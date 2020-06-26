package Controllers.Models.SceneBuilder.Products;

import Controllers.Models.SceneBuilder.MiniGame;
import Controllers.Models.SpriteFactory.Products.Button;
import Controllers.Models.SpriteFactory.Products.Node;
import Controllers.Models.SpriteFactory.Sprite;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class TitleScene extends MiniGame {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//




    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//


    //Constructor
    public TitleScene(){

    }

    @Override
    public void initGameComponents(){

        //Init Logo
        Sprite titleLogo=new Sprite("file:Resources/Imgs/Backgrounds/TitleLogo.png");
        titleLogo.resizeImage(569,110);
        titleLogo.setPosition(65.5,50);

        super.getGameComponents().add(titleLogo);

        //Init Start Button
        Button startButton =new Button(200,400);
        startButton.resizeImage(300,50);

        super.getButtonsList().add(startButton);
        super.getGameComponents().add(startButton);

        //Init Decoration
        Sprite mario=new Sprite("file:Resources/Imgs/Characters/Mario_Img.png");
        mario.getImgSection(81,241,19,29);
        mario.resizeImage(41,50);
        mario.setPosition(100,100);


        super.getGameComponents().add(mario);

    }

    //Event Handling System
    @Override
    public void handleMouseEvents(){

        super.getSceneController().getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                for(int element = 0; element< TitleScene.super.getButtonsList().size(); element++){

                    Node tempButton= (Node)TitleScene.super.getButtonsList().get(element);

                    if(tempButton.getPositionX()<=mouseEvent.getX() & mouseEvent.getX()<=tempButton.getPositionX()+tempButton.getWidth()){
                        if(tempButton.getPositionY()<mouseEvent.getY() & mouseEvent.getY()<tempButton.getPositionY()+tempButton.getHeight())
                           System.out.println("Click");

                    }
                }



            }
        });
    }

}
