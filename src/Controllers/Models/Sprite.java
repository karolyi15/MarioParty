package Controllers.Models;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public class Sprite {

    //********************************************* Class Fields ***********************************************//

    //Animation System
    Image image;

    //Dimension System
    double width;
    double height;

    //Physics System
    double[] position={0,0};
    double[] speed={0,0};


    //********************************************* Class Methods **********************************************//

    //********** Constructors **********//
    public Sprite (String imgPath){

        this.image=new Image(imgPath);

        this.width=this.image.getWidth();
        this.height=this.image.getHeight();

    }

    public Sprite(String imgPath,double positionX,double positionY){

        this.image=new Image(imgPath);

        this.position[0]=positionX;
        this.position[1]=positionY;

        this.width=this.image.getWidth();
        this.height=this.image.getHeight();
    }

    public Sprite(String imgPath,double positionX,double positionY,double speedX,double speedY){

        this.image=new Image(imgPath);

        this.position[0]=positionX;
        this.position[1]=positionY;

        this.speed[0]=speedX;
        this.speed[1]=speedY;

        this.width=this.image.getWidth();
        this.height=this.image.getHeight();
    }

    //Render System

    public void update(double time){
        this.position[0]=this.speed[0]*time;
        this.position[1]=this.speed[1]*time;
    }

    public void render(){

    }

    //Collides System
    public Rectangle2D getBoundary(){
        return new Rectangle2D(this.position[0],this.position[1],this.width,this.height);
    }

    public boolean collide(Sprite tempSprite){
        return true;
    }
}
