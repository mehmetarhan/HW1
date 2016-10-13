/**
 * Created by Mehmet Tarhan on 30/09/2016.
 */

public class Vehicle {

    // Data fields
    private String plate;
    private String size;          // Size of the vehicle
    private int timeEntered;  // Time the vehicle entered
    private int timeExited;   // Time the vehicle exited

    // Constructors
    public Vehicle() {

    }

    // This constructor is used for entering vehicles
    public Vehicle(String plate, String size, int timeEntered) {
        this.plate = plate;
        this.size = size;
        this.timeEntered = timeEntered;
    }

    // This constructor is used for exiting vehicles
    public Vehicle(String plate, int timeExited) {
        this.plate = plate;
        this.timeExited = timeExited;
    }

    // Methods
    // setTimeExited method is used for setting exiting time of the vehicles
    public void setTimeExited(int timeExited) {
        this.timeExited = timeExited;
    }

    // get methods are used for creating lists .
    public String getPlate() {
        return plate;
    }

    public String getSize() {
        return size;
    }

    public int getTimeEntered() {
        return timeEntered;
    }

    public int getTimeExited() {
        return timeExited;
    }

    public int sizeOfTheVehicle() {
        if (size.equals("small")) {
            return 1;
        } else if (size.equals("medium")) {
            return 2;
        } else if (size.equals("large")) {
            return 3;
        }

        return 0;
    }

    public int getTotalPayment() {
        int cost = 0;
        int time = timeExited - timeEntered;

        // Small vehicles
        if (sizeOfTheVehicle() == 1) {
            if (time <= 2) {
                cost = 5;
            }
            cost = 5 + (time - 2) * 1;
        }

        // Medium vehicles
        if (sizeOfTheVehicle() == 2) {
            if (time <= 2) {
                cost = 6;
            }
            cost = 6 + (time - 2) * 2;
        }

        if (sizeOfTheVehicle() == 3) {
            if (time <= 2) {
                cost = 7;
            }
            cost = 7 + (time - 2) * 3;
        }

        return cost;
    }
}
