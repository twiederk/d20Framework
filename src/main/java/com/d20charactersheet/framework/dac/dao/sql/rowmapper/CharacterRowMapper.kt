package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.*
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

/**
 * Maps a datarow to a Character instance.
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
        character.setSaveModifier(Save.STRENGTH, dataRow.getInt(20))
        character.setSaveModifier(Save.DEXTERITY, dataRow.getInt(21))
        character.setSaveModifier(Save.CONSTITUTION, dataRow.getInt(22))
        character.setSaveModifier(Save.INTELLIGENCE, dataRow.getInt(23))
        character.setSaveModifier(Save.WISDOM, dataRow.getInt(24))
        character.setSaveModifier(Save.CHARISMA, dataRow.getInt(25))
        character.imageId = dataRow.getInt(26)
        character.thumbImageId = dataRow.getInt(27)
        character.money = getMoney(dataRow)
        return character
    }

    @Throws(SQLException::class)
    private fun getMoney(dataRow: DataRow): Money {
        val money = Money()
        money.platinum = dataRow.getInt(28)
        money.gold = dataRow.getInt(29)
        money.silver = dataRow.getInt(30)
        money.copper = dataRow.getInt(31)
        return money
    }
}