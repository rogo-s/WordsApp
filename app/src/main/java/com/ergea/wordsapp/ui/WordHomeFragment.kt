package com.ergea.wordsapp.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ergea.wordsapp.R
import com.ergea.wordsapp.adapter.WordAdapter
import com.ergea.wordsapp.databinding.FragmentWordHomeBinding

class WordHomeFragment : Fragment() {

    private var _binding: FragmentWordHomeBinding? = null
    private val binding get() = _binding!!
    private var isListMode = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvHome.adapter = WordAdapter(('A').rangeTo('L').toList())
            rvHome.layoutManager = LinearLayoutManager(requireContext())
            rvHome.setHasFixedSize(true)
        }

        switchMode()

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.item_menu, menu)
                changeIcon(menu.findItem(R.id.switchMode))
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.switchMode -> {
                        isListMode = !isListMode
                        switchMode()
                        changeIcon(menuItem)

                        return true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

    }

    private fun changeIcon(menuItem: MenuItem?) {
        menuItem?.icon =
            if (isListMode)
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_mode)
            else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_list_mode)
    }

    private fun switchMode() {
        binding.rvHome.layoutManager =
            if (isListMode)
                LinearLayoutManager(requireContext())
            else
                GridLayoutManager(requireContext(), 2)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}