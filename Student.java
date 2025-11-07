public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private int classId;
    private String gender;
    private String dateOfBirth;
    private String address;
    private String phone;

    // Constructor
    public Student(int studentId, String firstName, String lastName, 
                   int classId, String gender, String dateOfBirth, 
                   String address, String phone) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.classId = classId;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getClassId() {
        return classId;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    // Setters
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", classId=" + classId +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
