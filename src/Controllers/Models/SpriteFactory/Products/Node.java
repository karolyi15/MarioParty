package Controllers.Models.SpriteFactory.Products;

import Controllers.Models.SpriteFactory.Sprite;
import javafx.scene.image.Image;

public class Node extends Sprite implements iButton {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private NodeType type;

    //Handle System
    private int value;
    private Boolean pressed;

    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //Constructor
    public Node(double positionX,double positionY){

        super(NodeType.CAJA.getImage());
        super.setPosition(positionX,positionY);

        //Render System
        this.type=NodeType.CAJA;

        //Handle System
        this.value=0;
        this.pressed=false;

    }

    //Render System
    public void setType(NodeType type) {
        this.type = type;
        super.setImage(type.getImage());
    }

    public NodeType getType(){
        return this.type;
    }


    //Handle System
    public void setPressed(Boolean pressed) {
        this.pressed = pressed;
    }
    public Boolean getPressed() {
        return pressed;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }



}
