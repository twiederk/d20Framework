package com.d20charactersheet.framework.boc.service.exportimport;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Provides proper import implementation based on the version of the import file.
 */
public class ImportFactoryImpl implements ImportFactory, XmlConstants {

  @Override
  public ImportCharacter getImportCharacter(final ImportContext importContext, final File importFile) throws Exception {
    final Document document = parseDocument(importFile);
    checkGameSystem(importContext.getGameSystemName(), document.getDocumentElement());
    final ImportCharacter importCharacter = getImportCharacter(importContext, document);
    return importCharacter;
  }

  private ImportCharacter getImportCharacter(final ImportContext importContext, final Document document) {
    final int version = getVersion(document);

    switch (version) {
      case 1:
        return new ImportCharacterV1Xml(importContext, document);
      case 2:
        return new ImportCharacterV2Xml(importContext, document);

      default:
        throw new IllegalArgumentException("Can't find ImportCharacter for version: " + version);
    }
  }

  @Override
  public ImportEquipment getImportEquipment(final ImportContext importContext, final File importFile) throws Exception {
    final Document document = parseDocument(importFile);
    checkGameSystem(importContext.getGameSystemName(), document.getDocumentElement());
    final ImportEquipment importEquipment = getImportEquipment(importContext, document);
    return importEquipment;
  }

  private ImportEquipment getImportEquipment(final ImportContext importContext, final Document document) {
    final int version = getVersion(document);

    switch (version) {
      case 1:
        return new ImportEquipmentV1Xml(importContext, document);

      default:
        throw new IllegalArgumentException("Can't find ImportEquipment for version: " + version);
    }
  }

  private Document parseDocument(final File importFile) throws Exception {
    final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    final DocumentBuilder builder = factory.newDocumentBuilder();
    final Document document = builder.parse(importFile);
    return document;
  }

  void checkGameSystem(final String gameSystemName, final Element documentElement) {
    final String name = documentElement.getAttribute(ATTRIBUTE_GAMESYSTEM);
    if (!gameSystemName.equalsIgnoreCase(name)) {
      throw new IllegalStateException("Import file belongs to " + name //
                                          + ", but current game system is " + gameSystemName);
    }
  }

  private int getVersion(final Document document) {
    final Element charactersElement = document.getDocumentElement();
    final String version = charactersElement.getAttribute(ATTRIBUTE_VERSION);
    return Integer.parseInt(version);
  }

}
