package Controllers.Models.SceneBuilder.Products;

import Controllers.Models.SceneBuilder.GameScene;
import Controllers.Models.SceneBuilder.SceneType;
import Controllers.Models.SpriteFactory.Products.Button;
import Controllers.Models.SpriteFactory.Products.NodeType;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class TicTacToe extends GameScene {


    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Identifiers
    private int turn;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //Constructor
    public TicTacToe(){
        super(SceneType.TICTACTOE);
        this.turn =1;
    }

    //Render System
    @Override
    public void initGameComponents(){


        for(int row = 0; row<3;row++){
            for(int column = 0; column<3;column++){
                Button button=new Button(NodeType.CAJA,110*column+50,110*row+50);
                button.resizeImage(100,100);


                super.getButtonsList().add(button);
                super.getGameComponents().add(button);

            }
        }

    }
    @Override
    public void update(){
        for(int element=0;element<super.getGameComponents().size();element++){
            super.getGameComponents().get(element).update(super.getSceneController().getDrawer());
        }
        drawTitle(); // title game
        drawturn(this.turn); // players board turn

        if(checkWinner() == true){
            drawturn(this.turn*-1);
            drawWinner();
        }

    }

    public void setState(Button button){
        if (this.turn == 1){
            if(button.getPressed() == false){

                button.setType(NodeType.TTTO);

                button.setValue(1);

            }
        }else if (this.turn == -1){
            if(button.getPressed() == false) {

                button.setType(NodeType.TTTX);

                button.setValue(-1);

            }
        }else{
            System.out.println("ESTADO INVALIDO");
        }
        button.setPressed(true);
        //this.changeTurn();

    }



    //Event Handling System
    @Override
    public void handleMouseEvents(){

        super.getSceneController().getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                for(int element = 0; element< TicTacToe.super.getButtonsList().size(); element++){

                    Button tempButton= (Button)TicTacToe.super.getButtonsList().get(element);

                    if(tempButton.getPositionX()<=mouseEvent.getX() & mouseEvent.getX()<=tempButton.getPositionX()+tempButton.getWidth()) {
                        if (tempButton.getPositionY() < mouseEvent.getY() & mouseEvent.getY() < tempButton.getPositionY() + tempButton.getHeight()){
                            if (checkWinner() == false) {
                                System.out.println("CHECK WINNER");
                                tempButton.setValue(changeTurn());
                                setState(tempButton);
                                if (checkButtonsStates() == true) {
                                    System.out.println("CHECK STATES");
                                    restartButtonsStates();
                                }
                            }
                        }
                    }
                }

                if(checkWinner() == true){

                    System.out.println("GANO EL JUGADOR" + turn *-1);
                    stop();

                }else{
                    System.out.println("SIGUE EL JUGADOR" + turn);

                }
            }
        });
    }



    //Game Logic
    private int changeTurn(){
        this.turn =this.turn *-1;
        return this.turn;
    }

    public void restartButtonsStates(){
        for(int j = 0; j < 9 ; j++){
            super.getButtonsList().get(j).setValue(0);
            super.getButtonsList().get(j).setPressed(false);
            super.getButtonsList().get(j).setType(NodeType.CAJA);
        }
    }

    private boolean checkButtonsStates(){
        int cont = 0;
        for(int j = 0; j < 9 ; j++){
            if(super.getButtonsList().get(j).getValue() != 0) {
                cont++;
            }
        }
        if(cont == 9){
            return true;
        }
        return false;
    }


    private boolean checkWinner(){

        int[][] tableWinner = new int[8][3];
        //String topRow,midRow,botRow,leftRow,midCol,rightCol,cross1,cross2;
            /*topRow = "012"; midRow = "345"; botRow = "678"; leftRow = "036";
            midCol = "147"; rightCol = "258"; cross1 = "048"; cross2 = "246";*/
        tableWinner[0][0] = 0; tableWinner[0][1] = 1; tableWinner[0][2] = 2; //topRow = "012";
        tableWinner[1][0] = 3; tableWinner[1][1] = 4; tableWinner[1][2] = 5; //midRow = "345";
        tableWinner[2][0] = 6; tableWinner[2][1] = 7; tableWinner[2][2] = 8; //botRow = "678";
        tableWinner[3][0] = 0; tableWinner[3][1] = 3; tableWinner[3][2] = 6; //leftRow = "036";
        tableWinner[4][0] = 1; tableWinner[4][1] = 4; tableWinner[4][2] = 7; //midCol = "147";
        tableWinner[5][0] = 2; tableWinner[5][1] = 5; tableWinner[5][2] = 8; //rightCol = "258";
        tableWinner[6][0] = 0; tableWinner[6][1] = 4; tableWinner[6][2] = 8; //cross1 = "048";
        tableWinner[7][0] = 2; tableWinner[7][1] = 4; tableWinner[7][2] = 6; //cross2 = "246";
        int cont = 0;
        for(int i = 0; i < 8 ; i++){
            cont = 0;
            for(int j = 0; j < 3 ; j++){
                if(super.getButtonsList().get(tableWinner[i][j]).getValue() == this.turn) {
                    cont++;
                }
            }
            if(cont == 3){
                return true;
            }
        }
        return false;

    }

    public void drawTitle(){
        // ---- TITLE TIC TAC TOE ----
        super.getSceneController().getDrawer().setFont(new Font("Verdana Bold Italic", 40));
        super.getSceneController().getDrawer().setFill(Color.WHITE);
        super.getSceneController().getDrawer().fillText("Tic Tac Toe",400,80,500);
    }

    public void drawturn(int turn){
        /*double x = 400;
        double y = 150;
        double width = ;
        double height = ;*/
        if(turn == 1){
            //----- CREATE PLAYER 2 BOARD------
            super.getSceneController().getDrawer().setFill(Color.BLUE);
            super.getSceneController().getDrawer().fillRoundRect(400, 150, 200, 50, 10, 10);
            // ---- TITLE PLAYER ----
            super.getSceneController().getDrawer().setFont(new Font("Verdana Bold", 30));
            super.getSceneController().getDrawer().setFill(Color.WHITE);
            super.getSceneController().getDrawer().fillText("PLAYER 1",420,185);
        }else if (turn == -1){
            //----- CREATE PLAYER 1 BOARD-----
            super.getSceneController().getDrawer().setFill(Color.RED);
            super.getSceneController().getDrawer().fillRoundRect(400, 150, 200, 50, 10, 10);
            // ---- TITLE PLAYER ----
            super.getSceneController().getDrawer().setFont(new Font("Verdana Bold", 30));
            super.getSceneController().getDrawer().setFill(Color.WHITE);
            super.getSceneController().getDrawer().fillText("PLAYER 2",420,185);
        }
    }

    public void drawWinner(){
        // ---- TITLE WINNER ----
        super.getSceneController().getDrawer().setFont(new Font("Verdana Bold", 30));
        super.getSceneController().getDrawer().setFill(Color.WHITE);
        super.getSceneController().getDrawer().fillText("YOU WIN!!!",405,230);
    }

    @Override
    public void stop(){

        //Stops Mini Game Execution
        super.getMusicPlayer().stop();
        super.getGameLoop().stop();

        //Reload Main Game
        super.getSceneDirector().getMainGame().start();
    }

}
