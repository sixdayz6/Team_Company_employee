import java.util.Scanner;

public class CompanyEmployeeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CompanyEmployeeManager manager = new CompanyEmployeeManager();

        int choice;
        do {
            System.out.println("\n===== QUẢN LÝ NHÂN VIÊN CÔNG TY =====");
            System.out.println("1. Thêm nhân viên mới");
            System.out.println("2. Hiển thị tất cả nhân viên");
            System.out.println("3. Tìm nhân viên theo mã");
            System.out.println("4. Cập nhật thông tin nhân viên");
            System.out.println("5. Xóa nhân viên");
            System.out.println("6. Số lượng nhân viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- THÊM NHÂN VIÊN MỚI ---");
                    System.out.print("Nhập mã nhân viên: ");
                    String id = scanner.nextLine();

                    // Kiểm tra xem mã nhân viên đã tồn tại chưa
                    if (manager.findEmployeeByID(id) != null) {
                        System.out.println("Mã nhân viên đã tồn tại!");
                        break;
                    }

                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập chức vụ: ");
                    String position = scanner.nextLine();
                    System.out.print("Nhập phòng ban: ");
                    String department = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String phone = scanner.nextLine();
                    System.out.print("Nhập email: ");
                    String email = scanner.nextLine();
                    System.out.print("Nhập lương: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ ký tự newline

                    Employee newEmployee = new Employee(id, name, position, department, phone, email, salary);
                    manager.addEmployee(newEmployee);
                    break;

                case 2:
                    System.out.println("\n--- DANH SÁCH NHÂN VIÊN ---");
                    manager.displayAllEmployees();
                    break;

                case 3:
                    System.out.println("\n--- TÌM NHÂN VIÊN THEO MÃ ---");
                    System.out.print("Nhập mã nhân viên: ");
                    String searchID = scanner.nextLine();

                    Employee foundEmployee = manager.findEmployeeByID(searchID);
                    if (foundEmployee != null) {
                        System.out.println("Thông tin nhân viên:");
                        foundEmployee.displayInfo();
                    } else {
                        System.out.println("Không tìm thấy nhân viên với mã: " + searchID);
                    }
                    break;

                case 4:
                    System.out.println("\n--- CẬP NHẬT THÔNG TIN NHÂN VIÊN ---");
                    System.out.print("Nhập mã nhân viên cần cập nhật: ");
                    String updateID = scanner.nextLine();

                    Employee empToUpdate = manager.findEmployeeByID(updateID);
                    if (empToUpdate == null) {
                        System.out.println("Không tìm thấy nhân viên với mã: " + updateID);
                        break;
                    }

                    System.out.println("Thông tin hiện tại:");
                    empToUpdate.displayInfo();

                    System.out.print("Nhập tên mới (ấn Enter để giữ nguyên): ");
                    String newName = scanner.nextLine();
                    if (!newName.isEmpty()) {
                        empToUpdate.setName(newName);
                    }

                    System.out.print("Nhập chức vụ mới (ấn Enter để giữ nguyên): ");
                    String newPosition = scanner.nextLine();
                    if (!newPosition.isEmpty()) {
                        empToUpdate.setPosition(newPosition);
                    }

                    System.out.print("Nhập phòng ban mới (ấn Enter để giữ nguyên): ");
                    String newDepartment = scanner.nextLine();
                    if (!newDepartment.isEmpty()) {
                        empToUpdate.setDepartment(newDepartment);
                    }

                    System.out.print("Nhập số điện thoại mới (ấn Enter để giữ nguyên): ");
                    String newPhone = scanner.nextLine();
                    if (!newPhone.isEmpty()) {
                        empToUpdate.setPhoneNumber(newPhone);
                    }

                    System.out.print("Nhập email mới (ấn Enter để giữ nguyên): ");
                    String newEmail = scanner.nextLine();
                    if (!newEmail.isEmpty()) {
                        empToUpdate.setEmail(newEmail);
                    }

                    System.out.print("Nhập lương mới (nhập 0 để giữ nguyên): ");
                    double newSalary = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ ký tự newline
                    if (newSalary != 0) {
                        empToUpdate.setSalary(newSalary);
                    }

                    System.out.println("Cập nhật thông tin thành công!");
                    break;

                case 5:
                    System.out.println("\n--- XÓA NHÂN VIÊN ---");
                    System.out.print("Nhập mã nhân viên cần xóa: ");
                    String deleteID = scanner.nextLine();

                    if (manager.deleteEmployee(deleteID)) {
                        System.out.println("Đã xóa nhân viên thành công!");
                    } else {
                        System.out.println("Không tìm thấy nhân viên với mã: " + deleteID);
                    }
                    break;

                case 6:
                    System.out.println("\nSố lượng nhân viên hiện tại: " + manager.getEmployeeCount());
                    break;

                case 0:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;

                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại!");
            }
        } while (choice != 0);

        scanner.close();
    }

}
