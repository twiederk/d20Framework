package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.DnDv35Universe
import com.d20charactersheet.framework.Universe
import com.d20charactersheet.framework.boc.model.*
import com.d20charactersheet.framework.boc.service.exportimport.ImportReport
import org.junit.Assert
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import java.io.File
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class ExportImportServiceTest {

    private lateinit var gameSystem: GameSystem
    private lateinit var exportImportService: ExportImportService

    @Before
    fun setUp() {
        val universe: Universe = DnDv35Universe()
        gameSystem = universe.gameSystem
        exportImportService = ExportImportServiceImpl()
        if (!EXPORT_DIR.exists()) {
            EXPORT_DIR.mkdir()
        }
    }

    @Test
    @Ignore
    @Throws(Exception::class)
    fun testExportCharacters() {
        val belvador = gameSystem.getCharacter(0)

        // test note
        val noteDate = SimpleDateFormat("yyyyMMdd HH:mm").parse("20130413 15:30")
        val noteText = "My test note!"
        val notes: MutableList<Note> = ArrayList()
        val note = Note()
        note.date = noteDate
        note.text = noteText
        notes.add(note)
        belvador.notes = notes

        // test armor
        val itemGroup = ItemGroup()
        itemGroup.item = gameSystem.allArmor[0]
        itemGroup.number = 2
        belvador.equipment.armor.add(itemGroup)
        val characters: MutableList<Character> = LinkedList()
        characters.add(belvador)
        val exportFile = exportImportService.exportCharacters(gameSystem, EXPORT_CHARACTERS_FILE, characters)
        Assert.assertNotNull("Missing export file of characters", exportFile)
        belvador.notes.clear()
        belvador.equipment.armor.clear()
    }

    @Test
    @Ignore
    @Throws(Exception::class)
    fun testImportCharactersV1() {
        val importReports = exportImportService.importCharacters(gameSystem, IMPORT_CHARACTER_V1_FILE)
        Assert.assertNotNull(importReports)
        Assert.assertEquals(1, importReports.size.toLong())
        val belvador = importReports[0].importObject
        assertAppearance(belvador)
        assertAttributes(belvador)
        assertCombat(belvador)
        assertSaves(belvador)
        assertMoney(belvador)
        assertNotes(belvador)
        assertAttacks(belvador)
        assertSkills(belvador)
        assertFeats(belvador)
        assertKnownSpells(belvador)
        assertWeapons(belvador)
        assertArmor(belvador)
        assertGoods(belvador)
    }

    @Test
    @Ignore
    @Throws(Exception::class)
    fun testImportCharactersV2() {
        val importReports = exportImportService.importCharacters(gameSystem, IMPORT_CHARACTER_V2_FILE)
        Assert.assertNotNull(importReports)
        Assert.assertEquals(1, importReports.size.toLong())
        val importReport = importReports[0]
        Assert.assertTrue(importReport.importMessages.toString(), importReport.isSuccess)
        Assert.assertEquals(importReport.importMessages.toString(), 0, importReport.importMessages.size.toLong())
        val belvador = importReport.importObject
        assertAppearance(belvador)
        assertAttributes(belvador)
        assertCombat(belvador)
        assertSaves(belvador)
        assertMoney(belvador)
        assertNotes(belvador)
        assertAttacks(belvador)
        assertSkills(belvador)
        assertFeats(belvador)
        assertKnownSpells(belvador)
        assertSpellSlots(belvador)
        assertWeapons(belvador)
        assertArmor(belvador)
        assertGoods(belvador)
    }

    private fun assertAppearance(belvador: Character) {
        Assert.assertEquals("Belvador the Summoner", belvador.name)
        Assert.assertEquals("Torsten", belvador.player)
        Assert.assertEquals(2, belvador.race.id.toLong())
        Assert.assertEquals(Sex.MALE, belvador.sex)
        val classLevels = belvador.classLevels
        Assert.assertNotNull(classLevels)
        Assert.assertEquals(1, classLevels.size.toLong())
        val classLevel = classLevels[0]
        Assert.assertEquals(10, classLevel.characterClass.id.toLong())
        Assert.assertEquals(5, classLevel.level.toLong())
        val characterAbilities = classLevel.characterAbilities
        Assert.assertNotNull(characterAbilities)
        Assert.assertEquals(16, characterAbilities.size.toLong())
        Assert.assertEquals(8, getNumberOfOwnedCharacterAbilities(characterAbilities))
        Assert.assertEquals(Alignment.CHAOTIC_GOOD, belvador.alignment)
        Assert.assertEquals(13129, belvador.experiencePoints.toLong())
        Assert.assertEquals(1, belvador.xpTable.id.toLong())
    }

    private fun getNumberOfOwnedCharacterAbilities(characterAbilities: List<CharacterAbility>): Any {
        var numberOfOwnedCharacterAbilities = 0
        for (characterAbility in characterAbilities) {
            if (characterAbility.isOwned) {
                numberOfOwnedCharacterAbilities++
            }
        }
        return numberOfOwnedCharacterAbilities
    }

    private fun assertAttributes(belvador: Character) {
        Assert.assertEquals(11, belvador.strength.toLong())
        Assert.assertEquals(18, belvador.dexterity.toLong())
        Assert.assertEquals(17, belvador.constitution.toLong())
        Assert.assertEquals(18, belvador.intelligence.toLong())
        Assert.assertEquals(11, belvador.wisdom.toLong())
        Assert.assertEquals(15, belvador.charisma.toLong())
    }

    private fun assertCombat(belvador: Character) {
        Assert.assertEquals(26, belvador.hitPoints.toLong())
        Assert.assertEquals(26, belvador.maxHitPoints.toLong())
        Assert.assertEquals(0, belvador.armorClass.toLong())
        Assert.assertEquals(0, belvador.initiativeModifier.toLong())
        Assert.assertEquals(0, belvador.cmbModifier.toLong())
        Assert.assertEquals(0, belvador.cmdModifier.toLong())
    }

    private fun assertSaves(belvador: Character) {
        Assert.assertEquals(0, belvador.fortitudeModifier.toLong())
        Assert.assertEquals(0, belvador.reflexModifier.toLong())
        Assert.assertEquals(0, belvador.willModifier.toLong())
    }

    private fun assertMoney(belvador: Character) {
        Assert.assertEquals(1, belvador.money.platinum.toLong())
        Assert.assertEquals(2, belvador.money.gold.toLong())
        Assert.assertEquals(3, belvador.money.silver.toLong())
        Assert.assertEquals(4, belvador.money.copper.toLong())
    }

    private fun assertNotes(belvador: Character) {
        val notes = belvador.notes
        Assert.assertNotNull(notes)
        Assert.assertEquals(1, notes.size.toLong())
        val note = notes[0]
        try {
            val noteDate = SimpleDateFormat("yyyyMMdd HH:mm").parse("20130413 15:30")
            Assert.assertEquals(noteDate, note.date)
            Assert.assertEquals("My test note!", note.text)
        } catch (parseException: ParseException) {
            parseException.printStackTrace()
            Assert.fail("Can't create noteDate")
        }
    }

    private fun assertAttacks(belvador: Character) {
        val weaponAttacks = belvador.weaponAttacks
        Assert.assertNotNull(weaponAttacks)
        Assert.assertEquals(3, weaponAttacks.size.toLong())
        val weaponAttack = weaponAttacks[0]
        Assert.assertEquals("Quarterstaff", weaponAttack.name)
        Assert.assertEquals("My good old quarterstaff", weaponAttack.description)
        Assert.assertEquals(AttackWield.TWO_HANDED, weaponAttack.attackWield)
        Assert.assertEquals(11, weaponAttack.weapon.id.toLong())
        Assert.assertEquals("Quarterstaff", weaponAttack.weapon.name)
        Assert.assertEquals(0, weaponAttack.attackBonusModifier.toLong())
        Assert.assertEquals(0, weaponAttack.damageBonusModifier.toLong())
    }

    private fun assertSkills(belvador: Character) {
        val characterSkills = belvador.characterSkills
        Assert.assertNotNull(characterSkills)
        Assert.assertEquals(10, characterSkills.size.toLong())
        val concentration = characterSkills[0]
        Assert.assertEquals("Concentration", concentration.skill.name)
        Assert.assertEquals(8.0f, concentration.rank, 0.0f)
        Assert.assertEquals(0, concentration.modifier.toLong())
    }

    private fun assertFeats(belvador: Character) {
        val characterFeats = belvador.characterFeats
        Assert.assertNotNull(characterFeats)
        Assert.assertEquals(3, characterFeats.size.toLong())
        val characterFeat = characterFeats[2]
        Assert.assertEquals("Spell Focus", characterFeat.feat.name)
        Assert.assertEquals("Summoning", characterFeat.category)
    }

    private fun assertKnownSpells(belvador: Character) {
        val spelllistAbility = belvador.spelllistAbilities[0]
        val knownSpells = belvador.getKnownSpells(spelllistAbility.spelllist)
        Assert.assertNotNull(knownSpells)
        Assert.assertEquals(31, knownSpells.size.toLong())
        val knownSpell = knownSpells[0]
        Assert.assertNotNull("Spell can't be null", knownSpell.spell)
        Assert.assertEquals("Arcane Mark", knownSpell.spell.name)
        Assert.assertNotNull("Spelllist can't be null", knownSpell.spelllist)
        Assert.assertEquals("Wizard", knownSpell.spelllist.name)
    }

    private fun assertSpellSlots(belvador: Character) {
        val spellSlots = belvador.spellSlots
        Assert.assertNotNull(spellSlots)
        Assert.assertEquals(17, spellSlots.size.toLong())

        // <spellslot><spell>Detect
        // Magic</spell><level>0</level><cast>false</cast><spelllistabilities><spellistability>Spells -
        // Wizard</spellistability></spelllistabilities><metamagicfeats/></spellslot>
        var spellSlot = spellSlots[0]
        Assert.assertNotNull(spellSlot.spell)
        Assert.assertEquals("Detect Magic", spellSlot.spell.name)
        Assert.assertEquals(0, spellSlot.level.toLong())
        Assert.assertFalse(spellSlot.isCast)
        var spelllistAbilities = spellSlot.spelllistAbilities
        Assert.assertNotNull(spelllistAbilities)
        Assert.assertEquals(1, spelllistAbilities.size.toLong())
        Assert.assertEquals("Spells - Wizard", spelllistAbilities[0].name)
        Assert.assertNotNull(spellSlot.metamagicFeats)
        Assert.assertEquals(0, spellSlot.metamagicFeats.size.toLong())

        // <spellslot><spell>Summon Monster
        // II</spell><level>3</level><cast>false</cast><spelllistabilities><spellistability>Spells -
        // Wizard</spellistability></spelllistabilities><metamagicfeats><metamagicfeat>Extend
        // Spell</metamagicfeat></metamagicfeats></spellslot>
        spellSlot = spellSlots[12]
        Assert.assertNotNull(spellSlot.spell)
        Assert.assertEquals("Summon Monster II", spellSlot.spell.name)
        Assert.assertEquals(3, spellSlot.level.toLong())
        Assert.assertFalse(spellSlot.isCast)
        spelllistAbilities = spellSlot.spelllistAbilities
        Assert.assertNotNull(spelllistAbilities)
        Assert.assertEquals(1, spelllistAbilities.size.toLong())
        Assert.assertEquals("Spells - Wizard", spelllistAbilities[0].name)
        val metamagicFeats = spellSlot.metamagicFeats
        Assert.assertNotNull(metamagicFeats)
        Assert.assertEquals(1, metamagicFeats.size.toLong())
        Assert.assertEquals("Extend Spell", metamagicFeats[0].name)
    }

    private fun assertWeapons(belvador: Character) {
        val weapons = belvador.equipment.weapons
        Assert.assertNotNull(weapons)
        Assert.assertEquals(3, weapons.size.toLong())
        val quarterstaff = weapons[0]
        Assert.assertEquals("Quarterstaff", quarterstaff.item.name)
        Assert.assertEquals(1, quarterstaff.number.toLong())
    }

    private fun assertArmor(belvador: Character) {
        val armor = belvador.equipment.armor
        Assert.assertNotNull(armor)
        Assert.assertEquals(1, armor.size.toLong())
        val padded = armor[0]
        Assert.assertEquals("Padded", padded.item.name)
        Assert.assertEquals(2, padded.number.toLong())
    }

    private fun assertGoods(belvador: Character) {
        val goods = belvador.equipment.goods
        Assert.assertNotNull(goods)
        Assert.assertEquals(19, goods.size.toLong())
        val padded = goods[0]
        Assert.assertEquals("Backpack", padded.item.name)
        Assert.assertEquals(1, padded.number.toLong())
    }

    @Test
    @Ignore
    fun testExportEquipment() {
        val weapons = gameSystem.allWeapons
        val armor = gameSystem.allArmor
        val goods = gameSystem.allGoods
        val exportFile = exportImportService.exportEquipment(gameSystem, EXPORT_EQUIPMENT_FILE, weapons, armor, goods)
        Assert.assertNotNull("Missing export file of weapons", exportFile)
    }

    @Test
    @Ignore
    fun testImportEquipment() {
        val importReports = exportImportService.importEquipment(gameSystem, IMPORT_EQUIPMENT_V1_FILE)
        Assert.assertNotNull("Import reports can't be null", importReports)
        Assert.assertEquals(279, importReports?.size)
        val dagger = getItemByName("Dagger", importReports) as Weapon
        val weaponFamily = weaponFamilyByName()
        assertWeapon(Damage(1, Die.D4), Critical(19, 2), weaponFamily, dagger)
        val scaleMail = getItemByName("Scale Mail", importReports) as Armor
        assertArmor(scaleMail)
        val winterBlanket = getItemByName("Winter Blanket", importReports) as Good
        assertGood(winterBlanket)
    }

    private fun weaponFamilyByName(): WeaponFamily {
        for (weaponFamily in gameSystem.allWeaponFamilies) {
            if (weaponFamily.name == "Dagger") {
                return weaponFamily
            }
        }
        throw IllegalArgumentException("Can't find weapon family with name: " + "Dagger")
    }

    private fun assertWeapon(damage: Damage, critical: Critical, weaponFamily: WeaponFamily, weapon: Weapon) {
        assertItem(
            "Dagger", 2.0.toFloat(), 1.0.toFloat(),
            "You get a +2 bonus on Sleight of Hand checks made to conceal a dagger on your body (see the Sleight of Hand skill)",
            weapon
        )
        Assert.assertEquals(WeaponType.SIMPLE, weapon.weaponType)
        Assert.assertEquals(damage, weapon.damage)
        Assert.assertEquals(critical, weapon.critical)
        Assert.assertEquals(CombatType.MELEE_WEAPON, weapon.combatType)
        Assert.assertEquals(WeaponEncumbrance.LIGHT_HANDED, weapon.weaponEncumbrance)
        Assert.assertEquals(WeaponCategory.NORMAL_WEAPON, weapon.weaponCategory)
        Assert.assertEquals(0, weapon.enhancementBonus.toLong())
        Assert.assertEquals(weaponFamily, weapon.weaponFamily)
        Assert.assertEquals(10, weapon.rangeIncrement.toLong())
    }

    private fun assertArmor(armor: Armor) {
        assertItem("Scale Mail", 50.0.toFloat(), 30.0.toFloat(), "The suit includes gauntlets.", armor)
        Assert.assertEquals(ArmorType.MEDIUM, armor.armorType)
        Assert.assertEquals(4, armor.armorBonus.toLong())
        Assert.assertEquals(-4, armor.armorCheckPenalty.toLong())
    }

    private fun assertGood(good: Good) {
        assertItem(
            "Winter Blanket", 0.5.toFloat(), 3.0.toFloat(), "A thick, quilted, wool blanket made to keep you warm in cold weather.",
            good
        )
        Assert.assertEquals(GoodType.ADVENTURING_GEAR, good.goodType)
    }

    private fun assertItem(name: String, cost: Float, weight: Float, description: String, item: Item) {
        Assert.assertEquals(name, item.name)
        Assert.assertEquals(cost, item.cost, 0.0f)
        Assert.assertEquals(weight, item.weight, 0.0f)
        Assert.assertEquals(QualityType.NORMAL, item.qualityType)
        Assert.assertEquals(description, item.description)
    }

    private fun getItemByName(name: String, importReports: List<ImportReport<out Item>>): Item {
        for (importReport in importReports) {
            val item = importReport.importObject
            if (item.name == name) {
                return item
            }
        }
        throw IllegalArgumentException("Can't find item with name: $name")
    }

    companion object {
        val EXPORT_DIR = File("target/xml")
        val EXPORT_CHARACTERS_FILE = File(EXPORT_DIR, "d20cs_characters_unit_test.xml")
        val EXPORT_EQUIPMENT_FILE = File(EXPORT_DIR, "d20cs_equipment_unit_test.xml")
        private val IMPORT_DIR = File("src/test/resources/exportimport")
        val IMPORT_CHARACTER_V1_FILE = File(IMPORT_DIR, "d20cs_characters_v1_unit_test.xml")
        val IMPORT_CHARACTER_V2_FILE = File(IMPORT_DIR, "d20cs_characters_v2_unit_test.xml")
        val IMPORT_EQUIPMENT_V1_FILE = File(IMPORT_DIR, "d20cs_equipment_v1_unit_test.xml")
    }
}