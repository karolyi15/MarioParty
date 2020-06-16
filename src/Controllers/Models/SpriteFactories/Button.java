package Controllers.Models.SpriteFactories;

import Controllers.Models.GameFactories.PootyImages;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Button  implements iSprite {


    //Render System
    Image image;
    double width;
    double height;
    private PootyImages type;

    //Physics System
    double[] position;
    double[] speed;
    //
    private Boolean pressed;
    private int value;

    public Button(double width,double height){
        this.width=width;
        this.height=height;
        this.type=PootyImages.CAJA;
        this.position=new double[2];
        this.setPosition(0,0);
        image=new Image(type.getImagen(),width,height,false,false);
        this.value=0;
        this.pressed=false;

    }

    public Boolean getPressed() {
        return pressed;
    }

    public void setPressed(Boolean pressed) {
        this.pressed = pressed;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setState(int state){
        if (state == 1){
            if(pressed == false){
                this.type=PootyImages.TTTO;
                image=new Image(type.getImagen(),width,height,false,false);
                pressed = true;
                this.value=1;
                //this.setDisabled(true);
            }}}

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setPosition(double positionX, double positionY){
        this.position[0]=positionX;
        this.position[1]=positionY;
    }

    public double[] getPosition() {
        return position;
    }

    public void update(GraphicsContext drawer){
        drawer.drawImage(image,position[0],position[1]);

    }

    public Rectangle2D getBoundary(){
        return new Rectangle2D(this.position[0],this.position[1],this.width,this.height);
    }
    public boolean collide(iSprite tempSprite){
        return false;
    }

}
