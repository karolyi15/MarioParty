package Controllers.Models.SceneBuilder;

import Controllers.Models.Player;
import Controllers.Views.Scene_Controller;

import java.util.ArrayList;

public class SceneDirector {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Builder System
    private iSceneBuilder builder;

    //Render System
    private Scene_Controller controller;

    //Scene Transition System
    private GameScene mainGame;
    private GameScene miniGame;

    private ArrayList<Player> playerList;

    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //Constructor
    public SceneDirector(iSceneBuilder builder){

        this.builder=builder;
        this.playerList=new ArrayList<>();
    }

    //Setters & Getters
    public void changeBuilder(iSceneBuilder builder){
        this.builder=builder;
    }

    public void setSceneController(Scene_Controller controller){

        this.controller=controller;
    }

    public GameScene getMainGame() {
        return mainGame;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }
    //Building  Methods

    //Complete Solution
    public void buildSolution(){


    }


    //Main Scenes
    public void  buildTitleScene(){
        builder.reset(SceneType.TITLEMENU);
        builder.setSceneController(controller);
        builder.setSceneDirector(this);
        //builder.setPlayers();
        this.mainGame=builder.getBuild();
        this.mainGame.start();
    }

    public void  buildCharacterSelection(){
        builder.reset(SceneType.CHARACTERSELECTIONMENU);
        builder.setSceneController(controller);
        builder.setSceneDirector(this);
        //builder.setPlayers();
        this.mainGame=builder.getBuild();
        this.mainGame.start();
    }

    public void  buildMainGame(){
        builder.reset(SceneType.BOARD);
        builder.setSceneController(controller);
        builder.setSceneDirector(this);
        //builder.setPlayers();
        this.mainGame=builder.getBuild();
        this.mainGame.start();
    }

    //Mini Games
    public void  buildTicTacToe(){
        builder.reset(SceneType.TICTACTOE);
        builder.setSceneController(controller);
        builder.setSceneDirector(this);
        //builder.setPlayers();
        this.miniGame=builder.getBuild();
        this.miniGame.start();
    }

    public void  buildMemoryPath(){
        builder.reset(SceneType.MEMORYPATH);
        builder.setSceneController(controller);
        builder.setSceneDirector(this);
        //builder.setPlayers();
        this.miniGame=builder.getBuild();
        this.miniGame.start();
    }

    public void  buildCatchBoo(){
        builder.reset(SceneType.CATCHCAT);
        builder.setSceneController(controller);
        builder.setSceneDirector(this);
        //builder.setPlayers();
        this.miniGame=builder.getBuild();
        this.miniGame.start();
    }

    public void  buildMarioSoup(){
        builder.reset(SceneType.SOUP);
        builder.setSceneController(controller);
        builder.setSceneDirector(this);
        //builder.setPlayers();
        this.miniGame=builder.getBuild();
        this.miniGame.start();
    }

    public void  buildCollectTheCoins(){

        builder.reset(SceneType.COINS);
        builder.setSceneController(controller);
        builder.setSceneDirector(this);
        this.miniGame=builder.getBuild();
        this.miniGame.start();

    }

    public void  buildMemory(){

        builder.reset(SceneType.MEMORY);
        builder.setSceneController(controller);
        builder.setSceneDirector(this);
        this.miniGame=builder.getBuild();
        this.miniGame.start();

    }

    public void  buildGuessWho(){

        builder.reset(SceneType.GUESS);
        builder.setSceneController(controller);
        builder.setSceneDirector(this);
        this.miniGame=builder.getBuild();
        this.miniGame.start();
    }

    public void  buildMarioCards(){

        builder.reset(SceneType.CARDS);
        builder.setSceneController(controller);
        builder.setSceneDirector(this);
        this.miniGame=builder.getBuild();
        this.miniGame.start();
    }

}
