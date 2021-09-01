package com.d20charactersheet.framework.dsl

import com.d20charactersheet.framework.boc.model.*

class CharacterBuilder {
    var id: Int = 0
    var name: String? = null
    var sex: Sex? = null
    var race: Race? = null
    var classLevels: List<ClassLevel>? = null
    var equipment: Equipment? = null

    fun race(c: RaceBuilder.() -> Unit) {
        race = RaceBuilder().apply(c).build()
    }

    fun classLevels(c: ClassLevelsBuilder.() -> Unit) {
        classLevels = ClassLevelsBuilder().apply(c).build()
    }

    fun equipment(c: EquipmentBuilder.() -> Unit) {
        equipment = EquipmentBuilder().apply(c).build()
    }


    fun build(): Character {
        return Character().also { character ->
            character.id = id
            character.name = name
            character.sex = sex
            character.race = race
            if (classLevels != null) {
                character.classLevels = classLevels
            }
            character.equipment = equipment
        }
    }

}
