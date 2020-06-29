package Controllers.Models.SpriteFactory.Products;


import Controllers.Models.SpriteFactory.Sprite;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.GraphicsContext;


public class Button extends Sprite implements iButton {


    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private String id;
    private StringProperty text;
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

        //Render System
        this.id="";
        this.text=new SimpleStringProperty("");

        //Handle System
        this.value=0;
        this.pressed=false;

    }
    public Button(NodeType type,double positionX, double positionY){

        super(type.getImage());
        this.type=type;
        super.setPosition(positionX,positionY);
        //super.getImgSection((int)type.getPositionX(),(int)type.getPositionY(),(int)type.getWidth(),(int)type.getHeight());

        //Render System
        this.id="";
        this.text=new SimpleStringProperty("");

        //Handle System
        this.value=0;
        this.pressed=false;

    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StringProperty getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    //Render System

    @Override
    public void update(GraphicsContext drawer){

        drawer.drawImage(super.getImage(),type.getPositionX(),type.getPositionY(),type.getWidth(),type.getHeight(),super.getPositionX(),super.getPositionY(),super.getWidth(),super.getHeight());
        //drawer.fillText(this.text.getValue(),super.getPositionX(),super.getPositionY(),super.getWidth());

    }

    public void setType(NodeType type) {

        this.type = type;
        super.setImage(type.getImage());
        //super.getImgSection((int)type.getPositionX(),(int)type.getPositionY(),(int)type.getWidth(),(int)type.getHeight());
        //super.getImgSection((int)type.getPositionX(),(int)type.getPositionY(),(int)type.getWidth(),(int)type.getHeight());
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


}
