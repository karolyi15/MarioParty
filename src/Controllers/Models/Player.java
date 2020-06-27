package Controllers.Models;

import Controllers.Models.SpriteFactory.Products.Character;

public class Player {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private int currentNode;
    private Character character;

    //Game Components
    private int punished;

    //Data Log System
    private String playerLog;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //Constructor
    public Player(Character character){

        //Render System
        this.currentNode=0;
        this.character=character;

        //Game Components
        this.punished=0;
    }

    //Render System
    public Character getCharacter() {
        return this.character;
    }

    public int getCurrentNode() {
        return this.currentNode;
    }

    public void setCurrentNode(int currentNode) {
        this.currentNode = currentNode;
    }

    //Game Components


    public int getPunished() {
        return punished;
    }

    public void setPunished(int punished) {
        this.punished = punished;
    }
}
