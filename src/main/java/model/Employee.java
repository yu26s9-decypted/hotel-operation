package model;

public class Employee {
    double totalPay;
    double regularHour;
    double overtimeHour;
    private int employeeId;
    private String employeeName;
    private String department;
    private double payRate;
    private double hoursWorked;

    public Employee(double totalPay, double regularHour, double overtimeHour) {
        this.totalPay = totalPay;
        this.regularHour = regularHour;
        this.overtimeHour = overtimeHour;
    }




}


