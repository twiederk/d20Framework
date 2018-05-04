package com.d20charactersheet.framework.dac.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.d20charactersheet.framework.boc.model.ItemGroup;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.dac.dao.dummy.DummyItemDaoHelper;

// currentItems
// Id | Number
// -----------
//  1 | 1
//  2 | 2
//  3 | 3
//  4 | 4

// editedItems
// Id  | Number
// -----------
//  -1 | 1 new added => insert
//   1 | 1 nothing changed => nothing todo
//   2 | 1 removed one => update
//   3 | 4 added one => update
//         missing item with id 4 => delete

public class ItemDaoHelperTest {

  private ItemDaoHelper helper;
  private List<ItemGroup> currentItems;
  private List<ItemGroup> editedItems;

  @Before
  public void setUp() throws Exception {
    helper = new DummyItemDaoHelper(null, null, null);
    currentItems = createCurrentItems();
    editedItems = createEditedItems();
  }

  private List<ItemGroup> createCurrentItems() {
    final List<ItemGroup> currentItems = new LinkedList<ItemGroup>();
    for (int i = 1; i <= 4; i++) {
      currentItems.add(createItemGroup(i, i)); // creates 4 items with id = number
    }
    return currentItems;
  }

  private List<ItemGroup> createEditedItems() {
    final List<ItemGroup> editedItems = new LinkedList<ItemGroup>();
    editedItems.add(createItemGroup(-1, 1)); // new added item => insert
    editedItems.add(createItemGroup(1, 1)); // nothing changed => nothing to do
    editedItems.add(createItemGroup(2, 1)); // removed one item => update
    editedItems.add(createItemGroup(3, 4)); // added one item => update
    // missing item with id 4 => delete
    return editedItems;
  }

  private ItemGroup createItemGroup(final int id, final int number) {
    final ItemGroup itemGroup = new ItemGroup();
    itemGroup.setId(id);
    itemGroup.setNumber(number);
    final Weapon weapon = new Weapon();
    weapon.setId(id);
    itemGroup.setItem(weapon);
    return itemGroup;
  }

  @Test
  public void testGetItemsToDelete() throws Exception {
    final List<ItemGroup> itemsToDelete = helper.getItemsToDelete(currentItems, editedItems);

    assertNotNull(itemsToDelete);
    assertEquals(1, itemsToDelete.size());
    final ItemGroup itemToDelete = itemsToDelete.get(0);
    assertEquals(4, itemToDelete.getId());
  }

  @Test
  public void testGetItemsToUpate() throws Exception {
    final List<ItemGroup> itemsToUpdate = helper.getItemsToUpdate(currentItems, editedItems);

    assertNotNull(itemsToUpdate);
    assertEquals(2, itemsToUpdate.size());

    ItemGroup itemToUpdate = itemsToUpdate.get(0);
    assertEquals(2, itemToUpdate.getId());
    assertEquals(1, itemToUpdate.getNumber());

    itemToUpdate = itemsToUpdate.get(1);
    assertEquals(3, itemToUpdate.getId());
    assertEquals(4, itemToUpdate.getNumber());
  }

  @Test
  public void testGetItemsToInsert() throws Exception {
    final List<ItemGroup> itemsToInsert = helper.getItemsToInsert(editedItems);

    assertNotNull(itemsToInsert);
    assertEquals(1, itemsToInsert.size());

    final ItemGroup itemToInsert = itemsToInsert.get(0);
    assertEquals(-1, itemToInsert.getId());
    assertEquals(1, itemToInsert.getNumber());
  }

  @Test
  public void testGetUnmodifiedItems() throws Exception {
    final List<ItemGroup> itemsUnmodified = helper.getUnmodifiedItems(currentItems, editedItems);

    assertNotNull(itemsUnmodified);
    assertEquals(1, itemsUnmodified.size());
  }
}
