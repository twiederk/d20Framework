package com.d20charactersheet.framework.boc.service;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Feat;

/**
 * Provides services about feats.
 */
public interface FeatService {

  /**
   * Returns all static feats.
   *
   * @return All static feats.
   */
  public List<Feat> getAllFeats();

  /**
   * Creates a feat with the given parameters and stores it to the persistent layer.
   *
   * @param feat
   *     The feat to create.
   *
   * @return The created feat with a valid id.
   */
  public Feat createFeat(Feat feat);

  /**
   * Updates the feat.
   *
   * @param feat
   *     The feat to update.
   */
  public void updateFeat(Feat feat);

  /**
   * Deletes the feat.
   *
   * @param feat
   *     The feat to delete.
   */
  public void deleteFeat(Feat feat);

  /**
   * Returns the feat of the given id.
   *
   * @param featId
   *     The id of the feat.
   * @param allFeats
   *     The feats to find the feat in.
   *
   * @return The feat of the given id.
   */
  public Feat findFeatById(int featId, List<Feat> allFeats);

  /**
   * Find feat by name.
   *
   * @param name
   *     The name of the feat.
   * @param allFeats
   *     The feats to search.
   *
   * @return The feat with the given name.
   */
  public Feat findFeatByName(String name, List<Feat> allFeats);
}
