package com.d20charactersheet.framework.boc.model

class StarterPack {

    val selectionBoxes: MutableList<SelectionBox> = mutableListOf()

    fun add(selectionBox: SelectionBox) {
        selectionBoxes.add(selectionBox)
    }
}
