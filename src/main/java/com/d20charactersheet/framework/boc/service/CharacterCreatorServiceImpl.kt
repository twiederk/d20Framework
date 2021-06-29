package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*

class CharacterCreatorServiceImpl : CharacterCreatorService {

    override fun rollAttributeWithStandardMethod(): Int {
        val rolls = listOf(Die.D6.roll(), Die.D6.roll(), Die.D6.roll(), Die.D6.roll())
        return rolls.sum() - (rolls.minOrNull() ?: 0)
    }

    override fun getStarterPack(
        characterClass: CharacterClass,
        itemService: ItemService,
        allArmor: List<Armor>
    ): StarterPack {

        val chainMailOption = SelectionOption()
        val chainMail = itemService.getItemById(1, allArmor)
        chainMailOption.add(ItemGroup().apply { item = chainMail; number = 1 })

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

        val starterPack = StarterPack()
        starterPack.add(armorSelectionBox)
        starterPack.add(primaryHandSelectionBox)

        return starterPack
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