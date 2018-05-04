package com.d20charactersheet.framework.boc.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.d20charactersheet.framework.DnDv35Universe;
import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.ClassAbility;
import com.d20charactersheet.framework.boc.model.Skill;

public class CharacterClassServiceTest {

  private CharacterClassService characterClassService;
  private List<Skill> allSkills;
  private List<Ability> allAbilities;

  @Before
  public void setUp() throws Exception {
    final GameSystem gameSystem = new DnDv35Universe().getGameSystem();
    characterClassService = gameSystem.getCharacterClassService();
    allSkills = gameSystem.getAllSkills();
    allAbilities = gameSystem.getAllAbilities();
  }

  @Test
  public void testGetAllCharacterClasses() {
    final List<CharacterClass> allCharacterClasses = characterClassService.getAllCharacterClasses(allSkills, allAbilities);
    assertEquals(27, allCharacterClasses.size());
    final CharacterClass barbarian = allCharacterClasses.get(0);
    final List<ClassAbility> barbarianAbilities = barbarian.getClassAbilities();
    final int[] levels = {1, 1, 1, 2, 3, 5, 7, 11, 14, 17, 20};
    assertEquals(levels.length, barbarianAbilities.size());
    assertLevels(levels, barbarianAbilities);
  }

  private void assertLevels(final int[] levels, final List<ClassAbility> classAbilities) {
    for (int i = 0; i < levels.length; i++) {
      final ClassAbility classAbility = classAbilities.get(i);
      assertEquals(levels[i], classAbility.getLevel());
    }

  }
}
