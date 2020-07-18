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

public class GuessWho extends GameScene {


    private ArrayList<Button> buttonsList;
    private ArrayList<Button> buttonsSelectionList;
    private int character;
    private int cellsToDisappear;

    public GuessWho(){
        super(SceneType.GUESS);
    }
    @Override
    public void initGameComponents(){
        buttonsList = new ArrayList<Button>();
        buttonsSelectionList = new ArrayList<Button>();
        character= (int)(Math.random()*15 + 1);
        System.out.println("CHARACTER #: "+character);
        cellsToDisappear= 3+(int)(Math.random()*5 + 1);
        System.out.println("CELLS TO DISAPPEAR #: "+cellsToDisappear);

        //Charater
        Button backgroundCharacter = new Button(72,63);
        backgroundCharacter.resizeImage(350,350);
        NodeType characterSelected = selectCharacter(character);
        System.out.println("CHARACTER : "+characterSelected.name());
        backgroundCharacter.setType(characterSelected);
        backgroundCharacter.setPressed(true);
        super.getGameComponents().add(backgroundCharacter);


        //Boxes
        for(int row = 0; row<10;row++){
            for(int column = 0; column<10;column++){
                Button memoryButton =new Button(37*column+72,37*row+63);
                memoryButton.resizeImage(40,40);
                memoryButton.setType(NodeType.CAJA);
                memoryButton.setValue(0);
                memoryButton.setPressed(true);
                this.buttonsList.add(memoryButton);
                //super.getButtonsList().add(memoryButton);
                super.getGameComponents().add(memoryButton);
            }
        }

        for(int list = 0; list < cellsToDisappear;list++){
            int randomBox = (int)(Math.random()*100 + 1)-1;
            this.buttonsList.get(randomBox).setValue(1);
            this.buttonsList.get(randomBox).setType(NodeType.GUEESTRANSPARENT);
        }

        //Selection Buttons

        for(int row = 0; row<15;row++){
            Button memoryButton =new Button(495,30*row+20);
            //Button memoryButton =new Button(350,20*row+1);
            memoryButton.resizeImage(200,30);
            memoryButton.setType(NodeType.GUESSBUTTONSTANDARD);
            memoryButton.setValue(-1);
            memoryButton.setPressed(false);
            //memoryButton.setText("PRUEBA");
            this.buttonsSelectionList.add(memoryButton);
            //super.getButtonsList().add(memoryButton);
            super.getGameComponents().add(memoryButton);
        }
        this.buttonsSelectionList.get(character-1).setValue(1);
        //this.buttonsSelectionList.get(character-1).setType(NodeType.GUESSBUTTONCORRECT);

        //super.getButtonsList().get(character-1).setValue(1);
        //super.getButtonsList().get(character-1).setType(NodeType.BOARDCOINS);


    }

    @Override
    public void handleMouseEvents(){
        super.getSceneController().getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                for(int element = 0; element< buttonsSelectionList.size(); element++){

                    Button tempGuessWhoButton = buttonsSelectionList.get(element);

                    if(tempGuessWhoButton.getPositionX()<=mouseEvent.getX() & mouseEvent.getX()<= tempGuessWhoButton.getPositionX()+ tempGuessWhoButton.getWidth()){
                        if(tempGuessWhoButton.getPositionY()<mouseEvent.getY() & mouseEvent.getY()< tempGuessWhoButton.getPositionY()+ tempGuessWhoButton.getHeight()) {
                            if(tempGuessWhoButton.getPressed() == false) {
                                setButtonState(tempGuessWhoButton);
                                disableButtons();
                                if(checkWinner(tempGuessWhoButton)){
                                    System.out.println("YOU WIN!!!!");
                                    GuessWho.super.showDialog("Player Wins!!");
                                    int playerTurn=(int)GuessWho.super.getSceneDirector().getGameLog().get("PlayerTurn");
                                    GuessWho.super.getSceneDirector().getPlayerList().get(playerTurn).setCurrentNodeState(1);
                                    stop();
                                }else{
                                    System.out.println("YOU LOSE :(");
                                    GuessWho.super.showDialog("Player Lose!!");
                                    int playerTurn=(int)GuessWho.super.getSceneDirector().getGameLog().get("PlayerTurn");
                                    GuessWho.super.getSceneDirector().getPlayerList().get(playerTurn).setCurrentNodeState(-1);
                                    stop();
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

        NodeType type;
        double x;
        double y;
        for(int row = 0; row<15;row++){
            type = selectCharacter(row+1);
           // type = this.buttonsSelectionList.get(row).getType();
            x = this.buttonsSelectionList.get(row).getPositionX();
            y = this.buttonsSelectionList.get(row).getPositionY();
            drawCharacterName(type,x,y);
        }
    }

    public boolean checkWinner(Button button){
        if(button.getValue() == 1){
            return true;
        }else{
          return false;
        }
    }


    public void disableButtons(){
        for(int row = 0; row<15;row++){
            this.buttonsSelectionList.get(row).setPressed(true);
        }
    }

    public void setButtonState(Button node){
        System.out.println("STATE:"+ node.getValue());
        if (node.getValue() == 1){
            if(node.getPressed() == false){
                node.setType(NodeType.GUESSBUTTONCORRECT);
                node.setPressed(true);
            }
        }else if (node.getValue() == -1){
            if(node.getPressed() == false) {
                node.setType(NodeType.GUESSBUTTONINCORRECT);
                node.setPressed(true);
            }
        }else{
            System.out.println("ESTADO INVALIDO");
        }
    }


    private NodeType selectCharacter(int Character){
        switch (Character) {
            case 1:
                return NodeType.BOO;
            case 2:
                return NodeType.BOWSER;
            case 3:
                return NodeType.DAISY;
            case 4:
                return NodeType.DIDDYKONG;
            case 5:
                return NodeType.DONKEYKONG;
            case 6:
                return NodeType.DRYBONES;
            case 7:
                return NodeType.GOOMBA;
            case 8:
                return NodeType.KOOPA;
            case 9:
                return NodeType.LUIGI;
            case 10:
                return NodeType.MARIO;
            case 11:
                return NodeType.PEACH;
            case 12:
                return NodeType.TOAD;
            case 13:
                return NodeType.WALUIGI;
            case 14:
                return NodeType.WARIO;
            case 15:
                return NodeType.YOSHI;
            default:
                return NodeType.CAJA;
        }
    }

    public void drawCharacterName(NodeType type,double x,double y){
        super.getSceneController().getDrawer().setFont(new Font("AR DARLING", 20));
        super.getSceneController().getDrawer().setFill(Color.BLACK);
        super.getSceneController().getDrawer().fillText(type.name() , x+35 , y+20 ,200);
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
