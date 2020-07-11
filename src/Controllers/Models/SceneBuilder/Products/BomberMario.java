package Controllers.Models.SceneBuilder.Products;

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

public class BomberMario extends GameScene {

    private Button[][] blocks;
    private int contBombers;
    private int bombers;
    private int starParts;
    private int blockSize;
    private int blockRow;
    private int blockColumn;
    private ArrayList<Integer> bomberList;

    public BomberMario(){
        super(SceneType.BOMBER);
    }


    @Override
    public void initGameComponents(){
        this.blockSize= randomBlocksSize();
        System.out.println("Block Size: "+blockSize);
        this.bombers=7;
        this.contBombers=7;

        this.starParts= 0;

        this.bomberList = new ArrayList<Integer>();
        this.bomberList.add(1);
        this.bomberList.add(1);
        this.bomberList.add(2);
        this.bomberList.add(2);
        this.bomberList.add(3);
        this.bomberList.add(3);
        this.bomberList.add(4);

        Collections.shuffle(this.bomberList);

        this.blockRow= (int)(Math.random()*blockSize-1-1 + 1);
        this.blockColumn= (int)(Math.random()*blockSize-1-1 + 1);
        this.blocks = new Button[blockSize][blockSize];
        System.out.println("ROW :"+this.blockRow+" COLUMN :"+this.blockColumn);

        for(int row = 0; row<blockSize;row++){
            for(int column = 0; column<blockSize;column++){
                //60,75
                Button RockButton =new Button(25*row+0,25*column+0);
                RockButton.resizeImage(25,25);
                RockButton.setType(NodeType.BOMBERROCK);
                RockButton.setValue(0);

                RockButton.setPressed(false);
                this.blocks[row][column]=RockButton;
                super.getGameComponents().add(RockButton);
            }
        }

        this.blocks[blockRow][blockColumn].setValue(1);
        this.blocks[blockRow+1][blockColumn].setValue(2);
        this.blocks[blockRow][blockColumn+1].setValue(3);
        this.blocks[blockRow+1][blockColumn+1].setValue(4);

        printBoard();//PRUEBA IMPRESION

    }
    @Override
    public void handleMouseEvents(){
        super.getSceneController().getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                for(int row = 0; row<blockSize;row++){
                    for(int column = 0; column<blockSize;column++){
                        Button tempRockButton = blocks[row][column];
                        if(tempRockButton.getPositionX()<=mouseEvent.getX() & mouseEvent.getX()<= tempRockButton.getPositionX()+ tempRockButton.getWidth()) {
                            if (tempRockButton.getPositionY() < mouseEvent.getY() & mouseEvent.getY() < tempRockButton.getPositionY() + tempRockButton.getHeight()){

                                if(tempRockButton.getPressed() == false) {
                                    if(contBombers>0){
                                        explodeBomb(row,column,tempRockButton);
                                        if(checkWinner()==true){
                                            System.out.println("GANASTE!!!");

                                        }else{
                                            if(contBombers == 0){
                                                System.out.println("PERDISTE :(");
                                            }else{
                                                contBombers--;
                                                System.out.println("Siguiente Bomba");
                                            }
                                        }
                                        //explodeBomb(row,column,tempRockButton);
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
        //this.drawTitle();
        this.drawAttemps(this.contBombers);

        if(checkWinner() == true){
            this.drawTitleWinnerState(1);
            this.stop();
            super.showDialog("Player Wins!!");
            int playerTurn=(int)super.getSceneDirector().getGameLog().get("PlayerTurn");
            super.getSceneDirector().getPlayerList().get(playerTurn).setCurrentNodeState(1);

        }else{
            if(contBombers==0){
                this.drawTitleWinnerState(-1);
                this.stop();
                super.showDialog("Player Lose!!");
                int playerTurn=(int)super.getSceneDirector().getGameLog().get("PlayerTurn");
                super.getSceneDirector().getPlayerList().get(playerTurn).setCurrentNodeState(-1);

            }
        }

    }

    private int randomBlocksSize (){
        int randomNumber = (int)(Math.random()*3 + 1);
        if(randomNumber == 1){
            return 10 ;
        }else if(randomNumber == 2){
            return 15 ;
        }else if(randomNumber == 3){
            return 20 ;
        }
        System.out.println("NUMERO ALEATORIO : " + randomNumber);
        return 0;
    }

    private void explodeBomb(int row,int column,Button node){
        if(bomberList.get(contBombers-1)==1){
            dobleBomb(row,column,node);
        }else if(bomberList.get(contBombers-1)==2){
            crossBomb(row,column,node);
        }else if(bomberList.get(contBombers-1)==3){
            lineBomb(row,column,node);
        }else if(bomberList.get(contBombers-1)==4){
            simpleBomb(row,column,node);
        }
    }

    private void simpleBomb(int row,int column,Button node){
        checkStar(setButtonState(node));
    }

    private void dobleBomb(int row,int column,Button node){
        int ranRow = (int)(Math.random()*2 + 1);
        int ranColumn = (int)(Math.random()*2 + 1);
        if(ranRow ==2){
            ranRow = -1;
        }
        if(ranColumn ==2){
            ranColumn = -1;
        }
        try{
            checkStar(setButtonState(this.blocks[row][column]));
        }catch (Exception e){
            System.out.println("FUERA DE RANGO");
        }
        try{
            checkStar(setButtonState(this.blocks[row+1*ranRow][column]));
        }catch (Exception e){
            System.out.println("FUERA DE RANGO");
        }
        try{
            checkStar(setButtonState(this.blocks[row][column+1*ranColumn]));
        }catch (Exception e){
            System.out.println("FUERA DE RANGO");
        }
        try{
            checkStar(setButtonState(this.blocks[row+1*ranRow][column+1*ranColumn]));
        }catch (Exception e){
            System.out.println("FUERA DE RANGO");
        }
    }

    private void crossBomb(int row,int column,Button node){
        checkStar(setButtonState(this.blocks[row][column]));
        try{
            checkStar(setButtonState(this.blocks[row][column+1]));
        }catch (Exception e){
            System.out.println("FUERA DE RANGO");
        }

        try{
            checkStar(setButtonState(this.blocks[row][column-1]));
        }catch (Exception e){
            System.out.println("FUERA DE RANGO");
        }

        try{
            checkStar(setButtonState(this.blocks[row+1][column]));
        }catch (Exception e){
            System.out.println("FUERA DE RANGO");
        }

        try{
            checkStar(setButtonState(this.blocks[row-1][column]));
        }catch (Exception e){
            System.out.println("FUERA DE RANGO");
        }
    }

    private void lineBomb(int row,int column,Button node){
        int randomNumber = (int)(Math.random()*2 + 1);
        checkStar(setButtonState(this.blocks[row][column]));
        for(int i = 1; i < 3 ; i++){
            if(randomNumber == 1){
                row++;
            }else{
                column++;
            }
            try{
                checkStar(setButtonState(this.blocks[row][column]));
            }catch (Exception e){
                System.out.println("FUERA DE RANGO");
            }

        }
    }

    private void checkStar(int value){
        if(value == 1 || value == 2 || value == 3 || value == 4){
            this.starParts++;
        }
        System.out.println("STAR PARTS: "+this.starParts);
    }

    private boolean checkWinner(){
        if(starParts >= 4 && contBombers>=1){
            return true;
        }else{
            return false;
        }
    }

    private int randomValue(){
        int randomNumber = (int)(Math.random()*3 + 1);
        randomNumber--;
        System.out.println("NUMERO ALEATORIO : " + randomNumber);
        return randomNumber;
    }

    private void printBoard(){
        System.out.println("-------TABLA-------");
        String tabla = "";
        for(int column = 0; column<blockSize;column++){
            for(int row = 0; row<blockSize;row++){
                tabla = tabla + "| " +this.blocks[row][column].getValue();
            }
            System.out.println(column+")"+tabla);
            tabla = "";
        }
    }

    public int setButtonState(Button node){
        System.out.println("STATE:"+ node.getValue());
        if (node.getValue() == 0){
            if(node.getPressed() == false){
                node.setType(NodeType.BOMBERTRANSPARENT);
                node.setPressed(true);
            }
        }else if (node.getValue() == 1){
            if(node.getPressed() == false) {
                node.setType(NodeType.BOMBERSTARPART1);
                node.setPressed(true);
            }
        }else if (node.getValue() == 2){
            if(node.getPressed() == false){
                node.setType(NodeType.BOMBERSTARPART2);
                node.setPressed(true);
            }
        }else if (node.getValue() == 3){
            if(node.getPressed() == false){
                node.setType(NodeType.BOMBERSTARPART3);
                node.setPressed(true);
            }
        }else if (node.getValue() == 4){
            if(node.getPressed() == false){
                node.setType(NodeType.BOMBERSTARPART4);
                node.setPressed(true);
            }
        }else{
            System.out.println("ESTADO INVALIDO");
        }
        return node.getValue();
    }

    public void drawTitle(){
        // ---- TITLE TIC TAC TOE ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 50));
        super.getSceneController().getDrawer().setFill(Color.WHITE);
        super.getSceneController().getDrawer().fillText("MEMORY PATH",170,60,500);
        //drawMario();
    }

    public void drawAttemps(int bombs){
        //---------PLAYER 1---------------------------------------------------------------------
        //----- CREATE COUNTER POINTS BOARD-----
        super.getSceneController().getDrawer().setFill(Color.BLUE);
        // this.sceneController.getDrawer().fillRect(550,40,80,60);
        super.getSceneController().getDrawer().fillRoundRect(560, 60, 100, 50, 10, 10);

        // ---- TITLE COUNTER POINTS ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 20));
        super.getSceneController().getDrawer().setFill(Color.WHITE);
        super.getSceneController().getDrawer().fillText("Bombers",570,80,100);

        // ---- POINTS ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 20));
        super.getSceneController().getDrawer().fillText(bombs+"",600,100,100);
        //---------------------------------------------------------------------------------------

    }

    public void drawTitleWinnerState(int state){
        // ---- TITLE MEMORY PATH ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 65));
        super.getSceneController().getDrawer().setFill(Color.WHITE);
        if(state == 1){
            super.getSceneController().getDrawer().fillText("YOU WIN !!!",170,190,500);
        }else if (state == -1){
            super.getSceneController().getDrawer().fillText("YOU LOSE !!!",170,190,500);
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
