package scripts;
import java.util.*;

public abstract class Elevator {
    private double currentCapacity; // current weight of elevator in lbs
    private final double MAX_CAPACITY; // max capacity that elevator can hold in lbs
    private final double MAX_HEIGHT; // height of elevator
    public int currentFloor;  // current floor
    private final List<Person> peopleOnElevator = new ArrayList<>(); // Assume that the elevator holds people 
    public boolean elevatorOpened = false;
    public Elevator (double maxCapacity, double height, int floor){
        this.MAX_CAPACITY = maxCapacity;
        this.MAX_HEIGHT = height;
        this.currentFloor = floor;
        this.currentCapacity = 0;
    }
    public Elevator (double maxCapacity, double height, int floor, int currentCapacity){
        this.MAX_CAPACITY = maxCapacity;
        this.MAX_HEIGHT = height;
        this.currentFloor = floor;
        this.currentCapacity = currentCapacity;
    }
    public boolean enterElevator(Person p) throws IllegalArgumentException{
        double potentialWeight = this.currentCapacity + p.getWeight();
        if ((MAX_CAPACITY < potentialWeight || MAX_HEIGHT < p.getHeight()) && this.elevatorOpened){
            throw new IllegalArgumentException("Cannot add person due to elevator constraints");
        }
        peopleOnElevator.add(p);
        return true;
    }

    public boolean enterElevator(double height, double weight, int floor){
        Person p = new Person(height, weight, floor);
        double potentialWeight = this.currentCapacity + p.getWeight();
        if (MAX_CAPACITY < potentialWeight || MAX_HEIGHT < p.getHeight()){
            throw new IllegalArgumentException("Cannot add person due to elevator constraints");
        }
        peopleOnElevator.add(p);
        return true;
    }

    public void exitElevator(){
        int i = 0;
        while (i < peopleOnElevator.size() && this.elevatorOpened){
            if (peopleOnElevator.get(i).getFloor() == getCurrentFloor()){
                peopleOnElevator.remove(i);
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
        return this.currentFloor++;
    }

    public int downElevator(){
        return this.currentFloor--;
    }

    public void closeElevator(){
        this.elevatorOpened = false;
    }

    public void openElevator(){
        this.elevatorOpened = true;
    }

}