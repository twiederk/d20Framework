package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.model.CastingTime
import com.d20charactersheet.framework.boc.model.School
import com.d20charactersheet.framework.boc.model.SpellResistance
import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eSpellTest {

    private val gameSystem: GameSystem = DnD5eUniverse().gameSystem

    @Test
    fun findSpellById_idOfAcidSplash_loadAcidSplash() {

        // act
        val acidSplash = gameSystem.spelllistService.findSpellById(1, gameSystem.allSpells)

        // assert
        assertThat(acidSplash.name).isEqualTo("Acid Splash")
        assertThat(acidSplash.school).isEqualTo(School.CONJURATION)
        assertThat(acidSplash.isVerbal).isTrue
        assertThat(acidSplash.isSomatic).isTrue
        assertThat(acidSplash.isMaterial).isFalse
        assertThat(acidSplash.isFocus).isFalse
        assertThat(acidSplash.isXpCost).isFalse
        assertThat(acidSplash.castingTime).isEqualTo(CastingTime.ONE_STANDARD_ACTION)
        assertThat(acidSplash.range).isEqualTo("60 feet")
        assertThat(acidSplash.effect).isEmpty()
        assertThat(acidSplash.duration).isEqualTo("Instantaneous")
        assertThat(acidSplash.savingThrow).isEmpty()
        assertThat(acidSplash.spellResistance).isEqualTo(SpellResistance.NONE)
        assertThat(acidSplash.shortDescription).isEqualTo("1 or 2 creatures within 5 feet must succeed on a Dex. save or take 1d6 acid damage (damage/lvl).")
        assertThat(acidSplash.materialComponent).isEmpty()
        assertThat(acidSplash.focus).isEmpty()
    }

    @Test
    fun loadDescription_acidSplash_fillDescription() {
        // arrange
        val acidSplash = gameSystem.spelllistService.findSpellById(1, gameSystem.allSpells)

        // act
        gameSystem.spelllistService.getSpellDescription(acidSplash)

        // assert
        assertThat(acidSplash.description).isEqualTo("You hurl a bubble of acid. Choose one creature you can see within range, or choose two creatures you can see within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage.<br>This spell's damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).<br>")
    }

    @Test
    fun findSpelllistById_idOfBardSpelllist_returnBardSpelllist() {

        // act
        val bardSpelllist = gameSystem.spelllistService.findSpelllistById(1, gameSystem.allSpelllists)

        // assert
        assertThat(bardSpelllist.name).isEqualTo("Bard")
        assertThat(bardSpelllist.shortname).isEqualTo("Brd")
        assertThat(bardSpelllist.isDomain).isFalse
        assertThat(bardSpelllist.minLevel).isEqualTo(0)
        assertThat(bardSpelllist.maxLevel).isEqualTo(9)
        assertThat(bardSpelllist.numberOfSpellLevels).isEqualTo(10)
        assertThat(bardSpelllist.getSpellsOfLevel(0)).hasSize(9)
        assertThat(bardSpelllist.getSpellsOfLevel(1)).hasSize(20)
        assertThat(bardSpelllist.getSpellsOfLevel(2)).hasSize(19)
        assertThat(bardSpelllist.getSpellsOfLevel(3)).hasSize(15)
        assertThat(bardSpelllist.getSpellsOfLevel(4)).hasSize(8)
        assertThat(bardSpelllist.getSpellsOfLevel(5)).hasSize(16)
        assertThat(bardSpelllist.getSpellsOfLevel(6)).hasSize(7)
        assertThat(bardSpelllist.getSpellsOfLevel(7)).hasSize(10)
        assertThat(bardSpelllist.getSpellsOfLevel(8)).hasSize(5)
        assertThat(bardSpelllist.getSpellsOfLevel(9)).hasSize(3)
    }

    @Test
    fun findSpelllistById_idOfClericSpelllist_returnClericSpelllist() {

        // act
        val clericSpelllist = gameSystem.spelllistService.findSpelllistById(2, gameSystem.allSpelllists)

        // assert
        assertThat(clericSpelllist.name).isEqualTo("Cleric")
        assertThat(clericSpelllist.shortname).isEqualTo("Clr")
        assertThat(clericSpelllist.isDomain).isFalse
        assertThat(clericSpelllist.minLevel).isEqualTo(0)
        assertThat(clericSpelllist.maxLevel).isEqualTo(9)
        assertThat(clericSpelllist.numberOfSpellLevels).isEqualTo(10)
        assertThat(clericSpelllist.getSpellsOfLevel(0)).hasSize(7)
        assertThat(clericSpelllist.getSpellsOfLevel(1)).hasSize(15)
        assertThat(clericSpelllist.getSpellsOfLevel(2)).hasSize(17)
        assertThat(clericSpelllist.getSpellsOfLevel(3)).hasSize(20)
        assertThat(clericSpelllist.getSpellsOfLevel(4)).hasSize(8)
        assertThat(clericSpelllist.getSpellsOfLevel(5)).hasSize(13)
        assertThat(clericSpelllist.getSpellsOfLevel(6)).hasSize(10)
        assertThat(clericSpelllist.getSpellsOfLevel(7)).hasSize(8)
        assertThat(clericSpelllist.getSpellsOfLevel(8)).hasSize(4)
        assertThat(clericSpelllist.getSpellsOfLevel(9)).hasSize(4)
    }

    @Test
    fun findSpelllistById_idOfDruidSpelllist_returnDruidSpelllist() {

        // act
        val druidSpelllist = gameSystem.spelllistService.findSpelllistById(3, gameSystem.allSpelllists)

        // assert
        assertThat(druidSpelllist.name).isEqualTo("Druid")
        assertThat(druidSpelllist.shortname).isEqualTo("Drd")
        assertThat(druidSpelllist.isDomain).isFalse
        assertThat(druidSpelllist.minLevel).isEqualTo(0)
        assertThat(druidSpelllist.maxLevel).isEqualTo(9)
        assertThat(druidSpelllist.numberOfSpellLevels).isEqualTo(10)
        assertThat(druidSpelllist.getSpellsOfLevel(0)).hasSize(7)
        assertThat(druidSpelllist.getSpellsOfLevel(1)).hasSize(16)
        assertThat(druidSpelllist.getSpellsOfLevel(2)).hasSize(17)
        assertThat(druidSpelllist.getSpellsOfLevel(3)).hasSize(12)
        assertThat(druidSpelllist.getSpellsOfLevel(4)).hasSize(15)
        assertThat(druidSpelllist.getSpellsOfLevel(5)).hasSize(14)
        assertThat(druidSpelllist.getSpellsOfLevel(6)).hasSize(9)
        assertThat(druidSpelllist.getSpellsOfLevel(7)).hasSize(5)
        assertThat(druidSpelllist.getSpellsOfLevel(8)).hasSize(6)
        assertThat(druidSpelllist.getSpellsOfLevel(9)).hasSize(4)
    }

    @Test
    fun findSpelllistById_idOfPaladinSpelllist_returnPaladinSpelllist() {

        // act
        val paladinSpelllist = gameSystem.spelllistService.findSpelllistById(4, gameSystem.allSpelllists)

        // assert
        assertThat(paladinSpelllist.name).isEqualTo("Paladin")
        assertThat(paladinSpelllist.shortname).isEqualTo("Pal")
        assertThat(paladinSpelllist.isDomain).isFalse
        assertThat(paladinSpelllist.minLevel).isEqualTo(1)
        assertThat(paladinSpelllist.maxLevel).isEqualTo(5)
        assertThat(paladinSpelllist.numberOfSpellLevels).isEqualTo(5)
        assertThat(paladinSpelllist.getSpellsOfLevel(1)).hasSize(11)
        assertThat(paladinSpelllist.getSpellsOfLevel(2)).hasSize(8)
        assertThat(paladinSpelllist.getSpellsOfLevel(3)).hasSize(6)
        assertThat(paladinSpelllist.getSpellsOfLevel(4)).hasSize(3)
        assertThat(paladinSpelllist.getSpellsOfLevel(5)).hasSize(3)
    }

    @Test
    fun findSpelllistById_idOfRangerSpelllist_returnRangerSpelllist() {

        // act
        val rangerSpelllist = gameSystem.spelllistService.findSpelllistById(5, gameSystem.allSpelllists)

        // assert
        assertThat(rangerSpelllist.name).isEqualTo("Ranger")
        assertThat(rangerSpelllist.shortname).isEqualTo("Rgr")
        assertThat(rangerSpelllist.isDomain).isFalse
        assertThat(rangerSpelllist.minLevel).isEqualTo(1)
        assertThat(rangerSpelllist.maxLevel).isEqualTo(5)
        assertThat(rangerSpelllist.numberOfSpellLevels).isEqualTo(5)
        assertThat(rangerSpelllist.getSpellsOfLevel(1)).hasSize(11)
        assertThat(rangerSpelllist.getSpellsOfLevel(2)).hasSize(11)
        assertThat(rangerSpelllist.getSpellsOfLevel(3)).hasSize(9)
        assertThat(rangerSpelllist.getSpellsOfLevel(4)).hasSize(4)
        assertThat(rangerSpelllist.getSpellsOfLevel(5)).hasSize(2)
    }

    @Test
    fun findSpelllistById_idOfSorcererSpelllist_returnSorcererSpelllist() {

        // act
        val sorcererSpelllist = gameSystem.spelllistService.findSpelllistById(6, gameSystem.allSpelllists)

        // assert
        assertThat(sorcererSpelllist.name).isEqualTo("Sorcerer")
        assertThat(sorcererSpelllist.shortname).isEqualTo("Sor")
        assertThat(sorcererSpelllist.isDomain).isFalse
        assertThat(sorcererSpelllist.minLevel).isEqualTo(0)
        assertThat(sorcererSpelllist.maxLevel).isEqualTo(9)
        assertThat(sorcererSpelllist.numberOfSpellLevels).isEqualTo(10)
        assertThat(sorcererSpelllist.getSpellsOfLevel(0)).hasSize(14)
        assertThat(sorcererSpelllist.getSpellsOfLevel(1)).hasSize(17)
        assertThat(sorcererSpelllist.getSpellsOfLevel(2)).hasSize(21)
        assertThat(sorcererSpelllist.getSpellsOfLevel(3)).hasSize(20)
        assertThat(sorcererSpelllist.getSpellsOfLevel(4)).hasSize(10)
        assertThat(sorcererSpelllist.getSpellsOfLevel(5)).hasSize(11)
        assertThat(sorcererSpelllist.getSpellsOfLevel(6)).hasSize(9)
        assertThat(sorcererSpelllist.getSpellsOfLevel(7)).hasSize(8)
        assertThat(sorcererSpelllist.getSpellsOfLevel(8)).hasSize(5)
        assertThat(sorcererSpelllist.getSpellsOfLevel(9)).hasSize(5)
    }

    @Test
    fun findSpelllistById_idOfWarlockSpelllist_returnWarlockSpelllist() {

        // act
        val warlockSpelllist = gameSystem.spelllistService.findSpelllistById(7, gameSystem.allSpelllists)

        // assert
        assertThat(warlockSpelllist.name).isEqualTo("Warlock")
        assertThat(warlockSpelllist.shortname).isEqualTo("War")
        assertThat(warlockSpelllist.isDomain).isFalse
        assertThat(warlockSpelllist.minLevel).isEqualTo(0)
        assertThat(warlockSpelllist.maxLevel).isEqualTo(9)
        assertThat(warlockSpelllist.numberOfSpellLevels).isEqualTo(10)
        assertThat(warlockSpelllist.getSpellsOfLevel(0)).hasSize(7)
        assertThat(warlockSpelllist.getSpellsOfLevel(1)).hasSize(12)
        assertThat(warlockSpelllist.getSpellsOfLevel(2)).hasSize(14)
        assertThat(warlockSpelllist.getSpellsOfLevel(3)).hasSize(17)
        assertThat(warlockSpelllist.getSpellsOfLevel(4)).hasSize(9)
        assertThat(warlockSpelllist.getSpellsOfLevel(5)).hasSize(9)
        assertThat(warlockSpelllist.getSpellsOfLevel(6)).hasSize(7)
        assertThat(warlockSpelllist.getSpellsOfLevel(7)).hasSize(4)
        assertThat(warlockSpelllist.getSpellsOfLevel(8)).hasSize(5)
        assertThat(warlockSpelllist.getSpellsOfLevel(9)).hasSize(5)
    }

    @Test
    fun findSpelllistById_idOfWizardpelllist_returnWizardSpelllist() {

        // act
        val wizardSpelllist = gameSystem.spelllistService.findSpelllistById(8, gameSystem.allSpelllists)

        // assert
        assertThat(wizardSpelllist.name).isEqualTo("Wizard")
        assertThat(wizardSpelllist.shortname).isEqualTo("Wiz")
        assertThat(wizardSpelllist.isDomain).isFalse
        assertThat(wizardSpelllist.minLevel).isEqualTo(0)
        assertThat(wizardSpelllist.maxLevel).isEqualTo(9)
        assertThat(wizardSpelllist.numberOfSpellLevels).isEqualTo(10)
        assertThat(wizardSpelllist.getSpellsOfLevel(0)).hasSize(14)
        assertThat(wizardSpelllist.getSpellsOfLevel(1)).hasSize(27)
        assertThat(wizardSpelllist.getSpellsOfLevel(2)).hasSize(31)
        assertThat(wizardSpelllist.getSpellsOfLevel(3)).hasSize(28)
        assertThat(wizardSpelllist.getSpellsOfLevel(4)).hasSize(23)
        assertThat(wizardSpelllist.getSpellsOfLevel(5)).hasSize(23)
        assertThat(wizardSpelllist.getSpellsOfLevel(6)).hasSize(19)
        assertThat(wizardSpelllist.getSpellsOfLevel(7)).hasSize(15)
        assertThat(wizardSpelllist.getSpellsOfLevel(8)).hasSize(12)
        assertThat(wizardSpelllist.getSpellsOfLevel(9)).hasSize(12)
    }

    @Test
    fun allKnownSpellsTables_allKnownSpellsTablesLoaded_listOfAllKnownSpellsTables() {

        // act
        val allKnownSpellsTables = gameSystem.allKnownSpellsTables

        // assert
        assertThat(allKnownSpellsTables).hasSize(7)
        assertThat(allKnownSpellsTables[0].name).isEqualTo("Druid")
        assertThat(allKnownSpellsTables[1].name).isEqualTo("Paladin")
        assertThat(allKnownSpellsTables[2].name).isEqualTo("Wizard")
        assertThat(allKnownSpellsTables[3].name).isEqualTo("Bard")
        assertThat(allKnownSpellsTables[4].name).isEqualTo("Ranger")
        assertThat(allKnownSpellsTables[5].name).isEqualTo("Sorcerer")
        assertThat(allKnownSpellsTables[6].name).isEqualTo("Warlock")
    }

    @Test
    fun allSpellsPerDayTables_allSpellsPerDayTables_listOfAllSpellsPerDayTables() {

        // act
        val allSpellsPerDayTables = gameSystem.allSpellsPerDayTables

        // assert
        assertThat(allSpellsPerDayTables).hasSize(7)
        assertThat(allSpellsPerDayTables[0].name).isEqualTo("Druid")
        assertThat(allSpellsPerDayTables[1].name).isEqualTo("Paladin")
        assertThat(allSpellsPerDayTables[2].name).isEqualTo("Wizard")
        assertThat(allSpellsPerDayTables[3].name).isEqualTo("Bard")
        assertThat(allSpellsPerDayTables[4].name).isEqualTo("Ranger")
        assertThat(allSpellsPerDayTables[5].name).isEqualTo("Sorcerer")
        assertThat(allSpellsPerDayTables[6].name).isEqualTo("Warlock")
    }

}