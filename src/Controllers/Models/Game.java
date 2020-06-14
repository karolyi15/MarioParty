package Controllers.Models;

import Controllers.Views.GameScene_Controller;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

import java.util.ArrayList;

public class Game {

    //********************************************* Class Fields ***********************************************//

    //
    private GameScene_Controller sceneController;

    //Animation System
    private GraphicsContext drawer;
    double[] camaraPosition;

    private AnimationTimer animationTimer;

    //Sound System
    private final String GAME_MUSIC_PATH="src/Resources/Sounds/Intro_Music.mp3";

    //Game
    private int currentScene;
    private ArrayList<Character> playersList= new ArrayList();

    //********************************************* Class Methods **********************************************//


    //********** Constructors **********//


    public Game(GameScene_Controller sceneController){
        this.sceneController=sceneController;
        this.currentScene=0;

        this.startGameLoop();

    }

    //******* Setters and Getters ******//





    //Audio System
    public void playMusic(String path){
        Media musicFile=new Media(path);
        this.sceneController.playMusic(musicFile);
    }

    public void playSound(String path){
        Media soundFile=new Media(path);
        this.sceneController.playSound(soundFile);
    }

    //Game

    //Create matrix of "spaces"

    //Refresh Camara

    //Restart Camara

    public void startGameLoop(){
        Image testImage=new Image("file:Resources/Imgs/Map_Img.png");
        this.sceneController.getDrawer().drawImage(testImage,0,0);




    }





}
