package com.cbt.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("employee_id")
    
    private Long employeeId;
    @SerializedName("first_name")
    
    private String firstName;
    @SerializedName("last_name")
    
    private String lastName;
    @SerializedName("email")
    
    private String email;
    @SerializedName("phone_number")
    
    private String phoneNumber;
    @SerializedName("hire_date")
    
    private String hireDate;
    @SerializedName("job_id")
    
    private String jobId;
    @SerializedName("salary")
    
    private Long salary;
    @SerializedName("commission_pct")
    
    private Object commissionPct;
    @SerializedName("manager_id")
    
    private Object managerId;
    @SerializedName("department_id")
    
    private Long departmentId;
    @SerializedName("links")
    
    private List<Link> links = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Employee() {
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param jobId
     * @param hireDate
     * @param phoneNumber
     * @param departmentId
     * @param employeeId
     * @param links
     * @param managerId
     * @param salary
     * @param email
     * @param commissionPct
     */
    public Employee(Long employeeId, String firstName, String lastName, String email, String phoneNumber, String hireDate, String jobId, Long salary, Object commissionPct, Object managerId, Long departmentId, List<Link> links) {
        super();
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.managerId = managerId;
        this.departmentId = departmentId;
        this.links = links;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Object getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(Object commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Object getManagerId() {
        return managerId;
    }

    public void setManagerId(Object managerId) {
        this.managerId = managerId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", jobId='" + jobId + '\'' +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ", managerId=" + managerId +
                ", departmentId=" + departmentId +
                ", links=" + links +
                '}';
    }
}