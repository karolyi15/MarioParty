package Controllers.Models.SpriteFactories;

public class Node {

    //Fields
    private double[] position={0,0};
    private NodeType type;

    //Constructors
    public Node(double positionX, double positionY){
        this.position[0]=positionX;
        this.position[1]=positionY;
        this.type=NodeType.STANDARD;
    }

    public Node(double positionX, double positionY,NodeType type){
        this.position[0]=positionX;
        this.position[1]=positionY;
        this.type=type;
    }

    //Setters and Getters
    public double getPositionX(){
        return position[0];
    }
    public double getPositionY(){
        return position[1];
    }

    public double[] getPosition() {
        return position;
    }
    public void setPosition(double[] position) {
        this.position = position;
    }

    public NodeType getType(){
        return this.type;
    }
}
