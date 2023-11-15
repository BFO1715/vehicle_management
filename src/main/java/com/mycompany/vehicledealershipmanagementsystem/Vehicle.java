/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vehicledealershipmanagementsystem;

/**
 *
 * @author bethan
 */
// Base Vehicle class
abstract class Vehicle {
    protected final String make;
    protected final String model;
    protected final int year;
    protected final String gearboxType;
    protected String color;
    protected int mileage;
    protected final String vin;

    public Vehicle(String make, String model, int year, String gearboxType, String color, int mileage, String vin) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.gearboxType = gearboxType;
        this.color = color;
        this.mileage = mileage;
        this.vin = vin;
    }

    public void updateMileage(int newMileage) {
        this.mileage = newMileage;
    }

    public void updateColor(String newColor) {
        this.color = newColor;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", gearboxType='" + gearboxType + '\'' +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", vin='" + vin + '\'' +
                '}';
    }
}
