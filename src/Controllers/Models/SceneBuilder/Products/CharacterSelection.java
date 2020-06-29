package Controllers.Models.SceneBuilder.Products;

import Controllers.Models.SceneBuilder.GameScene;
import Controllers.Models.SceneBuilder.SceneType;
import Controllers.Models.SpriteFactory.Products.Button;
import Controllers.Models.SpriteFactory.Products.Node;

public class CharacterSelection extends GameScene {



    //Constructor
    public CharacterSelection(){
        super(SceneType.CHARACTERSELECTIONMENU);
    }


    @Override
    public void initGameComponents(){

        //Init UI Components
        Button startButton=new Button(100,100);
        startButton.setId("Start");
        startButton.setText("Start");

        for(int counter=0;counter<8;counter++){
            Node tempNode =new Node(100,100);

        }

    }


    @Override
    public void handleMouseEvents(){

    }

    @Override
    public void stop(){
        super.getMusicPlayer().stop();
        super.getGameLoop().stop();
        super.getSceneDirector().buildMainGame();
    }




}
