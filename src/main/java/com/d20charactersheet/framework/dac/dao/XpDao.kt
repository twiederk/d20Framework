package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.XpTable

/**
 * Access object to persistent layer for xp tables.
 */
interface XpDao {
    
    /**
     * Returns all xp tables from the persistent layer.
     *
     * @return All xp tables from the persistent layer.
     */
    fun getAllXpTables(): List<XpTable>
}