package Controllers.Models.SceneBuilder.Products;


import Controllers.Models.Player;
import Controllers.Models.SceneBuilder.GameScene;
import Controllers.Models.SceneBuilder.SceneType;
import Controllers.Models.SpriteFactory.Products.Button;
import Controllers.Models.SpriteFactory.Products.NodeType;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


import java.util.ArrayList;

public class CharacterSelection extends GameScene {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    ArrayList<NodeType> openSet;
    Button[] buttons;
    Button[] portraits;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //Constructor
    public CharacterSelection(){

        super(SceneType.CHARACTERSELECTIONMENU);
    }


    @Override
    public void initGameComponents(){

        //Init Character Selection System
        this.buttons=new Button[6];
        this.portraits=new Button[6];

        this.initOpenSet();
        this.initPortraits();
        this.initButtons();

        this.sortButtons(this.portraits,115,75,175,3);
        this.sortButtons(this.buttons,115,180,175,2);

    }

    private void initOpenSet(){
        //Init Open Set
        this.openSet=new ArrayList<>();

        //Add Characters Portrait
        this.openSet.add(NodeType.UNKNOWNPORTRAIT);
        this.openSet.add(NodeType.MARIOPORTRAIT);
        this.openSet.add(NodeType.LUIGIPORTRAIT);
        this.openSet.add(NodeType.PEACHPORTRAIT);
        this.openSet.add(NodeType.YOSHIPORTRAIT);
        this.openSet.add(NodeType.WALUIGIPORTRAIT);
        this.openSet.add(NodeType.WARIOPORTRAIT);
        this.openSet.add(NodeType.DAISYPORTRAIT);
        this.openSet.add(NodeType.YELLOWYOSHIPORTRAIT);
    }

    private void changePortrait(Button button){
        button.setValue(button.getValue()+1);
        if(button.getValue()>=this.openSet.size()){
            button.setValue(0);
        }
        button.setType(this.openSet.get(button.getValue()));
    }

    private void initPortraits(){

        for(int portrait=0;portrait<this.portraits.length;portrait++){
            Button tempPortrait = new Button(NodeType.UNKNOWNPORTRAIT, 0, 0);
            tempPortrait.resizeImage(100, 100);
            this.portraits[portrait]=tempPortrait;
            super.getGameComponents().add(tempPortrait);
        }

    }

    private void initButtons(){
        for(int button=0;button<this.portraits.length;button++){
            Button tempButton = new Button(0, 0);
            tempButton.resizeImage(100,25);
            tempButton.setId("Player"+String.valueOf(0));
            tempButton.setText("Select");
            this.buttons[button]=tempButton;
            super.getGameComponents().add(tempButton);
        }

        Button startButton=new Button(540,440);
        startButton.resizeImage(100,35);
        startButton.setText("Start Game");
        startButton.setId("StartGame");
        super.getGameComponents().add(startButton);
        super.getButtonsList().add(startButton);
    }



    private void sortButtons(Button[] buttonList, int consX, int consY, int multX, int multY){

        int len=buttonList.length;
        for(int row=0;row<len/2;row++){
            buttonList[row].setPosition(consX+multX*row,consY);
        }

        for(int column=len/2;column<len;column++){
            buttonList[column].setPosition(consX+multX*(column-len/2),consY*multY);
        }

    }


    @Override
    public void handleMouseEvents(){
       super.getSceneController().getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //Start Game Button
                Button startButton=(Button)CharacterSelection.super.getButtonsList().get(0);
                if(startButton.getPositionX()<=mouseEvent.getX() & mouseEvent.getX()<=startButton.getPositionX()+startButton.getWidth())
                {
                    if (startButton.getPositionY() < mouseEvent.getY() & mouseEvent.getY() < startButton.getPositionY() + startButton.getHeight())
                        verifyPlayers();

                }else {
                    //Change Portrait Buttons
                    for (int button = 0; button < buttons.length; button++) {
                        Button tempButton = buttons[button];
                        if (tempButton.getPositionX() <= mouseEvent.getX() & mouseEvent.getX() <= tempButton.getPositionX() + tempButton.getWidth()) {
                            if (tempButton.getPositionY() < mouseEvent.getY() & mouseEvent.getY() < tempButton.getPositionY() + tempButton.getHeight()) {

                                changePortrait(portraits[button]);

                            }
                        }

                    }
                }


            }
        });

    }

    private void verifyPlayers(){
        int activePlayer=0;

        for(int player=0;player<portraits.length;player++){
            if(this.portraits[player].getType()!=NodeType.UNKNOWNPORTRAIT){
                activePlayer++;
            }
        }

        if(activePlayer>=2 & verifyCharacter()){
            this.stop();
        }else{
            System.out.println("No hay suficientes jugadores o personajes repetidos");
        }
    }

    private boolean verifyCharacter(){

       for(int player=0;player<portraits.length;player++){

           int present=0;
           //System.out.println(present);
           Button tempPlayer=portraits[player];
           if(tempPlayer.getType()!=NodeType.UNKNOWNPORTRAIT) {
               for (int character = 0; character < portraits.length; character++) {

                   if (tempPlayer.getType() == this.portraits[character].getType()) {
                       present++;

                   }

               }
               if (present >= 2) {
                   return false;
               }
           }
       }

        return true;
    }

   private void createPlayers(){
        ArrayList<Player> tempPlayerList=new ArrayList<>();

        for(int player=0;player<portraits.length;player++){

            Button tempPlayer=this.portraits[player];

            if(tempPlayer.getType()!=NodeType.UNKNOWNPORTRAIT){
               tempPlayerList.add(new Player(tempPlayer.getType()));
            }

        }
        super.getSceneDirector().setPlayerList(tempPlayerList);
    }

    @Override
    public void stop(){

        //Stops Game Execution
        super.getMusicPlayer().stop();
        super.getGameLoop().stop();

        //Load Main Game
        this.createPlayers();
        super.getSceneDirector().buildMainGame();
    }




}
