import java.util.ArrayList;

public class CompanyEmployeeManager {
    private ArrayList<Employee> employees;

    public CompanyEmployeeManager() {
        employees = new ArrayList<>();
    }

    // Thêm nhân viên mới
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Đã thêm nhân viên thành công!");
    }

    // Hiển thị tất cả nhân viên
    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống!");
            return;
        }

        System.out.println("===== DANH SÁCH NHÂN VIÊN =====");
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

    // Cập nhật thông tin nhân viên
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

    // Xóa nhân viên
    public boolean deleteEmployee(String employeeID) {
        Employee emp = findEmployeeByID(employeeID);
        if (emp != null) {
            employees.remove(emp);
            return true;
        }
        return false;
    }

    // Lấy số lượng nhân viên
    public int getEmployeeCount() {
        return employees.size();
    }
}

