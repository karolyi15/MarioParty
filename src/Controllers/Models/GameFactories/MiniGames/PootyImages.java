package Controllers.Models.GameFactories.MiniGames;

public enum PootyImages {
    CAJA ("file:Resources/Imgs/Backgrounds/Caja.jpeg"), //Separamos con comas

    TTTO ("file:Resources/Imgs/Backgrounds/TTTO.jpeg"),

    TTTX("file:Resources/Imgs/Backgrounds/TTTX.jpeg"),

    TTTBACKGROUND ("file:Resources/Imgs/Backgrounds/TTTBackground.png"),

    TTTBOARD ("file:Resources/Imgs/Backgrounds/TTTBoard.png");  //Cuando terminamos cerramos con ;

    private final String imagen;

    PootyImages(String imagen) {
        this.imagen = imagen;

    }


    //Métodos de la clase tipo Enum

    public String getImagen() { return imagen; }

}
