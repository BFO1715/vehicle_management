/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vehicledealershipmanagementsystem;

/**
 *
 * @author bethan
 */
// SUV Car class
class SUV extends Car {
    private boolean hasAllWheelDrive;

    public SUV(String make, String model, int year, String gearboxType, String color, int mileage, String vin, String bodyType) {
        super(make, model, year, gearboxType, color, mileage, vin, bodyType);
    }

    public void addAllWheelDrive() {
        this.hasAllWheelDrive = true;
    }

    @Override
    public String toString() {
        return "SUV{" +
                "bodyType='" + bodyType + '\'' +
                ", hasAllWheelDrive=" + hasAllWheelDrive +
                ", " + super.toString() +
                '}';
    }
}
