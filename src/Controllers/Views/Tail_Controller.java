package Controllers.Views;

import Controllers.Models.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class Tail_Controller {

    @FXML
    private RadioButton forward;
    @FXML
    private RadioButton backward;
    @FXML
    private RadioButton movement1;
    @FXML
    private RadioButton movement2;
    @FXML
    private RadioButton movement3;

    @FXML
    private Button okButton;

    private ToggleGroup toggleGroupDirection;
    private ToggleGroup toggleGroupMovement;
    private Stage dialogStage;

    private Player player;

    @FXML
    private void initialize(){

        this.toggleGroupDirection =new ToggleGroup();
        this.toggleGroupMovement=new ToggleGroup();

        this.forward.setToggleGroup(this.toggleGroupDirection);
        this.forward.setSelected(true);
        this.backward.setToggleGroup(this.toggleGroupDirection);

        this.movement1.setToggleGroup(this.toggleGroupMovement);
        this.movement2.setToggleGroup(this.toggleGroupMovement);
        this.movement3.setToggleGroup(this.toggleGroupMovement);
        this.movement3.setSelected(true);
    }



    @FXML
    private void handleOk(){

        //Get User Input
        RadioButton tempDirection=(RadioButton)this.toggleGroupDirection.getSelectedToggle();
        RadioButton tempMovement=(RadioButton) this.toggleGroupMovement.getSelectedToggle();

        //Update Player Position
        if(tempDirection.getText().equals("Forward")){

            int currentNode=this.player.getCurrentNode();
            int inputMovement=Integer.valueOf(tempMovement.getText());

            if(currentNode+inputMovement>26){
                player.setCurrentNode(26-(currentNode+inputMovement-26));

            }else{
                player.setCurrentNode(currentNode+inputMovement);
            }


        }else if(tempDirection.getText().equals("Backward")){
            int currentNode=this.player.getCurrentNode();
            int inputMovement=Integer.valueOf(tempMovement.getText());

            if(currentNode-inputMovement<0){
                player.setCurrentNode(0);

            }else{
                player.setCurrentNode(currentNode-inputMovement);
            }
        }



        //Close Dialog
        this.dialogStage.close();
    }


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
