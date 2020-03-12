package com.sergio.Ejercicio3;
import java.util.Random;

/**
 * @author SERGIO GARCIA MAYO
 */
public class BOT {

    private int difficult;

    // CONSTRUCTOR QUE ESTABLECE LA DIFICULTAD
    public BOT(int difficult){
        this.difficult = difficult;
    }

    /** JUGADA FÁCIL
     * ELIGE ALEATORIAMENTE LA POSICIÓN
     */
    private void easyPlay(){
        Random rand = new Random();
        int row = rand.nextInt(3);
        int col = rand.nextInt(3);
        Board.getInstance()
                .nextPlay(row, col);
    }

    /** JUGADA DIFICIL
     * FUNCIONA MEDIANTE UN ALGORITMO MINIMAX LO QUE SIGNIFICA QUE JUEGA EN BASE A PUNTOS
     * EN ESTE ALGORITMO COMPRUEBA CADA UNA DE LAS POSIBILIDADES QUE HAY
     * EN CADA POSIBILIDAD LLAMA AL ALGORITMO MINIMAX
     * SI EL ALGORITMO DEVUELVE UNA PUNTUACIÓN SUPERIOR A LA BASE ES LA JUGADA QUE REALIZA
     * @return UN ARRAY CON LAS POSICIONES DE LA JUGADA
     */
    private int[] hardPlay(){

        int bestScore = Integer.MIN_VALUE;

        int[] move = new int[2];

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){

                if (isEquals(i, j)) {
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

    // COMPRUEBA SI LA POSICION ESTÁ LIBRE
    private boolean isEquals(int row, int col) {
        return Board.getInstance().getGameBoard()[row][col].equals(" ");
    }


    /**
     * ALGORITMO MINIMAX
     * ESTE ALGORITMO FUNCIONA MEDIANTE RECURSIVIDAD Y PUNTUACIONES
     * CADA VEZ QUE EMPIEZA EL ALGORITMO COMPRUEBA SI HAY GANADOR
     * SI HAY GANADOR O EMPATE DEVUELVE LOS PUNTOS ASIGNADOS A CADA UNA DE LAS POSIBILIDADES (1 GANA, 0 EMPATA, -1 PIERDE)
     * EN EL CASO DE QUE NO HAYA FIN DE PARTIDA SE REALIZA EL ALGORITMO
     * TIENE DOS ESTADOS MAXIMIZANDO Y MINIMIZANDO
     * MAXIMIZANDO:
     *    EL ALGORITMO BUSCA LA MEJOR JUGADA PARA GANAR EL
     *    BUSCA UNA POSICION VACÍA Y PRUEBA A PONER LA FICHA
     *    AL PONER LA FICHA VUELVE A LLAMARSE PERO ESTA VEZ MINIMIZANDO
     *    AL COMPROBAR TODAS LAS POSIBILIDADES SE QUEDA CON LA PUNTUACIÓN MÁS ALTA QUE ES LA MÁS ÓPTIMA
     * MINIMIZANDO:
     *    EL ALGORITMO BUSCA LA MEJOR JUGADA DEL OPONENTE
     *    BUSCA UNA POSICIÓN VACÍA Y PRUEBA A PONER LA FICHA
     *    AL PONER LA FICHA VUELVE A LLAMARSE PERO ESTA VEZ MAXMIMZANDO
     *    AL COMPROBAR TODAS LAS POSIBILIDADES SE QUEDA CON LA PUNTUACIÓN MAS BAJA YA QUE ÉSTA ES LA QUE INDICA QUE EL OPONENTE GANA, DE AHÍ MINIMIZAR
     * @param max BOOLEAN COMPRUEBA SI ESTA MAXIMIZANDO O MINIMIZANDO
     * @return INT CON LA PUNTUACIÓN QUE OBTIENE ESTE ÁRBOL DE JUGADAS
     */
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

                    if (isEquals(i, j)){
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
                    if (isEquals(i, j)){
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

    /**
     * PLAY
     * DEPENDIENDO DE LA DIFICULTAD DEL BOT JUEGA DIFICIL O FÁCIL
     */
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
