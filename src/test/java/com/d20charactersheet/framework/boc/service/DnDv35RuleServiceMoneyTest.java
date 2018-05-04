package com.d20charactersheet.framework.boc.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.Money;

public class DnDv35RuleServiceMoneyTest extends DnDv35RuleServiceTestCase {

  @Test
  public void testGetMoney() throws Exception {
    final Money money = new Money();
    money.setPlatinum(1);
    money.setGold(2);
    money.setSilver(3);
    money.setCopper(4);

    final Character character = createCharacter(fighter, 1);
    character.setMoney(money);
    final float gold = ruleService.getGold(character);
    assertEquals(12.34f, gold, 0.0f);
  }
}
