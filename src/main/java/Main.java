import model.Employee;
import model.Reservation;
import model.Room;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){


        LocalDate checkIn = LocalDate.of(2026, 5, 8);
        LocalDate checkOut = LocalDate.of(2026, 5, 10);

        Reservation myReservation = new Reservation("kIng", checkIn, checkOut);


        Room myRoom = new Room(1, 139.00, false, false);

        double finalPrice = myReservation.calculateRoomPrice(myRoom);
        double totalPriceForStay = finalPrice * myReservation.getNumberOfNights();

        /**
         * Room Test Case
         */
        if(myRoom.isDirty()){
            System.out.println("Room is dirty and isn't available. Sorry!");
        } else if (myRoom.isOccupied()) {
            System.out.println("This room is already occupied!");
        } else {
            System.out.printf("Thank you! You're checked out for the %s room on %s to %s $%.2f. You are staying %s nights. Total: $%.2f %n", myReservation.getRoomType(), checkIn, checkOut, finalPrice, myReservation.getNumberOfNights(), totalPriceForStay);
            System.out.printf("Base Price: $%.2f\n", myRoom.getPrice());
            System.out.println("Total Price with Surcharge" + finalPrice);
            myRoom.setOccupied(true);
        }


        Employee e = new Employee(1, "Samuel Veloz", "Engineering", 150, 55);
        double samsSalary = e.getTotalPay();

        System.out.printf("%s Salary: $%.2f for %.0f hours worked\n", e.getEmployeeName(), samsSalary, e.getHoursWorked());
        System.out.printf("Overtime Pay $%.2f for %.0f hours of overtime\n", e.getOverTimePay(), e.getOvertimeHours());

        testRoom();
    }

    public static void testRoom(){
        Room r1 = new Room(2, 140, true, true);
        System.out.printf("Room is available? %s\n", r1.isAvailable());
        Room r2 = new Room(2, 140, false, false);
        System.out.printf("Room is available? %s\n", r2.isAvailable());
    }
}
