package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.StarterPackBoxOption
import com.d20charactersheet.framework.boc.model.StarterPackQuery

class StarterPackHelper {

    fun getStarterBoxOptions(starterPackQueries: List<StarterPackQuery>): List<StarterPackBoxOption> {
        // group queries by option id
        val groupedStarterPackQuieries: Map<Int, StarterPackQuery> =
            groupStarterPackBoxOptionQueries(starterPackQueries)
        // create option for each group of queries
        val starterPackBoxOptions = createStarterBoxOptions(groupedStarterPackQuieries)
        return starterPackBoxOptions
    }


    private fun createStarterBoxOptions(groupedStarterPackQuieries: Map<Int, StarterPackQuery>): List<StarterPackBoxOption> {
        TODO("Not yet implemented function body")
    }

    private fun groupStarterPackBoxOptionQueries(starterPackQueries: List<StarterPackQuery>): Map<Int, StarterPackQuery> {
        TODO("Not yet implemented function body")
    }

}
