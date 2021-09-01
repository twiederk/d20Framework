package com.d20charactersheet.framework.dsl

import com.d20charactersheet.framework.boc.model.Race

class RaceBuilder {
    var racename: String? = null

    fun build(): Race {
        return Race().also { race ->
            race.name = racename
        }
    }

}
