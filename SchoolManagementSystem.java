public class schoolmanagementsystem {
    public static void main(String[] args) {
        // Create a sample student
        Student student = new Student(
            1,                  // studentId
            "John",             // firstName
            "Doe",              // lastName
            101,               // classId
            "Male",            // gender
            "2000-01-01",      // dateOfBirth
            "123 Main St",     // address
            "555-0123"         // phone
        );

        // Print the student information
        System.out.println("School Management System");
        System.out.println("Student Information:");
        System.out.println(student);
    }
}

