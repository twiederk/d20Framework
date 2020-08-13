package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.util.EnumSet;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.Alignment;
import com.d20charactersheet.framework.boc.model.BaseAttackBonus;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.Die;
import com.d20charactersheet.framework.boc.model.Save;
import com.d20charactersheet.framework.dac.dao.BaseRowMapper;
import com.d20charactersheet.framework.dac.dao.DataRow;

/**
 * Maps a data row to a character class.
 */
public class ClassRowMapper extends BaseRowMapper {

    /**
     * Maps a data row to a character class.
     */
    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws java.sql.SQLException {
        // id, name, base_attack_bonus, saves, alignments, skill_points_per_level, hit_die_id
        final CharacterClass characterClass = new CharacterClass();
        characterClass.setId(dataRow.getInt(0));
        characterClass.setName(dataRow.getString(1));
        final EnumSet<Save> saves = getEnums(dataRow.getInt(2), Save.class);
        characterClass.setSaves(saves);
        final EnumSet<Alignment> alignments = getEnums(dataRow.getInt(3), Alignment.class);
        characterClass.setAlignments(alignments);
        characterClass.setBaseAttackBonus((BaseAttackBonus) getEnum(dataRow.getInt(4), BaseAttackBonus.values()));
        characterClass.setSkillPointsPerLevel(dataRow.getInt(5));
        characterClass.setHitDie((Die) getEnum(dataRow.getInt(6), Die.values()));
        return characterClass;
    }

}
