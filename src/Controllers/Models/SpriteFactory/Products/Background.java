package Controllers.Models.SpriteFactory.Products;

import Controllers.Models.SceneBuilder.SceneType;
import Controllers.Models.SpriteFactory.Sprite;
import javafx.scene.canvas.GraphicsContext;


public class Background extends Sprite implements iBackground{

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private SceneType type;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //Constructor
    public Background(SceneType type) {

        //Constructor
        super(type.getImgFilePath());

        //Render System
        this.type = type;

        //Set Up Configuration
        this.setUp();
    }


    private void setUp(){

        switch (this.type){
            case TITLEMENU:
                this.setPosition(482,5);
                break;
            case BOARD:
                this.setPosition(350,1400);
                break;
            case TICTACTOE:
                break;
            case MEMORYPATH:
                this.setPosition(50,0);
                break;
            case CATCHCAT:
                this.setPosition(25,0);
                break;
            case CARDS:
                this.setPosition(2,0);
                break;

        }
    }

    @Override
    public void update(GraphicsContext drawer) {
        drawer.drawImage(super.getImage(), super.getPositionX(), super.getPositionY(), drawer.getCanvas().getWidth(), drawer.getCanvas().getHeight(), 0, 0, 700, 500);
    }


}