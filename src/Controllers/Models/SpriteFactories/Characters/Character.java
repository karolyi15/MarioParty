package Controllers.Models.SpriteFactories.Characters;

import Controllers.Models.SpriteFactories.iSprite;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Character implements iSprite {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private Image image;
    private double width;
    private double height;
    private CharacterType type;

    //Animation System


    //Physics System
    private double[] position;
    private double[] speed;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//


    //Constructor
    public Character(CharacterType type){

        //Render System
        this.type=type;
        this.image=new Image(type.getImgPath());
        this.width=image.getWidth();
        this.height=image.getHeight();

        //Physics System
        this.position=new double[2];
        this.speed=new double[2];
    }

    //Positioning System
    @Override
    public void setPosition(double positionX, double positionY){
        this.position[0]=positionX-350-24;
        this.position[1]=positionY-1400-34;
    }
    @Override
    public double[] getPosition() {
        return position;
    }

    //Render System
    @Override
    public void update(GraphicsContext drawer){
        drawer.drawImage(image,67,309,31,34,position[0],position[1],46.5,51);
    }

    @Override
    public double getWidth(){
        return this.width;
    }

    @Override
    public double getHeight(){
        return this.height;
    }

    //Collide System
    @Override
    //Collides System
    public Rectangle2D getBoundary(){

        return new Rectangle2D(this.position[0],this.position[1],this.width,this.height);
    }

    @Override
    public boolean collide(iSprite tempSprite){
        return tempSprite.getBoundary().intersects(this.getBoundary());
    }
}
