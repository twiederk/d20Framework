package com.d20charactersheet.framework.dac.dao.dummy;

import java.util.List;

import com.androidash.memorydb.DataTable;
import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.ItemGroup;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.dac.dao.ItemDaoHelper;

/**
 * Extension of ItemDaoHelper specific for DummyItemDao.
 */
public class DummyItemDaoHelper extends ItemDaoHelper {

  private final DataTable characterWeaponDataTable;
  private final DataTable characterArmorDataTable;
  private final DataTable characterGoodDataTable;

  /**
   * Creates helper using the given tables to store weapons, armor and goods of the characters.
   *
   * @param charakterWeaponDataTable The data table of the characters weapons.
   * @param characterArmorDataTable The data table of the characters armor.
   * @param characterGoodDataTable The data table of the characters goods.
   */
  public DummyItemDaoHelper(final DataTable charakterWeaponDataTable, final DataTable characterArmorDataTable,
      final DataTable characterGoodDataTable) {
    super();
    this.characterWeaponDataTable = charakterWeaponDataTable;
    this.characterArmorDataTable = characterArmorDataTable;
    this.characterGoodDataTable = characterGoodDataTable;
  }

  @Override
  protected void deleteItemGroups(final List<ItemGroup> currentItems, final List<ItemGroup> editedItems, final String classname) {
    final List<ItemGroup> itemsToDelete = getItemsToDelete(currentItems, editedItems);
    final DataTable dataTable = getDataTable(classname);
    for (final ItemGroup itemToDelete : itemsToDelete) {
      dataTable.delete(itemToDelete.getId());
    }
  }

  private DataTable getDataTable(final String classname) {
    if (Weapon.class.getSimpleName().equals(classname)) {
      return characterWeaponDataTable;
    } else if (Armor.class.getSimpleName().equals(classname)) {
      return characterArmorDataTable;
    } else if (Good.class.getSimpleName().equals(classname)) {
      return characterGoodDataTable;
    }
    throw new IllegalArgumentException("Can't determine column name of " + classname);
  }

  @Override
  protected List<ItemGroup> updateItemGroups(final List<ItemGroup> currentItems, final List<ItemGroup> editedItems,
      final String classname, final int characterId) {
    final List<ItemGroup> itemsToUpdate = getItemsToUpdate(currentItems, editedItems);
    final DataTable dataTable = getDataTable(classname);
    for (final ItemGroup itemToUpdate : itemsToUpdate) {
      dataTable.delete(itemToUpdate.getId());
      dataTable.insert(new Object[] {itemToUpdate.getId(), characterId, itemToUpdate.getItem().getId(), itemToUpdate.getNumber()});
    }
    return itemsToUpdate;
  }

  @Override
  protected List<ItemGroup> insertItemGroups(final List<ItemGroup> editedItems, final String classname, final int characterId) {
    final List<ItemGroup> itemsToInsert = getItemsToInsert(editedItems);
    final DataTable dataTable = getDataTable(classname);
    for (final ItemGroup itemToInsert : itemsToInsert) {
      itemToInsert.setId(dataTable.getNewId());
      dataTable.insert(new Object[] {itemToInsert.getId(), characterId, itemToInsert.getItem().getId(), itemToInsert.getNumber()});
    }
    return itemsToInsert;
  }

}
