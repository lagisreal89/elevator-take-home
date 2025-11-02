package scripts;

public class Item {
    private double height;
    private double weight;
    private double length;
    private double width;
    public Item(int weight, int height, int length, int width){
        setHeight(height);
        setLength(length);
        setWidth(width);
        setWeight(weight);
    }

    private void setHeight(int height){
        this.height = height;
    }

    private void setWeight(int weight){
        this.weight = weight;
    }

    private void setLength(int length){
        this.length = length;
    }

    private void setWidth(int width){
        this.width = width;
    }

}
