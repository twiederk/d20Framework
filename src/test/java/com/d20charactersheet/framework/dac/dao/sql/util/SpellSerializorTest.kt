package com.d20charactersheet.framework.dac.dao.sql.util

import com.d20charactersheet.framework.boc.model.*
import org.junit.Assert
import org.junit.jupiter.api.Test

class SpellSerializorTest {

    private val spellSerializor = SpellSerializor()

    @Test
    fun testDeserializeSchool() {
        var school = spellSerializor.deserializeSchool("Conjuration (Creation) [Acid]")
        Assert.assertNotNull(school)
        Assert.assertEquals(School.CONJURATION, school)
        school = spellSerializor.deserializeSchool("Enchantment")
        Assert.assertNotNull(school)
        Assert.assertEquals(School.ENCHANTMENT, school)
    }

    @Test
    fun testDeserializeSubSchool() {
        var subSchool = spellSerializor.deserializeSubSchool("Conjuration (Creation) [Acid]")
        Assert.assertNotNull(subSchool)
        Assert.assertEquals(SubSchool.CREATION, subSchool)
        subSchool = spellSerializor.deserializeSubSchool("Enchantment")
        Assert.assertNotNull(subSchool)
        Assert.assertEquals(SubSchool.NONE, subSchool)
        subSchool = spellSerializor.deserializeSubSchool("Conjuration (Creation or Calling)")
        Assert.assertNotNull(subSchool)
        Assert.assertEquals(SubSchool.NONE, subSchool)
    }

    @Test
    fun testSerializeSchool() {
        val spell = Spell()
        spell.school = School.CONJURATION
        var school = spellSerializor.serializeSchool(spell)
        Assert.assertNotNull(school)
        Assert.assertEquals("Conjuration", school)
        spell.subSchool = SubSchool.CREATION
        school = spellSerializor.serializeSchool(spell)
        Assert.assertNotNull(school)
        Assert.assertEquals("Conjuration (Creation)", school)
        spell.descriptors = arrayOf(Descriptor.ACID)
        school = spellSerializor.serializeSchool(spell)
        Assert.assertNotNull(school)
        Assert.assertEquals("Conjuration (Creation) [Acid]", school)
    }

    @Test
    fun testDeserializeDescriptors() {
        var descriptors = spellSerializor.deserializeDescriptors("Conjuration (Creation) [Acid]")
        Assert.assertNotNull(descriptors)
        Assert.assertEquals(descriptors.size.toLong(), 1)
        Assert.assertEquals(Descriptor.ACID, descriptors[0])
        descriptors = spellSerializor.deserializeDescriptors("Conjuration (Creation) [Acid,Air]")
        Assert.assertNotNull(descriptors)
        Assert.assertEquals(descriptors.size.toLong(), 2)
        Assert.assertEquals(Descriptor.ACID, descriptors[0])
        Assert.assertEquals(Descriptor.AIR, descriptors[1])
        descriptors = spellSerializor.deserializeDescriptors("Conjuration (Creation) [Acid ,Air]")
        Assert.assertNotNull(descriptors)
        Assert.assertEquals(descriptors.size.toLong(), 2)
        Assert.assertEquals(Descriptor.ACID, descriptors[0])
        Assert.assertEquals(Descriptor.AIR, descriptors[1])
        descriptors = spellSerializor.deserializeDescriptors("Conjuration (Creation) [Acid, Air]")
        Assert.assertNotNull(descriptors)
        Assert.assertEquals(descriptors.size.toLong(), 2)
        Assert.assertEquals(Descriptor.ACID, descriptors[0])
        Assert.assertEquals(Descriptor.AIR, descriptors[1])
        descriptors = spellSerializor.deserializeDescriptors("Conjuration (Creation) [Acid , Air]")
        Assert.assertNotNull(descriptors)
        Assert.assertEquals(descriptors.size.toLong(), 2)
        Assert.assertEquals(Descriptor.ACID, descriptors[0])
        Assert.assertEquals(Descriptor.AIR, descriptors[1])
        descriptors = spellSerializor.deserializeDescriptors("Illusion (Phantasm) [Fear, Mind-Affecting]")
        Assert.assertNotNull(descriptors)
        Assert.assertEquals(descriptors.size.toLong(), 2)
        Assert.assertEquals(Descriptor.FEAR, descriptors[0])
        Assert.assertEquals(Descriptor.MIND_AFFECTING, descriptors[1])
        descriptors = spellSerializor.deserializeDescriptors("Enchantment (Charm) [Language-Dependent, Mind-Affecting, Sonic]")
        Assert.assertNotNull(descriptors)
        Assert.assertEquals(descriptors.size.toLong(), 3)
        Assert.assertEquals(Descriptor.LANGUAGE_DEPENDENT, descriptors[0])
        Assert.assertEquals(Descriptor.MIND_AFFECTING, descriptors[1])
        Assert.assertEquals(Descriptor.SONIC, descriptors[2])
        descriptors = spellSerializor.deserializeDescriptors("Conjuration (Calling) [see text for lesser planar binding]")
        Assert.assertNotNull(descriptors)
        Assert.assertEquals(descriptors.size.toLong(), 1)
        Assert.assertEquals(Descriptor.NONE, descriptors[0])
    }

    @Test
    fun testDeserializeCastingTime() {
        var castingTime = spellSerializor.deserializeCastingTime("1 standard action")
        Assert.assertNotNull(castingTime)
        Assert.assertEquals(CastingTime.ONE_STANDARD_ACTION, castingTime)
        castingTime = spellSerializor.deserializeCastingTime("10 minutes")
        Assert.assertNotNull(castingTime)
        Assert.assertEquals(CastingTime.TEN_MINUTES, castingTime)
        castingTime = spellSerializor.deserializeCastingTime("1 round")
        Assert.assertNotNull(castingTime)
        Assert.assertEquals(CastingTime.ONE_ROUND, castingTime)
        castingTime = spellSerializor.deserializeCastingTime("1 minute")
        Assert.assertNotNull(castingTime)
        Assert.assertEquals(CastingTime.ONE_MINUTE, castingTime)
        castingTime = spellSerializor.deserializeCastingTime("1 hour")
        Assert.assertNotNull(castingTime)
        Assert.assertEquals(CastingTime.ONE_HOUR, castingTime)
        castingTime = spellSerializor.deserializeCastingTime("3 rounds")
        Assert.assertNotNull(castingTime)
        Assert.assertEquals(CastingTime.SPECIFIC, castingTime)
        castingTime = spellSerializor.deserializeCastingTime("24 hours")
        Assert.assertNotNull(castingTime)
        Assert.assertEquals(CastingTime.SPECIFIC, castingTime)
        castingTime = spellSerializor.deserializeCastingTime("See text")
        Assert.assertNotNull(castingTime)
        Assert.assertEquals(CastingTime.SPECIFIC, castingTime)
        castingTime = spellSerializor.deserializeCastingTime("30 minutes")
        Assert.assertNotNull(castingTime)
        Assert.assertEquals(CastingTime.SPECIFIC, castingTime)
        castingTime = spellSerializor.deserializeCastingTime(null)
        Assert.assertNotNull(castingTime)
        Assert.assertEquals(CastingTime.NONE, castingTime)
        castingTime = spellSerializor.deserializeCastingTime("")
        Assert.assertNotNull(castingTime)
        Assert.assertEquals(CastingTime.NONE, castingTime)
        castingTime = spellSerializor.deserializeCastingTime("1 free action")
        Assert.assertNotNull(castingTime)
        Assert.assertEquals(CastingTime.ONE_FREE_ACTION, castingTime)
        castingTime = spellSerializor.deserializeCastingTime("1 minute or longer; see text")
        Assert.assertNotNull(castingTime)
        Assert.assertEquals(CastingTime.SPECIFIC, castingTime)
    }

    @Test
    fun testDeserializeSpellResistance() {
        var spellResistance = spellSerializor.deserializeSpellResistance("Yes")
        Assert.assertNotNull(spellResistance)
        Assert.assertEquals(SpellResistance.YES, spellResistance)
        spellResistance = spellSerializor.deserializeSpellResistance("No")
        Assert.assertNotNull(spellResistance)
        Assert.assertEquals(SpellResistance.NO, spellResistance)
        spellResistance = spellSerializor.deserializeSpellResistance("Yes (harmless)")
        Assert.assertNotNull(spellResistance)
        Assert.assertEquals(SpellResistance.YES_HARMLESS, spellResistance)
        spellResistance = spellSerializor.deserializeSpellResistance("Yes (object)")
        Assert.assertNotNull(spellResistance)
        Assert.assertEquals(SpellResistance.YES_OBJECT, spellResistance)
        spellResistance = spellSerializor.deserializeSpellResistance("Yes (harmless, object)")
        Assert.assertNotNull(spellResistance)
        Assert.assertEquals(SpellResistance.YES_HARMLESS_OBJECT, spellResistance)
        spellResistance = spellSerializor.deserializeSpellResistance("See text")
        Assert.assertNotNull(spellResistance)
        Assert.assertEquals(SpellResistance.SPECIFIC, spellResistance)
        spellResistance = spellSerializor.deserializeSpellResistance("Yes; see text")
        Assert.assertNotNull(spellResistance)
        Assert.assertEquals(SpellResistance.SPECIFIC, spellResistance)
        spellResistance = spellSerializor.deserializeSpellResistance("")
        Assert.assertNotNull(spellResistance)
        Assert.assertEquals(SpellResistance.NONE, spellResistance)
        spellResistance = spellSerializor.deserializeSpellResistance(null)
        Assert.assertNotNull(spellResistance)
        Assert.assertEquals(SpellResistance.NONE, spellResistance)
    }

    @Test
    fun testSerializeComponents() {
        val spell = Spell()
        var components = spellSerializor.serializeComponents(spell)
        Assert.assertEquals(0, components.toLong())
        spell.isVerbal = true
        components = spellSerializor.serializeComponents(spell)
        Assert.assertEquals(1, components.toLong())
        spell.isSomatic = true
        components = spellSerializor.serializeComponents(spell)
        Assert.assertEquals(3, components.toLong())
        spell.isMaterial = true
        components = spellSerializor.serializeComponents(spell)
        Assert.assertEquals(7, components.toLong())
        spell.isFocus = true
        components = spellSerializor.serializeComponents(spell)
        Assert.assertEquals(15, components.toLong())
        spell.isDivineFocus = true
        components = spellSerializor.serializeComponents(spell)
        Assert.assertEquals(31, components.toLong())
        spell.isXpCost = true
        components = spellSerializor.serializeComponents(spell)
        Assert.assertEquals(63, components.toLong())
        spell.isVerbal = false
        spell.isMaterial = false
        spell.isDivineFocus = false
        components = spellSerializor.serializeComponents(spell)
        Assert.assertEquals(42, components.toLong())
    }

    @Test
    fun testSerializeCastingTime() {
        var castingTime = spellSerializor.serializeCastingTime(CastingTime.ONE_STANDARD_ACTION)
        Assert.assertNotNull(castingTime)
        Assert.assertEquals("1 standard action", castingTime)
        castingTime = spellSerializor.serializeCastingTime(CastingTime.ONE_FREE_ACTION)
        Assert.assertNotNull(castingTime)
        Assert.assertEquals("1 free action", castingTime)
        castingTime = spellSerializor.serializeCastingTime(CastingTime.ONE_ROUND)
        Assert.assertNotNull(castingTime)
        Assert.assertEquals("1 round", castingTime)
        castingTime = spellSerializor.serializeCastingTime(CastingTime.ONE_MINUTE)
        Assert.assertNotNull(castingTime)
        Assert.assertEquals("1 minute", castingTime)
        castingTime = spellSerializor.serializeCastingTime(CastingTime.TEN_MINUTES)
        Assert.assertNotNull(castingTime)
        Assert.assertEquals("10 minutes", castingTime)
        castingTime = spellSerializor.serializeCastingTime(CastingTime.ONE_HOUR)
        Assert.assertNotNull(castingTime)
        Assert.assertEquals("1 hour", castingTime)
        castingTime = spellSerializor.serializeCastingTime(CastingTime.SPECIFIC)
        Assert.assertNotNull(castingTime)
        Assert.assertEquals("specific", castingTime)
        castingTime = spellSerializor.serializeCastingTime(CastingTime.NONE)
        Assert.assertNotNull(castingTime)
        Assert.assertEquals("", castingTime)
    }

    @Test
    fun testSerializeSpellResistance() {
        var spellResistance = spellSerializor.serializeSpellResistance(SpellResistance.NO)
        Assert.assertNotNull(spellResistance)
        Assert.assertEquals("No", spellResistance)
        spellResistance = spellSerializor.serializeSpellResistance(SpellResistance.YES)
        Assert.assertNotNull(spellResistance)
        Assert.assertEquals("Yes", spellResistance)
        spellResistance = spellSerializor.serializeSpellResistance(SpellResistance.YES_HARMLESS)
        Assert.assertNotNull(spellResistance)
        Assert.assertEquals("Yes (harmless)", spellResistance)
        spellResistance = spellSerializor.serializeSpellResistance(SpellResistance.YES_OBJECT)
        Assert.assertNotNull(spellResistance)
        Assert.assertEquals("Yes (object)", spellResistance)
        spellResistance = spellSerializor.serializeSpellResistance(SpellResistance.YES_HARMLESS_OBJECT)
        Assert.assertNotNull(spellResistance)
        Assert.assertEquals("Yes (harmless, object)", spellResistance)
        spellResistance = spellSerializor.serializeSpellResistance(SpellResistance.NONE)
        Assert.assertNotNull(spellResistance)
        Assert.assertEquals("", spellResistance)
        spellResistance = spellSerializor.serializeSpellResistance(SpellResistance.SPECIFIC)
        Assert.assertNotNull(spellResistance)
        Assert.assertEquals("specific", spellResistance)
    }
}