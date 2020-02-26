package com.sergio.Ejercicio3;

import java.util.Scanner;

public class Board {

    private String[][] board = new String[3][3];
    private String[][] check = new String[3][3];
    private String actualPlayer = "x";
    private boolean game = true;
    private static Board b;

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

    public static Board getInstance(){
        if (b == null){
            b = new Board();
        }
        return b;
    }

    public void runGame(){
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Contra quién deseas jugar?");
        System.out.println("1. Jugador");
        System.out.println("2. BOT");
        System.out.print(">>> ");
        int option = sc.nextInt();

        if (option == 1){
            playerVsPlayer();
        }else if (option == 2){
            playerVsBot();
        }else{
            System.out.println("Entrada desconocida.");
        }
    }

    private void playerVsBot(){
        Scanner sc = new Scanner(System.in);
        BOT bot;
        int difficult = 0;
        System.out.println("Selecciona el tipo de dificultad: ");
        System.out.println("1. Fácil");
        System.out.println("2. Difícil");

        do{
            difficult = sc.nextInt();
            System.out.print(">>> ");
        }while(difficult != 1 && difficult != 2);

        if (difficult == 1){
            bot = new BOT(1);
        }else{
            bot = new BOT(2);
        }

        while (game) {

            System.out.println("Turno del jugador: " + this.getActualPlayer());
            System.out.println(this);
            if (this.getActualPlayer().equals("x")) {
                try {
                    System.out.print("Introduce la fila(1-3): ");
                    int row = sc.nextInt();
                    System.out.print("Introduce la columna(1-3): ");
                    int col = sc.nextInt();
                    if (!board[row - 1][col - 1].equals("x") && !board[row - 1][col - 1].equals("o"))
                        this.nextMove(row - 1, col - 1);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Entrada inválida.");
                }
            } else {
                int[] botPlay = bot.play(this.board);
                if (botPlay[0] == -1) {
                    game = false;
                }
                System.out.println("Bot playing: " + botPlay[0] + " " + botPlay[1]);
                this.board[botPlay[0]][botPlay[1]] = "o";
                this.check[botPlay[0]][botPlay[1]] = "o";
                nextTurn();
            }
            if (checkWinner(this.board) != null){
                if (this.checkWinner(this.board).equals("x")){
                    game = false;
                    System.out.println("GANA JUGADOR 1");
                }else if ( this.checkWinner(this.board).equals("o")){
                    game = false;
                    System.out.println("GANA BOT");
                }else if ( this.checkWinner(this.board).equals("TIE")){
                    game = false;
                    System.out.println("EMPATE");
                }
            }

        }
    }

    private void playerVsPlayer(){
        Scanner sc = new Scanner(System.in);
        while(game){

            System.out.println("Turno del jugador " + this.getActualPlayer());
            System.out.println(this);
            try{
                System.out.print("Introduce la fila(1-3): ");
                int row = sc.nextInt();
                System.out.print("Introduce la columna(1-3): ");
                int col = sc.nextInt();
                this.nextMove(row - 1,col - 1);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Entrada inválida.");
            }
            this.checkWinner(this.check);
        }
    }

    private void nextTurn(){
        if (actualPlayer.equals("x")){
            actualPlayer = "o";
        }else{
            actualPlayer = "x";
        }
    }

    private String getActualPlayer(){
        return actualPlayer;
    }

    private void getWinner(){
        if (actualPlayer.equals("x")){
            System.out.println("Gana el Jugador 2");
        }else{
            System.out.println("Gana el Jugador 1");
        }
    }

    public String checkWinner(String[][] check){

        String winner = null;

        // 0 1 2
        // 3 4 5
        // 6 7 8
        if (check[0][0].equals(check[0][1]) && check[0][0].equals(check[0][2])) {
            winner = check[0][0];
        } else if (check[1][0].equals(check[1][1]) && check[1][1].equals(check[1][2])) {
            winner = check[1][0];
        } else if (check[2][0].equals(check[2][1]) && check[2][1].equals(check[2][2])) {
            winner = check[2][0];
        } else if (check[0][0].equals(check[1][0]) && check[1][0].equals(check[2][0])) {
            winner = check[0][0];
        } else if (check[0][1].equals(check[1][1]) && check[1][1].equals(check[2][1])) {
            winner = check[0][1];
        } else if (check[0][2].equals(check[1][2]) && check[0][2].equals(check[2][2])) {
            winner = check[0][2];
        } else if (check[0][0].equals(check[1][1]) && check[1][1].equals(check[2][2])) {
            winner = check[0][0];
        } else if (check[0][2].equals(check[1][1]) && check[0][2].equals(check[2][0])){
            winner = check[0][2];
        }

        int freeSpaces = 0;

        for (int i  = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (check[i][j].equals(" ")){
                    freeSpaces++;
                }
            }
        }

        if (winner == null && freeSpaces == 0) {
            return "TIE";
        } else {
            return winner;
        }
    }

    private void nextMove(int row, int col){
        this.board[row][col] = actualPlayer;
        this.check[row][col] = actualPlayer;
        nextTurn();
    }

    @Override
    public String toString(){

        StringBuilder boardString = new StringBuilder(" -------------\n");

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (j == 1) {
                    boardString.append(this.board[i][j]);
                }else{
                    boardString.append(" | ").append(this.board[i][j]).append(" | ");
                }
            }
            boardString.append("\n -------------\n");
        }

        return boardString.toString();
    }

}
