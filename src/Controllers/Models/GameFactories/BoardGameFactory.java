package Controllers.Models.GameFactories;


import Controllers.Models.SpriteFactories.SpriteFactory;
import Controllers.Views.GameScene_Controller;
import javafx.scene.canvas.GraphicsContext;

public class BoardGameFactory implements iGameFactory{



    @Override
    public iMiniGame createGame(GameScene_Controller sceneController){
        return new BoardGame(sceneController);
    }

}
