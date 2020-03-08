package com.sergio.Ejercicio3;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

/**
 * @author SERGIO GARCÍA MAYO
 */
public class Board {

    private String[][] gameBoard;
    private static Board board;
    private String actualPlayer;
    private String[] players;
    private Boolean game;

    public Board(){
        // DECLARA EL TABLERO
        this.gameBoard = new String[3][3];
        // RELLENA EL ARRAY
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                gameBoard[i][j] = " ";
            }
        }
        // ESTABLECE LOS JUGADORES
        players = new String[2];
        players[0] = "X";
        players[1] = "O";

        game = true;
    }

    /**
     * GETINSTANCE
     * CLASE SINGLETON PARA PODER UTILIZAR LA MISMA INSTANCIA DESDE CUALQUIER SITIO
     * @return INSTANCIA DE LA CALSE
     */
    public static Board getInstance(){
        if (board == null) {
            board = new Board();
        }
        return board;
    }

    /**
     * RUNGAME
     * INICIA EL JUEGO
     */
    public void runGame(){

        Scanner sc = new Scanner(System.in);

        System.out.println("¿Contra quién deseas jugar?");
        System.out.println("1. Jugador");
        System.out.println("2. BOT");
        System.out.print(">>> ");
        int option = sc.nextInt();

        if (option == 1){
            playerVsPlayer();
        }else if (option == 2) {
            playerVsBot();
        }else{
            System.out.println("Entrada desconocida.");
        }
    }

    /**
     * PLAYERVSBOT
     * ELIGE EL JUGADOR QUE EMPIEZA ALEATORIAMENTE
     * METODO PARA JUGAR CONTRA UN BOT
     * ELIGES EL TIPO DE DIFICULTAD
     * INICIA EL BUCLE DE JUEGO
     */
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
            System.out.print(">>> ");
            difficult = sc.nextInt();
        }while(difficult != 1 && difficult != 2);

        if (difficult == 1){
            bot = new BOT(1);
        }else{
            bot = new BOT(2);
        }

        while (game) {

            System.out.println("Turno del jugador: " + actualPlayer);
            System.out.println(this);
            if (actualPlayer.equalsIgnoreCase("X")) {
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
                bot.play();
            }

            checkEndGame();
        }
    }

    /**
     * PLAYERVSPLAYER
     * ELIGE EL JUGADOR QUE EMPIEZA ALEATORIAMENTE
     * ELIGES EL TIPO DE DIFICULTAD
     * INICIA EL BUCLE DE JUEGO
     */
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
        if (checkWinner().equalsIgnoreCase(actualPlayer)){
            System.out.println("Gana el jugador: " + actualPlayer);
            game = false;
        }else if (checkWinner().equalsIgnoreCase("TIE")){
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

    /**
     * COMPROBAR EL GANADOR
     * HACE TODAS LAS COMPROBACIONES
     * AL EMPEZAR EL GANADOR ES NONE
     * SI ENCUENTRA UN GANADOR ESTE SE ALMACENA EN LA VARIABLE WINNER
     * SI NO QUEDAN HUECOS Y NO HAY GANADOR DEVULVE EMPATE
     * @return SI NO HAY GANADOR || EMPATE || GANADOR
     */
    public String checkWinner() {

        String winner = "NONE";

        if (gameBoard[0][0].equals(gameBoard[0][1]) && gameBoard[0][0].equals(gameBoard[0][2]) && !gameBoard[0][0].equals(" ")) {
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

        if (winner.equalsIgnoreCase("NONE") && freeSpaces == 0) {
            return "TIE";
        } else {
            return winner;
        }
    }

    /**
     * NEXTPLAY
     * SI ROW Y COL NO ESTAN OCUPADOS REALIZA ESA JUGADA Y SUSTITUYE EL ESPACIO EN BLANCO POR EL JUGADOR ACTUAL
     * @param row FILA
     * @param col COLUMNA
     */
    public void nextPlay(int row, int col){
        if (!gameBoard[row][col].equals("X") && !gameBoard[row][col].equals("O")){
            gameBoard[row][col] = actualPlayer;
            nextTurn();
        }
    }

    /**
     * NEXTPLAY
     * IGUAL QUE EL ANTERIOR PERO ESTA VEZ TU INTRODUCES QUE JUGADOR VA A REALIZAR LA JUGADA
     * UTILIZADO PARA EL ALGORITMO MINIMAX
     * @param row FILA
     * @param col COLUMNA
     * @param player JUGADOR
     */
    public void nextPlay(int row, int col, String player){
        this.gameBoard[row][col] = player;
        nextTurn();
    }

    /**
     * NEXTTURN
     * CAMBIA EL JUGADOR ACTUAL
     */
    private void nextTurn() {
        if (actualPlayer.equalsIgnoreCase("X")){
            actualPlayer = "O";
        }else{
            actualPlayer = "X";
        }
    }

    /**
     * ENDGAME
     * SE LLAMA AL TERMINAR EL JUEGO
     * TE PIDE SI QUIERES VOLVER A JUGAR O NO
     */
    private void endGame(){

        Scanner sc = new Scanner(System.in);
        int opt = 0;

        System.out.println("================");
        System.out.println("1. Volver a jugar.");
        System.out.println("2. Salir");
        do {
            try{
                System.out.print(">>>");
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
