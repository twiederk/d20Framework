package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.CharacterFeat
import com.d20charactersheet.framework.boc.model.Feat
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

/**
 * Instantiates mapper with list of all feats.
 *
 * @param allFeats
 * All feats.
 */
class CharacterFeatRowMapper(private val allFeats: List<Feat>) : BaseRowMapper() {

    /**
     * Maps the data of a character feat row to an Character Feat, using the list of all static feats.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        val feat = getFeat(dataRow.getInt(1))
        val characterFeat = CharacterFeat(feat)
        characterFeat.id = dataRow.getInt(0)
        characterFeat.category = dataRow.getString(2)
        return characterFeat
    }

    private fun getFeat(featId: Int): Feat {
        for (feat in allFeats) {
            if (feat.id == featId) {
                return feat
            }
        }
        throw IllegalStateException("Can't get static feat: $featId")
    }
}