package com.d20charactersheet.framework.boc.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Character;

public class DnDv35RuleServiceItemTest extends DnDv35RuleServiceTestCase {

  @Test
  public void testGetLoadOfBelvador() throws Exception {
    final Character belvador = gameSystem.getCharacter(0);

    final float load = ruleService.getLoad(belvador);
    assertEquals(52.5f, load, 0.0f);
  }

}
