package Controllers;

import Controllers.Views.GameScene_Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {

    //********************************************* Class Fields ***********************************************//

    private Stage primaryStage;
    private BorderPane rootLayout;

    //********************************************* Class Methods **********************************************//


    @Override
    public void start(Stage primaryStage) {

        this.primaryStage=primaryStage;
        this.primaryStage.setTitle("Mario Party");

        initRootLayout();
        showGameScene();

    }

    public void initRootLayout(){
        try{

            //Load FXML File
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(Main.class.getResource("Views/RootLayout.fxml"));
            rootLayout=(BorderPane) loader.load();

            //Set Scene and Show Stage
            Scene scene=new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showGameScene(){
        try{

            //Load FXML File
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(Main.class.getResource("Views/GameScene_UI.fxml"));
            AnchorPane mainMenu=(AnchorPane) loader.load();

            //Set Scene to RootLayout
            rootLayout.setCenter(mainMenu);

            //Load FXML Controller
            GameScene_Controller controller=loader.getController();
            controller.setMainApp(this);


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Setters and Getters
    public Stage getPrimaryStage(){
        return this.primaryStage;
    }

    //Main
    public static void main(String[] args) {
        launch(args);
    }
}
