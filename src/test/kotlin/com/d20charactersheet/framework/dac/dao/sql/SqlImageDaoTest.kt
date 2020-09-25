package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.dac.dao.BaseImageDaoTest
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcDatabase
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcHelper
import org.junit.Before
import java.sql.Connection

class SqlImageDaoTest : BaseImageDaoTest() {

    @Before
    fun setUp() {
        val jdbcHelper = JdbcHelper()
        jdbcHelper.executeSqlScript("/create_database.sql")
        initImageTable(jdbcHelper.connection)

        val jdbcDatabase = JdbcDatabase(jdbcHelper.connection)

        imageDao = SqlImageDao(jdbcDatabase)
    }

    private fun initImageTable(connection: Connection) {
        val images = arrayOf("/char_belvador.jpg", "/char_belvador_face.jpg", "/char_default.jpg", "/char_default_face.jpg")
        images.forEachIndexed { index, imageName ->
            val imageData = getImageData(imageName)
            insertImageAsBlob(connection, index, imageData)
        }
    }

    private fun insertImageAsBlob(connection: Connection, imageId: Int, imageData: ByteArray) {
        val values = ContentValues()
        values.put(TableAndColumnNames.COLUMN_ID, imageId)
        values.put(TableAndColumnNames.COLUMN_IMAGE, imageData)
        synchronized(Database.DB_LOCK) {
            JdbcDatabase(connection).insertOrThrow(TableAndColumnNames.TABLE_IMAGE, values)
        }

    }

    private fun getImageData(imageName: String): ByteArray {
        try {
            return this::class.java.getResource(imageName).readBytes()
        } catch (exception: Exception) {
            throw IllegalStateException(exception)
        }
    }

}