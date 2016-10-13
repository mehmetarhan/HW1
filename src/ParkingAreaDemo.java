/**
 * Created by Mehmet Tarhan on 30/09/2016.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ParkingAreaDemo {

    // Utilities
    public static Scanner userInput = new Scanner(System.in);  // User Input
    public static String lineSeparator = "----------------------------------------";

    // An array of vehicles in the parking area. Parking area cannot have more than 20 vehicles.
    public static ArrayList<Vehicle> vehicles = new ArrayList<>();

    // Necessary variables
    public static int numberOfVehicles = 0;  // Total number of vehicles in the parking area
    public static int totalIncome;   // Total money earned

    public static void main(String[] args) {

        int choice = getChoice();
        while (choice != 3) {   // It keeps the choice in a loop, till the user enters 3.
            switch (choice) {

                case 1:
                    enterVehicle();
                    choice = getChoice();
                    break;

                case 2:
                    exitVehicle();
                    choice = getChoice();
                    break;

                default:
                    System.out.println("Enter a valid choice.");
                    System.out.println(lineSeparator);
                    choice = getChoice();
                    break;
            }
        }

        terminate();
    }


    // MARK:
    // (enterVehicle) method requires a set Vehicle object and adds it to the array of vehicles.
    // And finally it shows the whole list of the vehicles in the parking area.
    public static void enterVehicle() {  // Vehicle(plate, size, timeEntered)
        if (numberOfVehicles < 3) { // CHECK: If numberOfVehicles is more than 20, parking area cannot take any vehicle.
            System.out.println("Entering a vehicle.........");
            Vehicle vehicle = setEnteringVehicle();
            vehicles.add(vehicle); // Adding vehicle
            numberOfVehicles++;   // Since it adds vehicle to the array, numberOfVehicles must be increased.
            showList();          // Showing the whole list of the vehicles(Current list)
        } else {
            System.out.println("Out of space!");
        }
        System.out.println(lineSeparator);

    }

    // MARK:
    // (exitVehicle) method requires a set Vehicle object and finds if it's in the array if so, it deletes it.
    // And finally, it shows the whole list of the vehicles in the parking area.
    public static void exitVehicle() {  // Vehicle(plate, timeExited)
        System.out.println("Exiting a vehicle..........");
        Vehicle vehicle = setExitingVehicle();
        for (Vehicle vhcl : vehicles) { // Checking every single vehicle in the vehicles array
            if (vhcl.getPlate().equals(vehicle.getPlate())) {
                vhcl.setTimeExited(vehicle.getTimeExited());
                int cost = vhcl.getTotalPayment();
                totalIncome += cost;
                vehicles.remove(vehicles.indexOf(vhcl));
                System.out.println("The vehicle pays: " + cost);

                showList();  // Showing the list
                System.out.println(lineSeparator);
                break;
            }
        }

    }

    // MARK:
    // Setting a new Vehicle object with given values of plate, size and timeEntered
    // Scanner is used for input
    public static Vehicle setEnteringVehicle() {
        System.out.println("Enter plate of the vehicle");
        String plate = userInput.next();
        System.out.println("Enter size of the vehicle");
        String size = userInput.next();
        System.out.println("Enter entering time of the vehicle");
        int timeEntered = userInput.nextInt();

        Vehicle vehicle = new Vehicle(plate, size, timeEntered); // Setting entering vehicle
        return vehicle;
    }

    // MARK:
    // Setting a new Vehicle object with given values of plate and timeExited
    // Scanner is used for input
    public static Vehicle setExitingVehicle() {
        System.out.println("Enter plate of the vehicle");
        String plate = userInput.next();
        System.out.println("Enter exiting time of the vehicle");
        int time = userInput.nextInt();

        Vehicle vehicle = new Vehicle(plate, time);  // Setting exiting vehicle
        return vehicle;
    }

    // Showing whole list of the vehicles in the parking area. (Current list)
    public static void showList() {
        System.out.println("\nList of the vehicles");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getPlate() + "\t" + vehicle.getSize() + "\t" + vehicle.getTimeEntered());
        }
    }

    // Showing total money earned
    public static void terminate() {
        System.out.println("Total earned money: " + totalIncome);
    }

    // Letting the user make a choice.
    public static int getChoice() {
        System.out.println("Choose:\n" + "1:Vehicle Enter\n" + "2:Vehicle Exit\n" + "3:Terminate");
        int choice = userInput.nextInt();

        return choice;

    }
}
