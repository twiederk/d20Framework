package com.d20charactersheet.framework.dac.abilitybuilder

/**
 * The AbilityBuilderFactory administers AbilityBuilder. The AbilityBuilder must be registered first with their class
 * name and be retrieved from the factory later by class name.
 */
class AbilityBuilderFactory {

    private val abilityBuilders: MutableMap<String, AbilityBuilder> = HashMap()

    /**
     * Register an AbilityBuilder class.
     *
     * @param classname
     * The simple name of the AbilityBuilder class.
     * @param abilityBuilder
     * The instance of the AbilityBuilder.
     */
    fun registerAbilityBuilder(classname: String, abilityBuilder: AbilityBuilder) {
        abilityBuilders[classname] = abilityBuilder
    }

    /**
     * Returns a registered AbilityBuilder or throws IllegalArgumentException if none AbilityBuilder is registered for
     * given classname.
     *
     * @param classname
     * The simple name of the Ability to get an AbilityBuilder for.
     *
     * @return The AbilityBuilder for the given classname.
     */
    fun getAbilityBuilder(classname: String): AbilityBuilder {
        return abilityBuilders[classname]
                ?: throw IllegalArgumentException("Can't find AbilityBuilder for: $classname")
    }

}