package Controllers.Models.SceneBuilder.Products;

import Controllers.Models.SceneBuilder.GameScene;
import Controllers.Models.SceneBuilder.SceneType;
import Controllers.Models.SpriteFactory.Products.Button;
import Controllers.Models.SpriteFactory.Products.NodeType;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MarioSoup extends GameScene {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //File Handler System
    File textFile;
    String filePath;
    String fileContent;

    //Player Input System
    Random random;
    String[] alphabet;
    String playerInput;
    String[] selectedWords;
    String[] splitContent;

    ArrayList<Button> enableNodes;

    //Game Field Builder System
    Button[][] gameField;
    ArrayList<Integer> gameFieldSize;

    //UI Validate
    Button validateButton;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    public MarioSoup(){
        super(SceneType.SOUP);
    }

    @Override
    public void initGameComponents(){

        //Init Fields
        this.random=new Random();
        this.playerInput="";
        this.selectedWords=new String[4];
        this.gameFieldSize=new ArrayList<>();
        this.alphabet= new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        this.enableNodes=new ArrayList<>();

        //Setting Possible Game Field Size
        this.gameFieldSize.add(10);
        this.gameFieldSize.add(15);
        this.gameFieldSize.add(20);

        //Setting FilePath
        this.filePath="Resources/Text Files/Text.txt";

        //Load File Into Memory
        this.loadTextFile(this.filePath);

        //Reading File Content
        this.readTextFile(this.textFile);

        //Parse File Content
        this.parseFileContent();

        //Selecting Words
        this.selectWords();

        //Build Game Field
        this.buildGameField();
    }


    private void buildGameField(){

        //Init Game Fields

        int size=this.gameFieldSize.get(random.nextInt(this.gameFieldSize.size()));
        System.out.println("Game Field Size: "+size);
        this.gameField=new Button[size][size];

        //UI Elements
        this.validateButton=new Button(590,440);
        validateButton.resizeImage(100,50);
        validateButton.setText("Validate");
        validateButton.setId("validateButton");
        super.getGameComponents().add(validateButton);
        super.getButtonsList().add(validateButton);

        //Create Game Nodes
        for(int word=0;word<this.selectedWords.length;word++){
            for(int character=0;character<this.selectedWords[word].length();character++){

                Button button=new Button(0,0);
                button.resizeImage(25,20);
                button.setId(String.valueOf(this.selectedWords[word].charAt(character)));
                button.setText(String.valueOf(this.selectedWords[word].charAt(character)));
                this.enableNodes.add(button);
                super.getGameComponents().add(button);
                //super.getButtonsList().add(button);
            }
        }

        //Positioning Game Node Into Game Field
        this.setNodesPosition();

        //Fill Game Fields With Random Characters
        this.fillGameField();

        //Display Game Field
        this.displayGameField();
    }

    private void fillGameField(){
        for(int row=0;row<this.gameField.length;row++){
            for(int column=0;column<this.gameField.length;column++){
                Button testButton=gameField[row][column];
                if(testButton==null){
                    Button tempButton=new Button(30*row+50,20*column+10); /////////////
                    tempButton.resizeImage(25,20);
                    tempButton.setText(this.alphabet[random.nextInt(this.alphabet.length)]);
                    gameField[row][column]=tempButton;
                    super.getGameComponents().add(tempButton);

                }
            }
        }
    }

    private void setNodesPosition(){

        int readLen=0;
        //Set Vertical Word
        for(int character=0;character<this.selectedWords[0].length();character++){
            this.gameField[this.gameField.length-1][character]=this.enableNodes.get(readLen);
            this.gameField[this.gameField.length-1][character].setPosition(50+30*(this.gameField.length-1),20*character+10);
            readLen++;
        }
        //Set Horizontal Word
        for(int character=0;character<this.selectedWords[1].length();character++){
            this.gameField[character][this.gameField.length-1]=this.enableNodes.get(readLen);
            this.gameField[character][this.gameField.length-1].setPosition(30*character+50,10+(this.gameField.length-1)*20);
            readLen++;

        }
        //Set Diagonal Word 1
        for(int character=0;character<this.selectedWords[2].length();character++){
            this.gameField[character][character]=this.enableNodes.get(readLen);
            this.gameField[character][character].setPosition(30*character+50,20*character+10);
            readLen++;
        }
        //Set Diagonal Word 2
        for(int character=0;character<this.selectedWords[3].length();character++){
            this.gameField[character+2][character]=this.enableNodes.get(readLen);
            this.gameField[character+2][character].setPosition(30*(character+2)+50,20*character+10);
            readLen++;
        }
    }

    private void selectWords(){

        Random random= new Random();

        for(int word=0;word<this.selectedWords.length;word++){
            this.selectedWords[word]=this.splitContent[random.nextInt(splitContent.length)];
        }
        this.displayStringArray(this.selectedWords);
    }

    private void parseFileContent(){

        this.splitContent=fileContent.split("\\s+|,\\s*|\\.\\s*");
        //this.displayStringArray(splitContent);
    }


    private void loadTextFile(String filePath){

            this.textFile = new File(filePath);

    }

    private void readTextFile(File textFile){
        try{
            Scanner fileReader=new Scanner(textFile);
            while(fileReader.hasNextLine()){
                this.fileContent+=fileReader.nextLine();
            }
            fileReader.close();
            //System.out.println(fileContent);
        }catch (FileNotFoundException e){
            System.out.println("Error Reading File");
            e.printStackTrace();
        }
    }

    private void displayGameField(){
        System.out.println("********** Game Field **********");
        for(int row=0;row<gameField.length;row++){
            for(int column=0;column<gameField[0].length;column++){

                System.out.print(this.gameField[row][column].getText().get()+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private void displayStringArray(String[] array){

        for(int element=0;element<array.length;element++){
            System.out.println(array[element]);
        }
    }


    @Override
    public void handleMouseEvents(){
        super.getSceneController().getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                for(int element = 0; element< enableNodes.size(); element++){

                    Button tempButton = enableNodes.get(element);

                    if(tempButton.getPositionX()<=mouseEvent.getX() & mouseEvent.getX()<=tempButton.getPositionX()+tempButton.getWidth()){
                        if(tempButton.getPositionY()<mouseEvent.getY() & mouseEvent.getY()<tempButton.getPositionY()+tempButton.getHeight()) {

                           nodeClick(tempButton);
                        }
                    }
                }


                if(validateButton.getPositionX()<=mouseEvent.getX() & mouseEvent.getX()<=validateButton.getPositionX()+validateButton.getWidth()){
                    if(validateButton.getPositionY()<mouseEvent.getY() & mouseEvent.getY()<validateButton.getPositionY()+validateButton.getHeight()) {

                        validateWord();
                    }}

            }
        });

    }

    private void nodeClick(Button node){
        if(node.getPressed()==true){
            System.out.println("Node ya fue seleccionado");
        }else {
            node.setType(NodeType.REDBUTTON);
            this.playerInput += node.getText().getValue();
            System.out.println("Actual input: " + this.playerInput);
        }
    }

    private  void validateWord(){
        for(int word=0;word<this.selectedWords.length;word++){

            if(this.playerInput.equals(this.selectedWords[word])){
                System.out.println("Palabra encontrada: "+this.selectedWords[word]);
                this.selectedWords[word]="";
            }
        }

        if(checkWinner()){
            System.out.println("Player Wins");
            super.showDialog("Player Wins!!");
            int playerTurn=(int)super.getSceneDirector().getGameLog().get("PlayerTurn");
            super.getSceneDirector().getPlayerList().get(playerTurn).setCurrentNodeState(1);
            this.stop();
        }else{
            System.out.println("Quedan palabras por encontrar");
            this.playerInput="";
        }
    }

    private boolean checkWinner(){
        int pendingWords=0;
        for(int word=0;word<this.selectedWords.length;word++){
            if(this.selectedWords[word].equals("")){
                System.out.println("Empty Word");
            }else{
                pendingWords+=1;
            }
        }

        if(pendingWords!=0){
            return false;
        }else{
            return true;
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
