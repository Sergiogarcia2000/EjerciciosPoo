package com.sergio.EjericicoOpcional;


import com.sergio.EjericicoOpcional.Conjunto;

public class EjercicioOpcional {

    public static void main(String[] args) {

        Conjunto set = new Conjunto();
        Conjunto set2 = new Conjunto();

        // AÑADIMOS ELEMENTOS AL PRIMER SET
        set.addElement("hola");
        set.addElement(7);
        set.addElement(8);
        set.addElement(7.33);
        set.addElement(true);
        set.addElement(432);
        set.addElement(20);

        // IMPRIMIMOS EL SET
        System.out.print("Set 1: ");
        System.out.println(set);

        // AÑADIMOS ELEMENTOS AL SEGUNDO SET
        set2.addElement("hola");
        set2.addElement(8);
        set2.addElement(7);
        set2.addElement(12);
        set2.addElement(27);

        // IMPRIMIMOS EL SET
        System.out.print("Set 2: ");
        System.out.println(set2);
        System.out.println(set);

        System.out.println("===========");
        // ELIMINAMOS ELEMENTOS

        set.removeElement(20);
        set.removeElement(true);
        System.out.print("Nuevo Set 1: ");
        System.out.println(set);

        System.out.println("============");
        // UNION INTERSECCION Y DIFERENCIA CON SET3

        Conjunto set3;

        set3 = set.union(set2);
        System.out.print("Set 3 union(set1, set2): ");
        System.out.println(set3);

        set3 = set.intersect(set2);
        System.out.print("Set 3 interseccion(set1, set2): ");
        System.out.println(set3);

        set3 = set.difference(set2);
        System.out.print("Set 3 diferencia(set1, set2): ");
        System.out.println(set3);

        System.out.println("==============");

        // COMPROBACIONES ENTRE CONJUNTOS

        System.out.println("Comprobar si un conjunto tiene un número: ");
        System.out.println(set.checkElement(3));
        System.out.println(set.checkElement(7.33));
        System.out.println(set.checkElement(7));

        System.out.println("Comprobar si un conjunto es subconjunto de otro");

        System.out.print("Set 1: ");
        System.out.println(set);
        System.out.print("Set 2: ");
        System.out.println(set2);

            // DEJANDOLO TAL CUAL
        System.out.println("Tal cual: " + set.checkSubSet(set2));

        set.removeElement(52);
        set.removeElement(432);
        set.removeElement(7.33);


        System.out.print("Set 1: ");
        System.out.println(set);
        System.out.print("Set 2: ");
        System.out.println(set2);

            // AJUSTÁNDOLO
        System.out.println("Ajustado: " + set.checkSubSet(set2));


        System.out.println("Comprobar si dos conjuntos son iguales");


        System.out.print("Set 1: " );
        System.out.println(set);
        System.out.println("Set 2: ");
        System.out.println(set2);
            // DEJÁNDOLO TAL CUAL
        System.out.println("Tal cual: " + set.checkEquals(set2));

        set2.removeElement(12);
        set2.removeElement(27);

        System.out.println("Set 1: ");
        System.out.println(set);
        System.out.println("Set 2: ");
        System.out.println(set2);

            // AJUSTÁNDOLO
        System.out.println("Ajustado: " + set.checkEquals(set2));
    }
}
