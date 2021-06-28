package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*

class CharacterCreatorServiceImpl : CharacterCreatorService {

    override fun rollAttributeWithStandardMethod(): Int {
        val rolls = listOf(Die.D6.roll(), Die.D6.roll(), Die.D6.roll(), Die.D6.roll())
        return rolls.sum() - (rolls.minOrNull() ?: 0)
    }

    override fun getEquipmentSelectionBoxes(characterClass: CharacterClass, itemService: ItemService): List<SelectionBox> {

        val chainMailOption = SelectionOption()
        chainMailOption.add(ItemGroup().apply { item = Armor().apply { name = "Chain mail" }; number = 1 })

        val leatherArmorOption = SelectionOption()
        leatherArmorOption.add(ItemGroup().apply { item = Armor().apply { name = "Leather" }; number = 1 })
        leatherArmorOption.add(ItemGroup().apply { item = Weapon().apply { name = "Longbow" }; number = 1 })
        leatherArmorOption.add(ItemGroup().apply { item = Weapon().apply { name = "Arrow" }; number = 20 })

        val armorSelectionBox = SelectionBox()
        armorSelectionBox.add(chainMailOption)
        armorSelectionBox.add(leatherArmorOption)


        val martialWeapons: List<Weapon> = itemService.filterWeaponsByType(WeaponType.MARTIAL)
        val martialWeaponsSelectionOptions: List<SelectionOption> = createSelectionOptions(martialWeapons)
        val primaryHandSelectionBox = SelectionBox()
        primaryHandSelectionBox.addAll(martialWeaponsSelectionOptions)



        return listOf(armorSelectionBox, primaryHandSelectionBox)
    }

    private fun createSelectionOptions(weapons: List<Weapon>): List<SelectionOption> {
        val itemGroups = weapons.map { ItemGroup().apply { item = it; number = 1 } }
        val selectionOptions = mutableListOf<SelectionOption>()
        for (itemGroup in itemGroups) {
            val selectionOption = SelectionOption()
            selectionOption.add(itemGroup)
            selectionOptions.add(selectionOption)
        }
        return selectionOptions
    }


}