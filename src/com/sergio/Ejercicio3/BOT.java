package com.sergio.Ejercicio3;

import java.util.Random;

public class BOT {

    private int difficult;

    public BOT(int difficult){
        this.difficult = difficult;
    }

    private int[] easyPlay(String[][] board){
        Random rand = new Random();
        int attempts = 20;
        while (attempts >= 0){
            int row = rand.nextInt(3);
            int col = rand.nextInt(3);
            System.out.println("Row: " + row + " Col: " + col);
            if (!board[row][col].equals("x") && !board[row][col].equals("o")){
                board[row][col] = "o";
                return new int[]{row, col};
            }
            attempts--;
        }
        return new int[]{-1,-1};
    }

    private int[] hardPlay(String[][] board){

        int bestScore = Integer.MIN_VALUE;

        int[] move = new int[2];

        System.out.println(move[0] + " " + move[1]);

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){

                if (board[i][j].equals(" ")) {
                    System.out.println("Entra en " + i + " " + j);
                    board[i][j] = "o";
                    int score = minimax(board, 0, false);
                    board[i][j] = " ";
                    System.out.println("Score: " + score + " bestscore " + bestScore);
                    if (score > bestScore){
                        bestScore = score;
                        move[0] = i;
                        move[1] = j;
                    }
                }
            }
        }
        System.out.println(move[0] + " " + move[1]);
        return move;
    }

    private int minimax(String[][] board, int depth, boolean isMaximizing) {

        String result = Board.getInstance().checkWinner(board);

        if (result != null){
            if (result.equals("TIE")){
                return 0;
            }else if (result.equals("o")){
                return 10;
            }else{
                return -10;
            }
        }

        if (isMaximizing){
            int bestScore = Integer.MIN_VALUE;

            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){

                    if (board[i][j].equals(" ")){
                        board[i][j] = "o";
                        int score = minimax(board, depth + 1, false);
                        board[i][j] = " ";
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        }else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){

                    if (board[i][j].equals(" ")){

                        board[i][j] = "x";
                        int score = minimax(board, depth + 1, true);
                        board[i][j] = " ";
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    public int[] play(String[][] board){
        int[] botPlay;
        if (this.difficult == 1){
            botPlay = easyPlay(board);
        }else{
            botPlay = hardPlay(board);
        }

        return botPlay;
    }

}
