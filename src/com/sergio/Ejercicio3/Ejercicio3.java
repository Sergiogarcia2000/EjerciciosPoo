package com.sergio.Ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args){

        Board b = new Board();

        Scanner sc = new Scanner(System.in);

        while(!b.checkWinner()){
            System.out.println("Turno del jugador " + b.getPlayer());
            System.out.println(b);
            b.nextMove(sc.nextInt(),sc.nextInt());

        }

        System.out.println("Gana el jugador: " + b.getPlayer());

    }
}
