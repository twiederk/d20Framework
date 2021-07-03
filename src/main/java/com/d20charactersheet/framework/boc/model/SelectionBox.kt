package com.d20charactersheet.framework.boc.model

class SelectionBox(
    val id: Int = 0,
    val name: String = ""
) {
    val options: MutableList<SelectionOption> = mutableListOf()

    fun add(selectionOption: SelectionOption) {
        options.add(selectionOption)
    }

    fun addAll(selectionOptions: List<SelectionOption>) {
        options.addAll(selectionOptions)
    }

}
