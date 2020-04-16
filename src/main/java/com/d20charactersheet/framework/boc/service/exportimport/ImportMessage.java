package com.d20charactersheet.framework.boc.service.exportimport;

/**
 * The ImportMessage is part of an ImportReport and contains information about the import. Each message holds a type
 * which expresses how serious this message is.
 */
public class ImportMessage {

  private final Type type;
  private final String message;

  /**
   * Creates ImportMessage with given message an type.
   *
   * @param message
   *     The message about the import.
   * @param type
   *     The type of the import.
   */
  public ImportMessage(final String message, final Type type) {
    this.message = message;
    this.type = type;
  }

  /**
   * Returns the type of the message.
   *
   * @return The type of the message.
   */
  public Type getType() {
    return type;
  }

  /**
   * Returns the message.
   *
   * @return The message.
   */
  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return type + ": " + message;
  }

  /**
   * The type of the message how serious the message is.
   */
  public enum Type {
    /**
     * The whole import was a success
     */
    SUCCESS, /**
     * The whole import was a failure
     */
    FAILURE, /**
     * A minor error occurred, which broke only a part of the import, but not the whole.
     */
    WARNING, /**
     * An error occured, which broke the whole import.
     */
    ERROR
  }

}
