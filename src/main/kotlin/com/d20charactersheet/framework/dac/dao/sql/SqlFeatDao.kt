package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.Feat
import com.d20charactersheet.framework.dac.dao.FeatDao
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_BENEFIT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_FEAT_TYPE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_FIGHTER_BONUS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_MULTIPLE
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_NAME
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_PREREQUISITE
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SPELL_SLOT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_STACK
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_FEATS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_WHERE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_FEAT
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.FeatRowMapper
import java.sql.SQLException
import java.util.*

/**
 * Implementation of FeatDao to access data in a SQLite database on an Android device.
 */
class SqlFeatDao(private val db: Database) : FeatDao {

    private val featRowMapper: RowMapper = FeatRowMapper()

    companion object {
        private const val SQL_GET_ID: String = SELECT + "id FROM " + TABLE_FEAT + " WHERE rowid = ?"
    }


    /**
     * Returns all feats. Caches feats after first request.
     *
     * @see FeatDao.getAllFeats
     */
    override fun getAllFeats(): List<Feat> {
        val feats: MutableList<Feat> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            queryResult = db.rawQuery(SQL_GET_ALL_FEATS, arrayOf())
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val staticFeat = featRowMapper.mapRow(queryResult.getDataRow()) as Feat
                feats.add(staticFeat)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get all feats", sqlException);
        } finally {
            queryResult?.close()
        }
        return feats
    }

    /**
     * @see FeatDao.createFeat
     */
    override fun createFeat(feat: Feat) {
        insertFeatTable(feat)
    }

    private fun insertFeatTable(feat: Feat) {
        val featValues = getFeatValues(feat)
        featValues.putNull(COLUMN_ID)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_FEAT, featValues)
            check(rowId != -1L) { "Can't insert feat in feat table" }
            feat.id = db.queryId(SQL_GET_ID, rowId)
        }
    }

    private fun getFeatValues(feat: Feat): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, feat.name)
        contentValues.put(COLUMN_BENEFIT, feat.benefit)
        contentValues.put(COLUMN_PREREQUISITE, feat.prerequisit)
        contentValues.put(COLUMN_FEAT_TYPE_ID, feat.featType.ordinal)
        contentValues.put(COLUMN_FIGHTER_BONUS, feat.isFighterBonus)
        contentValues.put(COLUMN_MULTIPLE, feat.isMultiple)
        contentValues.put(COLUMN_STACK, feat.isStack)
        contentValues.put(COLUMN_SPELL_SLOT, feat.spellSlot)
        return contentValues
    }

    override fun updateFeat(feat: Feat) {
        updateFeatTable(feat)
    }

    private fun updateFeatTable(feat: Feat) {
        val featValues = getFeatValues(feat)
        val bindVariables = arrayOf(feat.id.toString())
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db.update(TABLE_FEAT, featValues, SQL_WHERE_ID, bindVariables)
            check(numberOfAffectedRows == 1) { "More or Less than 1 row affected: $numberOfAffectedRows" }
        }
    }

    /**
     * @see FeatDao.deleteFeat
     */
    override fun deleteFeat(feat: Feat) {

        // delete from feat table
        val featId = arrayOf(feat.id.toString())
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db.delete(TABLE_FEAT, "$COLUMN_ID = ?", featId)
            check(numberOfAffectedRows != 0) { "Can't delete feat: $feat" }
        }
    }

}