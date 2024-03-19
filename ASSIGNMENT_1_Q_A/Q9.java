// Q9. Design a Java program for managing student enrollment in a university, adhering to the 
// principles of loose coupling and high cohesion. Your program should include classes for 
// representing students (`Student`), courses (`Course`), and enrollment management 
// (`Enrollment`). Ensure that the `Enrollment` class interacts with the other classes indirectly 
// through an interface class (`EnrollmentSystem`). Implement methods for enrolling and 
// dropping students from courses, and displaying enrollment details. Create a `Main` class to 
// demonstrate the system's functionality, with appropriate error handling and user-friendly output 
// messages. Provide comments in your code explaining how loose coupling and high cohesion 
// are maintained throughout the implementation

//Interface for Enrollment System to maintain loose coupling
interface EnrollmentSystem {
    void enroll(Student s, Course c);

    void drop(Student s, Course c);

    void display();
}

// Student class
class Student {
    private String sId;
    private String sName;

    public Student(String sId, String sName) {
        this.sId = sId;
        this.sName = sName;
    }

    public String getsId() {
        return sId;
    }

    public String getsName() {
        return sName;
    }
}

// Course class
class Course {
    private String cId;
    private String cName;

    public Course(String cId, String cName) {
        this.cId = cId;
        this.cName = cName;
    }

    public String getcId() {
        return cId;
    }

    public String getcName() {
        return cName;
    }
}

// Enrollment class implementing EnrollmentSystem interface
class Enrollment implements EnrollmentSystem {
    private Student st;
    private Course co;

    @Override
    public void enroll(Student s, Course c) {
        if (st != null && st.getsId().equals(s.getsId())) {
            System.out.println(
                    "Enrollment failed. Student " + s.getsName() + " is already enrolled in course " + co.getcName());
        } else {
            st = s;
            co = c;
            System.out.println("Enrolled student " + st.getsName() + " in course " + co.getcName());
        }
    }

    @Override
    public void drop(Student s, Course c) {
        if (st != null && co != null && st.getsId().equals(s.getsId()) && co.getcId().equals(c.getcId())) {
            st = null;
            co = null;
            System.out.println("Dropped student " + s.getsName() + " from course " + c.getcName());
        } else {
            System.out.println("Drop failed. Student " + s.getsName() + " is not enrolled in course " + c.getcName());
        }
    }

    public void display() {
        if (st != null && co != null) {
            System.out.println("Enrollment Details:");
            System.out.println("Student: " + st.getsName() + ", Course: " + co.getcName());
        } else {
            System.out.println("No enrollment details available.");
        }
    }

}

public class Q9 {
    public static void main(String[] args) {
        EnrollmentSystem enrollmentSystem = new Enrollment();

        Student student1 = new Student("S1", "Rama");
        Student student2 = new Student("S2", "Laxman");

        Course course1 = new Course("C1", "CSW1");
        Course course2 = new Course("C2", "CSW2");

        enrollmentSystem.enroll(student1, course1);
        enrollmentSystem.enroll(student2, course1);
        enrollmentSystem.enroll(student1, course2);

        enrollmentSystem.display();

        enrollmentSystem.drop(student1, course1);
        enrollmentSystem.display();
    }
}
// output
// Enrolled student Rama in course CSW1
// Enrolled student Laxman in course CSW1
// Enrolled student Rama in course CSW2
// Enrollment Details:
// Student: Rama, Course: CSW2
// Drop failed. Student Rama is not enrolled in course CSW1
// Enrollment Details:
// Student: Rama, Course: CSW2
//