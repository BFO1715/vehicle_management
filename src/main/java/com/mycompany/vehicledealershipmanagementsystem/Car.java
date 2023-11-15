/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vehicledealershipmanagementsystem;

/**
 *
 * @author bethan
 */
// Car class
class Car extends Vehicle {
    protected String bodyType;
    protected boolean hasSatNav;
    protected boolean hasParkingSensors;
    protected boolean hasTowBar;
    protected boolean hasRoofRack;

    public Car(String make, String model, int year, String gearboxType, String color, int mileage, String vin, String bodyType) {
        super(make, model, year, gearboxType, color, mileage, vin);
        this.bodyType = bodyType;
    }

    public void addSatNav() { this.hasSatNav = true; }
    public void addParkingSensors() { this.hasParkingSensors = true; }
    public void addTowBar() { this.hasTowBar = true; }
    public void addRoofRack() { this.hasRoofRack = true; }

    @Override
    public String toString() {
        return "Car{" +
                "bodyType='" + bodyType + '\'' +
                ", hasSatNav=" + hasSatNav +
                ", hasParkingSensors=" + hasParkingSensors +
                ", hasTowBar=" + hasTowBar +
                ", hasRoofRack=" + hasRoofRack +
                ", " + super.toString() +
                '}';
    }
}
