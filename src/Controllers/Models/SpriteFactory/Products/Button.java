package Controllers.Models.SpriteFactory.Products;


import Controllers.Models.SpriteFactory.Sprite;


public class Button extends Sprite implements iButton {


    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private NodeType type;

    //Handle System
    private int value;
    private Boolean pressed;

    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //Constructors
    public Button(double positionX, double positionY){

        super(NodeType.DEFAULTBUTTON.getImage());
        this.type=NodeType.DEFAULTBUTTON;
        super.setPosition(positionX,positionY);

        //Handle System
        this.value=0;
        this.pressed=false;

    }

    //Render System
    public void setType(NodeType type) {
        this.type = type;
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
