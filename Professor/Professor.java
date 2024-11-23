package Professor;
import Course.Course;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import Course.CourseCatalog;
import Student.Student;
import Feedback.Feedback;
import Main.Main;
import Student.TeachingAssistant;
public class Professor {
    private String name;
    public String username;
    private String password;
    CourseCatalog catalog = CourseCatalog.getInstance();
    public ArrayList<Course> courses;

    public Professor(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.courses = new ArrayList<>();
    }
    public void addCourse(String courseCode) {

        for (Course course : catalog.courses) {
            if (course.code.equals(courseCode)) {
                this.courses.add(course);
                break;
            }
        }
    }

    public void removeCourse(Course course) {
        CourseCatalog courseCatalog = CourseCatalog.getInstance();
        courseCatalog.removeCourse(course);
    }

    public void manageCourses() {
        CourseCatalog courseCatalog = CourseCatalog.getInstance();
        Scanner scanner = new Scanner(System.in);

        if (courses.isEmpty()) {
            System.out.println("No courses assigned to you.");
            return;
        }

        while (true) {
            System.out.println("Manage Courses Menu:");
            System.out.println("1. View courses assigned to you");
            System.out.println("2. Update course details");
            System.out.println("M. Return to menu");
            System.out.println("X. Logout");

            char choice = scanner.next().charAt(0);
            if (choice == 'M' || choice == 'm') {
                break; // Return to menu
            } else if (choice == 'X' || choice == 'x') {
                System.out.println("Logout successful!");
                return;
            } else if (choice == '1') {
                viewCourses(scanner);
            } else if (choice == '2') {
                updateCourseDetails(scanner);
            }
        }
    }

    private void viewCourses(Scanner scanner) {
        CourseCatalog courseCatalog = CourseCatalog.getInstance();
        System.out.println("Courses assigned to you:");
        for (Course course : courses) {
            System.out.println(course.getCode());
        }
    }

    private void updateCourseDetails(Scanner scanner) {

        System.out.println("Available courses assigned to you:");
        viewCourses(scanner);

        System.out.println("Enter course code of the course you want to update:");
        String courseCode = scanner.next();
        Course selectedCourse = findCourse(courseCode);

        if (selectedCourse == null) {
            System.out.println("Invalid course code.");
            return;
        }

        while (true) {
            displayCourseDetails(selectedCourse);
            System.out.println("Choose a detail to update:");
            displayUpdateOptions();

            char updateDetailChoice = scanner.next().charAt(0);
            if (updateDetailChoice == 'M' || updateDetailChoice == 'm') {
                break; // Return to manage courses
            } else if (updateDetailChoice == 'X' || updateDetailChoice == 'x') {
                System.out.println("Logout successful!");
                return;
            } else {
                updateCourseDetail(selectedCourse, updateDetailChoice, scanner);
            }
            System.out.println("Do you want to update anything else? (Y/N)");
            char updateAgainChoice = scanner.next().charAt(0);
            if (updateAgainChoice == 'N' || updateAgainChoice == 'n') {
                break;
            }
        }
    }

    private Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    private void displayCourseDetails(Course course) {
        System.out.println("Course details:");
        System.out.println("1. Credits: " + course.getCredits());
        System.out.println("2. Prerequisites: " + (course.getPrerequisites().length == 0 ? "None" : String.join(", ", course.getPrerequisites())));
        System.out.println("3. Timings: " + course.getTimings());
        System.out.println("4. Syllabus: " + course.getSyllabus());
        System.out.println("5. Office Hours: " + course.getOfficeHours());
        System.out.println("6. Enrollment Limit: " + course.getEnrollmentLimit());
        System.out.println("7. Location: " + course.getLocation());
    }

    private void displayUpdateOptions() {
        System.out.println("1. Credits");
        System.out.println("2. Prerequisites");
        System.out.println("3. Timings");
        System.out.println("4. Syllabus");
        System.out.println("5. Office Hours");
        System.out.println("6. Enrollment Limit");
        System.out.println("7. Location");
        System.out.println("M. Return to manage courses");
        System.out.println("X. Logout");
    }

    private void updateCourseDetail(Course course, char updateDetailChoice, Scanner scanner) {
        switch (updateDetailChoice) {
            case '1':
                System.out.println("Initial credits: " + course.getCredits());
                System.out.println("Enter new credits:");
                int newCredits = scanner.nextInt();
                course.setCredits(newCredits);
                System.out.println("Credits for course " + course.getCode() + " updated to " + newCredits);
                break;
            case '2':
                updatePrerequisites(course, scanner);
                break;
            case '3':
                System.out.println("Initial timings: " + course.getTimings());
                System.out.println("Enter new  Day :");
                String newTimings = scanner.next();
                System.out.println("Enter new  Hours :");
                newTimings+= scanner.next();
                course.setTimings(newTimings);
                System.out.println("Timings for course " + course.getCode() + " updated to " + newTimings);
                break;
            case '4':
                System.out.println("Initial syllabus: " + course.getSyllabus());
                System.out.println("Enter new syllabus:");
                String newSyllabus = scanner.next();
                course.setSyllabus(newSyllabus);
                System.out.println("Syllabus for course " + course.getCode() + " updated to " + newSyllabus);
                break;
            case '5':
                System.out.println("Initial office hours: " + course.getOfficeHours());
                System.out.println("Enter new office hours Day :");
                String newOfficeHours = scanner.next();
                System.out.println("Enter new  Hours :");
                newOfficeHours+= scanner.next();

                course.setOfficeHours(newOfficeHours);
                System.out.println("Office hours for course " + course.getCode() + " updated to " + newOfficeHours);
                break;
            case '6':
                System.out.println("Initial enrollment limit: " + course.getEnrollmentLimit());
                System.out.println("Enter new enrollment limit:");
                int newEnrollmentLimit = scanner.nextInt();
                course.setEnrollmentLimit(newEnrollmentLimit);
                System.out.println("Enrollment limit for course " + course.getCode() + " updated to " + newEnrollmentLimit);
                break;
            case '7':
                System.out.println("Initial location: " + course.getLocation());
                System.out.println("Enter new location:");
                String newLocation = scanner.next();
                course.setLocation(newLocation);
                System.out.println("Location for course " + course.getCode() + " updated to " + newLocation);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void updatePrerequisites(Course course, Scanner scanner) {
        System.out.println("Current prerequisites: " + (course.getPrerequisites().length == 0 ? "None" : String.join(", ", course.getPrerequisites())));
        System.out.println("1. Remove all existing prerequisites");
        System.out.println("2. Add a new prerequisite");
        System.out.println("M. Return to update options");
        System.out.println("X. Logout");

        char updatePrerequisitesChoice = scanner.next().charAt(0);
        if (updatePrerequisitesChoice == '1') {
            course.setPrerequisites(new String[0]);
            System.out.println("Prerequisites for course " + course.getCode() + " removed.");
        } else if (updatePrerequisitesChoice == '2') {
            System.out.println("Enter new prerequisite:");
            String newPrerequisite = scanner.next();
            String[] newPrerequisites = new String[course.getPrerequisites().length + 1];
            System.arraycopy(course.getPrerequisites(), 0, newPrerequisites, 0, course.getPrerequisites().length);
            newPrerequisites[course.getPrerequisites().length] = newPrerequisite;
            course.setPrerequisites(newPrerequisites);
            System.out.println("Prerequisites for course " + course.getCode() + " updated to " + String.join(", ", course.getPrerequisites()));
        }
    }

    public void viewEnrolledStudents(Student[] students) {
        if (courses.isEmpty()) {
            System.out.println("No courses assigned to you.");
            return;
        }

        for (Course course : courses) {
            System.out.println("Enrolled students in " + course.getCourseName() + ":");
            boolean studentsEnrolled = false;
            for (Student student : students) {
                if (student.enrolledCourses.contains(course.getCode())) {
                    System.out.println("Name: " + student.getName());
                    System.out.println("Email: " + student.getuserName() + "@gmail.com");
                    System.out.println("Grade: N/A");
                    System.out.println();
                    studentsEnrolled = true;
                }
            }
            if (!studentsEnrolled) {
                System.out.println("No students enrolled in this course");
            }
            System.out.println();
        }
    }
    public void viewFeedback() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Courses assigned to you:");
        for (Course course : courses) {
            System.out.println(course.getCode());
        }

        System.out.print("Enter the course code of the course you want to view feedback for: ");
        String courseCode = scanner.next();

        Course course = null;
        for (Course c : courses) {
            if (c.getCode().equals(courseCode)) {
                course = c;
                break;
            }
        }

        if (course != null) {
            Main main = new Main();
            for (Feedback<?> feedback :main.feedbacks) {
                if (feedback.getCourseCode().equals(courseCode)) {
                    if (feedback.getFeedback() instanceof Integer) {
                        System.out.println(feedback.getStudentName() + " rated " + courseCode + " " + feedback.getFeedback());
                    } else if (feedback.getFeedback() instanceof String) {
                        System.out.println(feedback.getStudentName() + " said " + feedback.getFeedback());
                    }
                }
            }
        } else {
            System.out.println("You are not assigned to this course.");
        }
    }
    public void viewTaForCourse() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Courses assigned to you:");
        for (Course course : courses) {
            System.out.println(course.getCode());
        }

        System.out.print("Enter the course code of the course you want to view TA for: ");
        String courseCode = scanner.next();

        Course course = null;
        for (Course c : courses) {
            if (c.getCode().equals(courseCode)) {
                course = c;
                break;
            }
        }

        if (course != null) {
            System.out.println("TA for " + course.getCode() + ": " + course.getTaName());
        } else {
            System.out.println("You are not assigned to this course.");
        }
    }
    public void assignTaToCourse(Student[] students) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Courses assigned to you:");
        for (Course course : courses) {
            System.out.println(course.getCode());
        }

        System.out.print("Enter the code of the course for which you want to assign a TA: ");
        String courseCode = scanner.next();

        Course course = null;
        for (Course c : courses) {
            if (c.getCode().equals(courseCode)) {
                course = c;
                break;
            }
        }

        if (course != null) {
            System.out.print("Enter the name of the student you want to assign as a TA for this course: ");
            String studentName = scanner.next();

            Student student = null;
            for (Student s : students) {
                if (s.getName().equals(studentName)) {
                    student = s;
                    break;
                }
            }

            if (student != null) {
                TeachingAssistant ta = new TeachingAssistant(student.getName(), student.getuserName(), student.getPassword(), course);
                student.setTa(true);
                student.setAssignedCourse(course);
                course.setTaName(student.getName());
                System.out.println("TA assigned successfully!");
                return;
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("You are not assigned to this course.");
        }
    }
    public Object getName() {return name;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}


