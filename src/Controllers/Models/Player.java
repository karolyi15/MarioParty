package Controllers.Models;

import Controllers.Models.SpriteFactory.Products.Character;
import Controllers.Models.SpriteFactory.Products.Node;

import java.util.ArrayList;

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

    //Game Board
    private ArrayList<Node> gameBoard;

    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //Constructor
    public Player(Character character){

        //Render System
        this.currentNode=0;
        this.character=character;

        //Game Components
        this.punished=0;

        //Game Board
        this.gameBoard=new ArrayList<>();
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

    public ArrayList<Node> getGameBoard() {
        return this.gameBoard;
    }
}
