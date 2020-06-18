package Controllers.Models.GameFactories;

import Controllers.Models.GameFactories.MiniGames.iMiniGame;
import Controllers.Views.Scene_Controller;

public interface iGameFactory {

    public iMiniGame createGame(Scene_Controller sceneController);

}
