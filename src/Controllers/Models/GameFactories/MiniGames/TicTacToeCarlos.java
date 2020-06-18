package Controllers.Models.GameFactories.MiniGames;

public class TicTacToeCarlos {
    private int turno = 1;

    int state = 0;
    public TicTacToeCarlos() {
        this.turno = 1;
    }


    public void changeTurno(){
        this.turno = this.turno * -1;
    }

    public boolean checkWinner(int turno, TicTacToeButton[] buttons){
        int[][] tableWinner = new int[8][3];
        //String topRow,midRow,botRow,leftRow,midCol,rightCol,cross1,cross2;
            /*topRow = "012"; midRow = "345"; botRow = "678"; leftRow = "036";
            midCol = "147"; rightCol = "258"; cross1 = "048"; cross2 = "246";*/
        tableWinner[0][0] = 0; tableWinner[0][1] = 1; tableWinner[0][2] = 2; //topRow = "012";
        tableWinner[1][0] = 3; tableWinner[1][1] = 4; tableWinner[1][2] = 5; //midRow = "345";
        tableWinner[2][0] = 6; tableWinner[2][1] = 7; tableWinner[2][2] = 8; //botRow = "678";
        tableWinner[3][0] = 0; tableWinner[3][1] = 3; tableWinner[3][2] = 6; //leftRow = "036";
        tableWinner[4][0] = 1; tableWinner[4][1] = 4; tableWinner[4][2] = 7; //midCol = "147";
        tableWinner[5][0] = 2; tableWinner[5][1] = 5; tableWinner[5][2] = 8; //rightCol = "258";
        tableWinner[6][0] = 0; tableWinner[6][1] = 4; tableWinner[6][2] = 8; //cross1 = "048";
        tableWinner[7][0] = 2; tableWinner[7][1] = 4; tableWinner[7][2] = 6; //cross2 = "246";
        int cont = 0;
             for(int i = 0; i < 8 ; i++){
            cont = 0;
            for(int j = 0; j < 3 ; j++){
                if(buttons[tableWinner[i][j]].getValue() == turno) {
                    cont++;
                }
            }
            if(cont == 3){
                return true;
            }
        }
             return false;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }


}
