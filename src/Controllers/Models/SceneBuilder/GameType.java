package Controllers.Models.SceneBuilder;

public enum GameType {

    //********************************************************************************************************************//
    //************************************************* ENUM TYPES *******************************************************//

    TITLEMENU("file:Resources/Imgs/Backgrounds/TitleScene.png","Resources/Sounds/Title_Music.mp3"),
    CHARACTERSELECTIONMENU("file:Resources/Imgs/Backgrounds/Room01_Img.png","Resources/Sounds/Title_Music.mp3"),
    BOARD("file:Resources/Imgs/Backgrounds/Map_Img.png","Resources/Sounds/Game_Music.mp3"),
    TICTACTOE("file:Resources/Imgs/Backgrounds/TitleScene.png","Resources/Sounds/Title_Music.mp3"),
    SOUP("file:Resources/Imgs/Backgrounds/Map_Img.png","Resources/Sounds/Title_Music.mp3"),
    MEMORYPATH("file:Resources/Imgs/Backgrounds/Map_Img.png","Resources/Sounds/Title_Music.mp3"),
    MEMORY("file:Resources/Imgs/Backgrounds/Map_Img.png","Resources/Sounds/Title_Music.mp3"),
    CATCHCAT("file:Resources/Imgs/Backgrounds/Map_Img.png","Resources/Sounds/Title_Music.mp3"),
    BOMBER("file:Resources/Imgs/Backgrounds/Map_Img.png","Resources/Sounds/Title_Music.mp3"),
    GUESS("file:Resources/Imgs/Backgrounds/Map_Img.png","Resources/Sounds/Title_Music.mp3"),
    COINS("file:Resources/Imgs/Backgrounds/Map_Img.png","Resources/Sounds/Title_Music.mp3"),
    CARDS("file:Resources/Imgs/Backgrounds/Map_Img.png","Resources/Sounds/Title_Music.mp3");

    //********************************************************************************************************************//
    //************************************************ ENUM FIELDS *******************************************************//

    //Img File Path
    private String imgFilePath;

    //Music File Path
    private String musicFilePath;

    //********************************************************************************************************************//
    //************************************************ ENUM METHODS ******************************************************//

    //Constructor
    GameType(String imgFilePath,String musicFilePath){
        this.imgFilePath=imgFilePath;
        this.musicFilePath=musicFilePath;
    }

    //Setters and Getters
    public String getImgFilePath(){
        return this.imgFilePath;
    }

    public String getMusicFilePath(){
        return this.musicFilePath;
    }
}
