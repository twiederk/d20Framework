package com.d20charactersheet.framework.boc.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DnDv35RuleServiceAmorClassTest extends DnDv35RuleServiceTestCase {

  @Test
  public void getArmorClassOfBelvador() {
    // Act
    int armorClass = ruleService.getArmorClass(belvador);

    // Assert
    Assertions.assertThat(armorClass).isEqualTo(14);
  }

  @Test
  public void getArmorClassOfNascan() {
    // Act
    int armorClass = ruleService.getArmorClass(nascan);

    // Assert
    Assertions.assertThat(armorClass).isEqualTo(18);
  }

  @Test
  public void getArmorClassOfTocDerJuengere() {
    // Act
    int armorClass = ruleService.getArmorClass(toc);

    // Assert
    Assertions.assertThat(armorClass).isEqualTo(16);
  }


}