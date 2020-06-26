package Controllers.Models.SceneBuilder;

import Controllers.Models.Player;
import Controllers.Models.SpriteFactory.Products.Background;
import Controllers.Models.SpriteFactory.Products.iButton;
import Controllers.Models.SpriteFactory.Sprite;
import Controllers.Models.SpriteFactory.SpriteFactory;
import Controllers.Views.Scene_Controller;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;

public class MiniGame {


    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Identifiers
    private GameType gameType;

    //Render System
    private SpriteFactory spriteFactory;
    private ArrayList<Player> playerList;
    private ArrayList<Sprite> gameComponents;
    private ArrayList<iButton> ButtonsList;
    private Scene_Controller sceneController;

    //Sound System
    private MediaPlayer musicPlayer;
    private MediaPlayer soundPlayer;

    //GameLoop
    private AnimationTimer gameLoop;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//


    //Constructor
    public MiniGame() {

    }

    //Setters and Getters

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public void setSceneController(Scene_Controller sceneController) {
        this.sceneController = sceneController;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public void setMusicPlayer(MediaPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    public void setSoundPlayer(MediaPlayer soundPlayer) {
        this.soundPlayer = soundPlayer;
    }

    public void setSpriteFactory(SpriteFactory spriteFactory) {
        this.spriteFactory = spriteFactory;
    }

    public SpriteFactory getSpriteFactory() {
        return spriteFactory;
    }

    public ArrayList<Player> getPlayerList() {
        return this.playerList;
    }

    public ArrayList<Sprite> getGameComponents() {
        return this.gameComponents;
    }

    public ArrayList<iButton> getButtonsList() {
        return this.ButtonsList;
    }

    public Scene_Controller getSceneController() {
        return this.sceneController;
    }

    //Render System

    public void update(){
        for(int element=0;element<gameComponents.size();element++){
            this.gameComponents.get(element).update(this.sceneController.getDrawer());
        }
    }

    public void initGameComponents(){

    }

    //Sound System
    public void playMusic(String filePath){

        Media media=new Media(new File(filePath).toURI().toString());
        this.musicPlayer=new MediaPlayer(media);

        this.musicPlayer.setVolume(0.1);
        this.musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        this.musicPlayer.setAutoPlay(true);

    }

    public void playSound(String filePath){

        Media media=new Media(new File(filePath).toURI().toString());
        this.soundPlayer=new MediaPlayer(media);
        this.soundPlayer.setVolume(0.3);
        this.soundPlayer.setAutoPlay(true);

    }

    //Event Handler System
    public void handleMouseEvents(){
        this.sceneController.getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){

                    System.out.println("test handler");

                }
            }
        });
    }

    public void handleKeyEvents(){
        this.sceneController.getCanvas().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()== KeyCode.ESCAPE){
                    System.out.println("Pause");
                }
            }
        });
    }

    //Game Loop System
    public void start(){

        //Init Render System
        this.gameComponents=new ArrayList<>();
        this.ButtonsList=new ArrayList<>();

        //Init Background
        Background background=(Background) this.spriteFactory.createBackground(this.gameType);
        background.setPosition(482,5);
        this.gameComponents.add(background);

        //Init Board
        this.initGameComponents();

        //Init  Event Handler System
        this.handleMouseEvents();
        this.handleKeyEvents();

        this.playMusic(this.gameType.getMusicFilePath());

        //Init Game Loop
        this.gameLoop=new AnimationTimer() {
            @Override
            public void handle(long l) {

                update();
            }
        };

        this.gameLoop.start();

    }

    public void stop(){
        this.gameLoop.stop();
    }
}
