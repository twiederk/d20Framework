package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.dac.dao.ImageDao
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_IMAGE
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_WHERE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_IMAGE
import java.lang.IllegalStateException
import java.sql.SQLException


/**
 * SQLite specific implementation of the ImageDao interface. Instantiates ImageDaoSQLite with the given context containing the database.
 *
 * @param db
 * The database to access.
 */
class SqlImageDao (private val db: Database) : ImageDao {

    companion object {
        private const val SQL_GET_IMAGE: String = "$SELECT$COLUMN_IMAGE FROM $TABLE_IMAGE WHERE $COLUMN_ID = ?"
        private const val SQL_GET_ID: String = "$SELECT$COLUMN_ID FROM $TABLE_IMAGE WHERE rowid = ?"
    }

    /**
     * @see ImageDao.getImage
     */
    override fun getImage(imageId: Int): ByteArray {
        val bindVariables = arrayOf(imageId.toString())
        var queryResult: QueryResult? = null
        try {
            queryResult = db.rawQuery(SQL_GET_IMAGE, bindVariables)
            queryResult.moveToFirst()
            if (!queryResult.isAfterLast()) {
                return queryResult.getDataRow().getBlob(0)
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get image width imageId: " + imageId);
        } finally {
            queryResult?.close()
        }
        throw IllegalStateException("Can't get image with imageId: $imageId")
    }

    /**
     * @see ImageDao.createImage
     */
    override fun createImage(imageData: ByteArray): Int {
        val values = ContentValues()
        values.putNull(COLUMN_ID)
        values.put(COLUMN_IMAGE, imageData)
        var rowId: Long
        synchronized(Database.DB_LOCK) { rowId = db.insertOrThrow(TABLE_IMAGE, values) }
        return db.queryId(SQL_GET_ID, rowId)
    }

    /**
     * @see ImageDao.deleteImage
     */
    override fun deleteImage(imageId: Int) {
        val bindVariables = arrayOf(imageId.toString())
        synchronized(Database.DB_LOCK) {
            val deletedRows = db.delete(TABLE_IMAGE, SQL_WHERE_ID, bindVariables)
            check(deletedRows == 1) { "Too many or to less deleted rows: $deletedRows. Expected one deleted row!" }
        }
    }


}