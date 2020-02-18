package com.sergio.Ejercicio2;

import java.util.ArrayList;

public class Vector3D {

    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vector3D sumVector(Vector3D vector2){
        return new Vector3D(this.x + vector2.x, this.y + vector2.y, this.z + vector2.z);
    }

    public Vector3D substractVector(Vector3D vector2){
        return new Vector3D(this.x - vector2.x, this.y - vector2.y, this.z - vector2.z);
    }

    public double moduleVector(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    public double scaleVector(Vector3D vector2){
        return this.x * vector2.x + this.y * vector2.y + this.z * vector2.z;
    }

    public Vector3D prductVectorial(Vector3D vector2){
        Vector3D vec3;
        double x = this.y * vector2.z - vector2.y * this.z;
        double y = this.x * vector2.z - vector2.x * this.z;
        double z = this.x * vector2.y - vector2.x * this.y;

        return vec3 = new Vector3D(x, -y ,z);
    }

    @Override
    public String toString(){
        return "X: " + this.x + "\nY: " + this.y + "\nZ: " + this.z;
    }


}
