package Controllers.Models;

import Controllers.Views.GameScene_Controller;
import javafx.animation.AnimationTimer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
    double[] camaraPosition={0,0};

    private AnimationTimer animationTimer;
    Image testImage=new Image("file:Resources/Imgs/GameMap_Img.png");
    Image character=new Image("file:Resources/Imgs/Mario_Img.png");

    //Sound System
    private final String GAME_MUSIC_PATH="src/Resources/Sounds/Title_Music.mp3";

    //Game
    private int currentScene;
    private ArrayList<Character> playersList= new ArrayList();
    public ArrayList<Node> mapSpaces=new ArrayList<>();
    private AnimationTimer gameLoop;

    public IntegerProperty characterPos=new SimpleIntegerProperty(0);

    //********************************************* Class Methods **********************************************//


    //********** Constructors **********//


    public Game(GameScene_Controller sceneController){
        this.sceneController=sceneController;
        this.currentScene=0;
        this.initGame();
        this.startGameLoop();

    }

    //******* Setters and Getters ******//

    public void createMap(){

        //Main Path
        this.mapSpaces.add(new Node(503,1626));
        this.mapSpaces.add(new Node(576,1626));
        this.mapSpaces.add(new Node(576,1684));

        this.mapSpaces.add(new Node(576,1740));
        this.mapSpaces.add(new Node(633,1740));
        this.mapSpaces.add(new Node(691,1740));
        this.mapSpaces.add(new Node(748,1740));
        this.mapSpaces.add(new Node(806,1740));
        this.mapSpaces.add(new Node(863,1740));
        this.mapSpaces.add(new Node(922,1740));
        this.mapSpaces.add(new Node(979,1740));

        this.mapSpaces.add(new Node(979,1681));
        this.mapSpaces.add(new Node(1041,1681));
        this.mapSpaces.add(new Node(1097,1681));

        this.mapSpaces.add(new Node(1097,1741));
        this.mapSpaces.add(new Node(1150,1741));

        this.mapSpaces.add(new Node(1150,1796));
        this.mapSpaces.add(new Node(1290,1799));
        this.mapSpaces.add(new Node(1267,1800));
        this.mapSpaces.add(new Node(1325,1798));
        this.mapSpaces.add(new Node(1383,1798));
        this.mapSpaces.add(new Node(1439,1798));
        this.mapSpaces.add(new Node(1497,1798));

        this.mapSpaces.add(new Node(1497,1739));
        this.mapSpaces.add(new Node(1553,1739));
        this.mapSpaces.add(new Node(1612,1739));
        this.mapSpaces.add(new Node(1671,1739));




    }



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

    public void refreshCamara(){

    }

    //Restart Camara
    public void restartCamara(){

    }

    public void initGame(){

        this.createMap();
        this.handleMouseEvent();


    }

    public void drawMap(){
        double tempX=-350+mapSpaces.get(currentScene).getPositionX()-24;
        double tempY=-1400+mapSpaces.get(currentScene).getPositionY()-34;


        this.sceneController.getDrawer().drawImage(testImage,-350,-1400);
        this.sceneController.getDrawer().drawImage(character,67,309,31,34,tempX,tempY,46.5,51);
        //this.sceneController.getDrawer().drawImage(character,tempX,tempY);
    }

    public void handleMouseEvent(){
        this.sceneController.getGameScene_Canvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    currentScene+=1;
                    System.out.println("current scene= "+currentScene);
                }
            }
        });
    }

    public void startGameLoop(){
       this.gameLoop=new AnimationTimer() {
           @Override
           public void handle(long l) {
               drawMap();
           }
       };
       this.gameLoop.start();
    }





}
