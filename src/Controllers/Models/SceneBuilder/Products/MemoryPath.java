package Controllers.Models.SceneBuilder.Products;

import Controllers.Models.SceneBuilder.GameScene;
import Controllers.Models.SceneBuilder.SceneType;
import Controllers.Models.SpriteFactory.Products.Node;
import Controllers.Models.SpriteFactory.Products.NodeType;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MemoryPath extends GameScene {

    private Node[][] tables;

    private int attempts;
    private int currentRow;
    private int stateWin;

    public MemoryPath(){
        super(SceneType.MEMORYPATH);
    }

    @Override
    public void initGameComponents(){

        this.attempts=3;

        this.currentRow=0;

        this.stateWin= 0;

        this.tables = new Node[6][3];


        for(int row = 0; row<6;row++){
            for(int column = 0; column<3;column++){
                //60,75
                Node memoryButton =new Node(65*row+160,80*column+190);
                memoryButton.resizeImage(60,75);
                memoryButton.setType(NodeType.MEMORYPATHEMPTYTABLE);
                memoryButton.setValue(-1);

                memoryButton.setPressed(true);
                this.tables[row][column]=memoryButton;
                super.getGameComponents().add(memoryButton);

            }
            this.tables[row][randomValue()].setValue(1);
        }

        enableRowTable(currentRow);

        printBoard();//PRUEBA IMPRESION



    }


    @Override
    public void handleMouseEvents(){
        super.getSceneController().getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                for(int row = 0; row<6;row++){
                    for(int column = 0; column<3;column++){
                        Node tempMemoryButton = tables[row][column];
                        if(tempMemoryButton.getPositionX()<=mouseEvent.getX() & mouseEvent.getX()<= tempMemoryButton.getPositionX()+ tempMemoryButton.getWidth()) {
                            if (tempMemoryButton.getPositionY() < mouseEvent.getY() & mouseEvent.getY() < tempMemoryButton.getPositionY() + tempMemoryButton.getHeight()){

                                if(tempMemoryButton.getPressed() == false) {
                                    setButtonState(tempMemoryButton);
                                    if (tempMemoryButton.getValue() == 1) {
                                        disableRowTable(currentRow);
                                        if(currentRow < 5){
                                            currentRow++;
                                            enableRowTable(currentRow);
                                        }else{
                                            System.out.println("GANASTE!!!");
                                            stateWin = 1;
                                            stop();
                                        }
                                        System.out.println("NEXT ROW: "+currentRow);
                                    } else {
                                        disableRowTable(currentRow);
                                        disableTable(currentRow,column);
                                        attempts--;
                                        System.out.println("Attempts:"+attempts);
                                        if(attempts==0) {
                                            System.out.println("PERDISTE :( ");
                                            stateWin = -1;
                                            stop();
                                        }
                                    }
                                }else{
                                    restartGame();
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
        this.drawTitle();
        this.drawAttemps(this.attempts);
        this.drawTitleWinnerState(this.stateWin);
    }



    public void restartGame(){
        System.out.println("***RESTART GAME***");
        if(attempts>0 && currentRow<5 ){
            for(int row = 0; row<6;row++){
                for(int column = 0; column<3;column++) {
                    this.tables[row][column].setType(NodeType.MEMORYPATHEMPTYTABLE);
                    this.tables[row][column].setPressed(true);
                }
            }
            currentRow = 0;
            enableRowTable(currentRow);
        }else{
            disableAllRowTable();
        }
    }

    public void disableTable(int row, int column){
        this.tables[row][column].setPressed(true);
    }

    public void enableTable(int row, int column){
        this.tables[row][column].setPressed(false);
    }

    public void enableRowTable(int row){
        this.tables[row][0].setPressed(false);
        this.tables[row][1].setPressed(false);
        this.tables[row][2].setPressed(false);
    }

    public void disableRowTable(int row){
        this.tables[row][0].setPressed(true);
        this.tables[row][1].setPressed(true);
        this.tables[row][2].setPressed(true);
    }

    public void disableAllRowTable(){
        disableRowTable(0);
        disableRowTable(1);
        disableRowTable(2);
        disableRowTable(3);
        disableRowTable(4);
        disableRowTable(5);
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
        for(int column = 0; column<3;column++){
            for(int row = 0; row<6;row++){
                tabla = tabla + "| " +this.tables[row][column].getValue();
            }
            System.out.println(column+")"+tabla);
            tabla = "";
        }
    }

    public void setButtonState(Node node){
        System.out.println("STATE:"+ node.getValue());
        if (node.getValue() == -1){
            if(node.getPressed() == false){
                node.setType(NodeType.MEMORYPATHINCORRECTTABLE);
                //node.resizeImage(100,100);
                node.setPressed(true);


            }
        }else if (node.getValue() == 0){
            if(node.getPressed() == false) {

                node.setType(NodeType.MEMORYPATHEMPTYTABLE);
                //node.resizeImage(100,100);
                node.setPressed(true);

            }
        }else if (node.getValue() == 1){
            if(node.getPressed() == false){

                node.setType(NodeType.MEMORYPATHCORRECTTABLE);
                //node.resizeImage(100,100);
                node.setPressed(true);

            }
        }else{
            System.out.println("ESTADO INVALIDO");
        }
    }

    public void drawTitle(){
        // ---- TITLE TIC TAC TOE ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 50));
        super.getSceneController().getDrawer().setFill(Color.WHITE);
        super.getSceneController().getDrawer().fillText("MEMORY PATH",170,60,500);
        //drawMario();
    }

    public void drawAttemps(int attempts){
        //---------PLAYER 1---------------------------------------------------------------------
        //----- CREATE COUNTER POINTS BOARD-----
        super.getSceneController().getDrawer().setFill(Color.BLUE);
        // this.sceneController.getDrawer().fillRect(550,40,80,60);
        super.getSceneController().getDrawer().fillRoundRect(20, 60, 100, 50, 10, 10);

        // ---- TITLE COUNTER POINTS ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 20));
        super.getSceneController().getDrawer().setFill(Color.WHITE);
        super.getSceneController().getDrawer().fillText("Attempts",35,80,100);

        // ---- POINTS ----
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 20));
        super.getSceneController().getDrawer().fillText(attempts+"",60,100,100);
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
