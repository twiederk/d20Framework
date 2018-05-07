package com.d20charactersheet.framework.boc.service.exportimport;

import java.util.ArrayList;
import java.util.List;

/**
 * The import report is created by importing an object. It contains the imported object and messages about the import.
 * The import contains all messages about the import, even if the whole import failed.
 *
 * @param <T>
 *     The class created by the import.
 */
public class ImportReport<T> {

  private final T importObject;
  private final List<ImportMessage> importMessages;

  /**
   * Creates an import report.
   *
   * @param importObject
   *     The empty object to import.
   */
  public ImportReport(final T importObject) {
    this.importObject = importObject;
    importMessages = new ArrayList<ImportMessage>();
  }

  /**
   * Returns the imported object.
   *
   * @return The imported object.
   */
  public T getImportObject() {
    return importObject;
  }

  /**
   * Adds an import message to the report.
   *
   * @param importMessage The import message.
   */
  public void addMessage(final ImportMessage importMessage) {
    importMessages.add(importMessage);
  }

  /**
   * Returns all import messages of the import.
   *
   * @return All import messages of the import.
   */
  public List<ImportMessage> getImportMessages() {
    return importMessages;
  }

  /**
   * Returns true, if the whole import of the object was a success.
   *
   * @return True, if the whole import of the object was a success.
   */
  public boolean isSuccess() {
    for (final ImportMessage importMessage : importMessages) {
      if (importMessage.getType().equals(ImportMessage.Type.ERROR)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public String toString() {
    return "ImportReport [importObject=" + importObject + ", importMessages=" + importMessages + "]";
  }

}
