package Controllers.Models.SpriteFactory.Products;

public enum NodeType {

    //Board Cells
    PRISON(""),
    TUBE(""),
    STAR(""),
    FIRE(""),
    ICE(""),
    TAIL(""),
    DEFAULT(""),

    //Button State
    DEFAULTBUTTON("file:Resources/Imgs/UI Elements/DefaultButton_Img.png"),

    //UI
    CAJA ("file:Resources/Imgs/UI Elements/Caja.jpeg"),
    TTTO ("file:Resources/Imgs/UI Elements/TTTO.jpeg"),
    TTTX("file:Resources/Imgs/UI Elements/TTTX.jpeg");



    private final String image;

    NodeType(String imgPath) {
        this.image = imgPath;

    }



    public String getImage() { return image; }



}
