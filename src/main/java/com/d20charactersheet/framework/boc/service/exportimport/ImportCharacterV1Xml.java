package com.d20charactersheet.framework.boc.service.exportimport;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.Alignment;
import com.d20charactersheet.framework.boc.model.AttackWield;
import com.d20charactersheet.framework.boc.model.Attribute;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterAbility;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.CharacterFeat;
import com.d20charactersheet.framework.boc.model.CharacterSkill;
import com.d20charactersheet.framework.boc.model.ClassAbility;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.ItemGroup;
import com.d20charactersheet.framework.boc.model.KnownSpell;
import com.d20charactersheet.framework.boc.model.Note;
import com.d20charactersheet.framework.boc.model.Race;
import com.d20charactersheet.framework.boc.model.Sex;
import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpelllistAbility;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponAttack;
import com.d20charactersheet.framework.boc.model.XpTable;

/**
 * Imports characters from a xml document.
 */
public class ImportCharacterV1Xml extends XmlImport implements ImportCharacter {

  protected static final int NODE_INDEX_APPEARANCE = 0;
  protected static final int NODE_INDEX_ATTRIBUTES = 1;
  protected static final int NODE_INDEX_COMBAT = 2;
  protected static final int NODE_INDEX_SAVES = 3;
  protected static final int NODE_INDEX_MONEY = 4;
  protected static final int NODE_INDEX_NOTES = 5;
  protected static final int NODE_INDEX_ATTACKS = 6;
  protected static final int NODE_INDEX_SKILLS = 7;
  protected static final int NODE_INDEX_FEATS = 8;
  protected static final int NODE_INDEX_SPELLS = 9;
  protected static final int NODE_INDEX_EQUIPMENT = 10;

  /**
   * Imports characters from a xml document.
   *
   * @param importContext
   *     Contains all data of the game system required for import.
   * @param document
   *     The xml document to import from.
   */
  public ImportCharacterV1Xml(final ImportContext importContext, final Document document) {
    super(importContext, document);
  }

  @Override
  public List<ImportReport<Character>> importCharacters() {
    final NodeList nodeList = document.getElementsByTagName(TAG_CHARACTER);
    final int numberOfCharacters = nodeList.getLength();
    final List<ImportReport<Character>> importReports = new ArrayList<>(numberOfCharacters);
    for (int i = 0; i < numberOfCharacters; i++) {
      final Node characterElement = nodeList.item(i);
      final ImportReport<Character> importReport = importCharacter(characterElement);
      importReports.add(importReport);
    }
    return importReports;
  }

  protected ImportReport<Character> importCharacter(final Node characterElement) {
    final ImportReport<Character> importReport = new ImportReport<>(new Character());
    try {
      new ImportAppearance().importAppearance(characterElement, importReport);
      new ImportAttribute().importAttribute(characterElement, importReport);
      new ImportCombat().importCombat(characterElement, importReport);
      new ImportSaves().importSaves(characterElement, importReport);
      new ImportMoney().importMoney(characterElement, importReport);
      new ImportNotes().importNotes(characterElement, importReport);
      new ImportAttacks().importAttacks(characterElement, importReport);
      new ImportSkills().importSkills(characterElement, importReport);
      new ImportFeats().importFeats(characterElement, importReport);
      new ImportSpells().importSpells(characterElement, importReport);
      new ImportEquipment().importWeapons(characterElement, importReport);
      new ImportEquipment().importArmor(characterElement, importReport);
      new ImportEquipment().importGoods(characterElement, importReport);
    } catch (final Exception exception) {
      exception.printStackTrace();
      final String message = exception.getMessage();
      final ImportMessage importMessage = new ImportMessage(message, ImportMessage.Type.ERROR);
      importReport.addMessage(importMessage);
    }
    return importReport;
  }

  protected void addImportMessage(final Exception exception, final ImportReport<Character> importReport) {
    final String message = exception.getMessage();
    final ImportMessage importMessage = new ImportMessage(message, ImportMessage.Type.WARNING);
    importReport.addMessage(importMessage);
  }

  /**
   * Imports the appearance data of a character.
   */
  public class ImportAppearance {

    private static final int INDEX_NAME = 0;
    private static final int INDEX_PLAYER = 1;
    private static final int INDEX_RACE = 2;
    private static final int INDEX_SEX = 3;
    private static final int INDEX_CLASSLEVELS = 4;
    private static final int INDEX_ALIGNMENT = 5;
    private static final int INDEX_XPPOINTS = 6;
    private static final int INDEX_XPTABLEID = 7;

    /**
     * Imports the appearance data from the character node.
     *
     * @param characterNode
     *     The character node with the appearance node as child.
     * @param importReport
     *     The import report of the character.
     */
    public void importAppearance(final Node characterNode, final ImportReport<Character> importReport) {
      final Node appearanceElement = characterNode.getChildNodes().item(NODE_INDEX_APPEARANCE);
      final NodeList childNodes = appearanceElement.getChildNodes();

      final Character character = importReport.getImportObject();

      character.setName(childNodes.item(INDEX_NAME).getTextContent());
      character.setPlayer(childNodes.item(INDEX_PLAYER).getTextContent());

      // race
      final Race race = getRace(childNodes.item(INDEX_RACE));
      character.setRace(race);

      // sex
      final Sex sex = Sex.valueOf(childNodes.item(INDEX_SEX).getTextContent());
      character.setSex(sex);

      // classlevels
      final List<ClassLevel> classLevels = getClassLevels(childNodes.item(INDEX_CLASSLEVELS), importReport);
      character.setClassLevels(classLevels);

      // alignment
      final Alignment alignment = Alignment.valueOf(childNodes.item(INDEX_ALIGNMENT).getTextContent());
      character.setAlignment(alignment);

      // xp points
      character.setExperiencePoints(getInt(childNodes.item(INDEX_XPPOINTS)));

      // xp table
      final XpTable xpTable = getXpTable(childNodes.item(INDEX_XPTABLEID));
      character.setXpTable(xpTable);

    }

    Race getRace(final Node raceElement) {
      final String name = raceElement.getTextContent();
      for (final Race race : importContext.getAllRaces()) {
        if (race.getName().equalsIgnoreCase(name)) {
          return race;
        }
      }
      throw new IllegalArgumentException("Can't find race with name: " + name);
    }

    private List<ClassLevel> getClassLevels(final Node classLevelsElement, final ImportReport<Character> importReport) {
      final List<ClassLevel> classLevels = new ArrayList<>();
      final NodeList nodeList = classLevelsElement.getChildNodes();
      for (int i = 0; i < nodeList.getLength(); i++) {
        final Node classLevelElement = nodeList.item(i);
        final ClassLevel classLevel = getClassLevel(classLevelElement, importReport);
        classLevels.add(classLevel);
      }
      return classLevels;
    }

    private ClassLevel getClassLevel(final Node classLevelElement, final ImportReport<Character> importReport) {
      final Node classElement = classLevelElement.getFirstChild();
      final CharacterClass clazz = getClazz(classElement);

      final Node levelElement = classElement.getNextSibling();
      final int level = Integer.parseInt(levelElement.getTextContent());

      final Node characterAbilitiesElement = levelElement.getNextSibling();
      final List<CharacterAbility> characterAbilities = getCharacterAbilities(characterAbilitiesElement, clazz, importReport);

      final ClassLevel classLevel = new ClassLevel(clazz, level);
      classLevel.setCharacterAbilities(characterAbilities);
      return classLevel;
    }

    private CharacterClass getClazz(final Node classElement) {
      final String name = classElement.getTextContent();

      for (final CharacterClass clazz : importContext.getAllClasses()) {
        if (clazz.getName().equalsIgnoreCase(name)) {
          return clazz;
        }
      }
      throw new IllegalArgumentException("Can't find class with name: " + name);
    }

    private List<CharacterAbility> getCharacterAbilities(final Node characterAbilitiesElement, final CharacterClass clazz,
        final ImportReport<Character> importReport) {
      final List<CharacterAbility> characterAbilities = new ArrayList<>();
      final NodeList nodeList = characterAbilitiesElement.getChildNodes();
      for (int i = 0; i < nodeList.getLength(); i++) {
        final Element characterAbilityElement = (Element) nodeList.item(i);
        try {
          final CharacterAbility characterAbility = getCharacterAbility(characterAbilityElement, clazz);
          characterAbilities.add(characterAbility);
        } catch (final Exception exception) {
          addImportMessage(exception, importReport);
        }
      }
      return characterAbilities;
    }

    private CharacterAbility getCharacterAbility(final Element characterAbilityElement, final CharacterClass clazz) {

      final String name = characterAbilityElement.getAttribute(ATTRIBUTE_NAME);
      final String ownedString = characterAbilityElement.getAttribute(ATTRIBUTE_OWNED);
      final boolean owned = Boolean.parseBoolean(ownedString);

      for (final ClassAbility classAbility : clazz.getClassAbilities()) {
        final Ability ability = classAbility.getAbility();
        if (ability.getName().equalsIgnoreCase(name)) {
          final CharacterAbility characterAbility = new CharacterAbility();
          characterAbility.setClassAbility(classAbility);
          characterAbility.setOwned(owned);
          return characterAbility;
        }
      }
      throw new IllegalArgumentException("Can't find class ability with name: " + name + ". Ignoring ability.");
    }

    private XpTable getXpTable(final Node xpTableIdElement) {
      final int xpTableId = Integer.parseInt(xpTableIdElement.getTextContent());
      for (final XpTable xpTable : importContext.getAllXpTables()) {
        if (xpTable.getId() == xpTableId) {
          return xpTable;
        }
      }
      throw new IllegalArgumentException("Can't find xp table with id: " + xpTableId);
    }
  }

  /**
   * Imports the attributes of a character.
   */
  public static class ImportAttribute {

    /**
     * Imports the attributes of a character.
     *
     * @param characterNode
     *     The character node with the attributes as child node.
     * @param importReport
     *     The import report of the character.
     */
    public void importAttribute(final Node characterNode, final ImportReport<Character> importReport) {
      final Node attributesElement = characterNode.getChildNodes().item(NODE_INDEX_ATTRIBUTES);
      final NodeList attributeElements = attributesElement.getChildNodes();
      for (int i = 0; i < attributeElements.getLength(); i++) {
        final Element attributeElement = (Element) attributeElements.item(i);
        setAttribute(attributeElement, importReport.getImportObject());
      }
    }

    private void setAttribute(final Element attributeElement, final Character character) {
      final String name = attributeElement.getAttribute(ATTRIBUTE_NAME);
      final Attribute attribute = Attribute.valueOf(name);

      final int value = Integer.parseInt(attributeElement.getAttribute(ATTRIBUTE_VALUE));

      switch (attribute) {
        case STRENGTH:
          character.setStrength(value);
          break;

        case DEXTERITY:
          character.setDexterity(value);
          break;

        case CONSTITUTION:
          character.setConstitution(value);
          break;

        case INTELLIGENCE:
          character.setIntelligence(value);
          break;

        case WISDOM:
          character.setWisdom(value);
          break;

        case CHARISMA:
          character.setCharisma(value);
          break;

        default:
          throw new IllegalArgumentException("Can't find attribute: " + attribute);
      }

    }
  }

  /**
   * Imports the combat data of a character.
   */
  public class ImportCombat {

    private static final int INDEX_HITPOINTS = 0;
    private static final int INDEX_MAXHITPOINTS = 1;
    private static final int INDEX_ARMORMOD = 2;
    private static final int INDEX_INIMOD = 3;
    private static final int INDEX_CMBMOD = 4;
    private static final int INDEX_CMDMOD = 5;

    /**
     * Import the combat data of a character.
     *
     * @param characterNode
     *     The character node with the combat node as child.
     * @param importReport
     *     The import report of the character.
     */
    public void importCombat(final Node characterNode, final ImportReport<Character> importReport) {
      final Node combatElement = characterNode.getChildNodes().item(NODE_INDEX_COMBAT);
      final NodeList childNodes = combatElement.getChildNodes();
      final Character character = importReport.getImportObject();

      character.setHitPoints(getInt(childNodes.item(INDEX_HITPOINTS)));
      character.setMaxHitPoints(getInt(childNodes.item(INDEX_MAXHITPOINTS)));
      character.setArmorClass(getInt(childNodes.item(INDEX_ARMORMOD)));
      character.setInitiativeModifier(getInt(childNodes.item(INDEX_INIMOD)));
      character.setCmbModifier(getInt(childNodes.item(INDEX_CMBMOD)));
      character.setCmdModifier(getInt(childNodes.item(INDEX_CMDMOD)));
    }
  }

  /**
   * Imports the saves of the character.
   */
  public class ImportSaves {

    private static final int INDEX_FORTIFY = 0;
    private static final int INDEX_REFLEX = 1;
    private static final int INDEX_WILL = 2;

    /**
     * Imports the saves of the character.
     *
     * @param characterNode
     *     The character node with the save node as child.
     * @param importReport
     *     The import report of the character.
     */
    public void importSaves(final Node characterNode, final ImportReport<Character> importReport) {
      final Node savesElement = characterNode.getChildNodes().item(NODE_INDEX_SAVES);
      final NodeList childNodes = savesElement.getChildNodes();
      final Character character = importReport.getImportObject();

      character.setFortitudeModifier(getInt(childNodes.item(INDEX_FORTIFY)));
      character.setReflexModifier(getInt(childNodes.item(INDEX_REFLEX)));
      character.setWillModifier(getInt(childNodes.item(INDEX_WILL)));
    }
  }

  /**
   * Imports the money of the character.
   */
  public class ImportMoney {

    private static final int INDEX_PLATINUM = 0;
    private static final int INDEX_GOLD = 1;
    private static final int INDEX_SILVER = 2;
    private static final int INDEX_COPPER = 3;

    /**
     * Imports the money of the character.
     *
     * @param characterNode
     *     The character node with the money node as child.
     * @param importReport
     *     The import report of the character.
     */
    public void importMoney(final Node characterNode, final ImportReport<Character> importReport) {
      final Node moneyElement = characterNode.getChildNodes().item(NODE_INDEX_MONEY);
      final NodeList childNodes = moneyElement.getChildNodes();
      final Character character = importReport.getImportObject();

      character.getMoney().setPlatinum(getInt(childNodes.item(INDEX_PLATINUM)));
      character.getMoney().setGold(getInt(childNodes.item(INDEX_GOLD)));
      character.getMoney().setSilver(getInt(childNodes.item(INDEX_SILVER)));
      character.getMoney().setCopper(getInt(childNodes.item(INDEX_COPPER)));
    }
  }

  /**
   * Imports the notes of the character.
   */
  public static class ImportNotes {

    private static final int INDEX_DATE = 0;
    private static final int INDEX_TEXT = 1;

    /**
     * Imports the notes of the character.
     *
     * @param characterNode
     *     The character node with the note node as child.
     * @param importReport
     *     The import report of the character.
     */
    public void importNotes(final Node characterNode, final ImportReport<Character> importReport) {
      final Node notesElement = characterNode.getChildNodes().item(NODE_INDEX_NOTES);
      final NodeList childNodes = notesElement.getChildNodes();
      final Character character = importReport.getImportObject();

      final List<Note> notes = new ArrayList<>(childNodes.getLength());
      final DateFormat dateFormat = new SimpleDateFormat(PATTERN_DATETIME);
      for (int i = 0; i < childNodes.getLength(); i++) {
        final Node noteElement = childNodes.item(i);
        final NodeList noteChildren = noteElement.getChildNodes();

        final Note note = new Note();
        note.setDate(getDate(noteChildren.item(INDEX_DATE), dateFormat, importReport));
        note.setText(noteChildren.item(INDEX_TEXT).getTextContent());
        notes.add(note);
      }
      character.setNotes(notes);
    }

    private Date getDate(final Node dateNode, final DateFormat dateFormat, final ImportReport<Character> importReport) {
      try {
        final String textContent = dateNode.getTextContent();
        final Date date = dateFormat.parse(textContent);
        return date;
      } catch (final ParseException parseException) {
        parseException.printStackTrace();
        final String message = "Can't parse date of note, use current date instead";
        final ImportMessage importMessage = new ImportMessage(message, ImportMessage.Type.WARNING);
        importReport.addMessage(importMessage);
        return new Date();
      }
    }

  }

  /**
   * Imports the attacks of the character.
   */
  public class ImportAttacks {

    private static final int INDEX_NAME = 0;
    private static final int INDEX_DESCRIPTION = 1;
    private static final int INDEX_ATTACKWIELD = 2;
    private static final int INDEX_WEAPON = 3;
    private static final int INDEX_ATTACKBONUSMOD = 4;
    private static final int INDEX_DAMAGEBONUSMOD = 5;

    /**
     * Imports the attacks of the character.
     *
     * @param characterNode
     *     The character node with the attack node as child.
     * @param importReport
     *     The import report of the character.
     */
    public void importAttacks(final Node characterNode, final ImportReport<Character> importReport) {
      final Node attacksElement = characterNode.getChildNodes().item(NODE_INDEX_ATTACKS);
      final NodeList childNodes = attacksElement.getChildNodes();
      final Character character = importReport.getImportObject();

      final List<WeaponAttack> weaponAttacks = new ArrayList<>(childNodes.getLength());
      for (int i = 0; i < childNodes.getLength(); i++) {
        final Node attackElement = childNodes.item(i);
        final NodeList attackChildren = attackElement.getChildNodes();
        try {
          final WeaponAttack weaponAttack = getWeaponAttack(attackChildren);
          weaponAttacks.add(weaponAttack);
        } catch (final Exception exception) {
          addImportMessage(exception, importReport);
        }
      }
      character.setWeaponAttacks(weaponAttacks);
    }

    private WeaponAttack getWeaponAttack(final NodeList attackChildren) {
      final WeaponAttack weaponAttack = new WeaponAttack();
      weaponAttack.setName(attackChildren.item(INDEX_NAME).getTextContent());
      weaponAttack.setDescription(attackChildren.item(INDEX_DESCRIPTION).getTextContent());
      weaponAttack.setAttackWield(AttackWield.valueOf(attackChildren.item(INDEX_ATTACKWIELD).getTextContent()));
      weaponAttack.setWeapon(getWeapon(attackChildren.item(INDEX_WEAPON)));
      weaponAttack.setAttackBonusModifier(getInt(attackChildren.item(INDEX_ATTACKBONUSMOD)));
      weaponAttack.setDamageBonusModifier(getInt(attackChildren.item(INDEX_DAMAGEBONUSMOD)));
      return weaponAttack;
    }

    private Weapon getWeapon(final Node weaponElement) {
      final String name = weaponElement.getTextContent();
      for (final Weapon weapon : importContext.getAllWeapons()) {
        if (weapon.getName().equalsIgnoreCase(name)) {
          return weapon;
        }
      }
      throw new IllegalArgumentException("Can't find weapon with name: " + name + ". Ignoring attack.");
    }
  }

  /**
   * Imports the skills of the character.
   */
  public class ImportSkills {

    private static final int INDEX_NAME = 0;
    private static final int INDEX_RANK = 1;
    private static final int INDEX_SKILLMOD = 2;

    /**
     * Imports the skills of the character.
     *
     * @param characterNode
     *     The character node with the skill node as child.
     * @param importReport
     *     The import report of the character.
     */
    public void importSkills(final Node characterNode, final ImportReport<Character> importReport) {
      final Node skillsElement = characterNode.getChildNodes().item(NODE_INDEX_SKILLS);
      final NodeList skillNodes = skillsElement.getChildNodes();
      final Character character = importReport.getImportObject();

      final List<CharacterSkill> characterSkills = new ArrayList<>(skillNodes.getLength());
      for (int i = 0; i < skillNodes.getLength(); i++) {
        try {
          final CharacterSkill characterSkill = getCharacterSkill(skillNodes.item(i));
          characterSkills.add(characterSkill);
        } catch (final Exception exception) {
          addImportMessage(exception, importReport);
        }
      }
      character.setCharacterSkills(characterSkills);
    }

    private CharacterSkill getCharacterSkill(final Node skillNode) {
      final NodeList skillChildNodes = skillNode.getChildNodes();
      final Skill skill = getSkill(skillChildNodes.item(INDEX_NAME));

      final CharacterSkill characterSkill = new CharacterSkill(skill);
      characterSkill.setRank(getFloat(skillChildNodes.item(INDEX_RANK)));
      characterSkill.setModifier(getInt(skillChildNodes.item(INDEX_SKILLMOD)));
      return characterSkill;
    }

    private Skill getSkill(final Node skillNode) {
      final String name = skillNode.getTextContent();
      for (final Skill skill : importContext.getAllSkills()) {
        if (skill.getName().equalsIgnoreCase(name)) {
          return skill;
        }
      }
      throw new IllegalArgumentException("Can't find skill with name: " + name + ". Ignoring skill.");
    }
  }

  /**
   * Imports the feats of the character.
   */
  public class ImportFeats {

    private static final int INDEX_NAME = 0;
    private static final int INDEX_CATEGORY = 1;

    /**
     * Imports the feats of the character.
     *
     * @param characterNode
     *     The character node with the feat node as child.
     * @param importReport
     *     The import report of the character.
     */
    public void importFeats(final Node characterNode, final ImportReport<Character> importReport) {
      final Node featsElement = characterNode.getChildNodes().item(NODE_INDEX_FEATS);
      final NodeList featNodes = featsElement.getChildNodes();
      final Character character = importReport.getImportObject();

      final List<CharacterFeat> characterFeats = new ArrayList<>(featNodes.getLength());
      for (int i = 0; i < featNodes.getLength(); i++) {
        try {
          final CharacterFeat characterFeat = getCharacterFeat(featNodes.item(i));
          characterFeats.add(characterFeat);
        } catch (final Exception exception) {
          addImportMessage(exception, importReport);
        }
      }
      character.setCharacterFeats(characterFeats);
    }

    private CharacterFeat getCharacterFeat(final Node featNode) {
      final NodeList featChildNodes = featNode.getChildNodes();
      final Feat feat = getFeat(featChildNodes.item(INDEX_NAME));

      final CharacterFeat characterFeat = new CharacterFeat(feat);
      characterFeat.setCategory(featChildNodes.item(INDEX_CATEGORY).getTextContent());
      return characterFeat;
    }

    private Feat getFeat(final Node nameNode) {
      final String name = nameNode.getTextContent();
      for (final Feat feat : importContext.getAllFeats()) {
        if (feat.getName().equalsIgnoreCase(name)) {
          return feat;
        }
      }
      throw new IllegalArgumentException("Can't find feat with name: " + name + ". Ignoring feat.");
    }

  }

  /**
   * Imports the spells of the character
   */
  public class ImportSpells {

    private static final int INDEX_NAME = 0;

    /**
     * Imports the spells of the character.
     *
     * @param characterNode
     *     The character node with the spell node as child.
     * @param importReport
     *     The import report of the character.
     */
    public void importSpells(final Node characterNode, final ImportReport<Character> importReport) {
      final Node spellsElement = characterNode.getChildNodes().item(NODE_INDEX_SPELLS);
      final NodeList spellNodes = spellsElement.getChildNodes();
      final Character character = importReport.getImportObject();

      final List<KnownSpell> knownSpells = new ArrayList<>(spellNodes.getLength());
      for (int i = 0; i < spellNodes.getLength(); i++) {
        try {
          final KnownSpell knownSpell = getKnownSpell(character, spellNodes.item(i));
          knownSpells.add(knownSpell);
        } catch (final Exception exception) {
          addImportMessage(exception, importReport);
        }
      }
      character.setKnownSpells(knownSpells);
    }

    private KnownSpell getKnownSpell(final Character character, final Node spellNode) {
      final NodeList spellChildNodes = spellNode.getChildNodes();
      final Spell spell = findSpell(spellChildNodes.item(INDEX_NAME));
      final Spelllist spelllist = findSpelllist(character, spell);

      final KnownSpell knownSpell = new KnownSpell();
      knownSpell.setSpell(spell);
      knownSpell.setSpelllist(spelllist);
      return knownSpell;
    }

    private Spell findSpell(final Node nameNode) {
      final String name = nameNode.getTextContent();
      for (final Spell spell : importContext.getAllSpells()) {
        if (spell.getName().equalsIgnoreCase(name)) {
          return spell;
        }
      }
      throw new IllegalArgumentException("Can't find spell with name: " + name + ". Ignoring spell.");
    }

    private Spelllist findSpelllist(final Character character, final Spell spell) {
      for (final SpelllistAbility spelllistAbility : character.getSpelllistAbilities()) {
        final Spelllist spelllist = spelllistAbility.getSpelllist();
        if (contains(spelllist, spell)) {
          return spelllist;
        }
      }
      throw new IllegalArgumentException("Can't find spell list for spell: " + spell.getName() + ". Ignoring spell.");
    }

    private boolean contains(final Spelllist spelllist, final Spell spell) {
      for (final Spell spellOfSpelllist : spelllist.getAllSpells()) {
        if (spell.equals(spellOfSpelllist)) {
          return true;
        }
      }
      return false;
    }

  }

  /**
   * Imports the equipment of the character.
   */
  public class ImportEquipment {

    private static final int INDEX_WEAPONS = 0;
    private static final int INDEX_ARMORS = 1;
    private static final int INDEX_GOODS = 2;

    private static final int INDEX_NAME = 0;
    private static final int INDEX_NUMBER = 1;

    /**
     * Imports the weapons of the character.
     *
     * @param characterNode
     *     The character node with the weapon node as child.
     * @param importReport
     *     The import report of the character.
     */
    public void importWeapons(final Node characterNode, final ImportReport<Character> importReport) {
      final Character character = importReport.getImportObject();

      final NodeList itemNodes = getItemNodes(characterNode, INDEX_WEAPONS);
      final List<ItemGroup> itemGroups = getItems(itemNodes, importContext.getAllWeapons(), importReport);
      character.getEquipment().setWeapons(itemGroups);
    }

    /**
     * Imports the armor of the character.
     *
     * @param characterNode
     *     The character node with the armor node as child.
     * @param importReport
     *     The import report of the character.
     */
    public void importArmor(final Node characterNode, final ImportReport<Character> importReport) {
      final Character character = importReport.getImportObject();

      final NodeList itemNodes = getItemNodes(characterNode, INDEX_ARMORS);
      final List<ItemGroup> itemGroups = getItems(itemNodes, importContext.getAllArmor(), importReport);
      character.getEquipment().setArmor(itemGroups);
    }

    /**
     * Imports the armor of the character.
     *
     * @param characterNode
     *     The character node with the armor node as child.
     * @param importReport
     *     The import report of the character.
     */
    public void importGoods(final Node characterNode, final ImportReport<Character> importReport) {
      final Character character = importReport.getImportObject();

      final NodeList itemNodes = getItemNodes(characterNode, INDEX_GOODS);
      final List<ItemGroup> itemGroups = getItems(itemNodes, importContext.getAllGoods(), importReport);
      character.getEquipment().setGoods(itemGroups);
    }

    protected NodeList getItemNodes(final Node characterElement, final int index) {
      final Node equipmentElement = characterElement.getChildNodes().item(NODE_INDEX_EQUIPMENT);
      final Node itemsNode = equipmentElement.getChildNodes().item(index);
      final NodeList itemNodes = itemsNode.getChildNodes();
      return itemNodes;
    }

    private List<ItemGroup> getItems(final NodeList itemNodes, final List<? extends Item> items,
        final ImportReport<Character> importReport) {
      final List<ItemGroup> itemGroups = new ArrayList<>(itemNodes.getLength());
      for (int i = 0; i < itemNodes.getLength(); i++) {
        try {
          final ItemGroup itemGroup = getItemGroup(itemNodes.item(i), items);
          itemGroups.add(itemGroup);
        } catch (final Exception exception) {
          addImportMessage(exception, importReport);
        }
      }
      return itemGroups;
    }

    private ItemGroup getItemGroup(final Node itemNode, final List<? extends Item> items) {
      final NodeList childNodes = itemNode.getChildNodes();
      final Item item = getItem(childNodes.item(INDEX_NAME), items);
      final ItemGroup itemGroup = new ItemGroup();
      itemGroup.setItem(item);
      itemGroup.setNumber(getInt(childNodes.item(INDEX_NUMBER)));
      return itemGroup;
    }

    private Item getItem(final Node itemNode, final List<? extends Item> items) {
      final String name = itemNode.getTextContent();
      for (final Item item : items) {
        if (item.getName().equals(name)) {
          return item;
        }
      }
      throw new IllegalArgumentException("Can't find item with name: " + name + ". Ignoring item.");
    }

  }
}
