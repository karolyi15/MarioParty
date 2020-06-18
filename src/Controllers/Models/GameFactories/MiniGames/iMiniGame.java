package Controllers.Models.GameFactories.MiniGames;

import Controllers.Models.SpriteFactories.SpriteFactory;
import Controllers.Views.Scene_Controller;

public interface iMiniGame {

    //Camara System
    public void restartCamara();
    public void updateCamara();

    //Audio System
    public void playSound();
    public void playMusic();

    //Event Handling System
    public void handleMouseEvents();
    public void handleKeyEvents();

    //Render System
    public void createBoard();
    public void update();

    //Collide System


    //Game Loop
    public void initGame(Scene_Controller sceneController);
    public void start();

}
