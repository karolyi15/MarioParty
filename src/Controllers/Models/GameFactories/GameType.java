package Controllers.Models.GameFactories;

public enum GameType {

    TITLEMENU("file:Resources/Imgs/Backgrounds/Map_Img.png","file:Resources/Sounds/Title_Music.mp3"),
    CHARACTERSELECTIONMENU("file:Resources/Imgs/Backgrounds/Room01_Img.png","file:Resources/Sounds/Title_Music.mp3"),
    BOARD("file:Resources/Imgs/Backgrounds/Map_Img.png","file:Resources/Sounds/Game_Music.mp3"),
    TICTACTOE("file:Resources/Imgs/Backgrounds/Tictactoe_Img.jpeg","file:Resources/Sounds/Title_Music.mp3"),
    SOUP("file:Resources/Imgs/Backgrounds/Map_Img.png","file:Resources/Sounds/Title_Music.mp3"),
    MEMORYPATH("file:Resources/Imgs/Backgrounds/Map_Img.png","file:Resources/Sounds/Title_Music.mp3"),
    MEMORY("file:Resources/Imgs/Backgrounds/Map_Img.png","file:Resources/Sounds/Title_Music.mp3"),
    CATCHCAT("file:Resources/Imgs/Backgrounds/Map_Img.png","file:Resources/Sounds/Title_Music.mp3"),
    BOMBER("file:Resources/Imgs/Backgrounds/Map_Img.png","file:Resources/Sounds/Title_Music.mp3"),
    GUESS("file:Resources/Imgs/Backgrounds/Map_Img.png","file:Resources/Sounds/Title_Music.mp3"),
    COINS("file:Resources/Imgs/Backgrounds/Map_Img.png","file:Resources/Sounds/Title_Music.mp3"),
    CARDS("file:Resources/Imgs/Backgrounds/Map_Img.png","file:Resources/Sounds/Title_Music.mp3");

    private String imgFilePath;
    private String musicFilePath;

    GameType(String imgFilePath,String musicFilePath){
        this.imgFilePath=imgFilePath;
        this.musicFilePath=musicFilePath;
    }

    public String getImgFilePath(){
        return this.imgFilePath;
    }

    public String getMusicFilePath(){
        return this.musicFilePath;
    }
}
