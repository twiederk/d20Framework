package com.d20charactersheet.framework.boc.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.Test;

public class BodyTest {

  @Test
  public void testBody() {
    // Arrange
    Body body = new HumanoidBody();

    // Act
    Set<BodyPart> bodyParts = body.getBodyParts();

    // Assert
    assertThat(bodyParts).hasSize(15);
    bodyParts.forEach(bodyPart -> assertThat(body.getItemOfBodyPart(bodyPart)).isEqualTo(Item.EMPTY_ITEM));
  }

  @Test
  public void testEquippedItems() {
    // Arrange
    Body body = new HumanoidBody();
    Armor armor = new Armor();
    armor.setName("Armor");
    body.equip(BodyPart.BOTH_HANDS, armor);

    Weapon weapon = new Weapon();
    weapon.setName("Weapon");
    body.equip(BodyPart.PRIMARY_HAND, weapon);

    // Act
    List<Item> equippedItems = body.getEquippedItems();

    // Assert
    assertThat(equippedItems).extracting("name").containsExactlyInAnyOrder("Armor", "Weapon");

  }

}
