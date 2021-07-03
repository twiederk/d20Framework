package com.d20charactersheet.framework.boc.model

class StarterPack {

    val starterPackBoxes: MutableList<StarterPackBox> = mutableListOf()

    fun add(starterPackBox: StarterPackBox) {
        starterPackBoxes.add(starterPackBox)
    }
}
