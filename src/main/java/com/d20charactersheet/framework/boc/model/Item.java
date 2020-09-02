package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * Base class of items to extend from. Each item has a id, which is unique for the extend class, but not for all items.
 * Name, cost, weight, quality type and description are properties of all items.
 */
public abstract class Item implements Serializable {

  /**
   * An empty item
   */
  public static final Item EMPTY_ITEM = new EmptyItem();

  private static final long serialVersionUID = -7607921893077838072L;

  private int id;
  private String name;
  private float cost;
  private float weight;
  private QualityType qualityType;
  private String description;

  /**
   * Returns the id of the item. Unique only for the derived class.
   *
   * @return The id of the item. Unique only for the derived class.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id
   *     The id to set.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the name of the item.
   *
   * @return The name of the item.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the item.
   *
   * @param name
   *     The name of the item.
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Returns the weight of the item in lb.
   *
   * @return The weight of the item in lb.
   */
  public float getWeight() {
    return weight;
  }

  /**
   * Sets the weight in lb.
   *
   * @param weight
   *     The weight in lb.
   */
  public void setWeight(final float weight) {
    this.weight = weight;
  }

  /**
   * Returns the cost in gold pieces.
   *
   * @return The cost in gold pieces.
   */
  public float getCost() {
    return cost;
  }

  /**
   * Sets the cost in gold pieces.
   *
   * @param cost
   *     The cost in gold pieces.
   */
  public void setCost(final float cost) {
    this.cost = cost;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Item other = (Item) obj;
    return id == other.id;
  }

  @Override
  public String toString() {
    return name;
  }

  /**
   * Returns true, if item the quality of the item is magical.
   *
   * @return True, if item the quality of the item is magical.
   */
  public boolean isMagic() {
    return QualityType.MAGIC.equals(qualityType);
  }

  /**
   * Returns the description of the item.
   *
   * @return The description of the item.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description of the item.
   *
   * @param description
   *     The description of the item.
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Returns true, if quality of item is masterwork.
   *
   * @return True, if quality of item is masterwork.
   */
  public boolean isMasterwork() {
    return QualityType.MASTERWORK.equals(qualityType);
  }

  /**
   * Returns the quality type of the item.
   *
   * @return The quality type of the item.
   */
  public QualityType getQualityType() {
    return qualityType;
  }

  /**
   * Sets the quality type of the item.
   *
   * @param qualityType
   *     The quality type to set.
   */
  public void setQualityType(final QualityType qualityType) {
    this.qualityType = qualityType;
  }

  private static class EmptyItem extends Item {

    private static final long serialVersionUID = 1L;

    private EmptyItem() {
      super();
      setId(-1);
      setName("EMPTY ITEM");
      setCost(0.0f);
      setWeight(0.0f);
      setQualityType(QualityType.NORMAL);
      setDescription("");
    }
  }

}
