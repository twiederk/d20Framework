@file:Suppress("unused")

package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.*
import com.d20charactersheet.framework.boc.service.ImageService
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.util.*

abstract class BaseCharacterDaoTest {

    protected lateinit var characterDao: CharacterDao
    protected lateinit var imageDao: ImageDao
    protected lateinit var characterClassDao: ClassDao
    protected lateinit var skillDao: SkillDao
    protected lateinit var featDao: FeatDao
    protected lateinit var raceDao: RaceDao
    protected lateinit var abilityDao: AbilityDao
    protected lateinit var spelllistDao: SpelllistDao
    protected lateinit var xpDao: XpDao
    protected lateinit var allCharacterClasses: List<CharacterClass>
    protected lateinit var allRaces: List<Race>
    protected lateinit var allXpTables: List<XpTable>
    protected lateinit var allAbilities: List<Ability>
    private lateinit var allSkills: List<Skill>
    protected lateinit var allFeats: List<Feat>
    protected lateinit var fighter: CharacterClass
    protected lateinit var wizard: CharacterClass
    protected lateinit var human: Race

    @Before
    open fun setUp() {
        allAbilities = abilityDao
            .getAllAbilities(
                spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                spelllistDao.getAllSpellsPerDayTables()
            )
        allSkills = skillDao.getAllSkills()
        allFeats = featDao.getAllFeats()
        allCharacterClasses = characterClassDao.getAllCharacterClasses(allSkills, allAbilities)
        fighter = allCharacterClasses[4]
        wizard = allCharacterClasses[10]
        allRaces = raceDao.getAllRaces(allCharacterClasses, allAbilities)
        human = allRaces[0]
        allXpTables = xpDao.getAllXpTables()
    }

    @Test
    open fun testGetAllCharacters() {

        // Act
        val characters = characterDao.getAllCharacters(allCharacterClasses, allRaces, allXpTables)

        // Assert
        assertThat(characters).hasSize(1)
    }

    @Test
    fun testGetCharacter() {

        // Act
        val belvador = characterDao.getCharacter(0, allCharacterClasses, allRaces, allXpTables)

        // Assert
        assertThat(belvador).isNotNull
    }

    @Test
    fun testUpdateAttribute() {
        // Arrange
        var character = characterDao.getCharacter(0, allCharacterClasses, allRaces, allXpTables)
        val oldStrength = character.strength
        character.strength = 20

        // Act
        val updatedCharacter = characterDao.updateCharacter(character)

        // Assert
        assertThat(updatedCharacter).isNotNull
        character = characterDao.getCharacter(0, allCharacterClasses, allRaces, allXpTables)
        assertThat(character.strength).isEqualTo(20)

        // tear down
        character.strength = oldStrength
        characterDao.updateCharacter(character)
    }

    @Test
    fun testUpdateClassLevel() {
        // Arrange
        val belvador = characterDao.getCharacter(0, allCharacterClasses, allRaces, allXpTables)
        val oldClassLevels = belvador.classLevels
        val classLevels: MutableList<ClassLevel> = ArrayList()
        val classLevel = ClassLevel(wizard, 10)
        classLevels.add(classLevel)
        belvador.classLevels = classLevels

        // Act
        val character = characterDao.updateCharacter(belvador)

        // Assert
        assertThat(character.classLevels[0]).isEqualTo(classLevel)

        // tear down
        character.classLevels = oldClassLevels
        characterDao.updateCharacter(character)
    }

    @Test
    fun testCreateCharacter() {
        // Arrange
        val name = "name"
        val player = "player"
        val race = human
        val sex = Sex.MALE
        val classLevel = ClassLevel(fighter, 1)
        val alignment = Alignment.NEUTRAL
        val xpTable = xpDao.getAllXpTables()[0]
        val newCharacter = createCharacter(name, race, sex, classLevel, alignment, xpTable)

        // Act
        val character = characterDao.createCharacter(newCharacter)

        // Assert
        assertThat(character).isNotNull
        assertThat(character.id).isGreaterThanOrEqualTo(0)
        assertThat(character.name).isEqualTo(name)
        assertThat(character.player).isEqualTo(player)
        assertThat(character.race).isEqualTo(race)
        assertThat(character.classLevels).hasSize(1)
        assertThat(character.classLevels[0].characterClass).isEqualTo(classLevel.characterClass)
        assertThat(character.classLevels[0].level).isEqualTo(classLevel.level)
        assertThat(character.alignment).isEqualTo(alignment)

        // tear down
        characterDao.deleteCharacter(character)
    }

    @Test
    fun testDeleteCharacter() {
        // Arrange
        val name = "testDeleteCharacter"
        val race = human
        val sex = Sex.MALE
        val classLevel = ClassLevel(fighter, 1)
        val alignment = Alignment.NEUTRAL
        val xpTable = xpDao.getAllXpTables()[0]
        val newCharacter = createCharacter(name, race, sex, classLevel, alignment, xpTable)
        newCharacter.strength = 10
        newCharacter.dexterity = 10
        newCharacter.constitution = 10
        newCharacter.intelligence = 10
        newCharacter.wisdom = 10
        newCharacter.charisma = 10
        val character = characterDao.createCharacter(newCharacter)
        val numberOfCharacters = characterDao.getAllCharacters(allCharacterClasses, allRaces, allXpTables).size

        // Act
        characterDao.deleteCharacter(character)

        // Assert
        assertThat(characterDao.getAllCharacters(allCharacterClasses, allRaces, allXpTables)).hasSize(numberOfCharacters - 1)
    }

    private fun createCharacter(name: String, race: Race?, sex: Sex, classLevel: ClassLevel,
                                alignment: Alignment, xpTable: XpTable): Character {
        val character = Character()
        character.name = name
        character.player = "player"
        character.race = race
        character.sex = sex
        val classLevels: MutableList<ClassLevel> = LinkedList()
        classLevels.add(classLevel)
        character.classLevels = classLevels
        character.alignment = alignment
        character.xpTable = xpTable
        character.strength = 1
        character.dexterity = 1
        character.constitution = 1
        character.intelligence = 1
        character.wisdom = 1
        character.charisma = 1
        character.imageId = ImageService.DEFAULT_CHARACTER_IMAGE_ID
        character.thumbImageId = ImageService.DEFAULT_THUMB_IMAGE_ID
        return character
    }

    @Test
    fun testGetAllNotes() {
        // Arrange
        val belvador = Character()
        belvador.id = 0

        // Act
        val notes = characterDao.getNotes(belvador)

        // Assert
        assertThat(notes).hasSize(0)
    }

    @Test
    fun testCreateNote() {
        // Arrange
        val note = Note()
        val date = Date()
        note.date = date
        note.text = "newNote"
        val belvador = Character()
        belvador.id = 0

        // Act
        characterDao.createNote(note, belvador)

        // Assert
        assertThat(note.id).isGreaterThanOrEqualTo(0)
        val notes = characterDao.getNotes(belvador)
        assertThat(notes).hasSize(1)

        // tear down
        characterDao.deleteNote(note)
    }

    @Test
    fun testDeleteNote() {
        // Arrange
        val note = Note()
        val date = Date()
        note.date = date
        note.text = "newNote"
        val belvador = Character()
        belvador.id = 0
        characterDao.createNote(note, belvador)

        // Act
        characterDao.deleteNote(note)

        // Assert
        val notes = characterDao.getNotes(belvador)
        assertThat(notes).hasSize(0)
    }

    @Test
    fun testGetKnownSpells() {
        // Arrange
        val belvador = Character()
        belvador.id = 0
        val allSpells = spelllistDao.getAllSpells()
        val allSpelllists = spelllistDao.getAllSpelllists(allSpells)

        // Act
        val knownSpells = characterDao.getKnownSpells(belvador, allSpelllists, allSpells)

        // Assert
        assertThat(knownSpells).hasSize(31)
        assertThat(contains(knownSpells)).isTrue
    }

    private operator fun contains(knownSpells: List<KnownSpell>): Boolean {
        for (knownSpell in knownSpells) {
            if (knownSpell.spell.name == "Arcane Mark") {
                return true
            }
        }
        return false
    }

    @Test
    fun testGetSpellSlots() {
        // Arrange
        val belvador = Character()
        belvador.id = 0
        val allSpells = spelllistDao.getAllSpells()

        // Act
        val spellSlots = characterDao.getSpellSlots(belvador, allSpells, allAbilities, allFeats)

        // Assert
        assertThat(spellSlots).hasSize(17)

        // spell slots per level
        assertThat(countLevel(spellSlots, 0)).isEqualTo(5)
        assertThat(countLevel(spellSlots, 1)).isEqualTo(5)
        assertThat(countLevel(spellSlots, 2)).isEqualTo(4)
        assertThat(countLevel(spellSlots, 3)).isEqualTo(3)

        // number of spells
        assertThat(countSpell(spellSlots, "Detect Magic")).isEqualTo(2)
        assertThat(countSpell(spellSlots, "Ray of Frost")).isEqualTo(1)
        assertThat(countSpell(spellSlots, "Light")).isEqualTo(1)
        assertThat(countSpell(spellSlots, "Mage Hand")).isEqualTo(1)
        assertThat(countSpell(spellSlots, "Mage Armor")).isEqualTo(1)
        assertThat(countSpell(spellSlots, "Mount")).isEqualTo(1)
        assertThat(countSpell(spellSlots, "Magic Missile")).isEqualTo(3)
        assertThat(countSpell(spellSlots, "Acid Arrow")).isEqualTo(2)
        assertThat(countSpell(spellSlots, "Summon Monster II")).isEqualTo(2)
        assertThat(countSpell(spellSlots, "Levitate")).isEqualTo(1)
        assertThat(countSpell(spellSlots, "Summon Monster III")).isEqualTo(1)
        assertThat(countSpell(spellSlots, "Lightning Bolt")).isEqualTo(1)

        // number of SpelllistAbilities
        assertThat(countSpelllistAbility(spellSlots, "Spells - Wizard")).isEqualTo(13)
        assertThat(countSpelllistAbility(spellSlots, "School Specialization - Conjuration")).isEqualTo(4)

        // number of meta magic feats
        assertThat(countMetaMagicFeats(spellSlots)).isEqualTo(1)
    }

    private fun countSpell(spellSlots: List<SpellSlot>, name: String): Int {
        var count = 0
        for (spellSlot in spellSlots) {
            if (spellSlot.spell.name == name) {
                count++
            }
        }
        return count
    }

    private fun countLevel(spellSlots: List<SpellSlot>, level: Int): Int {
        var count = 0
        for (spellSlot in spellSlots) {
            if (spellSlot.level == level) {
                count++
            }
        }
        return count
    }

    private fun countSpelllistAbility(spellSlots: List<SpellSlot>, name: String): Int {
        var count = 0
        for (spellSlot in spellSlots) {
            for (spelllistAbility in spellSlot.spelllistAbilities) {
                if (spelllistAbility.name == name) {
                    count++
                }
            }
        }
        return count
    }

    private fun countMetaMagicFeats(spellSlots: List<SpellSlot>): Int {
        var count = 0
        for (spellSlot in spellSlots) {
            for (feat in spellSlot.metamagicFeats) {
                if (feat.name == "Extend Spell") {
                    count++
                }
            }
        }
        return count
    }

    @Test
    fun testUpdateSpellSlot() {
        // Arrange
        val belvador = Character()
        belvador.id = 0
        val allSpells = spelllistDao.getAllSpells()
        var spellSlots = characterDao.getSpellSlots(belvador, allSpells, allAbilities, allFeats)
        var spellSlot = findSpellSlotById(1, spellSlots)
        val copySpellSlot = copySpellSlot(spellSlot)
        val detectPoison = findSpellByName("Detect Poison", allSpells)
        spellSlot.spell = detectPoison
        spellSlot.isCast = true
        val metamagicFeats: MutableList<Feat> = LinkedList()
        metamagicFeats.add(findFeatByName("Empower Spell", allFeats))
        spellSlot.metamagicFeats = metamagicFeats

        // Act
        characterDao.updateSpellSlot(spellSlot)

        // Assert
        spellSlots = characterDao.getSpellSlots(belvador, allSpells, allAbilities, allFeats)
        spellSlot = findSpellSlotById(1, spellSlots)
        assertThat(spellSlot.id).isEqualTo(copySpellSlot.id)
        assertThat(spellSlot.level).isEqualTo(copySpellSlot.level)
        assertThat(spellSlot.spelllistAbilities).isEqualTo(copySpellSlot.spelllistAbilities)
        assertThat(spellSlot.spell.name).isEqualTo("Detect Poison")
        assertThat(spellSlot.metamagicFeats).isEqualTo(metamagicFeats)
        assertThat(spellSlot.isCast).isTrue

        // tear down
        characterDao.updateSpellSlot(copySpellSlot)
    }

    private fun copySpellSlot(spellSlot: SpellSlot): SpellSlot {
        val copySpellSlot = SpellSlot()
        copySpellSlot.id = spellSlot.id
        copySpellSlot.spell = spellSlot.spell
        copySpellSlot.level = spellSlot.level
        copySpellSlot.isCast = spellSlot.isCast
        copySpellSlot.spelllistAbilities = LinkedList(spellSlot.spelllistAbilities)
        copySpellSlot.metamagicFeats = LinkedList(spellSlot.metamagicFeats)
        return copySpellSlot
    }

    private fun findSpellSlotById(spellSlotId: Int, spellSlots: List<SpellSlot>): SpellSlot {
        for (spellSlot in spellSlots) {
            if (spellSlot.id == spellSlotId) {
                return spellSlot
            }
        }
        throw IllegalArgumentException("Can't find spell slot with id: $spellSlotId")
    }

    private fun findSpellByName(name: String, allSpells: List<Spell>): Spell {
        for (spell in allSpells) {
            if (spell.name == name) {
                return spell
            }
        }
        throw IllegalArgumentException("Can't find spell with name: $name")
    }

    private fun findFeatByName(name: String, allFeats: List<Feat>): Feat {
        for (feat in allFeats) {
            if (feat.name == name) {
                return feat
            }
        }
        throw IllegalArgumentException("Can't find feat with name: $name")
    }

    @Test
    fun testCreateSpellSlot() {
        // Arrange
        val allSpells = spelllistDao.getAllSpells()
        val character = Character()
        character.id = 0
        var spellSlot = SpellSlot()
        spellSlot.spell = findSpellByName("Magic Missile", allSpells)
        spellSlot.level = 1
        spellSlot.isCast = true
        var spelllistAbilities: MutableList<SpelllistAbility?> = ArrayList(1)
        spelllistAbilities.add(findAbilityByName(allAbilities) as SpelllistAbility)
        spellSlot.spelllistAbilities = spelllistAbilities
        var metamagicFeats: MutableList<Feat> = ArrayList(1)
        metamagicFeats.add(findFeatByName("Extend Spell", featDao.getAllFeats()))
        spellSlot.metamagicFeats = metamagicFeats

        // Act
        spellSlot = characterDao.createSpellSlot(character, spellSlot)

        // Assert
        assertThat(spellSlot).isNotNull
        val spellSlotId = spellSlot.id
        assertThat(spellSlotId).isGreaterThan(0)
        val spellSlots = characterDao.getSpellSlots(character, allSpells, allAbilities, allFeats)
        val createdSpellSlot = findSpellSlotById(spellSlotId, spellSlots)
        assertThat(createdSpellSlot.spell.name).isEqualTo("Magic Missile")
        assertThat(createdSpellSlot.level).isEqualTo(1)
        assertThat(createdSpellSlot.isCast).isTrue
        spelllistAbilities = createdSpellSlot.spelllistAbilities
        assertThat(spelllistAbilities).hasSize(1)
        assertThat(createdSpellSlot.spelllistAbilities[0].name).isEqualTo("Spells - Wizard")
        metamagicFeats = createdSpellSlot.metamagicFeats
        assertThat(metamagicFeats).hasSize(1)
        assertThat(metamagicFeats[0].name).isEqualTo("Extend Spell")

        // tear down
        characterDao.deleteSpellSlot(createdSpellSlot)
    }

    private fun findAbilityByName(allAbilities: List<Ability>): Ability {
        for (ability in allAbilities) {
            if (ability.name == "Spells - Wizard") {
                return ability
            }
        }
        throw IllegalArgumentException("Can't find ability with name: " + "Spells - Wizard")
    }

    @Test
    fun testUpdateCharacterSkill() {
        // Arrange
        val belvador = Character()
        belvador.id = 0
        var characterSkills = characterDao.getCharacterSkills(belvador, allSkills)
        var concentration = findSkillByName(characterSkills)
        val modifierBackup = concentration.modifier
        concentration.modifier = -1

        // Act
        characterDao.updateCharacterSkill(belvador, concentration)

        // Assert
        characterSkills = characterDao.getCharacterSkills(belvador, allSkills)
        concentration = findSkillByName(characterSkills)
        assertThat(concentration.modifier).isEqualTo(-1)

        // tear down
        concentration.modifier = modifierBackup
        characterDao.updateCharacterSkill(belvador, concentration)
    }

    private fun findSkillByName(characterSkills: List<CharacterSkill>): CharacterSkill {
        for (characterSkill in characterSkills) {
            val skill = characterSkill.skill
            if (skill.name == "Concentration") {
                return characterSkill
            }
        }
        throw IllegalArgumentException("Can't find character skill with a skill named: " + "Concentration")
    }
}