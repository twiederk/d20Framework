package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * The XpTable stores the level and the according experience points.
 */
public class XpTable implements Serializable {

  private static final long serialVersionUID = 1L;

  private int id;
  private String name;
  private int[] levels;

  /**
   * Returns the id of the XpTable.
   *
   * @return The id of the XpTable.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id of the XpTable.
   *
   * @param id
   *     The id of the XpTable.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the name of the XpTable.
   *
   * @return The name of the XpTable.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the XpTable.
   *
   * @param name
   *     The name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Returns the table of experience points required by each level.
   *
   * @return The table of experience points required by each level.
   */
  public int[] getLevels() {
    return levels;
  }

  /**
   * Sets the table of experience points.
   *
   * @param levels
   *     The experience points for each level.
   */
  public void setLevelTable(final int[] levels) {
    this.levels = levels;
  }

  @Override
  public String toString() {
    return name;
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
    final XpTable other = (XpTable) obj;
    if (id != other.id) {
      return false;
    }
    return true;
  }

}
