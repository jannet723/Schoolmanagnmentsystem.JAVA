import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolManagementSystem {
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int studentIdCounter = 1;

    public static void main(String[] args) {
        System.out.println("🎓 Welcome to School Management System 🎓");
        showMainMenu();
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Students");
            System.out.println("4. View Statistics");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudents();
                    break;
                case 4:
                    showStatistics();
                    break;
                case 5:
                    System.out.println("Thank you for using School Management System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addNewStudent() {
        System.out.println("\n=== ADD NEW STUDENT ===");
        
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Class ID: ");
        int classId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Gender (Male/Female/Other): ");
        String gender = scanner.nextLine();
        
        System.out.print("Date of Birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();
        
        System.out.print("Address: ");
        String address = scanner.nextLine();
        
        System.out.print("Phone Number: ");
        String phone = scanner.nextLine();
        
        Student student = new Student(
            studentIdCounter++,
            firstName,
            lastName,
            classId,
            gender,
            dateOfBirth,
            address,
            phone
        );
        
        students.add(student);
        System.out.println("\n✅ Student added successfully!");
    }

    private static void viewAllStudents() {
        System.out.println("\n=== ALL STUDENTS ===");
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        
        System.out.println("ID\tName\t\tClass\tGender");
        System.out.println("----------------------------------------");
        for (Student student : students) {
            System.out.printf("%d\t%s %s\t%d\t%s\n",
                student.getStudentId(),
                student.getFirstName(),
                student.getLastName(),
                student.getClassId(),
                student.getGender()
            );
        }
    }

    private static void searchStudents() {
        System.out.println("\n=== SEARCH STUDENTS ===");
        System.out.print("Enter search term (name or ID): ");
        String searchTerm = scanner.nextLine().toLowerCase();
        
        List<Student> searchResults = new ArrayList<>();
        for (Student student : students) {
            if (String.valueOf(student.getStudentId()).contains(searchTerm) ||
                student.getFirstName().toLowerCase().contains(searchTerm) ||
                student.getLastName().toLowerCase().contains(searchTerm) ||
                (student.getFirstName() + " " + student.getLastName()).toLowerCase().contains(searchTerm)) {
                searchResults.add(student);
            }
        }
        
        if (searchResults.isEmpty()) {
            System.out.println("No matching students found.");
            return;
        }
        
        System.out.println("\nSearch Results:");
        System.out.println("ID\tName\t\tClass\tGender");
        System.out.println("----------------------------------------");
        for (Student student : searchResults) {
            System.out.printf("%d\t%s %s\t%d\t%s\n",
                student.getStudentId(),
                student.getFirstName(),
                student.getLastName(),
                student.getClassId(),
                student.getGender()
            );
        }
    }

    private static void showStatistics() {
        System.out.println("\n=== STATISTICS ===");
        int totalStudents = students.size();
        int maleCount = 0;
        int femaleCount = 0;
        
        for (Student student : students) {
            if (student.getGender().equalsIgnoreCase("Male")) {
                maleCount++;
            } else if (student.getGender().equalsIgnoreCase("Female")) {
                femaleCount++;
            }
        }
        
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Male Students: " + maleCount);
        System.out.println("Female Students: " + femaleCount);
        System.out.println("Other: " + (totalStudents - maleCount - femaleCount));
    }
}

