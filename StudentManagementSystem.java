import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    String rollNo;
    String course;

    Student(String name, String rollNo, String course) {
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static final String FILE_NAME = "students.txt";

    // Save data into file
    static void saveData() {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);

            for (Student s : students) {
                writer.write(s.name + "|" + s.rollNo + "|" + s.course);
                writer.write(System.lineSeparator());
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error: Data could not be saved.");
        }
    }

    // Load data from file
    static void loadData() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try {
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();
                String[] data = line.split("\\|", -1);

                if (data.length == 3) {
                    students.add(
                        new Student(data[0], data[1], data[2])
                    );
                }
            }

            fileScanner.close();

        } catch (IOException e) {
            System.out.println("Error: Data could not be loaded.");
        }
    }

    // Add student
    static void addStudent(Scanner sc) {

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNo = sc.nextLine();

        // Check duplicate roll number
        for (Student s : students) {
            if (s.rollNo.equalsIgnoreCase(rollNo)) {
                System.out.println("Roll Number already exists!");
                return;
            }
        }

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students.add(new Student(name, rollNo, course));

        saveData();

        System.out.println("Student Added Successfully!");
    }

    // View students
    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found.");
            return;
        }

        System.out.println("\n===== Student List =====");

        for (Student s : students) {

            System.out.println("Name: " + s.name);
            System.out.println("Roll Number: " + s.rollNo);
            System.out.println("Course: " + s.course);
            System.out.println("------------------------");
        }
    }

    // Search student
    static void searchStudent(Scanner sc) {

        System.out.print("Enter Roll Number: ");
        String rollNo = sc.nextLine();

        for (Student s : students) {

            if (s.rollNo.equalsIgnoreCase(rollNo)) {

                System.out.println("\nStudent Found!");
                System.out.println("Name: " + s.name);
                System.out.println("Roll Number: " + s.rollNo);
                System.out.println("Course: " + s.course);

                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    // Update student
    static void updateStudent(Scanner sc) {

        System.out.print("Enter Roll Number: ");
        String rollNo = sc.nextLine();

        for (Student s : students) {

            if (s.rollNo.equalsIgnoreCase(rollNo)) {

                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Course: ");
                s.course = sc.nextLine();

                saveData();

                System.out.println("Student Updated Successfully!");

                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    // Delete student
    static void deleteStudent(Scanner sc) {

        System.out.print("Enter Roll Number: ");
        String rollNo = sc.nextLine();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).rollNo.equalsIgnoreCase(rollNo)) {

                students.remove(i);

                saveData();

                System.out.println("Student Deleted Successfully!");

                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Load old data
        loadData();

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent(sc);
                    break;

                case 4:
                    updateStudent(sc);
                    break;

                case 5:
                    deleteStudent(sc);
                    break;

                case 6:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}