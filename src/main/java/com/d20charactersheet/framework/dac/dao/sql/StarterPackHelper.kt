package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.StarterPackBoxOption
import com.d20charactersheet.framework.boc.model.StarterPackBoxOptionQuery

class StarterPackHelper {

    fun getStarterBoxOptions(starterPackBoxOptionQueries: List<StarterPackBoxOptionQuery>): List<StarterPackBoxOption> {
        // group queries by option id
        val groupedStarterPackBoxOptionQuieries: Map<Int, StarterPackBoxOptionQuery> =
            groupStarterPackBoxOptionQueries(starterPackBoxOptionQueries)
        // create option for each group of queries
        val starterPackBoxOptions = createStarterBoxOptions(groupedStarterPackBoxOptionQuieries)
        return starterPackBoxOptions
    }


    private fun createStarterBoxOptions(groupedStarterPackBoxOptionQuieries: Map<Int, StarterPackBoxOptionQuery>): List<StarterPackBoxOption> {
        TODO("Not yet implemented function body")
    }

    private fun groupStarterPackBoxOptionQueries(starterPackBoxOptionQueries: List<StarterPackBoxOptionQuery>): Map<Int, StarterPackBoxOptionQuery> {
        TODO("Not yet implemented function body")
    }

}
