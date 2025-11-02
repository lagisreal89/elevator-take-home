package scripts;
import java.util.*;

public abstract class Elevator {
    private double currentCapacity; // current weight of elevator in lbs
    private final double MAX_CAPACITY; // max capacity that elevator can hold in lbs
    private final double MAX_HEIGHT; // height of elevator
    private final int MAX_FLOORS; // max floors in an elevator
    public int currentFloor;  // current floor
    public double width;
    public double length;
    private List<Load> onElevator = new ArrayList<>(); // Assume that the elevator holds people 
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
    public boolean personEnterElevator(Person p){
        double potentialWeight = this.currentCapacity + p.getWeight();
        if ((MAX_CAPACITY < potentialWeight || MAX_HEIGHT < p.getHeight()) && this.elevatorOpened){
            return false;
        }
        onElevator.add(p);
        currentCapacity += p.getWeight();
        return true;
    }

    public boolean personEnterElevator(double height, double weight, int floor){
        Person p = new Person(height, weight, floor);
        double potentialWeight = this.currentCapacity + p.getWeight();
        if (MAX_CAPACITY < potentialWeight || MAX_HEIGHT < p.getHeight()){
            return false;
        }
        onElevator.add(p);
        currentCapacity += p.getWeight();
        return true;
    }

    public boolean itemEnterElevator(Item s){
        double potentialWeight = this.currentCapacity + s.getWeight();
        if ((MAX_CAPACITY < potentialWeight || MAX_HEIGHT < s.getHeight() || MAX_HEIGHT < s.getLength() || this.width < s.getWidth()) && this.elevatorOpened){
            return false;
        }
        onElevator.add(s);
        currentCapacity += s.getWeight();
        return true;
    }

    public boolean itemEnterElevator(int weight, int height, int length, int width, int floor){
        Item item = new Item(weight, height, length, width, floor);
        double potentialWeight = this.currentCapacity + item.getWeight();
        if ((MAX_CAPACITY < potentialWeight || MAX_HEIGHT < item.getHeight() || MAX_HEIGHT < item.getLength()) && this.elevatorOpened){
            return false;
        }
        onElevator.add(item);
        currentCapacity += item.getWeight();
        return true;
    }

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
        return this.currentFloor++;
    }

    public int downElevator(){
        if (this.currentFloor == 0){
            return 0;
        }
        return this.currentFloor--;
    }

    public void closeElevator(){
        this.elevatorOpened = false;
    }

    public void openElevator(){
        this.elevatorOpened = true;
    }

    public List<Load> getThingsOnElevator() {
        return this.onElevator;
    }

}