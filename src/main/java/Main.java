import model.Employee;
import model.Reservation;
import model.Room;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){

        Room myRoom = new Room(1, 139.00, false, false, true);

        LocalDate checkIn = LocalDate.of(2026, 5, 8);
        LocalDate checkOut = LocalDate.of(2026, 5, 10);

        Reservation myReservation = new Reservation("kIng", checkIn, checkOut);
        double finalPrice = myReservation.calculateRoomPrice(myRoom);
        double totalPriceForStay = finalPrice * myReservation.getNumberOfNights();

        System.out.printf("All good! You're checked out for the %s room on %s to %s $%.2f. You are staying %s nights. Total: $%.2f %n", myReservation.getRoomType(), checkIn, checkOut, finalPrice, myReservation.getNumberOfNights(), totalPriceForStay);
        System.out.println("Base Price: $" + myRoom.getPrice());
        System.out.println("Calculated Price: $" + finalPrice);


        Employee e = new Employee(1, "Samuel", "Engineering", 150, 40);
        double samsSalary = e.getTotalPay();


        System.out.printf("%s Salary: $%.2f for %.0f hours worked", e.getEmployeeName(), samsSalary, e.getHoursWorked());
    }
}
