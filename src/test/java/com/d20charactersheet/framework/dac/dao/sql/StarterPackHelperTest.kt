package com.d20charactersheet.framework.dac.dao.sql

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class StarterPackHelperTest {

    @Test
    fun getStarterBoxOptions() {

        // act
        val starterBoxOptions = StarterPackHelper().getStarterBoxOptions(listOf())

        // assert
        assertThat(starterBoxOptions).isEmpty()
    }

}