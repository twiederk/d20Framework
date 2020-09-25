package com.d20charactersheet.framework.dac.abilitybuilder

import com.d20charactersheet.framework.boc.model.Ability

/**
 * Creates Ability instances out of the given AbilityConfig. No properties are required to create the Ability.
 */
open class DefaultAbilityBuilder : AbilityBuilder {
    override fun createAbility(abilityConfig: AbilityConfig): Ability {
        val ability = newAbility(abilityConfig)
        fillAbility(ability, abilityConfig)
        return ability
    }

    private fun newAbility(abilityConfig: AbilityConfig): Ability {
        var ability = Ability()
        if (abilityConfig.classname != Ability::class.java.simpleName) {
            val classname = getClassname(abilityConfig)
            try {
                val clazz = Class.forName(classname)
                val instance = clazz.newInstance()
                ability = instance as Ability
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }
        return ability
    }

    fun getClassname(abilityConfig: AbilityConfig): String {
        val packageName = Ability::class.java.getPackage().name
        return packageName + "." + abilityConfig.classname
    }

    fun fillAbility(ability: Ability, abilityConfig: AbilityConfig) {
        ability.id = abilityConfig.id
        ability.abilityType = abilityConfig.abilityType
        ability.name = abilityConfig.name
        ability.description = abilityConfig.description
    }

    fun getInt(abilityConfig: AbilityConfig, key: String?): Int {
        val value = abilityConfig.properties[key]
        return value!!.toInt()
    }

    fun getBoolean(abilityConfig: AbilityConfig): Boolean {
        val value = abilityConfig.properties[SpelllistAbilityBuilder.KEY_ATTRIBUTE_BONUS_SPELL_SLOTS]
        return java.lang.Boolean.parseBoolean(value)
    }

}