package Controllers.Models.GameFactories.MiniGames;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TicTacToeButton extends Button {
    private int value;
    private PootyImages imgEnum;
    private ImageView imgCaja;
    private ImageView imgO;
    private ImageView imgX;
    private Boolean pressed;

    public TicTacToeButton(){
        this.imgCaja = new ImageView(new Image(imgEnum.CAJA.getImagen(),55,55,false,false));
        this.imgO = new ImageView(new Image(imgEnum.TTTO.getImagen(),55,55,false,false));
        this.imgX = new ImageView(new Image(imgEnum.TTTX.getImagen(),55,55,false,false));
        this.setGraphic(imgCaja);
        this.pressed = false;
    }

    public void setState(int state){
        if (state == 1){
            if(pressed == false){
                this.setGraphic(imgO);
                pressed = true;
                this.value=1;
                //this.setDisabled(true);
            }

        }else if (state == -1){
            if(pressed == false) {
                this.setGraphic(imgX);
                pressed = true;
                this.value = -1;
                // this.setDisabled(true);
            }
        }else{
            System.out.println("ESTADO INVALIDO");
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public PootyImages getImgEnum() {
        return imgEnum;
    }

    public void setImgEnum(PootyImages imgEnum) {
        this.imgEnum = imgEnum;
    }

    public Boolean getPressed() {
        return pressed;
    }

    public void setPressed(Boolean pressed) {
        this.pressed = pressed;
    }
}
