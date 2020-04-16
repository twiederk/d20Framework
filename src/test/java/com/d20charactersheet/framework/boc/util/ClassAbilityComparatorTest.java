package com.d20charactersheet.framework.boc.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.ClassAbility;

public class ClassAbilityComparatorTest {

  @Test
  public void testCompare() {
    final List<ClassAbility> classAbilities = new ArrayList<>();
    classAbilities.add(createClassAbility("Attack", 5));
    classAbilities.add(createClassAbility("Defend", 3));
    classAbilities.add(createClassAbility("Track", 1));
    classAbilities.add(createClassAbility("Ride", 1));
    classAbilities.add(createClassAbility("Survive", 1));

    classAbilities.sort(new ClassAbilityComparator());

    assertEquals("Ride", classAbilities.get(0).getAbility().getName());
    assertEquals("Survive", classAbilities.get(1).getAbility().getName());
    assertEquals("Track", classAbilities.get(2).getAbility().getName());
    assertEquals("Defend", classAbilities.get(3).getAbility().getName());
    assertEquals("Attack", classAbilities.get(4).getAbility().getName());
  }

  private ClassAbility createClassAbility(final String name, final int level) {
    final Ability ability = new Ability();
    ability.setName(name);
    final ClassAbility classAbility = new ClassAbility(ability);
    classAbility.setLevel(level);
    return classAbility;
  }

}
