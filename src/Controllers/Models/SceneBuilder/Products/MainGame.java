package Controllers.Models.SceneBuilder.Products;

import Controllers.Models.Dice;
import Controllers.Models.Player;
import Controllers.Models.SceneBuilder.GameScene;
import Controllers.Models.SceneBuilder.SceneType;
import Controllers.Models.SpriteFactory.Products.*;
import Controllers.Models.SpriteFactory.Products.Character;
import Controllers.Models.SpriteFactory.Sprite;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


import java.util.ArrayList;

public class MainGame extends GameScene {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private ArrayList<Node> realBoard;
    private ArrayList<Node> relativeBoard;

    //Camara System
    private double[] camara;

    //Game Components
    private Dice dice;
    private int playerTurn;

    //UI Elements
    Sprite portrait;
    Button tdice;
    Button tarea;

    //Scene Transition System
    SceneType nextMiniGame;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//
    //Constructors
    public MainGame(){
        super(SceneType.BOARD);
    }

    //Camara System

    public  void restartCamara(){
        this.camara[0]=350;
        this.camara[1]=1400;
        super.getBackground().setPosition(camara[0],camara[1]);

    }

    private void setCamaraOn(Player player){
        this.restartCamara();
        super.getBackground().setPosition(this.realBoard.get(player.getCurrentNode()).getPositionX()-super.getBackground().getPositionX(),super.getBackground().getPositionY());
        this.updatePathPosition();
        this.updatePlayerPosition();

    }


    /*public  void updateCamara(Player player){


        //Update Path Position
        //this.updatePathPosition();


    }*/

    private void updatePathPosition(){
        System.out.println("***************Path Position Update*****************\n");
        for(int node = 0; node<this.realBoard.size(); node++){

            Node realNode=this.realBoard.get(node);
            Node relativeNode=this.relativeBoard.get(node);

            relativeNode.setPosition(realNode.getPositionX()-super.getBackground().getPositionX(),realNode.getPositionY()-super.getBackground().getPositionY());
            //System.out.println("node "+node+" posx: "+relativeNode.getPositionX()+" posy: "+relativeNode.getPositionY()+"\n");
        }
    }



    //Event Handling System
    @Override
    public void handleMouseEvents(){
        super.getSceneController().getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                for(int element = 0; element< MainGame.super.getButtonsList().size(); element++){

                    Button tempButton= (Button) MainGame.super.getButtonsList().get(element);

                    if(tempButton.getPositionX()<=mouseEvent.getX() & mouseEvent.getX()<=tempButton.getPositionX()+tempButton.getWidth()){
                        if(tempButton.getPositionY()<mouseEvent.getY() & mouseEvent.getY()<tempButton.getPositionY()+tempButton.getHeight())

                            throwDice(MainGame.super.getPlayerList().get(playerTurn));
                            //updateCamara(MainGame.super.getPlayerList().get(playerTurn));

                            stop();

                    }
                }


            }
        });
    }


    //Render System

   public void buildPath(){

       /*this.board.add(new Node(503,1626));
       this.board.add(new Node(576,1626));
       this.board.add(new Node(576,1684));*/

        //Main Path
        this.realBoard.add(new Node(503,1626));
        this.realBoard.add(new Node(576,1626));
        this.realBoard.add(new Node(576,1684));

        this.realBoard.add(new Node(576,1740));
        this.realBoard.add(new Node(633,1740));
        this.realBoard.add(new Node(691,1740));
        this.realBoard.add(new Node(748,1740));
        this.realBoard.add(new Node(806,1740));
        this.realBoard.add(new Node(863,1740));
        this.realBoard.add(new Node(922,1740));
        this.realBoard.add(new Node(979,1740));

        this.realBoard.add(new Node(979,1681));
        this.realBoard.add(new Node(1041,1681));
        this.realBoard.add(new Node(1097,1681));

        this.realBoard.add(new Node(1097,1741));
        this.realBoard.add(new Node(1150,1741));

        this.realBoard.add(new Node(1150,1796));
        this.realBoard.add(new Node(1290,1799));
        this.realBoard.add(new Node(1267,1800));
        this.realBoard.add(new Node(1325,1798));
        this.realBoard.add(new Node(1383,1798));
        this.realBoard.add(new Node(1439,1798));
        this.realBoard.add(new Node(1497,1798));

        this.realBoard.add(new Node(1497,1739));
        this.realBoard.add(new Node(1553,1739));
        this.realBoard.add(new Node(1612,1739));
        this.realBoard.add(new Node(1671,1739));

       ///Relative

       this.relativeBoard.add(new Node(503,1626));
       this.relativeBoard.add(new Node(576,1626));
       this.relativeBoard.add(new Node(576,1684));

       this.relativeBoard.add(new Node(576,1740));
       this.relativeBoard.add(new Node(633,1740));
       this.relativeBoard.add(new Node(691,1740));
       this.relativeBoard.add(new Node(748,1740));
       this.relativeBoard.add(new Node(806,1740));
       this.relativeBoard.add(new Node(863,1740));
       this.relativeBoard.add(new Node(922,1740));
       this.relativeBoard.add(new Node(979,1740));

       this.relativeBoard.add(new Node(979,1681));
       this.relativeBoard.add(new Node(1041,1681));
       this.relativeBoard.add(new Node(1097,1681));

       this.relativeBoard.add(new Node(1097,1741));
       this.relativeBoard.add(new Node(1150,1741));

       this.relativeBoard.add(new Node(1150,1796));
       this.relativeBoard.add(new Node(1290,1799));
       this.relativeBoard.add(new Node(1267,1800));
       this.relativeBoard.add(new Node(1325,1798));
       this.relativeBoard.add(new Node(1383,1798));
       this.relativeBoard.add(new Node(1439,1798));
       this.relativeBoard.add(new Node(1497,1798));

       this.relativeBoard.add(new Node(1497,1739));
       this.relativeBoard.add(new Node(1553,1739));
       this.relativeBoard.add(new Node(1612,1739));
       this.relativeBoard.add(new Node(1671,1739));



        this.updatePathPosition();
    }


    //Game Loop
    @Override
    public void initGameComponents(){

        //Init Game Components
        this.dice=new Dice();
        this.playerTurn=0;
        this.realBoard =new ArrayList<>();
        this.relativeBoard=new ArrayList<>();
        this.buildPath();

        //Init Camara System
        this.camara= new double[2];
        //restartCamara();

        //Init UI Components
        Button diceButton=new Button(540,435);
        diceButton.setText("Throw Dice");
        diceButton.setId("Dice Button");
        diceButton.resizeImage(150,50);
        super.getButtonsList().add(diceButton);
        super.getGameComponents().add(diceButton);

        Button textArea=new Button(390,10);
        textArea.setText("Player #");
        textArea.setId("Text Area");
        textArea.setType(NodeType.TEXTAREA);
        textArea.resizeImage(300,75);
        super.getGameComponents().add(textArea);

        //Test Bench
        Player player1=new Player(NodeType.MARIOPORTRAIT);
        Player player2=new Player(NodeType.MARIOPORTRAIT);

        super.getPlayerList().add(player1);
        super.getPlayerList().add(player2);

        super.getGameComponents().add(player1.getCharacter());
        super.getGameComponents().add(player2.getCharacter());

        this.updatePlayerPosition();
        //this.setPlayersBoard();
    }


    //Game Logic

    private void updatePlayerPosition(){

       for(int player=0;player<super.getPlayerList().size();player++){
           Player tempPlayer=super.getPlayerList().get(player);
           tempPlayer.getCharacter().setPosition(this.relativeBoard.get(tempPlayer.getCurrentNode()).getPositionX(),this.relativeBoard.get(tempPlayer.getCurrentNode()).getPositionY());
       }
    }

    /*private void setPlayersBoard(){
        for(int player=0;player<super.getPlayerList().size();player++) {
            for (int node = 0; node < this.realBoard.size(); node++) {
                Node tempNode = this.realBoard.get(node);
                tempNode.setPosition(tempNode.getPositionX()-super.getMap().getPositionX(),tempNode.getPositionY()-super.getMap().getPositionY());
                super.getPlayerList().get(player).getGameBoard().add(tempNode);
            }
        }


    }*/

    private void changeTurn(){

        this.playerTurn+=1;
        if(this.playerTurn>=super.getPlayerList().size()){
            this.playerTurn=0;
        }
        this.setCamaraOn(super.getPlayerList().get(this.playerTurn));
        //this.updatePathPosition();
        this.displayPlayerInfo(super.getPlayerList().get(this.playerTurn));

    }

    private void displayPlayerInfo(Player player){
        System.out.println("Player info displayed");
    }

    private void throwDice(Player player){

        System.out.println("Playing Player "+(this.playerTurn+1));
        System.out.println("Actual x: "+player.getCharacter().getPositionX()+" Actual y: "+player.getCharacter().getPositionY());
       if(player.getPunished()==0) {

           for (int dice = 0; dice < 2; dice++) {
               int diceValue = this.dice.throwDice();
               System.out.println("Dice "+dice+" :" + diceValue);
               if (diceValue == 0) {

                   player.setPunished(player.getPunished() + 1);

               } else {

                   int actualNode=player.getCurrentNode();

                   if(actualNode+diceValue>26){

                       player.setCurrentNode(26-(actualNode+diceValue-26));

                   }else if(actualNode+diceValue==26){

                       System.out.println("Player "+playerTurn+1+"Wins!!");
                       player.setCurrentNode(player.getCurrentNode()+diceValue);
                       //super.getGameLoop().stop();
                   }else{
                       player.setCurrentNode(player.getCurrentNode()+diceValue);
                   }
                   System.out.println("Player current node: "+player.getCurrentNode());
                   //this.updatePathPosition();
                   //this.setCamaraOn(player.getCharacter());
                   player.getCharacter().setPosition(this.relativeBoard.get(player.getCurrentNode()).getPositionX(),this.relativeBoard.get(player.getCurrentNode()).getPositionY());

                   System.out.println("New x: "+player.getCharacter().getPositionX()+" New y: "+player.getCharacter().getPositionY());
               }
           }
       }else{
           player.setPunished(player.getPunished()-1);
           System.out.println("Players Punished\n");
       }
        System.out.println("***** Turn Changed *****");
        this.changeTurn();

    }

    @Override
    public void stop(){

        //Stops Game Execution
        super.getMusicPlayer().stop();
        super.getGameLoop().stop();

        //Build Mini Game
        super.getSceneDirector().buildTicTacToe();
    }


}
