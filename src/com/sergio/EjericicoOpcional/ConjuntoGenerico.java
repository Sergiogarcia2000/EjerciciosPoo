package com.sergio.EjericicoOpcional;

import java.util.ArrayList;
import java.util.List;

public class ConjuntoGenerico<T> {

    private List<T> set = new ArrayList<>();

    public ConjuntoGenerico(){
    }

    /**
     * AÑADE UN ELEMENTO A LA LISTA
     * COMPRUEBA SI YA ESTÁ, SI NO ESTÁ LO AÑADE
     * @param obj OBJETO QUE SE QUIERE AÑADIR
     */
    public void addElement(T obj){

        if (!this.set.contains(obj)){
            this.set.add(obj);
        }

    }

    /**
     * ELIMINA EL ELEMENTO ESPECIFICADO
     * @param obj EL ELEMENTO QUE SE DESEA ELIMINAR
     */
    public void removeElement(T obj){
        this.set.remove(obj);
    }

    /**
     * GENERA UN NUEVO CONJUNTO A PARTIR DEL LLAMADO Y UNO PASADO POR PARÁMETRO
     * @param c2 SEGUNDO CONJUNTO
     * @return LA UNIÓN ENTRE LOS DOS CONJUNTOS
     */
    public ConjuntoGenerico<T> union(ConjuntoGenerico<T> c2){
        ConjuntoGenerico<T> c3 = new ConjuntoGenerico<T>();

        for (T i : this.set)
            c3.addElement(i);

        for (T i : c2.set)
            c3.addElement(i);

        return c3;
    }

    /**
     * GENERA UN NUEVO CONJUNTO A PARTIR DE LLAMADO Y DEL PASADO POR PARÁMETRO
     * @param c2 SEGUNDO CONJUNTO
     * @return LA INTERSECCIÓN ENTRE LOS DOS CONJUNTOS
     */
    public ConjuntoGenerico<T> intersect(ConjuntoGenerico<T> c2){
        ConjuntoGenerico<T> c3 = new ConjuntoGenerico<T>();

        for (T i : this.set){
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
    public ConjuntoGenerico<T> difference(ConjuntoGenerico<T> c2){
        ConjuntoGenerico<T> c3 = new ConjuntoGenerico<T>();

        for (T i : this.set){
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
    public boolean checkElement(T e){
        return this.set.contains(e);
    }

    /**
     * COMPRUEBA SI EL SET ES UN SUBCONJUNTO DEL SEGUNDO
     * @param c2 SEGUNDO CONJUNTO
     * @return BOOLEANA DEPENDIENDO
     */
    public boolean checkSubSet(ConjuntoGenerico<T> c2){

        for (T i : this.set){
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
    public boolean checkEquals(ConjuntoGenerico<T> c2){

        if (this.set.size() == c2.set.size()){

            for (T i : this.set){
                if (!c2.checkElement(i))
                    return false;
            }
            return true;
        }
        return false;
    }

    /**
     * COMPRUEBA SI LA LISTA DEL OTRO OBJETO ES IGUAL A LA DE ESTE OBJETO
     * @param set OTRO OBJETO
     * @return TRUE O FALSE
     */
    public boolean checkSet(ConjuntoGenerico<T> c2){
        return this.set.equals(c2.set);
    }

    /**
     * @return STRING CON ELEMENTOS
     */
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("{ ");
        for (T i : this.set){
            s.append(i).append(", ");
        }
        s.replace(s.length()-2, s.length()-1, "");
        s.append("}");
        return s.toString();
    }
}
