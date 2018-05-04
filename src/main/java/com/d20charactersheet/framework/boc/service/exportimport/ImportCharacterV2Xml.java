package com.d20charactersheet.framework.boc.service.exportimport;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.boc.model.KnownSpell;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.SpellSlot;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpelllistAbility;

/**
 * Imports characters from a xml document.
 */
public class ImportCharacterV2Xml extends ImportCharacterV1Xml {

  protected static final int NODE_INDEX_KNOWN_SPELLS = 9;
  protected static final int NODE_INDEX_SPELL_SLOTS = 10;
  protected static final int NODE_INDEX_EQUIPMENT = 11;

  /**
   * Imports characters from a xml document.
   *
   * @param importContext
   *     Contains all data of the game system required for import.
   * @param document
   *     The xml document to import from.
   */
  public ImportCharacterV2Xml(final ImportContext importContext, final Document document) {
    super(importContext, document);
  }

  @Override
  protected ImportReport<Character> importCharacter(final Node characterElement) {
    final ImportReport<Character> importReport = new ImportReport<Character>(new Character());
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
      new ImportKnownSpells().importKnownSpells(characterElement, importReport);
      new ImportSpellSlots().importSpellSlots(characterElement, importReport);
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

  /**
   * Imports known spells of character from xml document..
   */
  public class ImportKnownSpells {

    private static final int INDEX_SPELL = 0;
    private static final int INDEX_SPELLLIST = 1;

    /**
     * Imports known spells from character node.
     *
     * @param characterNode
     *     The character node to import known spells from.
     * @param importReport
     *     The import report.
     */
    public void importKnownSpells(final Node characterNode, final ImportReport<Character> importReport) {
      final Node knownSpellsElement = characterNode.getChildNodes().item(NODE_INDEX_KNOWN_SPELLS);
      final NodeList knownSpellNodes = knownSpellsElement.getChildNodes();
      final Character character = importReport.getImportObject();

      final List<KnownSpell> knownSpells = new ArrayList<KnownSpell>(knownSpellNodes.getLength());
      for (int i = 0; i < knownSpellNodes.getLength(); i++) {
        final Node knownSpellElement = knownSpellNodes.item(i);
        final NodeList knownSpellChildren = knownSpellElement.getChildNodes();
        try {
          final KnownSpell knownSpell = getKnownSpell(knownSpellChildren);
          knownSpells.add(knownSpell);
        } catch (final Exception exception) {
          addImportMessage(exception, importReport);
        }
      }
      character.setKnownSpells(knownSpells);
    }

    private KnownSpell getKnownSpell(final NodeList knownSpellChildren) {
      final KnownSpell knownSpell = new KnownSpell();
      knownSpell.setSpell(findSpell(knownSpellChildren.item(INDEX_SPELL)));
      knownSpell.setSpelllist(findSpelllist(knownSpellChildren.item(INDEX_SPELLLIST)));
      return knownSpell;
    }

    private Spell findSpell(final Node spellNode) {
      final String name = spellNode.getTextContent();
      for (final Spell spell : importContext.getAllSpells()) {
        if (spell.getName().equalsIgnoreCase(name)) {
          return spell;
        }
      }
      throw new IllegalArgumentException("Can't find spell with name: " + name + ". Ignoring spell.");
    }
  }

  private Spelllist findSpelllist(final Node spelllistNode) {
    final String name = spelllistNode.getTextContent();
    for (final Spelllist spelllist : importContext.getAllSpelllists()) {
      if (spelllist.getName().equalsIgnoreCase(name)) {
        return spelllist;
      }
    }
    throw new IllegalArgumentException("Can't find spell list with name: " + name + ". Ignoring spell.");
  }

  /**
   * Imports equipment of a character.
   */
  public class ImportEquipment extends ImportCharacterV1Xml.ImportEquipment {

    @Override
    protected NodeList getItemNodes(final Node characterElement, final int index) {
      final Node equipmentElement = characterElement.getChildNodes().item(NODE_INDEX_EQUIPMENT);
      final Node itemsNode = equipmentElement.getChildNodes().item(index);
      final NodeList itemNodes = itemsNode.getChildNodes();
      return itemNodes;
    }
  }

  /**
   * Imports spell slots of a character.
   */
  public class ImportSpellSlots {

    private static final int INDEX_NAME = 0;
    private static final int INDEX_LEVEL = 1;
    private static final int INDEX_CAST = 2;
    private static final int INDEX_SPELLLIST_ABILITIES = 3;
    private static final int INDEX_METAMAGICFEATS = 4;

    /**
     * Import spell slots from character node.
     *
     * @param characterNode
     *     The character node to import from.
     * @param importReport
     *     The import report.
     */
    public void importSpellSlots(final Node characterNode, final ImportReport<Character> importReport) {
      final Node spellSlotsElement = characterNode.getChildNodes().item(NODE_INDEX_SPELL_SLOTS);
      final NodeList spellSlotNodes = spellSlotsElement.getChildNodes();
      final Character character = importReport.getImportObject();

      final List<SpellSlot> spellSlots = new ArrayList<SpellSlot>(spellSlotNodes.getLength());
      for (int i = 0; i < spellSlotNodes.getLength(); i++) {
        final Node spellSlotNode = spellSlotNodes.item(i);
        try {
          final SpellSlot spellSlot = getSpellSlot(spellSlotNode);
          spellSlots.add(spellSlot);
        } catch (final Exception exception) {
          addImportMessage(exception, importReport);
        }
      }
      character.setSpellSlots(spellSlots);
    }

    private SpellSlot getSpellSlot(final Node spellSlotNode) {
      final NodeList spellSlotChildren = spellSlotNode.getChildNodes();
      final Spell spell = findSpell(spellSlotChildren.item(INDEX_NAME));
      final int level = getInt(spellSlotChildren.item(INDEX_LEVEL));
      final boolean cast = getBoolean(spellSlotChildren.item(INDEX_CAST));
      final List<SpelllistAbility> spelllistAbilities = getSpelllistAbilities(spellSlotChildren.item(INDEX_SPELLLIST_ABILITIES));
      final List<Feat> metamagicFeats = getMetamagicFeats(spellSlotChildren.item(INDEX_METAMAGICFEATS));

      final SpellSlot spellSlot = new SpellSlot();
      spellSlot.setSpell(spell);
      spellSlot.setLevel(level);
      spellSlot.setCast(cast);
      spellSlot.setSpelllistAbilities(spelllistAbilities);
      spellSlot.setMetamagicFeats(metamagicFeats);
      return spellSlot;
    }

    private List<SpelllistAbility> getSpelllistAbilities(final Node spelllistAbilitiesNode) {
      final List<SpelllistAbility> spelllistAbilities = new ArrayList<SpelllistAbility>();
      final NodeList spelllistAbilityNodes = spelllistAbilitiesNode.getChildNodes();
      for (int i = 0; i < spelllistAbilityNodes.getLength(); i++) {
        final Node spelllistAbilityNode = spelllistAbilityNodes.item(i);
        final SpelllistAbility spellistAbility = findSpelllistAbility(spelllistAbilityNode);
        spelllistAbilities.add(spellistAbility);
      }
      return spelllistAbilities;
    }

    private Spell findSpell(final Node nameNode) {
      final String name = nameNode.getTextContent();
      for (final Spell spell : importContext.getAllSpells()) {
        if (spell.getName().equalsIgnoreCase(name)) {
          return spell;
        }
      }
      throw new IllegalArgumentException("Can't find spell with name: " + name + ". Ignoring spell slot.");
    }

    private SpelllistAbility findSpelllistAbility(final Node spelllistAbilityNode) {
      final String name = spelllistAbilityNode.getTextContent();
      for (final SpelllistAbility spelllistAbility : importContext.getAllSpelllistAbilities()) {
        if (spelllistAbility.getName().equalsIgnoreCase(name)) {
          return spelllistAbility;
        }
      }
      throw new IllegalArgumentException("Can't find spell list ability with name: " + name + ". Ignoring spell slot.");
    }

    private List<Feat> getMetamagicFeats(final Node metamagicFeatsNode) {
      final List<Feat> metamagicFeats = new ArrayList<Feat>();
      final NodeList metamagicFeatNodes = metamagicFeatsNode.getChildNodes();
      for (int i = 0; i < metamagicFeatNodes.getLength(); i++) {
        final Node metamagicFeatNode = metamagicFeatNodes.item(i);
        final Feat metamagicFeat = findMetamagicFeat(metamagicFeatNode);
        metamagicFeats.add(metamagicFeat);
      }
      return metamagicFeats;
    }

    private Feat findMetamagicFeat(final Node metamagicFeatNode) {
      final String name = metamagicFeatNode.getTextContent();
      for (final Feat metamagicFeat : importContext.getAllMetamagicFeats()) {
        if (metamagicFeat.getName().equalsIgnoreCase(name)) {
          return metamagicFeat;
        }
      }
      throw new IllegalArgumentException("Can't find metamagic feat with name: " + name + ". Ignoring spell slot.");
    }

  }

}
