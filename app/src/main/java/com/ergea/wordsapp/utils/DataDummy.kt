package com.ergea.wordsapp.utils


object DataDummy {
    private val words = arrayOf(
        "AA",
        "AB",
        "AC",
        "BA",
        "BB",
        "BC",
        "CA",
        "CB",
        "CC",
        "DA",
        "DB",
        "DC",
        "EA",
        "EB",
        "EC",
        "FA",
        "FB",
        "FC",
        "GA",
        "GB",
        "GC",
        "HA",
        "HB",
        "HC",
        "IA",
        "IB",
        "IC",
        "JA",
        "JB",
        "JC",
        "KA",
        "KB",
        "KC",
        "LA",
        "LB",
        "LC",
    )

    val listData: ArrayList<String>
        get() {
            val list = arrayListOf<String>()
            for (position in words.indices) {
                list.add(words[position])
            }
            return list
        }


}