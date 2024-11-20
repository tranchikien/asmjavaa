import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String firstName;
    String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

public class StudentManagement {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Student Management System");
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("4. End");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    enterStudentList(scanner);
                    break;
                case 2:
                    findStudentsByLastName(scanner);
                    break;
                case 3:
                    findAndEditStudentsByFullName(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the program. See you again!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void enterStudentList(Scanner scanner) {
        System.out.print("Enter number of students to add: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();
            students.add(new Student(firstName, lastName));
        }
        System.out.println("Students added successfully.");
    }

    private static void findStudentsByLastName(Scanner scanner) {
        System.out.print("Enter last name to search: ");
        String lastNameToSearch = scanner.nextLine();
        boolean found = false;

        System.out.println("Students with last name '" + lastNameToSearch + "':");
        for (Student student : students) {
            if (student.lastName.equalsIgnoreCase(lastNameToSearch)) {
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found with the last name '" + lastNameToSearch + "'.");
        }
    }

    private static void findAndEditStudentsByFullName(Scanner scanner) {
        System.out.print("Enter full name (first and last name) to edit: ");
        String fullName = scanner.nextLine();
        boolean found = false;

        for (Student student : students) {
            if ((student.firstName + " " + student.lastName).equalsIgnoreCase(fullName)) {
                found = true;
                System.out.println("Editing student: " + student);
                
                System.out.print("Enter new first name: ");
                String newFirstName = scanner.nextLine();
                System.out.print("Enter new last name: ");
                String newLastName = scanner.nextLine();
                
                student.firstName = newFirstName;
                student.lastName = newLastName;
                
                System.out.println("Student updated successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("No student found with the name '" + fullName + "'.");
        }
    }
}
