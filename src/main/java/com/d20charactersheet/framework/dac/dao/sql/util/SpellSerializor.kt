package com.d20charactersheet.framework.dac.dao.sql.util

import com.d20charactersheet.framework.boc.model.*

/**
 * Helper to serialize and deserialize the data of a spell from the persistance layer.
 */
class SpellSerializor {
    /**
     * Deserialize school of spell from data.
     *
     * @param data
     * The data to deserialize the school from.
     *
     * @return The school of the spell.
     */
    fun deserializeSchool(data: String): School {
        var school = data
        val index = data.indexOf(' ')
        if (index > -1) {
            school = data.substring(0, index)
        }
        return try {
            School.valueOf(school.uppercase())
        } catch (exception: Exception) {
            School.ABJURATION
        }
    }

    /**
     * Deserialize sub school from data.
     *
     * @param data
     * The data to deserialize the sub school from.
     *
     * @return The sub school of the spell.
     */
    fun deserializeSubSchool(data: String): SubSchool {
        var subSchool = SubSchool.NONE.name
        val beginIndex = data.indexOf('(')
        val endIndex = data.indexOf(')')
        if (beginIndex > -1) {
            subSchool = data.substring(beginIndex + 1, endIndex)
        }
        return try {
            SubSchool.valueOf(subSchool.uppercase())
        } catch (exception: Exception) {
            SubSchool.NONE
        }
    }

    /**
     * Deserialize descriptors from data.
     *
     * @param data
     * The data to deserialize descriptors form.
     *
     * @return The descriptors.
     */
    fun deserializeDescriptors(data: String): Array<Descriptor?> {
        var descriptors = arrayOf<Descriptor?>(Descriptor.NONE)
        val beginIndex = data.indexOf('[')
        val endIndex = data.indexOf(']')
        if (beginIndex > -1) {
            val descriptorStrings = data.substring(beginIndex + 1, endIndex).split(",".toRegex()).toTypedArray()
            descriptors = arrayOfNulls(descriptorStrings.size)
            for (i in descriptorStrings.indices) {
                try {
                    descriptors[i] = Descriptor.valueOf(
                        descriptorStrings[i].trim { it <= ' ' }.uppercase() //
                            .replace('-', '_').replace(' ', '_')
                    )
                } catch (exception: Exception) {
                    return arrayOf(Descriptor.NONE)
                }
            }
        }
        return descriptors
    }

    /**
     * Deserialize casting time from data.
     *
     * @param data
     * The data to deserialize the casting time from.
     *
     * @return The casting time.
     */
    fun deserializeCastingTime(data: String?): CastingTime {
        return if ("1 standard action".equals(data, ignoreCase = true)) {
            CastingTime.ONE_STANDARD_ACTION
        } else if ("1 free action".equals(data, ignoreCase = true)) {
            CastingTime.ONE_FREE_ACTION
        } else if ("1 round".equals(data, ignoreCase = true)) {
            CastingTime.ONE_ROUND
        } else if ("1 minute".equals(data, ignoreCase = true)) {
            CastingTime.ONE_MINUTE
        } else if ("10 minutes".equals(data, ignoreCase = true)) {
            CastingTime.TEN_MINUTES
        } else if ("1 hour".equals(data, ignoreCase = true)) {
            CastingTime.ONE_HOUR
        } else if ("1 immediate action".equals(data, ignoreCase = true)) {
            CastingTime.ONE_IMMEDIATE_ACTION
        } else if ("1 swift action".equals(data, ignoreCase = true)) {
            CastingTime.ONE_SWIFT_ACTION
        } else if (data == null || "".equals(data, ignoreCase = true)) {
            CastingTime.NONE
        } else {
            CastingTime.SPECIFIC
        }
    }

    /**
     * Deserialize the spell resistance from.
     *
     * @param data
     * The data to deserialize from.
     *
     * @return The spell resistance.
     */
    fun deserializeSpellResistance(data: String?): SpellResistance {
        if ("Yes".equals(data, ignoreCase = true)) {
            return SpellResistance.YES
        } else if ("No".equals(data, ignoreCase = true)) {
            return SpellResistance.NO
        } else if ("Yes (harmless)".equals(data, ignoreCase = true)) {
            return SpellResistance.YES_HARMLESS
        } else if ("Yes (object)".equals(data, ignoreCase = true)) {
            return SpellResistance.YES_OBJECT
        } else if ("Yes (harmless, object)".equals(data, ignoreCase = true)) {
            return SpellResistance.YES_HARMLESS_OBJECT
        } else if (data == null || "".equals(data, ignoreCase = true)) {
            return SpellResistance.NONE
        }
        return SpellResistance.SPECIFIC
    }

    /**
     * Serialize school to string.
     *
     * @param spell
     * The spell to serialize the school of.
     *
     * @return The serializable school as string.
     */
    fun serializeSchool(spell: Spell): String {
        return getSchool(spell.school) + getSubSchool(spell) + getDescriptors(spell)
    }

    private fun getSchool(school: School): String {
        return when (school) {
            School.ABJURATION -> "Abjuration"
            School.CONJURATION -> "Conjuration"
            School.DIVINATION -> "Divination"
            School.ENCHANTMENT -> "Enchantment"
            School.EVOCATION -> "Evocation"
            School.ILLUSION -> "Illusion"
            School.NECROMANCY -> "Necromancy"
            School.TRANSMUTATION -> "Transmutation"
            School.UNIVERSAL -> "Universal"
        }
    }

    private fun getSubSchool(spell: Spell): String {
        val subSchool = spell.subSchool
        val output = StringBuilder()
        if (subSchool != null && SubSchool.NONE != subSchool) {
            output.append(" (").append(getSubSchool(subSchool)).append(")")
        }
        return output.toString()
    }

    private fun getSubSchool(subSchool: SubSchool): String {
        return when (subSchool) {
            SubSchool.CALLING -> "Calling"
            SubSchool.CHARM -> "Charm"
            SubSchool.COMPULSION -> "Complusion"
            SubSchool.CREATION -> "Creation"
            SubSchool.FIGMENT -> "Figment"
            SubSchool.GLAMER -> "Glamer"
            SubSchool.HEALING -> "Healing"
            SubSchool.NONE -> "None"
            SubSchool.PATTERN -> "Pattern"
            SubSchool.PHANTASM -> "Phantasm"
            SubSchool.POLYMORPH -> "Polymorph"
            SubSchool.SCRYING -> "Scrying"
            SubSchool.SHADOW -> "Shadow"
            SubSchool.SUMMONING -> "Summoning"
            SubSchool.TELEPORTATION -> "Teleportation"
        }
    }

    private fun getDescriptors(spell: Spell): String {
        val descriptors = spell.descriptors
        val output = StringBuilder()
        if (descriptors != null && descriptors.isNotEmpty() && !(descriptors.size == 1 && Descriptor.NONE == descriptors[0])) {
            output.append(" [")
            for (i in descriptors.indices) {
                output.append(getDescriptor(descriptors[i]))
                if (i + 1 < descriptors.size) {
                    output.append(", ")
                }
            }
            output.append("]")
        }
        return output.toString()
    }

    /**
     * Returns the serialized descriptor.
     *
     * @param descriptor
     * The descriptor to serialize.
     *
     * @return The serialized descriptor.
     */
    private fun getDescriptor(descriptor: Descriptor): String {
        return when (descriptor) {
            Descriptor.ACID -> "Acid"
            Descriptor.AIR -> "Air"
            Descriptor.CHAOTIC -> "Chaotic"
            Descriptor.COLD -> "Cold"
            Descriptor.DARKNESS -> "Darkness"
            Descriptor.DEATH -> "Death"
            Descriptor.EARTH -> "Earth"
            Descriptor.ELECTRICITY -> "Electricity"
            Descriptor.EVIL -> "Evil"
            Descriptor.FEAR -> "Fear"
            Descriptor.FIRE -> "Fire"
            Descriptor.FORCE -> "Force"
            Descriptor.GOOD -> "Good"
            Descriptor.LANGUAGE_DEPENDENT -> "Language-Dependent"
            Descriptor.LAWFUL -> "Lawful"
            Descriptor.LIGHT -> "Light"
            Descriptor.MIND_AFFECTING -> "Mind-Affecting"
            Descriptor.NONE -> "None"
            Descriptor.SONIC -> "Sonic"
            Descriptor.WATER -> "Water"
        }
    }

    /**
     * Serialize components.
     *
     * @param spell
     * The spell to serialize the components of.
     *
     * @return The serialized components.
     */
    fun serializeComponents(spell: Spell): Int {
        var components = 0
        if (spell.isVerbal) {
            components += 1
        }
        if (spell.isSomatic) {
            components += 2
        }
        if (spell.isMaterial) {
            components += 4
        }
        if (spell.isFocus) {
            components += 8
        }
        if (spell.isDivineFocus) {
            components += 16
        }
        if (spell.isXpCost) {
            components += 32
        }
        return components
    }

    /**
     * Serialize casting time to string.
     *
     * @param castingTime
     * The casting time to serialize.
     *
     * @return The serializable string.
     */
    fun serializeCastingTime(castingTime: CastingTime): String {
        return when (castingTime) {
            CastingTime.ONE_STANDARD_ACTION -> "1 standard action"
            CastingTime.ONE_FREE_ACTION -> "1 free action"
            CastingTime.ONE_ROUND -> "1 round"
            CastingTime.ONE_MINUTE -> "1 minute"
            CastingTime.TEN_MINUTES -> "10 minutes"
            CastingTime.ONE_HOUR -> "1 hour"
            CastingTime.ONE_IMMEDIATE_ACTION -> "1 immediate action"
            CastingTime.ONE_SWIFT_ACTION -> "1 swift action"
            CastingTime.SPECIFIC -> "specific"
            CastingTime.NONE -> ""
        }
    }

    /**
     * Serialize spell resistance.
     *
     * @param spellResistance
     * The spell resistance to serialize.
     *
     * @return The serialized spell resistance.
     */
    fun serializeSpellResistance(spellResistance: SpellResistance): String {
        return when (spellResistance) {
            SpellResistance.YES -> "Yes"
            SpellResistance.NO -> "No"
            SpellResistance.YES_HARMLESS -> "Yes (harmless)"
            SpellResistance.YES_OBJECT -> "Yes (object)"
            SpellResistance.YES_HARMLESS_OBJECT -> "Yes (harmless, object)"
            SpellResistance.NONE -> ""
            SpellResistance.SPECIFIC -> "specific"
        }
    }
}