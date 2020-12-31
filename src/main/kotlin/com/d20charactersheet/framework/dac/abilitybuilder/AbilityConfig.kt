@file:Suppress("unused")

package com.d20charactersheet.framework.dac.abilitybuilder

import com.d20charactersheet.framework.boc.model.AbilityType

/**
 * The AbilityConfig contains all information necessary to create a valid Ability instance. It is used in conjunction
 * with an AbilityBuilder to create an Ability instance. The AbilityBuild can be retrieve from the
 * AbilityBuilderFactory. The classname property is used to get the proper AbilityBuilder from the AbilityFactory. The
 * properties contain all information required by the AbilityBuilder to create the Ability.
 */
class AbilityConfig {

    internal var properties: MutableMap<String, String> = HashMap()

    /**
     * The id of the Ability.
     */
    var id = 0

    /**
     * The name of the Ability.
     */
    var name: String? = null

    /**
     * The description of the Ability.
     */
    var description: String? = null

    /**
     * The type of the Ability.
     */

    var abilityType: AbilityType? = null

    /**
     * The simple class name of the ability.
     */
    lateinit var classname: String

    /**
     * The properties required by the AbilityBuilder to create the Ability.
     *
     * @return The properties required by the AbilityBuilder to create the Ability.
     */
    fun getProperties(): Map<String, String> {
        return properties
    }

    /**
     * Sets the properties required to create the Ability.
     *
     * @param properties
     * The properties to create the Ability.
     */
    fun setProperties(properties: MutableMap<String, String>) {
        this.properties = properties
    }

    /**
     * Adds a single property necessary to create the Ability.
     *
     * @param key
     * The key to store the value of the ability property.
     * @param value
     * The value of the ability property.
     */
    fun addProperty(key: String, value: String) {
        properties[key] = value
    }

    /**
     * Reads the int value of the given property key. Throws IllegalArgumentException if property can't be found. Throws
     * ParseException if parsing the int value fails.
     *
     * @param propertyKey
     * The key of the property to read.
     *
     * @return The int value of the property.
     */
    fun readInt(propertyKey: String): Int {
        val rawValue = properties[propertyKey] ?: throw IllegalArgumentException("Can't find property: $propertyKey")
        return rawValue.toInt()
    }

    override fun toString(): String {
        return name!!
    }

}