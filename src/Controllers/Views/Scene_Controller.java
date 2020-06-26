package Controllers.Views;

import Controllers.Models.SceneBuilder.MiniGameDirector;
import Controllers.Models.SpriteFactory.SpriteFactory;
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

    //Test System
    MiniGameDirector director=new MiniGameDirector();
    SpriteFactory factory=new SpriteFactory();



    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //********** Initialize **********//

    //Initialize is call after fxml is loaded
    @FXML
    private void initialize(){


        //Init drawer
        this.drawer=this.canvas.getGraphicsContext2D();

        //Test System
        this.director.setSceneController(this);
        this.director.setFactory(factory);
        this.director.buildTitleScene();

    }

   //Render System
    public Canvas getCanvas(){
        return this.canvas;
    }

    public GraphicsContext getDrawer(){
        return this.drawer;
    }





}
