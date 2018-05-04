package com.d20charactersheet.framework.boc.service;

import java.io.File;
import java.util.List;

import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.service.exportimport.ExportCharacter;
import com.d20charactersheet.framework.boc.service.exportimport.ExportCharacterXml;
import com.d20charactersheet.framework.boc.service.exportimport.ExportEquipment;
import com.d20charactersheet.framework.boc.service.exportimport.ExportEquipmentXml;
import com.d20charactersheet.framework.boc.service.exportimport.ImportCharacter;
import com.d20charactersheet.framework.boc.service.exportimport.ImportContext;
import com.d20charactersheet.framework.boc.service.exportimport.ImportEquipment;
import com.d20charactersheet.framework.boc.service.exportimport.ImportFactory;
import com.d20charactersheet.framework.boc.service.exportimport.ImportFactoryImpl;
import com.d20charactersheet.framework.boc.service.exportimport.ImportReport;

/**
 * Export and imports characters using xml.
 */
public class ExportImportServiceImpl implements ExportImportService {

  private final ImportFactory importFactory = new ImportFactoryImpl();

  @Override
  public File exportCharacters(final GameSystem gameSystem, final File exportFile, final List<Character> characters)
      throws Exception {
    final ExportCharacter exportCharacter = new ExportCharacterXml();
    exportCharacter.exportCharacters(gameSystem.getName(), exportFile, characters);
    return exportFile;
  }

  @Override
  public List<ImportReport<Character>> importCharacters(final GameSystem gameSystem, final File importFile) throws Exception {
    final ImportContext importContext = new ImportContext();
    importContext.setGameSystemName(gameSystem.getName());
    importContext.setAllRaces(gameSystem.getAllRaces());
    importContext.setAllClasses(gameSystem.getAllCharacterClasses());
    importContext.setAllXpTables(gameSystem.getAllXpTables());
    importContext.setAllSkills(gameSystem.getAllSkills());
    importContext.setAllFeats(gameSystem.getAllFeats());
    importContext.setAllWeapons(gameSystem.getAllWeapons());
    importContext.setAllArmor(gameSystem.getAllArmor());
    importContext.setAllGoods(gameSystem.getAllGoods());
    importContext.setAllSpells(gameSystem.getAllSpells());
    importContext.setAllSpelllists(gameSystem.getAllSpelllists());
    importContext.setAllAbilities(gameSystem.getAllAbilities());

    final ImportCharacter importCharacter = importFactory.getImportCharacter(importContext, importFile);
    final List<ImportReport<Character>> importReports = importCharacter.importCharacters();
    return importReports;
  }

  @Override
  public File exportEquipment(final GameSystem gameSystem, final File exportFile, final List<Weapon> weapons,
      final List<Armor> armor, final List<Good> goods) throws Exception {
    final ExportEquipment exportWeapon = new ExportEquipmentXml();
    exportWeapon.exportEquipment(gameSystem.getName(), exportFile, weapons, armor, goods);
    return exportFile;
  }

  @Override
  public List<ImportReport<? extends Item>> importEquipment(final GameSystem gameSystem, final File importFile) throws Exception {
    final ImportContext importContext = new ImportContext();
    importContext.setGameSystemName(gameSystem.getName());
    importContext.setAllWeapons(gameSystem.getAllWeapons());
    importContext.setAllWeaponFamilies(gameSystem.getAllWeaponFamilies());
    importContext.setAllArmor(gameSystem.getAllArmor());
    importContext.setAllGoods(gameSystem.getAllGoods());

    final ImportEquipment importEquipment = importFactory.getImportEquipment(importContext, importFile);
    final List<ImportReport<? extends Item>> importReports = importEquipment.importEquipment();
    return importReports;
  }

}
