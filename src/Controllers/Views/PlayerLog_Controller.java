package Controllers.Views;

import Controllers.Models.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;

public class PlayerLog_Controller {

    @FXML
    TextArea textArea;
    @FXML
    Button okButton;

    private Stage dialogStage;

    private Player player;

    private String content;


    @FXML
    private void handleOk(){
        this.dialogStage.close();
    }

    public void setPlayer(Player player) {
        this.player = player;
        JSONObject playerLog=this.player.getPlayerLog();
        this.content+="\n***** Player log *****\n";
        this.content+="Player ID: "+playerLog.get("ID")+"\n";
        this.content+="Player Punishments: "+playerLog.get("Punishments")+"\n";
        this.content+="***** Player Turns Description *****";


        JSONArray turns = (JSONArray) playerLog.get("Turns");

        for(int turn=0;turn<turns.size();turn++){
            JSONObject tempTurn=(JSONObject)turns.get(turn);
            this.content+="\n*** Turn "+turn+" ***\n";
            this.content+="Node: "+tempTurn.get("Node")+"\n";
            this.content+="NodeType: "+tempTurn.get("NodeType")+"\n";
            this.content+="State: "+tempTurn.get("State")+"\n";
        }

        this.textArea.setText(this.content);
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
