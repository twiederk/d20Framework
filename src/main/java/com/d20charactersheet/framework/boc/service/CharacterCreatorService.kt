package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.Armor
import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.StarterPack
import com.d20charactersheet.framework.boc.model.Weapon

interface CharacterCreatorService {

    fun rollAttributeWithStandardMethod(): Int

    fun getStarterPack(
        characterClass: CharacterClass,
        itemService: ItemService,
        allWeapons: List<Weapon>,
        allArmor: List<Armor>
    ): StarterPack

}
