package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.ItemGroup;
import com.d20charactersheet.framework.dac.dao.BaseRowMapper;
import com.d20charactersheet.framework.dac.dao.DataRow;

/**
 * Maps raw data to an item group.
 */
public class ItemGroupRowMapper extends BaseRowMapper {

    private final List<? extends Item> allItems;

    /**
     * All available items to map.
     *
     * @param allItems
     *     All available items to map.
     */
    public ItemGroupRowMapper(final List<? extends Item> allItems) {
        super();
        this.allItems = allItems;
    }

    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws java.sql.SQLException {
        // id, weapon_id, number
        final ItemGroup itemGroup = new ItemGroup();
        itemGroup.setId(dataRow.getInt(0));
        itemGroup.setItem(getItem(dataRow.getInt(1), allItems));
        itemGroup.setNumber(dataRow.getInt(2));
        return itemGroup;
    }

}
