package Controllers.Views;

import Controllers.Main;

import Controllers.Models.GameFactories.BoardGame;
import Controllers.Models.GameFactories.BoardGameFactory;
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

public class GameScene_Controller {

    //********************************************* Class Fields ***********************************************//

    //Sound System
    private MediaPlayer musicPlayer;
    private MediaPlayer soundPlayer;

    private Main mainApp;
    private BoardGameFactory gameFactory;
    private SpriteFactory spriteFactory;
    private GraphicsContext drawer;
    private BoardGame game;

    //FXML Components
    @FXML
    private Canvas gameScene_Canvas;
    @FXML
    private Button start_Button;
    @FXML
    private Button exit_Button;





    //********************************************* Class Methods **********************************************//




    //********** Initialize **********//

    //Initialize is call after fxml is loaded
    @FXML
    private void initialize(){

        //Creating drawer
        this.drawer=this.gameScene_Canvas.getGraphicsContext2D();

        this.gameFactory=new BoardGameFactory();
        this.game=(BoardGame) gameFactory.createGame(this);
        this.game.start();

        Media media=new Media(new File("Resources/Sounds/Game_Music.mp3").toURI().toString());
        this.musicPlayer=new MediaPlayer(media);
        musicPlayer.setAutoPlay(true);

    }


    //******* Setters and Getters ******//


    public GraphicsContext getDrawer(){
        return this.drawer;
    }



    public void playMusic(String filePath){

        this.musicPlayer=new MediaPlayer(new Media(filePath));
        this.musicPlayer.play();
    }

    public void playSound(String filePath){

        this.soundPlayer.stop();
        this.soundPlayer=new MediaPlayer(new Media(filePath));
        this.soundPlayer.play();
    }



    public void setMainApp(Main mainApp){
        this.mainApp=mainApp;
    }

    public Canvas getGameScene_Canvas(){
        return this.gameScene_Canvas;
    }

    //********** Draw System ***********//

    public void drawMainMenu(){

        Image map=new Image("file:Resources/Imgs/Map_Img.png");
        drawer.drawImage(map,0,0);

    }



    @FXML
    private void handleStart(){

        Image map=new Image("file:Resources/Imgs/Map_Img.png");

        drawer.drawImage(map,-460,-1725);

    }

    @FXML
    private void handleExit(){

        Image background=new Image("file:Resources/Imgs/Room01_Img.png");
       // Image characters=new Image("file:Resources/Imgs/CharacterMenu_Img.png");
        drawer.drawImage(background,-27,0);
       // drawer.drawImage(characters,300,200);
        this.gameScene_Canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    if(mouseEvent.getX()<=100 & mouseEvent.getY()<=100){
                        System.out.println("picha lo logre!");
                    }
                }
            }
        });


    }




}
