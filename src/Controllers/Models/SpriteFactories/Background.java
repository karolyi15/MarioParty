package Controllers.Models.SpriteFactories;

import Controllers.Models.GameFactories.GameType;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Background implements iSprite{

    //Render System
    Image image;
    double width;
    double height;
    private GameType type;

    //Physics System
    double[] position;

    public Background(GameType type){
        //Render System
        this.type=type;
        this.image=new Image(type.getImgFilePath());
        this.width=image.getWidth();
        this.height=image.getHeight();

        //Physics System
        this.position=new double[2];
    }

    @Override
    public void setPosition(double positionX, double positionY){
        this.position[0]=positionX;
        this.position[1]=positionY;

    }
    @Override
    public void update(GraphicsContext drawer){
        drawer.drawImage(image,position[0],position[1]);

    }
    @Override
    public Rectangle2D getBoundary(){
        return new Rectangle2D(this.position[0],this.position[1],this.width,this.height);
    }
    @Override
    public boolean collide(iSprite tempSprite){
        return false;
    }
}
