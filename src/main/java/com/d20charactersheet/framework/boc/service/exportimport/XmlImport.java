package com.d20charactersheet.framework.boc.service.exportimport;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * Base class to derive classes from which import from xml files. Provides common methods for xml handling.
 */
public class XmlImport implements XmlConstants {

  final protected ImportContext importContext;
  final protected Document document;

  /**
   * Creates XmlImport with given import context for import and the document to import.
   *
   * @param importContext
   *     The data necessary to import data.
   * @param document
   *     The document to import.
   */
  public XmlImport(final ImportContext importContext, final Document document) {
    this.importContext = importContext;
    this.document = document;
  }

  protected int getInt(final Node node) {
    return Integer.parseInt(node.getTextContent());
  }

  protected Date getDate(final Node node, final DateFormat dateFormat) throws ParseException {
    final String textContent = node.getTextContent();
    return dateFormat.parse(textContent);
  }

  protected float getFloat(final Node node) {
    return Float.parseFloat(node.getTextContent());
  }

  protected boolean getBoolean(final Node node) {
    return Boolean.parseBoolean(node.getTextContent());
  }
}
