package model;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedbasicRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this(name, numberOfSuites, numberOfRooms, 0,0);
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedbasicRooms){
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedbasicRooms = bookedbasicRooms;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
    public int getNumberOfSuites() {
        return numberOfSuites - this.bookedSuites;
    }
    private void setNumberOfSuites(int numberOfSuites) {
        this.numberOfSuites = numberOfSuites;
    }
    public int getNumberOfRooms() {
        return numberOfRooms - this.bookedbasicRooms;
    }
    private void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
    public int getBookedSuites() {
        return bookedSuites;
    }
    private void setBookedSuites(int bookedSuites) {
        this.bookedSuites = bookedSuites;
    }
    public int getBookedbasicRooms() {
        return bookedbasicRooms;
    }
    private void setBookedbasicRooms(int bookedbasicRooms) {
        this.bookedbasicRooms = bookedbasicRooms;
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite){
        if (isSuite){
            if(this.bookedSuites + numberOfRooms <= this.numberOfSuites ){
                this.bookedSuites += numberOfRooms;
                return true;
            }
        } else if (this.bookedbasicRooms + numberOfRooms <= this.numberOfRooms) {
            this.bookedbasicRooms += numberOfRooms;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Hotel name: " + name +
                ", Booked Basic Rooms: " + bookedbasicRooms +
                ", Booked Suites: " + bookedSuites +
                ", Available Basic: " + numberOfRooms +
                ", Available Suites: " + numberOfSuites;
    }




}
