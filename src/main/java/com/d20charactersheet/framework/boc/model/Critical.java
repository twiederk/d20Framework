package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * The chance to critical hit with a weapon and the according damage multiplier.
 */
public class Critical implements Serializable {

  private static final long serialVersionUID = 5363950771892678909L;

  private int hit;
  private int multiplier;

  /**
   * Creates an instance of Critical with hit and multiplier set to zero. This represents that no critical hits is
   * available.
   */
  public Critical() {
    this(0, 0);
  }

  /**
   * Create Critical with given hit and multiplier value.
   *
   * @param hit
   *     The value to roll to hit critical.
   * @param multiplier
   *     The value to multiply the rolled damage with.
   */
  public Critical(final int hit, final int multiplier) {
    super();
    this.hit = hit;
    this.multiplier = multiplier;
  }

  /**
   * Returns the number to roll at least with a d20 to critical hit.
   *
   * @return The number to roll at least with a d20 to critical hit.
   */
  public int getHit() {
    return hit;
  }

  /**
   * Sets the number to hit critical.
   *
   * @param hit
   *     The number to hit critical.
   */
  public void setHit(final int hit) {
    this.hit = hit;
  }

  /**
   * Returns the number to multiply the damage with.
   *
   * @return The number to multiply the damage with.
   */
  public int getMultiplier() {
    return multiplier;
  }

  /**
   * Sets the number to mulitply the damage with.
   *
   * @param multiplier
   *     The number to multiply the damage with.
   */
  public void setMultiplier(final int multiplier) {
    this.multiplier = multiplier;
  }

  @Override
  public String toString() {
    return hit + "/x" + multiplier;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + hit;
    result = prime * result + multiplier;
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
    final Critical other = (Critical) obj;
    if (hit != other.hit) {
      return false;
    }
    return multiplier == other.multiplier;
  }

}
