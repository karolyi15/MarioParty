package Controllers.Models.GameFactories;

import Controllers.Models.SpriteFactories.SpriteFactory;
import Controllers.Views.Scene_Controller;

public class MiniGameFactory implements iGameFactory{

    //Factories
    private SpriteFactory spriteFactory;

    //Setters and Getters
    public void setSpriteFactory(SpriteFactory spriteFactory){
        this.spriteFactory=spriteFactory;
    }

    //Creation System
    @Override
    public iMiniGame createGame(Scene_Controller sceneController){
        if(this.spriteFactory!=null) {

            iMiniGame tempGame = new BoardGame(sceneController, this.spriteFactory);
            return tempGame;

        }else{
            return null;
        }
    }
}
