package com.d20charactersheet.framework.dac.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.d20charactersheet.framework.boc.model.ItemGroup;

/**
 * Supports implementations of ItemDao. A character can carry a lot of items. Deleting all items an inserting them new
 * in the database, would take a lot of time. This Helper can detemine which items to delete, to insert or to update.
 * Thus only necessary changes are done, which is much faster. The method updateItems is the interface of the
 * ItemDaoHelper. While the methods insertItemGroups, updateItemGroups and deleteItemGroups must be imlemented specific
 * to the Dao.
 */
public abstract class ItemDaoHelper {

  /**
   * Updates items in performant way. Insert new items, update changed items and delete dropped items.
   *
   * @param currentItems
   *     The current items of the character.
   * @param editedItems
   *     The items edited by the user.
   * @param tableName
   *     The name of the items table like TABLE_WEAPON.
   * @param characterId
   *     The id of the character to update its weapons.
   *
   * @return The updated list of the characters items.
   */
  public List<ItemGroup> updateItems(final List<ItemGroup> currentItems, final List<ItemGroup> editedItems, final String tableName,
      final int characterId) {
    deleteItemGroups(currentItems, editedItems, tableName);
    final List<ItemGroup> updatedItems = new ArrayList<>();
    updatedItems.addAll(updateItemGroups(currentItems, editedItems, tableName, characterId));
    updatedItems.addAll(insertItemGroups(editedItems, tableName, characterId));
    updatedItems.addAll(getUnmodifiedItems(currentItems, editedItems));
    return updatedItems;
  }

  List<ItemGroup> getUnmodifiedItems(final List<ItemGroup> currentItems, final List<ItemGroup> editedItems) {
    final List<ItemGroup> itemsUnmodified = new LinkedList<>();
    for (final ItemGroup currentItem : currentItems) {
      if (isUnmodified(currentItem, editedItems)) {
        itemsUnmodified.add(currentItem);
      }
    }
    return itemsUnmodified;
  }

  private boolean isUnmodified(final ItemGroup currentItem, final List<ItemGroup> editedItems) {
    for (final ItemGroup editedItem : editedItems) {
      if (currentItem.getItem().getId() == editedItem.getItem().getId() //
          && currentItem.getNumber() == editedItem.getNumber()) {
        return true;
      }
    }
    return false;
  }

  protected List<ItemGroup> getItemsToDelete(final List<ItemGroup> currentItems, final List<ItemGroup> editedItems) {
    final List<ItemGroup> itemsToDelete = new LinkedList<>();
    for (final ItemGroup currentItem : currentItems) {
      if (isDeleted(currentItem, editedItems)) {
        itemsToDelete.add(currentItem);
      }
    }
    return itemsToDelete;
  }

  private boolean isDeleted(final ItemGroup currentItem, final List<ItemGroup> editedItems) {
    for (final ItemGroup editedItem : editedItems) {
      if (currentItem.getId() == editedItem.getId()) {
        return false;
      }
    }
    return true;
  }

  protected List<ItemGroup> getItemsToUpdate(final List<ItemGroup> currentItems, final List<ItemGroup> editedItems) {
    final List<ItemGroup> itemsToUpdate = new LinkedList<>();
    for (final ItemGroup currentItem : currentItems) {
      final ItemGroup editedItem = getEditedItem(currentItem, editedItems);
      if (editedItem != null) {
        itemsToUpdate.add(editedItem);
      }
    }
    return itemsToUpdate;
  }

  private ItemGroup getEditedItem(final ItemGroup currentItem, final List<ItemGroup> editedItems) {
    for (final ItemGroup editedItem : editedItems) {
      if (currentItem.getId() == editedItem.getId() //
          && editedItem.getNumber() > 0 //
          && currentItem.getNumber() != editedItem.getNumber()) {
        return editedItem;
      }
    }
    return null;
  }

  protected List<ItemGroup> getItemsToInsert(final List<ItemGroup> editedItems) {
    final List<ItemGroup> itemsToInsert = new LinkedList<>();
    for (final ItemGroup editedItem : editedItems) {
      if (editedItem.getNumber() > 0 //
          && editedItem.getId() == -1) {
        itemsToInsert.add(editedItem);
      }
    }
    return itemsToInsert;
  }

  protected abstract void deleteItemGroups(List<ItemGroup> currentItems, List<ItemGroup> editedItems, String classname);

  protected abstract List<ItemGroup> updateItemGroups(List<ItemGroup> currentItems, List<ItemGroup> editedItems, String classname,
      int characterId);

  protected abstract List<ItemGroup> insertItemGroups(List<ItemGroup> editedItems, String classname, int characterId);

}
