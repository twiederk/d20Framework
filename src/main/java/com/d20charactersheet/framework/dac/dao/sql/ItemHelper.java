package com.d20charactersheet.framework.dac.dao.sql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.ItemGroup;
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.ItemGroupRowMapper;

/**
 * Helper to retrieve all items of a specific implementation (weapon, armor, good) from the database. Retrieves all items
 * of a character of a specific item type.
 */
class ItemHelper {

    final Database db;
    final SqlItemDaoHelper helper;

    /**
     * Creates ItemHelper with given database and helper.
     *
     * @param db
     *     The database to connect to.
     * @param helper
     *     The helper to handle basic item tasks.
     */
    ItemHelper(final Database db, final SqlItemDaoHelper helper) {
        this.db = db;
        this.helper = helper;
    }

    /**
     * Returns all items of a sub type of item.
     *
     * @param sql
     *     The sql to select all items of the sub type.
     * @param rowMapper
     *     Rowmapper to map row data to sub type of item.
     *
     * @return All items of a sub type of item.
     */
    List<Item> getAllItems(final String sql, final RowMapper rowMapper) {
        final List<Item> allItems = new ArrayList<>();
        QueryResult queryResult = null;
        try {
            queryResult = db.rawQuery(sql, new String[0]);
            for (queryResult.moveToFirst(); !queryResult.isAfterLast(); queryResult.moveToNext()) {
                final Item item = (Item) rowMapper.mapRow(queryResult.getDataRow());
                allItems.add(item);
            }
        } catch (final SQLException sqlException) {
            //            Logger.error("Can't get all items", sqlException);
        } finally {
            if (queryResult != null) {
                queryResult.close();
            }
        }
        return allItems;
    }

    /**
     * Returns all items of a character grouped together.
     *
     * @param sql
     *     The sql to select the a subtype of an item.
     * @param character
     *     The character to get its items grouped.
     * @param allItems
     *     All items available in the game system.
     *
     * @return All items of a character grouped together.
     */
    List<ItemGroup> getItemGroups(final String sql, final Character character, final List<? extends Item> allItems) {
        final List<ItemGroup> itemGroups = new ArrayList<>();
        QueryResult queryResult = null;
        try {
            final String[] params = new String[] {Integer.toString(character.getId())};
            queryResult = db.rawQuery(sql, params);
            final ItemGroupRowMapper itemGroupRowMapper = new ItemGroupRowMapper(allItems);
            for (queryResult.moveToFirst(); !queryResult.isAfterLast(); queryResult.moveToNext()) {
                mapAndAddItemGroup(queryResult, itemGroups, itemGroupRowMapper);
            }
        } catch (final SQLException sqlException) {
            //            Logger.error("Can't get items of character", sqlException);
        } finally {
            if (queryResult != null) {
                queryResult.close();
            }
        }
        return itemGroups;
    }

    private void mapAndAddItemGroup(final QueryResult queryResult, final List<ItemGroup> characterItem,
        final ItemGroupRowMapper itemGroupRowMapper) {
        try {
            final ItemGroup itemGroup = (ItemGroup) itemGroupRowMapper.mapRow(queryResult.getDataRow());
            characterItem.add(itemGroup);
        } catch (final Exception exception) {
            //            Logger.error("Can't map item group, skipping it", exception);
        }
    }

}
