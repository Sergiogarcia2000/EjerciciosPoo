package com.sergio.Ejercicio3;

public class Board {

    private String[][] board = new String[3][3];
    private String[][] check = new String[3][3];
    private String actualPlayer = "x";
    private int moves = 0;

    public Board(){
        int cont = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board[i][j] = " ";
                check[i][j] = Integer.toString(cont);
                cont++;
            }
        }
    }

    private void nextTurn(){
        if (actualPlayer.equals("x")){
            actualPlayer = "o";
        }else{
            actualPlayer = "x";
        }
    }

    public String getPlayer(){
        if (actualPlayer == "x"){
            return "Jugador 2";
        }else{
            return "Jugador 1";
        }

    }

    public boolean checkWinner(){

        // 0 1 2
        // 3 4 5
        // 6 7 8
            if (check[0][0] == check[0][1] && check[0][0] == check[0][2]) {
                return true;
            } else if (check[1][0] == check[1][1] && check[1][1] == check[1][2]) {
                return true;
            } else if (check[2][0] == check[2][1] && check[2][1] == check[2][2]) {
                return true;
            } else if (check[0][0] == check[1][0] && check[1][0] == check[2][0]) {
                return true;
            } else if (check[0][1] == check[1][1] && check[1][1] == check[2][1]) {
                return true;
            } else if (check[0][2] == check[1][2] && check[0][2] == check[2][2]) {
                return true;
            } else if (check[0][0] == check[1][1] && check[1][1] == check[2][2]) {
                return true;
            } else if (check[0][2] == check[1][1] && check[0][2] == check[2][0]) {
                return true;
            }
        return false;


    }

    public void nextMove(int row, int col){
        this.board[row][col] = actualPlayer;
        this.check[row][col] = actualPlayer;
        moves++;
        nextTurn();
    }

    @Override
    public String toString(){

        String boardString = "--------------\n";

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (j == 1) {
                    boardString += this.board[i][j];
                }else{
                    boardString += " | " + this.board[i][j] + " | ";
                }
            }
            boardString += "\n--------------\n";
        }

        return boardString;
    }

}
