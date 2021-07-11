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
        allArmor: List<Armor>,
        allGoods: List<Good>,
        allPacks: List<EquipmentPack>
    ): StarterPack {

        val starterPackBoxesWithQueries = classDao.getStarterPackBoxesWithQueries(characterClass.id)

        val starterPack = StarterPack()
        for (starterPackBox in starterPackBoxesWithQueries.keys) {
            val starterBoxOptions = StarterPackHelper(itemService, allWeapons, allArmor, allGoods, allPacks)
                .getStarterBoxOptions(starterPackBoxesWithQueries.getOrDefault(starterPackBox, listOf()))
            starterPackBox.addAll(starterBoxOptions)
            starterPack.add(starterPackBox)
        }

        characterClass.starterPack = starterPack

        return starterPack

        /*
        // Armor
        val chainMail = itemService.getItemById(1, allArmor)

        val leatherArmorOption = StarterPackBoxItemOption()
        val leatherArmor = itemService.getItemById(2, allArmor)
        val longBow = itemService.getItemById(1, allWeapons)
        val arrow = itemService.getItemById(2, allWeapons)

        leatherArmorOption.add(ItemGroup().apply { item = leatherArmor; number = 1 })
        leatherArmorOption.add(ItemGroup().apply { item = longBow; number = 1 })
        leatherArmorOption.add(ItemGroup().apply { item = arrow; number = 20 })

        val armorSelectionBox = StarterPackBox(name = "Armor")
        armorSelectionBox.add(createSelectionOption(chainMail))
        armorSelectionBox.add(leatherArmorOption)

        // Primary Hand
        val martialWeapons: List<Weapon> = itemService.filterWeaponsByType(WeaponType.MARTIAL)
        val martialWeaponsStarterPackBoxOptions: List<StarterPackBoxOption> = createSelectionOptions(martialWeapons)
        val primaryHandSelectionBox = StarterPackBox(name = "Primary Hand")
        primaryHandSelectionBox.addAll(martialWeaponsStarterPackBoxOptions)

        // Secondary Hand
        val secondaryHandSelectionBox = StarterPackBox(name = "Secondary Hand")
        secondaryHandSelectionBox.addAll(martialWeaponsStarterPackBoxOptions)
        val shield = itemService.getItemById(3, allArmor)
        secondaryHandSelectionBox.add(createSelectionOption(shield))

        // Range Weapon
        val crossbow = itemService.getItemById(3, allWeapons)
        val bolt = itemService.getItemById(4, allWeapons)
        val crossbowSelectionOption = StarterPackBoxItemOption()
        val rangeWeaponSelectionBox = StarterPackBox(name = "Range Weapon")
        crossbowSelectionOption.add(ItemGroup().apply { item = crossbow; number = 1 })
        crossbowSelectionOption.add(ItemGroup().apply { item = bolt; number = 20 })

        val handaxe = itemService.getItemById(5, allWeapons)
        rangeWeaponSelectionBox.add(crossbowSelectionOption)
        rangeWeaponSelectionBox.add(createSelectionOption(handaxe, 2))

        // Equipment pack

        val dungeoneersPack = StarterPackBoxPackOption(EquipmentPack().apply { name = "Dungeoneer's Pack" })
        val explorerersPack = StarterPackBoxPackOption(EquipmentPack().apply { name = "Explorer's Pack" })

        val equipmentPackSelectionBox = StarterPackBox(name = "Equipment Pack")
        equipmentPackSelectionBox.add(dungeoneersPack)
        equipmentPackSelectionBox.add(explorerersPack)
        */


    }

    private fun createSelectionOption(item: Item, number: Int = 1): StarterPackBoxOption {
        val selectionOption = StarterPackBoxItemOption()
        selectionOption.add(ItemGroup().apply { this.item = item; this.number = number })
        return selectionOption
    }

    private fun createSelectionOptions(weapons: List<Weapon>): List<StarterPackBoxOption> {
        val itemGroups = weapons.map { ItemGroup().apply { item = it; number = 1 } }
        val selectionOptions = mutableListOf<StarterPackBoxOption>()
        for (itemGroup in itemGroups) {
            val selectionOption = StarterPackBoxItemOption()
            selectionOption.add(itemGroup)
            selectionOptions.add(selectionOption)
        }
        return selectionOptions
    }

}