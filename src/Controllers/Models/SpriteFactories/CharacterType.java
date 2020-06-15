package Controllers.Models.SpriteFactories;

public enum CharacterType {


    MARIO("file:Resources/Imgs/Characters/Mario_Img.png"),
    LUIGI("file:Resources/Imgs/Characters/Luigi_Img.png"),
    YOSHI("file:Resources/Imgs/Characters/Yoshi_Img.png"),
    PEACH("file:Resources/Imgs/Characters/Peach_Img.png"),

    WARIO("file:Resources/Imgs/Characters/Mario_Img.png"),
    WALUIGI("file:Resources/Imgs/Characters/Luigi_Img.png"),
    DAISY("file:Resources/Imgs/Characters/Peach_Img.png"),
    YOSHIBLUE("file:Resources/Imgs/Characters/Yoshi_Img.png");

    private String filePath;

    CharacterType(String filePath){
        this.filePath=filePath;
    }

    public String getImgPath() {
        return filePath;
    }
}
