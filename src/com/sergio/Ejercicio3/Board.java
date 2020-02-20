package com.sergio.Ejercicio3;

import java.util.Scanner;

public class Board {

    private String[][] board = new String[3][3];
    private String[][] check = new String[3][3];
    private String actualPlayer = "x";

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

        while (!this.checkWinner()){
            System.out.println("Turno del jugador: " + this.getActualPlayer());
            System.out.println(this);
            if (this.getActualPlayer().equals("x")){
                try{
                    System.out.print("Introduce la fila(1-3): ");
                    int row = sc.nextInt();
                    System.out.print("Introduce la columna(1-3): ");
                    int col = sc.nextInt();
                    if (!board[row - 1][col - 1].equals("x") && !board[row - 1][col - 1].equals("o"))
                        this.nextMove(row - 1,col - 1);
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Entrada inválida.");
                }
            }else{
                this.board = bot.play(this.board);
                nextTurn();
            }
        }
        System.out.println("Gana: " + this.getWinner());

    }

    private void playerVsPlayer(){
        Scanner sc = new Scanner(System.in);
        while(!this.checkWinner()){
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
        }
        System.out.println("Gana: " + this.getWinner());
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

    private String getWinner(){
        if (actualPlayer.equals("x")){
            return "Jugador 2";
        }else{
            return "Jugador 1";
        }
    }

    private boolean checkWinner(){

            // 0 1 2
            // 3 4 5
            // 6 7 8
            if (check[0][0].equals(check[0][1]) && check[0][0].equals(check[0][2])) {
                return true;
            } else if (check[1][0].equals(check[1][1]) && check[1][1].equals(check[1][2])) {
                return true;
            } else if (check[2][0].equals(check[2][1]) && check[2][1].equals(check[2][2])) {
                return true;
            } else if (check[0][0].equals(check[1][0]) && check[1][0].equals(check[2][0])) {
                return true;
            } else if (check[0][1].equals(check[1][1]) && check[1][1].equals(check[2][1])) {
                return true;
            } else if (check[0][2].equals(check[1][2]) && check[0][2].equals(check[2][2])) {
                return true;
            } else if (check[0][0].equals(check[1][1]) && check[1][1].equals(check[2][2])) {
                return true;
            } else return check[0][2].equals(check[1][1]) && check[0][2].equals(check[2][0]);

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
