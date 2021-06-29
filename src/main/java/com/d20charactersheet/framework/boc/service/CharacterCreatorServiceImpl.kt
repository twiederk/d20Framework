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
        allWeapons: List<Weapon>,
        allArmor: List<Armor>
    ): StarterPack {

        // Armor
        val chainMail = itemService.getItemById(1, allArmor)

        val leatherArmorOption = SelectionOption()
        val leatherArmor = itemService.getItemById(2, allArmor)
        val longBow = itemService.getItemById(1, allWeapons)
        val arrow = itemService.getItemById(2, allWeapons)

        leatherArmorOption.add(ItemGroup().apply { item = leatherArmor; number = 1 })
        leatherArmorOption.add(ItemGroup().apply { item = longBow; number = 1 })
        leatherArmorOption.add(ItemGroup().apply { item = arrow; number = 20 })

        val armorSelectionBox = SelectionBox("Armor")
        armorSelectionBox.add(createSelectionOption(chainMail))
        armorSelectionBox.add(leatherArmorOption)

        // Primary Hand
        val martialWeapons: List<Weapon> = itemService.filterWeaponsByType(WeaponType.MARTIAL)
        val martialWeaponsSelectionOptions: List<SelectionOption> = createSelectionOptions(martialWeapons)
        val primaryHandSelectionBox = SelectionBox("Primary Hand")
        primaryHandSelectionBox.addAll(martialWeaponsSelectionOptions)

        // Secondary Hand
        val secondaryHandSelectionBox = SelectionBox("Secondary Hand")
        secondaryHandSelectionBox.addAll(martialWeaponsSelectionOptions)
        val shield = itemService.getItemById(3, allArmor)
        secondaryHandSelectionBox.add(createSelectionOption(shield))

        // Starter Pack
        val starterPack = StarterPack()
        starterPack.add(armorSelectionBox)
        starterPack.add(primaryHandSelectionBox)
        starterPack.add(secondaryHandSelectionBox)

        return starterPack
    }

    private fun createSelectionOption(item: Item): SelectionOption {
        val selectionOption = SelectionOption()
        selectionOption.add(ItemGroup().apply { this.item = item; number = 1 })
        return selectionOption
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