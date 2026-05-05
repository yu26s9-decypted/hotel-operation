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

    public Instant punchIn(){
        String empN = this.employeeName;
        int empId = this.employeeId;
        double empPayrate = this.payRate;

        Instant empPunchInTime = Instant.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:mm a")
                .withZone(ZoneId.systemDefault());
        String formattedTime = dtf.format(empPunchInTime);

        System.out.printf("%s clocked in at: %s\n", empN, formattedTime);


        return empPunchInTime;


    }


    public Instant punchOut(Instant punchInTime, Instant endTime){

        String empN = this.employeeName;

        Duration empWorkTime = Duration.between(punchInTime, endTime);
        long h = empWorkTime.toHours();
        long m = empWorkTime.toMinutes();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm a")
                .withZone(ZoneId.systemDefault());

        String formattedTime = dtf.format(endTime);
        System.out.printf("%s clocked out at: %s\n", empN, formattedTime);
        System.out.printf("Worked for %d %d", h,m);


        return endTime;
    }

    public Instant simulateWorkDay(Instant start){
        Instant simulation = start.plus(8, ChronoUnit.HOURS);

        Duration empWorkSimulation = Duration.between(start, simulation);
        long h = empWorkSimulation.toHours();
        long m = empWorkSimulation.toMinutes();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm a")
                .withZone(ZoneId.systemDefault());

        String formattedTime = dtf.format(simulation);

        System.out.printf("Simulating a workday...Skipping time by 8hrs. %s. Formatted: %s\n",simulation, formattedTime);
        return simulation;
    }













}


