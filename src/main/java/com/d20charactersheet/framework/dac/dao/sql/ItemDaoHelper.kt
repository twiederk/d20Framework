package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.ItemGroup
import java.util.*

/**
 * Supports implementations of ItemDao. A character can carry a lot of items. Deleting all items and inserting them new
 * in the database, would take a lot of time. This Helper can detemine which items to delete, to insert or to update.
 * Only necessary changes are done, which is much faster. The method updateItems is the interface of the
 * ItemDaoHelper. While the methods insertItemGroups, updateItemGroups and deleteItemGroups must be imlemented specific
 * to the Dao.
 */
abstract class ItemDaoHelper {
    /**
     * Updates items in performant way. Insert new items, update changed items and delete dropped items.
     *
     * @param currentItems
     * The current items of the character.
     * @param editedItems
     * The items edited by the user.
     * @param tableName
     * The name of the items table like TABLE_WEAPON.
     * @param characterId
     * The id of the character to update its weapons.
     *
     * @return The updated list of the characters items.
     */
    fun updateItems(currentItems: List<ItemGroup>, editedItems: List<ItemGroup>, tableName: String,
                    characterId: Int): List<ItemGroup> {
        deleteItemGroups(currentItems, editedItems, tableName)
        val updatedItems: MutableList<ItemGroup> = ArrayList()
        updatedItems.addAll(updateItemGroups(currentItems, editedItems, tableName, characterId))
        updatedItems.addAll(insertItemGroups(editedItems, tableName, characterId))
        updatedItems.addAll(getUnmodifiedItems(currentItems, editedItems))
        return updatedItems
    }

    fun getUnmodifiedItems(currentItems: List<ItemGroup>, editedItems: List<ItemGroup>): List<ItemGroup> {
        val itemsUnmodified: MutableList<ItemGroup> = LinkedList()
        for (currentItem in currentItems) {
            if (isUnmodified(currentItem, editedItems)) {
                itemsUnmodified.add(currentItem)
            }
        }
        return itemsUnmodified
    }

    private fun isUnmodified(currentItem: ItemGroup, editedItems: List<ItemGroup>): Boolean {
        for (editedItem in editedItems) {
            if (currentItem.item.id == editedItem.item.id //
                    && currentItem.number == editedItem.number) {
                return true
            }
        }
        return false
    }

    fun getItemsToDelete(currentItems: List<ItemGroup>, editedItems: List<ItemGroup>): List<ItemGroup> {
        val itemsToDelete: MutableList<ItemGroup> = LinkedList()
        for (currentItem in currentItems) {
            if (isDeleted(currentItem, editedItems)) {
                itemsToDelete.add(currentItem)
            }
        }
        return itemsToDelete
    }

    private fun isDeleted(currentItem: ItemGroup, editedItems: List<ItemGroup>): Boolean {
        for (editedItem in editedItems) {
            if (currentItem.id == editedItem.id) {
                return false
            }
        }
        return true
    }

    fun getItemsToUpdate(currentItems: List<ItemGroup>, editedItems: List<ItemGroup>): List<ItemGroup> {
        val itemsToUpdate: MutableList<ItemGroup> = LinkedList()
        for (currentItem in currentItems) {
            val editedItem = getEditedItem(currentItem, editedItems)
            if (editedItem != null) {
                itemsToUpdate.add(editedItem)
            }
        }
        return itemsToUpdate
    }

    private fun getEditedItem(currentItem: ItemGroup, editedItems: List<ItemGroup>): ItemGroup? {
        for (editedItem in editedItems) {
            if (currentItem.id == editedItem.id //
                    && editedItem.number > 0 //
                    && currentItem.number != editedItem.number) {
                return editedItem
            }
        }
        return null
    }

    fun getItemsToInsert(editedItems: List<ItemGroup>): List<ItemGroup> {
        val itemsToInsert: MutableList<ItemGroup> = LinkedList()
        for (editedItem in editedItems) {
            if (editedItem.number > 0 //
                    && editedItem.id == -1) {
                itemsToInsert.add(editedItem)
            }
        }
        return itemsToInsert
    }

    protected abstract fun deleteItemGroups(currentItems: List<ItemGroup>, editedItems: List<ItemGroup>, tableName: String)

    protected abstract fun updateItemGroups(currentItems: List<ItemGroup>, editedItems: List<ItemGroup>, tableName: String,
                                            characterId: Int): List<ItemGroup>

    protected abstract fun insertItemGroups(editedItems: List<ItemGroup>, tableName: String, characterId: Int): List<ItemGroup>
}