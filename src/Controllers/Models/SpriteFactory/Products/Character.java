package Controllers.Models.SpriteFactory.Products;

import Controllers.Models.SpriteFactory.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class Character extends Sprite {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private CharacterType type;

    //Animation System



    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//


    //Constructor
    public Character(CharacterType type){

        //Constructor
        super(type.getImgPath());

        //Render System
        this.type=type;


    }


    //Render System
    @Override
    public void update(GraphicsContext drawer){
        drawer.drawImage(super.getImage(),type.getPositionX(),type.getPositionY(),type.getWidth(),type.getHeight(),super.getPositionX()-24,super.getPositionY()-34,46.5,51);
    }


}
