import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement management = new StudentManagement();

        while (true) {
            try {
                System.out.println("\n=== MENU ===");
                System.out.println("1. Thêm học sinh");
                System.out.println("2. Hiển thị danh sách học sinh");
                System.out.println("3. Cập nhật điểm học sinh");
                System.out.println("4. Xóa học sinh");
                System.out.println("5. Tìm kiếm học sinh");
                System.out.println("6. Sắp xếp học sinh theo điểm");
                System.out.println("7. Sắp xếp học sinh theo tên");
                System.out.println("8. Thoát");
                System.out.print("Chọn chức năng (1-8): ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Nhập mã học sinh: ");
                        String id = scanner.nextLine();

                        String name;
                        while (true) {
                            System.out.print("Nhập tên học sinh: ");
                            name = scanner.nextLine();
                            if (name.matches("[a-zA-Z\\s]+")) { // Check if name contains only letters and spaces
                                break;
                            } else {
                                System.out.println("Tên không hợp lệ! Vui lòng nhập lại bằng chữ.");
                            }
                        }

                        double score;
                        while (true) {
                            System.out.print("Nhập điểm học sinh (0-10): ");
                            score = Double.parseDouble(scanner.nextLine());
                            if (score >= 0 && score <= 10) {
                                break;
                            } else {
                                System.out.println("Điểm không hợp lệ! Vui lòng nhập lại trong khoảng từ 0 đến 10.");
                            }
                        }

                        management.addLast(new Student(id, name, score));
                        System.out.println("Đã thêm học sinh thành công.");
                        break;

                    case 2:
                        management.traverse();
                        break;

                    case 3:
                        System.out.print("Nhập mã học sinh cần cập nhật: ");
                        id = scanner.nextLine();

                        while (true) {
                            System.out.print("Nhập điểm mới (0-10): ");
                            score = Double.parseDouble(scanner.nextLine());
                            if (score >= 0 && score <= 10) {
                                break;
                            } else {
                                System.out.println("Điểm không hợp lệ! Vui lòng nhập lại trong khoảng từ 0 đến 10.");
                            }
                        }
                        management.updateStudent(id, score);
                        break;

                    case 4:
                        System.out.print("Nhập mã học sinh cần xóa: ");
                        id = scanner.nextLine();
                        management.deleteById(id);
                        break;

                    case 5:
                        System.out.print("Nhập mã học sinh cần tìm: ");
                        id = scanner.nextLine();
                        Student student = management.searchById(id);
                        if (student != null) {
                            System.out.println(student);
                        } else {
                            System.out.println("Không tìm thấy học sinh!");
                        }
                        break;

                    case 6:
                        management.bubbleSortByScore();
                        break;

                    case 7:
                        management.insertionSortByName();
                        break;

                    case 8:
                        System.out.println("Thoát chương trình.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi nhập liệu! Vui lòng nhập một số nguyên.");
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
    }
}