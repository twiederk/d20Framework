package com.d20charactersheet.framework.dsl

import com.d20charactersheet.framework.boc.model.Character

fun createCharacter(c: CharacterBuilder.() -> Unit): Character {
    return CharacterBuilder().apply(c).build()
}
