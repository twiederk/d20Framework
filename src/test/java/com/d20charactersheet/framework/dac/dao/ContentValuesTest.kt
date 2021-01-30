package com.d20charactersheet.framework.dac.dao


import com.d20charactersheet.framework.dac.dao.sql.ContentValues
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ContentValuesTest {

    @Test
    fun whereClause_oneString_clauseWithOneValue() {
        // Arrange
        val underTest = ContentValues()
        underTest.put("name", "Peter")

        // Act
        val result = underTest.whereClause()

        // Assert
        assertThat(result).isEqualTo("name=?")
    }

    @Test
    fun whereClause_twoStrings_clauseWithTwoValues() {
        // Arrange
        val underTest = ContentValues()
        underTest.put("firstname", "Peter")
        underTest.put("lastname", "Beck")

        // Act
        val result = underTest.whereClause()

        // Assert
        assertThat(result).isEqualTo("firstname=?, lastname=?")
    }

    @Test
    fun whereClause_oneStringOneInteger_clauseWithTwoValues() {
        // Arrange
        val underTest = ContentValues()
        underTest.put("firstname", "Peter")
        underTest.put("id", 1)

        // Act
        val result = underTest.whereClause()

        // Assert
        assertThat(result).isEqualTo("firstname=?, id=?")
    }

    @Test
    fun whereClause_twoIntegers_clauseWithTwoValues() {
        // Arrange
        val underTest = ContentValues()
        underTest.put("age", 28)
        underTest.put("id", 1)

        // Act
        val result = underTest.whereClause()

        // Assert
        assertThat(result).isEqualTo("age=?, id=?")
    }

    @Test
    fun size_oneElement_sizeIsOne() {
        // Arrange
        val underTest = ContentValues()
        underTest.put("key", "value")

        // Act
        val size = underTest.size()

        // Assert
        assertThat(size).isEqualTo(1)
    }


    @Test
    fun value_twoValues_twoValusInProperOrder() {
        // Arrange
        val underTest = ContentValues()
        underTest.put("key1", "value1")
        underTest.put("key2", "value2")

        // Act
        val values = underTest.values()

        // Assert
        assertThat(values).containsExactly("value1", "value2")
    }

    @Test
    fun placeHolder_oneValue_oneQuestionmark() {
        // Arrange
        val underTest = ContentValues()
        underTest.put("key1", "value1")

        // Act
        val placeHolder = underTest.placeHolder()

        // Assert
        assertThat(placeHolder).isEqualTo("?")
    }

    @Test
    fun placeHolder_twoValues_twoQuestionmarks() {
        // Arrange
        val underTest = ContentValues()
        underTest.put("key1", "value1")
        underTest.put("key2", "value2")

        // Act
        val placeHolder = underTest.placeHolder()

        // Assert
        assertThat(placeHolder).isEqualTo("?,?")
    }

    @Test
    fun placeHolder_threeValues_threeQuestionmarks() {
        // Arrange
        val underTest = ContentValues()
        underTest.put("key1", "value1")
        underTest.put("key2", "value2")
        underTest.put("key3", "value3")

        // Act
        val placeHolder = underTest.placeHolder()

        // Assert
        assertThat(placeHolder).isEqualTo("?,?,?")
    }

}