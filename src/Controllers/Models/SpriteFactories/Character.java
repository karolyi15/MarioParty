package Controllers.Models.SpriteFactories;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Character implements iSprite{

    //********************************************* Class Fields ***********************************************//


    //Render System
    Image image;
    double width;
    double height;
    private CharacterType type;

    //Physics System
    double[] position;
    double[] speed;



    //********************************************* Class Methods **********************************************//


    //********** Constructors **********//

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

    @Override
    public void setPosition(double positionX, double positionY){
        this.position[0]=positionX-350-24;
        this.position[1]=positionY-1400-34;
    }
    public double[] getPosition() {
        return position;
    }

    @Override
    public void update(GraphicsContext drawer){
        drawer.drawImage(image,67,309,31,34,position[0],position[1],46.5,51);

    }

    @Override
    //Collides System
    public Rectangle2D getBoundary(){
        return new Rectangle2D(this.position[0],this.position[1],this.width,this.height);
    }

    @Override
    public boolean collide(iSprite tempSprite){
        return false;
    }
}
