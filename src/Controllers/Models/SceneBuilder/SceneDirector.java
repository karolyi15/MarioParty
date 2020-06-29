package Controllers.Models.SceneBuilder;

import Controllers.Views.Scene_Controller;

public class SceneDirector {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Builder System
    private iSceneBuilder builder;

    //Render System
    private Scene_Controller controller;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //Constructor
    public SceneDirector(iSceneBuilder builder){
        this.builder=builder;
    }

    //Setters & Getters
    public void changeBuilder(iSceneBuilder builder){
        this.builder=builder;
    }

    public void setSceneController(Scene_Controller controller){

        this.controller=controller;
    }

    //Building  Methods

    //Main Scenes
    public void  buildTitleScene(){
        builder.reset(SceneType.TITLEMENU);
        builder.setSceneController(controller);
        //builder.setPlayers();
        builder.getBuild().start();
    }

    public void  buildMainGame(){
        builder.reset(SceneType.BOARD);
        builder.setSceneController(controller);
        //builder.setPlayers();
        builder.getBuild().start();
    }

    //Mini Games
    public void  buildTicTacToe(){
        builder.reset(SceneType.TICTACTOE);
        builder.setSceneController(controller);
        //builder.setPlayers();
        builder.getBuild().start();
    }

    public void  buildMemoryPath(){
        builder.reset(SceneType.MEMORYPATH);
        builder.setSceneController(controller);
        //builder.setPlayers();
        builder.getBuild().start();
    }

    public void  buildCatchBoo(){
        builder.reset(SceneType.CATCHCAT);
        builder.setSceneController(controller);
        //builder.setPlayers();
        builder.getBuild().start();
    }

    public void  buildMarioSoup(){
        builder.reset(SceneType.SOUP);
        builder.setSceneController(controller);
        //builder.setPlayers();
        builder.getBuild().start();
    }

}
