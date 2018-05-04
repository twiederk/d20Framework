package com.d20charactersheet.framework.boc.model;

/**
 * Thrown if a rule is violated.
 */
public class RuleException extends RuntimeException {

  private static final long serialVersionUID = 8752954117084066250L;

  private final RuleError ruleError;
  private final Object value;

  /**
   * Creates a RuleException with the violation.
   *
   * @param ruleError
   *     The violation of the rule.
   */
  public RuleException(final RuleError ruleError) {
    this(ruleError, null);
  }

  /**
   * Creates a RuleException with the given violation and value.
   *
   * @param ruleError
   *     The violation of the rule.
   * @param value
   *     The violating value.
   */
  public RuleException(final RuleError ruleError, final Object value) {
    super();
    this.ruleError = ruleError;
    this.value = value;
  }

  /**
   * Returns the violation of the rule.
   *
   * @return The violation of the rule.
   */
  public RuleError getRuleError() {
    return ruleError;
  }

  /**
   * Returns the violating value.
   *
   * @return The violating value.
   */
  public Object getValue() {
    return value;
  }

}
