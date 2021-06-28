package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.SelectionBox

interface CharacterCreatorService {

    fun rollAttributeWithStandardMethod(): Int

    fun getEquipmentSelectionBoxes(characterClass: CharacterClass): List<SelectionBox>

}
