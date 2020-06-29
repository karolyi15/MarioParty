package Controllers.Models.SceneBuilder;

import Controllers.Models.Player;
import Controllers.Views.Scene_Controller;
import java.util.ArrayList;

public interface iSceneBuilder {



    public void reset(SceneType sceneType);

    public void setSceneController(Scene_Controller sceneController);

    public void setSceneDirector(SceneDirector director);

    public void setPlayers(ArrayList<Player> playerList);

    public GameScene getBuild();


}
