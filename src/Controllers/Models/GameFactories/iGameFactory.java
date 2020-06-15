package Controllers.Models.GameFactories;

import Controllers.Views.GameScene_Controller;

public interface iGameFactory {

    public iMiniGame createGame(GameScene_Controller sceneController);

}
