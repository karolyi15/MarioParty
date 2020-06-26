package Controllers.Models.SceneBuilder.Products;

import Controllers.Models.Dice;
import Controllers.Models.Player;
import Controllers.Models.SceneBuilder.MiniGame;
import Controllers.Models.SpriteFactory.Products.Character;
import Controllers.Models.SpriteFactory.Products.CharacterType;
import Controllers.Models.SpriteFactory.Products.Node;
import Controllers.Models.SpriteFactory.Sprite;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class BoardGameScene extends MiniGame {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Camara System
    private double[] camara;

    //Game Components
    private Dice dice;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//
    //Constructors
    public BoardGameScene(){

    }

    //Camara System

    /*public  void restartCamara(){
        this.camara[0]=350;
        this.camara[1]=1400;
        this.playerList.get(0).setPosition(camara[0],camara[1]);
    }


    public  void updateCamara(){
        Player tempPlayer=players.get(0);
        Sprite map=this.playerList.get(0);

        while(tempPlayer.getCharacter().getPositionX()>=500) {

            map.setPosition(map.getPositionX()+100,map.getPositionY());
            tempPlayer.getCharacter().setPosition(tempPlayer.getCharacter().getPositionX()-100,tempPlayer.getCharacter().getPositionY());

        }

    }*/



    //Event Handling System
    /*@Override
    public void handleMouseEvents(){
        this.sceneController.getGameScene().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    Player tempPlayer=players.get(0);
                    int diceRolled=dice.throwDice();
                    System.out.println(diceRolled);
                    int tempCurrent=tempPlayer.getCurrentNode()+diceRolled;
                    tempPlayer.setCurrentNode(tempCurrent);

                    tempPlayer.getCharacter().setPosition(board.get(tempCurrent).getPositionX()-playerList.get(0).getPositionX(),board.get(tempCurrent).getPositionY()-playerList.get(0).getPositionY());
                    System.out.println(tempPlayer.getCharacter().getPositionX());
                    //System.out.println(dice.throwDice());
                    //System.out.println(dice.throwDice());

                }
            }
        });
    }*/


    //Render System

   /* public void init(){

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


    }*/


    //Game Loop
    /*@Override
    public void initGame(){


        //Set Game Type
        this.gameType=GameType.BOARD;

        //Init Game Board
        this.dice=new Dice();

        this.init();

        //Init Game Players

        this.playerList=new ArrayList<>();
        Sprite boardImg=this.spriteFactory.createBackground(this.gameType);
        boardImg.setPosition(350,1400);
        this.playerList.add(boardImg);

        Character player1=(Character) this.spriteFactory.createCharacter(CharacterType.MARIO);
        this.playerList.add(player1);

        this.players=new ArrayList<>();
        players.add(new Player(player1));


        //Init Camara System
        this.camara= new double[2];
        restartCamara();



        //test
        this.players.get(0).getCharacter().setPosition(board.get(players.get(0).getCurrentNode()).getPositionX()-playerList.get(0).getPositionX(),board.get(players.get(0).getCurrentNode()).getPositionY()-playerList.get(0).getPositionY());

    }*/


}
