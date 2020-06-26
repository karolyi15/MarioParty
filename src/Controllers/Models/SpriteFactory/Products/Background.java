package Controllers.Models.SpriteFactory.Products;

import Controllers.Models.SceneBuilder.GameType;
import Controllers.Models.SpriteFactory.Sprite;
import javafx.scene.canvas.GraphicsContext;


public class Background extends Sprite implements iBackground{

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private GameType type;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //Constructor
    public Background(GameType type) {

        //Constructor
        super(type.getImgFilePath());
        //Render System
        this.type = type;

    }


    @Override
    public void update(GraphicsContext drawer) {
        drawer.drawImage(super.getImage(), super.getPositionX(), super.getPositionY(), drawer.getCanvas().getWidth(), drawer.getCanvas().getHeight(), 0, 0, drawer.getCanvas().getWidth(), drawer.getCanvas().getHeight());
    }




}