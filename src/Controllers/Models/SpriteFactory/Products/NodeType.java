package Controllers.Models.SpriteFactory.Products;

public enum NodeType {

    //Board Cells
    PRISON("",0,0,0,0),
    TUBE("",0,0,0,0),
    STAR("",0,0,0,0),
    FIRE("",0,0,0,0),
    ICE("",0,0,0,0),
    TAIL("",0,0,0,0),
    DEFAULT("",0,0,0,0),

    //Button State
    DEFAULTBUTTON("file:Resources/Imgs/UI Elements/UI_Elements.png",57,1114,85,25),

    //UI
    TEXTAREA("file:Resources/Imgs/UI Elements/UI_Elements.png",4,1201,182,42),

    //Tic Tac Toe Nodes
    CAJA ("file:Resources/Imgs/UI Elements/Caja.jpeg",0,0,0,0),
    TTTO ("file:Resources/Imgs/UI Elements/TTTO.jpeg",0,0,0,0),
    TTTX("file:Resources/Imgs/UI Elements/TTTX.jpeg",0,0,0,0),

    //Catch Boo Nodes
    TUMB("file:Resources/Imgs/Characters/Boo_Img.png",145,107,33,30),
    TUMBX("file:Resources/Imgs/Characters/Boo_Img.png",215,107,33,30),


    //Memory Path Nodes
    MEMORYPATHEMPTYTABLE("file:Resources/Imgs/UI Elements/MemoryPathTable1.png",0,0,0,0),
    MEMORYPATHCORRECTTABLE("file:Resources/Imgs/UI Elements/MemoryPathCorrectTable.png",0,0,0,0),
    MEMORYPATHINCORRECTTABLE("file:Resources/Imgs/UI Elements/MemoryPathIncorrectTable.png",0,0,358,407),

    TABLE("",0,0,0,0);



    private final String image;
    private final double positionX;
    private final double positionY;
    private final double width;
    private final double height;

    //Constructor
    NodeType(String imgPath, double positionX, double positionY, double width, double height) {

        this.image = imgPath;

        this.positionX=positionX;
        this.positionY=positionY;

        this.width=width;
        this.height=height;

    }

    //Setters and Getters
    public String getImage() { return image; }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }




}
