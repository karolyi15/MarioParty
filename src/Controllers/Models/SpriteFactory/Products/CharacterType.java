package Controllers.Models.SpriteFactory.Products;

public enum CharacterType {

    //********************************************************************************************************************//
    //************************************************* ENUM TYPES *******************************************************//

    //Characters Type
    MARIO("file:Resources/Imgs/Characters/Mario_Img.png",67,309,31,34),
    LUIGI("file:Resources/Imgs/Characters/Luigi_Img.png",68,324,31,36),
    YOSHI("file:Resources/Imgs/Characters/Yoshi_Img.png",67,308,31,35),
    PEACH("file:Resources/Imgs/Characters/Peach_Img.png",67,338,31,36),

    WARIO("file:Resources/Imgs/Characters/Wario_Img.png",67,309,31,34),
    WALUIGI("file:Resources/Imgs/Characters/Waluigi_Img.png",68,324,31,36),
    DAISY("file:Resources/Imgs/Characters/Daisy_Img.png",67,338,31,36),
    YOSHIBLUE("file:Resources/Imgs/Characters/YellowYoshi_Img.png",67,308,31,35);

    //********************************************************************************************************************//
    //************************************************ ENUM FIELDS *******************************************************//

    //Img File Path
    private String imgFilePath;

    private final double positionX;
    private final double positionY;
    private final double width;
    private final double height;

    //********************************************************************************************************************//
    //************************************************ ENUM METHODS ******************************************************//

    //Constructor
    CharacterType(String imgFilePath,double positionX, double positionY, double width, double height){
        this.imgFilePath = imgFilePath;
        this.positionX=positionX;
        this.positionY=positionY;

        this.width=width;
        this.height=height;
    }

    //Setters and Getters
    public String getImgPath() {
        return imgFilePath;
    }
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
