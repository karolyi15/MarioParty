package Controllers.Models.SpriteFactories;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

public interface iSprite {

    public void setPosition(double positionX, double positionY);
    public void update(GraphicsContext drawer);
    public Rectangle2D getBoundary();
    public boolean collide(iSprite tempSprite);

}
