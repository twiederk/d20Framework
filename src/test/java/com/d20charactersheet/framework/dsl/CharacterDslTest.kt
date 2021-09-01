package com.d20charactersheet.framework.dsl

import com.d20charactersheet.framework.boc.model.Sex
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CharacterDslTest {

    @Test
    fun createCharacter_characterWithNameRaceAndSex_returnsCharacter() {

        // act
        val character = createCharacter {
            id = 1
            name = "myCharacter"
            sex = Sex.MALE
            race {
                racename = "myRace"
            }
            classLevels {
                classLevel {
                    classname = "firstClass"
                    level = 1
                }
                classLevel {
                    classname = "secondClass"
                    level = 2
                }
            }
            equipment {
                good {
                    itemname = "myGood"
                    quantity = 2
                }
            }
        }

        // assert
        assertThat(character).isNotNull
        assertThat(character.id).isEqualTo(1)
        assertThat(character.name).isEqualTo("myCharacter")
        assertThat(character.sex).isEqualTo(Sex.MALE)
        assertThat(character.race.name).isEqualTo("myRace")
        assertThat(character.classLevels).hasSize(2)
        assertThat(character.classLevels[0].characterClass.name).isEqualTo("firstClass")
        assertThat(character.classLevels[0].level).isEqualTo(1)
        assertThat(character.classLevels[1].characterClass.name).isEqualTo("secondClass")
        assertThat(character.classLevels[1].level).isEqualTo(2)
        assertThat(character.equipment.goods).hasSize(1)
        assertThat(character.equipment.goods[0].item.name).isEqualTo("myGood")
    }

}