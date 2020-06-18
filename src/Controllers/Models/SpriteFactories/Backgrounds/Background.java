package Controllers.Models.SpriteFactories.Backgrounds;

import Controllers.Models.GameFactories.GameType;
import Controllers.Models.SpriteFactories.iSprite;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Background implements iSprite {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private Image image;
    private double width;
    private double height;
    private GameType type;

    //Physics System
    private double[] position;

    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //Constructor
    public Background(GameType type){

        //Render System
        this.type=type;
        this.image=new Image(type.getImgFilePath());
        this.width=image.getWidth();
        this.height=image.getHeight();

        //Physics System
        this.position=new double[2];
    }

    //Positioning System
    @Override
    public void setPosition(double positionX, double positionY){
        this.position[0]=positionX;
        this.position[1]=positionY;

    }
    @Override
    public double[] getPosition() {
        return position;
    }

    //Render System
    public void resize(double width,double height){
        this.width=width;
        this.height=height;
        this.image=new Image(type.getImgFilePath(),this.width,this.height,false,false);
    }

    @Override
    public void update(GraphicsContext drawer){
        drawer.drawImage(image,position[0],position[1],drawer.getCanvas().getWidth(),drawer.getCanvas().getHeight(),0,0,drawer.getCanvas().getWidth(),drawer.getCanvas().getHeight());
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
    public Rectangle2D getBoundary(){
        return new Rectangle2D(this.position[0],this.position[1],this.width,this.height);
    }
    @Override
    public boolean collide(iSprite tempSprite){
        return tempSprite.getBoundary().intersects(this.getBoundary());
    }
}
