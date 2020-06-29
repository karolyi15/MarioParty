package Controllers.Models.SceneBuilder.Products;

import Controllers.Models.SceneBuilder.GameScene;
import Controllers.Models.SceneBuilder.SceneType;
import Controllers.Models.SpriteFactory.Products.Button;
import Controllers.Models.SpriteFactory.Sprite;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class TitleScene extends GameScene {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//




    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//


    //Constructor
    public TitleScene(){

        super(SceneType.TITLEMENU);

    }

    //Init Scene Components

    @Override
    public void initGameComponents(){


       this.initSprites();
       this.initGameLogo();
       this.initUiElements();
    }

    private void initUiElements(){

        //Init Buttons
        Button startButton =new Button(200,400);
        startButton.setId("Start");
        startButton.setText("Start");
        startButton.resizeImage(300,50);

        super.getButtonsList().add(startButton);
        super.getGameComponents().add(startButton);
    }

    private void initGameLogo(){

        //Init Logo
        Sprite titleLogo=new Sprite("file:Resources/Imgs/Backgrounds/Title_Img.png");
        titleLogo.getImgSection(157,236,213,40);
        titleLogo.resizeImage(569,110);
        titleLogo.setPosition(65.5,50);
        super.getGameComponents().add(titleLogo);

    }


    private void initSprites(){

        //Mario
        Sprite mario=new Sprite("file:Resources/Imgs/Characters/Mario_Img.png");
        mario.getImgSection(81,241,20,29);
        mario.resizeImage(49,75);
        mario.setPosition(150,300);
        super.getGameComponents().add(mario);

        //Luigi
        Sprite luigi=new Sprite("file:Resources/Imgs/Characters/Luigi_Img.png");
        luigi.getImgSection(68,254,15,34);
        luigi.resizeImage(37,85);
        luigi.setPosition(200,300);
        super.getGameComponents().add(luigi);

        //Peach
        Sprite peach=new Sprite("file:Resources/Imgs/Characters/Peach_Img.png");
        peach.getImgSection(684,1374,40,30);
        peach.resizeImage(100,79);
        peach.setPosition(450,200);
        super.getGameComponents().add(peach);

        //Yoshi
        Sprite yoshi=new Sprite("file:Resources/Imgs/Characters/Yoshi_Img.png");
        yoshi.getImgSection(68,308,30,36);
        yoshi.resizeImage(75,85);
        yoshi.setPosition(325,310);
        super.getGameComponents().add(yoshi);

        //Balloons
        Sprite blue=new Sprite("file:Resources/Imgs/Backgrounds/Title_Img.png");
        blue.getImgSection(9,9,19,40);
        blue.resizeImage(47,100);
        blue.setPosition(100,200);
        super.getGameComponents().add(blue);

        Sprite rose=new Sprite("file:Resources/Imgs/Backgrounds/Title_Img.png");
        rose.getImgSection(32,9,19,40);
        rose.resizeImage(47,100);
        rose.setPosition(45,300);
        super.getGameComponents().add(rose);

        Sprite green=new Sprite("file:Resources/Imgs/Backgrounds/Title_Img.png");
        green.getImgSection(76,9,19,40);
        green.resizeImage(47,100);
        green.setPosition(300,250);
        super.getGameComponents().add(green);

        Sprite yellow=new Sprite("file:Resources/Imgs/Backgrounds/Title_Img.png");
        yellow.getImgSection(54,9,19,40);
        yellow.resizeImage(47,100);
        yellow.setPosition(615,230);
        super.getGameComponents().add(yellow);

        //Tubes
        Sprite tubeBlue=new Sprite("file:Resources/Imgs/UI Elements/UI_Elements.png");
        tubeBlue.getImgSection(8,1335,25,30);
        tubeBlue.resizeImage(85,85);
        tubeBlue.setPosition(550,350);
        super.getGameComponents().add(tubeBlue);

    }


    //Event Handling System
    @Override
    public void handleMouseEvents(){

        super.getSceneController().getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                for(int element = 0; element< TitleScene.super.getButtonsList().size(); element++){

                    Button tempButton= (Button) TitleScene.super.getButtonsList().get(element);

                    if(tempButton.getPositionX()<=mouseEvent.getX() & mouseEvent.getX()<=tempButton.getPositionX()+tempButton.getWidth()){
                        if(tempButton.getPositionY()<mouseEvent.getY() & mouseEvent.getY()<tempButton.getPositionY()+tempButton.getHeight())
                           stop();

                    }
                }



            }
        });
    }

    @Override
    public void stop(){
        super.getMusicPlayer().stop();
        super.getGameLoop().stop();
        super.getSceneDirector().buildMainGame();
    }

}
