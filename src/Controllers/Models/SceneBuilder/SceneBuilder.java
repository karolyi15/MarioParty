package Controllers.Models.SceneBuilder;

import Controllers.Models.Player;
import Controllers.Models.SceneBuilder.Products.*;
import Controllers.Models.SpriteFactory.SpriteFactory;
import Controllers.Views.Scene_Controller;
import java.util.ArrayList;

public class SceneBuilder implements iSceneBuilder {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private GameScene gameScene;
    private SpriteFactory spriteFactory;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //Constructor
    public SceneBuilder(){
        this.spriteFactory=new SpriteFactory();
    }


    @Override
    public void reset(SceneType sceneType){

        //Main Scenes
        if(sceneType.equals(SceneType.TITLEMENU)){

            this.gameScene =new TitleScene();
            this.gameScene.setSpriteFactory(this.spriteFactory);

        }else if(sceneType.equals(SceneType.CHARACTERSELECTIONMENU)){

            this.gameScene =new CharacterSelection();
            this.gameScene.setSpriteFactory(this.spriteFactory);

        }else if(sceneType.equals(SceneType.BOARD)){

            this.gameScene =new MainGame();
            this.gameScene.setSpriteFactory(this.spriteFactory);

        }

        //Mini Games
        else if(sceneType.equals(SceneType.TICTACTOE)){

            this.gameScene =new TicTacToe();
            this.gameScene.setSpriteFactory(this.spriteFactory);

        }else if(sceneType.equals(SceneType.MEMORYPATH)){

            this.gameScene =new MemoryPath();
            this.gameScene.setSpriteFactory(this.spriteFactory);

        }else if(sceneType.equals(SceneType.CATCHCAT)){

            this.gameScene =new CatchBoo();
            this.gameScene.setSpriteFactory(this.spriteFactory);

        }else if(sceneType.equals(SceneType.SOUP)){

            this.gameScene =new MarioSoup();
            this.gameScene.setSpriteFactory(this.spriteFactory);

        }else if(sceneType.equals(SceneType.COINS)){

            this.gameScene=new CollectTheCoins();
            this.gameScene.setSpriteFactory(this.spriteFactory);

        }else if(sceneType.equals(SceneType.MEMORY)){

            this.gameScene=new Memory();
            this.gameScene.setSpriteFactory(this.spriteFactory);

        }else if(sceneType.equals(SceneType.GUESS)){

            this.gameScene=new GuessWho();
            this.gameScene.setSpriteFactory(this.spriteFactory);

        }else if(sceneType.equals(SceneType.CARDS)){

            this.gameScene=new MarioCards();
            this.gameScene.setSpriteFactory(this.spriteFactory);

         }else if(sceneType.equals(SceneType.BOMBER)){

            this.gameScene=new BomberMario();
            this.gameScene.setSpriteFactory(this.spriteFactory);

        }else{
            this.gameScene=null;
        }

    }

    @Override
    public void setSceneController(Scene_Controller sceneController){
        this.gameScene.setSceneController(sceneController);
    }

    @Override
    public void setSceneDirector(SceneDirector director){
        this.gameScene.setSceneDirector(director);
    }

    @Override
    public void setPlayers(ArrayList<Player> playerList){
        this.gameScene.setPlayerList(playerList);
    }

    @Override
    public GameScene getBuild(){

        return this.gameScene;
    }


}
