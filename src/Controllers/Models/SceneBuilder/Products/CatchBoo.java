package Controllers.Models.SceneBuilder.Products;

import Controllers.Models.SceneBuilder.MiniGame;
import Controllers.Models.SpriteFactory.Products.Node;
import Controllers.Models.SpriteFactory.Products.NodeType;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.Random;

public class CatchBoo extends MiniGame {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Boo Position System
    int[] booNode;

    //Random Generator System
    Random random;

    //Game Field System
    private Node[][] gameField;

    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    @Override
    public void initGameComponents(){
        this.booNode=new int[2];
        this.random=new Random();
        this.createGameField();

    }

    //Create the Game Field
    private void createGameField(){
        this.gameField=new Node[10][10];

        for(int row=0;row<gameField.length;row++){
            for(int column=0;column<gameField[0].length;column++){
                Node tempNode=new Node(0,0);
                tempNode.setValue(9);
                tempNode.setType(NodeType.TUMB);
                tempNode.resizeImage(40,40);
                gameField[row][column]=tempNode;

                super.getGameComponents().add(tempNode);
            }
        }

        this.buildBlockage();
        this.createBoo();

    }

    //Print Game Field Weights
    private void displayGameField(){
        System.out.println("********** Game Field **********");
        for(int row=0;row<gameField.length;row++){
            for(int column=0;column<gameField[0].length;column++){

                System.out.print(this.gameField[row][column].getValue()+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    //Build Initial Blockage
    private void buildBlockage(){
        int blocks=0;

        while(blocks<this.gameField.length+1){

            Node tempNode=this.gameField[this.getRandom()][this.getRandom()];
            if(tempNode.getPressed()==false){

                tempNode.setType(NodeType.TUMBX);
                tempNode.setPressed(true);
                blocks++;
            }
        }
    }

    //Creating Boo & Set Initial Position
    private void createBoo(){

        int booCreated=0;

        int highValue=6;
        int lowValue=3;

        while(booCreated<1){
            int tempRow=this.random.nextInt(highValue-lowValue)+lowValue;
            int temColumn=this.random.nextInt(highValue-lowValue)+lowValue;
            Node tempNode=this.gameField[tempRow][temColumn];

            if(tempNode.getPressed()==false){
                tempNode.setPressed(true);
                tempNode.setType(NodeType.MEMORYPATHCORRECTTABLE);
                tempNode.setValue(0);
                this.booNode[0]=tempRow;
                this.booNode[1]=temColumn;
                booCreated++;
            }
        }
    }

    //Player Turn System
    private void playerTurn(Node selectedNode){

        this.displayGameField();

        if(selectedNode.getPressed()==true){

            System.out.println("Casilla ya fue seleccionada");

        }else{

            selectedNode.setPressed(true);
            selectedNode.setType(NodeType.TUMBX);

            this.booTurn();
        }

    }

    //Boo Movement System
    private void booTurn(){

        int[][] openSet=new int[3][3];

        //Update Node Values
        this.updateNodeWeight();

        //Calculate Path
        if(this.booBounds()) {

            System.out.println("********* Calculating Path *********");
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {

                    int tempRow=booNode[0]-1+row;
                    int tempColumn=booNode[1]-1+column;

                    Node tempNode=this.gameField[tempRow][tempColumn];
                    //Calculating Path Weights & Set to Open Set
                    openSet[row][column] = calculatePath(tempNode,tempRow,tempColumn,row-1,column-1);

                    System.out.print(openSet[row][column]+" ");
                }
                System.out.println("");
            }

            //Selecting  Lower Path

            int[] nextMove=this.selectPath(openSet);
            if(nextMove.equals(null)){
                System.out.println("Player Wins");
            }else{
                gameField[booNode[0]][booNode[1]].setPressed(false);
                booNode[0]=nextMove[0];
                booNode[1]=nextMove[1];
                gameField[booNode[0]][booNode[1]].setPressed(true);
            }

        }else{
            System.out.println("Player Perdiooo!!! :(");
        }


        //Selecting Path
        /*int[] selectedPath=selectPath(openSet);
        if(selectedPath.equals(null)){
            System.out.println("Player wins");
        }else{
            booNode[0]=booNode[0]+selectedPath[0]-1;
            booNode[1]=booNode[1]+selectedPath[1]-1;
        }*/

        System.out.println("*** Boo Moved ***");

    }

    private void updateNodeWeight(){
        for(int row=0;row<this.gameField.length;row++){
            for(int column=0;column<this.gameField.length;column++){

                Node tempNode=this.gameField[row][column];
                if(tempNode.getPressed()==true & booNode[0]!=row &booNode[1]!=column){
                    tempNode.setValue(-1);
                }else {
                    tempNode.setValue(Math.abs(row - booNode[0]) + Math.abs(column - booNode[1]));
                }
            }
        }
    }

    //Look Up For Boo Bounds
    private boolean booBounds(){
        if(booNode[0]+1<gameField.length & booNode[0]-1>=0 &booNode[1]+1<gameField.length & booNode[1]-1>=0){
            return true;
        }else{
            return false;
        }

    }

    //Calculate Path Weight
    private int calculatePath(Node node, int nodeRow, int nodeColumn, int rowDir, int columnDir){

        if(node.getPressed()){
            return 100;
        }else{

            int initRow=nodeRow;
            int initColumn=nodeColumn;
            int PathValue=0;

            while(initRow>=0 & initRow<10 & initColumn>=0 & initColumn<10){

                PathValue+=this.gameField[initRow][initColumn].getValue();
                initRow+=rowDir;
                initColumn+=columnDir;


            }

            return PathValue;
        }
    }

    //Comparing Path Weight
    private int[] selectPath(int[][] openSet){
        int lowerValueRow=0;
        int lowerValueColumn=0;
        for(int row=0;row<openSet.length;row++){
            for(int column=0;column<openSet.length;column++){

                if(openSet[row][column]<=openSet[lowerValueRow][lowerValueColumn]){
                    lowerValueRow=row;
                    lowerValueColumn=column;
                }
            }
        }
        if(openSet[lowerValueRow][lowerValueColumn]==100){
            return null;
        }else{
            int[] result={lowerValueRow,lowerValueColumn};
            return result;
        }


    }


    //Random Generator
    private int getRandom(){

        return this.random.nextInt(this.gameField.length);
    }

    //Events Handler System
    @Override
    public void handleMouseEvents(){
        super.getSceneController().getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                /*for(int row = 0; row<6;row++){
                    for(int column = 0; column<3;column++){
                        Node tempMemoryButton = gameField[row][column];
                        if(tempMemoryButton.getPositionX()<=mouseEvent.getX() & mouseEvent.getX()<= tempMemoryButton.getPositionX()+ tempMemoryButton.getWidth()) {
                            if (tempMemoryButton.getPositionY() < mouseEvent.getY() & mouseEvent.getY() < tempMemoryButton.getPositionY() + tempMemoryButton.getHeight()){

                                displayGameField();
                                booTurn();


                            }
                        }
                    }
                }*/


                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){

                    displayGameField();
                    booTurn();


                }
            }
        });

    }




}
