package Controllers.Views;

import Controllers.Main;

import Controllers.Models.GameFactories.BoardGame;
import Controllers.Models.GameFactories.GameFactory;
import Controllers.Models.GameFactories.MiniGameFactory;
import Controllers.Models.SpriteFactories.SpriteFactory;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Scene_Controller {

    //********************************************* Class Fields ***********************************************//

    //References


    //Sound System
    private MediaPlayer musicPlayer;
    private MediaPlayer soundPlayer;

    //Render System
    private GraphicsContext drawer;

    //Factories
    private GameFactory gameFactory;
    private MiniGameFactory miniGameFactory;
    private SpriteFactory spriteFactory;

    private BoardGame game;

    //FXML Components
    @FXML
    private Canvas gameScene_Canvas;


    //********** Initialize **********//

    //Initialize is call after fxml is loaded
    @FXML
    private void initialize(){

        //Init drawer
        this.drawer=this.gameScene_Canvas.getGraphicsContext2D();

        //Init Factories
        this.miniGameFactory=new MiniGameFactory();
        this.spriteFactory=new SpriteFactory();
        this.gameFactory=new GameFactory();
        this.gameFactory.setSpriteFactory(this.spriteFactory);
        this.gameFactory.setMiniGameFactory(this.miniGameFactory);

        //test Game
        this.game=(BoardGame) this.gameFactory.createGame(this);

        Media media=new Media(new File("Resources/Sounds/Game_Music.mp3").toURI().toString());
        this.musicPlayer=new MediaPlayer(media);
        musicPlayer.setAutoPlay(true);

    }


    //******* Setters and Getters ******//
    public Canvas getGameScene_Canvas(){
        return this.gameScene_Canvas;
    }

    public GraphicsContext getDrawer(){
        return this.drawer;
    }

    //Sound System
    public void playMusic(String filePath){

        this.musicPlayer=new MediaPlayer(new Media(filePath));
        this.musicPlayer.play();
    }

    public void playSound(String filePath){

        this.soundPlayer.stop();
        this.soundPlayer=new MediaPlayer(new Media(filePath));
        this.soundPlayer.play();
    }



}
