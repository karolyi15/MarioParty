package Controllers.Views;

import Controllers.Models.SceneBuilder.SceneBuilder;
import Controllers.Models.SceneBuilder.SceneDirector;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


public class Scene_Controller {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private GraphicsContext drawer;


    //FXML Components
    @FXML
    private Canvas canvas;

    //Scenes Controller System
    private SceneDirector director;
    private SceneBuilder builder;


    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //********** Initialize **********//

    //Initialize is call after fxml is loaded
    @FXML
    private void initialize(){


        //Init drawer
        this.drawer=this.canvas.getGraphicsContext2D();

        //Init Scene Components
        this.builder=new SceneBuilder();
        this.director=new SceneDirector(this.builder);

        //Test System
        this.director.setSceneController(this);
        this.director.buildMainGame();

    }

   //Render System
    public Canvas getCanvas(){
        return this.canvas;
    }

    public GraphicsContext getDrawer(){
        return this.drawer;
    }





}
