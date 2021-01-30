package com.d20charactersheet.framework.boc.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eRuleServiceTest {

    @Test
    fun getName_nameOfDnD5e() {

        // Act
        val name = DnD5eRuleServiceImpl().name

        // Assert
        assertThat(name).isEqualTo("DnD 5e")
    }

}