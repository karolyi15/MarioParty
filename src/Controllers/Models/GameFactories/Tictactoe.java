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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;


public class Tictactoe implements iMiniGame {


    //Fields
    //Identifiers
    private GameType gameType;
    private int turno;

    //Camara System
    private double[] camara;

    //Render System
    private Scene_Controller sceneController;

    //Game Components
    private Button[] board;
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

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
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

                    Button tempButton=ButtonsList.get(element);

                    if(tempButton.getPosition()[0]<=mouseEvent.getX() & mouseEvent.getX()<=tempButton.getPosition()[0]+tempButton.getWidth()){
                        if(tempButton.getPosition()[1]<mouseEvent.getY() & mouseEvent.getY()<tempButton.getPosition()[1]+tempButton.getHeight())
                        ButtonsList.get(element).setState(changeTurn());
                    }
                }

                if(checkWinner() == true){

                    System.out.println("GANO EL JUGADOR" + turno*-1);

                }else{
                    System.out.println("SIGUE EL JUGADOR" + turno);

                }

            }
        });
    }
    @Override
    public void handleKeyEvents(){

        this.sceneController.getGameScene_Canvas().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                System.out.println("key");
            }
        });

    }

    //Render System
    @Override
    public void createBoard(){

        this.board=new Button[9];
        for(int row = 0; row<3;row++){
            for(int column = 0; column<3;column++){
                Button button=new Button(55,55);
                button.setPosition(83*column+57,80*row+90);

                this.ButtonsList.add(button);
                this.componentList.add(button);

            }
        }

    }

    private int changeTurn(){
        this.turno=this.turno*-1;
        return this.turno;
    }

    private boolean checkWinner(){

        int[][] tableWinner = new int[8][3];
        //String topRow,midRow,botRow,leftRow,midCol,rightCol,cross1,cross2;
            /*topRow = "012"; midRow = "345"; botRow = "678"; leftRow = "036";
            midCol = "147"; rightCol = "258"; cross1 = "048"; cross2 = "246";*/
        tableWinner[0][0] = 0; tableWinner[0][1] = 1; tableWinner[0][2] = 2; //topRow = "012";
        tableWinner[1][0] = 3; tableWinner[1][1] = 4; tableWinner[1][2] = 5; //midRow = "345";
        tableWinner[2][0] = 6; tableWinner[2][1] = 7; tableWinner[2][2] = 8; //botRow = "678";
        tableWinner[3][0] = 0; tableWinner[3][1] = 3; tableWinner[3][2] = 6; //leftRow = "036";
        tableWinner[4][0] = 1; tableWinner[4][1] = 4; tableWinner[4][2] = 7; //midCol = "147";
        tableWinner[5][0] = 2; tableWinner[5][1] = 5; tableWinner[5][2] = 8; //rightCol = "258";
        tableWinner[6][0] = 0; tableWinner[6][1] = 4; tableWinner[6][2] = 8; //cross1 = "048";
        tableWinner[7][0] = 2; tableWinner[7][1] = 4; tableWinner[7][2] = 6; //cross2 = "246";
        int cont = 0;
        for(int i = 0; i < 8 ; i++){
            cont = 0;
            for(int j = 0; j < 3 ; j++){
                if(ButtonsList.get(tableWinner[i][j]).getValue() == this.turno) {
                    cont++;
                }
            }
            if(cont == 3){
                return true;
            }
        }
        return false;

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


        //Init Render System
        this.componentList=new ArrayList<>();
        this.componentList.add(this.spriteFactory.createBackground(this.gameType));
        //this.componentList.add(this.spriteFactory.)
        this.ButtonsList=new ArrayList<>();

        //Init Board
        this.createBoard();

        this.turno=1;

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
