package com.d20charactersheet.framework.dac.dao.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.d20charactersheet.framework.boc.model.CastingTime;
import com.d20charactersheet.framework.boc.model.Descriptor;
import com.d20charactersheet.framework.boc.model.Range;
import com.d20charactersheet.framework.boc.model.School;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.SpellResistance;
import com.d20charactersheet.framework.boc.model.SubSchool;

public class SpellSerializorTest {

  private SpellSerializor spellSerializor;

  @Before
  public void setUp() throws Exception {
    spellSerializor = new SpellSerializor();
  }

  @Test
  public void testDeserializeSchool() {
    School school = spellSerializor.deserializeSchool("Conjuration (Creation) [Acid]");
    assertNotNull(school);
    assertEquals(School.CONJURATION, school);

    school = spellSerializor.deserializeSchool("Enchantment");
    assertNotNull(school);
    assertEquals(School.ENCHANTMENT, school);

  }

  @Test
  public void testDeserializeSubSchool() {
    SubSchool subSchool = spellSerializor.deserializeSubSchool("Conjuration (Creation) [Acid]");
    assertNotNull(subSchool);
    assertEquals(SubSchool.CREATION, subSchool);

    subSchool = spellSerializor.deserializeSubSchool("Enchantment");
    assertNotNull(subSchool);
    assertEquals(SubSchool.NONE, subSchool);

    subSchool = spellSerializor.deserializeSubSchool("Conjuration (Creation or Calling)");
    assertNotNull(subSchool);
    assertEquals(SubSchool.NONE, subSchool);
  }

  @Test
  public void testSerializeSchool() throws Exception {
    final Spell spell = new Spell();

    spell.setSchool(School.CONJURATION);
    String school = spellSerializor.serializeSchool(spell);
    assertNotNull(school);
    assertEquals("Conjuration", school);

    spell.setSubSchool(SubSchool.CREATION);
    school = spellSerializor.serializeSchool(spell);
    assertNotNull(school);
    assertEquals("Conjuration (Creation)", school);

    spell.setDescriptors(new Descriptor[] {Descriptor.ACID});
    school = spellSerializor.serializeSchool(spell);
    assertNotNull(school);
    assertEquals("Conjuration (Creation) [Acid]", school);
  }

  @Test
  public void testDeserializeDescriptors() {
    Descriptor[] descriptors = spellSerializor.deserializeDescriptors("Conjuration (Creation) [Acid]");
    assertNotNull(descriptors);
    assertEquals(descriptors.length, 1);
    assertEquals(Descriptor.ACID, descriptors[0]);

    descriptors = spellSerializor.deserializeDescriptors("Conjuration (Creation) [Acid,Air]");
    assertNotNull(descriptors);
    assertEquals(descriptors.length, 2);
    assertEquals(Descriptor.ACID, descriptors[0]);
    assertEquals(Descriptor.AIR, descriptors[1]);

    descriptors = spellSerializor.deserializeDescriptors("Conjuration (Creation) [Acid ,Air]");
    assertNotNull(descriptors);
    assertEquals(descriptors.length, 2);
    assertEquals(Descriptor.ACID, descriptors[0]);
    assertEquals(Descriptor.AIR, descriptors[1]);

    descriptors = spellSerializor.deserializeDescriptors("Conjuration (Creation) [Acid, Air]");
    assertNotNull(descriptors);
    assertEquals(descriptors.length, 2);
    assertEquals(Descriptor.ACID, descriptors[0]);
    assertEquals(Descriptor.AIR, descriptors[1]);

    descriptors = spellSerializor.deserializeDescriptors("Conjuration (Creation) [Acid , Air]");
    assertNotNull(descriptors);
    assertEquals(descriptors.length, 2);
    assertEquals(Descriptor.ACID, descriptors[0]);
    assertEquals(Descriptor.AIR, descriptors[1]);

    descriptors = spellSerializor.deserializeDescriptors("Illusion (Phantasm) [Fear, Mind-Affecting]");
    assertNotNull(descriptors);
    assertEquals(descriptors.length, 2);
    assertEquals(Descriptor.FEAR, descriptors[0]);
    assertEquals(Descriptor.MIND_AFFECTING, descriptors[1]);

    descriptors = spellSerializor.deserializeDescriptors("Enchantment (Charm) [Language-Dependent, Mind-Affecting, Sonic]");
    assertNotNull(descriptors);
    assertEquals(descriptors.length, 3);
    assertEquals(Descriptor.LANGUAGE_DEPENDENT, descriptors[0]);
    assertEquals(Descriptor.MIND_AFFECTING, descriptors[1]);
    assertEquals(Descriptor.SONIC, descriptors[2]);

    descriptors = spellSerializor.deserializeDescriptors("Conjuration (Calling) [see text for lesser planar binding]");
    assertNotNull(descriptors);
    assertEquals(descriptors.length, 1);
    assertEquals(Descriptor.NONE, descriptors[0]);
  }

  @Test
  public void testDeserializeCastingTime() throws Exception {
    CastingTime castingTime = spellSerializor.deserializeCastingTime("1 standard action");
    assertNotNull(castingTime);
    assertEquals(CastingTime.ONE_STANDARD_ACTION, castingTime);

    castingTime = spellSerializor.deserializeCastingTime("10 minutes");
    assertNotNull(castingTime);
    assertEquals(CastingTime.TEN_MINUTES, castingTime);

    castingTime = spellSerializor.deserializeCastingTime("1 round");
    assertNotNull(castingTime);
    assertEquals(CastingTime.ONE_ROUND, castingTime);

    castingTime = spellSerializor.deserializeCastingTime("1 minute");
    assertNotNull(castingTime);
    assertEquals(CastingTime.ONE_MINUTE, castingTime);

    castingTime = spellSerializor.deserializeCastingTime("1 hour");
    assertNotNull(castingTime);
    assertEquals(CastingTime.ONE_HOUR, castingTime);

    castingTime = spellSerializor.deserializeCastingTime("3 rounds");
    assertNotNull(castingTime);
    assertEquals(CastingTime.SPECIFIC, castingTime);

    castingTime = spellSerializor.deserializeCastingTime("24 hours");
    assertNotNull(castingTime);
    assertEquals(CastingTime.SPECIFIC, castingTime);

    castingTime = spellSerializor.deserializeCastingTime("See text");
    assertNotNull(castingTime);
    assertEquals(CastingTime.SPECIFIC, castingTime);

    castingTime = spellSerializor.deserializeCastingTime("30 minutes");
    assertNotNull(castingTime);
    assertEquals(CastingTime.SPECIFIC, castingTime);

    castingTime = spellSerializor.deserializeCastingTime(null);
    assertNotNull(castingTime);
    assertEquals(CastingTime.NONE, castingTime);

    castingTime = spellSerializor.deserializeCastingTime("");
    assertNotNull(castingTime);
    assertEquals(CastingTime.NONE, castingTime);

    castingTime = spellSerializor.deserializeCastingTime("1 free action");
    assertNotNull(castingTime);
    assertEquals(CastingTime.ONE_FREE_ACTION, castingTime);

    castingTime = spellSerializor.deserializeCastingTime("1 minute or longer; see text");
    assertNotNull(castingTime);
    assertEquals(CastingTime.SPECIFIC, castingTime);
  }

  @Test
  public void testDeserializeRange() throws Exception {
    Range range = spellSerializor.deserializeRange("Personal");
    assertNotNull(range);
    assertEquals(Range.PERSONAL, range);

    range = spellSerializor.deserializeRange("Touch");
    assertNotNull(range);
    assertEquals(Range.TOUCH, range);

    range = spellSerializor.deserializeRange("Close (25 ft. + 5 ft./2 levels)");
    assertNotNull(range);
    assertEquals(Range.CLOSE, range);

    range = spellSerializor.deserializeRange("Medium (100 ft. + 10 ft./level)");
    assertNotNull(range);
    assertEquals(Range.MEDIUM, range);

    range = spellSerializor.deserializeRange("Long (400 ft. + 40 ft./level)");
    assertNotNull(range);
    assertEquals(Range.LONG, range);

    range = spellSerializor.deserializeRange("See text");
    assertNotNull(range);
    assertEquals(Range.SPECIFIC, range);

    range = spellSerializor.deserializeRange("Close (25 ft. + 5 ft./2 levels) or see text");
    assertNotNull(range);
    assertEquals(Range.SPECIFIC, range);

    range = spellSerializor.deserializeRange("Anywhere within the area to be warded");
    assertNotNull(range);
    assertEquals(Range.SPECIFIC, range);
  }

  @Test
  public void testDeserializeSpellResistance() throws Exception {
    SpellResistance spellResistance = spellSerializor.deserializeSpellResistance("Yes");
    assertNotNull(spellResistance);
    assertEquals(SpellResistance.YES, spellResistance);

    spellResistance = spellSerializor.deserializeSpellResistance("No");
    assertNotNull(spellResistance);
    assertEquals(SpellResistance.NO, spellResistance);

    spellResistance = spellSerializor.deserializeSpellResistance("Yes (harmless)");
    assertNotNull(spellResistance);
    assertEquals(SpellResistance.YES_HARMLESS, spellResistance);

    spellResistance = spellSerializor.deserializeSpellResistance("Yes (object)");
    assertNotNull(spellResistance);
    assertEquals(SpellResistance.YES_OBJECT, spellResistance);

    spellResistance = spellSerializor.deserializeSpellResistance("Yes (harmless, object)");
    assertNotNull(spellResistance);
    assertEquals(SpellResistance.YES_HARMLESS_OBJECT, spellResistance);

    spellResistance = spellSerializor.deserializeSpellResistance("See text");
    assertNotNull(spellResistance);
    assertEquals(SpellResistance.SPECIFIC, spellResistance);

    spellResistance = spellSerializor.deserializeSpellResistance("Yes; see text");
    assertNotNull(spellResistance);
    assertEquals(SpellResistance.SPECIFIC, spellResistance);

    spellResistance = spellSerializor.deserializeSpellResistance("");
    assertNotNull(spellResistance);
    assertEquals(SpellResistance.NONE, spellResistance);

    spellResistance = spellSerializor.deserializeSpellResistance(null);
    assertNotNull(spellResistance);
    assertEquals(SpellResistance.NONE, spellResistance);
  }

  @Test
  public void testSerializeComponents() throws Exception {
    final Spell spell = new Spell();

    int components = spellSerializor.serializeComponents(spell);
    assertEquals(0, components);

    spell.setVerbal(true);
    components = spellSerializor.serializeComponents(spell);
    assertEquals(1, components);

    spell.setSomatic(true);
    components = spellSerializor.serializeComponents(spell);
    assertEquals(3, components);

    spell.setMaterial(true);
    components = spellSerializor.serializeComponents(spell);
    assertEquals(7, components);

    spell.setFocus(true);
    components = spellSerializor.serializeComponents(spell);
    assertEquals(15, components);

    spell.setDivineFocus(true);
    components = spellSerializor.serializeComponents(spell);
    assertEquals(31, components);

    spell.setXpCost(true);
    components = spellSerializor.serializeComponents(spell);
    assertEquals(63, components);

    spell.setVerbal(false);
    spell.setMaterial(false);
    spell.setDivineFocus(false);
    components = spellSerializor.serializeComponents(spell);
    assertEquals(42, components);
  }

  @Test
  public void testSerializeCastingTime() throws Exception {
    String castingTime = spellSerializor.serializeCastingTime(CastingTime.ONE_STANDARD_ACTION);
    assertNotNull(castingTime);
    assertEquals("1 standard action", castingTime);

    castingTime = spellSerializor.serializeCastingTime(CastingTime.ONE_FREE_ACTION);
    assertNotNull(castingTime);
    assertEquals("1 free action", castingTime);

    castingTime = spellSerializor.serializeCastingTime(CastingTime.ONE_ROUND);
    assertNotNull(castingTime);
    assertEquals("1 round", castingTime);

    castingTime = spellSerializor.serializeCastingTime(CastingTime.ONE_MINUTE);
    assertNotNull(castingTime);
    assertEquals("1 minute", castingTime);

    castingTime = spellSerializor.serializeCastingTime(CastingTime.TEN_MINUTES);
    assertNotNull(castingTime);
    assertEquals("10 minutes", castingTime);

    castingTime = spellSerializor.serializeCastingTime(CastingTime.ONE_HOUR);
    assertNotNull(castingTime);
    assertEquals("1 hour", castingTime);

    castingTime = spellSerializor.serializeCastingTime(CastingTime.SPECIFIC);
    assertNotNull(castingTime);
    assertEquals("specific", castingTime);

    castingTime = spellSerializor.serializeCastingTime(CastingTime.NONE);
    assertNotNull(castingTime);
    assertEquals("", castingTime);
  }

  @Test
  public void testSerializeSpellResistance() throws Exception {
    String spellResistance = spellSerializor.serializeSpellResistance(SpellResistance.NO);
    assertNotNull(spellResistance);
    assertEquals("No", spellResistance);

    spellResistance = spellSerializor.serializeSpellResistance(SpellResistance.YES);
    assertNotNull(spellResistance);
    assertEquals("Yes", spellResistance);

    spellResistance = spellSerializor.serializeSpellResistance(SpellResistance.YES_HARMLESS);
    assertNotNull(spellResistance);
    assertEquals("Yes (harmless)", spellResistance);

    spellResistance = spellSerializor.serializeSpellResistance(SpellResistance.YES_OBJECT);
    assertNotNull(spellResistance);
    assertEquals("Yes (object)", spellResistance);

    spellResistance = spellSerializor.serializeSpellResistance(SpellResistance.YES_HARMLESS_OBJECT);
    assertNotNull(spellResistance);
    assertEquals("Yes (harmless, object)", spellResistance);

    spellResistance = spellSerializor.serializeSpellResistance(SpellResistance.NONE);
    assertNotNull(spellResistance);
    assertEquals("", spellResistance);

    spellResistance = spellSerializor.serializeSpellResistance(SpellResistance.SPECIFIC);
    assertNotNull(spellResistance);
    assertEquals("specific", spellResistance);
  }
}
