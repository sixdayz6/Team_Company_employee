import java.util.ArrayList;
import java.util.Scanner;


    class Employee {
        private String employeeID;
        private String name;
        private String position;
        private String department;
        private String phoneNumber;
        private String email;
        private double salary;

        // Constructor
        public Employee(String employeeID, String name, String position, String department,
                        String phoneNumber, String email, double salary) {
            this.employeeID = employeeID;
            this.name = name;
            this.position = position;
            this.department = department;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.salary = salary;
        }

        // Getter và Setter methods
        public String getEmployeeID() {
            return employeeID;
        }

        public void setEmployeeID(String employeeID) {
            this.employeeID = employeeID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        // Hiển thị thông tin nhân viên
        public void displayInfo() {
            System.out.println("사원 ID: " + employeeID);
            System.out.println("이름: " + name);
            System.out.println("직책: " + position);
            System.out.println("부서: " + department);
            System.out.println("전화번호: " + phoneNumber);
            System.out.println("이메일: " + email);
            System.out.println("금여: " + salary);
            System.out.println("-----------------------------------");
        }
    }