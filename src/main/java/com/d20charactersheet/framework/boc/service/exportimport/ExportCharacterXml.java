package com.d20charactersheet.framework.boc.service.exportimport;

import java.io.File;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.d20charactersheet.framework.boc.model.Attribute;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterAbility;
import com.d20charactersheet.framework.boc.model.CharacterFeat;
import com.d20charactersheet.framework.boc.model.CharacterSkill;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.Equipment;
import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.boc.model.ItemGroup;
import com.d20charactersheet.framework.boc.model.KnownSpell;
import com.d20charactersheet.framework.boc.model.Note;
import com.d20charactersheet.framework.boc.model.SpellSlot;
import com.d20charactersheet.framework.boc.model.SpelllistAbility;
import com.d20charactersheet.framework.boc.model.WeaponAttack;

/**
 * Exports characters to a xml file.
 */
public class ExportCharacterXml extends XmlExport implements ExportCharacter {

  private static final String VERSION = "2";

  private Character character;

  @Override
  public void exportCharacters(final String gameSystemName, final File exportFile, final List<Character> characters)
      throws Exception {
    createDocument();

    // create characters element
    final Element charactersElement = document.createElement(TAG_CHARACTERS);
    charactersElement.setAttribute(ATTRIBUTE_VERSION, VERSION);
    charactersElement.setAttribute(ATTRIBUTE_GAMESYSTEM, gameSystemName);
    document.appendChild(charactersElement);

    // create charater elements
    for (final Character character : characters) {
      this.character = character;
      charactersElement.appendChild(createCharacter());
    }

    // write XML file
    final PrintStream printStream = new PrintStream(exportFile);
    write(printStream, DTD_CHARACTERS_SYSTEM, DTD_CHARACTERS_PUBLIC);

  }

  private Node createCharacter() {
    final Element characterElement = document.createElement(TAG_CHARACTER);
    characterElement.appendChild(createAppearance());
    characterElement.appendChild(createAttributes());
    characterElement.appendChild(createCombat());
    characterElement.appendChild(createSaves());
    characterElement.appendChild(createMoney());
    characterElement.appendChild(createNotes());
    characterElement.appendChild(createAttacks());
    characterElement.appendChild(createSkills());
    characterElement.appendChild(createFeats());
    characterElement.appendChild(createKnownSpells());
    characterElement.appendChild(createSpellSlots());
    characterElement.appendChild(createEquipment());
    return characterElement;

  }

  private Node createAppearance() {
    final Element appearanceElement = document.createElement(TAG_APPEARANCE);
    appearanceElement.appendChild(createElementWithText(TAG_NAME, character.getName()));
    appearanceElement.appendChild(createElementWithText(TAG_PLAYER, character.getPlayer()));
    appearanceElement.appendChild(createElementWithText(TAG_RACE, character.getRace().getName()));
    appearanceElement.appendChild(createElementWithText(TAG_SEX, character.getSex().name()));
    appearanceElement.appendChild(createClassLevels());
    appearanceElement.appendChild(createElementWithText(TAG_ALIGNMENT, character.getAlignment().name()));
    appearanceElement.appendChild(createElementWithText(TAG_XPPOINTS, character.getExperiencePoints()));
    appearanceElement.appendChild(createElementWithText(TAG_XPTABLEID, character.getXpTable().getId()));
    return appearanceElement;
  }

  private Node createClassLevels() {
    final Element classLevelsElement = document.createElement(TAG_CLASSLEVELS);
    for (final ClassLevel classLevel : character.getClassLevels()) {
      final Element classLevelElement = createClassLevel(classLevel);
      createCharacterAbilities(classLevel, classLevelElement);
      classLevelsElement.appendChild(classLevelElement);
    }
    return classLevelsElement;
  }

  private Element createClassLevel(final ClassLevel classLevel) {
    final Element classLevelElement = document.createElement(TAG_CLASSLEVEL);
    classLevelElement.appendChild(createElementWithText(TAG_CLASS, classLevel.getCharacterClass().getName()));
    classLevelElement.appendChild(createElementWithText(TAG_LEVEL, classLevel.getLevel()));
    return classLevelElement;
  }

  private void createCharacterAbilities(final ClassLevel classLevel, final Element classLevelElement) {
    final Element classAbilitiesElement = document.createElement(TAG_CLASSABILITIES);

    for (final CharacterAbility characterAbility : classLevel.getCharacterAbilities()) {
      final Element classAbilityElement = document.createElement(TAG_CLASSABILITY);

      final String name = characterAbility.getClassAbility().getAbility().getName();
      final String owned = Boolean.toString(characterAbility.isOwned());

      classAbilityElement.setAttribute(ATTRIBUTE_NAME, name);
      classAbilityElement.setAttribute(ATTRIBUTE_OWNED, owned);
      classAbilitiesElement.appendChild(classAbilityElement);
    }
    classLevelElement.appendChild(classAbilitiesElement);
  }

  private Node createAttributes() {
    final Element attributesElement = document.createElement(TAG_ATTRIBUTES);
    for (final Attribute attribute : Attribute.values()) {
      final Element attributeElement = document.createElement(TAG_ATTRIBUTE);
      attributeElement.setAttribute(ATTRIBUTE_NAME, attribute.name());
      final String value = Integer.toString(getAttributeValue(attribute));
      attributeElement.setAttribute(ATTRIBUTE_VALUE, value);
      attributesElement.appendChild(attributeElement);
    }
    return attributesElement;
  }

  private int getAttributeValue(final Attribute attribute) {
    switch (attribute) {
      case STRENGTH:
        return character.getStrength();
      case DEXTERITY:
        return character.getDexterity();
      case CONSTITUTION:
        return character.getConstitution();
      case INTELLIGENCE:
        return character.getIntelligence();
      case WISDOM:
        return character.getWisdom();
      case CHARISMA:
        return character.getCharisma();
      default:
        throw new IllegalArgumentException("Can't determine value of attribute: " + attribute);
    }
  }

  private Node createCombat() {
    final Element combatElement = document.createElement(TAG_COMBAT);
    combatElement.appendChild(createElementWithText(TAG_HITPOINTS, character.getHitPoints()));
    combatElement.appendChild(createElementWithText(TAG_MAXHITPOINTS, character.getMaxHitPoints()));
    combatElement.appendChild(createElementWithText(TAG_ARMORMOD, character.getArmorClass()));
    combatElement.appendChild(createElementWithText(TAG_INITATIVEMOD, character.getInitiativeModifier()));
    combatElement.appendChild(createElementWithText(TAG_CMBMOD, character.getCmbModifier()));
    combatElement.appendChild(createElementWithText(TAG_CMDMOD, character.getCmdModifier()));
    return combatElement;
  }

  private Node createSaves() {
    final Element savesElement = document.createElement(TAG_SAVES);
    savesElement.appendChild(createElementWithText(TAG_FORTIFYMOD, character.getFortitudeModifier()));
    savesElement.appendChild(createElementWithText(TAG_REFLEXMOD, character.getReflexModifier()));
    savesElement.appendChild(createElementWithText(TAG_WILLMOD, character.getWillModifier()));
    return savesElement;
  }

  private Node createMoney() {
    final Element moneyElement = document.createElement(TAG_MONEY);
    moneyElement.appendChild(createElementWithText(TAG_PLATINUM, character.getMoney().getPlatinum()));
    moneyElement.appendChild(createElementWithText(TAG_GOLD, character.getMoney().getGold()));
    moneyElement.appendChild(createElementWithText(TAG_SILVER, character.getMoney().getSilver()));
    moneyElement.appendChild(createElementWithText(TAG_COPPER, character.getMoney().getCopper()));
    return moneyElement;
  }

  private Node createNotes() {
    final Element notesElement = document.createElement(TAG_NOTES);
    final SimpleDateFormat formatter = new SimpleDateFormat(PATTERN_DATETIME);
    for (final Note note : character.getNotes()) {
      final Element noteElement = createNote(note, formatter);
      notesElement.appendChild(noteElement);
    }
    return notesElement;
  }

  private Element createNote(final Note note, final DateFormat formatter) {
    final Element noteElement = document.createElement(TAG_NOTE);
    noteElement.appendChild(createElementWithText(TAG_DATE, formatter.format(note.getDate())));
    noteElement.appendChild(createElementWithText(TAG_TEXT, note.getText()));
    return noteElement;
  }

  private Node createAttacks() {
    final Node attacksElement = document.createElement(TAG_ATTACKS);
    for (final WeaponAttack weaponAttack : character.getWeaponAttacks()) {
      final Node attackElement = createAttack(weaponAttack);
      attacksElement.appendChild(attackElement);
    }
    return attacksElement;
  }

  private Node createAttack(final WeaponAttack weaponAttack) {
    final Node attackElement = document.createElement(TAG_ATTACK);
    attackElement.appendChild(createElementWithText(TAG_NAME, weaponAttack.getName()));
    attackElement.appendChild(createElementWithText(TAG_DESCRIPTION, weaponAttack.getDescription()));
    attackElement.appendChild(createElementWithText(TAG_ATTACKWIELD, weaponAttack.getAttackWield().name()));
    attackElement.appendChild(createElementWithText(TAG_ATTACKWEAPON, weaponAttack.getWeapon().getName()));
    attackElement.appendChild(createElementWithText(TAG_ATTACKBONUSMOD, weaponAttack.getAttackBonusModifier()));
    attackElement.appendChild(createElementWithText(TAG_DAMAGEBONUSMOD, weaponAttack.getDamageBonusModifier()));
    return attackElement;
  }

  private Node createSkills() {
    final Node skillsElement = document.createElement(TAG_SKILLS);
    for (final CharacterSkill characterSkill : character.getCharacterSkills()) {
      if (characterSkill.getRank() != 0.0f || characterSkill.getModifier() != 0) {
        final Node skillElement = createSkill(characterSkill);
        skillsElement.appendChild(skillElement);
      }
    }
    return skillsElement;
  }

  private Node createSkill(final CharacterSkill characterSkill) {
    final Node skillElement = document.createElement(TAG_SKILL);
    skillElement.appendChild(createElementWithText(TAG_NAME, characterSkill.getSkill().getName()));
    skillElement.appendChild(createElementWithText(TAG_RANK, characterSkill.getRank()));
    skillElement.appendChild(createElementWithText(TAG_SKILLMOD, characterSkill.getModifier()));
    return skillElement;
  }

  private Node createFeats() {
    final Node featsElement = document.createElement(TAG_FEATS);
    for (final CharacterFeat characterFeat : character.getCharacterFeats()) {
      final Node featElement = createFeat(characterFeat);
      featsElement.appendChild(featElement);
    }
    return featsElement;
  }

  private Node createFeat(final CharacterFeat characterFeat) {
    final Node featElement = document.createElement(TAG_FEAT);
    featElement.appendChild(createElementWithText(TAG_NAME, characterFeat.getFeat().getName()));
    featElement.appendChild(createElementWithText(TAG_CATEGORY, characterFeat.getCategory()));
    return featElement;
  }

  private Node createKnownSpells() {
    final Element knownSpellsElement = document.createElement(TAG_KNOWNSPELLS);
    for (final KnownSpell knownSpell : character.getKnownSpells()) {
      final Element spellElement = createKnownSpell(knownSpell);
      knownSpellsElement.appendChild(spellElement);
    }
    return knownSpellsElement;
  }

  private Element createKnownSpell(final KnownSpell knownSpell) {
    final Element knownSpellElement = document.createElement(TAG_KNOWNSPELL);
    knownSpellElement.appendChild(createElementWithText(TAG_SPELL, knownSpell.getSpell().getName()));
    knownSpellElement.appendChild(createElementWithText(TAG_SPELLLIST, knownSpell.getSpelllist().getName()));
    return knownSpellElement;
  }

  private Node createSpellSlots() {
    final Element spellSlotsElement = document.createElement(TAG_SPELLSLOTS);
    for (final SpellSlot spellSlot : character.getSpellSlots()) {
      final Element spellSlotElement = createSpellSlot(spellSlot);
      spellSlotsElement.appendChild(spellSlotElement);
    }
    return spellSlotsElement;
  }

  private Element createSpellSlot(final SpellSlot spellSlot) {
    final Element spellSlotElement = document.createElement(TAG_SPELLSLOT);
    spellSlotElement.appendChild(createElementWithText(TAG_SPELL, spellSlot.getSpell().getName()));
    spellSlotElement.appendChild(createElementWithText(TAG_LEVEL, spellSlot.getLevel()));
    spellSlotElement.appendChild(createElementWithText(spellSlot.isCast()));
    spellSlotElement.appendChild(createElementSpelllistAbilities(spellSlot.getSpelllistAbilities()));
    spellSlotElement.appendChild(createElementMeatamagicFeats(spellSlot.getMetamagicFeats()));
    return spellSlotElement;
  }

  private Node createElementSpelllistAbilities(final List<SpelllistAbility> spelllistAbilities) {
    final Element spelllistAbilitiesElement = document.createElement(TAG_SPELLLISTABILITIES);
    for (final SpelllistAbility spelllistAbility : spelllistAbilities) {
      spelllistAbilitiesElement.appendChild(createElementWithText(TAG_SPELLLISTABILITY, spelllistAbility.getName()));
    }
    return spelllistAbilitiesElement;
  }

  private Node createElementMeatamagicFeats(final List<Feat> metamagicFeats) {
    final Element metamagicFeatElement = document.createElement(TAG_METAMAGICFEATS);
    for (final Feat metamagicFeat : metamagicFeats) {
      metamagicFeatElement.appendChild(createElementWithText(TAG_METAMAGICFEAT, metamagicFeat.getName()));
    }
    return metamagicFeatElement;
  }

  private Node createEquipment() {
    final Element equipmentElement = document.createElement(TAG_EQUIPMENT);
    final Equipment equipment = character.getEquipment();
    equipmentElement.appendChild(createItemGroupsElement(TAG_WEAPONS, TAG_WEAPON, equipment.getWeapons()));
    equipmentElement.appendChild(createItemGroupsElement(TAG_ARMORS, TAG_ARMOR, equipment.getArmor()));
    equipmentElement.appendChild(createItemGroupsElement(TAG_GOODS, TAG_GOOD, equipment.getGoods()));
    return equipmentElement;
  }

  private Node createItemGroupsElement(final String itemGroupsTag, final String itemGroupTag, final List<ItemGroup> itemGroups) {
    final Element itemGroupsElement = document.createElement(itemGroupsTag);
    for (final ItemGroup itemGroup : itemGroups) {
      itemGroupsElement.appendChild(createItemGroupElement(itemGroupTag, itemGroup));
    }
    return itemGroupsElement;
  }

  private Node createItemGroupElement(final String tagName, final ItemGroup itemGroup) {
    final Node itemGroupElement = document.createElement(tagName);
    itemGroupElement.appendChild(createElementWithText(TAG_NAME, itemGroup.getItem().getName()));
    itemGroupElement.appendChild(createElementWithText(TAG_NUMBER, itemGroup.getNumber()));
    return itemGroupElement;
  }

}
