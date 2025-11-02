package scripts;

public abstract class Load {
    private double height;
    private double weight;
    private int floor;
    public Load(double height, double weight, int floor){
        setHeight(height);
        setWeight(weight);
        setFloor(floor);
    }

    private void setHeight(double height){
        this.height = height;
    }

    private void setWeight(double weight){
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
