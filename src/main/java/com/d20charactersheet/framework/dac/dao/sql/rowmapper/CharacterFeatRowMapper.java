package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.CharacterFeat;
import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.dac.dao.BaseRowMapper;
import com.d20charactersheet.framework.dac.dao.DataRow;

/**
 * Maps the data of a character feat row to a CharacterFeat instance.
 */
public class CharacterFeatRowMapper extends BaseRowMapper {

    private final List<Feat> allFeats;

    /**
     * Instantiates mapper with list of all feats.
     *
     * @param allFeats
     *     All feats.
     */
    public CharacterFeatRowMapper(final List<Feat> allFeats) {
        super();
        this.allFeats = allFeats;
    }

    /**
     * Maps the data of a character feat row to an Character Feat, using the list of all static feats.
     */
    @NotNull
    public Object mapRow(@NotNull DataRow dataRow) throws java.sql.SQLException {
        final Feat feat = getFeat(dataRow.getInt(1));
        final CharacterFeat characterFeat = new CharacterFeat(feat);
        characterFeat.setId(dataRow.getInt(0));
        characterFeat.setCategory(dataRow.getString(2));
        return characterFeat;
    }

    private Feat getFeat(final int featId) {
        for (final Feat feat : allFeats) {
            if (feat.getId() == featId) {
                return feat;
            }
        }
        throw new IllegalStateException("Can't get static feat: " + featId);
    }

}
