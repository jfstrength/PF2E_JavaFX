package models;

import java.util.ArrayList;
import java.util.List;

public class Adventurer {

private int strength;
private int dexterity;
private int constitution;
private int intelligence;
private int wisdom;
private int charisma;
private Ancestry ancestry;
private String className;
private int level;
private List<Feat> feats = new ArrayList<>();
private List<Skill> skills = new ArrayList<>();
private List<Save> saves = new ArrayList<>();
private List<Spell> spells = new ArrayList<>();

public Adventurer() {
    this.strength=10;
    this.dexterity=11;
    this.constitution=12;
    this.intelligence=13;
    this.wisdom=14;
    this.charisma=15;
}

    public int getStrength() { return strength; }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getStrengthMod() { return strength/2-5; }

    public int getDexterityMod() {
        return dexterity/2-5;
    }

    public int getConstitutionMod() {
        return constitution/2-5;
    }

    public int getIntelligenceMod() { return intelligence/2-5; }

    public int getWisdomMod() { return wisdom/2-5; }

    public int getCharismaMod() {
        return charisma/2-5;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
}
