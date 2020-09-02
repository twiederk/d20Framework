package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.sql.SQLException;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.dac.dao.sql.DataRow;
import com.d20charactersheet.framework.dac.dao.sql.RowMapper;

/**
 * Maps a row of the table character_class_level to a ClassLevel object.
 */
public class ClassLevelRowMapper implements RowMapper {

    private final List<CharacterClass> allCharacterClasses;

    /**
     * Creates ClassLevelRowMapper, which requires all character classes to map the data to a ClassLevel.
     *
     * @param allCharacterClasses
     *     All character classes of the game system.
     */
    public ClassLevelRowMapper(final List<CharacterClass> allCharacterClasses) {
        this.allCharacterClasses = allCharacterClasses;
    }

    /**
     * Maps a row of the table classLevel to a ClassLevel object.
     */
    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws SQLException {
        // id, charakter_class_id, level
        final CharacterClass characterClass = getCharacterClass(dataRow.getInt(1));
        final ClassLevel classLevel = new ClassLevel(characterClass);
        classLevel.setId(dataRow.getInt(0));
        classLevel.setLevel(dataRow.getInt(2));
        return classLevel;
    }

    private CharacterClass getCharacterClass(final int characterClassId) {
        for (final CharacterClass characterClass : allCharacterClasses) {
            if (characterClassId == characterClass.getId()) {
                return characterClass;
            }
        }
        throw new IllegalArgumentException("Can't get character class with id: " + characterClassId);
    }
}
