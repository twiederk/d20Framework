package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.*
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

/**
 * Maps a datarow to an Character instance.
 *
 * @param allRaces
 * All races of the game system.
 * @param allXpTables
 * All xp tables of the game system.
 */
class CharacterRowMapper(private val allRaces: List<Race>, private val allXpTables: List<XpTable>) : BaseRowMapper() {

    /**
     * Maps a database row to a Character instance.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        val character = Character()
        character.id = dataRow.getInt(0)
        character.player = dataRow.getString(1)
        character.name = dataRow.getString(2)
        character.race = getRace(dataRow.getInt(3), allRaces)
        character.sex = Sex.values()[dataRow.getInt(4)]
        character.alignment = Alignment.values()[dataRow.getInt(5)]
        character.xpTable = getXpTable(dataRow.getInt(6), allXpTables)
        character.experiencePoints = dataRow.getInt(7)
        character.strength = dataRow.getInt(8)
        character.dexterity = dataRow.getInt(9)
        character.constitution = dataRow.getInt(10)
        character.intelligence = dataRow.getInt(11)
        character.wisdom = dataRow.getInt(12)
        character.charisma = dataRow.getInt(13)
        character.hitPoints = dataRow.getInt(14)
        character.maxHitPoints = dataRow.getInt(15)
        character.armorClass = dataRow.getInt(16)
        character.initiativeModifier = dataRow.getInt(17)
        character.cmbModifier = dataRow.getInt(18)
        character.cmdModifier = dataRow.getInt(19)
        character.fortitudeModifier = dataRow.getInt(20)
        character.reflexModifier = dataRow.getInt(21)
        character.willModifier = dataRow.getInt(22)
        character.imageId = dataRow.getInt(23)
        character.thumbImageId = dataRow.getInt(24)
        character.money = getMoney(dataRow)
        return character
    }

    @Throws(SQLException::class)
    private fun getMoney(dataRow: DataRow): Money {
        val money = Money()
        money.platinum = dataRow.getInt(25)
        money.gold = dataRow.getInt(26)
        money.silver = dataRow.getInt(27)
        money.copper = dataRow.getInt(28)
        return money
    }
}