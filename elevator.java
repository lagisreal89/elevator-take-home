public class elevator {
    private double current_capacity;
    private int number_of_people;
    private double MAX_CAPACITY;
    public elevator (double capacity, int people){
        this.current_capacity = capacity;
        this.number_of_people = people;
    }

    public boolean enterElevator(){
        return false;
    }

    public boolean exitElevator(){
        return false;
    }

}