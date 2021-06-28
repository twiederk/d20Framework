package com.d20charactersheet.framework.boc.model

class SelectionBox {

    private val options: MutableList<SelectionOption> = mutableListOf()

    fun add(selectionOption: SelectionOption) {
        options.add(selectionOption)
    }

}
