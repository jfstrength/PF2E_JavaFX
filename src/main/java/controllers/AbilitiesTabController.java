package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AbilitiesTabController implements Initializable {

    @FXML
    private Label str;
    @FXML
    private Label strMod;
    @FXML
    private Label dex;
    @FXML
    private Label dexMod;
    @FXML
    private Label con;
    @FXML
    private Label conMod;
    @FXML
    private Label inte;
    @FXML
    private Label inteMod;
    @FXML
    private Label wis;
    @FXML
    private Label wisMod;
    @FXML
    private Label cha;
    @FXML
    private Label chaMod;

    @FXML
    private MainController parentController;

    private Adventurer adventurer;

    @Override public void initialize(URL url, ResourceBundle rb){
    }

    public void setParentController(MainController parentController) {
        this.parentController = parentController;
        //Get Domain Object from Parent Controller
        setAdventurer(parentController.getAdventurer());
    }

    public void setAdventurer(Adventurer adv){
        adventurer = adv;
        //Display Ability Scores
        setLabels();
    }

    public void setLabels(){
        //Set Score Labels
        str.setText(Integer.toString(adventurer.getStrength()));
        dex.setText(Integer.toString(adventurer.getDexterity()));
        con.setText(Integer.toString(adventurer.getConstitution()));
        inte.setText(Integer.toString(adventurer.getIntelligence()));
        wis.setText(Integer.toString(adventurer.getWisdom()));
        cha.setText(Integer.toString(adventurer.getCharisma()));

        //Set Mod Labels
        strMod.setText(Integer.toString(adventurer.getStrengthMod()));
        dexMod.setText(Integer.toString(adventurer.getDexterityMod()));
        conMod.setText(Integer.toString(adventurer.getConstitutionMod()));
        inteMod.setText(Integer.toString(adventurer.getIntelligenceMod()));
        wisMod.setText(Integer.toString(adventurer.getWisdomMod()));
        chaMod.setText(Integer.toString(adventurer.getCharismaMod()));
    }

    public void addStr(){
        adventurer.setStrength(adventurer.getStrength()+1);
        String strNum = Integer.toString(adventurer.getStrength());
        str.setText(strNum);
        strMod.setText(Integer.toString(adventurer.getStrengthMod()));
    }

    public void addDex(){
        adventurer.setDexterity(adventurer.getDexterity()+1);
        String strNum = Integer.toString(adventurer.getDexterity());
        dex.setText(strNum);
        dexMod.setText(Integer.toString(adventurer.getDexterityMod()));

    }

    public void addCon(){
        adventurer.setConstitution(adventurer.getConstitution()+1);
        String strNum = Integer.toString(adventurer.getConstitution());
        con.setText(strNum);
        conMod.setText(Integer.toString(adventurer.getConstitutionMod()));

    }

    public void addInte(){
        adventurer.setIntelligence(adventurer.getIntelligence()+1);
        String strNum = Integer.toString(adventurer.getIntelligence());
        inte.setText(strNum);
        inteMod.setText(Integer.toString(adventurer.getIntelligenceMod()));

    }

    public void addWis(){
        adventurer.setWisdom(adventurer.getWisdom()+1);
        String strNum = Integer.toString(adventurer.getWisdom());
        wis.setText(strNum);
        wisMod.setText(Integer.toString(adventurer.getWisdomMod()));

    }

    public void addCha(){
        adventurer.setCharisma(adventurer.getCharisma()+1);
        String strNum = Integer.toString(adventurer.getCharisma());
        cha.setText(strNum);
        chaMod.setText(Integer.toString(adventurer.getCharismaMod()));

    }

    public void subStr() {
        adventurer.setStrength(adventurer.getStrength()-1);
        String strNum = Integer.toString(adventurer.getStrength());
        str.setText(strNum);
        strMod.setText(Integer.toString(adventurer.getStrengthMod()));

    }

    public void subDex() {
        adventurer.setDexterity(adventurer.getDexterity() - 1);
        String strNum = Integer.toString(adventurer.getDexterity());
        dex.setText(strNum);
        dexMod.setText(Integer.toString(adventurer.getDexterityMod()));

    }

    public void subCon(){
        adventurer.setConstitution(adventurer.getConstitution()-1);
        String strNum = Integer.toString(adventurer.getConstitution());
        con.setText(strNum);
        conMod.setText(Integer.toString(adventurer.getConstitutionMod()));

    }

    public void subInte(){
        adventurer.setIntelligence(adventurer.getIntelligence()-1);
        String strNum = Integer.toString(adventurer.getIntelligence());
        inte.setText(strNum);
        inteMod.setText(Integer.toString(adventurer.getIntelligenceMod()));

    }

    public void subWis(){
        adventurer.setWisdom(adventurer.getWisdom()-1);
        String strNum = Integer.toString(adventurer.getWisdom());
        wis.setText(strNum);
        wisMod.setText(Integer.toString(adventurer.getWisdomMod()));

    }

    public void subCha(){
        adventurer.setCharisma(adventurer.getCharisma()-1);
        String strNum = Integer.toString(adventurer.getCharisma());
        cha.setText(strNum);
        chaMod.setText(Integer.toString(adventurer.getCharismaMod()));

    }
}
