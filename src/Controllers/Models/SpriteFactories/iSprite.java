package Controllers.Models.SpriteFactories;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

public interface iSprite {

    //********************************************************************************************************************//
    //********************************************* INTERFACE METHODS ****************************************************//

    //Positioning System
    public void setPosition(double positionX, double positionY);
    public double[] getPosition();

    //Render System
    public void update(GraphicsContext drawer);
    public double getWidth();
    public double getHeight();

    //Collide System
    public Rectangle2D getBoundary();
    public boolean collide(iSprite tempSprite);

}
