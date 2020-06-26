package Controllers.Models;

import Controllers.Models.SpriteFactory.Products.Character;

public class Player {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private int currentNode;
    private Character character;

    //Data Log System
    private String playerLog;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //Constructor
    public Player(Character character){

        //Render System
        this.currentNode=0;
        this.character=character;
    }

    //Render System
    public Character getCharacter() {
        return character;
    }

    public int getCurrentNode() {
        return this.currentNode;
    }

    public void setCurrentNode(int currentNode) {
        this.currentNode = currentNode;
    }

}