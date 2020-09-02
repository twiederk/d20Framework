package com.d20charactersheet.framework.boc.service.exportimport;

import java.io.PrintStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Base class to derive classes which export to xml. Offers methods to support this export.
 */
public abstract class XmlExport implements XmlConstants {

  Document document;

  void createDocument() throws Exception {
    final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    final DocumentBuilder builder = factory.newDocumentBuilder();
    document = builder.newDocument();
  }

  Element createElementWithText(final boolean text) {
    final Element element = document.createElement(XmlConstants.TAG_CAST);
    element.setTextContent(Boolean.toString(text));
    return element;
  }

  Element createElementWithText(final String name, final int text) {
    final Element element = document.createElement(name);
    element.setTextContent(Integer.toString(text));
    return element;
  }

  Element createElementWithText(final String name, final float text) {
    final Element element = document.createElement(name);
    element.setTextContent(Float.toString(text));
    return element;
  }

  Element createElementWithText(final String name, final String text) {
    final Element element = document.createElement(name);
    element.setTextContent(text);
    return element;
  }

  void write(final PrintStream printStream, final String doctypeSystem, final String doctypePublic) throws Exception {
    final Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctypeSystem);
    transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, doctypePublic);
    transformer.transform(new DOMSource(document), new StreamResult(printStream));
  }

}
