package Controllers.Models.GameFactories;

import Controllers.Models.SpriteFactories.Button;
import Controllers.Models.SpriteFactories.iSprite;
import Controllers.Models.SpriteFactories.Node;
import Controllers.Models.SpriteFactories.SpriteFactory;

import Controllers.Views.Scene_Controller;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;


public class Tictactoe implements iMiniGame {


    //Fields
    //Identifiers
    private GameType gameType;

    //Camara System
    private double[] camara;

    //Render System
    private Scene_Controller sceneController;

    //Game Components
    private Node[][] board;
    private ArrayList<iSprite> componentList;
    private ArrayList<Button> ButtonsList;

    //Factories
    private SpriteFactory spriteFactory;

    //GameLoop
    private AnimationTimer gameLoop;
    //******************************************************************************************************************
    //******************************************************************************************************************
   /* private TicTacToeButton[] buttons;

    private final int MAXBUTTONS = 9;

    private TicTacToeCarlos TTTGame;

    PootyImages imgEnum;

    public void initialize(){
        TTTGame = new TicTacToeCarlos();
        Image imgbackground= new Image(imgEnum.TTTBACKGROUND.getImagen());
        Image imgboard = new Image(imgEnum.TTTBOARD.getImagen());

        buttons = new TicTacToeButton[MAXBUTTONS];
        int pos = 0;
        for(int row = 0; row<3;row++){
            for(int column = 0; column<3;column++){
                TicTacToeButton btn1 = new TicTacToeButton();
                btn1.setLayoutX(83*column+57);
                btn1.setLayoutY(80*row+90);
                btn1.setMaxSize(10,10);
                buttons[pos] = btn1;
                pos++;

            }
        }
        // anchorPane.setDisable(false);
    }

    public void handle(ActionEvent event){
        for (int i=0; i<MAXBUTTONS ; i++) {
            if(buttons[i] == event.getSource()){
                //buttons[i].changeState();
                if(buttons[i].getPressed() == false) {
                    buttons[i].setState(TTTGame.getTurno());
                    TTTGame.changeTurno();
                }
                if(TTTGame.checkWinner(TTTGame.getTurno()*-1,this.buttons) == true){

                    System.out.println("GANO EL JUGADOR" + String.valueOf(TTTGame.getTurno()));

                }else{
                    System.out.println("SIGUE EL JUGADOR" + String.valueOf(TTTGame.getTurno()));
                    //showAlert();
                }
            }
        }

    }*/

    //*****************************************************************************************************************
    //***************************************************************************************************************
    //Methods
    //Constructor
    public Tictactoe(Scene_Controller sceneController,SpriteFactory spriteFactory){
        this.spriteFactory=spriteFactory;
        this.initGame(sceneController);
        this.start();
    }


    //Camara System
    @Override
    public void restartCamara(){
        this.camara[0]=0;
        this.camara[1]=0;

    }
    @Override
    public void updateCamara(){

    }

    //Audio System
    @Override
    public void playSound(){

    }
    @Override
    public void playMusic(){
        this.sceneController.playMusic(gameType.getMusicFilePath());
    }

    //Event Handling System
    @Override
    public void handleMouseEvents(){
        this.sceneController.getGameScene_Canvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                for(int element=0;element<ButtonsList.size();element++){
                    if(ButtonsList.get(element).getPosition()[0]<=mouseEvent.getX() &mouseEvent.getX()<=ButtonsList.get(element).getPosition()[0]+ButtonsList.get(element).getWidth()){
                        if(ButtonsList.get(element).getPosition()[1]<mouseEvent.getY() & mouseEvent.getY()<ButtonsList.get(element).getPosition()[1]+ButtonsList.get(element).getHeight())
                        ButtonsList.get(element).setState(1);
                    }
                }

            }
        });
    }
    @Override
    public void handleKeyEvents(){

    }

    //Render System
    @Override
    public void createBoard(){

        this.board=new Node[3][3];


    }


    @Override
    public void update(){

        for(int element=0;element<this.componentList.size();element++){
            this.componentList.get(element).update(this.sceneController.getDrawer());
        }

    }

    //Collide System


    //Game Loop
    @Override
    public void initGame(Scene_Controller sceneController){

        //Set Game Type
        this.gameType=GameType.TICTACTOE;

        //Set Scene Controller
        this.sceneController=sceneController;

        //Init Handlers
        this.handleMouseEvents();
        this.handleKeyEvents();

        //Init Board
        this.createBoard();

        //Init Render System
        this.componentList=new ArrayList<>();
        this.componentList.add(this.spriteFactory.createBackground(this.gameType));
        //this.componentList.add(this.spriteFactory.)
        this.ButtonsList=new ArrayList<>();
        Button button1=new Button();
        button1.setPosition(100,100);
        this.ButtonsList.add(button1);
        this.componentList.add(button1);

        //Init Sound System
        //this.playMusic();


    }
    @Override
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
