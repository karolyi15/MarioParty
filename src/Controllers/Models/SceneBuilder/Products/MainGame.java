package Controllers.Models.SceneBuilder.Products;

import Controllers.Main;
import Controllers.Models.Dice;
import Controllers.Models.Player;
import Controllers.Models.SceneBuilder.GameScene;
import Controllers.Models.SceneBuilder.SceneType;
import Controllers.Models.SpriteFactory.Products.*;
import Controllers.Views.Tail_Controller;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.json.simple.JSONObject;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MainGame extends GameScene {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private ArrayList<Button> realBoard;
    private ArrayList<Button> relativeBoard;

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
    NodeType playingNode;

    //Random
    Random random;




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

        this.random=new Random();

        //**********************************Review
        //this.updatePathPosition();
        //this.updatePlayerPosition();
        this.setCamaraOn(super.getPlayerList().get(this.playerTurn));

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
        System.out.println("\nArray Inicial");
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

        //Restart Camara Values To Calculate New Node Position
        this.restartCamara();
        super.getBackground().setPosition(this.realBoard.get(player.getCurrentNode()).getPositionX()-super.getBackground().getPositionX(),super.getBackground().getPositionY());

        //Update Camara Values
        //this.camara[0]=super.getBackground().getPositionX();
        //this.camara[1]=super.getBackground().getPositionY();

        //Update Game Elements Position
        this.updatePathPosition();
        this.updatePlayerPosition();

        this.displayPlayerPortrait(player);

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
        this.realBoard.add(new Button(503,1626));
        this.realBoard.add(new Button(576,1626));
        this.realBoard.add(new Button(576,1684));

        this.realBoard.add(new Button(576,1740));
        this.realBoard.add(new Button(633,1740));
        this.realBoard.add(new Button(691,1740));
        this.realBoard.add(new Button(748,1740));
        this.realBoard.add(new Button(806,1740));
        this.realBoard.add(new Button(863,1740));
        this.realBoard.add(new Button(922,1740));
        this.realBoard.add(new Button(979,1740));

        this.realBoard.add(new Button(979,1681));
        this.realBoard.add(new Button(1041,1681));
        this.realBoard.add(new Button(1097,1681));

        this.realBoard.add(new Button(1097,1741));
        this.realBoard.add(new Button(1150,1741));

        this.realBoard.add(new Button(1150,1796));
        this.realBoard.add(new Button(1208,1799));
        this.realBoard.add(new Button(1267,1800));
        this.realBoard.add(new Button(1325,1798));
        this.realBoard.add(new Button(1383,1798));
        this.realBoard.add(new Button(1439,1798));
        this.realBoard.add(new Button(1497,1798));

        this.realBoard.add(new Button(1497,1739));
        this.realBoard.add(new Button(1553,1739));
        this.realBoard.add(new Button(1612,1739));
        this.realBoard.add(new Button(1671,1739));

        ///Relative Path

        this.relativeBoard.add(new Button(503,1626));
        this.relativeBoard.add(new Button(576,1626));
        this.relativeBoard.add(new Button(576,1684));

        this.relativeBoard.add(new Button(576,1740));
        this.relativeBoard.add(new Button(633,1740));
        this.relativeBoard.add(new Button(691,1740));
        this.relativeBoard.add(new Button(748,1740));
        this.relativeBoard.add(new Button(806,1740));
        this.relativeBoard.add(new Button(863,1740));
        this.relativeBoard.add(new Button(922,1740));
        this.relativeBoard.add(new Button(979,1740));

        this.relativeBoard.add(new Button(979,1681));
        this.relativeBoard.add(new Button(1041,1681));
        this.relativeBoard.add(new Button(1097,1681));

        this.relativeBoard.add(new Button(1097,1741));
        this.relativeBoard.add(new Button(1150,1741));

        this.relativeBoard.add(new Button(1150,1796));
        this.relativeBoard.add(new Button(1208,1799));
        this.relativeBoard.add(new Button(1267,1800));
        this.relativeBoard.add(new Button(1325,1798));
        this.relativeBoard.add(new Button(1383,1798));
        this.relativeBoard.add(new Button(1439,1798));
        this.relativeBoard.add(new Button(1497,1798));

        this.relativeBoard.add(new Button(1497,1739));
        this.relativeBoard.add(new Button(1553,1739));
        this.relativeBoard.add(new Button(1612,1739));
        this.relativeBoard.add(new Button(1671,1739));

        //Assign Node Type
        this.assignNodeType();
    }

    private void assignNodeType(){
        //Create NodeType List
        ArrayList<NodeType> typeList=new ArrayList<>();
        typeList.add(NodeType.TAIL);
        typeList.add(NodeType.STAR);
        typeList.add(NodeType.PRISON);
        typeList.add(NodeType.TUBERED);
        typeList.add(NodeType.TUBEBLUE);
        typeList.add(NodeType.TUBEYELLOW);
        typeList.add(NodeType.FIRE);
        typeList.add(NodeType.ICE);

        typeList.add(NodeType.SOUPICON);
        typeList.add(NodeType.SOUPICON);

        typeList.add(NodeType.CARDSICON);
        typeList.add(NodeType.CARDSICON);

        typeList.add(NodeType.GUESSICON);
        typeList.add(NodeType.GUESSICON);

        typeList.add(NodeType.MEMORYICON);
        typeList.add(NodeType.MEMORYICON);

        typeList.add(NodeType.MEMORYPATHICON);
        typeList.add(NodeType.MEMORYPATHICON);

        typeList.add(NodeType.CATCHBOOICON);
        typeList.add(NodeType.CATCHBOOICON);

        typeList.add(NodeType.BOMBERICON);
        typeList.add(NodeType.BOMBERICON);

        typeList.add(NodeType.TICTACTOEICON);
        typeList.add(NodeType.TICTACTOEICON);

        typeList.add(NodeType.COINSICON);
        typeList.add(NodeType.COINSICON);

        Random random=new Random();

        for(int node=1;node<this.realBoard.size();node++){
            int randomPosition=random.nextInt(typeList.size());
            //int randomPosition=random.nextInt(typeList.size()-1)+1;//***********
            //System.out.println("Random Position"+randomPosition);
            Button tempRealNode=this.realBoard.get(node);
            tempRealNode.setType(typeList.get(randomPosition));
            tempRealNode.resizeImage(10,10);
            Button tempRelativeNode=this.relativeBoard.get(node);
            tempRelativeNode.setType(typeList.get(randomPosition));
            tempRelativeNode.resizeImage(30,30);

            typeList.remove(randomPosition);
            super.getGameComponents().add(tempRelativeNode);
        }
    }


    //Game Logic
    private void throwDice(Player player){

        String dialogContent="";
        //System.out.println("Playing Player "+(this.playerTurn+1));
        //System.out.println("Actual x: "+player.getCharacter().getPositionX()+" Actual y: "+player.getCharacter().getPositionY());

        //Case: PLayer not Punished
        if(player.getPunished()==0) {

            if(player.isCurrentNodeState()==-1) {
                super.delay(1000);
                this.executeGame(this.realBoard.get(player.getCurrentNode()).getType());

            }else {
                for (int dice = 0; dice < 2; dice++) {

                    int diceValue = this.dice.throwDice();

                    dialogContent += "Dice " + (dice + 1) + ":" + diceValue + "\n";

                    //System.out.println("Dice " + dice + " :" + diceValue);
                    if (diceValue == 0) {

                        player.setPunished(player.getPunished() + 1);

                    } else {

                        int actualNode = player.getCurrentNode();

                        if (actualNode + diceValue > 26) {

                            player.setCurrentNode(26 - (actualNode + diceValue - 26));

                        } else if (actualNode + diceValue == 26) {

                            System.out.println("Player " + playerTurn + 1 + "Wins!!");
                            player.setCurrentNode(player.getCurrentNode() + diceValue);
                            player.getCharacter().setPosition(this.relativeBoard.get(player.getCurrentNode()).getPositionX(), this.relativeBoard.get(player.getCurrentNode()).getPositionY());

                            super.showDialog("Player " + (this.playerTurn + 1) + " Wins");
                            //this.stop();
                            super.getSceneDirector().getPrimaryStage().close();

                        } else {
                            player.setCurrentNode(player.getCurrentNode() + diceValue);
                        }
                        //System.out.println("Player current node: " + player.getCurrentNode());
                        //this.updatePathPosition();
                        //this.setCamaraOn(player.getCharacter());
                        player.getCharacter().setPosition(this.relativeBoard.get(player.getCurrentNode()).getPositionX(), this.relativeBoard.get(player.getCurrentNode()).getPositionY());
                        this.setCamaraOn(player);
                        //System.out.println("New x: " + player.getCharacter().getPositionX() + " New y: " + player.getCharacter().getPositionY());
                    }
                }
                super.showDialog(dialogContent);
                System.out.println("moved");
                //this.executeGame(this.realBoard.get(player.getCurrentNode()).getType());

            }

            if(player.isCurrentNodeState()==-1){
                delay(2000);
                this.changeTurn();
            }

            //If Player Won Mini Game Gets Another Turn
            /*if(player.isCurrentNodeState()==1 & player.getPunished()==0){
                delay(2000);
                this.throwDice(super.getPlayerList().get(this.playerTurn));
            }else {
                delay(2000);
                this.changeTurn();
            }*/

           }
        //Case: Player is Punished
        else{
            System.out.println("Players Punished Cant Move\n");
            player.setPunished(player.getPunished()-1);
            System.out.println("***** Turn Changed *****");
            super.delay(2000);
            this.changeTurn();
       }





    }



    private void executeGame(NodeType nodeType){

        switch (nodeType){
            //MiniGames Options
            case SOUPICON:
                this.stop();
                //super.getSceneDirector().buildTicTacToe();
                super.getSceneDirector().buildMarioSoup();
                break;
            case CARDSICON:
                this.stop();
                super.getSceneDirector().buildMarioCards();
                break;
            case GUESSICON:
                this.stop();
                super.getSceneDirector().buildGuessWho();
                break;
            case MEMORYICON:
                this.stop();
                super.getSceneDirector().buildMemory();
                break;
            case MEMORYPATHICON:
                this.stop();
                super.getSceneDirector().buildMemoryPath();
                break;
            case CATCHBOOICON:
                this.stop();
                super.getSceneDirector().buildCatchBoo();
                break;
            case BOMBERICON:
                this.stop();
                super.getSceneDirector().buildBomberMario();
                break;
            case TICTACTOEICON:
                this.stop();
                super.getSceneDirector().buildTicTacToe();
                break;
            case COINSICON:
                this.stop();
                //super.getSceneDirector().buildTicTacToe();
                super.getSceneDirector().buildCollectTheCoins();
                break;
             //Other Node Options
            case PRISON:
                this.executePrison();
                break;
            case STAR:
                this.throwDice(super.getPlayerList().get(this.playerTurn));
                break;
            case FIRE:
                System.out.println("Flor de fuego");
                this.executeFire();
                break;
            case ICE:
                System.out.println("Flor de Hielo");
                this.executeIce();
                break;
            case TAIL:
                System.out.println("Colita");
                this.executeTail();
                break;
            case TUBERED:
                System.out.println("entré en un tubo");
                this.executeRedTube();
                break;
            case TUBEBLUE:
                System.out.println("entré en un tubo");
                this.executeBlueTube();
                break;
            case TUBEYELLOW:
                System.out.println("entré en un tubo");
                this.executeYellowTube();
                break;



        }

    }

    private void executeBlueTube(){
        for(int node=0;node<this.relativeBoard.size();node++){
            if(this.relativeBoard.get(node).getType()==NodeType.TUBEYELLOW){
                super.getPlayerList().get(this.playerTurn).setCurrentNode(node);
            }
        }
        Player tempPlayer=super.getPlayerList().get(this.playerTurn);
        tempPlayer.setCurrentNodeState(0);
        tempPlayer.getCharacter().setPosition(this.relativeBoard.get(tempPlayer.getCurrentNode()).getPositionX(), this.relativeBoard.get(tempPlayer.getCurrentNode()).getPositionY());
        this.setCamaraOn(tempPlayer);
    }

    private void executeYellowTube(){
        for(int node=0;node<this.relativeBoard.size();node++){
            if(this.relativeBoard.get(node).getType()==NodeType.TUBERED){
                super.getPlayerList().get(this.playerTurn).setCurrentNode(node);
            }
        }
        Player tempPlayer=super.getPlayerList().get(this.playerTurn);
        tempPlayer.setCurrentNodeState(0);
        tempPlayer.getCharacter().setPosition(this.relativeBoard.get(tempPlayer.getCurrentNode()).getPositionX(), this.relativeBoard.get(tempPlayer.getCurrentNode()).getPositionY());
        this.setCamaraOn(tempPlayer);
    }

    private void executeRedTube(){
        for(int node=0;node<this.relativeBoard.size();node++){
            if(this.relativeBoard.get(node).getType()==NodeType.TUBEBLUE){
                super.getPlayerList().get(this.playerTurn).setCurrentNode(node);
            }
        }
        Player tempPlayer=super.getPlayerList().get(this.playerTurn);
        tempPlayer.setCurrentNodeState(0);
        tempPlayer.getCharacter().setPosition(this.relativeBoard.get(tempPlayer.getCurrentNode()).getPositionX(), this.relativeBoard.get(tempPlayer.getCurrentNode()).getPositionY());
        this.setCamaraOn(tempPlayer);
    }

    private void executePrison(){
        Player activePlayer=super.getPlayerList().get(this.playerTurn);
        activePlayer.setPunished(activePlayer.getPunished()+2);
        super.getPlayerList().get(this.playerTurn).setCurrentNodeState(0);
    }

    private void executeIce(){
        int punishedPlayer=0;
        while(punishedPlayer==0){
            int randomPlayer=random.nextInt(super.getPlayerList().size());
            if(randomPlayer!=this.playerTurn){
                Player tempPlayer=super.getPlayerList().get(randomPlayer);
                tempPlayer.setPunished(tempPlayer.getPunished()+2);
                punishedPlayer+=1;
            }
        }
        super.getPlayerList().get(this.playerTurn).setCurrentNodeState(0);
    }

    private void executeFire(){
        int punishedPlayer=0;
        while(punishedPlayer==0){
            int randomPlayer=random.nextInt(super.getPlayerList().size());
            if(randomPlayer!=this.playerTurn){
                Player tempPlayer=super.getPlayerList().get(randomPlayer);
                tempPlayer.setCurrentNode(0);
                tempPlayer.getCharacter().setPosition(this.relativeBoard.get(tempPlayer.getCurrentNode()).getPositionX(), this.relativeBoard.get(tempPlayer.getCurrentNode()).getPositionY());
                punishedPlayer+=1;
            }
        }
        super.getPlayerList().get(this.playerTurn).setCurrentNodeState(0);
    }

    private void executeTail(){

        try{
            //Load Fxml File
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(Main.class.getResource("Views/Tail_UI.fxml"));
            AnchorPane dialog=(AnchorPane) loader.load();

            //Create Dialog Stage
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Tail Field");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(super.getSceneDirector().getPrimaryStage());

            Scene dialogScene=new Scene(dialog);
            dialogStage.setScene(dialogScene);

            //Set Controller
            Tail_Controller controller=loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPlayer(super.getPlayerList().get(this.playerTurn));

            //Wait Until Dialog Close
            dialogStage.showAndWait();
            Player tempPlayer=super.getPlayerList().get(this.playerTurn);
            tempPlayer.setCurrentNodeState(0);
            tempPlayer.getCharacter().setPosition(this.relativeBoard.get(tempPlayer.getCurrentNode()).getPositionX(), this.relativeBoard.get(tempPlayer.getCurrentNode()).getPositionY());
            this.setCamaraOn(tempPlayer);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void changeTurn(){

        this.playerTurn+=1;
        if(this.playerTurn>=super.getPlayerList().size()){
            this.playerTurn=0;
        }
        this.setCamaraOn(super.getPlayerList().get(this.playerTurn));
        //this.updatePathPosition();
        //this.displayPlayerPortrait(super.getPlayerList().get(this.playerTurn));

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

            Button realNode=this.realBoard.get(node);
            Button relativeNode=this.relativeBoard.get(node);

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
        gameLog.put("RelativePath", this.relativeBoard);
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
            this.realBoard=(ArrayList<Button>)gameLog.get("RealPath");
            this.relativeBoard=(ArrayList<Button>)gameLog.get("RelativePath");

            this.loadNodeImg();
        }

    }

    private void loadNodeImg(){
        for(int node=1;node<this.relativeBoard.size();node++){
            Button tempNode=this.relativeBoard.get(node);
            super.getGameComponents().add(tempNode);
        }
    }


    @Override
    public void stop(){

        //Stops Game Execution
        super.getMusicPlayer().stop();
        super.getGameLoop().stop();
        this.saveGameState();

        //Build Mini Game
        //super.getSceneDirector().buildTicTacToe();
    }

    private void finish(){
        //Stops Game Execution
        super.getMusicPlayer().stop();
        super.getGameLoop().stop();

        super.getSceneDirector().buildTitleScene();

    }

    private void showPlayerLog(){
        try{

            //Load Fxml File
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(Main.class.getResource("Views/PlayerLog_UI.fxml"));
            AnchorPane playerDialog=(AnchorPane) loader.load();

            //Create Dialog Stage
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Player Log");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(super.getSceneDirector().getPrimaryStage());

            Scene dialogScene=new Scene(playerDialog);
            dialogStage.setScene(dialogScene);

            //Set Controller
            Tail_Controller controller=loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPlayer(super.getPlayerList().get(this.playerTurn));

            //Wait Until Dialog Close
            dialogStage.showAndWait();

        }catch (IOException e){
            e.printStackTrace();
        }
    }



}
