package com.d20charactersheet.framework.boc.model

class StarterPackBox(
    val id: Int = 0,
    val name: String = ""
) {
    val options: MutableList<StarterPackBoxOption> = mutableListOf()

    fun add(starterPackBoxOption: StarterPackBoxOption) {
        options.add(starterPackBoxOption)
    }

    fun addAll(starterPackBoxOptions: List<StarterPackBoxOption>) {
        options.addAll(starterPackBoxOptions)
    }

}
