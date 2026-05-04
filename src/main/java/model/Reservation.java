package model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Reservation {
    String roomType;
    LocalDate checkedInDate;
    LocalDate checkedOutDate;
    double price;
    int numberOfNights;
    boolean isWeekend;
    double reservationTotal;

    public Reservation(String roomType, LocalDate checkedInDate, LocalDate checkedOutDate, boolean isWeekendStay) {
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
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public double getReservationTotal() {
        return reservationTotal;
    }

    public void setReservationTotal(double reservationTotal) {
        this.reservationTotal = reservationTotal;
    }

    public String getRoomType() {
        return roomType;
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

    public boolean isWeekend(LocalDate checkedInDate, LocalDate checkedOutDate){
            DayOfWeek start = checkedInDate.getDayOfWeek();
            DayOfWeek end = checkedOutDate.getDayOfWeek();
            return (start == DayOfWeek.SATURDAY || start == DayOfWeek.SUNDAY) ||
                    (end == DayOfWeek.SATURDAY || end == DayOfWeek.SUNDAY);
    }



}
