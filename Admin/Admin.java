package Admin ;

import Course.Course;
import Course.CourseCatalog;
import Main.Main;
import Professor.Professor;
import Student.Student;
import User.User;
import Complaint.Complaint;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


import static Main.Main.scanner;

public class Admin extends User {
    public Admin(String name, String username, String password) {
        super(username, password, "Admin");
    }
    public void manageCourseCatalogue(Professor[] professors, Student[] students) {
        CourseCatalog courseCatalog = CourseCatalog.getInstance();
        while (true) {
            System.out.println("Manage Course Catalogue Menu:");
            System.out.println("1. View courses");
            System.out.println("2. Add courses to catalog");
            System.out.println("3. Delete course from catalog");
            System.out.println("M. Return to admin menu");
            System.out.println("X. Logout");

            char choice = scanner.next().charAt(0);
            if (choice == 'M' || choice == 'm') {
                break; // Return to admin menu
            } else if (choice == 'X' || choice == 'x') {
                System.out.println("Logout successful!");
                return;
            } else if (choice == '1') {
                viewCourses(courseCatalog);
            } else if (choice == '2') {
                addCourseToCatalog(courseCatalog);
            } else if (choice == '3') {
                deleteCourseFromCatalog(courseCatalog, professors, students);
            } else {
                System.out.println("Invalid input. Please press 1, 2, 3, M, or X.");
            }
        }
    }

    private void viewCourses(CourseCatalog courseCatalog) {
        System.out.println("View courses for which semester?");
        System.out.println("1. Semester 1");
        System.out.println("2. Semester 2");
        System.out.println("3. Semester 3");

        int semesterChoice = scanner.nextInt();
        if (semesterChoice < 1 || semesterChoice > 3) {
            System.out.println("Invalid semester choice. Returning to admin menu.");
            return;
        }

        System.out.println("Courses for Semester " + semesterChoice + ":");
        for (Course course : courseCatalog.courses) {
            if (course.semester == semesterChoice) {
                System.out.println("Title: " + course.title);
                System.out.println("Code: " + course.code);
                System.out.println("Professor: " + course.professorName);
                System.out.println("Credits: " + course.credits);
                System.out.println("Prerequisites: " + (course.prerequisites.length == 0 ? "None" : String.join(", ", course.prerequisites)));
                System.out.println("Timings: " + course.timings);
                System.out.println("Syllabus: " + course.syllabus);
                System.out.println("Office Hours: " + course.officeHours);
                System.out.println("Location: " + course.location);
                System.out.println();
            }
        }
    }

    private void addCourseToCatalog(CourseCatalog courseCatalog) {
        System.out.println("Enter course title:");
        String courseTitle = scanner.next();
        System.out.println("Enter course code:");
        String courseCode = scanner.next();
        System.out.println("Enter semester:");
        int semester = scanner.nextInt();

        Course newCourse = new Course(courseTitle, courseCode, "N/A", 0, new String[0], "N/A", "N/A", "N/A", 0, semester, "N/A");
        courseCatalog.courses = Arrays.copyOf(courseCatalog.courses, courseCatalog.courses.length + 1);
        courseCatalog.courses[courseCatalog.courses.length - 1] = newCourse;

        System.out.println("Course added successfully!");
    }

    private void deleteCourseFromCatalog(CourseCatalog courseCatalog, Professor[] professors, Student[] students) {
        System.out.println("Enter course code to delete:");
        String courseCode = scanner.next();

        int indexToRemove = -1;
        for (int i = 0; i < courseCatalog.courses.length; i++) {
            if (courseCatalog.courses[i].getCode().equals(courseCode)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove == -1) {
            System.out.println("Course not found.");
            return;
        }

        for (Professor professor : professors) {
            professor.courses.remove(courseCatalog.courses[indexToRemove]);
        }

        for (Student student : students) {
            student.enrolledCourses.remove(courseCode);
            student.completedCourses.remove(courseCode);

            student.semester -= courseCatalog.courses[indexToRemove].credits / 20;
        }

        Course[] newCourses = new Course[courseCatalog.courses.length - 1];
        System.arraycopy(courseCatalog.courses, 0, newCourses, 0, indexToRemove);
        System.arraycopy(courseCatalog.courses, indexToRemove + 1, newCourses, indexToRemove, courseCatalog.courses.length - indexToRemove -1);
        courseCatalog.courses = newCourses;

        System.out.println("Course deleted successfully!");
    }
    public void manageStudentRecords() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the student for which you want to manage records: ");
        String studentName = scanner.next();

        Student student = null;
        for (Student s : Main.students) {
            if (s.getName().equals(studentName)) {
                student = s;
                break;
            }
        }

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        while (true) {
            System.out.println("Manage Student Records Menu:");
            System.out.println("1. View/Update Student Email ID");
            System.out.println("2. View Student Semester");
            System.out.println("3. View Enrolled Courses");
            System.out.println("4. View Completed Courses");
            System.out.println("5. View/Update Student Grades");
            System.out.println("6. View CGPA and SGPA");
            System.out.println("M. Return to Admin Menu");
            System.out.println("X. Logout");

            char choice = scanner.next().charAt(0);
            if (choice == 'M' || choice == 'm') {
                break;
            } else if (choice == 'X' || choice == 'x') {
                System.out.println("Logout successful!");
                return;
            } else if (choice == '1') {
                System.out.println("Email ID: " + student.getuserName() + "@gmail.com");
                System.out.print("Press 'U' to update or any other key to return to Manage Student Records Menu: ");
                char updateChoice = scanner.next().charAt(0);
                if (updateChoice == 'U' || updateChoice == 'u') {
                    System.out.print("Enter new username: ");
                    String newEmailID = scanner.next();
                    student.name = newEmailID.substring(0, newEmailID.length() - 5);
                    System.out.println("Email ID updated successfully!");
                }
            } else if (choice == '2') {
                System.out.println("Semester: " + student.semester);
            } else if (choice == '3') {
                if (student.enrolledCourses.isEmpty()) {
                    System.out.println("No enrolled courses.");
                } else {
                    System.out.println("Enrolled Courses: " + String.join(", ", student.enrolledCourses));
                }
            } else if (choice == '4') {
                if (student.completedCourses.isEmpty()) {
                    System.out.println("No completed courses.");
                } else {
                    System.out.println("Completed Courses: " + String.join(", ", student.completedCourses));
                }
            } else if (choice == '5') {
                if (student.semester == 1) {
                    System.out.println("Semester 1");
                    System.out.println("Completed Courses:");
                    if (student.completedCourses.isEmpty()) {
                        System.out.println("No completed courses.");
                    } else {
                        for (int i = 0; i < student.completedCourses.size(); i++) {
                            System.out.println((i + 1) + ". " + student.completedCourses.get(i) + ": " + student.grades.get(student.completedCourses.get(i)));
                        }
                    }
                    System.out.println("Enrolled Courses:");
                    for (int i = 0; i < student.enrolledCourses.size(); i++) {
                        System.out.println((i + 1) + ". " + student.enrolledCourses.get(i) + ": " + (student.grades.containsKey(student.enrolledCourses.get(i)) ? student.grades.get(student.enrolledCourses.get(i)) : "N/A"));
                    }
                    System.out.print("To update grade for a course, enter the course code: ");
                    String courseCode = scanner.next();
                    if (student.enrolledCourses.contains(courseCode)) {
                        System.out.print("Enter grade (1-10): ");
                        int grade = scanner.nextInt();
                        student.grades.put(courseCode, grade);
                        student.completedCourses.add(courseCode);
                        student.enrolledCourses.remove(courseCode);
                        System.out.println("Grade updated successfully!");
                        System.out.print("Do you want to update grade for another course? (Y/N): ");
                        char updateAnotherChoice = scanner.next().charAt(0);
                        if (updateAnotherChoice == 'N' || updateAnotherChoice == 'n') {
                            continue;
                        }
                    } else {
                        System.out.println("Course not found in enrolled courses.");
                    }
                } else if (student.semester == 2) {
                    System.out.println("Semester 1");
                    System.out.println("Completed Courses:");
                    for (int i = 0; i < student.completedCourses.size(); i++) {
                        if (Integer.parseInt(student.completedCourses.get(i).substring(3, 4)) == 1) {
                            System.out.println((i + 1) + ". " + student.completedCourses.get(i) + ": " + student.grades.get(student.completedCourses.get(i)));
                        }
                    }
                    System.out.println("Semester 2");
                    System.out.println("Completed Courses:");
                    for (int i = 0; i < student.completedCourses.size(); i++) {
                        if (Integer.parseInt(student.completedCourses.get(i).substring(3, 4)) == 2) {
                            System.out.println((i + 1) + ". " + student.completedCourses.get(i) + ": " + student.grades.get(student.completedCourses.get(i)));
                        }
                    }
                    System.out.println("Enrolled Courses:");
                    for (int i = 0; i < student.enrolledCourses.size(); i++) {
                        System.out.println((i + 1) + ". " + student.enrolledCourses.get(i) + ": " + (student.grades.containsKey(student.enrolledCourses.get(i)) ? student.grades.get(student.enrolledCourses.get(i)) : "N/A"));
                    }
                    System.out.print("To update grade for a course, enter the course code: ");
                    String courseCode = scanner.next();
                    if (student.enrolledCourses.contains(courseCode)) {
                        System.out.print("Enter grade (1-10): ");
                        int grade = scanner.nextInt();
                        student.grades.put(courseCode, grade);
                        student.completedCourses.add(courseCode);
                        student.enrolledCourses.remove(courseCode);
                        System.out.println("Grade updated successfully!");
                        System.out.print("Do you want to update grade for another course? (Y/N): ");
                        char updateAnotherChoice = scanner.next().charAt(0);
                        if (updateAnotherChoice == 'N' || updateAnotherChoice == 'n') {
                            continue;
                        }
                    } else {
                        System.out.println("Course not found in enrolled courses.");
                    }
                }

            } else if (choice == '6') {
                if (student.semester == 1) {
                    System.out.println("Enrolled Courses:");
                    for (String courseCode : student.enrolledCourses) {
                        System.out.println(courseCode);
                    }

                    System.out.println("Completed Courses:");
                    for (String courseCode : student.completedCourses) {
                        System.out.println(courseCode);
                    }

                    if (!student.enrolledCourses.isEmpty()) {
                        System.out.println("Cannot calculate SGPA as grades haven't been assigned to all courses.");
                    } else {
                        double sgpa = student.calculateSGPA(student.grades);
                        double cgpa = sgpa;
                        System.out.println("SGPA for Semester 1: " + sgpa);
                        System.out.println("CGPA: " + cgpa);
                        student.semester = 2;
                        System.out.println("Student's semester has been updated to 2.");
                    }
                } else if (student.semester == 2) {
                    System.out.println("Enrolled Courses:");
                    for (String courseCode : student.enrolledCourses) {
                        System.out.println(courseCode);
                    }

                    System.out.println("Completed Courses for Semester 2:");
                    for (String courseCode : student.completedCourses) {
                        if (Integer.parseInt(courseCode.substring(3, 4)) == 2) {
                            System.out.println(courseCode);
                        }
                    }

                    if (!student.enrolledCourses.isEmpty()) {
                        double cgpa = student.calculateCGPAForSemester(1);
                        System.out.println("Cannot calculate SGPA for Semester 2 as grades haven't been assigned to all courses of Semester 2.");
                        System.out.println("CGPA: " + cgpa);
                    } else {
                        double sgpaSem1 = student.calculateSGPAForSemester(1);
                        double sgpaSem2 = student.calculateSGPAForSemester(2);
                        double cgpa = (sgpaSem1 + sgpaSem2) / 2;
                        System.out.println("SGPA for Semester 2: " + sgpaSem2);
                        System.out.println("CGPA: " + cgpa);
                        student.semester = 3;
                        System.out.println("Student's semester has been updated to 3.");
                    }
                }
            } else {
                System.out.println("Invalid input. Please press 1, 2, 3, 4, 5, 6, M, or X.");
            }
        }
    }
    public void assignProfessorsToCourses() {
        System.out.println("List of Professors:");
        for (Professor professor : Main.professors) {
            System.out.println("Name: " + professor.getName());
            System.out.print("Courses: ");
            for (Course course : professor.getCourses()) {
                System.out.print(course.getCode() + ", ");
            }
            System.out.println();
        }

        System.out.print("Enter the course code of the course to assign a professor to: ");
        String courseCode;
        while (true) {
            try {
                courseCode = scanner.next();
                Course course = CourseCatalog.getInstance().findCourseByCode(courseCode);
                if (course != null) {
                    break;
                } else {
                    System.out.println("Course not found. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid course code.");
                scanner.nextLine();
            }
        }

        System.out.print("Enter the name of the professor who will teach the course: ");
        String professorName;
        while (true) {
            try {
                professorName = scanner.next();
                Professor professor = null;
                for (Professor p : Main.professors) {
                    if (p.getName().equals(professorName)) {
                        professor = p;
                        break;
                    }
                }
                if (professor != null) {
                    break;
                } else {
                    System.out.println("Professor not found. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid professor name.");
                scanner.nextLine();
            }
        }

        Course course = CourseCatalog.getInstance().findCourseByCode(courseCode);
        if (course.getProfessorName() != null) {
            Professor previousProfessor = null;
            for (Professor p : Main.professors) {
                if (p.getName().equals(course.getProfessorName())) {
                    previousProfessor = p;
                    break;
                }
            }
            if (previousProfessor != null) {
                previousProfessor.removeCourse(course);
            }
        }

        course.setProfessorName(professorName);
        Professor professor = null;
        for (Professor p : Main.professors) {
            if (p.getName().equals(professorName)) {
                professor = p;
                break;
            }
        }
        if (professor != null) {
            professor.addCourse(String.valueOf(course));
            for (int i = 0; i < Main.professors.length; i++) {
                if (Main.professors[i].getName().equals(professorName)) {
                    Main.professors[i] = professor;
                    break;
                }
            }
        }

        System.out.println("Professor assigned successfully!");
    }
    public void seeComplaints(String stu) {
        System.out.println(stu);
        for (Student st : Main.students) {
            if (Objects.equals(st.name, stu)) {
                if (!st.complaints.isEmpty()) {
                    for (Complaint comp : st.complaints) {
                        if (comp.getStatus() != "Resolved") {
                            System.out.println("Complaint: " + comp.getDescription());
                        }
                    }
                } else {
                    System.out.println("No complaints");
                }
            }
        }
    }

    public void handleComps(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input student name: ");
        String stu= scanner.nextLine();
        for (Student st: Main.students){
            if (st.name==stu){
                for (Complaint comp: st.complaints){
                    comp.setStatus("Resolved");
                    System.out.println("Resolved!");
                }
            }
        }


    }



}
