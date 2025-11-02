package scripts;
public class Person {
    private double height;
    private double weight;
    private int exitFloor;
    public Person(double height, double weight, int floorToExit){
        setHeight(height);
        setWeight(weight);
        setFloor(floorToExit);
    }

    private void setHeight(double height){
        this.height = height;
    }

    private void setWeight(double weight){
        this.weight = weight;
    }

    private void setFloor(int floor){
        this.exitFloor = floor;
    }

    public int getFloor(){
        return this.exitFloor;
    }

    public double getWeight(){
        return this.weight;
    }

    public double getHeight(){
        return this.height;
    }
}
