package Controllers.Models.SceneBuilder;

public enum SceneType {

    //********************************************************************************************************************//
    //************************************************* ENUM TYPES *******************************************************//

    //Main Scenes
    TITLEMENU("file:Resources/Imgs/Backgrounds/TitleBackground_Img.png","Resources/Sounds/Title_Music.mp3"),
    CHARACTERSELECTIONMENU("file:Resources/Imgs/Backgrounds/TitleBackground_Img.png","Resources/Sounds/CharacterSelection_Music.mp3"),
    BOARD("file:Resources/Imgs/Backgrounds/Map_Img.png","Resources/Sounds/MainGame_Music.mp3"),

    //Mini Games
    TICTACTOE("file:Resources/Imgs/Backgrounds/Tictactoe_Img.jpeg","Resources/Sounds/TicTacToe_Music.mp3"),
    SOUP("file:Resources/Imgs/Backgrounds/Map_Img.png","Resources/Sounds/MarioSoup_Music.mp3"),
    MEMORYPATH("file:Resources/Imgs/Backgrounds/MemoryPathBackground.png","Resources/Sounds/MemoryPath_Music.mp3"),
    MEMORY("file:Resources/Imgs/Backgrounds/MemoryBackground.png","Resources/Sounds/Memory_Music.mp3"),
    CATCHCAT("file:Resources/Imgs/Backgrounds/CatchBooBackground_Img.png","Resources/Sounds/CatchBoo_Music.mp3"),
    BOMBER("file:Resources/Imgs/Backgrounds/CollectCoinsScene.jpg","Resources/Sounds/CollectTheCoins_Music.mp3"),
    GUESS("file:Resources/Imgs/Backgrounds/WhoGuessBackground.png","Resources/Sounds/Memory_Music.mp3"),
    COINS("file:Resources/Imgs/Backgrounds/CollectCoinsScene.jpg","Resources/Sounds/CollectTheCoins_Music.mp3"),
    CARDS("file:Resources/Imgs/Backgrounds/MarioCardsBackground.png","Resources/Sounds/MarioCards_Music.mp3");

    //********************************************************************************************************************//
    //************************************************ ENUM FIELDS *******************************************************//

    //Img File Path
    private String imgFilePath;

    //Music File Path
    private String musicFilePath;

    //********************************************************************************************************************//
    //************************************************ ENUM METHODS ******************************************************//

    //Constructor
    SceneType(String imgFilePath, String musicFilePath){
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
