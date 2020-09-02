package com.d20charactersheet.framework.dac.dao;

import static org.assertj.core.api.Assertions.assertThat;

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

    // Act
    final List<Feat> allFeats = featDao.getAllFeats();

    // Assert
    assertThat(allFeats).hasSize(109);
  }

  @Test
  public void testGetFeatsOfCharacter() {
    // Arrange
    final Character belvador = new Character();
    belvador.setId(0);

    // Act
    final List<CharacterFeat> characterFeats = characterDao.getCharacterFeats(belvador, featDao.getAllFeats());

    // Assert
    assertThat(characterFeats).hasSize(3);
  }

}
