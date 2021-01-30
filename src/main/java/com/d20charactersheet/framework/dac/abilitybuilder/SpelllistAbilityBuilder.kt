package com.d20charactersheet.framework.dac.abilitybuilder

import com.d20charactersheet.framework.boc.model.*
import java.util.*

/**
 * Creates a SpelllistAbility which contains a spell list. The id of the spell list is a ability property called
 * spelllist_id. Instanciates SpelllistAbilityBuilder with a list of all available spell lists.
 *
 * @param allSpelllists
 * All spell lists of the game sytem.
 * @param allKnownSpellsTables
 * All known spell tables of the game system.
 * @param allSpellsPerDayTables
 * All spells per day tables of the game system.
 */
class SpelllistAbilityBuilder(
        private val allSpelllists: List<Spelllist>,
        private val allKnownSpellsTables: List<KnownSpellsTable>,
        private val allSpellsPerDayTables: List<SpellsPerDayTable>) : DefaultAbilityBuilder() {

    override fun createAbility(abilityConfig: AbilityConfig): Ability {
        val ability = SpelllistAbility()
        fillAbility(ability, abilityConfig)
        ability.spelllist = getSpelllist(abilityConfig)
        ability.spellAttribute = getAttribute(abilityConfig)
        ability.castingType = getCastingType(abilityConfig)
        ability.spellSource = getSpellSource(abilityConfig)
        ability.knownSpellsTable = getKnownSpellsTable(abilityConfig)
        ability.spellsPerDayTable = getSpellsPerDayTable(abilityConfig)
        ability.schools = getSchools(abilityConfig)
        ability.isAttributeBonusSpellSlots = getAttributeBonusSpellSlots(abilityConfig)
        return ability
    }

    private fun getSpelllist(abilityConfig: AbilityConfig): Spelllist {
        var spelllist = allSpelllists[0]
        try {
            val spelllistId = getInt(abilityConfig, KEY_SPELLLIST_ID)
            for (currentSpelllist in allSpelllists) {
                if (currentSpelllist.id == spelllistId) {
                    spelllist = currentSpelllist
                    break
                }
            }
        } catch (e: Exception) {
            // failed to get spell list from ability config
        }
        return spelllist
    }

    private fun getKnownSpellsTable(abilityConfig: AbilityConfig): KnownSpellsTable {
        var knownSpellsTableId = allKnownSpellsTables[0].id
        try {
            knownSpellsTableId = getInt(abilityConfig, KEY_KNOWN_SPELLS_TABLE_ID)
        } catch (e: Exception) {
            // failed to get id of spells known table from ability config
        }
        for (knownSpellsTable in allKnownSpellsTables) {
            if (knownSpellsTable.id == knownSpellsTableId) {
                return knownSpellsTable
            }
        }
        throw IllegalArgumentException("Can't find spells known table with id: $knownSpellsTableId")
    }

    private fun getSpellsPerDayTable(abilityConfig: AbilityConfig): SpellsPerDayTable {
        var spellsPerDayTableId = allSpellsPerDayTables[0].id
        try {
            spellsPerDayTableId = getInt(abilityConfig, KEY_SPELLS_PER_DAY_TABLE_ID)
        } catch (e: Exception) {
            // failed to get id of spells per day table from ability config
        }
        for (spellsPerDayTable in allSpellsPerDayTables) {
            if (spellsPerDayTable.id == spellsPerDayTableId) {
                return spellsPerDayTable
            }
        }
        throw IllegalArgumentException("Can't find spells per day table with id: $spellsPerDayTableId")
    }

    private fun getAttribute(abilityConfig: AbilityConfig): Attribute {
        var attribute = Attribute.INTELLIGENCE
        try {
            val id = getInt(abilityConfig, KEY_SPELL_ATTRIBUTE_ID)
            attribute = Attribute.values()[id]
        } catch (exception: Exception) {
            // failed to read attribute id from ability config
        }
        return attribute
    }

    private fun getCastingType(abilityConfig: AbilityConfig): CastingType {
        var castingType = CastingType.PREPARED
        try {
            val id = getInt(abilityConfig, KEY_CASTING_TYPE_ID)
            castingType = CastingType.values()[id]
        } catch (e: Exception) {
            // failed to get casting type from ability config
        }
        return castingType
    }

    private fun getSpellSource(abilityConfig: AbilityConfig): SpellSource {
        var spellSource = SpellSource.ARCANE
        try {
            val id = getInt(abilityConfig, KEY_SPELL_SOURCE_ID)
            spellSource = SpellSource.values()[id]
        } catch (e: Exception) {
            // failed to get spell source from ability config
        }
        return spellSource
    }

    private fun getSchools(abilityConfig: AbilityConfig): EnumSet<School> {
        var schools = ANY_SCHOOL
        try {
            val schoolId = getInt(abilityConfig, KEY_SCHOOL_ID)
            if (schoolId != ANY_SCHOOL_ID) {
                for (school in School.values()) {
                    if (school.ordinal == schoolId) {
                        schools = EnumSet.of(school)
                    }
                }
            }
        } catch (e: Exception) {
            // failed to get school from ability config
        }
        return schools
    }

    private fun getAttributeBonusSpellSlots(abilityConfig: AbilityConfig): Boolean {
        var attributeBonusSpellSlots = false
        try {
            attributeBonusSpellSlots = getBoolean(abilityConfig)
        } catch (e: Exception) {
            // failed to get attribute bonus spell slots from ability config
        }
        return attributeBonusSpellSlots
    }

    companion object {
        /**
         * The key to store the spell list id of the ability
         */
        const val KEY_SPELLLIST_ID = "spelllist_id"

        /**
         * The key to store the id of the spell attribute
         */
        const val KEY_SPELL_ATTRIBUTE_ID = "spell_attribute_id"

        /**
         * The key to store the id of the casting type
         */
        const val KEY_CASTING_TYPE_ID = "casting_type_id"

        /**
         * The key to store the id of the spell source
         */
        const val KEY_SPELL_SOURCE_ID = "spell_source_id"

        /**
         * The key to store the id of the known spells table
         */
        const val KEY_KNOWN_SPELLS_TABLE_ID = "spells_known_table_id"

        /**
         * The key to store the id of the spells per day table
         */
        const val KEY_SPELLS_PER_DAY_TABLE_ID = "spells_per_day_table_id"

        /**
         * The key to store if the attribute provides bonus spell slots
         */
        const val KEY_ATTRIBUTE_BONUS_SPELL_SLOTS = "attribute_bonus_spell_slots"

        /**
         * The key to store the id of the school suported by the spell list ability
         */
        const val KEY_SCHOOL_ID = "school_id"

        /**
         * Set of all school
         */
        val ANY_SCHOOL: EnumSet<School> = EnumSet.allOf(School::class.java)

        /**
         * The id to support any school
         */
        const val ANY_SCHOOL_ID = -1
    }
}