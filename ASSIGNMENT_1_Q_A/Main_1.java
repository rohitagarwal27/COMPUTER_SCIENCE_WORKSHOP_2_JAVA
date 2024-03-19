// Q5. Developing a Simple College Management System in Java
// Create a Java program for managing colleges and students. The provided classes model the 
// relationship between colleges and students.
// The College class represents a college with attributes collegeName and collegeLoc. The 
// Student class represents a student with attributes studentId, studentName, and a reference
// to a College object. Enhance the Student class by adding a constructor that assigns a student 
// ID, name, and college information. Additionally, add a method named displayStudentInfo()
// that prints the student's ID, name, and the college information in which they are enrolled 
// In the Main class, instantiate at least two College objects and at least two Student objects. 
// Enroll each student in one of the colleges. Then, display the information of all colleges and all 
// students using the appropriate methods

class College {
    private String collegeName;
    private String collegeLoc;

    public College(String collegeName, String collegeLoc) {
        this.collegeName = collegeName;
        this.collegeLoc = collegeLoc;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeLoc() {
        return collegeLoc;
    }

    public void setCollegeLoc(String collegeLoc) {
        this.collegeLoc = collegeLoc;
    }

    public void displayCollegeInfo() {
        System.out.println("College Name: " + getCollegeName());
        System.out.println("Location: " + getCollegeLoc());
    }
}

class Student {
    private int studentId;
    private String studentName;
    private College college;

    public Student(int studentId, String studentName, College college) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.college = college;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public void displayStudentInfo() {
        System.out.println("Student ID: " + getStudentId());
        System.out.println("Student Name: " + getStudentName());
        System.out.println("College: " + getCollege().getCollegeName());
        System.out.println("Location: " + getCollege().getCollegeLoc());
    }
}

public class Main_1 {
    public static void main(String[] args) {
        College obj1 = new College("ABC", "City1");
        College obj2 = new College("XYZ", "City2");

        Student s1 = new Student(1, "x", obj1);
        Student s2 = new Student(2, "y", obj2);

        s1.displayStudentInfo();
        System.out.println();
        s2.displayStudentInfo();
        System.out.println();
        obj1.displayCollegeInfo();
        System.out.println();
        obj2.displayCollegeInfo();
    }
}

// output Student ID: 1
// Student Name: x
// College: ABC
// Location: City1
//
// Student ID: 2
// Student Name: y
// College: XYZ
// Location: City2
//
// College Name: ABC
// Location: City1
//
// College Name: XYZ
// Location: City2