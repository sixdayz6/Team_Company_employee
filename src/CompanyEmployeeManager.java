import java.util.ArrayList;

public class CompanyEmployeeManager {
    private ArrayList<Employee> employees;

    public CompanyEmployeeManager() {
        employees = new ArrayList<>();
    }


    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("직원 추가 성공!");
    }

    // Hiển thị tất cả nhân viên
    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("직원 목록이 비어 있습니다!");
            return;
        }

        System.out.println("===== 직원 목록 =====");
        for (Employee emp : employees) {
            emp.displayInfo();
        }
    }

    // Tìm nhân viên theo ID
    public Employee findEmployeeByID(String employeeID) {
        for (Employee emp : employees) {
            if (emp.getEmployeeID().equals(employeeID)) {
                return emp;
            }
        }
        return null;
    }

    public boolean updateEmployee(String employeeID, String name, String position,
                                  String department, String phoneNumber, String email, double salary) {
        Employee emp = findEmployeeByID(employeeID);
        if (emp != null) {
            emp.setName(name);
            emp.setPosition(position);
            emp.setDepartment(department);
            emp.setPhoneNumber(phoneNumber);
            emp.setEmail(email);
            emp.setSalary(salary);
            return true;
        }
        return false;
    }


    public boolean deleteEmployee(String employeeID) {
        Employee emp = findEmployeeByID(employeeID);
        if (emp != null) {
            employees.remove(emp);
            return true;
        }
        return false;
    }


    public int getEmployeeCount() {
        return employees.size();
    }
}


