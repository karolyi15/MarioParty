package Controllers.Models.SceneBuilder;

import Controllers.Models.Player;
import Controllers.Models.SpriteFactory.SpriteFactory;
import Controllers.Views.Scene_Controller;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;

public interface iSceneBuilder {

    //

    public void reset(GameType gameType);

    public void setSceneController(Scene_Controller sceneController);

    public void setSpriteFactory(SpriteFactory spriteFactory);

    public void setGameType(GameType gameType);

    public void setPlayers(ArrayList<Player> playerList);

    public void setSoundSystem(MediaPlayer musicPlayer,MediaPlayer soundPlayer);


}
