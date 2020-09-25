package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.Feat

/**
 * Interface to provide access to persistent feat data.
 */
interface FeatDao {
    /**
     * Returns all feats.
     *
     * @return All feats.
     */
    fun getAllFeats(): List<Feat>

    /**
     * Create the feat.
     *
     * @param feat
     * The feat to create.
     */
    fun createFeat(feat: Feat)

    /**
     * Updates the feat.
     *
     * @param feat
     * The feat to update.
     */
    fun updateFeat(feat: Feat)

    /**
     * Deletes the feat.
     *
     * @param feat
     * The feat to delete.
     */
    fun deleteFeat(feat: Feat)
}