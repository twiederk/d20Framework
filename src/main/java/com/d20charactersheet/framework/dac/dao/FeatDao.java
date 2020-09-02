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
  List<Feat> getAllFeats();

  /**
   * Create the feat.
   *
   * @param feat
   *     The feat to create.
   */
  void createFeat(Feat feat);

  /**
   * Updates the feat.
   *
   * @param feat
   *     The feat to update.
   */
  void updateFeat(Feat feat);

  /**
   * Deletes the feat.
   *
   * @param feat
   *     The feat to delete.
   */
  void deleteFeat(Feat feat);

}
