package com.d20charactersheet.framework.dac.dao.util;

import com.d20charactersheet.framework.boc.model.CastingTime;
import com.d20charactersheet.framework.boc.model.Descriptor;
import com.d20charactersheet.framework.boc.model.Range;
import com.d20charactersheet.framework.boc.model.School;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.SpellResistance;
import com.d20charactersheet.framework.boc.model.SubSchool;

/**
 * Helper to serialize and deserialize the data of a spell from the persistance layer.
 */
public class SpellSerializor {

  /**
   * Deserialize school of spell from data.
   *
   * @param data
   *     The data to deserialize the school from.
   *
   * @return The school of the spell.
   */
  public School deserializeSchool(final String data) {
    String school = data;
    final int index = data.indexOf(' ');
    if (index > -1) {
      school = data.substring(0, index);
    }

    try {
      return School.valueOf(school.toUpperCase());
    } catch (final Exception exception) {
      return School.ABJURATION;
    }
  }

  /**
   * Deserialize sub school from data.
   *
   * @param data
   *     The data to deserialize the sub school from.
   *
   * @return The sub school of the spell.
   */
  public SubSchool deserializeSubSchool(final String data) {
    String subSchool = SubSchool.NONE.name();

    final int beginIndex = data.indexOf('(');
    final int endIndex = data.indexOf(')');
    if (beginIndex > -1) {
      subSchool = data.substring(beginIndex + 1, endIndex);
    }

    try {
      return SubSchool.valueOf(subSchool.toUpperCase());
    } catch (final Exception exception) {
      return SubSchool.NONE;
    }
  }

  /**
   * Deserialize descriptors from data.
   *
   * @param data
   *     The data to deserialize descriptors form.
   *
   * @return The descriptors.
   */
  public Descriptor[] deserializeDescriptors(final String data) {
    Descriptor[] descriptors = new Descriptor[] {Descriptor.NONE};

    final int beginIndex = data.indexOf('[');
    final int endIndex = data.indexOf(']');
    if (beginIndex > -1) {
      final String[] descriptorStrings = data.substring(beginIndex + 1, endIndex).split(",");
      descriptors = new Descriptor[descriptorStrings.length];
      for (int i = 0; i < descriptorStrings.length; i++) {
        try {
          descriptors[i] = Descriptor.valueOf(descriptorStrings[i].trim().toUpperCase() //
                                                  .replace('-', '_').replace(' ', '_'));
        } catch (final Exception exception) {
          return new Descriptor[] {Descriptor.NONE};
        }

      }
    }
    return descriptors;
  }

  /**
   * Deserialize casting time from data.
   *
   * @param data
   *     The data to deserialize the casting time from.
   *
   * @return The casting time.
   */
  public CastingTime deserializeCastingTime(final String data) {
    if ("1 standard action".equalsIgnoreCase(data)) {
      return CastingTime.ONE_STANDARD_ACTION;
    } else if ("1 free action".equalsIgnoreCase(data)) {
      return CastingTime.ONE_FREE_ACTION;
    } else if ("1 round".equalsIgnoreCase(data)) {
      return CastingTime.ONE_ROUND;
    } else if ("1 minute".equalsIgnoreCase(data)) {
      return CastingTime.ONE_MINUTE;
    } else if ("10 minutes".equalsIgnoreCase(data)) {
      return CastingTime.TEN_MINUTES;
    } else if ("1 hour".equalsIgnoreCase(data)) {
      return CastingTime.ONE_HOUR;
    } else if ("1 immediate action".equalsIgnoreCase(data)) {
      return CastingTime.ONE_IMMEDIATE_ACTION;
    } else if ("1 swift action".equalsIgnoreCase(data)) {
      return CastingTime.ONE_SWIFT_ACTION;
    } else if (data == null || "".equalsIgnoreCase(data)) {
      return CastingTime.NONE;
    } else {
      return CastingTime.SPECIFIC;
    }
  }

  /**
   * Deserialize range from data.
   *
   * @param data
   *     The data to deserialize from.
   *
   * @return The range.
   */
  public Range deserializeRange(final String data) {
    if ("Personal".equalsIgnoreCase(data)) {
      return Range.PERSONAL;
    } else if ("Touch".equalsIgnoreCase(data)) {
      return Range.TOUCH;
    } else if ("Close (25 ft. + 5 ft./2 levels)".equalsIgnoreCase(data)) {
      return Range.CLOSE;
    } else if ("Medium (100 ft. + 10 ft./level)".equalsIgnoreCase(data)) {
      return Range.MEDIUM;
    } else if ("Long (400 ft. + 40 ft./level)".equalsIgnoreCase(data)) {
      return Range.LONG;
    }
    return Range.SPECIFIC;
  }

  /**
   * Deserialize the spell resistance from.
   *
   * @param data
   *     The data to deserialize from.
   *
   * @return The spell resistance.
   */
  public SpellResistance deserializeSpellResistance(final String data) {
    if ("Yes".equalsIgnoreCase(data)) {
      return SpellResistance.YES;
    } else if ("No".equalsIgnoreCase(data)) {
      return SpellResistance.NO;
    } else if ("Yes (harmless)".equalsIgnoreCase(data)) {
      return SpellResistance.YES_HARMLESS;
    } else if ("Yes (object)".equalsIgnoreCase(data)) {
      return SpellResistance.YES_OBJECT;
    } else if ("Yes (harmless, object)".equalsIgnoreCase(data)) {
      return SpellResistance.YES_HARMLESS_OBJECT;
    } else if (data == null || "".equalsIgnoreCase(data)) {
      return SpellResistance.NONE;
    }
    return SpellResistance.SPECIFIC;
  }

  /**
   * Serialize school to string.
   *
   * @param spell
   *     The spell to serialize the school of.
   *
   * @return The serializable school as string.
   */
  public String serializeSchool(final Spell spell) {
    final StringBuilder output = new StringBuilder();
    output.append(getSchool(spell.getSchool()));
    output.append(getSubSchool(spell));
    output.append(getDescriptors(spell));
    return output.toString();
  }

  private String getSchool(final School school) {
    switch (school) {
      case ABJURATION:
        return "Abjuration";
      case CONJURATION:
        return "Conjuration";
      case DIVINATION:
        return "Divination";
      case ENCHANTMENT:
        return "Enchantment";
      case EVOCATION:
        return "Evocation";
      case ILLUSION:
        return "Illusion";
      case NECROMANCY:
        return "Necromancy";
      case TRANSMUTATION:
        return "Transmutation";
      case UNIVERSAL:
        return "Universal";
      default:
        throw new IllegalArgumentException("Can't determine school: " + school);
    }
  }

  private String getSubSchool(final Spell spell) {
    final SubSchool subSchool = spell.getSubSchool();

    final StringBuilder output = new StringBuilder();
    if (subSchool != null && !SubSchool.NONE.equals(subSchool)) {
      output.append(" (").append(getSubSchool(subSchool)).append(")");
    }
    return output.toString();
  }

  private String getSubSchool(final SubSchool subSchool) {
    switch (subSchool) {
      case CALLING:
        return "Calling";
      case CHARM:
        return "Charm";
      case COMPULSION:
        return "Complusion";
      case CREATION:
        return "Creation";
      case FIGMENT:
        return "Figment";
      case GLAMER:
        return "Glamer";
      case HEALING:
        return "Healing";
      case NONE:
        return "None";
      case PATTERN:
        return "Pattern";
      case PHANTASM:
        return "Phantasm";
      case POLYMORPH:
        return "Polymorph";
      case SCRYING:
        return "Scrying";
      case SHADOW:
        return "Shadow";
      case SUMMONING:
        return "Summoning";
      case TELEPORTATION:
        return "Teleportation";
      default:
        throw new IllegalArgumentException("Can't determine subschool: " + subSchool);
    }
  }

  private String getDescriptors(final Spell spell) {
    final Descriptor[] descriptors = spell.getDescriptors();

    final StringBuilder output = new StringBuilder();
    if (descriptors != null && descriptors.length > 0 && !(descriptors.length == 1 && Descriptor.NONE.equals(descriptors[0]))) {
      output.append(" [");
      for (int i = 0; i < descriptors.length; i++) {
        output.append(getDescriptor(descriptors[i]));
        if (i + 1 < descriptors.length) {
          output.append(", ");
        }
      }
      output.append("]");
    }
    return output.toString();
  }

  /**
   * Returns the serialized descriptor.
   *
   * @param descriptor
   *     The descriptor to serialize.
   *
   * @return The serialized descriptor.
   */
  public String getDescriptor(final Descriptor descriptor) {
    switch (descriptor) {
      case ACID:
        return "Acid";
      case AIR:
        return "Air";
      case CHAOTIC:
        return "Chaotic";
      case COLD:
        return "Cold";
      case DARKNESS:
        return "Darkness";
      case DEATH:
        return "Death";
      case EARTH:
        return "Earth";
      case ELECTRICITY:
        return "Electricity";
      case EVIL:
        return "Evil";
      case FEAR:
        return "Fear";
      case FIRE:
        return "Fire";
      case FORCE:
        return "Force";
      case GOOD:
        return "Good";
      case LANGUAGE_DEPENDENT:
        return "Language-Dependent";
      case LAWFUL:
        return "Lawful";
      case LIGHT:
        return "Light";
      case MIND_AFFECTING:
        return "Mind-Affecting";
      case NONE:
        return "None";
      case SONIC:
        return "Sonic";
      case WATER:
        return "Water";
      default:
        throw new IllegalArgumentException("Can't determine descriptor: " + descriptor);
    }
  }

  /**
   * Serialize components.
   *
   * @param spell
   *     The spell to serialize the components of.
   *
   * @return The serialized components.
   */
  public int serializeComponents(final Spell spell) {
    int components = 0;
    if (spell.isVerbal()) {
      components = components + 1;
    }
    if (spell.isSomatic()) {
      components = components + 2;
    }
    if (spell.isMaterial()) {
      components = components + 4;
    }
    if (spell.isFocus()) {
      components = components + 8;
    }
    if (spell.isDivineFocus()) {
      components = components + 16;
    }
    if (spell.isXpCost()) {
      components = components + 32;
    }
    return components;
  }

  /**
   * Serialize casting time to string.
   *
   * @param castingTime
   *     The casting time to serialize.
   *
   * @return The serializable string.
   */
  public String serializeCastingTime(final CastingTime castingTime) {
    switch (castingTime) {
      case ONE_STANDARD_ACTION:
        return "1 standard action";
      case ONE_FREE_ACTION:
        return "1 free action";
      case ONE_ROUND:
        return "1 round";
      case ONE_MINUTE:
        return "1 minute";
      case TEN_MINUTES:
        return "10 minutes";
      case ONE_HOUR:
        return "1 hour";
      case ONE_IMMEDIATE_ACTION:
        return "1 immediate action";
      case ONE_SWIFT_ACTION:
        return "1 swift action";
      case SPECIFIC:
        return "specific";
      case NONE:
        return "";
      default:
        throw new IllegalArgumentException("Can't determine casting time: " + castingTime);
    }

  }

  /**
   * Serialize rang to string.
   *
   * @param range
   *     The range to serialize.
   *
   * @return The string containing the serialized range.
   */
  public String serializeRange(final Range range) {
    switch (range) {
      case PERSONAL:
        return "Personal";
      case TOUCH:
        return "Touch";
      case CLOSE:
        return "Close (25 ft. + 5 ft./2 levels)";
      case MEDIUM:
        return "Medium (100 ft. + 10 ft./level)";
      case LONG:
        return "Long (400 ft. + 40 ft./level)";
      case SPECIFIC:
        return "specific";
      default:
        throw new IllegalArgumentException("Can't determine range: " + range);
    }
  }

  /**
   * Serialize spell resistance.
   *
   * @param spellResistance
   *     The spell resistance to serialize.
   *
   * @return The serialized spell resistance.
   */
  public String serializeSpellResistance(final SpellResistance spellResistance) {
    switch (spellResistance) {
      case YES:
        return "Yes";
      case NO:
        return "No";
      case YES_HARMLESS:
        return "Yes (harmless)";
      case YES_OBJECT:
        return "Yes (object)";
      case YES_HARMLESS_OBJECT:
        return "Yes (harmless, object)";
      case NONE:
        return "";
      case SPECIFIC:
        return "specific";
      default:
        throw new IllegalArgumentException("Can't determine spell resistance: " + spellResistance);
    }
  }
}
