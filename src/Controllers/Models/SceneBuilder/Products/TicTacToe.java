package Controllers.Models.SceneBuilder.Products;

import Controllers.Models.SceneBuilder.MiniGame;
import Controllers.Models.SpriteFactory.Products.Node;
import Controllers.Models.SpriteFactory.Products.NodeType;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class TicTacToe extends MiniGame {


    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Identifiers
    private int turn;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //Constructor
    public TicTacToe(){
        this.turn =1;
    }

    //Render System
    @Override
    public void initGameComponents(){


        for(int row = 0; row<3;row++){
            for(int column = 0; column<3;column++){
                Node button=new Node(83*column+57,80*row+90);
                button.resizeImage(55,55);

                super.getButtonsList().add(button);
                super.getGameComponents().add(button);

            }
        }

    }

    public void setState(Node button){
        if (this.turn == 1){
            if(button.getPressed() == false){
                button.setType(NodeType.TTTO);

                button.setValue(1);

            }}else if (this.turn == -1){
            if(button.getPressed() == false) {
                button.setType(NodeType.TTTX);

                button.setValue(-1);

            }
        }else{
            System.out.println("ESTADO INVALIDO");
        }
        button.setPressed(true);
        this.changeTurn();

    }



    //Event Handling System
    @Override
    public void handleMouseEvents(){

        super.getSceneController().getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                for(int element = 0; element< TicTacToe.super.getButtonsList().size(); element++){

                    Node tempButton= (Node)TicTacToe.super.getButtonsList().get(element);

                    if(tempButton.getPositionX()<=mouseEvent.getX() & mouseEvent.getX()<=tempButton.getPositionX()+tempButton.getWidth()){
                        if(tempButton.getPositionY()<mouseEvent.getY() & mouseEvent.getY()<tempButton.getPositionY()+tempButton.getHeight())
                           setState(tempButton);

                    }
                }

                if(checkWinner() == true){

                    System.out.println("GANO EL JUGADOR" + turn *-1);

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





}
