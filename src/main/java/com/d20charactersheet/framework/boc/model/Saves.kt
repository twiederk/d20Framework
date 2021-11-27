package com.d20charactersheet.framework.boc.model

import java.io.Serializable

/**
 * Stores the modifier of each save.
 */
class Saves : Serializable {

    private var strengthModifier = 0
    private var dexterityModifier = 0
    private var constitutionModifier = 0
    private var intelligenceModifier = 0
    private var wisdomModifier = 0
    private var charismaModifier = 0

    fun getSaveModifier(save: Save): Int {
        return when (save) {
            Save.STRENGTH -> strengthModifier
            Save.DEXTERITY -> dexterityModifier
            Save.CONSTITUTION -> constitutionModifier
            Save.INTELLIGENCE -> intelligenceModifier
            Save.WISDOM -> wisdomModifier
            Save.CHARISMA -> charismaModifier
        }
    }

    fun setSaveModifier(save: Save, modifier: Int) {
        when (save) {
            Save.STRENGTH -> strengthModifier = modifier
            Save.DEXTERITY -> dexterityModifier = modifier
            Save.CONSTITUTION -> constitutionModifier = modifier
            Save.INTELLIGENCE -> intelligenceModifier = modifier
            Save.WISDOM -> wisdomModifier = modifier
            Save.CHARISMA -> charismaModifier = modifier
        }
    }

    companion object {
        private const val serialVersionUID = 5516292153276782587L
    }
}