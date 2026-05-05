package model;

public class Room {
    private String type;
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;


    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;

    }

    public Room(String type){
        this.type = type;
        this.isOccupied = false;
        this.isDirty = false;

        if(type.equalsIgnoreCase("King")){
            this.numberOfBeds = 1;
            this.price = 139.00;
        } else {
            this.numberOfBeds = 2;
            this.price = 120.00;
        }
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    public boolean isAvailable(){
        return !isOccupied && !isDirty;
    }


    public void checkIn(){
        if(isAvailable()){
            setDirty(true);
            setOccupied(true);
        }
    }

    public void checkOut(){
        setOccupied(false);
    }

    public void cleanRoom(){
        setDirty(false);
    }

    public String toString() {
        return "Room type: " + type +
                ", Price: " + price +
                ", Number of bed: " + numberOfBeds +
                ", Is Occupied: " + isOccupied +
                ", Is Dirty: " + isDirty;
    }





}
