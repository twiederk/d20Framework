package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.androidash.memorydb.DaoUtil
import com.d20charactersheet.framework.boc.model.*
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import com.d20charactersheet.framework.dac.dao.sql.RowMapper
import java.sql.SQLException
import java.text.DateFormat
import java.text.ParseException
import java.util.*

/**
 * Base class of row mapper implementations. Contains util function to map enumerations.
 */
abstract class BaseRowMapper : RowMapper {

    private val daoUtil: DaoUtil = DaoUtil()

    /**
     * @see com.d20charactersheet.framework.dac.dao.sql.RowMapper.mapRow
     */
    @Throws(SQLException::class)
    abstract override fun mapRow(dataRow: DataRow): Any

    fun getBoolean(booleanId: Int): Boolean {
        if (booleanId == 0) {
            return false
        } else if (booleanId == 1) {
            return true
        }
        throw IllegalArgumentException("Can't determine boolean of: $booleanId")
    }

    /**
     * Returns the race enum of the given race id.
     *
     * @param raceId
     * The race id.
     * @return The race enum of the given race id.
     */
    fun getRace(raceId: Int, allRaces: List<Race>): Race {
        for (race in allRaces) {
            if (race.id == raceId) {
                return race
            }
        }
        throw IllegalArgumentException("Can't determine Race of raceId: $raceId")
    }

    fun getCharacterClass(characterClassId: Int, allCharacterClasses: List<CharacterClass>): CharacterClass? {
        for (characterClass in allCharacterClasses) {
            if (characterClass.id == characterClassId) {
                return characterClass
            }
        }
        return null
    }

    fun getItem(itemId: Int, allItems: List<Item>): Item {
        for (item in allItems) {
            if (item.id == itemId) {
                return item
            }
        }
        throw IllegalArgumentException("Can't determine item with id: $itemId")
    }

    fun parseDate(dateParameter: String?, dateFormat: DateFormat): Date {
        val date: Date
        date = try {
            dateFormat.parse(dateParameter)
        } catch (parseException: ParseException) {
            parseException.printStackTrace()
            throw RuntimeException(parseException)
        }
        return date
    }

    fun getQualityType(qualityTypeId: Int): QualityType {
        for (qualityType in QualityType.values()) {
            if (qualityType.ordinal == qualityTypeId) {
                return qualityType
            }
        }
        throw IllegalArgumentException("Can't determine QualityType of qualityTypeId: $qualityTypeId")
    }

    fun <U : Enum<U>?> getEnums(ids: Int, enumClass: Class<U>): EnumSet<U> {
        val enumSet = EnumSet.noneOf(enumClass)
        for (currentEnum in Objects.requireNonNull(enumClass.enumConstants)) {
            val mask = 1 shl currentEnum!!.ordinal
            if (ids and mask > 0) {
                enumSet.add(currentEnum)
            }
        }
        return enumSet
    }

    /**
     * Returns the enum with the proper id.
     *
     * @param id
     * The id of the enum to get.
     * @param values
     * The enum values to get the enum from.
     * @return The enum with the proper id.
     */
    fun getEnum(id: Int, values: Array<Enum<*>>): Enum<*> {
        return daoUtil.getEnum(id, values)
    }

    fun getXpTable(xpTableId: Int, allXpTables: List<XpTable>): XpTable {
        for (xpTable in allXpTables) {
            if (xpTable.id == xpTableId) {
                return xpTable
            }
        }
        throw IllegalArgumentException("Can't find xp table with id: $xpTableId")
    }

}