package com.d20charactersheet.framework.boc.service;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.dac.dao.FeatDao;

/**
 * Implementation of FeatService interface.
 */
public class FeatServiceImpl implements FeatService {

  private final FeatDao featDao;

  /**
   * Instanciates FeatService with given data access object.
   *
   * @param featDao
   *     Access to persistent layer.
   */
  public FeatServiceImpl(final FeatDao featDao) {
    this.featDao = featDao;
  }

  /**
   * Returns all feats, caching them after the first request.
   *
   * @see com.d20charactersheet.framework.boc.service.FeatService#getAllFeats()
   */
  @Override
  public List<Feat> getAllFeats() {
    return featDao.getAllFeats();
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.FeatService#createFeat(com.d20charactersheet.framework.boc.model.Feat)
   */
  @Override
  public Feat createFeat(final Feat feat) {
    featDao.createFeat(feat);
    return feat;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.FeatService#updateFeat(com.d20charactersheet.framework.boc.model.Feat)
   */
  @Override
  public void updateFeat(final Feat feat) {
    featDao.updateFeat(feat);
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.FeatService#deleteFeat(com.d20charactersheet.framework.boc.model.Feat)
   */
  @Override
  public void deleteFeat(final Feat feat) {
    featDao.deleteFeat(feat);
  }

  @Override
  public Feat findFeatById(final int featId, final List<Feat> allFeats) {
    for (final Feat feat : allFeats) {
      if (feat.getId() == featId) {
        return feat;
      }
    }
    throw new IllegalArgumentException("Can't find feat with id: " + featId);
  }

  @Override
  public Feat findFeatByName(final String name, final List<Feat> allFeats) {
    for (final Feat feat : allFeats) {
      if (feat.getName().equals(name)) {
        return feat;
      }
    }
    throw new IllegalArgumentException("Can't find feat with name: " + name);
  }

}
