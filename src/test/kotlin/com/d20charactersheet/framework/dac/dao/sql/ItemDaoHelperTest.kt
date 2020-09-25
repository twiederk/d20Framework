package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.ItemGroup
import com.d20charactersheet.framework.boc.model.Weapon
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcDatabase
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcHelper
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

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
class ItemDaoHelperTest {
    
    private lateinit var helper: ItemDaoHelper
    private lateinit var currentItems: List<ItemGroup>
    private lateinit var editedItems: List<ItemGroup>

    @Before
    fun setUp() {
        val jdbcHelper = JdbcHelper()
        jdbcHelper.executeSqlScript("/create_database.sql")
        jdbcHelper.executeSqlScript("/dndv35_phb_data.sql")
        jdbcHelper.executeSqlScript("/dndv35_phb_spell.sql")
        jdbcHelper.executeSqlScript("/dndv35_phb_character.sql")
        val jdbcDatabase = JdbcDatabase(jdbcHelper.connection)
        helper = SqlItemDaoHelper(jdbcDatabase)
        currentItems = createCurrentItems()
        editedItems = createEditedItems()
    }

    private fun createCurrentItems(): List<ItemGroup> {
        val currentItems: MutableList<ItemGroup> = LinkedList()
        for (i in 1..4) {
            currentItems.add(createItemGroup(i, i)) // creates 4 items with id = number
        }
        return currentItems
    }

    private fun createEditedItems(): List<ItemGroup> {
        val editedItems: MutableList<ItemGroup> = LinkedList()
        editedItems.add(createItemGroup(-1, 1)) // new added item => insert
        editedItems.add(createItemGroup(1, 1)) // nothing changed => nothing to do
        editedItems.add(createItemGroup(2, 1)) // removed one item => update
        editedItems.add(createItemGroup(3, 4)) // added one item => update
        // missing item with id 4 => delete
        return editedItems
    }

    private fun createItemGroup(id: Int, number: Int): ItemGroup {
        val itemGroup = ItemGroup()
        itemGroup.id = id
        itemGroup.number = number
        val weapon = Weapon()
        weapon.id = id
        itemGroup.item = weapon
        return itemGroup
    }

    @Test
    fun testGetItemsToDelete() {
        val itemsToDelete = helper.getItemsToDelete(currentItems, editedItems)
        Assert.assertNotNull(itemsToDelete)
        Assert.assertEquals(1, itemsToDelete.size.toLong())
        val itemToDelete = itemsToDelete[0]
        Assert.assertEquals(4, itemToDelete.id.toLong())
    }

    @Test
    fun testGetItemsToUpate() {
        val itemsToUpdate = helper.getItemsToUpdate(currentItems, editedItems)
        Assert.assertNotNull(itemsToUpdate)
        Assert.assertEquals(2, itemsToUpdate.size.toLong())
        var itemToUpdate = itemsToUpdate[0]
        Assert.assertEquals(2, itemToUpdate.id.toLong())
        Assert.assertEquals(1, itemToUpdate.number.toLong())
        itemToUpdate = itemsToUpdate[1]
        Assert.assertEquals(3, itemToUpdate.id.toLong())
        Assert.assertEquals(4, itemToUpdate.number.toLong())
    }

    @Test
    fun testGetItemsToInsert() {
        val itemsToInsert = helper.getItemsToInsert(editedItems)
        Assert.assertNotNull(itemsToInsert)
        Assert.assertEquals(1, itemsToInsert.size.toLong())
        val itemToInsert = itemsToInsert[0]
        Assert.assertEquals(-1, itemToInsert.id.toLong())
        Assert.assertEquals(1, itemToInsert.number.toLong())
    }

    @Test
    fun testGetUnmodifiedItems() {
        val itemsUnmodified = helper.getUnmodifiedItems(currentItems, editedItems)
        Assert.assertNotNull(itemsUnmodified)
        Assert.assertEquals(1, itemsUnmodified.size.toLong())
    }
}