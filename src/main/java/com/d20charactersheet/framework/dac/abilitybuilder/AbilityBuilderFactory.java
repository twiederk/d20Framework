package com.d20charactersheet.framework.dac.abilitybuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * The AbilityBuilderFactory administers AbilityBuilder. The AbilityBuilder must be registered first with their class
 * name and be retrieved from the factory later by class name.
 */
public class AbilityBuilderFactory {

  private final Map<String, AbilityBuilder> abilityBuilders;

  /**
   * Instanciates AbilityBuilderFactory with none AbilityBuilder registered.
   */
  public AbilityBuilderFactory() {
    this.abilityBuilders = new HashMap<>();
  }

  /**
   * Register an AbilityBuilder class.
   *
   * @param classname
   *     The simple name of the AbilityBuilder class.
   * @param abilityBuilder
   *     The instance of the AbilityBuilder.
   */
  public void registerAbilityBuilder(final String classname, final AbilityBuilder abilityBuilder) {
    abilityBuilders.put(classname, abilityBuilder);
  }

  /**
   * Returns a registered AbilityBuilder or throws IllegalArgumentException if none AbilityBuilder is registered for
   * given classname.
   *
   * @param classname
   *     The simple name of the Ability to get an AbilityBuilder for.
   *
   * @return The AbilityBuilder for the given classname.
   */
  public AbilityBuilder getAbilityBuilder(final String classname) {
    final AbilityBuilder abilityBuilder = abilityBuilders.get(classname);
    if (abilityBuilder == null) {
      throw new IllegalArgumentException("Can't find AbilityBuilder for: " + classname);
    }
    return abilityBuilder;
  }

}
