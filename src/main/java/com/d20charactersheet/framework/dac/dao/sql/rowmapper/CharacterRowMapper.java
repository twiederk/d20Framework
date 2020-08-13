package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.Alignment;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.Money;
import com.d20charactersheet.framework.boc.model.Race;
import com.d20charactersheet.framework.boc.model.Sex;
import com.d20charactersheet.framework.boc.model.XpTable;
import com.d20charactersheet.framework.dac.dao.BaseRowMapper;
import com.d20charactersheet.framework.dac.dao.DataRow;

/**
 * Maps a database row to a Character instance.
 */
public class CharacterRowMapper extends BaseRowMapper {

    private final List<Race> allRaces;
    private final List<XpTable> allXpTables;

    /**
     * Maps a datarow to an Character instance.
     *
     * @param allRaces
     *     All races of the game system.
     * @param allXpTables
     *     All xp tables of the game system.
     */
    public CharacterRowMapper(final List<Race> allRaces, final List<XpTable> allXpTables) {
        super();
        this.allRaces = allRaces;
        this.allXpTables = allXpTables;
    }

    /**
     * Maps a database row to a Character instance.
     */
    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws java.sql.SQLException {
        final Character character = new Character();
        character.setId(dataRow.getInt(0));
        character.setPlayer(dataRow.getString(1));
        character.setName(dataRow.getString(2));
        character.setRace(getRace(dataRow.getInt(3), allRaces));
        character.setSex((Sex) getEnum(dataRow.getInt(4), Sex.values()));
        character.setAlignment((Alignment) getEnum(dataRow.getInt(5), Alignment.values()));
        character.setXpTable(getXpTable(dataRow.getInt(6), allXpTables));
        character.setExperiencePoints(dataRow.getInt(7));
        character.setStrength(dataRow.getInt(8));
        character.setDexterity(dataRow.getInt(9));
        character.setConstitution(dataRow.getInt(10));
        character.setIntelligence(dataRow.getInt(11));
        character.setWisdom(dataRow.getInt(12));
        character.setCharisma(dataRow.getInt(13));
        character.setHitPoints(dataRow.getInt(14));
        character.setMaxHitPoints(dataRow.getInt(15));
        character.setArmorClass(dataRow.getInt(16));
        character.setInitiativeModifier(dataRow.getInt(17));
        character.setCmbModifier(dataRow.getInt(18));
        character.setCmdModifier(dataRow.getInt(19));
        character.setFortitudeModifier(dataRow.getInt(20));
        character.setReflexModifier(dataRow.getInt(21));
        character.setWillModifier(dataRow.getInt(22));
        character.setImageId(dataRow.getInt(23));
        character.setThumbImageId(dataRow.getInt(24));
        character.setMoney(getMoney(dataRow));
        return character;
    }

    private Money getMoney(final DataRow dataRow) {
        final Money money = new Money();
        money.setPlatinum(dataRow.getInt(25));
        money.setGold(dataRow.getInt(26));
        money.setSilver(dataRow.getInt(27));
        money.setCopper(dataRow.getInt(28));
        return money;
    }

}
