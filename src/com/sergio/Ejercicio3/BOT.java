package com.sergio.Ejercicio3;

import java.util.Random;

public class BOT {

    private int difficult;

    public BOT(int difficult){
        this.difficult = difficult;
    }

    private String[][] easyPlay(String[][] board){
        Random rand = new Random();
        while (true){
            int row = rand.nextInt(3);
            int col = rand.nextInt(3);
            System.out.println("Row: " + row + " Col: " + col);
            if (!board[row][col].equals("x") && !board[row][col].equals("o")){
                System.out.println("La posicion: " + row + " " + col + " no está ocupada.");
                board[row][col] = "o";
                return board;
            }
        }
    }

    private String[][] hardPlay(String[][] board){
        return board;
    }

    public String[][] play(String[][] board){
        String[][] botPlay;
        if (this.difficult == 1){
            botPlay = easyPlay(board);
        }else{
            botPlay = hardPlay(board);
        }

        return botPlay;
    }

}
