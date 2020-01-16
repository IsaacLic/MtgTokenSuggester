package com.example.mtgtokensuggester.TokenStructure.Token;

import androidx.annotation.NonNull;

public class Token {

    public final Color[] colors;
    private final String ability;

    private final ArtifactInfo artifactInfo;
    private final CreatureInfo creatureInfo;
    private final EnchantmentInfo enchantmentInfo;

    public Token(Color[] colors, String ability, ArtifactInfo artifactInfo, CreatureInfo creatureInfo, EnchantmentInfo enchantmentInfo) {
        this.colors = colors;
        this.ability = ability;

        this.artifactInfo = artifactInfo;
        this.creatureInfo = creatureInfo;
        this.enchantmentInfo = enchantmentInfo;
    }

    @Override
    public String toString() {
        String tokenDesc = "";

        tokenDesc += getPowerAndToughness();

        tokenDesc += getColors();

        tokenDesc += getCardTypes();

        tokenDesc += getAbility();

        return tokenDesc;
    }

    private String getPowerAndToughness() {
        String result = "";

        if (creatureInfo != null) {
            result = " " + creatureInfo.power + "/" + creatureInfo.toughness;
        }
        return result;
    }

    private String getColors() {
        if (colors.length == 0){
            return "";
        }

        if (colors.length == 1) {
            return " " + colors[0].toString().toLowerCase();
        }

        String result = "";

        for (int i = 0; i < colors.length - 2; i++){
            result += " " + colors[i].toString().toLowerCase() + ",";
        }

        result += " " + colors[colors.length - 2].toString().toLowerCase();

        result += " and " + colors[colors.length - 1].toString().toLowerCase();
        return result;
    }

    private String getCardTypes() {
        String result = "";

        if (artifactInfo != null) {
            result += " artifact";
        }
        if (enchantmentInfo != null) {
            result += " enchantment";
        }
        if (creatureInfo != null) {
            result += " creature";
        }
        return result;
    }

    private String getAbility() {
        String result = "";

        if (ability != null) {
            result += " with " + ability;
        }
        return result;
    }
}
