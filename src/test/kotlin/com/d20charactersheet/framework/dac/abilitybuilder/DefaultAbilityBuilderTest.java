package com.d20charactersheet.framework.dac.abilitybuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DefaultAbilityBuilderTest {

  @Test
  public void testGetClassnameAbility() {
    final DefaultAbilityBuilder abilityBuilder = new DefaultAbilityBuilder();
    final AbilityConfig abilityConfig = new AbilityConfig();
    abilityConfig.setClassname("Ability");
    final String classname = abilityBuilder.getClassname(abilityConfig);
    assertNotNull(classname);
    assertEquals("com.d20charactersheet.framework.boc.model.Ability", classname);
  }

  @Test
  public void testGetClassnameExtraAbility() {
    final DefaultAbilityBuilder abilityBuilder = new DefaultAbilityBuilder();
    final AbilityConfig abilityConfig = new AbilityConfig();
    abilityConfig.setClassname("ExtraAbility");
    final String classname = abilityBuilder.getClassname(abilityConfig);
    assertNotNull(classname);
    assertEquals("com.d20charactersheet.framework.boc.model.ExtraAbility", classname);
  }

}
