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

public class GameScene {


    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//


    //Render System
    private SceneType sceneType;
    private Sprite background;
    private SpriteFactory spriteFactory;
    private Scene_Controller sceneController;

    //Input Handler System
    private ArrayList<Player> playerList;
    private ArrayList<Sprite> gameComponents;
    private ArrayList<iButton> buttonsList;

    //Sound System
    private MediaPlayer musicPlayer;
    private MediaPlayer soundPlayer;

    //GameLoop
    private AnimationTimer gameLoop;
    private SceneDirector director;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//


    //Constructor
    public GameScene(SceneType sceneType) {
        this.sceneType = sceneType;
    }

    //Setters and Getters

    //Render System
    public void setSceneController(Scene_Controller sceneController) {
        this.sceneController = sceneController;
    }
    public Scene_Controller getSceneController() {
        return this.sceneController;
    }

    public void setSpriteFactory(SpriteFactory spriteFactory) {
        this.spriteFactory = spriteFactory;
    }
    public SpriteFactory getSpriteFactory() {
        return spriteFactory;
    }

    public Sprite getBackground() {
        return background;
    }

    //Input Handler System
    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }
    public ArrayList<Player> getPlayerList() {
        return this.playerList;
    }

    public ArrayList<iButton> getButtonsList() {
        return this.buttonsList;
    }

    public ArrayList<Sprite> getGameComponents() {
        return this.gameComponents;
    }

    //Game Loop
    public AnimationTimer getGameLoop() {
        return this.gameLoop;
    }

    public SceneDirector getSceneDirector() {
        return director;
    }

    public void setSceneDirector(SceneDirector director) {
        this.director = director;
    }

    //Render System
    public void update(){
        for(int element=0;element<gameComponents.size();element++){
            this.gameComponents.get(element).update(this.sceneController.getDrawer());
        }
    }

    public void initGameComponents(){
        System.out.println("There are not elements to initialize");
    }


    //Sound System

    public MediaPlayer getMusicPlayer() {
        return musicPlayer;
    }



    public MediaPlayer getSoundPlayer() {
        return soundPlayer;
    }



    public void playMusic(String filePath){

        Media media=new Media(new File(filePath).toURI().toString());
        this.musicPlayer=new MediaPlayer(media);

        this.musicPlayer.setVolume(0.2);
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

                    System.out.println("Test Mouse handler");

                }
            }
        });
    }

    public void handleKeyEvents(){
        this.sceneController.getCanvas().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()== KeyCode.ESCAPE){
                    System.out.println("Pause Test Key Handler");
                }
            }
        });
    }

    //Game Loop System
    public void start(){

        //Init Render System
        this.gameComponents=new ArrayList<>();
        this.buttonsList =new ArrayList<>();

        //Init Input System
        this.playerList=new ArrayList<>();

        //Init Background
        this.background =(Background) this.spriteFactory.createBackground(this.sceneType);
        this.gameComponents.add(background);

        //Init Game Components Rendering
        this.initGameComponents();

        //Init Event Handler System
        this.handleMouseEvents();
        this.handleKeyEvents();

        this.playMusic(this.sceneType.getMusicFilePath());

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
