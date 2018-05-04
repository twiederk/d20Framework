package com.d20charactersheet.framework.dac.dao.dummy;

import java.util.ArrayList;
import java.util.List;

import com.androidash.memorydb.DaoUtil;
import com.androidash.memorydb.DataRow;
import com.androidash.memorydb.DataTable;
import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.boc.model.FeatType;
import com.d20charactersheet.framework.dac.dao.FeatDao;

/**
 * In memory implemenation of FeatDao.
 */
public class DummyFeatDao implements FeatDao {

  private final DataTable featTable;
  private final DaoUtil daoUtil;

  /**
   * Instanciates all static feats and character feats.
   *
   * @param feat
   *     Feat raw data.
   */
  public DummyFeatDao(final Object[][] feat) {
    featTable = new DataTable(feat);
    daoUtil = new DaoUtil();
  }

  private Feat selectFeat(final DataRow featRow) {
    // id, name, feat type, prerequisit, benefit, fighter bonus, multiple, stack
    final Feat feat = new Feat();
    feat.setId(featRow.getId());
    feat.setName(featRow.getString(1));
    feat.setPrerequisit(featRow.getString(2));
    feat.setBenefit(featRow.getString(3));
    feat.setFeatType(getFeatType(featRow.getInt(4)));
    feat.setFighterBonus(daoUtil.getBoolean(featRow.getInt(5)));
    feat.setMultiple(daoUtil.getBoolean(featRow.getInt(6)));
    feat.setStack(daoUtil.getBoolean(featRow.getInt(7)));
    feat.setSpellSlot(featRow.getInt(8));
    return feat;
  }

  private FeatType getFeatType(final int featTypeId) {
    for (final FeatType featType : FeatType.values()) {
      if (featType.ordinal() == featTypeId) {
        return featType;
      }
    }
    throw new IllegalArgumentException("Can't get feat type of id: " + featTypeId);
  }

  /**
   * @see com.d20charactersheet.framework.dac.dao.FeatDao#getAllFeats()
   */
  @Override
  public List<Feat> getAllFeats() {
    final List<Feat> allFeats = new ArrayList<Feat>();
    for (final DataRow featRow : featTable) {
      final Feat feat = selectFeat(featRow);
      allFeats.add(feat);
    }
    return allFeats;
  }

  /**
   * @see com.d20charactersheet.framework.dac.dao.FeatDao#createFeat(com.d20charactersheet.framework.boc.model.Feat)
   */
  @Override
  public Feat createFeat(final Feat feat) {
    feat.setId(featTable.getNewId());
    insertFeat(feat);
    return feat;
  }

  /**
   * @see com.d20charactersheet.framework.dac.dao.FeatDao#updateFeat(com.d20charactersheet.framework.boc.model.Feat)
   */
  @Override
  public Feat updateFeat(final Feat feat) {
    deleteFeat(feat);
    insertFeat(feat);
    return feat;
  }

  private void insertFeat(final Feat feat) {
    featTable.insert(
        new Object[] {feat.getId(), feat.getName(), feat.getPrerequisit(), feat.getBenefit(), feat.getFeatType().ordinal(),
            daoUtil.setBoolean(feat.isFighterBonus()), daoUtil.setBoolean(feat.isMultiple()), daoUtil.setBoolean(feat.isStack()),
            feat.getSpellSlot()
        });
  }

  /**
   * @see com.d20charactersheet.framework.dac.dao.FeatDao#deleteFeat(com.d20charactersheet.framework.boc.model.Feat)
   */
  @Override
  public void deleteFeat(final Feat feat) {
    featTable.delete(feat.getId());
  }

}
