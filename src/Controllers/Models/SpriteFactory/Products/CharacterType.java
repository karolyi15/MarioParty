package Controllers.Models.SpriteFactory.Products;

public enum CharacterType {

    //********************************************************************************************************************//
    //************************************************* ENUM TYPES *******************************************************//

    //Characters Type
    MARIO("file:Resources/Imgs/Characters/Mario_Img.png"),
    LUIGI("file:Resources/Imgs/Characters/Luigi_Img.png"),
    YOSHI("file:Resources/Imgs/Characters/Yoshi_Img.png"),
    PEACH("file:Resources/Imgs/Characters/Peach_Img.png"),

    WARIO("file:Resources/Imgs/Characters/Mario_Img.png"),
    WALUIGI("file:Resources/Imgs/Characters/Luigi_Img.png"),
    DAISY("file:Resources/Imgs/Characters/Peach_Img.png"),
    YOSHIBLUE("file:Resources/Imgs/Characters/Yoshi_Img.png");

    //********************************************************************************************************************//
    //************************************************ ENUM FIELDS *******************************************************//

    //Img File Path
    private String imgFilePath;

    //********************************************************************************************************************//
    //************************************************ ENUM METHODS ******************************************************//

    //Constructor
    CharacterType(String imgFilePath){
        this.imgFilePath = imgFilePath;
    }

    //Setters and Getters
    public String getImgPath() {
        return imgFilePath;
    }
}
