package model;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String department;
    private double payRate;
    private double hoursWorked;
    private boolean isClockedIn;
    private Instant punchInTime;
    
    public Employee(int employeeId, String employeeName, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }



    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }


    public boolean isClockedIn() {
        return isClockedIn;
    }

    public void setClockedIn(boolean clockedIn) {
        isClockedIn = clockedIn;
    }

    public Instant getPunchInTime() {
        return punchInTime;
    }

    public void setPunchInTime(Instant punchInTime) {
        this.punchInTime = punchInTime;
    }


    public double getRegularHours(){
        return Math.min(hoursWorked, 40);
    }
    public double getOvertimeHours(){
        return Math.max(0, hoursWorked - 40);
    }
    public double getOverTimePay(){
        return payRate * 1.5;
    }

    public double getTotalPay(){
        double regularPay = payRate * getRegularHours();
        double overTimePay = getOverTimePay() * getOvertimeHours();
        double totalPay = regularPay + overTimePay;
        return totalPay;
    }

    public double getShiftPay(Instant startTime, Instant endTime){
        Duration workDur = Duration.between(startTime, endTime);
        double dHours = workDur.toHours();
        System.out.println(dHours);

        return dHours * this.payRate;
    }

//    public Instant punchIn(){
//        String empN = this.employeeName;
//        int empId = this.employeeId;
//        double empPayrate = this.payRate;
//
//
//        Instant empPunchInTime = Instant.now();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:mm a")
//                .withZone(ZoneId.systemDefault());
//        String formattedTime = dtf.format(empPunchInTime);
//
//
//
//        System.out.printf("%s clocked in at: %s\n", empN, formattedTime);
//        return empPunchInTime;
//
//    }


//    public Instant punchOut(Instant punchInTime, Instant endTime){
//
//        String empN = this.employeeName;
//        Duration empWorkTime = Duration.between(punchInTime, endTime);
//        long h = empWorkTime.toHours();
//        long m = empWorkTime.toMinutesPart();
//        double shiftPay = getShiftPay(punchInTime, endTime);
//
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm a")
//                .withZone(ZoneId.systemDefault());
//
//        String formattedTime = dtf.format(endTime);
//        System.out.printf("%s clocked out at: %s\n", empN, formattedTime);
//        System.out.printf("%s %d Worked for (%d hour %d minute). Hourly Rate: $%.2f, Pay for this shift: $%.2f\n",this.employeeName, this.employeeId, h,m, this.payRate, shiftPay);
//
//
//        return endTime;
//    }
//
//    public Instant simulateWorkDay(Instant start){
//        Instant simulation = start.plus(8, ChronoUnit.HOURS)
//                .plus(15, ChronoUnit.MINUTES);
//
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm a")
//                .withZone(ZoneId.systemDefault());
//
//        String formattedTime = dtf.format(simulation);
//
//        return simulation;
//    }


    /**
     * This records the time punch for a employee.
     * If the employee isn't already punched in, it will start a new shift.
     * If employee is already clocked in, it will complete the current shift and calculate the hours worked
     * @return msg for punch in time and a shift summary
     */
    public String punchTimeCard(){
       if(!isClockedIn){
           this.punchInTime = Instant.now();
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:mm a")
                   .withZone(ZoneId.systemDefault());
           String formattedTime = dtf.format(punchInTime);
           this.isClockedIn = true;
           return "Clocked in at: " + formattedTime;
       } else {
           return punchTimeCard(punchInTime, Instant.now());
       }
    }

    public String punchTimeCard(Instant punchInTime, Instant punchOutTime){
        Duration empWorkTime = Duration.between(punchInTime, punchOutTime);
        double shiftTimeWorked = empWorkTime.toMinutes() / 60;
        this.hoursWorked+= shiftTimeWorked;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm a")
                .withZone(ZoneId.systemDefault());

        String pInTime = dtf.format(punchInTime);
        String pOutTime = dtf.format(punchOutTime);

        return String.format("%s punched out at %s. Shift time: %d hr %d min"
                ,this.employeeName, pOutTime, empWorkTime.toHours(), empWorkTime.toMinutesPart());

    }

}


