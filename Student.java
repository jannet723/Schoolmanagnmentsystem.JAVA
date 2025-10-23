
public class Student {

    private int studentId;
    private String firstName;
    private String lastName;
    private int classId;
    private String gender;
    private String dob;
    private String address;
    private String phoneNumber;

    public Student(int studentId, String firstName, String lastName, int classId,
            String gender, String dob, String address, String phoneNumber) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.classId = classId;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{"
                + "studentId=" + studentId
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", classId=" + classId
                + ", gender='" + gender + '\''
                + ", dob='" + dob + '\''
                + ", address='" + address + '\''
                + ", phoneNumber='" + phoneNumber + '\''
                + '}';
    }
}
