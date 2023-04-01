package com.ergea.wordsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ergea.wordsapp.adapter.DetailAdapter
import com.ergea.wordsapp.databinding.FragmentWordDetailBinding
import com.ergea.wordsapp.utils.DataDummy

class WordDetailFragment : Fragment() {

    private var _binding: FragmentWordDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val filter: List<String> =
            DataDummy.listData.filter { it.startsWith(arguments?.getString("EXTRA_WORD")!!, true) }
        binding.apply {
            rvDetail.adapter = DetailAdapter(filter)
            rvDetail.layoutManager = LinearLayoutManager(requireContext())
            rvDetail.setHasFixedSize(true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}