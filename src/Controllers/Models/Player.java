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
    private int currentNodeState;
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
        this.currentNodeState=1;
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
            case BOWSERPORTRAIT:
                this.character=new Character(CharacterType.BROWSER);
                this.playerID=portrait;
                break;
            case TOADPORTRAIT:
                this.character=new Character(CharacterType.TOAD);
                this.playerID=portrait;
                break;
        }
    }


    private void initPlayerLog(){

        this.playerLog=new JSONObject();
        JSONArray playerTurns=new JSONArray();

        this.playerLog.put("ID",this.playerID);
        //this.playerLog.put("CurrentNode",this.currentNode);
        this.playerLog.put("Punishments",this.punished);
        this.playerLog.put("Turns",playerTurns);
    }

    public void addTurnLog(NodeType type){
        //Getting Turns Array List
        JSONArray playerTurns=(JSONArray) this.playerLog.get("Turns");

        //Create new JsoN Object Turn
        JSONObject turn=new JSONObject();
        turn.put("Node",this.currentNode);
        turn.put("NodeType",type);
        turn.put("State",this.getNodeState());

        //Add New Turn Log
        playerTurns.add(turn);
    }

    private String getNodeState(){
        if(this.currentNodeState==1){
            return "Win";
        }else if(this.currentNodeState==-1){
            return "Lose";
        }else{
            return "Replay";
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

    public NodeType getPlayerID() {
        return playerID;
    }

    public JSONObject getPlayerLog() {
        return playerLog;
    }

    public int isCurrentNodeState() {
        return currentNodeState;
    }

    public void setCurrentNodeState(int currentNodeState) {
        this.currentNodeState = currentNodeState;
    }
}
