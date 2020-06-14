package Controllers.Models;

import javafx.scene.image.Image;

public class Character {

    //********************************************* Class Fields ***********************************************//

    //Identification System
    String tag;
    String name;

    //Players Game Information
    int actualPosition;
    int punishment;
    String gameLog;  //Json

    //Animation System
    Image image;

    //********************************************* Class Methods **********************************************//


    //********** Constructors **********//

    Character(String tag, String name){

        this.tag=tag;
        this.name=name;

        this.actualPosition=0;
        this.punishment=0;


    }


    //******* Setters and Getters ******//

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(int actualPosition) {
        this.actualPosition = actualPosition;
    }

    public int getPunishment() {
        return punishment;
    }

    public void setPunishment(int punishment) {
        this.punishment = punishment;
    }

    //Movement System
    public void move(int movement){
        this.actualPosition+=movement;
    }
}
