package com.d20charactersheet.framework.boc.model;

/**
 * Expands CharacterSkill to offer favorite skills.
 */
public class FavoriteCharacterSkill extends CharacterSkill {

    private static final long serialVersionUID = -1128306673422199374L;

    private boolean favorite;

    /**
     * Creates FavoriteCharacterSkill for given skill.
     *
     * @param skill
     *     The skill.
     */
    public FavoriteCharacterSkill(final Skill skill) {
        super(skill);
    }

    /**
     * Returns true, if favorite skill.
     *
     * @return True, if favorite skill.
     */
    public boolean isFavorite() {
        return favorite;
    }

    /**
     * Set true for favorite skill.
     *
     * @param favorite
     *     True for favorite skill.
     */
    public void setFavorite(final boolean favorite) {
        this.favorite = favorite;
    }

}
