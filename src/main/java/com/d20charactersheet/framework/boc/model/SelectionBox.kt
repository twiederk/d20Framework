package com.d20charactersheet.framework.boc.model

class SelectionBox {

    val options: MutableList<SelectionOption> = mutableListOf()

    fun add(selectionOption: SelectionOption) {
        options.add(selectionOption)
    }

}
