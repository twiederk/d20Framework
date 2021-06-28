package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.StarterPackBoxOption
import com.d20charactersheet.framework.boc.model.StarterPackData
import com.d20charactersheet.framework.boc.model.StarterPackFactory
import com.d20charactersheet.framework.boc.model.StarterPackQuery

class StarterPackHelper(private val starterPackData: StarterPackData) {

    /**
     * Get all options of one starter box.
     *
     * @param starterPackQueries List of all queries for this starter box.
     *
     * @return List of all options for this box
     */
    fun getStarterBoxOptions(starterPackQueries: List<StarterPackQuery>): List<StarterPackBoxOption> {
        val groupedStarterPackQuieries: Map<Int, List<StarterPackQuery>> = starterPackQueries.groupBy { it.optionId }

        // queries are now mapped to options
        val starterPackOptions = mutableListOf<StarterPackBoxOption>()
        for (queriesOfOneOption in groupedStarterPackQuieries.values) {
            // list of queries for one option
            starterPackOptions.addAll(
                StarterPackFactory().createStarterPackOptions(queriesOfOneOption, starterPackData)
            )
        }
        return starterPackOptions
    }


}
