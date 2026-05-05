import model.Employee;
import model.Hotel;
import model.Reservation;
import model.Room;
import ui.Console;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args){
        testHotel();
        System.out.printf("=".repeat(100) + "\n");
        testEmployee();
        System.out.printf("=".repeat(100) + "\n");
        testReservation();
        System.out.printf("=".repeat(100) + "\n");
        testRoom();
        System.out.printf("=".repeat(100) + "\n");


    }

    public static void testReservation(){
        LocalDate today = LocalDate.now();
        LocalDate checkIn = LocalDate.of(2026, 5, 8);
        LocalDate checkOut = LocalDate.of(2026, 5, 10);
        Reservation myReservation = new Reservation("kIng", checkIn, checkOut);
        System.out.printf("Today is %s\n", today);


        Room r1 = new Room(1, 139.00, false, false);

        double finalPrice = myReservation.calculateRoomPrice(r1);
        double totalPriceForStay = finalPrice * myReservation.getNumberOfNights();

        /**
         * Room Test Case
         */
        if(r1.isDirty()){
            System.out.println("Room is dirty and isn't available. Sorry!");
        } else if (r1.isOccupied()) {
            System.out.println("This room is already occupied!");
        } else {
            System.out.printf("Thank you! You're checked out for the %s room on %s to %s $%.2f. You are staying %s nights. Total: $%.2f %n", myReservation.getRoomType(), checkIn, checkOut, finalPrice, myReservation.getNumberOfNights(), totalPriceForStay);
            r1.checkIn();
            System.out.printf("Base Price: $%.2f\n", r1.getPrice());
            System.out.println("Total Price with Surcharge" + finalPrice);

            boolean passingDayOption = true;
            while(passingDayOption){
                try {
                    String userInput = Console.askForString("Would you like to pass a day? (y/n)");
                    if(userInput.equalsIgnoreCase("y")){
                        today = today.plusDays(1);
                        System.out.printf("Time skipped. Today is: %s", today);
                    } else if (userInput.equalsIgnoreCase("n")) {
                        break;
                    }
                } catch (Exception e){
                    System.out.println("Invalid");
                }
            }

        }

    }

    public static void testRoom(){
        Room r1 = new Room(2, 140, true, true);
        System.out.printf("Room is available? %s\n", r1.isAvailable());
        Room r2 = new Room(2, 140, false, false);
        System.out.printf("Room is available? %s\n", r2.isAvailable());
    }

    public static void testEmployee(){
        Employee e = new Employee(1, "Samuel Veloz", "Engineering", 150, 55);
        double sam = e.getTotalPay();

        System.out.printf("%s Salary: $%.2f for %.0f hours worked\n", e.getEmployeeName(), sam, e.getHoursWorked());
        System.out.printf("Overtime Pay $%.2f for %.0f hours of overtime\n", e.getOverTimePay(), e.getOvertimeHours());

        String pIn = e.punchTimeCard();

        System.out.printf("\u001B[36m[log]\u001B[0m \u001B[32m%-15s\u001B[0m(ID: \u001B[33m%d\u001B[0m) \u001B[36mPunch In:\u001B[0m %s\n", e.getEmployeeName(), e.getEmployeeId(), pIn);

        String userInput = Console.askForString("Simulate a 8hr shift?");
        {
            if(userInput.equalsIgnoreCase("y"))
            {
                Instant simulationTimeSkip = e.getPunchInTime().plus(8, ChronoUnit.HOURS);
                System.out.println(e.punchTimeCard(e.getPunchInTime(), simulationTimeSkip));
            } else {
                System.out.println(e.punchTimeCard());
            }
        }

        System.out.printf("Total hours worked: %s", e.getHoursWorked());

    }

    public static void testHotel(){
        Hotel h = new Hotel("Wynn", 12, 4);
        System.out.println(h);

        String m = """
                \t Welcome to Cabin Inn!
                \t How many rooms will you be booking?
                \t (x) to exit
                """;

        String promptForRoom = "";
        boolean completedBooking = false;
        boolean isSuite = false;
        int roomCount = 0;
        while(!completedBooking){
            promptForRoom = Console.askForString("How many rooms");
            try {
                roomCount = Integer.parseInt(promptForRoom);

                String promptForSuite = Console.askForString("Would you like a suite room?");
                if(promptForSuite.equalsIgnoreCase("y")){
                    isSuite = true;
                } else {
                    isSuite = false;
                }
            } catch (Exception e){
                System.out.println(e.getMessage());

            }
            boolean success = h.bookRoom(roomCount, isSuite);

            if(!success){
                System.out.println("Your selection isn't available!");
            } else {
                System.out.println("Thank you! You're all set." + h.getNumberOfRooms() + h.getNumberOfSuites());
                System.out.println(h);
                completedBooking = true;
            }
        }




    }


}
