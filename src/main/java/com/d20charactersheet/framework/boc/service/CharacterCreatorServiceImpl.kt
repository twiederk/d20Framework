package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.Die
import com.d20charactersheet.framework.boc.model.SelectionBox
import com.d20charactersheet.framework.boc.model.SelectionOption

class CharacterCreatorServiceImpl : CharacterCreatorService {

    override fun rollAttributeWithStandardMethod(): Int {
        val rolls = listOf(Die.D6.roll(), Die.D6.roll(), Die.D6.roll(), Die.D6.roll())
        return rolls.sum() - (rolls.minOrNull() ?: 0)
    }

    override fun getEquipmentSelectionBoxes(characterClass: CharacterClass): List<SelectionBox> {
        val armorSelectionBox = SelectionBox()

        val chainMailOption = SelectionOption()
        armorSelectionBox.add(chainMailOption)

        return listOf(armorSelectionBox)
    }

}