package Controllers.Models.SceneBuilder;

import Controllers.Models.SpriteFactory.SpriteFactory;
import Controllers.Views.Scene_Controller;

public class MiniGameDirector {

    MiniGameBuilder builder=new MiniGameBuilder();
    Scene_Controller controller;
    SpriteFactory factory;

    /*public MiniGameDirector(iSceneBuilder builder){
        this.builder=builder;
    }

    public void setBuilder(iSceneBuilder builder){
        this.builder=builder;
    }*/
    public void setSceneController(Scene_Controller controller){
        this.controller=controller;
    }

    public void setFactory(SpriteFactory factory){
        this.factory=factory;
    }

    //Build Method
    public void  buildTitleScene(){
        builder.reset(GameType.TITLEMENU);
        builder.setSceneController(controller);
        builder.setSpriteFactory(factory);
        builder.setGameType(GameType.TITLEMENU);
        builder.getMiniGame().start();
    }

    public void  buildMainGame(){
        builder.reset(GameType.BOARD);
        builder.setSceneController(controller);
        builder.setSpriteFactory(factory);
        builder.setGameType(GameType.BOARD);
        builder.getMiniGame().start();
    }

    public void  buildTicTacToe(){
        builder.reset(GameType.TICTACTOE);
        builder.setSceneController(controller);
        builder.setSpriteFactory(factory);
        builder.setGameType(GameType.TICTACTOE);
        builder.getMiniGame().start();
    }

    public void  buildMemoryPath(){
        builder.reset(GameType.MEMORYPATH);
        builder.setSceneController(controller);
        builder.setSpriteFactory(factory);
        builder.setGameType(GameType.MEMORYPATH);
        builder.getMiniGame().start();
    }

}
