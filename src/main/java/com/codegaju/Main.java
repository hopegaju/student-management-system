package com.codegaju;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        CourseDAO dao1 = new CourseDAO() ;
        MarksDAO dao2 = new MarksDAO();

        boolean running = true;
        while (running) {
            System.out.println("\n Student Management Menu for console \n ");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Add course");
            System.out.println("6. Get all courses");
            System.out.println("7. View course");
            System.out.println("8. Update course");
            System.out.println("9. Delete course");
            System.out.println("10. Add marks");
            System.out.println("11. View student marks");
            System.out.println("12. Update student marks");
            System.out.println("13. Delete student marks");
            System.out.println("14. EXIT");

            int choice = sc.nextInt();
            System.out.println("Your choice: " + choice);
            sc.nextLine(); switch (choice) {
                case 1:
                    System.out.println("Enter First Name: ");
                    String firstName = sc.nextLine();
                    System.out.println("Enter Last Name: ");
                    String lastName = sc.nextLine();
                    System.out.println("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.println("Enter Date of Birth (YYYY-MM-DD): ");
                    String dob = sc.nextLine();
                    Student student = new Student(firstName, lastName, email, dob);
                    dao.create(student);
                    break;
                case 2:
                    System.out.println("Enter Student ID: ");
                    int readId = Integer.parseInt(sc.nextLine());
                    dao.read(readId);
                    break;
                case 3:
                    System.out.println("Enter Student ID to update: ");
                    int updateId = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter new First Name: ");
                    String newFirst = sc.nextLine();
                    System.out.println("Enter new Last Name: ");
                    String newLast = sc.nextLine();
                    System.out.println("Enter new Email: ");
                    String newEmail = sc.nextLine();
                    System.out.println("Enter new Date of Birth (YYYY-MM-DD): ");
                    String newDob = sc.nextLine();
                    Student updatedStudent = new Student(updateId, newFirst, newLast, newEmail, newDob);
                    dao.update(updatedStudent);
                    break;
                case 4:
                    System.out.println("Enter Student ID: ");
                    int deleteId = Integer.parseInt(sc.nextLine());
                    dao.delete(deleteId);
                    break;
                case 5:
                    System.out.println("Enter Course Name: ");
                    String courseName = sc.nextLine();
                    System.out.println("Enter Course Description: ");
                    String courseDesc = sc.nextLine();
                    Courses course = new Courses(courseName, courseDesc);
                    dao1.create(course);
                    break;
                case 6:
                    System.out.print("Course ID: ");
                    int courseId = Integer.parseInt(sc.nextLine());
                    dao1.read(courseId);
                    break;
                case 7:
                    System.out.print("Enter Course ID: ");
                    int viewCourseId = Integer.parseInt(sc.nextLine());
                    dao1.read(viewCourseId);
                    break;
                case 8:
                    System.out.print("Course ID to update: ");
                    int updateCourseId = Integer.parseInt(sc.nextLine());
                    System.out.print("New Course Name: ");
                    String newCourseName = sc.nextLine();
                    System.out.print("New Course Description: ");
                    String newCourseDesc = sc.nextLine();
                    Courses updatedCourse = new Courses(newCourseName, newCourseDesc);
                    dao1.update(updatedCourse);
                    break;
                case 9:
                    System.out.println("Enter Course ID: ");
                    int deleteCourseID = Integer.parseInt(sc.nextLine());
                    dao1.delete(deleteCourseID);
                    break;
                case 10:
                    System.out.println("Enter Student ID: ");
                    int stu = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter Course ID: ");
                    int courseID = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter marks: ");
                    int mark = Integer.parseInt(sc.nextLine());
                    Marks marks = new Marks(stu, courseID, mark);
                    dao2.create(marks);
                    break;
                case 11:
                    System.out.println("Enter Student ID: ");
                    int readStudentID = Integer.parseInt(sc.nextLine());
                    dao2.read(readStudentID);
                    break;
                case 12:
                    System.out.println("Enter Student ID: ");
                    int studentToUpdate = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter Course ID: ");
                    int courseToUpdate = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter New Mark: ");
                    int newMark = Integer.parseInt(sc.nextLine());
                    Marks updatedMarks = new Marks(studentToUpdate, courseToUpdate, newMark);
                    dao2.update(updatedMarks);
                    break;
                case 13:
                    System.out.println("Enter Student ID: ");
                    int studentToDelete = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter Course ID: ");
                    int courseToDelete = Integer.parseInt(sc.nextLine());
                    dao2.delete(studentToDelete, courseToDelete);
                    break;
                case 14:
                    running = false;
                    System.out.println("Exit Program....");
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
            }
        }
    }
}