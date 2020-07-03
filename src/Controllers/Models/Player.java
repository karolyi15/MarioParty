package Controllers.Models;

import Controllers.Models.SpriteFactory.Products.Character;
import Controllers.Models.SpriteFactory.Products.CharacterType;
import Controllers.Models.SpriteFactory.Products.Node;
import Controllers.Models.SpriteFactory.Products.NodeType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Player {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private NodeType playerID;
    private int currentNode;
    private Character character;

    //Game Components
    private int punished;

    //Data Log System
    private JSONObject playerLog;



    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //Constructor
    public Player(NodeType portrait){

        //Render System
        this.currentNode=0;
        this.createCharacter(portrait);

        //Game Components
        this.punished=0;

        //Player Log
        this.initPlayerLog();
    }

    private void createCharacter(NodeType portrait){
        switch (portrait){
            case MARIOPORTRAIT:
                this.character=new Character(CharacterType.MARIO);
                this.playerID=portrait;
                break;
            case LUIGIPORTRAIT:
                this.character=new Character(CharacterType.LUIGI);
                this.playerID=portrait;
                break;
            case PEACHPORTRAIT:
                this.character=new Character(CharacterType.PEACH);
                this.playerID=portrait;
                break;
            case YOSHIPORTRAIT:
                this.character=new Character(CharacterType.YOSHI);
                this.playerID=portrait;
                break;
            case WALUIGIPORTRAIT:
                this.character=new Character(CharacterType.WALUIGI);
                this.playerID=portrait;
                break;
            case WARIOPORTRAIT:
                this.character=new Character(CharacterType.WARIO);
                this.playerID=portrait;
                break;
            case DAISYPORTRAIT:
                this.character=new Character(CharacterType.DAISY);
                this.playerID=portrait;
                break;
            case YELLOWYOSHIPORTRAIT:
                this.character=new Character(CharacterType.YOSHIBLUE);
                this.playerID=portrait;
                break;
        }
    }


    private void initPlayerLog(){

        this.playerLog=new JSONObject();
        JSONArray playerTurns=new JSONArray();

        this.playerLog.put("CurrentNode",this.currentNode);
        this.playerLog.put("Punishments",this.punished);
        this.playerLog.put("Turns",playerTurns);
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

    public NodeType getPlayerID() {
        return playerID;
    }

    public JSONObject getPlayerLog() {
        return playerLog;
    }
}
