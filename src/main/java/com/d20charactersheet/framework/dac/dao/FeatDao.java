package com.d20charactersheet.framework.dac.dao;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Feat;

/**
 * Interface to provide access to persitent feat data.
 */
public interface FeatDao {

  /**
   * Returns all feats.
   *
   * @return All feats.
   */
  public List<Feat> getAllFeats();

  /**
   * Create the feat.
   *
   * @param feat
   *     The feat to create.
   *
   * @return The created feat.
   */
  public Feat createFeat(Feat feat);

  /**
   * Updates the feat.
   *
   * @param feat
   *     The feat to update.
   *
   * @return The updated feat.
   */
  public Feat updateFeat(Feat feat);

  /**
   * Deletes the feat.
   *
   * @param feat
   *     The feat to delete.
   */
  public void deleteFeat(Feat feat);

}
