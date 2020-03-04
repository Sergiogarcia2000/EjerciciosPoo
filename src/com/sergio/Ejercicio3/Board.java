package com.sergio.Ejercicio3;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Board {

    private String[][] gameBoard;
    private static Board board;
    private String actualPlayer;
    private String[] players;
    private Boolean game;

    public Board(){
        this.gameBoard = new String[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                gameBoard[i][j] = " ";
            }
        }
        players = new String[2];
        players[0] = "X";
        players[1] = "O";

        game = true;
    }

    public static Board getInstance(){
        if (board == null) {
            board = new Board();
        }
        return board;
    }

    public void runGame(){

        Scanner sc = new Scanner(System.in);

        System.out.println("¿Contra quién deseas jugar?");
        System.out.println("1. Jugador");
        System.out.println("2. BOT");
        System.out.println("3. BOT VS BOT");
        System.out.print(">>> ");
        int option = sc.nextInt();

        if (option == 1){
            playerVsPlayer();
        }else if (option == 2) {
            playerVsBot();
        }else if (option == 3){
            botVsBot();
        }else{
            System.out.println("Entrada desconocida.");
        }
    }

    private void playerVsBot() {

        Random rand = new Random();
        actualPlayer = players[rand.nextInt(2)];
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

            System.out.println("Turno del jugador: " + actualPlayer);
            System.out.println(this);
            if (actualPlayer.equals("X")) {
                try {
                    System.out.print("Introduce la fila(1-3): ");
                    int row = sc.nextInt();
                    System.out.print("Introduce la columna(1-3): ");
                    int col = sc.nextInt();
                    nextPlay(row - 1, col - 1);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Entrada inválida.");
                }
            } else {
                bot.play("O");
            }

            checkEndGame();
        }
    }

    private void botVsBot(){

        Random rand = new Random();
        actualPlayer = players[rand.nextInt(2)];
        Scanner sc = new Scanner(System.in);
        BOT bot;
        int difficult = 0;


        System.out.println("Selecciona el tipo de dificultad para los Bots: ");
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
            System.out.println("Turno del jugador: " + actualPlayer);
            System.out.println(this);
            bot.play(actualPlayer);
            checkEndGame();
        }
    }

    private void playerVsPlayer() {
        Random rand = new Random();

        actualPlayer = players[rand.nextInt(2)];

        Scanner sc = new Scanner(System.in);
        while(game){

            System.out.println("Turno del jugador " + actualPlayer);
            System.out.println(this);
            try{
                System.out.print("Introduce la fila(1-3): ");
                int row = sc.nextInt();
                System.out.print("Introduce la columna(1-3): ");
                int col = sc.nextInt();
                nextPlay(row - 1,col - 1);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Entrada inválida.");
            }

            checkEndGame();
        }
    }

    private void checkEndGame(){
        nextTurn();
        if (checkWinner().equals(actualPlayer)){
            System.out.println("Gana el jugador: " + actualPlayer);
            game = false;
        }else if (checkWinner().equals("TIE")){
            System.out.println("EMPATE");
            game = false;
        }

        if (!checkWinner().equals("NONE")){
            endGame();
        }
        nextTurn();
    }

    public String[][] getGameBoard(){
        return this.gameBoard;
    }

    public String checkWinner() {

        String winner = "NONE";

        if (gameBoard[0][0].equals(gameBoard[0][1]) && gameBoard[0][0].equals(gameBoard[0][2])) {
            winner = gameBoard[0][0];
        } else if (gameBoard[1][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[1][2]) && !gameBoard[1][0].equals(" ")) {
            winner = gameBoard[1][0];
        } else if (gameBoard[2][0].equals(gameBoard[2][1]) && gameBoard[2][1].equals(gameBoard[2][2]) && !gameBoard[2][0].equals(" ")) {
            winner = gameBoard[2][0];
        } else if (gameBoard[0][0].equals(gameBoard[1][0]) && gameBoard[1][0].equals(gameBoard[2][0]) && !gameBoard[0][0].equals(" ")) {
            winner = gameBoard[0][0];
        } else if (gameBoard[0][1].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][1]) && !gameBoard[0][1].equals(" ")) {
            winner = gameBoard[0][1];
        } else if (gameBoard[0][2].equals(gameBoard[1][2]) && gameBoard[0][2].equals(gameBoard[2][2]) && !gameBoard[0][2].equals(" ")) {
            winner = gameBoard[0][2];
        } else if (gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2]) && !gameBoard[0][0].equals(" ")) {
            winner = gameBoard[0][0];
        } else if (gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[0][2].equals(gameBoard[2][0]) && !gameBoard[0][2].equals(" ")){
            winner = gameBoard[0][2];
        }

        int freeSpaces = 0;

        for (int i  = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (gameBoard[i][j].equals(" ")){
                    freeSpaces++;
                }
            }
        }

        if (winner == "NONE" && freeSpaces == 0) {
            return "TIE";
        } else {
            return winner;
        }
    }

    public void nextPlay(int row, int col){
        if (!gameBoard[row][col].equals("X") && !gameBoard[row][col].equals("O")){
            gameBoard[row][col] = actualPlayer;
            nextTurn();
        }
    }

    public void nextPlay(int row, int col, String player){
        this.gameBoard[row][col] = player;
        nextTurn();
    }

    private void nextTurn() {
        if (actualPlayer.equals("X")){
            actualPlayer = "O";
        }else{
            actualPlayer = "X";
        }
    }

    private void endGame(){

        Scanner sc = new Scanner(System.in);
        int opt = 0;

        System.out.println("================");
        System.out.println("1. Volver a jugar.");
        System.out.println("2. Salir");
        do {
            try{
                opt = sc.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Has introducido un valor invalido");
            }
        }while(opt != 1  && opt != 2);

        if (opt == 1){
            board = new Board();
            getInstance()
                    .runGame();
        }else{
            System.exit(1);
        }
    }

    @Override
    public String toString(){

        StringBuilder boardString = new StringBuilder(" -------------\n");

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (j == 1) {
                    boardString.append(this.gameBoard[i][j]);
                }else{
                    boardString.append(" | ").append(this.gameBoard[i][j]).append(" | ");
                }
            }
            boardString.append("\n -------------\n");
        }

        return boardString.toString();
    }
}
