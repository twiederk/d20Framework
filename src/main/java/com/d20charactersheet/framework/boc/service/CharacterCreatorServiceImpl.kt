package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*

class CharacterCreatorServiceImpl : CharacterCreatorService {

    override fun rollAttributeWithStandardMethod(): Int {
        val rolls = listOf(Die.D6.roll(), Die.D6.roll(), Die.D6.roll(), Die.D6.roll())
        return rolls.sum() - (rolls.minOrNull() ?: 0)
    }

    override fun getEquipmentSelectionBoxes(characterClass: CharacterClass): List<SelectionBox> {

        val chainMailOption = SelectionOption()
        chainMailOption.add(ItemGroup().apply { item = Armor().apply { name = "Chain mail" }; number = 1 })

        val leatherArmorOption = SelectionOption()
        leatherArmorOption.add(ItemGroup().apply { item = Armor().apply { name = "Leather" }; number = 1 })
        leatherArmorOption.add(ItemGroup().apply { item = Weapon().apply { name = "Longbow" }; number = 1 })
        leatherArmorOption.add(ItemGroup().apply { item = Weapon().apply { name = "Arrow" }; number = 20 })

        val armorSelectionBox = SelectionBox()
        armorSelectionBox.add(chainMailOption)
        armorSelectionBox.add(leatherArmorOption)

        return listOf(armorSelectionBox)
    }



}