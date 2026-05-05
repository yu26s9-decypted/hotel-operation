package model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
    String roomType;
    LocalDate checkedInDate;
    LocalDate checkedOutDate;
    double price;
    int numberOfNights;
    double reservationTotal;
    boolean weekend;


    public Reservation(String roomType, LocalDate checkedInDate, LocalDate checkedOutDate) {
        this.roomType = roomType;
        this.checkedInDate = checkedInDate;
        this.checkedOutDate = checkedOutDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfNights() {
        return (int) ChronoUnit.DAYS.between(checkedInDate, checkedOutDate);
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public double getReservationTotal() {
        return reservationTotal;
    }

    public void setReservationTotal(double reservationTotal) {
        this.reservationTotal = reservationTotal;
    }

    public String getRoomType() {
        return roomType.toLowerCase();
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public LocalDate getCheckedInDate() {
        return checkedInDate;
    }

    public void setCheckedInDate(LocalDate checkedInDate) {
        this.checkedInDate = checkedInDate;
    }

    public LocalDate getCheckedOutDate() {
        return checkedOutDate;
    }

    public void setCheckedOutDate(LocalDate checkedOutDate) {
        this.checkedOutDate = checkedOutDate;
    }

    public double calculateRoomPrice(Room room){
        double currentPrice = room.getPrice();

        if(isWeekend(this.checkedInDate, this.checkedOutDate)) {
            return currentPrice * 1.10;
        }

        return currentPrice;
    }

    public double calculateTotalPrice(Room room){
        double currentPrice = room.getPrice();

        return currentPrice * getNumberOfNights();
    }



    private boolean isWeekend(LocalDate checkedInDate, LocalDate checkedOutDate){
            DayOfWeek start = checkedInDate.getDayOfWeek();
            DayOfWeek end = checkedOutDate.getDayOfWeek();
            return (start == DayOfWeek.SATURDAY || start == DayOfWeek.SUNDAY) ||
                    (end == DayOfWeek.SATURDAY || end == DayOfWeek.SUNDAY);
    }

}
