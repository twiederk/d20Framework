package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.StarterPackQuery
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class StarterPackHelperTest {

    @Test
    fun getStarterBoxOptions() {
        // arrange
        val startPackQueries: List<StarterPackQuery> = listOf()

        // act
        val starterBoxOptions = StarterPackHelper().getStarterBoxOptions(startPackQueries)

        // assert
        assertThat(startPackQueries).isEmpty()
    }

}