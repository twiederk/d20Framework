package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.Armor
import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.StarterPack

interface CharacterCreatorService {

    fun rollAttributeWithStandardMethod(): Int

    fun getStarterPack(
        characterClass: CharacterClass,
        itemService: ItemService,
        allArmor: List<Armor>
    ): StarterPack

}
