package Controllers.Models.SpriteFactory.Products;

import Controllers.Models.SpriteFactory.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class Character extends Sprite implements iCharacter{

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private CharacterType type;

    //Animation System


    //Physics System
    private double[] speed;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//


    //Constructor
    public Character(CharacterType type){

        //Constructor
        super(type.getImgPath());

        //Render System
        this.type=type;

        //Physics System
        this.speed=new double[2];
    }


    //Render System
    @Override
    public void update(GraphicsContext drawer){
        drawer.drawImage(super.getImage(),67,309,31,34,super.getPositionX(),super.getPositionY(),46.5,51);
    }


}