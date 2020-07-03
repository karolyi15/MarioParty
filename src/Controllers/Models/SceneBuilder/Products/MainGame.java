package Controllers.Models.SceneBuilder.Products;

import Controllers.Models.Dice;
import Controllers.Models.Player;
import Controllers.Models.SceneBuilder.GameScene;
import Controllers.Models.SceneBuilder.SceneType;
import Controllers.Models.SpriteFactory.Products.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import org.json.simple.JSONObject;


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
    private Button portrait;
    private Button diceButton;
    private Button textArea;


    //Scene Transition System
    SceneType nextMiniGame;
    ArrayList<NodeType> minigames;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //Constructors
    public MainGame(){
        super(SceneType.BOARD);
    }



    //Game Loop
    @Override
    public void initGameComponents(){

        //Init Camara System
        this.camara= new double[2];

        //Init Game Components
        this.dice=new Dice();

        //Set Up Game State
        this.loadGameState();

        //UI Elements
        this.initUI_Elements();

        //**********************************Review
        this.updatePathPosition();
        this.updatePlayerPosition();

    }

    private void sortPlayers(){

        //Get player List Length

        int listLength=super.getPlayerList().size();

        //Get Random Positions
        ArrayList<Integer> sortedList=new ArrayList<>();

        for(int player=0;player<listLength;player++) {
            int diceResult = dice.throwDice() + dice.throwDice();
            sortedList.add(diceResult);
        }
        System.out.println("Array Inicial");
        this.printArrayList(sortedList);

        //Sorting Player List
        for(int i=0;i<super.getPlayerList().size()-1;i++){
            for(int j=0;j<listLength-i-1;j++){
                if(sortedList.get(j)>sortedList.get(j+1)){

                    int temNumber=sortedList.get(j);
                    Player tempPayer=super.getPlayerList().get(j);

                    sortedList.set(j,sortedList.get(j+1));
                    super.getPlayerList().set(j,super.getPlayerList().get(j+1));

                    sortedList.set(j+1,temNumber);
                    super.getPlayerList().set(j+1,tempPayer);
                }
            }
        }

        System.out.println("Array Ordenado");
        this.printArrayList(sortedList);
    }

    //Sorting Test
    private void printArrayList(ArrayList<Integer> array){
        for(int element=0;element<array.size();element++){
            System.out.print(array.get(element)+" ");
        }
    }

    //Camara System
    private  void restartCamara(){
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


    private void initUI_Elements(){
        //Init UI Components
        this.diceButton=new Button(540,435);
        diceButton.setText("Throw Dice");
        diceButton.setId("Dice Button");
        diceButton.resizeImage(150,50);
        super.getButtonsList().add(diceButton);
        super.getGameComponents().add(diceButton);

        this.textArea=new Button(390,10);
        textArea.setText("Player #");
        textArea.setId("Text Area");
        textArea.setType(NodeType.TEXTAREA);
        textArea.resizeImage(300,75);
        super.getGameComponents().add(textArea);

        this.portrait=new Button(NodeType.UNKNOWNPORTRAIT,400,20);
        portrait.resizeImage(54,58);
        super.getGameComponents().add(portrait);
    }

    //Render System

    public void buildPath(){

        //Real Path
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

        ///Relative Path

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

    }


    //Game Logic
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
                       super.getGameLoop().stop();
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

    private void changeTurn(){

        this.playerTurn+=1;
        if(this.playerTurn>=super.getPlayerList().size()){
            this.playerTurn=0;
        }
        this.setCamaraOn(super.getPlayerList().get(this.playerTurn));
        //this.updatePathPosition();
        this.displayPlayerPortrait(super.getPlayerList().get(this.playerTurn));

    }

    private void updatePlayerPosition(){

        for(int player=0;player<super.getPlayerList().size();player++){
            Player tempPlayer=super.getPlayerList().get(player);
            tempPlayer.getCharacter().setPosition(this.relativeBoard.get(tempPlayer.getCurrentNode()).getPositionX(),this.relativeBoard.get(tempPlayer.getCurrentNode()).getPositionY());
            super.getGameComponents().add(tempPlayer.getCharacter());
        }
    }

    private void updatePathPosition(){
        System.out.println("***************Path Position Update*****************\n");
        for(int node = 0; node<this.realBoard.size(); node++){

            Node realNode=this.realBoard.get(node);
            Node relativeNode=this.relativeBoard.get(node);

            relativeNode.setPosition(realNode.getPositionX()-super.getBackground().getPositionX(),realNode.getPositionY()-super.getBackground().getPositionY());
            //System.out.println("node "+node+" posx: "+relativeNode.getPositionX()+" posy: "+relativeNode.getPositionY()+"\n");
        }
    }


    private void displayPlayerPortrait(Player player){

        this.textArea.setText("Player "+(this.playerTurn+1));
        this.portrait.setType(player.getPlayerID());
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
                        if(tempButton.getPositionY()<mouseEvent.getY() & mouseEvent.getY()<tempButton.getPositionY()+tempButton.getHeight()) {

                            throwDice(MainGame.super.getPlayerList().get(playerTurn));
                            //updateCamara(MainGame.super.getPlayerList().get(playerTurn));

                            //stop();
                        }
                    }
                }
            }
        });
    }


    private void saveGameState(){
        JSONObject gameLog=super.getSceneDirector().getGameLog();
        gameLog.put("Restart",false);
        gameLog.put("PlayerTurn",this.playerTurn);
        gameLog.put("RealPath",this.realBoard);
        //gameLog.put("RelativePath", this.relativeBoard);
    }

    private void loadGameState(){
        JSONObject gameLog=super.getSceneDirector().getGameLog();
        Boolean restart=(Boolean) gameLog.get("Restart");

        if(restart){
            this.playerTurn=0;
            this.realBoard=new ArrayList<>();
            this.relativeBoard=new ArrayList<>();
            this.sortPlayers();
            this.buildPath();

        }else{
            this.playerTurn=(int)gameLog.get("PlayerTurn");
            this.realBoard=(ArrayList<Node>)gameLog.get("RealPath");
            this.relativeBoard=(ArrayList<Node>)gameLog.get("RealPath");
        }

    }


    @Override
    public void stop(){

        //Stops Game Execution
        super.getMusicPlayer().stop();
        super.getGameLoop().stop();
        this.saveGameState();

        //Build Mini Game
        super.getSceneDirector().buildTicTacToe();
    }




}
