package Controllers.Models.SceneBuilder.Products;

import Controllers.Models.SceneBuilder.GameScene;
import Controllers.Models.SceneBuilder.SceneType;
import Controllers.Models.SpriteFactory.Products.Button;
import Controllers.Models.SpriteFactory.Products.Node;
import Controllers.Models.SpriteFactory.Products.NodeType;
import Controllers.Models.SpriteFactory.Sprite;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;


public class CollectTheCoins extends GameScene {

    int seconds;
    private ArrayList<Button> buttonsList;

    public CollectTheCoins(){
        super(SceneType.COINS);
    }

    @Override
    public void initGameComponents(){

        this.seconds=ramdonTime();

        buttonsList = new ArrayList<Button>();

        for(int row = 0; row<25;row++){
            for(int column = 0; column<25;column++){
                Button memoryButton =new Button(20*column+20,20*row+1);
                memoryButton.resizeImage(20,20);
                memoryButton.setType(NodeType.CCBOX);
                memoryButton.setValue(randomCoinValue());
                memoryButton.setPressed(false);
                this.buttonsList.add(memoryButton);
                //super.getButtonsList().add(memoryButton);
                super.getGameComponents().add(memoryButton);
            }
        }

        this.drawBoardPoints();

    }

    @Override
    public void handleMouseEvents(){
        super.getSceneController().getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                for(int element = 0; element< buttonsList.size(); element++){

                    Button tempCollectTheCoinsButton = buttonsList.get(element);

                    if(tempCollectTheCoinsButton.getPositionX()<=mouseEvent.getX() & mouseEvent.getX()<= tempCollectTheCoinsButton.getPositionX()+ tempCollectTheCoinsButton.getWidth()){
                        if(tempCollectTheCoinsButton.getPositionY()<mouseEvent.getY() & mouseEvent.getY()< tempCollectTheCoinsButton.getPositionY()+ tempCollectTheCoinsButton.getHeight()) {
                            setButtonState(tempCollectTheCoinsButton);
                        }
                    }
                }
                System.out.println("TOTAL DE PUNTOS: " + counterPoints());
                //seconds--;
                //update();
                checkWinner();
            }
        });
    }



    @Override
    public void update(){
        for(int element=0;element<super.getGameComponents().size();element++){
            super.getGameComponents().get(element).update(super.getSceneController().getDrawer());
        }
        drawTimer();
        drawCounterPoints();
        //drawBoardPoints();
    }

    public void setButtonState(Button node){
        System.out.println("STATE:"+ node.getValue());
        if (node.getValue() == 1){
            if(node.getPressed() == false){
                node.setType(NodeType.GRAYCOIN);
                node.setPressed(true);
            }
        }else if (node.getValue() == -1){
            if(node.getPressed() == false) {
                node.setType(NodeType.BLUECOIN);
                node.setPressed(true);
            }
        }else if (node.getValue() == 10){
            if(node.getPressed() == false){
                node.setType(NodeType.GOLDCOIN);
                node.setPressed(true);
            }
        }else if (node.getValue() == -10){
            if(node.getPressed() == false){
                node.setType(NodeType.REDCOIN);
                node.setPressed(true);
            }
        }else{
            System.out.println("ESTADO INVALIDO");
        }
    }

    private int randomCoinValue(){
        int randomNumber = (int)(Math.random()*4 + 1);
        if(randomNumber == 1){
            return 1 ;
        }else if(randomNumber == 2){
            return -1 ;
        }else if(randomNumber == 3){
            return 10 ;
        }else if(randomNumber == 4){
            return -10 ;
        }
        System.out.println("NUMERO ALEATORIO : " + randomNumber);
        return 0;
    }

    private int counterPoints(){
        int puntos = 0;
        for(int i = 0; i < 25*25 ; i++){
            if(buttonsList.get(i).getPressed() == true){
                puntos = puntos + buttonsList.get(i).getValue();
            }
        }
        if(puntos > 0){
            // System.out.println(" VA GANANDO PUNTOS : " + puntos);
            return puntos;
        }else {
            // System.out.println(" VA PERDIENDO PUNTOS : " + puntos);
            return puntos;
        }
    }

    private void checkWinner(){
        if(counterPoints() > 0){
            CollectTheCoins.super.showDialog("Player Wins!!");
            int playerTurn=(int)CollectTheCoins.super.getSceneDirector().getGameLog().get("PlayerTurn");
            CollectTheCoins.super.getSceneDirector().getPlayerList().get(playerTurn).setCurrentNodeState(1);
            stop();
        }else if(counterPoints()<=-100){
            CollectTheCoins.super.showDialog("Player Lose!!");
            int playerTurn=(int)CollectTheCoins.super.getSceneDirector().getGameLog().get("PlayerTurn");
            CollectTheCoins.super.getSceneDirector().getPlayerList().get(playerTurn).setCurrentNodeState(-1);
            stop();
        }
    }


    private int ramdonTime(){
        int randomNumber = (int)(Math.random()*3 + 1);
        if(randomNumber == 1){
            return 30 ;
        }else if(randomNumber == 2){
            return 45 ;
        }else if(randomNumber == 3){
            return 60 ;
        }
        System.out.println("NUMERO ALEATORIIO : " + randomNumber);
        return 0;
    }

    public void drawTimer(){
        //----- CREATE TIMER BOARD-----
        super.getSceneController().getDrawer().setFill(Color.RED);
        // this.sceneController.getDrawer().fillRect(550,40,80,60);
        super.getSceneController().getDrawer().fillRoundRect(550, 40, 100, 50, 10, 10);

        // ---- TITLE TIMER ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 20));
        super.getSceneController().getDrawer().setFill(Color.WHITE);
        super.getSceneController().getDrawer().fillText("TIMER",560,60,100);

        // ---- SECONDS ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 15));
        super.getSceneController().getDrawer().fillText(seconds+"s",585,80,100);
    }

    public void drawCounterPoints(){
        //----- CREATE COUNTER POINTS BOARD-----
        super.getSceneController().getDrawer().setFill(Color.BLUE);
        // this.sceneController.getDrawer().fillRect(550,40,80,60);
        super.getSceneController().getDrawer().fillRoundRect(550, 110, 100, 50, 10, 10);

        // ---- TITLE COUNTER POINTS ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 20));
        super.getSceneController().getDrawer().setFill(Color.WHITE);
        super.getSceneController().getDrawer().fillText("SCORE",562,130,100);

        // ---- POINTS ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 15));
        super.getSceneController().getDrawer().fillText(counterPoints()+" pts",585,150,100);
    }

    public void drawBoardPoints(){
        //Image image=new Image(NodeType.BOARDCOINS.getImage(),150,200,false,false);
        //super.getSceneController().getDrawer().drawImage(image,530,200);
        Button board=new Button(NodeType.BOARDCOINS,530,200);
        board.resizeImage(150,200);
        super.getGameComponents().add(board);
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
