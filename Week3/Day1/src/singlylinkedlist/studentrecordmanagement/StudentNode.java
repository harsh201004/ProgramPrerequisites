package singlylinkedlist.studentrecordmanagement;
import java.util.Scanner;
public class StudentNode {
        int rollNumber;
        String name;
        int age;
        String grade;
        StudentNode next;

        // Constructor to initialize a student node
        public StudentNode(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
}
