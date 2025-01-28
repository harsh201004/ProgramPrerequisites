package singlylinkedlist.studentrecordmanagement;

public class StudentOperations {
    private StudentNode head;

    // Add a student at the beginning, end, or specific position
    public void addStudent(int rollNumber, String name, int age, String grade, Integer position) {
        StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);

        // Adding at beginning
        if (position == null || position == 0 || head == null) {
            newStudent.next = head;
            head = newStudent;
        }
         // Add at specific index
        else {
            StudentNode temp = head;
            for (int i = 1; i < position && temp.next != null; i++) {
                temp = temp.next;
            }
            newStudent.next = temp.next;
            temp.next = newStudent; // add at the end of the list
        }
    }

    // Delete a student by roll number
    public void deleteStudent(int rollNumber) {
        if (head == null) {
            System.out.println("No records found.");
            return;
        }

        if (head.rollNumber == rollNumber) { // If the head is the target
            head = head.next;
            System.out.println("Student with Roll Number " + rollNumber + " deleted.");
            return;
        }

        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student with Roll Number " + rollNumber + " deleted.");
        }
    }

    // Search for a student by roll number
    public void searchStudent(int rollNumber) {
        StudentNode temp = head;

        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Found: Roll Number: " + temp.rollNumber + ", Name: " + temp.name +
                        ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Update a student's grade by roll number
    public void updateGrade(int rollNumber, String newGrade) {
        StudentNode temp = head;

        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Updating grade for Roll Number " + rollNumber + " from " + temp.grade + " to " + newGrade);
                temp.grade = newGrade;
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Display all student records
    public void displayStudents() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("Student Records:");
        StudentNode temp = head;

        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name +
                    ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}