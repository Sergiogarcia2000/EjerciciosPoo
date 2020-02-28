package com.sergio.Ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Board.getInstance()
                .runGame();
        sc.close();
    }
}
