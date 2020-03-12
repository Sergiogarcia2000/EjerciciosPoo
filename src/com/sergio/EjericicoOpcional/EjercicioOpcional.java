package com.sergio.EjericicoOpcional;

/**
 * @author SERGIO GARCÍA MAYO
 */
public class EjercicioOpcional {

    public static void main(String[] args) {

        ConjuntoGenerico<String> setString = new ConjuntoGenerico<>();
        ConjuntoGenerico<String> setString2 = new ConjuntoGenerico<>();

        // AÑADIMOS ELEMENTOS AL PRIMER SET
        setString.addElement("Hola");
        setString.addElement("Buenas tardes");
        setString.addElement("asd");
        setString.addElement("perez");
        setString.addElement("123");

        // IMPRIMIMOS EL SET
        System.out.print("Set 1: ");
        System.out.println(setString);

        // AÑADIMOS ELEMENTOS AL SEGUNDO SET
        setString2.addElement("Hola");
        setString2.addElement("asd");
        setString2.addElement("Buenas tardes");
        setString2.addElement("Que tal");
        setString2.addElement("adios");

        // IMPRIMIMOS EL SET
        System.out.print("Set 2: ");
        System.out.println(setString2);


        System.out.println("===========");
        // ELIMINAMOS ELEMENTOS

        System.out.println("Elimino la string '123'");

        setString.removeElement("123");
        System.out.print("Nuevo Set 1: ");
        System.out.println(setString);

        System.out.println("============");
        // UNION INTERSECCION Y DIFERENCIA CON SET3

        ConjuntoGenerico<String> set3;

        set3 = setString.union(setString2);
        System.out.print("Set 3 union(set1, set2): ");
        System.out.println(set3);

        set3 = setString.intersect(setString2);
        System.out.print("Set 3 interseccion(set1, set2): ");
        System.out.println(set3);

        set3 = setString.difference(setString2);
        System.out.print("Set 3 diferencia(set1, set2): ");
        System.out.println(set3);

        System.out.println("==============");

        // COMPROBACIONES ENTRE CONJUNTOS

        System.out.println("Comprobar si un conjunto tiene una cadena: ");
        System.out.println("Cadena 'Hola': ");
        System.out.println(setString.checkElement("Hola"));
        System.out.println("Cadena 'Aprobado': ");
        System.out.println(setString.checkElement("Aprobado"));
        System.out.println("Cadena 'perez': ");
        System.out.println(setString.checkElement("perez"));

        System.out.println("Comprobar si un conjunto es subconjunto de otro");

        System.out.println("Set 1: " + setString);
        System.out.println("Set 2: " + setString2);

        // DEJÁNDOLO TAL CUAL
        System.out.println("Tal cual: " + setString.checkSubSet(setString2));

        // ELIMINO PARA AJUSTARLO
        setString.removeElement("perez");

        System.out.println("Set 1: " + setString);
        System.out.println("Set 2: " + setString2);
        // AJUSTÁNDOLO
        System.out.println("Ajustado: " + setString.checkSubSet(setString2));


        System.out.println("Comprobar si dos conjuntos son iguales");


        System.out.println("Set 1: " + setString);
        System.out.println("Set 2: " + setString2);
        // DEJÁNDOLO TAL CUAL
        System.out.println("Tal cual: " + setString.checkEquals(setString2));

        setString2.removeElement("Que tal");
        setString2.removeElement("adios");

        System.out.println("Set 1: " + setString);
        System.out.println("Set 2: " + setString2);

        // AJUSTÁNDOLO
        System.out.println("Ajustado: " + setString.checkEquals(setString2));

    }
}
