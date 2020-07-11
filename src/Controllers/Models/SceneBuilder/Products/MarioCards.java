package Controllers.Models.SceneBuilder.Products;

import Controllers.Models.Player;

import Controllers.Models.SceneBuilder.GameScene;
import Controllers.Models.SceneBuilder.SceneType;
import Controllers.Models.SpriteFactory.Products.Button;
import Controllers.Models.SpriteFactory.Products.Node;
import Controllers.Models.SpriteFactory.Products.NodeType;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Collections;

public class MarioCards extends GameScene {
    private int players;/// ESTO HAY QUE CAMBIARLO
    private int turns;
    private ArrayList<Integer> deck;
    private ArrayList<Button> buttonsList;
    private Button[] cardsMoved;

    public MarioCards(){
        super(SceneType.CARDS);
    }
    @Override
    public void initGameComponents() {
        players=super.getSceneDirector().getPlayerList().size();
        System.out.println("NUMBER OF PLAYERS:" + players);
        this.turns = players;
        this.deck = new ArrayList<Integer>();
        this.buttonsList = new ArrayList<Button>();
        this.cardsMoved = new Button[players];

        shuffleCards();

        int cont = 0;
        for(int row = 0; row<4;row++){
            for(int column = 0; column<13;column++){
                Button memoryButton =new Button(43*column+75,67*row+150);
                memoryButton.resizeImage(40,65);
                memoryButton.setType(NodeType.STANDARTCARD);///CAMBIAR ENUM
                memoryButton.setValue(this.deck.get(cont));
                memoryButton.setPressed(false);

                this.buttonsList.add(memoryButton);
                //super.getButtonsList().add(memoryButton);
                super.getGameComponents().add(memoryButton);
                cont++;
            }
        }
        printBoard();

    }

    @Override
    public void handleMouseEvents(){

        super.getSceneController().getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                for(int element = 0; element< buttonsList.size(); element++){

                    Button tempCardButton = buttonsList.get(element);

                    if(tempCardButton.getPositionX()<=mouseEvent.getX() & mouseEvent.getX()<= tempCardButton.getPositionX()+ tempCardButton.getWidth()) {
                        if (tempCardButton.getPositionY() < mouseEvent.getY() & mouseEvent.getY() < tempCardButton.getPositionY() + tempCardButton.getHeight()) {
                            if(tempCardButton.getPressed() == false){
                                if(turns>0){
                                    cardsMoved[turns-1] = tempCardButton;
                                    setButtonState(tempCardButton);
                                    turns--;
                                }else{
                                    printPlayersMovements();
                                    System.out.println("The higher is : "+ getHigherNumber());
                                    System.out.println("-----TERMINO EL JUEGO-----");
                                    if(checkWinner()==true){
                                        System.out.println("YOU WIN!!!");
                                        MarioCards.super.showDialog("Player Wins!!");
                                        int playerTurn=(int)MarioCards.super.getSceneDirector().getGameLog().get("PlayerTurn");
                                        MarioCards.super.getSceneDirector().getPlayerList().get(playerTurn).setCurrentNodeState(1);
                                        stop();
                                    }else{
                                        System.out.println("YOU LOSE!!!");
                                        MarioCards.super.showDialog("Player Lose!!");
                                        int playerTurn=(int)MarioCards.super.getSceneDirector().getGameLog().get("PlayerTurn");
                                        MarioCards.super.getSceneDirector().getPlayerList().get(playerTurn).setCurrentNodeState(-1);
                                        stop();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    @Override
    public void update(){
        for(int element=0;element<super.getGameComponents().size();element++){
            super.getGameComponents().get(element).update(super.getSceneController().getDrawer());
        }

        drawTitle();
        drawPlayersTurn();
        if(turns==0){
            drawTitleWinnerState(checkWinner());
        }
    }

    public int convertNumbers(Button card) {
        //System.out.println("STATE CARD:" + card.getValue());
        if (card.getValue() < 20) {
            return card.getValue();
        } else if (card.getValue() < 200) {
            return card.getValue() / 10;
        } else if (card.getValue() < 2000) {
            return card.getValue() / 100;
        } else if (card.getValue() < 20000) {
            return card.getValue() / 1000;
        } else {
            System.out.println("ESTADO INVALIDO");
            return 0;
        }
    }

    private boolean checkWinner(){

        if(cardsMoved[0].getValue()==getHigherNumber()){
            return true;
        }else{
            return false;
        }
    }

    private int getHigherNumber(){
        int max = players;
        Button num;
        Button higher = cardsMoved[0];
        for(int cont = 0;cont < max;cont++ ){
            num = cardsMoved[cont];
            if(cont==0){
                higher=num;
            }
            if (convertNumbers(num) == convertNumbers(higher)){
                if(num.getValue()>higher.getValue()) {
                    higher=num;
                }
            }
            if(convertNumbers(num)>convertNumbers(higher)) {
                higher=num;
            }
        }
        //System.out.println("The higher is : "+higher.getValue());
        return higher.getValue();
    }

    private void shuffleCards () {
        int cont = 1;
        for(int deckCont = 0;deckCont < 4;deckCont++){
            for(int card = 2 ;card<15;card++){
                this.deck.add(card*cont);
                System.out.println("Card Value: "+card*cont);
            }
            cont = cont * 10;
        }
        Collections.shuffle(this.deck);
    }


    private void printBoard(){
        String tabla = "";
        for (int i=0; i<52 ; i++) {
            if(i==13 || i==26 || i==39 || i == 52){
                tabla = tabla + "\n";
            }
            tabla = tabla + "| " +this.buttonsList.get(i).getValue();
        }
        System.out.println("-------TABLA-------");
        System.out.println(tabla);
    }

    private void printPlayersMovements(){
        System.out.println("-------PlayersMovements-------");
        /*for (int i=0; i<cardsMoved.length ; i++) {
            System.out.println("Player "+(i+1)+" : "+cardsMoved[i].getValue());
        }*/
        for (int i=cardsMoved.length; i>0 ; i--) {
            System.out.println("Player "+(i)+" : "+cardsMoved[i-1].getValue());
        }

    }

    public void setButtonState(Button node){
        System.out.println("STATE:"+ node.getValue());
        if (node.getValue() < 20){
            if(node.getPressed() == false){
                node.setType(getDiamondType(node.getValue()));
                node.setPressed(true);
            }
        }else if (node.getValue() < 200){
            if(node.getPressed() == false) {
                System.out.println("VALUE Spade CONVERTED : "+node.getValue()/10);
                node.setType(getSpadeType(node.getValue()/10));
                node.setPressed(true);
            }
        }else if (node.getValue() < 2000){
            if(node.getPressed() == false){
                System.out.println("VALUE Club CONVERTED: "+node.getValue()/100);
                node.setType(getClubType(node.getValue()/100));
                node.setPressed(true);
            }
        }else if (node.getValue() < 20000){
            if(node.getPressed() == false){
                System.out.println("VALUE Heart CONVERTED: "+node.getValue()/1000);
                node.setType(getHeartType(node.getValue()/1000));
                node.setPressed(true);
            }
        }else{
            System.out.println("ESTADO INVALIDO");
        }





    }


    private NodeType getHeartType(int cardValue){
        switch (cardValue) {
            case 2:
                return NodeType.HEARTS2;
            case 3:
                return NodeType.HEARTS3;
            case 4:
                return NodeType.HEARTS4;
            case 5:
                return NodeType.HEARTS5;
            case 6:
                return NodeType.HEARTS6;
            case 7:
                return NodeType.HEARTS7;
            case 8:
                return NodeType.HEARTS8;
            case 9:
                return NodeType.HEARTS9;
            case 10:
                return NodeType.HEARTS10;
            case 11:
                return NodeType.HEARTSJ;
            case 12:
                return NodeType.HEARTSQ;
            case 13:
                return NodeType.HEARTSK;
            case 14:
                return NodeType.HEARTSAS;
            default:
                return NodeType.MEMORYCARD;
        }
    }
    private NodeType getClubType(int cardValue){
        switch (cardValue) {
            case 2:
                return NodeType.CLUB2;
            case 3:
                return NodeType.CLUB3;
            case 4:
                return NodeType.CLUB4;
            case 5:
                return NodeType.CLUB5;
            case 6:
                return NodeType.CLUB6;
            case 7:
                return NodeType.CLUB7;
            case 8:
                return NodeType.CLUB8;
            case 9:
                return NodeType.CLUB9;
            case 10:
                return NodeType.CLUB10;
            case 11:
                return NodeType.CLUBJ;
            case 12:
                return NodeType.CLUBQ;
            case 13:
                return NodeType.CLUBK;
            case 14:
                return NodeType.CLUBAS;
            default:
                return NodeType.MEMORYCARD;
        }
    }

    private NodeType getSpadeType(int Character){
        switch (Character) {
            case 2:
                return NodeType.SPADES2;
            case 3:
                return NodeType.SPADES3;
            case 4:
                return NodeType.SPADES4;
            case 5:
                return NodeType.SPADES5;
            case 6:
                return NodeType.SPADES6;
            case 7:
                return NodeType.SPADES7;
            case 8:
                return NodeType.SPADES8;
            case 9:
                return NodeType.SPADES9;
            case 10:
                return NodeType.SPADES10;
            case 11:
                return NodeType.SPADESJ;
            case 12:
                return NodeType.SPADESQ;
            case 13:
                return NodeType.SPADESK;
            case 14:
                return NodeType.SPADESAS;
            default:
                return NodeType.MEMORYCARD;
        }
    }

    private NodeType getDiamondType(int cardValue){
        switch (cardValue) {
            case 2:
                return NodeType.DIAMOND2;
            case 3:
                return NodeType.DIAMOND3;
            case 4:
                return NodeType.DIAMOND4;
            case 5:
                return NodeType.DIAMOND5;
            case 6:
                return NodeType.DIAMOND6;
            case 7:
                return NodeType.DIAMOND7;
            case 8:
                return NodeType.DIAMOND8;
            case 9:
                return NodeType.DIAMOND9;
            case 10:
                return NodeType.DIAMOND10;
            case 11:
                return NodeType.DIAMONDJ;
            case 12:
                return NodeType.DIAMONDQ;
            case 13:
                return NodeType.DIAMONDK;
            case 14:
                return NodeType.DIAMONDAS;
            default:
                return NodeType.MEMORYCARD;
        }
    }

    public void drawTitle(){
        // ---- TITLE TIC TAC TOE ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 50));
        super.getSceneController().getDrawer().setFill(Color.WHITE);
        super.getSceneController().getDrawer().fillText("MARIO CARDS",170,60,500);
        //drawMario();
    }

    public void drawPlayersTurn(){
        //---------PLAYER 1---------------------------------------------------------------------
        //----- CREATE COUNTER POINTS BOARD-----
        super.getSceneController().getDrawer().setFill(Color.BLUE);
        // this.sceneController.getDrawer().fillRect(550,40,80,60);
        super.getSceneController().getDrawer().fillRoundRect(10, 15, 100, 50, 10, 10);

        // ---- TITLE PLAYER ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 20));
        super.getSceneController().getDrawer().setFill(Color.WHITE);
        super.getSceneController().getDrawer().fillText("Player",25,35,100);

        // ---- TURN ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 20));
        super.getSceneController().getDrawer().fillText(turns+"",45,55,100);
        //---------------------------------------------------------------------------------------

    }

    public void drawTitleWinnerState(boolean state){
        // ---- TITLE MEMORY PATH ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 65));
        super.getSceneController().getDrawer().setFill(Color.WHITE);
        if(state){
            super.getSceneController().getDrawer().fillText("YOU WIN !!!",170,150,500);
        }else{
            super.getSceneController().getDrawer().fillText("YOU LOSE !!!",170,150,500);
        }


    }

    @Override
    public void stop(){

        //Stops Mini Game Execution
        super.getMusicPlayer().stop();
        super.getGameLoop().stop();

        //Reload Main Game
        super.getSceneDirector().buildMainGame();
        //super.getSceneDirector().getMainGame().getGameLoop().start();
    }


}
