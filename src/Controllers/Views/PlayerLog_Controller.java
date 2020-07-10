package Controllers.Views;

import Controllers.Models.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class PlayerLog_Controller {

    @FXML
    TextArea textArea;
    @FXML
    Button okButton;

    private Stage dialogStage;

    private Player player;


    @FXML
    private void handleOk(){
        this.dialogStage.close();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
