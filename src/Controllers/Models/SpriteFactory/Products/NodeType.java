package Controllers.Models.SpriteFactory.Products;

public enum NodeType {

    //Board Cells
    PRISON("file:Resources/Imgs/UI Elements/UI_Elements.png",233,9,33,37),
    TUBERED("file:Resources/Imgs/UI Elements/UI_Elements.png",232,57,35,37),
    TUBEBLUE("file:Resources/Imgs/UI Elements/UI_Elements.png",310,57,35,37),
    TUBEYELLOW("file:Resources/Imgs/UI Elements/UI_Elements.png",271,56,35,37),
    STAR("file:Resources/Imgs/UI Elements/UI_Elements.png",339,107,17,16),
    FIRE("file:Resources/Imgs/UI Elements/UI_Elements.png",313,108,17,16),
    ICE("file:Resources/Imgs/UI Elements/UI_Elements.png",290,108,17,16),
    TAIL("file:Resources/Imgs/UI Elements/UI_Elements.png",7,1117,24,22),
    SOUPICON("file:Resources/Imgs/UI Elements/UI_Elements.png",55,75,17,17),
    CARDSICON("file:Resources/Imgs/UI Elements/UI_Elements.png",267,162,25,32),
    GUESSICON("file:Resources/Imgs/UI Elements/UI_Elements.png",239,107,17,17),
    MEMORYICON("file:Resources/Imgs/UI Elements/UI_Elements.png",239,162,26,32),
    MEMORYPATHICON("file:Resources/Imgs/UI Elements/UI_Elements.png",239,135,32,22),
    CATCHBOOICON("file:Resources/Imgs/UI Elements/UI_Elements.png",366,101,29,24),
    BOMBERICON("file:Resources/Imgs/UI Elements/UI_Elements.png",271,10,25,36),
    TICTACTOEICON("file:Resources/Imgs/UI Elements/UI_Elements.png",300,164,21,28),
    COINSICON("file:Resources/Imgs/UI Elements/UI_Elements.png",267,108,15,15),

    //Button State
    DEFAULTBUTTON("file:Resources/Imgs/UI Elements/UI_Elements.png",57,1114,85,25),

    //UI
    TEXTAREA("file:Resources/Imgs/UI Elements/UI_Elements.png",4,1201,182,42),

    //Character Selection
    UNKNOWNPORTRAIT("file:Resources/Imgs/UI Elements/CharacterMenu_Img.png",140,0,34,34),
    MARIOPORTRAIT("file:Resources/Imgs/UI Elements/CharacterMenu_Img.png",0,0,34,34),
    LUIGIPORTRAIT("file:Resources/Imgs/UI Elements/CharacterMenu_Img.png",35,0,34,34),
    YOSHIPORTRAIT("file:Resources/Imgs/UI Elements/CharacterMenu_Img.png",105,0,34,34),
    PEACHPORTRAIT("file:Resources/Imgs/UI Elements/CharacterMenu_Img.png",70,0,34,34),
    DAISYPORTRAIT("file:Resources/Imgs/UI Elements/CharacterMenu_Img.png",70,34,34,34),
    WARIOPORTRAIT("file:Resources/Imgs/UI Elements/CharacterMenu_Img.png",0,34,34,34),
    WALUIGIPORTRAIT("file:Resources/Imgs/UI Elements/CharacterMenu_Img.png",35,34,34,34),
    YELLOWYOSHIPORTRAIT("file:Resources/Imgs/UI Elements/CharacterMenu_Img.png",105,34,34,34),

    //Tic Tac Toe Nodes
    CAJA ("file:Resources/Imgs/UI Elements/TicTacToe_Elements.png",112,0,103,103),
    TTTO ("file:Resources/Imgs/UI Elements/TicTacToe_Elements.png",215,0,103,103),
    TTTX("file:Resources/Imgs/UI Elements/TicTacToe_Elements.png",0,0,103,103),

    //Catch Boo Nodes
    TUMB("file:Resources/Imgs/Characters/Boo_Img.png",145,107,33,30),
    TUMBX("file:Resources/Imgs/Characters/Boo_Img.png",215,107,33,30),
    CATCHBOO("file:Resources/Imgs/Characters/Boo_Img.png",80,29,29,22),


    //Memory Path Nodes
    MEMORYPATHEMPTYTABLE("file:Resources/Imgs/UI Elements/MemoryPath_Elements.png",403,0,358,407),
    MEMORYPATHCORRECTTABLE("file:Resources/Imgs/UI Elements/MemoryPath_Elements.png",0,0,358,407),
    MEMORYPATHINCORRECTTABLE("file:Resources/Imgs/UI Elements/MemoryPath_Elements.png",811,0,358,407),

    //COLLECT THE COINS
    GOLDCOIN("file:Resources/Imgs/UI Elements/CollectTheCoins_Elements.png",0,0,275,347),
    GRAYCOIN("file:Resources/Imgs/UI Elements/CollectTheCoins_Elements.png",589,0,296,347),
    REDCOIN("file:Resources/Imgs/UI Elements/CollectTheCoins_Elements.png",281,0,275,347),
    BLUECOIN("file:Resources/Imgs/UI Elements/CollectTheCoins_Elements.png",921,0,290,345),
    BOARDCOINS("file:Resources/Imgs/UI Elements/CollectTheCoins_Elements.png",1231,0,364,479),
    CCBOX("file:Resources/Imgs/UI Elements/CollectTheCoins_Elements.png",1615,0,340,340),

    //MEMORY
    MEMORYCARD("file:Resources/Imgs/UI Elements/Memory_Elements.png",643,0,208,291),
    MEMORYCOINCARD("file:Resources/Imgs/UI Elements/Memory_Elements.png",429,0,199,291),
    MEMORYCOIN20CARD("file:Resources/Imgs/UI Elements/Memory_Elements.png",209,0,199,291),
    MEMORYFLOWERCARD("file:Resources/Imgs/UI Elements/Memory_Elements.png",865,0,199,291),
    MEMORYCLOUDCARD("file:Resources/Imgs/UI Elements/Memory_Elements.png",661,319 ,180,291),
    MEMORYLUIGICARD("file:Resources/Imgs/UI Elements/Memory_Elements.png",209,319,199,291),
    MEMORYMARIOCARD("file:Resources/Imgs/UI Elements/Memory_Elements.png",869,319,199,291),
    MEMORYMUSHROOMCARD("file:Resources/Imgs/UI Elements/Memory_Elements.png",0,0,199,291),
    MEMORYSTARCARD("file:Resources/Imgs/UI Elements/Memory_Elements.png",429,319,199,291),
    MEMORYTRUNKCARD("file:Resources/Imgs/UI Elements/Memory_Elements.png",0,319,199,291),

    //GUESS WHO?
    GUEESTRANSPARENT("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",1245,983,50,50),

    BOO("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",654,323,327,323),
    BOWSER("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",654,0,327,323),
    DAISY("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",327,0,327,323),
    DIDDYKONG("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",981,0,327,323),
    DONKEYKONG("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",981,646,327,323),
    DRYBONES("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",327,646,327,323),
    GOOMBA("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",981,323,327,323),
    KOOPA("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",1308,646,327,323),
    LUIGI("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",1308,323,327,323),
    MARIO("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",327,323,327,323),
    PEACH("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",1308,0,327,323),
    TOAD("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",0,323,327,323),
    WALUIGI("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",0,646,327,323),
    WARIO("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",0,0,327,323),
    YOSHI("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",654 ,646,327,323),

    GUESSBUTTONSTANDARD("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",11,979,312,92),
    GUESSBUTTONCORRECT("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",363,979,312,92),
    GUESSBUTTONINCORRECT("file:Resources/Imgs/UI Elements/GuessWho_Elements.png",717,989,312,92),

    //MARIO CARDS
    HEARTS2("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",0,0,101,157),
    HEARTS3("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",111,0,101,157),
    HEARTS4("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",222,0,101,157),
    HEARTS5("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",333,0,101,157),
    HEARTS6("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",442,0,101,157),
    HEARTS7("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",555,0,101,157),
    HEARTS8("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",666,0,101,157),
    HEARTS9("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",774,0,101,157),
    HEARTS10("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",884,0,101,157),
    HEARTSJ("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",995,0,101,157),
    HEARTSQ("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",1106,0,101,157),
    HEARTSK("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",1217,0,101,157),
    HEARTSAS("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",1327,0,101,157),

    DIAMOND2("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",0,173,101,157),
    DIAMOND3("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",111,173,101,157),
    DIAMOND4("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",222,173,101,157),
    DIAMOND5("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",333,173,101,157),
    DIAMOND6("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",442,173,101,157),
    DIAMOND7("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",555,173,101,157),
    DIAMOND8("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",666,173,101,157),
    DIAMOND9("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",774,173,101,157),
    DIAMOND10("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",884,173,101,157),
    DIAMONDJ("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",995,173,101,157),
    DIAMONDQ("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",1106,173,101,157),
    DIAMONDK("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",1217,173,101,157),
    DIAMONDAS("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",1327,173,101,157),

    CLUB2("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",0,346,101,157),
    CLUB3("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",111,346,101,157),
    CLUB4("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",222,346,101,157),
    CLUB5("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",333,346,101,157),
    CLUB6("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",442,346,101,157),
    CLUB7("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",555,346,101,157),
    CLUB8("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",666,346,101,157),
    CLUB9("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",774,346,101,157),
    CLUB10("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",884,346,101,157),
    CLUBJ("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",995,346,101,157),
    CLUBQ("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",1106,346,101,157),
    CLUBK("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",1217,346,101,157),
    CLUBAS("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",1327,346,101,157),

    SPADES2("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",0,520,101,157),
    SPADES3("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",111,520,101,157),
    SPADES4("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",222,520,101,157),
    SPADES5("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",333,520,101,157),
    SPADES6("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",442,520,101,157),
    SPADES7("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",555,520,101,157),
    SPADES8("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",666,520,101,157),
    SPADES9("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",774,520,101,157),
    SPADES10("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",884,520,101,157),
    SPADESJ("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",995,520,101,157),
    SPADESQ("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",1106,520,101,157),
    SPADESK("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",1217,520,101,157),
    SPADESAS("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",1327,520,101,157),

    STANDARTCARD("file:Resources/Imgs/UI Elements/MarioCards_Elements.png",0,690,100,157);



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
