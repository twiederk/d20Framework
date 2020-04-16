package com.d20charactersheet.framework.dac.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterFeat;
import com.d20charactersheet.framework.boc.model.Feat;

public abstract class BaseFeatDaoTest {

  protected CharacterDao characterDao;
  protected FeatDao featDao;

  @Test
  public void testGetAllFeats() {
    final List<Feat> allFeats = featDao.getAllFeats();
    assertNotNull(allFeats);
    assertEquals(109, allFeats.size());
  }

  @Test
  public void testGetFeatsOfCharacter() {
    final Character belvador = new Character();
    belvador.setId(0);
    final List<CharacterFeat> characterFeats = characterDao.getCharacterFeats(belvador, featDao.getAllFeats());
    assertNotNull(characterFeats);
    assertEquals(3, characterFeats.size());
  }
}
