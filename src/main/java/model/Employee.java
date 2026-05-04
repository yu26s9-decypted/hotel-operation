package model;

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










}


