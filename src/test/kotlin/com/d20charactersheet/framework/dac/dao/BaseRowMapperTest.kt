package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.Alignment
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.BaseRowMapper
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.sql.SQLException

class BaseRowMapperTest {

    private lateinit var baseRowMapper: BaseRowMapper

    @Before
    fun setUp() {
        baseRowMapper = object : BaseRowMapper() {
            @Throws(SQLException::class)
            override fun mapRow(dataRow: DataRow) = Any()
        }
    }

    @Test
    fun testGetEnum() {
        val alignment = baseRowMapper.getEnum(0, Alignment.values() as Array<Enum<*>>) as Alignment
        Assert.assertEquals(Alignment.LAWFUL_GOOD, alignment)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testGetEnumWithException() {
        baseRowMapper.getEnum(100, Alignment.values() as Array<Enum<*>>)
    }

}