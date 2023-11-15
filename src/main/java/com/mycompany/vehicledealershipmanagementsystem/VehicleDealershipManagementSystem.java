/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vehicledealershipmanagementsystem;

import java.util.Scanner;
/**
 *
 * @author bethan
 */
// Main class to interact with system operator
public class VehicleDealershipManagementSystem {
    private static Vehicle[] vehicles = new Vehicle[10];
    private static int vehicleCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Select action: \n1. Add a new vehicle \n2. Update vehicle \n3. Exit");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    addVehicle(scanner);
                    break;
                case "2":
                    updateVehicle(scanner);
                    break;
                case "3":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (!"3".equals(input));

        printVehicles();
    }

    private static void addVehicle(Scanner scanner) {
        System.out.println("Enter type of vehicle (car/motorbike):");
        String type = scanner.nextLine();

        System.out.println("Enter make:");
        String make = scanner.nextLine();
        System.out.println("Enter model:");
        String model = scanner.nextLine();
        System.out.println("Enter year:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter gearbox type (manual/auto):");
        String gearboxType = scanner.nextLine();
        System.out.println("Enter color:");
        String color = scanner.nextLine();
        System.out.println("Enter mileage:");
        int mileage = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter VIN:");
        String vin = scanner.nextLine();

        if ("car".equalsIgnoreCase(type)) {
            System.out.println("Enter body type (saloon/estate/hatchback/SUV):");
            String bodyType = scanner.nextLine();

            Car car;
            if ("SUV".equalsIgnoreCase(bodyType)) {
                car = new SUV(make, model, year, gearboxType, color, mileage, vin, bodyType);
                System.out.println("Add all-wheel drive? (yes/no)");
                if ("yes".equalsIgnoreCase(scanner.nextLine())) {
                    ((SUV) car).addAllWheelDrive();
                }
            } else if ("estate".equalsIgnoreCase(bodyType)) {
                car = new Estate(make, model, year, gearboxType, color, mileage, vin, bodyType);
                System.out.println("Add third-row seat? (yes/no)");
                if ("yes".equalsIgnoreCase(scanner.nextLine())) {
                    ((Estate) car).addThirdRowSeat();
                }
            } else {
                car = new Car(make, model, year, gearboxType, color, mileage, vin, bodyType);
            }

            System.out.println("Add sat nav? (yes/no)");
            if ("yes".equalsIgnoreCase(scanner.nextLine())) {
                car.addSatNav();
            }

            System.out.println("Add parking sensors? (yes/no)");
            if ("yes".equalsIgnoreCase(scanner.nextLine())) {
                car.addParkingSensors();
            }

            System.out.println("Add a tow bar? (yes/no)");
            if ("yes".equalsIgnoreCase(scanner.nextLine())) {
                car.addTowBar();
            }

            System.out.println("Add a roof rack? (yes/no)");
            if ("yes".equalsIgnoreCase(scanner.nextLine())) {
                car.addRoofRack();
            }

            vehicles[vehicleCount++] = car;
        } else if ("motorbike".equalsIgnoreCase(type)) {
            Motorbike motorbike = new Motorbike(make, model, year, gearboxType, color, mileage, vin);
            System.out.println("Add luggage box? (yes/no)");
            if ("yes".equalsIgnoreCase(scanner.nextLine())) {
                motorbike.addLuggageBox();
            }

            vehicles[vehicleCount++] = motorbike;
        }

        if (vehicleCount >= vehicles.length) {
            resizeArray();
        }
    }

    private static void resizeArray() {
        Vehicle[] newVehicles = new Vehicle[vehicles.length * 2];
        System.arraycopy(vehicles, 0, newVehicles, 0, vehicles.length);
        vehicles = newVehicles;
        System.out.println("Array resized: New capacity is " + vehicles.length);
    }

    private static void printVehicles() {
        System.out.println("Vehicles in the system:");
        for (int i = 0; i < vehicleCount; i++) {
            System.out.println(vehicles[i]);
        }
    }

    private static void updateVehicle(Scanner scanner) {
        System.out.println("Enter the VIN of the vehicle to update:");
        String vin = scanner.nextLine();

        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].vin.equals(vin)) {
                if (vehicles[i] instanceof Motorbike) {
                    System.out.println("Do you want to add/remove luggage box? (add/remove/no)");
                    String choice = scanner.nextLine();
                    if ("add".equalsIgnoreCase(choice)) {
                        ((Motorbike) vehicles[i]).addLuggageBox();
                    } else if ("remove".equalsIgnoreCase(choice)) {
                        ((Motorbike) vehicles[i]).removeLuggageBox();
                    }
                } else if (vehicles[i] instanceof Vehicle) {
                    System.out.println("Enter new color (or 'no' to skip):");
                    String color = scanner.nextLine();
                    if (!"no".equalsIgnoreCase(color)) {
                        vehicles[i].updateColor(color);
                    }

                    System.out.println("Enter new mileage (or -1 to skip):");
                    int mileage = scanner.nextInt();
                    scanner.nextLine(); // Consume the remaining newline
                    if (mileage != -1) {
                        vehicles[i].updateMileage(mileage);
                    }
                }
                System.out.println("Vehicle updated: " + vehicles[i]);
                return;
            }
        }
        System.out.println("Vehicle with VIN " + vin + " not found.");
    }
}



