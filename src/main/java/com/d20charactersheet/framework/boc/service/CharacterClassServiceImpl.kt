package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*
import com.d20charactersheet.framework.dac.dao.ClassDao

/**
 * Creates CharacterClassService with given data access object.
 * Handles character class specific tasks.
 *
 * @param classDao
 * The data access object to the persistent layer.
 */
class CharacterClassServiceImpl(private val classDao: ClassDao) : CharacterClassService {

    /**
     * @see com.d20charactersheet.framework.boc.service.CharacterClassService.getAllCharacterClasses
     */
    override fun getAllCharacterClasses(allSkills: List<Skill>, allAbilities: List<Ability>): List<CharacterClass> {
        return classDao.getAllCharacterClasses(allSkills, allAbilities)
    }

    /**
     * @see com.d20charactersheet.framework.boc.service.CharacterClassService.deleteSkill
     */
    override fun deleteSkill(skill: Skill) {
        classDao.deleteSkill(skill)
    }

    /**
     * @see com.d20charactersheet.framework.boc.service.CharacterClassService.updateCharacterClass
     */
    override fun updateCharacterClass(characterClass: CharacterClass) {
        classDao.updateCharacterClass(characterClass)
    }

    /**
     * @see com.d20charactersheet.framework.boc.service.CharacterClassService.createCharacterClass
     */
    override fun createCharacterClass(characterClass: CharacterClass): CharacterClass {
        classDao.createCharacterClass(characterClass)
        return characterClass
    }

    /**
     * @see com.d20charactersheet.framework.boc.service.CharacterClassService.addSkill
     */
    override fun addSkill(skill: Skill, characterClasses: List<CharacterClass>) {
        classDao.addSkill(skill, characterClasses)
    }

    /**
     * @see com.d20charactersheet.framework.boc.service.CharacterClassService.findClassByName
     */
    override fun findClassByName(name: String, allClasses: List<CharacterClass>): CharacterClass {
        for (clazz in allClasses) {
            if (clazz.name == name) {
                return clazz
            }
        }
        throw IllegalArgumentException("Can't find class with name: $name")
    }

    override fun getStarterPack(
        characterClass: CharacterClass,
        itemService: ItemService,
        allWeapons: List<Weapon>,
        allArmor: List<Armor>
    ): StarterPack {

        // Armor
        val chainMail = itemService.getItemById(1, allArmor)

        val leatherArmorOption = ItemSelectionOption()
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

        // Range Weapon
        val crossbow = itemService.getItemById(3, allWeapons)
        val bolt = itemService.getItemById(4, allWeapons)
        val crossbowSelectionOption = ItemSelectionOption()
        val rangeWeaponSelectionBox = SelectionBox("Range Weapon")
        crossbowSelectionOption.add(ItemGroup().apply { item = crossbow; number = 1 })
        crossbowSelectionOption.add(ItemGroup().apply { item = bolt; number = 20 })

        val handaxe = itemService.getItemById(5, allWeapons)
        rangeWeaponSelectionBox.add(crossbowSelectionOption)
        rangeWeaponSelectionBox.add(createSelectionOption(handaxe, 2))

        // Equipment pack

        val dungeoneersPack = PackSelectionOption(EquipmentPack().apply { name = "Dungeoneer's Pack" })
        val explorerersPack = PackSelectionOption(EquipmentPack().apply { name = "Explorer's Pack" })

        val equipmentPackSelectionBox = SelectionBox("Equipment Pack")
        equipmentPackSelectionBox.add(dungeoneersPack)
        equipmentPackSelectionBox.add(explorerersPack)

        // Starter Pack
        val starterPack = StarterPack()
        starterPack.add(armorSelectionBox)
        starterPack.add(primaryHandSelectionBox)
        starterPack.add(secondaryHandSelectionBox)
        starterPack.add(rangeWeaponSelectionBox)
        starterPack.add(equipmentPackSelectionBox)

        characterClass.starterPack = starterPack

        return starterPack
    }

    private fun createSelectionOption(item: Item, number: Int = 1): SelectionOption {
        val selectionOption = ItemSelectionOption()
        selectionOption.add(ItemGroup().apply { this.item = item; this.number = number })
        return selectionOption
    }

    private fun createSelectionOptions(weapons: List<Weapon>): List<SelectionOption> {
        val itemGroups = weapons.map { ItemGroup().apply { item = it; number = 1 } }
        val selectionOptions = mutableListOf<SelectionOption>()
        for (itemGroup in itemGroups) {
            val selectionOption = ItemSelectionOption()
            selectionOption.add(itemGroup)
            selectionOptions.add(selectionOption)
        }
        return selectionOptions
    }

}