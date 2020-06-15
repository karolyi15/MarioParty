package Controllers.Models.GameFactories;

import Controllers.Models.SpriteFactories.SpriteFactory;
import Controllers.Models.SpriteFactories.iSprite;
import Controllers.Views.Scene_Controller;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class CharacterSelectionScene implements iMiniGame{


    //Fields
    //Identifiers
    private GameType gameType;

    //Camara System
    private double[] camara;

    //Render System
    private SpriteFactory spriteFactory;
    private Scene_Controller sceneController;
    private ArrayList<iSprite> gameComponents;


    //GameLoop
    private AnimationTimer gameLoop;

    //Methods
    //Constructor
    public CharacterSelectionScene(Scene_Controller sceneController){
        this.initGame(sceneController);
        this.start();
    }


    //Camara System
    public void restartCamara(){
        this.camara[0]=0;
        this.camara[1]=0;

    }
    public void updateCamara(){
        this.camara[0]=0;
        this.camara[1]=0;

    }

    //Audio System
    public void playSound(){
        System.out.println("playing Sound");
    }
    public void playMusic(){
        this.sceneController.playMusic(this.gameType.getMusicFilePath());
    }

    //Event Handling System
    public void handleMouseEvents(){
        this.sceneController.getGameScene_Canvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){

                    System.out.println("test handler");

                }
            }
        });
    }
    public void handleKeyEvents(){
        this.sceneController.getGameScene_Canvas().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()== KeyCode.ESCAPE){
                    System.out.println("Pause");
                }
            }
        });
    }

    //Render System
    public void createBoard(){

    }
    public void update(){
        for(int element=0;element<gameComponents.size();element++){
            this.gameComponents.get(element).update(this.sceneController.getDrawer());
        }
    }

    //Collide System


    //Game Loop
    public void initGame(Scene_Controller sceneController){

        //Set Scene Controller
        this.sceneController=sceneController;

        //Set Game Type
        this.gameType=GameType.CHARACTERSELECTIONMENU;

        //Init Camara System
        this.camara=new double[2];
        this.restartCamara();
        //Init Handlers
        this.handleMouseEvents();
        this.handleKeyEvents();
    }
    public void start(){
        this.gameLoop=new AnimationTimer() {
            @Override
            public void handle(long l) {
                update();
            }
        };

        this.gameLoop.start();
    }
}
