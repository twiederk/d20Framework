package com.d20charactersheet.framework.dac.abilitybuilder;

import java.util.HashMap;
import java.util.Map;

import com.d20charactersheet.framework.boc.model.AbilityType;

/**
 * The AbilityConfig contains all information necessary to create a valid Ability instance. It is used in conjunction
 * with an AbilityBuilder to create an Ability instance. The AbilityBuild can be retrieve from the
 * AbilityBuilderFactory. The classname property is used to get the proper AbilityBuilder from the AbilityFactory. The
 * properties contain all information required by the AbilityBuilder to create the Ability.
 */
public class AbilityConfig {

  private int id;
  private String name;
  private String description;
  private AbilityType abilityType;
  private String classname;
  private Map<String, String> properties;

  /**
   * Creates empty AbilityConfig.
   */
  public AbilityConfig() {
    super();
    properties = new HashMap<String, String>();
  }

  /**
   * The classname is the simple class name of the Ability to create. It is used to retrieve the proper AbilityBuilder
   * from the AbilityBuilderFactory.
   *
   * @return The classname of the Ability.
   */
  public String getClassname() {
    return classname;
  }

  /**
   * Sets the simple class name of the Ability.
   *
   * @param classname
   *     The simple class name of the ability.
   */
  public void setClassname(final String classname) {
    this.classname = classname;
  }

  /**
   * The properties required by the AbilityBuilder to create the Ability.
   *
   * @return The properties required by the AbilityBuilder to create the Ability.
   */
  public Map<String, String> getProperties() {
    return properties;
  }

  /**
   * Sets the properties required to create the Ability.
   *
   * @param properties
   *     The properties to create the Ability.
   */
  public void setProperties(final Map<String, String> properties) {
    this.properties = properties;
  }

  /**
   * Adds a single property necessary to create the Ability.
   *
   * @param key
   *     The key to store the value of the ability property.
   * @param value
   *     The value of the ability property.
   */
  public void addProperty(final String key, final String value) {
    properties.put(key, value);
  }

  /**
   * The id of the Ability.
   *
   * @return The id of the Ability.
   */
  public int getId() {
    return id;
  }

  /**
   * Returns the id of the Ability.
   *
   * @param id
   *     The id of the Ability.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the name of the Ability.
   *
   * @return The name of the Ability.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the Ability.
   *
   * @param name
   *     The name of the Ability.
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Returns the description of the Ability.
   *
   * @return The description of the Ability.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description of the Ability.
   *
   * @param description
   *     The description of the Ability.
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Returns the type of the Ability.
   *
   * @return The type of the Ability.
   */
  public AbilityType getAbilityType() {
    return abilityType;
  }

  /**
   * Sets the type of the Ability.
   *
   * @param abilityType
   *     The type of the Ability.
   */
  public void setAbilityType(final AbilityType abilityType) {
    this.abilityType = abilityType;
  }

  /**
   * Reads the int value of the given property key. Throws IllegalArgumentException if property can't be found. Throws
   * ParseException if parsing the int value fails.
   *
   * @param propertyKey
   *     The key of the property to read.
   *
   * @return The int value of the property.
   */
  public int readInt(final String propertyKey) {
    final String rawValue = properties.get(propertyKey);
    if (rawValue == null) {
      throw new IllegalArgumentException("Can't find property: " + propertyKey);
    }
    final int value = Integer.parseInt(rawValue);
    return value;
  }

  @Override
  public String toString() {
    return name;
  }
}
