package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

abstract class BaseSpelllistDaoTest {

    protected lateinit var spelllistDao: SpelllistDao

    @Test
    fun testGetAllSpells() {

        // Act
        val allSpells = spelllistDao.getAllSpells()

        // Assert
        assertThat(allSpells).hasSize(606)
        val acidArrow = getSpellById(SPELL_ID_ACID_ARROW, allSpells)
        val description = spelllistDao.getSpellDescription(acidArrow.id)
        acidArrow.description = description
        assertSpell(acidArrow)
    }

    private fun getSpellById(spellId: Int, allSpells: List<Spell>): Spell {
        for (spell in allSpells) {
            if (spell.id == spellId) {
                return spell
            }
        }
        throw IllegalArgumentException("Can't get spell with id: $spellId")
    }

    private fun assertSpell(spell: Spell) {
        // id, name, school, components, castingTime, range, effect, duration, savingThrow, spellresistance,
        // description, materialComponent, focus
        assertThat(spell.name).isEqualTo("Acid Arrow")
        assertThat(spell.school).isEqualTo(School.CONJURATION)
        assertThat(spell.subSchool).isEqualTo(SubSchool.CREATION)
        assertThat(spell.descriptors).hasSize(1)
        assertThat(spell.descriptors[0]).isEqualTo(Descriptor.ACID)
        assertThat(spell.isVerbal).isTrue
        assertThat(spell.isSomatic).isTrue
        assertThat(spell.isMaterial).isTrue
        assertThat(spell.isFocus).isTrue
        assertThat(spell.isDivineFocus).isFalse
        assertThat(spell.isXpCost).isFalse
        assertThat(spell.castingTime).isEqualTo(CastingTime.ONE_STANDARD_ACTION)
        assertThat(spell.range).isEqualTo("Long (400 ft. + 40 ft./level)")
        assertThat(spell.effect).isEqualTo("One arrow of acid")
        assertThat(spell.duration).isEqualTo("1 round + 1 round per three levels")
        assertThat(spell.spellResistance).isEqualTo(SpellResistance.NO)
        assertThat(spell.shortDescription).isEqualTo("Ranged touch attack, 2d4 damage for 1 round +1 round/three levels.")
        assertThat(spell.description).isEqualTo(
                "A magical arrow of acid springs from your hand and speeds to its target. You must succeed on a ranged touch attack to hit your target. The arrow deals 2d4 points of acid damage with no splash damage. For every three caster levels (to a maximum of 18th), the acid, unless somehow neutralized, lasts for another round, dealing another 2d4 points of damage in that round.")
        assertThat(spell.materialComponent).isEqualTo("Powdered rhubarb leaf and an adder's stomach.")
        assertThat(spell.focus).isEqualTo("A dart.")
    }

    @Test
    fun testGetAllSpelllists() {
        // Arrange
        val allSpells = spelllistDao.getAllSpells()

        // Act
        val allSpelllists = spelllistDao.getAllSpelllists(allSpells)

        // Assert
        assertThat(allSpelllists).hasSize(31)
        val clericSpelllist = getSpelllistById(allSpelllists)
        assertSpelllist(clericSpelllist)
    }

    private fun getSpelllistById(allSpelllists: List<Spelllist>): Spelllist {
        for (spelllist in allSpelllists) {
            if (spelllist.id == SPELLLIST_ID_CLERIC) {
                return spelllist
            }
        }
        throw IllegalArgumentException("Can't find spelllist with id: $SPELLLIST_ID_CLERIC")
    }

    private fun assertSpelllist(spelllist: Spelllist) {
        assertThat(spelllist.name).isEqualTo("Cleric")
        assertThat(spelllist.shortname).isEqualTo("Clr")
        assertThat(spelllist.isDomain).isFalse
        assertThat(spelllist.minLevel).isEqualTo(0)
        assertThat(spelllist.maxLevel).isEqualTo(9)
        assertThat(spelllist.numberOfSpellLevels).isEqualTo(10)
        assertThat(spelllist.getSpellsOfLevel(0)).hasSize(12)
        assertThat(spelllist.getSpellsOfLevel(1)).hasSize(31)
        assertThat(spelllist.getSpellsOfLevel(2)).hasSize(32)
        assertThat(spelllist.getSpellsOfLevel(3)).hasSize(34)
        assertThat(spelllist.getSpellsOfLevel(4)).hasSize(23)
        assertThat(spelllist.getSpellsOfLevel(5)).hasSize(27)
        assertThat(spelllist.getSpellsOfLevel(6)).hasSize(26)
        assertThat(spelllist.getSpellsOfLevel(7)).hasSize(18)
        assertThat(spelllist.getSpellsOfLevel(8)).hasSize(17)
        assertThat(spelllist.getSpellsOfLevel(9)).hasSize(11)
        assertThat(spelllist.allSpells).hasSize(231)
    }

    @Test
    fun testCreateAndDeleteSpell() {
        // Arrange
        var spell = Spell()
        spell.name = "testName"
        spell.school = School.CONJURATION
        spell.subSchool = SubSchool.CALLING
        spell.descriptors = arrayOf(Descriptor.ACID)
        spell.isVerbal = true
        spell.isSomatic = true
        spell.isMaterial = true
        spell.isFocus = true
        spell.castingTime = CastingTime.ONE_STANDARD_ACTION
        spell.range = "Long (400 ft. + 40 ft./level)"
        spell.effect = "one arrow of acid"
        spell.duration = "1 round + 1 round per three levels"
        spell.savingThrow = "none"
        spell.spellResistance = SpellResistance.NO
        spell.description = "An arrow of acid springs from your hand and speeds to its target. You must succeed on a ranged touch attack to hit your target. The arrow deals 2d4 points of acid damage with no splash damage. For every three caster levels you possess, the acid, unless neutralized, lasts for another round (to a maximum of 6 additional rounds at 18th level), dealing another 2d4 points of damage in each round."
        spell.materialComponent = "Powdered rhubarb leaf and an adder's stomach."
        spell.focus = "A dart."
        spell.shortDescription = "Ranged touch attack, 2d4 damage for 1 round +1 round/three levels."

        // Act
        spell = spelllistDao.createSpell(spell)

        // Assert
        assertThat(spell).isNotNull
        assertThat(spell.id).isGreaterThan(0)
        val allSpells = spelllistDao.getAllSpells()
        assertThat(allSpells).hasSize(607)
        val newSpell = getSpellById(spell.id, allSpells)
        val description = spelllistDao.getSpellDescription(newSpell.id)
        newSpell.description = description
        assertThat(newSpell.name).isEqualTo("testName")
        assertThat(newSpell.school).isEqualTo(School.CONJURATION)
        assertThat(newSpell.subSchool).isEqualTo(SubSchool.CALLING)
        val descriptors = arrayOf(Descriptor.ACID)
        assertThat(descriptors).hasSize(1)
        assertThat(descriptors[0]).isEqualTo(Descriptor.ACID)
        assertThat(newSpell.isVerbal).isTrue
        assertThat(newSpell.isSomatic).isTrue
        assertThat(newSpell.isMaterial).isTrue
        assertThat(newSpell.isFocus).isTrue
        assertThat(newSpell.castingTime).isEqualTo(CastingTime.ONE_STANDARD_ACTION)
        assertThat(newSpell.range).isEqualTo("Long (400 ft. + 40 ft./level)")
        assertThat(newSpell.effect).isEqualTo("one arrow of acid")
        assertThat(newSpell.duration).isEqualTo("1 round + 1 round per three levels")
        assertThat(newSpell.savingThrow).isEqualTo("none")
        assertThat(newSpell.spellResistance).isEqualTo(SpellResistance.NO)
        assertThat(newSpell.description).startsWith("An arrow of acid springs from your hand and speeds to its target.")
        assertThat(newSpell.materialComponent).isEqualTo("Powdered rhubarb leaf and an adder's stomach.")
        assertThat(newSpell.focus).isEqualTo("A dart.")
        assertThat(newSpell.shortDescription).isEqualTo("Ranged touch attack, 2d4 damage for 1 round +1 round/three levels.")

        // tear down
        spelllistDao.deleteSpell(newSpell)
    }

    @Test
    fun testGetAllKnownSpellsTables() {
        // Act
        val allKnownSpellsTables = spelllistDao.getAllKnownSpellsTables()

        // Assert
        assertThat(allKnownSpellsTables).hasSize(4)
    }

    @Test
    fun testGetAllKnownSpellsTables_checkBardKnownSpells() {
        // Arrange
        val allKnownSpellsTables = spelllistDao.getAllKnownSpellsTables()

        // Act
        val knownSpellsTable = allKnownSpellsTables[0]

        // Assert
        // Check Bard known spells
        // Lev. 0 1 2 3 4 5 6 7 8 9
        // 16th 6 5 4 4 4 4 2 - - -
        assertKnownSpellsTable(knownSpellsTable, "Bard", 16, intArrayOf(6, 5, 4, 4, 4, 4, 2, KnownSpellsTable.NO_ACCESS, KnownSpellsTable.NO_ACCESS,
                KnownSpellsTable.NO_ACCESS
        ))
    }

    @Test
    fun testGetAllKnownSpellsTables_checkSorcererKnownSpells() {
        // Arrange
        val allKnownSpellsTables = spelllistDao.getAllKnownSpellsTables()

        // Act
        val knownSpellsTable = allKnownSpellsTables[1]

        // Assert
        // Check Sorcerer known spells
        // Lev. 0 1 2 3 4 5 6 7 8 9
        // 18th 9 5 5 4 4 4 3 3 2 1
        assertKnownSpellsTable(knownSpellsTable, "Sorcerer", 18, intArrayOf(9, 5, 5, 4, 4, 4, 3, 3, 2, 1))
    }

    @Test
    fun testGetAllKnownSpellsTables_checkUnlimitedKnownSpells() {
        // Arrange
        val allKnownSpellsTables = spelllistDao.getAllKnownSpellsTables()

        // Act
        val knownSpellsTable = allKnownSpellsTables[2]

        // Assert
        // Check Unlimited known spells
        // 1st 10 10 10 10 10 10 10 10 10 10
        assertKnownSpellsTable(knownSpellsTable, "Unlimited", 18, intArrayOf(KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED,
                KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED,
                KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED,
                KnownSpellsTable.UNLIMITED))
    }

    private fun assertKnownSpellsTable(knownSpellsTable: KnownSpellsTable, name: String, spellcasterLevel: Int,
                                       knownSpells: IntArray) {
        assertThat(knownSpellsTable.name).isEqualTo(name)
        for (i in knownSpells.indices) {
            assertThat(knownSpellsTable.getKnownSpells(spellcasterLevel, i)).isEqualTo(knownSpells[i])
        }
    }

    @Test
    fun testGetAllSpellsPerDayTables() {

        // Act
        val allSpellsPerDayTables = spelllistDao.getAllSpellsPerDayTables()

        // Assert
        assertThat(allSpellsPerDayTables).hasSize(8)
    }

    @Test
    fun testGetAllSpellsPerDayTables_checkBardSpellsPerDay() {
        // Arrange
        val allSpellsPerDayTables = spelllistDao.getAllSpellsPerDayTables()

        // Act
        val spellsPerDayTable = allSpellsPerDayTables[0]

        // Assert
        // Check Bard spells per day
        // Lev. 0 1 2 3 4 5 6 7 8 9
        // 16th 6 5 4 4 4 4 2 - - -
        assertSpellsPerDayTable(spellsPerDayTable, "Bard", 16, intArrayOf(4, 4, 4, 3, 3, 2, 0, SpellsPerDayTable.NO_ACCESS, SpellsPerDayTable.NO_ACCESS,
                SpellsPerDayTable.NO_ACCESS
        ))
    }

    @Test
    fun testGetAllSpellsPerDayTables_checkRangerSpellsPerDay() {
        // Arrange
        val allSpellsPerDayTables = spelllistDao.getAllSpellsPerDayTables()

        // Act
        val spellsPerDayTable = allSpellsPerDayTables[1]

        // Assert
        // Check Ranger spells per day
        // Lev. 0 1 2 3 4 5 6 7 8 9
        // 14th - 2 1 1 0 - - - - -
        assertSpellsPerDayTable(spellsPerDayTable, "Ranger", 14, intArrayOf(SpellsPerDayTable.NO_ACCESS, 2, 1, 1, 0, SpellsPerDayTable.NO_ACCESS,
                SpellsPerDayTable.NO_ACCESS, SpellsPerDayTable.NO_ACCESS, SpellsPerDayTable.NO_ACCESS,
                SpellsPerDayTable.NO_ACCESS
        ))
    }

    @Test
    fun testGetAllSpellsPerDayTables_checkSorcererSpellsPerDay() {
        // Arrange
        val allSpellsPerDayTables = spelllistDao.getAllSpellsPerDayTables()

        // Act
        val spellsPerDayTable = allSpellsPerDayTables[2]

        // Assert
        // Check Sorcerer spells per day
        // Lev. 0 1 2 3 4 5 6 7 8 9
        // 18th 6 6 6 6 6 6 6 6 5 3
        assertSpellsPerDayTable(spellsPerDayTable, "Sorcerer", 18, intArrayOf(6, 6, 6, 6, 6, 6, 6, 6, 5, 3))
    }

    @Test
    fun testGetAllSpellsPerDayTables_checkWizardSpellsPerDay() {
        // Arrange
        val allSpellsPerDayTables = spelllistDao.getAllSpellsPerDayTables()

        // Act
        val spellsPerDayTable = allSpellsPerDayTables[3]

        // Assert
        // Check Wizard spells per day
        // Lev. 0 1 2 3 4 5 6 7 8 9
        // 17th 4 4 4 4 4 4 4 3 2 1
        assertSpellsPerDayTable(spellsPerDayTable, "Wizard", 17, intArrayOf(4, 4, 4, 4, 4, 4, 4, 3, 2, 1))
    }

    private fun assertSpellsPerDayTable(spellsPerDayTable: SpellsPerDayTable, name: String, spellcasterLevel: Int,
                                        spellsPerDay: IntArray) {
        assertThat(spellsPerDayTable.name).isEqualTo(name)
        for (i in spellsPerDay.indices) {
            assertThat(spellsPerDayTable.getSpellsPerDay(spellcasterLevel, i)).isEqualTo(spellsPerDay[i])
        }
    }

    companion object {
        private const val SPELL_ID_ACID_ARROW = 1
        private const val SPELLLIST_ID_CLERIC = 1
    }
}