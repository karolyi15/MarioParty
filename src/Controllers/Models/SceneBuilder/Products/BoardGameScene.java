package Controllers.Models.SceneBuilder.Products;

import Controllers.Models.Dice;
import Controllers.Models.Player;
import Controllers.Models.SceneBuilder.MiniGame;
import Controllers.Models.SpriteFactory.Products.*;
import Controllers.Models.SpriteFactory.Products.Character;
import Controllers.Models.SpriteFactory.Sprite;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;


import java.util.ArrayList;

public class BoardGameScene extends MiniGame {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private ArrayList<Node> board;

    //Camara System
    private double[] camara;

    //Game Components
    private Dice dice;
    private int playerTurn;

    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//
    //Constructors
    public BoardGameScene(){

    }

    //Camara System

    public  void restartCamara(){
        this.camara[0]=350;
        this.camara[1]=1400;
        super.getMap().setPosition(camara[0],camara[1]);
    }


    public  void updateCamara(){

        /*if(tempPlayer.getCharacter().getPositionX()>=500) {

            super.getMap().setPosition(map.getPositionX()+100,map.getPositionY());
            tempPlayer.getCharacter().setPosition(tempPlayer.getCharacter().getPositionX()-100,tempPlayer.getCharacter().getPositionY());

        }*/


        //Update Path Position
        for(int node=0;node<this.board.size();node++){
            Node tempNode=this.board.get(node);
            tempNode.setPosition(tempNode.getPositionX()-super.getMap().getPositionX(),tempNode.getPositionY()-super.getMap().getPositionY());
        }

    }



    //Event Handling System
    @Override
    public void handleMouseEvents(){
        super.getSceneController().getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                for(int element = 0; element< BoardGameScene.super.getButtonsList().size(); element++){

                    Button tempButton= (Button)BoardGameScene.super.getButtonsList().get(element);

                    if(tempButton.getPositionX()<=mouseEvent.getX() & mouseEvent.getX()<=tempButton.getPositionX()+tempButton.getWidth()){
                        if(tempButton.getPositionY()<mouseEvent.getY() & mouseEvent.getY()<tempButton.getPositionY()+tempButton.getHeight())
                            throwDice(BoardGameScene.super.getPlayerList().get(playerTurn));

                    }
                }


            }
        });
    }


    //Render System

   public void buildPath(){

        //Main Path
        this.board.add(new Node(479,1592));
        this.board.add(new Node(552,1592));
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


    //Game Loop
    @Override
    public void initGameComponents(){

        //Init Game Components
        this.dice=new Dice();
        this.playerTurn=0;
        this.board=new ArrayList<>();
        this.buildPath();

        //Init Camara System
        this.camara= new double[2];
        restartCamara();

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
        Player player1=new Player((Character) super.getSpriteFactory().createCharacter(CharacterType.MARIO));
        Player player2=new Player((Character) super.getSpriteFactory().createCharacter(CharacterType.MARIO));

        super.getPlayerList().add(player1);
        super.getPlayerList().add(player2);

        super.getGameComponents().add(player1.getCharacter());
        super.getGameComponents().add(player2.getCharacter());

        this.updateCamara();
        this.playersInitPosition();

    }


    //Game Logic

    private void playersInitPosition(){
       for(int player=0;player<super.getPlayerList().size();player++){
           Player tempPlayer=super.getPlayerList().get(player);
           tempPlayer.getCharacter().setPosition(this.board.get(0).getPositionX(),this.board.get(0).getPositionY());
       }
    }

    private void changeTurn(){

        this.playerTurn+=1;
        if(this.playerTurn>=super.getPlayerList().size()){
            this.playerTurn=0;
        }

        this.displayPlayerInfo(super.getPlayerList().get(this.playerTurn));

    }

    private void displayPlayerInfo(Player player){
        System.out.println("Player info displayed");
    }

    private void throwDice(Player player){

        System.out.println("Playing Player "+(this.playerTurn+1));

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
               }
           }
       }else{
           player.setPunished(player.getPunished()-1);

       }
        System.out.println("Players Punished\n***** Turn Changed *****");
        this.changeTurn();

    }




}
