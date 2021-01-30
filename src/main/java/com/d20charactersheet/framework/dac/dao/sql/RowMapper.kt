package com.d20charactersheet.framework.dac.dao.sql

import java.sql.SQLException

interface RowMapper {

    @Throws(SQLException::class)
    fun mapRow(dataRow: DataRow): Any
}