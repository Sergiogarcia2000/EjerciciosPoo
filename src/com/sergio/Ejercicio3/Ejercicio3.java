package com.sergio.Ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("====TRES EN RAYA====");
        Board.getInstance()
                .runGame();
        sc.close();
    }
}
