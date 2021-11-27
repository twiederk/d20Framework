package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Stores the data of character, which is normally stored on a paper called character sheet.
 */
public class Character implements Serializable {

  private static final long serialVersionUID = 523118095407677467L;

  private int id = -1;

  private final Stats stats = new Stats();
  private final Attributes attributes = new Attributes();
  private final Combat combat = new Combat();
  private final Saves saves = new Saves();
  private List<CharacterSkill> characterSkills = new ArrayList<>();
  private List<CharacterFeat> characterFeats = new ArrayList<>();
  private Money money = new Money();
  private Equipment equipment = new Equipment();
  private List<Note> notes = new ArrayList<>();
  private List<WeaponAttack> weaponAttacks = new ArrayList<>();
  private List<KnownSpell> knownSpells = new ArrayList<>();
  private List<SpellSlot> spellSlots = new ArrayList<>();
  private Body body = new HumanoidBody();

  /**
   * Sets the spell slots.
   *
   * @param spellSlots
   *     The spell slots.
   */
  public void setSpellSlots(final List<SpellSlot> spellSlots) {
    this.spellSlots = spellSlots;
  }

  /**
   * Returns the database id of the character.
   *
   * @return The database id of the character.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the database if of the character.
   *
   * @param id
   *     The database id of the character.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the name of the character.
   *
   * @return The name of the character.
   */
  public String getName() {
    return stats.getName();
  }

  /**
   * Sets the name of the character.
   *
   * @param name
   *     The name of the character.
   */
  public void setName(final String name) {
    stats.setName(name);
  }

  /**
   * @see Object#toString()
   */
  @Override
  public String toString() {
    return stats.getName();
  }

  /**
   * Returns the name of the player of the character.
   *
   * @return The name of the player of the character.
   */
  public String getPlayer() {
    return stats.getPlayer();
  }

  /**
   * Sets the name of the player of the character.
   *
   * @param player
   *     The name of the player of the character.
   */
  public void setPlayer(final String player) {
    stats.setPlayer(player);
  }

  /**
   * Returns the race of the character.
   *
   * @return The race of the character.
   */
  public Race getRace() {
    return stats.getRace();
  }

  /**
   * Sets the race of the character.
   *
   * @param race
   *     The race of the character.
   */
  public void setRace(final Race race) {
    stats.setRace(race);
  }

  /**
   * List of all class levels of the character.
   *
   * @return All class levels of the character.
   */
  public List<ClassLevel> getClassLevels() {
    return stats.getClassLevels();
  }

  /**
   * Sets the class levels of the character.
   *
   * @param classLevels
   *     The class levels of the character.
   */
  public void setClassLevels(final List<ClassLevel> classLevels) {
    checkClassLevels(classLevels);
    stats.setClassLevels(classLevels);
  }

  void checkClassLevels(final List<ClassLevel> classLevels) {
    for (final ClassLevel classLevel : classLevels) {
      if (classLevel.getLevel() < 1) {
        throw new RuleException(RuleError.ZERO_OR_NEGATIVE_CLASS_LEVEL, classLevel);
      }
    }
  }

  /**
   * Returns the alignment of the character.
   *
   * @return The alignment of the character.
   */
  public Alignment getAlignment() {
    return stats.getAlignment();
  }

  /**
   * Sets the alignment of the character.
   *
   * @param alignment
   *     The alignment of the character.
   */
  public void setAlignment(final Alignment alignment) {
    stats.setAlignment(alignment);
  }

  /**
   * Returns the strength attribute value of the character.
   *
   * @return The strength attribute value of the character.
   */
  public int getStrength() {
    return attributes.getStrength();
  }

  /**
   * Sets the strength attribute value of the character.
   *
   * @param strength
   *     The Strengh attribute value of the character.
   */
  public void setStrength(final int strength) {
    checkAttributeValue(strength);
    attributes.setStrength(strength);
  }

  /**
   * Returns the dexterity attribute value of the character.
   *
   * @return The dexterity attribute value of the character.
   */
  public int getDexterity() {
    return attributes.getDexterity();
  }

  /**
   * Sets the dexterity attribute value of the character.
   *
   * @param dexterity
   *     The dexterity attribute value of the character.
   */
  public void setDexterity(final int dexterity) {
    checkAttributeValue(dexterity);
    attributes.setDexterity(dexterity);
  }

  /**
   * Returns the constitution attribute value of the character.
   *
   * @return The constitution attribute value of the character.
   */
  public int getConstitution() {
    return attributes.getConstitution();
  }

  /**
   * Sets the constitution attribute value of the character.
   *
   * @param constitution
   *     The constitution attribute value of the character.
   */
  public void setConstitution(final int constitution) {
    checkAttributeValue(constitution);
    attributes.setConstitution(constitution);
  }

  /**
   * Returns the intelligence attribute value of the character.
   *
   * @return The intelligence attribute value of the character.
   */
  public int getIntelligence() {
    return attributes.getIntelligence();
  }

  /**
   * Sets the intelligence attribute value of the character.
   *
   * @param intelligence
   *     The intelligence attribute value of the character.
   */
  public void setIntelligence(final int intelligence) {
    checkAttributeValue(intelligence);
    attributes.setIntelligence(intelligence);
  }

  /**
   * Returns the wisdom attribute value of the character.
   *
   * @return The wisdom attribute value of the character.
   */
  public int getWisdom() {
    return attributes.getWisdom();
  }

  /**
   * Sets the wisdom attribute value of the character.
   *
   * @param wisdom
   *     The wisdom attribute value of the character.
   */
  public void setWisdom(final int wisdom) {
    checkAttributeValue(wisdom);
    attributes.setWisdom(wisdom);
  }

  /**
   * Returns the charisma attribute value of the character.
   *
   * @return The charisma attribute value of the character.
   */
  public int getCharisma() {
    return attributes.getCharisma();
  }

  /**
   * Sets the charisma attribute value of the character.
   *
   * @param charisma
   *     The charisma attribute value of the character.
   */
  public void setCharisma(final int charisma) {
    checkAttributeValue(charisma);
    attributes.setCharisma(charisma);
  }

  /**
   * Returns the resource id of the image of the character.
   *
   * @return The resource id of the image of the character.
   */
  public int getImageId() {
    return stats.getImageId();
  }

  /**
   * Sets the resource id of the image of the character.
   *
   * @param imageId
   *     The id of the image of the character.
   */
  public void setImageId(final int imageId) {
    stats.setImageId(imageId);
  }

  /**
   * Returns the resource id of the image of the face of the character.
   *
   * @return The resource if of the image of the face of the character.
   */
  public int getThumbImageId() {
    return stats.getThumbImageId();
  }

  /**
   * Sets the resource id of the image of the face of the character.
   *
   * @param thumbImageId
   *     The id of the thumbnail of the character.
   */
  public void setThumbImageId(final int thumbImageId) {
    stats.setThumbImageId(thumbImageId);
  }

  /**
   * Returns the experience points of the character.
   *
   * @return The experience points of the character.
   */
  public int getExperiencePoints() {
    return stats.getExperiencePoints();
  }

  /**
   * Sets the experience points of the character.
   *
   * @param experiencePoint
   *     The experience points of the character.
   */
  public void setExperiencePoints(final int experiencePoint) {
    if (experiencePoint < 0) {
      throw new RuleException(RuleError.NEGATIVE_EXPERIENCE_POINTS);
    }
    stats.setExperiencePoints(experiencePoint);
  }

  /**
   * Returns the current hit points of the character.
   *
   * @return The current hit points of the character.
   */
  public int getHitPoints() {
    return combat.getHitPoints();
  }

  /**
   * Sets the current hit points of the character.
   *
   * @param hitPoints
   *     The current hit points of the character.
   */
  public void setHitPoints(final int hitPoints) {
    combat.setHitPoints(hitPoints);
  }

  /**
   * Returns the maximum hit points of the character.
   *
   * @return The maximum hit points of the character.
   */
  public int getMaxHitPoints() {
    return combat.getMaxHitPoints();
  }

  /**
   * Sets the maximum hit points of the character.
   *
   * @param maxHitPoints
   *     The maximum hit points of the character.
   */
  public void setMaxHitPoints(final int maxHitPoints) {
    combat.setMaxHitPoints(maxHitPoints);
  }

  /**
   * Returns the armor class of the character.
   *
   * @return The armor class of the character.
   */
  public int getArmorClass() {
    return combat.getArmorClass();
  }

  /**
   * Sets the armor class of the character.
   *
   * @param armorClass
   *     The armor of the character.
   */
  public void setArmorClass(final int armorClass) {
    combat.setArmorClass(armorClass);
  }

  /**
   * Returns the character level of the character. The character level is the total of all class levels.
   *
   * @return The character level of the character.
   */
  public int getCharacterLevel() {
    int characterLevel = 0;
    for (final ClassLevel classLevel : stats.getClassLevels()) {
      characterLevel += classLevel.getLevel();
    }
    return characterLevel;
  }

  private void checkAttributeValue(final int attributeValue) {
    if (attributeValue <= 0 || attributeValue >= 100) {
      throw new RuleException(RuleError.ATTRIBUTE_VALUE_NOT_IN_RANGE, attributeValue);
    }
  }

  /**
   * Returns the sex of the character.
   *
   * @return The sex of the character.
   */
  public Sex getSex() {
    return stats.getSex();
  }

  /**
   * Set the sex of the character.
   *
   * @param sex
   *     The sex to sex.
   */
  public void setSex(final Sex sex) {
    stats.setSex(sex);
  }

  /**
   * Returns skills of character.
   *
   * @return Skills of character.
   */
  public List<CharacterSkill> getCharacterSkills() {
    return characterSkills;
  }

  /**
   * Sets the skills of the character.
   *
   * @param characterSkill
   *     The list of all skills of the character.
   */
  public void setCharacterSkills(final List<CharacterSkill> characterSkill) {
    this.characterSkills = characterSkill;
  }

  /**
   * Returns the modifier of initiative.
   *
   * @return The modifier of initiative.
   */
  public int getInitiativeModifier() {
    return combat.getInitiativeModifier();
  }

  /**
   * Sets the modifier of initiative.
   *
   * @param initiativeModifier
   *     The modifier of initiative.
   */
  public void setInitiativeModifier(final int initiativeModifier) {
    combat.setInitiativeModifier(initiativeModifier);
  }

  /**
   * Returns the modifier of the cmb.
   *
   * @return The modifier of the cmb.
   */
  public int getCmbModifier() {
    return combat.getCmbModifier();
  }

  /**
   * Sets the modifier of the cmb.
   *
   * @param cmbModifier
   *     The modifier to set.
   */
  public void setCmbModifier(final int cmbModifier) {
    combat.setCmbModifier(cmbModifier);
  }

  /**
   * Returns the Combat Maneuver Defence modifier.
   *
   * @return The Combat Maneuver Defence modifier.
   */
  public int getCmdModifier() {
    return combat.getCmdModifier();
  }

  /**
   * Sets the Combat Modifier Defence modifier.
   *
   * @param cmdModifier
   *     The Combat Modifier Defence modifier.
   */
  public void setCmdModifier(final int cmdModifier) {
    combat.setCmdModifier(cmdModifier);
  }

  /**
   * Returns modifier of given save.
   *
   * @param save
   *     The save to return the modifier of.
   *
   * @return The save modifier.
   */
  public int getSaveModifier(Save save) {
    return saves.getSaveModifier(save);
  }

  /**
   * Sets the modifier for the given save.
   *
   * @param save
   *     The save to set the modifier of.
   * @param modifier
   *     The modifier to set.
   */
  public void setSaveModifier(Save save, int modifier) {
    saves.setSaveModifier(save, modifier);
  }

  /**
   * Only id of character is important.
   *
   * @see Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  /**
   * Only id of character is important.
   *
   * @see Object#equals(Object)
   */
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
    final Character other = (Character) obj;
    return id == other.id;
  }

  /**
   * Returns the feats of the character.
   *
   * @return The feats of the character.
   */
  public List<CharacterFeat> getCharacterFeats() {
    return characterFeats;
  }

  /**
   * Sets the feats of the character.
   *
   * @param characterFeats
   *     The character feats to set.
   */
  public void setCharacterFeats(final List<CharacterFeat> characterFeats) {
    this.characterFeats = characterFeats;
  }

  /**
   * Returns the money of the character.
   *
   * @return The money of the character.
   */
  public Money getMoney() {
    return money;
  }

  /**
   * Sets the money of the character.
   *
   * @param money
   *     The money of the character.
   */
  public void setMoney(final Money money) {
    this.money = money;
  }

  /**
   * Sets the equipment of the character.
   *
   * @param equipment
   *     The equipment.
   */
  public void setEquipment(final Equipment equipment) {
    this.equipment = equipment;
  }

  /**
   * Returns the equipment of the character.
   *
   * @return The equipment of the character.
   */
  public Equipment getEquipment() {
    return equipment;
  }

  /**
   * Returns the notes of the character.
   *
   * @return The notes of the character.
   */
  public List<Note> getNotes() {
    return notes;
  }

  /**
   * Sets the notes of the character.
   *
   * @param notes
   *     The notes of the character.
   */
  public void setNotes(final List<Note> notes) {
    this.notes = notes;
  }

  /**
   * Returns all classes of the character.
   *
   * @return All classes of the character.
   */
  public List<CharacterClass> getCharacterClasses() {
    final List<ClassLevel> classLevels = stats.getClassLevels();
    final List<CharacterClass> characterClasses = new ArrayList<>(classLevels.size());
    for (final ClassLevel classLevel : classLevels) {
      characterClasses.add(classLevel.getCharacterClass());
    }
    return characterClasses;
  }

  /**
   * Returns the active abilities of the character. Active abilities are all race abilities and class abilities which
   * are allowed by the current class level of the character and is owned by the character.
   *
   * @return The activie abilities of the character.
   */
  public List<Ability> getActiveAbilities() {
    final List<Ability> abilities = new ArrayList<>();
    final List<Ability> classAbilities = getClassAbilities();
    abilities.addAll(classAbilities);
    abilities.addAll(stats.getRace().getAbilities());
    return abilities;
  }

  /**
   * Returns active class abilities of the character. Class ability is active if character has proper class level and
   * owns the ability.
   *
   * @return Active class abilities.
   */
  public List<Ability> getClassAbilities() {
    final List<Ability> classAbilities = new ArrayList<>();
    for (final ClassLevel classLevel : stats.getClassLevels()) {
      final int level = classLevel.getLevel();
      for (final CharacterAbility characterAbility : classLevel.getCharacterAbilities()) {
        if (characterAbility.isOwned() && characterAbility.getClassAbility().getLevel() <= level) {
          classAbilities.add(characterAbility.getClassAbility().getAbility());
        }
      }
    }
    return classAbilities;
  }

  /**
   * Returns the race abilities of the character.
   *
   * @return The race abilities of the character.
   */
  public List<Ability> getRaceAbilities() {
    return stats.getRace().getAbilities();
  }

  /**
   * Returns all abilities of the character, containing all abilities of its race and all class abilities active and
   * inactive.
   *
   * @return All abilities of the character.
   */
  public List<Ability> getAllAbilities() {
    final List<Ability> allAbilities = new ArrayList<>(stats.getRace().getAbilities());
    for (final CharacterClass characterClass : getCharacterClasses()) {
      for (final ClassAbility classAbility : characterClass.getClassAbilities()) {
        allAbilities.add(classAbility.getAbility());
      }
    }
    return allAbilities;
  }

  /**
   * Returns the active spell lists of the character. Spell lists are active if they are from a race ability or an
   * active class abilitiy.
   *
   * @return The active spell lists of the character.
   */
  public List<Spelllist> getSpelllists() {
    final List<Spelllist> spelllists = new LinkedList<>();
    for (final SpelllistAbility spelllistAbility : getSpelllistAbilities()) {
      final Spelllist spelllist = spelllistAbility.getSpelllist();
      if (!spelllists.contains(spelllist)) {
        spelllists.add(spelllist);
      }

    }
    return spelllists;
  }

  /**
   * Returns the weapon attacks of the character.
   *
   * @return The weapon attacks.
   */
  public List<WeaponAttack> getWeaponAttacks() {
    return weaponAttacks;
  }

  /**
   * Sets the weapon attacks of the character.
   *
   * @param weaponAttacks
   *     The weapon attacks to set.
   */
  public void setWeaponAttacks(final List<WeaponAttack> weaponAttacks) {
    this.weaponAttacks = weaponAttacks;
  }

  /**
   * Sets the spells marked by the character.
   *
   * @param knownSpells
   *     The spells marked by the character.
   */
  public void setKnownSpells(final List<KnownSpell> knownSpells) {
    this.knownSpells = knownSpells;
  }

  /**
   * Returns the xp table of the character.
   *
   * @return The xp table of the character.
   */
  public XpTable getXpTable() {
    return stats.getXpTable();
  }

  /**
   * Sets the xp table of the character.
   *
   * @param xpTable
   *     The xp table of the character.
   */
  public void setXpTable(final XpTable xpTable) {
    stats.setXpTable(xpTable);
  }

  /**
   * Returns the active spell list abilities of the character.
   *
   * @return The active spell list abilities of the character.
   */
  public List<SpelllistAbility> getSpelllistAbilities() {
    final List<SpelllistAbility> spellAbilities = new LinkedList<>();
    for (final Ability ability : getActiveAbilities()) {
      if (ability instanceof SpelllistAbility) {
        final SpelllistAbility spelllistAbility = (SpelllistAbility) ability;
        spellAbilities.add(spelllistAbility);
      }
    }
    return spellAbilities;
  }

  /**
   * Returns the attribute value of the given attribute.
   *
   * @param attribute
   *     The attribute to get the value of.
   *
   * @return The value of the attribute.
   */
  public int getAttribute(final Attribute attribute) {
    return attributes.getAttribute(attribute);
  }

  /**
   * Returns all known spells of the character.
   *
   * @return All known spells of the character.
   */
  public List<KnownSpell> getKnownSpells() {
    return knownSpells;
  }

  /**
   * Returns the known spells of the given spell list.
   *
   * @param spelllist
   *     The spell list to get the known spells of.
   *
   * @return The known spells of the given spell list.
   */
  public List<KnownSpell> getKnownSpells(final Spelllist spelllist) {
    final List<KnownSpell> spells = new LinkedList<>();
    for (final KnownSpell knownSpell : knownSpells) {
      if (knownSpell.getSpelllist().equals(spelllist)) {
        spells.add(knownSpell);
      }
    }
    return spells;
  }

  /**
   * Returns the spell slots of the character.
   *
   * @return The spell slots of the character.
   */
  public List<SpellSlot> getSpellSlots() {
    return spellSlots;
  }

  /**
   * Returns the metamagic feats of the character.
   *
   * @return The metamagic feats of the character.
   */
  public List<Feat> getMetamagicFeats() {
    final List<Feat> metamagicFeats = new LinkedList<>();
    for (final CharacterFeat characterFeat : characterFeats) {
      final Feat feat = characterFeat.getFeat();
      if (FeatType.METAMAGIC.equals(feat.getFeatType())) {
        metamagicFeats.add(feat);
      }
    }
    return metamagicFeats;
  }

  /**
   * Returns the body of the character.
   *
   * @return The body of the character.
   */
  public Body getBody() {
    return body;
  }

  /**
   * Sets the body of the character.
   *
   * @param body
   *     The body of the character to set.
   */
  public void setBody(Body body) {
    this.body = body;
  }

  /**
   * Returns the equipped items of the character.
   *
   * @return The equipped items of the character.
   */
  public List<Item> getEquippedItems() {
    return body.getEquippedItems();
  }
}
