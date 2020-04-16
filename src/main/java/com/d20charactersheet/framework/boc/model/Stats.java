package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Stores the stats of a character.
 */
public class Stats implements Serializable {

  private static final long serialVersionUID = 9061928780273064490L;

  private String name;
  private String player;
  private Race race;
  private Sex sex;
  private List<ClassLevel> classLevels = new ArrayList<>();
  private Alignment alignment;
  private int imageId;
  private int thumbImageId;
  private XpTable xpTable;
  private int experiencePoints;

  /**
   * Returns the name.
   *
   * @return The name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name
   *     The name to set.
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Returns the player.
   *
   * @return The player.
   */
  public String getPlayer() {
    return player;
  }

  /**
   * Sets the player.
   *
   * @param player
   *     The player to set.
   */
  public void setPlayer(final String player) {
    this.player = player;
  }

  /**
   * Returns the race.
   *
   * @return The race.
   */
  public Race getRace() {
    return race;
  }

  /**
   * Sets the race.
   *
   * @param race
   *     The race to set.
   */
  public void setRace(final Race race) {
    this.race = race;
  }

  /**
   * Returns the sex.
   *
   * @return The sex.
   */
  public Sex getSex() {
    return sex;
  }

  /**
   * Sets the sex.
   *
   * @param sex
   *     The sex to set.
   */
  public void setSex(final Sex sex) {
    this.sex = sex;
  }

  /**
   * Returns the class levels.
   *
   * @return The class levels.
   */
  public List<ClassLevel> getClassLevels() {
    return classLevels;
  }

  /**
   * Sets the class levels.
   *
   * @param classLevels
   *     The class levels to set.
   */
  public void setClassLevels(final List<ClassLevel> classLevels) {
    this.classLevels = classLevels;
  }

  /**
   * Returns the alignment.
   *
   * @return The alignment.
   */
  public Alignment getAlignment() {
    return alignment;
  }

  /**
   * Sets the alignment.
   *
   * @param alignment
   *     The alignment to set.
   */
  public void setAlignment(final Alignment alignment) {
    this.alignment = alignment;
  }

  /**
   * Returns the id of the image.
   *
   * @return The id of the image.
   */
  public int getImageId() {
    return imageId;
  }

  /**
   * Sets the image id.
   *
   * @param imageId
   *     The image id.
   */
  public void setImageId(final int imageId) {
    this.imageId = imageId;
  }

  /**
   * Returns the id of the thumbnail image.
   *
   * @return The id of the thumbnail image.
   */
  public int getThumbImageId() {
    return thumbImageId;
  }

  /**
   * Sets the thumbnail image id.
   *
   * @param thumbImageId
   *     The thumbnail image id.
   */
  public void setThumbImageId(final int thumbImageId) {
    this.thumbImageId = thumbImageId;
  }

  /**
   * Returns the experience points.
   *
   * @return The experience points.
   */
  public int getExperiencePoints() {
    return experiencePoints;
  }

  /**
   * Sets the experience points.
   *
   * @param experiencePoints
   *     The experience points to set.
   */
  public void setExperiencePoints(final int experiencePoints) {
    this.experiencePoints = experiencePoints;
  }

  /**
   * Returns the xp table of the character.
   *
   * @return The xp table of the character.
   */
  public XpTable getXpTable() {
    return xpTable;
  }

  /**
   * Sets the xp table of the character.
   *
   * @param xpTable
   *     The xp table.
   */
  public void setXpTable(final XpTable xpTable) {
    this.xpTable = xpTable;
  }

}
