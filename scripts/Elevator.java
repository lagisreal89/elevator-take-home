package scripts;
import java.util.*;

public abstract class Elevator {
    private double currentCapacity; // current weight of elevator in lbs
    private final double MAX_CAPACITY; // max capacity that elevator can hold in lbs
    private final double MAX_HEIGHT; // height of elevator
    private final int MAX_FLOORS; // max floors in an elevator
    public int currentFloor;  // current floor
    public final double width;
    public final double length;
    private List<Load> onElevator = new ArrayList<>(); // Assume that the elevator holds people and items 
    public boolean elevatorOpened = false;
    public Elevator (int maxFloors, double maxCapacity, double height, int floor, double width, double length){
        this.MAX_FLOORS = maxFloors;
        this.MAX_CAPACITY = maxCapacity;
        this.MAX_HEIGHT = height;
        this.currentFloor = floor;
        this.width = width;
        this.length = length;
        this.currentCapacity = 0;
    }
    public Elevator (int maxFloors, double maxCapacity, double height, int floor, int currentCapacity, double width, double length){
        this.MAX_FLOORS = maxFloors;
        this.MAX_CAPACITY = maxCapacity;
        this.MAX_HEIGHT = height;
        this.currentFloor = floor;
        this.width = width;
        this.length = length;
        this.currentCapacity = currentCapacity;
    }
    
    // object enters elevator if they meet elevator size requirements 
    public boolean enterElevator(Load object){
        if (!elevatorOpened){
            return false;
        }
        double potentialWeight = currentCapacity + object.getWeight();
        if (potentialWeight > MAX_CAPACITY || object.getHeight() > MAX_HEIGHT){
            return false;
        }
        if (object instanceof Item item){
            if ((item.getLength() > MAX_HEIGHT && item.getLength() > this.length) || item.getWidth() > this.width){
                return false;
            }
        }
        onElevator.add(object);
        currentCapacity += object.getWeight();
        return true;
    }

    // object exits elevator when exit floor is reached
    public void exitElevator(){
        int i = 0;
        while (i < onElevator.size() && this.elevatorOpened){
            if (onElevator.get(i).getFloor() == getCurrentFloor()){
                currentCapacity -= onElevator.get(i).getWeight();
                onElevator.remove(i);
            }
            else {
                i++;
            }
        }
    }

    public int getCurrentFloor(){
        return this.currentFloor;
    }

    public int upElevator(){
        if (this.currentFloor == this.MAX_FLOORS){
            return currentFloor;
        }
        currentFloor++;
        return currentFloor;
    }

    public int downElevator(){
        if (this.currentFloor == 0){
            return 0;
        }
        currentFloor--;
        return currentFloor;
    }

    public void closeElevator(){
        this.elevatorOpened = false;
    }

    public void openElevator(){
        this.elevatorOpened = true;
    }

    // returns the objects in the elevator
    public List<Load> getOnElevator() {
        return onElevator;
    }

}