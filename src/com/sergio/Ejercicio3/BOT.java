package com.sergio.Ejercicio3;
import java.util.Random;

public class BOT {

    private int difficult;

    public BOT(int difficult){
        this.difficult = difficult;
    }

    private void easyPlay(){
        Random rand = new Random();
        int row = rand.nextInt(3);
        int col = rand.nextInt(3);
        Board.getInstance()
                .nextPlay(row, col);
    }


    private int[] hardPlay(){

        int bestScore = Integer.MIN_VALUE;

        int[] move = new int[2];

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){

                if (Board.getInstance().getGameBoard()[i][j].equals(" ")) {
                    Board.getInstance()
                            .nextPlay(i, j, "O");
                    int score = minimax(false);
                    Board.getInstance()
                            .nextPlay(i, j, " ");
                    if (score > bestScore){
                        bestScore = score;
                        move[0] = i;
                        move[1] = j;
                    }
                }
            }
        }
        return move;
    }

    private int minimax(boolean max) {

        String result = Board.getInstance().checkWinner();

        if (!result.equals("NONE")){
            if (result.equals("TIE")){
                return 0;
            }else if (result.equals("O")){
                return 1;
            }else{
                return -1;
            }
        }

        if (max){
            int bestScore = Integer.MIN_VALUE;
            int score;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){

                    if (Board.getInstance().getGameBoard()[i][j].equals(" ")){
                        Board.getInstance()
                                .nextPlay(i, j, "O");
                            score = minimax(false);
                        Board.getInstance()
                                .nextPlay(i, j, " ");
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;

        }else {
            int bestScore = Integer.MAX_VALUE;
            int score;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if (Board.getInstance().getGameBoard()[i][j].equals(" ")){
                        Board.getInstance()
                                .nextPlay(i, j, "X");
                            score = minimax(true);
                        Board.getInstance()
                                .nextPlay(i, j, " ");
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    public void play(){
        if (this.difficult == 1){
            easyPlay();
        }else{
            int[] bot = hardPlay();
            Board.getInstance()
                    .nextPlay(bot[0], bot[1]);
        }

    }

}
