package Controllers.Models.SceneBuilder.Products;

import Controllers.Models.SceneBuilder.GameScene;

import Controllers.Models.SceneBuilder.SceneType;
import Controllers.Models.SpriteFactory.Products.Button;
import Controllers.Models.SpriteFactory.Products.Node;
import Controllers.Models.SpriteFactory.Products.NodeType;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Collections;

public class Memory extends GameScene {

    private int contMovements;
    private Button[] cardsMoved;
    private int turno;
    private int player1points;
    private int player2points;

    private ArrayList<Integer> deck;
    private ArrayList<Button> buttonsList;

    public Memory(){
        super(SceneType.MEMORY);
    }

    @Override
    public void initGameComponents(){
        this.contMovements=2;
        this.cardsMoved = new Button[3];
        this.turno=1;
        this.player1points = 0;
        this.player2points = 0;

        this.deck = new ArrayList<Integer>();
        this.buttonsList = new ArrayList<Button>();
        shuffleCards();

        int cont = 0;
        for(int row = 0; row<3;row++){
            for(int column = 0; column<6;column++){
                Button memoryButton =new Button(60*column+230,95*row+80);
                memoryButton.resizeImage(50,80);
                memoryButton.setType(NodeType.MEMORYCARD);///CAMBIAR ENUM
                memoryButton.setValue(this.deck.get(cont));
                memoryButton.setPressed(false);

                this.buttonsList.add(memoryButton);
                //super.getButtonsList().add(memoryButton);
                super.getGameComponents().add(memoryButton);
                cont++;
            }
        }
        printBoard();//PRUEBA IMPRESION

    }

    @Override
    public void handleMouseEvents(){

        super.getSceneController().getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                for(int element = 0; element< buttonsList.size(); element++){

                    Button tempMemoryButton = buttonsList.get(element);

                    if(tempMemoryButton.getPositionX()<=mouseEvent.getX() & mouseEvent.getX()<= tempMemoryButton.getPositionX()+ tempMemoryButton.getWidth()) {
                        if (tempMemoryButton.getPositionY() < mouseEvent.getY() & mouseEvent.getY() < tempMemoryButton.getPositionY() + tempMemoryButton.getHeight()){

                            if(contMovements==2 || contMovements==1){
                                if(tempMemoryButton.getPressed() == false) {
                                    cardsMoved[contMovements] = buttonsList.get(element);
                                }
                            }
                            if(contMovements == 0) {
                                if(checkPair()==true){
                                    //if(cardsMoved[1].getPressed() == false && cardsMoved[2].getPressed()){
                                    System.out.println("PAR CORRECTO:" + cardsMoved[1].getValue()+"/"+cardsMoved[2].getValue());
                                    incrementpoints();
                                    restartMovements();
                                    if(allPairsFound() == true){
                                        if(checkWinner() ==true){
                                            System.out.println("GANO EL PLAYER 1");
                                            Memory.super.showDialog("Player Wins!!");
                                            int playerTurn=(int)Memory.super.getSceneDirector().getGameLog().get("PlayerTurn");
                                            Memory.super.getSceneDirector().getPlayerList().get(playerTurn).setCurrentNodeState(1);

                                        }else{
                                            System.out.println("GANO EL PLAYER 2");
                                            Memory.super.showDialog("Player Lose!!");
                                            int playerTurn=(int)Memory.super.getSceneDirector().getGameLog().get("PlayerTurn");
                                            Memory.super.getSceneDirector().getPlayerList().get(playerTurn).setCurrentNodeState(-1);
                                        }
                                        stop();
                                    }
                                    //  }
                                    //restartMovements();
                                }else{
                                    System.out.println("PAR INCORRECTO:" + cardsMoved[1].getValue()+"/"+cardsMoved[2].getValue());
                                    restartMovements();
                                    flipCards();
                                    changeTurn();
                                }
                            }else{
                                setButtonState(buttonsList.get(element));
                                reduceMovements();
                            }
                            System.out.println("Movements:" + contMovements);
                        }
                    }
                }
                // System.out.println("TOTAL DE PUNTOS: " + counterPoints());
            }
        });
    }

    @Override
    public void update(){
        for(int element=0;element<super.getGameComponents().size();element++){
            super.getGameComponents().get(element).update(super.getSceneController().getDrawer());
        }

        drawCounterPoints();
        drawTitle();
        drawturn(this.turno);

    }

    private void incrementpoints(){
        if(this.turno == 1){
            this.player1points++;
            System.out.println("P1 : "+this.player1points);
        }else if(this.turno == -1){
            this.player2points++;
            System.out.println("P2 : "+this.player2points);
        }
    }

    private int changeTurn(){
        this.turno=this.turno*-1;
        System.out.println("-------------------");
        System.out.println("TURNO>> "+this.turno);
        return this.turno;
    }

    //private int reduceMovements(){ return this.contMovements--; };
    private void reduceMovements(){ this.contMovements--; };

    private void restartMovements(){
        //System.out.println("Restart movements: 2");
        this.contMovements =  2;
    };

    private void shuffleCards(){
        for(int i = 1 ; i<10 ; i++) {
            this.deck.add(i);
            this.deck.add(i);
        }
        Collections.shuffle(this.deck);
    }

    private boolean checkWinner(){
        if(player1points > player2points){
            return true;
        }else{
            return false;
        }
    }

    private boolean allPairsFound() {
        int totalPairs = player1points + player2points;
        if (totalPairs == 9) {
            return true;
        } else {
            return false;
        }
    }

    private void flipCards(){
        restartButtonState(cardsMoved[1]);
        restartButtonState(cardsMoved[2]);
    }

    private boolean checkPair(){
        if(cardsMoved[1].getValue() == cardsMoved[2].getValue()){
            disableCard(cardsMoved[1]);
            disableCard(cardsMoved[2]);
            return true;
        }else{
            return false;
        }
    }

    public void disableCard(Button card){
        card.setPressed(true);
    }

    public void restartButtonState(Button button){
        button.setType(NodeType.MEMORYCARD);
        button.setPressed(false);
    }

    private void printBoard(){
        String tabla = "";
        for (int i=0; i<18 ; i++) {
            if(i==6 || i==12 || i==18){
                tabla = tabla + "\n";
            }
            tabla = tabla + "| " +this.buttonsList.get(i).getValue();
        }
        System.out.println("-------TABLA-------");
        System.out.println(tabla);
    }

    public void setButtonState(Button node){
        System.out.println("STATE:"+ node.getValue());
        if (node.getValue() == 1){
            if(node.getPressed() == false){
                node.setType(NodeType.MEMORYCLOUDCARD);
                node.setPressed(true);
            }
        }else if (node.getValue() == 2){
            if(node.getPressed() == false) {
                node.setType(NodeType.MEMORYCOINCARD);
                node.setPressed(true);
            }
        }else if (node.getValue() == 3){
            if(node.getPressed() == false){
                node.setType(NodeType.MEMORYCOIN20CARD);
                node.setPressed(true);
            }
        }else if (node.getValue() == 4){
            if(node.getPressed() == false){
                node.setType(NodeType.MEMORYFLOWERCARD);
                node.setPressed(true);
            }
        }else if (node.getValue() == 5){
            if(node.getPressed() == false){
                node.setType(NodeType.MEMORYLUIGICARD);
                node.setPressed(true);
            }
        }else if (node.getValue() == 6){
            if(node.getPressed() == false){
                node.setType(NodeType.MEMORYMARIOCARD);
                node.setPressed(true);
            }
        }else if (node.getValue() == 7){
            if(node.getPressed() == false){
                node.setType(NodeType.MEMORYMUSHROOMCARD);
                node.setPressed(true);
            }
        }else if (node.getValue() == 8){
            if(node.getPressed() == false){
                node.setType(NodeType.MEMORYSTARCARD);
                node.setPressed(true);
            }
        }else if (node.getValue() == 9){
            if(node.getPressed() == false){
                node.setType(NodeType.MEMORYTRUNKCARD);
                node.setPressed(true);
            }
        }else{
            System.out.println("ESTADO INVALIDO");
        }
    }


    public void drawTitle(){
        // ---- TITLE TIC TAC TOE ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 30));
        super.getSceneController().getDrawer().setFill(Color.DARKRED);
        super.getSceneController().getDrawer().fillText("MEMORY",20,40,500);
    }

    public void drawCounterPoints(){
        //---------PLAYER 1---------------------------------------------------------------------
        //----- CREATE COUNTER POINTS BOARD-----
        super.getSceneController().getDrawer().setFill(Color.BLUE);
        // this.sceneController.getDrawer().fillRect(550,40,80,60);
        super.getSceneController().getDrawer().fillRoundRect(20, 60, 100, 50, 10, 10);

        // ---- TITLE COUNTER POINTS ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 20));
        super.getSceneController().getDrawer().setFill(Color.WHITE);
        super.getSceneController().getDrawer().fillText("Player 1",25,80,100);

        // ---- POINTS ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 15));
        super.getSceneController().getDrawer().fillText(player1points+" pairs ",50,100,100);
        //---------------------------------------------------------------------------------------
        //---------PLAYER 2---------------------------------------------------------------------
        //----- CREATE COUNTER POINTS BOARD-----
        super.getSceneController().getDrawer().setFill(Color.RED);
        // this.sceneController.getDrawer().fillRect(550,40,80,60);
        super.getSceneController().getDrawer().fillRoundRect(20, 120, 100, 50, 10, 10);

        // ---- TITLE COUNTER POINTS ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 20));
        super.getSceneController().getDrawer().setFill(Color.WHITE);
        super.getSceneController().getDrawer().fillText("Player 2",25,140,100);

        // ---- POINTS ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 15));
        super.getSceneController().getDrawer().fillText(player2points+" pairs ",50,160,100);
        //---------------------------------------------------------------------------------------
    }

    public void drawturn(int turn){
        /*double x = 400;
        double y = 150;
        double width = ;
        double height = ;*/
        String player = "";
        if(turn == 1){
            super.getSceneController().getDrawer().setFill(Color.BLUE);
            player = "PLAYER 1";
        }else if (turn == -1){
            super.getSceneController().getDrawer().setFill(Color.RED);
            player = "PLAYER 2";
        }
        super.getSceneController().getDrawer().fillRoundRect(310, 420, 200, 50, 10, 10);
        // ---- TITLE PLAYER ----
        super.getSceneController().getDrawer().setFont(new Font("Verdana Bold", 30));
        super.getSceneController().getDrawer().setFill(Color.WHITE);
        super.getSceneController().getDrawer().fillText(player,330,455);
    }

    @Override
    public void stop(){

        //Stops Mini Game Execution
        super.getMusicPlayer().stop();
        super.getGameLoop().stop();

        super.getSceneController().getDrawer().setFont(new Font(" Backward", 12));
        super.getSceneController().getDrawer().setFill(Color.BLACK);

        //Reload Main Game
        super.getSceneDirector().buildMainGame();
        //super.getSceneDirector().getMainGame().getGameLoop().start();
    }


}
