package Controllers.Models.GameFactories;


import Controllers.Models.SpriteFactories.SpriteFactory;
import Controllers.Views.Scene_Controller;

import java.util.ArrayList;

public class GameFactory implements iGameFactory{


    //Factories
    private SpriteFactory spriteFactory;
    private MiniGameFactory miniGameFactory;

    //Methods
    //Setters and Getters


    public void setSpriteFactory(SpriteFactory spriteFactory) {
        this.spriteFactory = spriteFactory;
    }

    public void setMiniGameFactory(MiniGameFactory miniGameFactory) {
        this.miniGameFactory = miniGameFactory;
    }

    //Creation System
    @Override
    public iMiniGame createGame(Scene_Controller sceneController){
        if(this.spriteFactory!=null & this.miniGameFactory!=null) {

            iMiniGame tempGame=new BoardGame(sceneController,this.spriteFactory);
            return tempGame;

        }else{

            return null;
        }
    }

}
