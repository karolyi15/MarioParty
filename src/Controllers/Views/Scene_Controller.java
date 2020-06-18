package Controllers.Views;

import Controllers.Models.GameFactories.MiniGames.iMiniGame;
import Controllers.Models.GameFactories.MainGame.BoardGame;
import Controllers.Models.GameFactories.GameFactory;
import Controllers.Models.GameFactories.MiniGameFactory;
import Controllers.Models.SpriteFactories.SpriteFactory;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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

    private iMiniGame game;

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

        this.spriteFactory=new SpriteFactory();

        this.miniGameFactory=new MiniGameFactory();
        this.miniGameFactory.setSpriteFactory(spriteFactory);

        this.gameFactory=new GameFactory();
        this.gameFactory.setSpriteFactory(this.spriteFactory);
        this.gameFactory.setMiniGameFactory(this.miniGameFactory);

        //test Game
        this.game=(BoardGame) this.gameFactory.createGame(this);
        //this.game=(Tictactoe) this.miniGameFactory.createGame(this);

        Media media=new Media(new File("Resources/Sounds/Game_Music.mp3").toURI().toString());
        this.musicPlayer=new MediaPlayer(media);
        this.musicPlayer.setVolume(0.1);
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
