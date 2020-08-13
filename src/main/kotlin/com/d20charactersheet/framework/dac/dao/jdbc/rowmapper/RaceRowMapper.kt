package com.d20charactersheet.framework.dac.dao.jdbc.rowmapper

import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.Race
import com.d20charactersheet.framework.boc.model.Size
import com.d20charactersheet.framework.dac.dao.BaseRowMapper
import com.d20charactersheet.framework.dac.dao.DataRow
import java.sql.SQLException

/**
 * Creates row mapper with the given character classes.
 *
 * @param allCharacterClasses All character classes of the game system.
 */
class RaceRowMapper(private val allCharacterClasses: List<CharacterClass>) : BaseRowMapper() {

    /**
     * Maps a data row to a instance of class Race.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        val race = Race()
        race.id = dataRow.getInt(0)
        race.name = dataRow.getString(1)
        race.size = getEnum(dataRow.getInt(2), Size.values() as Array<Enum<*>>) as Size
        race.baseLandSpeed = dataRow.getInt(3)
        race.favoredCharacterClass = getCharacterClass(dataRow.getInt(4), allCharacterClasses)
        return race
    }

}