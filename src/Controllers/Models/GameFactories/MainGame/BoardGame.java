package Controllers.Models.GameFactories.MainGame;

import Controllers.Models.GameComponents.Dice;
import Controllers.Models.GameComponents.Player;
import Controllers.Models.GameFactories.GameType;
import Controllers.Models.GameFactories.MiniGameFactory;
import Controllers.Models.GameFactories.MiniGames.iMiniGame;
import Controllers.Models.SpriteFactories.Characters.Character;
import Controllers.Models.SpriteFactories.Characters.CharacterType;
import Controllers.Models.SpriteFactories.Graphics.Node;
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

public class BoardGame implements iMiniGame {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Identifiers
    private GameType gameType;

    //Camara System
    private double[] camara;

    //Render System
    private Scene_Controller sceneController;

    //Game Components
    private Dice dice;
    private ArrayList<iSprite> playerList;
    private ArrayList<Player> players;
    private ArrayList<Node> board;

    //Factories
    private SpriteFactory spriteFactory;
    private MiniGameFactory miniGameFactory;

    //GameLoop
    private AnimationTimer gameLoop;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//
    //Constructors
    public BoardGame(Scene_Controller scene_controller,SpriteFactory spriteFactory){
        this.spriteFactory=spriteFactory;
        initGame(scene_controller);
        start();
    }

    //Camara System
    @Override
    public  void restartCamara(){
        this.camara[0]=350;
        this.camara[1]=1400;
        this.playerList.get(0).setPosition(camara[0],camara[1]);
    }

    @Override
    public  void updateCamara(){

    }

    //Audio System
    @Override
    public void playSound(){
        System.out.println("playing Sound");
    }
    @Override
    public void playMusic(){
        this.sceneController.playMusic(this.gameType.getMusicFilePath());
    }

    //Event Handling System
    @Override
    public void handleMouseEvents(){
        this.sceneController.getGameScene_Canvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    Player tempPlayer=players.get(0);
                    int diceRolled=dice.throwDice();
                    System.out.println(diceRolled);
                    int tempCurrent=tempPlayer.getCurrentNode()+diceRolled;
                    tempPlayer.setCurrentNode(tempCurrent);

                    tempPlayer.getCharacter().setPosition(board.get(tempCurrent).getPositionX(),board.get(tempCurrent).getPositionY());
                    //System.out.println(dice.throwDice());
                    //System.out.println(dice.throwDice());

                }
            }
        });
    }

    @Override
    public void handleKeyEvents(){
        this.sceneController.getGameScene_Canvas().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()==KeyCode.TAB){
                    System.out.println("Pause");
                }
            }
        });
    }

    //Render System
    @Override
    public void createBoard(){

        //Main Path
        this.board.add(new Node(503,1626));
        this.board.add(new Node(576,1626));
        this.board.add(new Node(576,1684));

        this.board.add(new Node(576,1740));
        this.board.add(new Node(633,1740));
        this.board.add(new Node(691,1740));
        this.board.add(new Node(748,1740));
        this.board.add(new Node(806,1740));
        this.board.add(new Node(863,1740));
        this.board.add(new Node(922,1740));
        this.board.add(new Node(979,1740));

        this.board.add(new Node(979,1681));
        this.board.add(new Node(1041,1681));
        this.board.add(new Node(1097,1681));

        this.board.add(new Node(1097,1741));
        this.board.add(new Node(1150,1741));

        this.board.add(new Node(1150,1796));
        this.board.add(new Node(1290,1799));
        this.board.add(new Node(1267,1800));
        this.board.add(new Node(1325,1798));
        this.board.add(new Node(1383,1798));
        this.board.add(new Node(1439,1798));
        this.board.add(new Node(1497,1798));

        this.board.add(new Node(1497,1739));
        this.board.add(new Node(1553,1739));
        this.board.add(new Node(1612,1739));
        this.board.add(new Node(1671,1739));


    }
    @Override
    public void update(){
        for(int element=0;element<playerList.size();element++){
            playerList.get(element).update(this.sceneController.getDrawer());
        }
    }

    //Game Loop
    @Override
    public void initGame(Scene_Controller sceneController){

        //Set Game Controller
        this.sceneController=sceneController;
        //Set Game Type
        this.gameType=GameType.BOARD;

        //Init Game Board
        this.dice=new Dice();
        this.board=new ArrayList<>();
        this.createBoard();

        //Init Game Players

        this.playerList=new ArrayList<>();
        iSprite boardImg=this.spriteFactory.createBackground(this.gameType);
        boardImg.setPosition(350,1400);
        this.playerList.add(boardImg);

        Character player1=(Character) this.spriteFactory.createCharacter(CharacterType.MARIO);
        this.playerList.add(player1);

        this.players=new ArrayList<>();
        players.add(new Player(player1));


        //Init Camara System
        this.camara= new double[2];
        restartCamara();

        //Init Handlers
        this.handleMouseEvents();
        this.handleKeyEvents();

        //Init Sound System
        //this.playMusic();

        //test
        this.players.get(0).getCharacter().setPosition(this.board.get(0).getPositionX(),this.board.get(0).getPositionY());

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
