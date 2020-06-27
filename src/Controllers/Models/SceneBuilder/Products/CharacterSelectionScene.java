package Controllers.Models.SceneBuilder.Products;

import Controllers.Models.SceneBuilder.MiniGame;
import Controllers.Models.SpriteFactory.Products.Button;
import Controllers.Models.SpriteFactory.Products.Node;

public class CharacterSelectionScene extends MiniGame {



    //Constructor
    public CharacterSelectionScene(){

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






}
