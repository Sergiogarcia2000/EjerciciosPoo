package com.sergio.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Conjunto {

    private List<Integer> set = new ArrayList<>();

    public Conjunto(){

    }

    /**
     * AÑADE UN ELEMENTO A LA LISTA
     * COMPRUEBA SI YA ESTÁ, SI NO ESTÁ LO AÑADE
     * @param num NUMERO QUE SE QUIERE AÑADIR
     */
    public void addElement(Integer num){

        if (!this.set.contains(num)){
            this.set.add(num);
        }

    }

    /**
     * ELIMINA EL ELEMENTO ESPECIFICADO
     * @param num EL ELEMENTO QUE SE DESEA ELIMINAR
     */
    public void removeElement(Integer num){
        this.set.remove(num);
    }

    /**
     * GENERA UN NUEVO CONJUNTO A PARTIR DEL LLAMADO Y UNO PASADO POR PARÁMETRO
     * @param c2 SEGUNDO CONJUNTO
     * @return LA UNIÓN ENTRE LOS DOS CONJUNTOS
     */
    public Conjunto union(Conjunto c2){
        Conjunto c3 = new Conjunto();

        for (Integer i : this.set)
            c3.addElement(i);

        for (Integer i : c2.set)
            c3.addElement(i);

        return c3;
    }

    /**
     * GENERA UN NUEVO CONJUNTO A PARTIR DE LLAMADO Y DEL PASADO POR PARÁMETRO
     * @param c2 SEGUNDO CONJUNTO
     * @return LA INTERSECCIÓN ENTRE LOS DOS CONJUNTOS
     */
    public Conjunto intersect(Conjunto c2){
        Conjunto c3 = new Conjunto();

        for (Integer i : this.set){
            if (c2.set.contains(i))
                c3.addElement(i);
        }
        return c3;
    }

    /**
     * GENERA UN CONJUNTO CON LOS QUE ESTÉN EN EL PRIMERO Y NO EN EL SEGUNDO
     * @param c2 SEGUNDO CONJUNTO
     * @return LA DIFERENCIA ENTRE LOS DOS CONJUNTOS
     */
    public Conjunto difference(Conjunto c2){
        Conjunto c3 = new Conjunto();

        for (Integer i : this.set){
            if (!c2.set.contains(i))
                c3.addElement(i);
        }
        return c3;
    }

    /**
     * COMPRUEBA SI EL ELEMENTO INTRODUCIDO ESTÁ DENTRO DEL SET
     * @param e ELEMENTO
     * @return BOOLEANA
     */
    public boolean checkElement(Integer e){
        return this.set.contains(e);
    }

    /**
     * COMPRUEBA SI EL SET ES UN SUBCONJUNTO DEL SEGUNDO
     * @param c2 SEGUNDO CONJUNTO
     * @return BOOLEANA DEPENDIENDO
     */
    public boolean checkSubSet(Conjunto c2){

        for (Integer i : this.set){
            if(!c2.set.contains(i))
                return false;
        }
        return true;
    }

    /**
     * COMPRUEBA SI LOS DOS CONJUNTOS SON IDÉNTICOS
     * @param c2 SEGUNDO CONJUNTO
     * @return BOOLEANA
     */
    public boolean checkEquals(Conjunto c2){

        if (this.set.size() == c2.set.size()){

            for (Integer i : this.set){
                if (!c2.checkElement(i))
                    return false;
            }
            return true;
        }
        return false;
    }

    /**
     * @return STRING CON ELEMENTOS
     */
    @Override
    public String toString(){
        String s = "{ ";
        for (Integer i : this.set){
            s += Integer.toString(i) + ", ";
        }
        s += "}";
        return s;
    }

}