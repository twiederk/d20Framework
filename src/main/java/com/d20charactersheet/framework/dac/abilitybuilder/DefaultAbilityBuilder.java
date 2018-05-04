package com.d20charactersheet.framework.dac.abilitybuilder;

import com.d20charactersheet.framework.boc.model.Ability;

/**
 * Creates Ability instances out of the given AbilityConfig. No properties are required to create the Ability.
 */
public class DefaultAbilityBuilder implements AbilityBuilder {

  @Override
  public Ability createAbility(final AbilityConfig abilityConfig) {
    final Ability ability = newAbility(abilityConfig);
    fillAbility(ability, abilityConfig);
    return ability;
  }

  private Ability newAbility(final AbilityConfig abilityConfig) {
    Ability ability = new Ability();
    if (!abilityConfig.getClassname().equals(Ability.class.getSimpleName())) {
      final String classname = getClassname(abilityConfig);
      try {
        final Class<?> clazz = Class.forName(classname);
        final Object instance = clazz.newInstance();
        ability = (Ability) instance;
      } catch (final Exception exception) {
        exception.printStackTrace();
      }
    }
    return ability;
  }

  String getClassname(final AbilityConfig abilityConfig) {
    final String packageName = Ability.class.getPackage().getName();
    final StringBuilder classname = new StringBuilder();
    classname.append(packageName).append(".").append(abilityConfig.getClassname());
    return classname.toString();
  }

  void fillAbility(final Ability ability, final AbilityConfig abilityConfig) {
    ability.setId(abilityConfig.getId());
    ability.setAbilityType(abilityConfig.getAbilityType());
    ability.setName(abilityConfig.getName());
    ability.setDescription(abilityConfig.getDescription());
  }

  int getInt(final AbilityConfig abilityConfig, final String key) {
    final String value = abilityConfig.getProperties().get(key);
    return Integer.parseInt(value);
  }

  boolean getBoolean(final AbilityConfig abilityConfig, final String key) {
    final String value = abilityConfig.getProperties().get(key);
    return Boolean.parseBoolean(value);
  }

  Enum<?> getEnum(final AbilityConfig abilityConfig, final String key, final Enum<?>[] values) {
    final int id = getInt(abilityConfig, key);
    for (final Enum<?> enumElement : values) {
      if (enumElement.ordinal() == id) {
        return enumElement;
      }
    }
    throw new IllegalArgumentException("Can't determine " + values.getClass().getSimpleName() + " of id: " + id);
  }

}
