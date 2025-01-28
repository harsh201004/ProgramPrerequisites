package singlylinkedlist.studentrecordmanagement;

import java.util.Scanner;
public class StudentRecordManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentOperations studentList = new StudentOperations();

        int choice;

        do {
            System.out.println("\nStudent Record Management System:");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Grade");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();
                    System.out.print("Enter Position (0 for beginning, -1 for end): ");
                    int position = scanner.nextInt();
                    if (position == -1) {
                        studentList.addStudent(rollNumber, name, age, grade, null);
                    } else {
                        studentList.addStudent(rollNumber, name, age, grade, position);
                    }
                    break;

                case 2:
                    System.out.print("Enter Roll Number to Delete: ");
                    int rollNumberToDelete = scanner.nextInt();
                    studentList.deleteStudent(rollNumberToDelete);
                    break;

                case 3:
                    System.out.print("Enter Roll Number to Search: ");
                    int rollNumberToSearch = scanner.nextInt();
                    studentList.searchStudent(rollNumberToSearch);
                    break;

                case 4:
                    System.out.print("Enter Roll Number to Update Grade: ");
                    int rollNumberToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Grade: ");
                    String newGrade = scanner.nextLine();
                    studentList.updateGrade(rollNumberToUpdate, newGrade);
                    break;

                case 5:
                    studentList.displayStudents();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
