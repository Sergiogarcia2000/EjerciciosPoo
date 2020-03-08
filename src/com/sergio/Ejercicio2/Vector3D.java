package com.sergio.Ejercicio2;

public class Vector3D {

    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * SUMA DE DOS VECTORES
     * @param vector2 SEGUNDO VECTOR
     * @return NUEVO VECTOR CON LA SUMA
     */
    public Vector3D sumVector(Vector3D vector2){
        return new Vector3D(this.x + vector2.x, this.y + vector2.y, this.z + vector2.z);
    }

    /**
     * RESTA DE DOS VECTORES
     * @param vector2 SEGUNDO VECTOR
     * @return UN NUEVO VECTOR CON LA RESTA
     */
    public Vector3D substractVector(Vector3D vector2){
        return new Vector3D(this.x - vector2.x, this.y - vector2.y, this.z - vector2.z);
    }

    /**
     * MÓDULO DEL VECTOR
     * @return EL MÓDULO
     */
    public double moduleVector(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    /**
     * ESCALA DE VECTOR
     * @param vector2 SEGUNDO VECTOR
     * @return ESCALA
     */
    public double scaleVector(Vector3D vector2){
        return this.x * vector2.x + this.y * vector2.y + this.z * vector2.z;
    }

    /**
     * PRODUCTO VECTORIAL
     * @param vector2 SEGUNDO VECTOR
     * @return UN TERCER VECTOR CON EL PRODUCTO
     */
    public Vector3D prductVectorial(Vector3D vector2){
        double x = this.y * vector2.z - vector2.y * this.z;
        double y = this.x * vector2.z - vector2.x * this.z;
        double z = this.x * vector2.y - vector2.x * this.y;

        return new Vector3D(x, -y ,z);
    }

    @Override
    public String toString(){
        return "X: " + this.x + "\nY: " + this.y + "\nZ: " + this.z;
    }


}
