package com.sergio.Ejercicio2;

import java.util.ArrayList;

public class Vector3D {

    private Integer x;
    private Integer y;
    private Integer z;

    public Vector3D(Integer x, Integer y, Integer z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getZ() {
        return z;
    }

    public Vector3D sumVector(Vector3D vector2){
        return new Vector3D(this.x + vector2.getX(), this.y + vector2.getY(), this.z + vector2.getZ());
    }

    public Vector3D substractVector(Vector3D vector2){
        return new Vector3D(this.x - vector2.getX(), this.y - vector2.getY(), this.z - vector2.getZ());
    }

    public double moduleVector(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    public double scaleVector(Vector3D vector2){

        return this.x * vector2.getX() + this.y * vector2.getY() + this.z * vector2.getZ();

    }

    public void printVector(){
        System.out.println("X: " + this.x + "\nY: " + this.y + "\nZ: " + this.z);
    }


}
