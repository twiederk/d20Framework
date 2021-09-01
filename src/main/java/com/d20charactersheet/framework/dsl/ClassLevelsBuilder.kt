package com.d20charactersheet.framework.dsl

import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.ClassLevel

class ClassLevelsBuilder {
    var classLevels: MutableList<ClassLevel> = mutableListOf()

    fun classLevel(c: ClassLevelBuilder.() -> Unit) {
        classLevels.add(ClassLevelBuilder().apply(c).build())
    }

    fun build(): List<ClassLevel> {
        return classLevels
    }

}

class ClassLevelBuilder {
    var classname: String? = null
    var level: Int = 1

    fun build(): ClassLevel {
        return ClassLevel(CharacterClass().apply { name = classname }, level)
    }

}
