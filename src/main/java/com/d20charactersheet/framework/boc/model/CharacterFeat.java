package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * Feat owned by a character. Consists of a StaticFeat and a category. The category is only filled if the feat is
 * multiple but doesn't stack.
 */
public class CharacterFeat implements Serializable {

  private static final long serialVersionUID = 1L;

  private int id;
  private final Feat feat;
  private String category = "";

  /**
   * Instanciate CharacterFaet with given feat.
   *
   * @param feat
   *     The feat of the character feat
   */
  public CharacterFeat(final Feat feat) {
    this.feat = feat;
  }

  /**
   * Returns the unique id.
   *
   * @return The unique id.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the unique id.
   *
   * @param id
   *     The unique id.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the feat.
   *
   * @return The feat.
   */
  public Feat getFeat() {
    return feat;
  }

  /**
   * Returns the category of the feat.
   *
   * @return The category of the feat.
   */
  public String getCategory() {
    return category;
  }

  /**
   * Set the category of the feat.
   *
   * @param category
   *     The category to set.
   */
  public void setCategory(final String category) {
    this.category = category;
  }

  @Override
  public String toString() {
    return feat.getName() + "(" + category + ")";
  }

}
