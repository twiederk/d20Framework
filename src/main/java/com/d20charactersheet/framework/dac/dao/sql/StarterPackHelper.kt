package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.StarterPackBoxItemOption
import com.d20charactersheet.framework.boc.model.StarterPackBoxOption
import com.d20charactersheet.framework.boc.model.StarterPackQuery

class StarterPackHelper {

    fun getStarterBoxOptions(starterPackQueries: List<StarterPackQuery>): List<StarterPackBoxOption> {
        val groupedStarterPackQuieries: Map<Int, List<StarterPackQuery>> = groupStarterPackQueries(starterPackQueries)
        return createStarterBoxOptions(groupedStarterPackQuieries)
    }

    private fun groupStarterPackQueries(starterPackQueries: List<StarterPackQuery>): Map<Int, List<StarterPackQuery>> {
        return starterPackQueries.groupBy { it.optionId }
    }


    private fun createStarterBoxOptions(groupedStarterPackQuieries: Map<Int, List<StarterPackQuery>>): List<StarterPackBoxOption> {
        val starterPackOptions = mutableListOf<StarterPackBoxOption>()
        for (starterPackQueries in groupedStarterPackQuieries.values) {
            starterPackOptions.add(StarterPackBoxItemOption())
        }
        return starterPackOptions
    }


}
