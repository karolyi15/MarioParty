package Controllers.Models.GameFactories;

import Controllers.Views.GameScene_Controller;

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
    public void initGame(GameScene_Controller sceneController);
    public void start();

}
