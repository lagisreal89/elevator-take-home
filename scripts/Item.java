package scripts;

public class Item extends Load{
    private double length;
    private double width;
    public Item(double weight, double height, double length, double width, int floor){
        super(height, weight, floor);
        setLength(length);
        setWidth(width);
    }

    private void setLength(double length){
        if (length > 0){
            this.length = length;
        }
    }

    private void setWidth(double width2){
        if (width2 > 0){
            this.width = width2;
        }
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

}
