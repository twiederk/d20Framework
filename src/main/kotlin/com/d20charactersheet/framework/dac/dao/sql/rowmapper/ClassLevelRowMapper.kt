package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.ClassLevel
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import com.d20charactersheet.framework.dac.dao.sql.RowMapper
import java.sql.SQLException


/**
 * Creates ClassLevelRowMapper, which requires all character classes to map the data to a ClassLevel.
 *
 * @param allCharacterClasses
 * All character classes of the game system.
 */
class ClassLevelRowMapper(private val allCharacterClasses: List<CharacterClass>) : RowMapper {

    /**
     * Maps a row of the table classLevel to a ClassLevel object.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        // id, charakter_class_id, level
        val characterClass = getCharacterClass(dataRow.getInt(1))
        val classLevel = ClassLevel(characterClass)
        classLevel.id = dataRow.getInt(0)
        classLevel.level = dataRow.getInt(2)
        return classLevel
    }

    private fun getCharacterClass(characterClassId: Int): CharacterClass {
        for (characterClass in allCharacterClasses) {
            if (characterClassId == characterClass.id) {
                return characterClass
            }
        }
        throw IllegalArgumentException("Can't get character class with id: $characterClassId")
    }
}