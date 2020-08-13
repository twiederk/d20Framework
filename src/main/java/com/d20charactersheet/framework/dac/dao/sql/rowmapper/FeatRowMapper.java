package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.boc.model.FeatType;
import com.d20charactersheet.framework.dac.dao.BaseRowMapper;
import com.d20charactersheet.framework.dac.dao.DataRow;

/**
 * Maps a row of feat data to a StaticFeat object.
 */
public class FeatRowMapper extends BaseRowMapper {

    /**
     * Maps a row of feat data to a StaticFeat object.
     */
    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws java.sql.SQLException {
        // feat.id, feat.feat_type_id, feat_text.name, feat_text.prerequisit, feat_text.benefit, feat.fighter,
        // feat.multiple, feat.stack
        final Feat feat = new Feat();
        feat.setId(dataRow.getInt(0));
        feat.setName(dataRow.getString(1));
        feat.setPrerequisit(dataRow.getString(2));
        feat.setBenefit(dataRow.getString(3));
        feat.setFeatType((FeatType) getEnum(dataRow.getInt(4), FeatType.values()));
        feat.setFighterBonus(getBoolean(dataRow.getInt(5)));
        feat.setMultiple(getBoolean(dataRow.getInt(6)));
        feat.setStack(getBoolean(dataRow.getInt(7)));
        feat.setSpellSlot(dataRow.getInt(8));
        return feat;
    }

}
