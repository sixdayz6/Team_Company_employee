import java.util.Scanner;

public class CompanyEmployeeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CompanyEmployeeManager manager = new CompanyEmployeeManager();

        int choice;
        do {
            System.out.println("\n===== 회사 직원 관리 시스템 =====");
            System.out.println("1. 새 직원 추가");
            System.out.println("2. 모든 직원 정보 보기");
            System.out.println("3. ID로 직원 찾기");
            System.out.println("4. 직원 정보 수정");
            System.out.println("5. 직원 삭제");
            System.out.println("6. 직원 수 확인");
            System.out.println("0. 종료");
            System.out.print("선택: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- 새 직원 추가---");
                    System.out.print("사원 ID 입력: ");
                    String id = scanner.nextLine();

                    // ID 중복 확인
                    if (manager.findEmployeeByID(id) != null) {
                        System.out.println("이미 있는 ID!");
                        break;
                    }

                    System.out.print("이름: ");
                    String name = scanner.nextLine();
                    System.out.print("직책: ");
                    String position = scanner.nextLine();
                    System.out.print("부서: ");
                    String department = scanner.nextLine();
                    System.out.print("전화번호: ");
                    String phone = scanner.nextLine();
                    System.out.print("이메일: ");
                    String email = scanner.nextLine();
                    System.out.print("급여: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();
                    Employee newEmployee = new Employee(id, name, position, department, phone, email, salary);
                    manager.addEmployee(newEmployee);
                    break;

                case 2:
                    System.out.println("\n---모든 직원 정보 출력 ---");
                    manager.displayAllEmployees();
                    break;

                case 3:
                    System.out.println("\n--- ID로 직원 찾기  ---");
                    System.out.print("직원 찾기 : ");
                    String searchID = scanner.nextLine();

                    Employee foundEmployee = manager.findEmployeeByID(searchID);
                    if (foundEmployee != null) {
                        System.out.println("직원 정보:");
                        foundEmployee.displayInfo();
                    } else {
                        System.out.println("해당 ID의 직원을 찾을 수 없습니다: " + searchID);
                    }
                    break;

                case 4:
                    System.out.println("\n--- 직원 정보 수정 ---");
                    System.out.print("수정할 사원 ID 입력: ");
                    String updateID = scanner.nextLine();

                    Employee empToUpdate = manager.findEmployeeByID(updateID);
                    if (empToUpdate == null) {
                        System.out.println("해당 ID의 직원을 찾을 수 없습니다: " + updateID);
                        break;
                    }

                    System.out.println("현재 정보:");
                    empToUpdate.displayInfo();

                    System.out.print("새 이름 입력 (변경 없으면 Enter): ");
                    String newName = scanner.nextLine();
                    if (!newName.isEmpty()) {
                        empToUpdate.setName(newName);
                    }

                    System.out.print("새 직책 입력 (변경 없으면 Enter): ");
                    String newPosition = scanner.nextLine();
                    if (!newPosition.isEmpty()) {
                        empToUpdate.setPosition(newPosition);
                    }

                    System.out.print("새 부서 입력 (변경 없으면 Enter)): ");
                    String newDepartment = scanner.nextLine();
                    if (!newDepartment.isEmpty()) {
                        empToUpdate.setDepartment(newDepartment);
                    }

                    System.out.print("새 전화번호 입력 (변경 없으면 Enter): ");
                    String newPhone = scanner.nextLine();
                    if (!newPhone.isEmpty()) {
                        empToUpdate.setPhoneNumber(newPhone);
                    }

                    System.out.print("새 이메일 입력 (변경 없으면 Enter): ");
                    String newEmail = scanner.nextLine();
                    if (!newEmail.isEmpty()) {
                        empToUpdate.setEmail(newEmail);
                    }

                    System.out.print("새 급여 입력 (변경 없으면 0 입력): ");
                    double newSalary = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ ký tự newline
                    if (newSalary != 0) {
                        empToUpdate.setSalary(newSalary);
                    }

                    System.out.println("정보 수정 완료!");
                    break;

                case 5:
                    System.out.println("\n---직원 삭제---");
                    System.out.print("삭제할 사원 ID 입력: ");
                    String deleteID = scanner.nextLine();

                    if (manager.deleteEmployee(deleteID)) {
                        System.out.println("직원 삭제 성공!");
                    } else {
                        System.out.println("해당 ID의 직원을 찾을 수 없습니다: " + deleteID);
                    }
                    break;

                case 6:
                    System.out.println("\n현재 직원 수: " + manager.getEmployeeCount());
                    break;

                case 0:
                    System.out.println("프로그램을 종료 합니다. 안녕히 가세요!");
                    break;

                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        } while (choice != 0);

        scanner.close();
    }

}





