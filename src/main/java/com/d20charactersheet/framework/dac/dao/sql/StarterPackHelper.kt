package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.StarterPackBoxOption
import com.d20charactersheet.framework.boc.model.StarterPackQuery

class StarterPackHelper {

    fun getStarterBoxOptions(starterPackQueries: List<StarterPackQuery>): List<StarterPackBoxOption> {
        // group queries by option id
        val groupedStarterPackQuieries: Map<Int, StarterPackQuery> =
            groupStarterPackBoxOptionQueries(starterPackQueries)
        // create option for each group of queries
        return createStarterBoxOptions(groupedStarterPackQuieries)
    }


    private fun createStarterBoxOptions(groupedStarterPackQuieries: Map<Int, StarterPackQuery>): List<StarterPackBoxOption> {
        return listOf()
    }

    private fun groupStarterPackBoxOptionQueries(starterPackQueries: List<StarterPackQuery>): Map<Int, StarterPackQuery> {
        return mapOf()
    }

}
