package model;

public class Room {
    int numberOfBeds;
    double price;
    boolean isOccupied;
    boolean isDirty;
    boolean isAvailable;

    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty, boolean isAvailabe) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
        this.isAvailable = isAvailabe;
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

    public String getRoomtype(Reservation r){
        String roomType = r.getRoomType();

        switch(roomType.toLowerCase()){
            case "king":
                setPrice(139.00);
                break;
            case "double":
                setPrice(120.00);
                break;
            default:
                System.out.println("Error");
                break;

        }
        return roomType;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }



}
