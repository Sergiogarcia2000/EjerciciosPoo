package com.sergio.Ejercicio2;

public class Ejercicio2 {

    public static void main(String[] args){

        // SI QUIERES PUEDES MODIFICAR LOS VALORES
        Vector3D vec1 = new Vector3D(45, 12, 5);
        Vector3D vec2 = new Vector3D(87, -2, 43);

        System.out.println("Primer vector: \n" + vec1);
        System.out.println("Segundo vector: \n" + vec2);


        Vector3D vec3 = vec1.sumVector(vec2);
        System.out.println("=================");
        System.out.println("Suma: ");
        System.out.println(vec3);
        System.out.println("=================");


        System.out.println("Resta: ");
        vec3 = vec1.substractVector(vec2);
        System.out.println(vec3);
        System.out.println("=================");


        System.out.println("Modulo: " + vec1.moduleVector());
        System.out.println("=================");


        System.out.println("Escalar: " + vec1.scaleVector(vec2));
        System.out.println("=================");


        vec3 = vec1.prductVectorial(vec2);
        System.out.println("Producto Vectorial: \n" + vec3);





    }

}
