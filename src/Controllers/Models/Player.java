package Controllers.Models;

import Controllers.Models.SpriteFactory.Products.Character;
import Controllers.Models.SpriteFactory.Products.CharacterType;
import Controllers.Models.SpriteFactory.Products.Node;
import Controllers.Models.SpriteFactory.Products.NodeType;

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
    public Player(NodeType portrait){

        //Render System
        this.currentNode=0;
        this.createCharacter(portrait);

        //Game Components
        this.punished=0;

        //Game Board
        this.gameBoard=new ArrayList<>();
    }

    private void createCharacter(NodeType portrait){
        switch (portrait){
            case MARIOPORTRAIT:
                this.character=new Character(CharacterType.MARIO);
                break;
            case LUIGIPORTRAIT:
                this.character=new Character(CharacterType.LUIGI);
                break;
            case PEACHPORTRAIT:
                this.character=new Character(CharacterType.PEACH);
                break;
            case YOSHIPORTRAIT:
                this.character=new Character(CharacterType.YOSHI);
                break;
            case WALUIGIPORTRAIT:
                this.character=new Character(CharacterType.WALUIGI);
                break;
            case WARIO:
                this.character=new Character(CharacterType.WARIO);
                break;
            case DAISYPORTRAIT:
                this.character=new Character(CharacterType.DAISY);
                break;
            case YELLOWYOSHIPORTRAIT:
                this.character=new Character(CharacterType.YOSHIBLUE);
                break;
        }
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
