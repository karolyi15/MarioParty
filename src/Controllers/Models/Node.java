package Controllers.Models;

public class Node {

    private double[] position={0,0};

    public Node(double positionX, double positionY){
        this.position[0]=positionX;
        this.position[1]=positionY;
    }

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
}
