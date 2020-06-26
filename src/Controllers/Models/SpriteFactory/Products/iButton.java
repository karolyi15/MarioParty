package Controllers.Models.SpriteFactory.Products;

public interface iButton {

    //Render System
    public void setType(NodeType type);
    public NodeType getType();

    //Handle System
    public void setPressed(Boolean pressed);
    public Boolean getPressed();

    public void setValue(int value);
    public int getValue();
}
