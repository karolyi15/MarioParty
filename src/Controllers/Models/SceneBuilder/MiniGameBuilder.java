package Controllers.Models.SceneBuilder;

import Controllers.Models.Player;
import Controllers.Models.SceneBuilder.Products.TicTacToe;
import Controllers.Models.SceneBuilder.Products.TitleScene;
import Controllers.Models.SpriteFactory.SpriteFactory;
import Controllers.Views.Scene_Controller;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;

public class MiniGameBuilder implements iSceneBuilder {



    private MiniGame miniGame;



    @Override
    public void reset(GameType gameType){
        if(gameType.equals(GameType.TICTACTOE)){
            this.miniGame=new TicTacToe();
        }else if(gameType.equals(GameType.TITLEMENU)){
            this.miniGame=new TitleScene();
        }else{
            this.miniGame=new MiniGame();
        }
    }

    @Override
    public void setSceneController(Scene_Controller sceneController){
        this.miniGame.setSceneController(sceneController);
    }

    @Override
    public void setSpriteFactory(SpriteFactory spriteFactory){
        this.miniGame.setSpriteFactory(spriteFactory);
    }

    @Override
    public void setGameType(GameType gameType){
        this.miniGame.setGameType(gameType);
    }

    @Override
    public void setPlayers(ArrayList<Player> playerList){
        this.miniGame.setPlayerList(playerList);
    }

    @Override
    public void setSoundSystem(MediaPlayer musicPlayer, MediaPlayer soundPlayer){
        this.miniGame.setMusicPlayer(musicPlayer);
        this.miniGame.setSoundPlayer(soundPlayer);
    }

    public MiniGame getMiniGame(){
        return this.miniGame;
    }


}
