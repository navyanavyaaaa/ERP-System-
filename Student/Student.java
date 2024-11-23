package Student;

import Course.CourseCatalog;
import Exceptions.CourseFullException;
import User.User;
import Complaint.Complaint;
import Course.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import Feedback.Feedback;
import Main.Main;
public class Student extends User {
    public String name;
    public int semester;
    public List<String> enrolledCourses;
    public List<Complaint> complaints;
    public List<String> completedCourses;
    public Map<String, Integer> grades;
    CourseCatalog catalog = CourseCatalog.getInstance();
    private boolean ta;
    private Course assignedCourse;
    public Student(String name, String username, String password) {
        super(username, password, "Student");
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
        this.semester = 1;
        this.complaints = new ArrayList<>();
        this.completedCourses=new ArrayList<>();
        this.grades = new HashMap<>();
        this.ta=false;
        this.assignedCourse = null;
    }

    public void viewAvailableCourses() {

        System.out.println("Available Courses for Semester " + semester + ":");

        for (Course course : catalog.courses) {
            if (course.semester == semester) {
                System.out.println("Title: " + course.title);
                System.out.println("Code: " + course.code);
                System.out.println("Professor.Professor: " + course.professorName);
                System.out.println("Credits: " + course.credits);
                System.out.println("Prerequisites: " + (course.prerequisites.length == 0 ? "None" : String.join(", ", course.prerequisites)));
                System.out.println("Timings: " + course.timings);
                System.out.println("Syllabus: " + course.syllabus);
                System.out.println("Office Hours: " + course.officeHours);
                System.out.println("Enrollment Limit: " + course.enrollmentLimit);
                System.out.println("Semester: " + course.semester);
                System.out.println();
            }
        }
    }

//    public void registerForCourses() {
//        Scanner scanner = new Scanner(System.in);
//        int semester = 0;
//        while (true) {
//            System.out.print("Enter your semester number (1, 2, or 3): ");
//            if (scanner.hasNextInt()) {
//                semester = scanner.nextInt();
//                if (semester >= 1 && semester <= 3) {
//                    break;
//                } else {
//                    System.out.println("Invalid semester number. Please enter a number from 1 to 3.");
//                }
//            } else {
//                System.out.println("Invalid input. Please enter a number.");
//                scanner.next();
//            }
//        }
//        viewAvailableCourses();
//
//        System.out.print("Enter the course code of the course you want to register for: ");
//        String courseCode = scanner.next();
//
//
////        CourseCatalog catalog = new CourseCatalog();
//        Course selectedCourse = null;
//        for (Course course : catalog.courses) {
//            if (course.code.equals(courseCode) && course.semester == semester) {
//                selectedCourse = course;
//                break;
//            }
//        }
//
//        if (selectedCourse == null) {
//            System.out.println("Invalid course code. Returning to the student menu.");
//            return;
//        }
//
//        if (enrolledCourses.contains(courseCode)) {
//            System.out.print("You are already registered for this course. Do you want to register for another course? (Y/N): ");
//            char response = scanner.next().charAt(0);
//            if (response == 'Y' || response == 'y') {
//                registerForCourses();
//            } else {
//                printRegisteredCourses();
//                return;
//            }
//        }
//
//        if (calculateTotalCredits() + selectedCourse.credits > 20) {
//            System.out.println("You cannot register for this course as it exceeds the 20 credit limit.");
//            return;
//        }
//
//        enrolledCourses.add(courseCode);
//        System.out.println("You have successfully registered for " + courseCode + ". Total credits: " + calculateTotalCredits());
//
//        System.out.print("Do you want to register for another course? (Y/N): ");
//        char registerMore = scanner.next().charAt(0);
//        if (registerMore == 'Y' || registerMore == 'y') {
//            registerForCourses();
//        } else {
//            printRegisteredCourses();
//            System.out.println("Returning to the student menu.");
//        }
//    }
//
    public int calculateTotalCredits() {
        int totalCredits = 0;

        for (String enrolledCourseCode : enrolledCourses) {
            for (Course course : catalog.courses) {
                if (course.code.equals(enrolledCourseCode)) {
                    totalCredits += course.credits;
                }
            }
        }
        return totalCredits;
    }

    private void printRegisteredCourses() {
        System.out.println("Registered Courses:");
        int totalCredits = 0;
        for (String courseCode : enrolledCourses) {
            for (Course course : catalog.courses) {
                if (course.code.equals(courseCode)) {
                    System.out.println("Course Code: " + course.code + ", Credits: " + course.credits);
                    totalCredits += course.credits;
                }
            }
        }
        System.out.println("Total Credits Registered: " + totalCredits);
    }
public void registerForCourses() {
    Scanner scanner = new Scanner(System.in);
    int semester = 0;
    while (true) {
        System.out.print("Enter your semester number (1, 2, or 3): ");
        if (scanner.hasNextInt()) {
            semester = scanner.nextInt();
            if (semester >= 1 && semester <= 3) {
                break;
            } else {
                System.out.println("Invalid semester number. Please enter a number from 1 to 3.");
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
    }
    viewAvailableCourses();

    System.out.print("Enter the course code of the course you want to register for: ");
    String courseCode = scanner.next();

    Course selectedCourse = null;
    for (Course course : catalog.courses) {
        if (course.code.equals(courseCode) && course.semester == semester) {
            selectedCourse = course;
            break;
        }
    }

    if (selectedCourse == null) {
        System.out.println("Invalid course code. Returning to the student menu.");
        return;
    }

    if (enrolledCourses.contains(courseCode)) {
        System.out.print("You are already registered for this course. Do you want to register for another course? (Y/N): ");
        char response = scanner.next().charAt(0);
        if (response == 'Y' || response == 'y') {
            registerForCourses();
        } else {
            printRegisteredCourses();
            return;
        }
    }

    if (calculateTotalCredits() + selectedCourse.credits > 20) {
        System.out.println("You cannot register for this course as it exceeds the 20 credit limit.");
        return;
    }

    try {
        if (getEnrolledStudents(selectedCourse) >= selectedCourse.enrollmentLimit) {
            throw new CourseFullException("The course is full. Please try another course.");
        }
        enrolledCourses.add(courseCode);
        System.out.println("You have successfully registered for " + courseCode + ". Total credits: " + calculateTotalCredits());
    } catch (CourseFullException e) {
        System.out.println(e.getMessage());
    }

    System.out.print("Do you want to register for another course? (Y/N): ");
    char registerMore = scanner.next().charAt(0);
    if (registerMore == 'Y' || registerMore == 'y') {
        registerForCourses();
    } else {
        printRegisteredCourses();
        System.out.println("Returning to the student menu.");
    }
}



    private int getEnrolledStudents(Course course) {
        int enrolledStudents = 0;
        for (Student student : Main.students) {
            if (student.enrolledCourses.contains(course.code)) {
                enrolledStudents++;
            }
        }
        return enrolledStudents;
    }
    public void viewSchedule() {
        if (enrolledCourses.isEmpty()) {
            System.out.println("You have not registered for any courses yet.");
            System.out.println("Please select one of the following options:");
            System.out.println("1. View available courses");
            System.out.println("2. Register for courses");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1) {
                viewAvailableCourses();
            } else if (choice == 2) {
                registerForCourses();
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
            return;
        }

        System.out.println("Your Schedule:");

        for (String courseCode : enrolledCourses) {
            for (Course course : catalog.courses) {
                if (course.code.equals(courseCode)) {
                    System.out.println("Course Code: " + course.code);
                    System.out.println("Course Name: " + course.title);
                    System.out.println("Timings: " + course.timings);
                    System.out.println("Location: " + course.location);
                    System.out.println("Professor: " + course.professorName);
                    System.out.println();
                }
            }
        }
    }

    public void dropCourses() {
        Scanner scanner = new Scanner(System.in);

        printRegisteredCourses();

        System.out.print("To drop a course, enter the course code or press 'u' to return to the user menu: ");
        String input = scanner.next();

        if (input.equalsIgnoreCase("u")) {
            return;
        }

        if (enrolledCourses.contains(input)) {

            int creditsToSubtract = 0;
            for (Course course : catalog.courses) {
                if (course.code.equals(input)) {
                    creditsToSubtract = course.credits;
                    break;
                }
            }

            enrolledCourses.remove(input);
            System.out.println("You have successfully dropped the course: " + input);
            System.out.println("Credits dropped: " + creditsToSubtract);
        } else {
            System.out.println("You are not enrolled in the course: " + input + ", so it can't be dropped.");
        }

        printRegisteredCourses();
    }

    public void submitComplaints() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 'L' to lodge a complaint or 'V' to view status of a complaint using complaint ID:");

        char option = scanner.next().charAt(0);
        if (option == 'L' || option == 'l') {

            System.out.print("Enter date (DD/MM/YYYY): ");
            String date = scanner.next();
            System.out.print("Enter your complaint: ");
            scanner.nextLine();
            String description = scanner.nextLine();

            String complaintId = username + (complaints.size() + 1);
            Complaint newComplaint = new Complaint(username, complaintId, date, description);
            complaints.add(newComplaint);

            System.out.println("Press 'L' to submit the complaint ");
            char forward = scanner.next().charAt(0);
            if (forward == 'L' || forward == 'l') {
                System.out.println("Your complaint has been successfully submitted.");
                System.out.println("Complaint ID: " + complaintId);

                System.out.println("Press 'M' to go to user menu or 'V' to view status using complaint ID:");
                char nextOption = scanner.next().charAt(0);
                if (nextOption == 'M' || nextOption == 'm') {

                    return;
                } else if (nextOption == 'V' || nextOption == 'v') {
                    viewComplaintStatus();
                }
            }
        } else if (option == 'V' || option == 'v') {
            viewComplaintStatus();
        }
    }

    private void viewComplaintStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your complaint ID: ");
        String complaintId = scanner.next();
        for (Complaint complaint : complaints) {
            if (complaint.getComplaintId().equals(complaintId)) {
                System.out.println("Complaint Status: " + complaint.getStatus());
                return;
            }
        }
        System.out.println("No complaint found with ID: " + complaintId);
    }
    public void addGrade(String courseCode, int grade) {
        grades.put(courseCode, grade);
    }

    public double calculateSGPA(Map<String, Integer> grades) {
        double totalGradePoints = 0;
        int totalCredits = 0;

        for (Map.Entry<String, Integer> entry : this.grades.entrySet()) {
            String courseCode = entry.getKey();
            int grade = entry.getValue();

            Course course = CourseCatalog.getInstance().findCourseByCode(courseCode);
            if (course != null) {
                int credits = course.getCredits();
                totalGradePoints += grade * credits;
                totalCredits += credits;
            }
        }

        if (totalCredits == 0) {
            return 0;
        }

        return totalGradePoints / totalCredits;
    }

    public double calculateCGPA(Map<String, Integer> grades) {
        double totalGradePoints = 0;
        int totalCredits = 0;

        for (Map.Entry<String, Integer> entry : this.grades.entrySet()) {
            String courseCode = entry.getKey();
            int grade = entry.getValue();

            Course course = CourseCatalog.getInstance().findCourseByCode(courseCode);
            if (course != null) {
                int credits = course.getCredits();
                totalGradePoints += grade * credits;
                totalCredits += credits;
            }
        }

        if (totalCredits == 0) {
            return 0;
        }

        return totalGradePoints / totalCredits;
    }
    public void trackAcademicProgress() {
        System.out.println("Your current semester is: " + semester);

        if (semester == 1) {
            if (enrolledCourses.size() > 0) {
                System.out.println("Enrolled Courses:");
                for (String courseCode : enrolledCourses) {
                    System.out.print("Course Code: " + courseCode + ", Grade: ");
                    if (grades.containsKey(courseCode)) {
                        System.out.println(grades.get(courseCode));
                    } else {
                        System.out.println("NA");
                    }
                }
            } else {
                System.out.println("You have not enrolled in any courses for Semester " + semester + ".");
            }

            System.out.println("You have not completed any semesters yet.");
        } else if (semester == 2) {
            System.out.println("Completed Courses for Semester 1:");
            for (String courseCode : completedCourses) {
                if (Integer.parseInt(courseCode.substring(3, 4)) == 1) {
                    System.out.print("Course Code: " + courseCode + ", Grade: ");
                    if (grades.containsKey(courseCode)) {
                        System.out.println(grades.get(courseCode));
                    } else {
                        System.out.println("NA");
                    }
                }
            }

            double sgpaSem1 = calculateSGPAForSemester(1);
            System.out.println("SGPA for Semester 1: " + sgpaSem1);

            System.out.println("You have completed all registered courses for Semester 1. You are now in Semester " + semester + ".");

            System.out.println("Completed Courses for Semester 2:");
            for (String courseCode : completedCourses) {
                if (Integer.parseInt(courseCode.substring(3, 4)) == 2) {
                    System.out.print("Course Code: " + courseCode + ", Grade: ");
                    if (grades.containsKey(courseCode)) {
                        System.out.println(grades.get(courseCode));
                    } else {
                        System.out.println("NA");
                    }
                }
            }

            System.out.println("Enrolled Courses for Semester 2:");
            for (String courseCode : enrolledCourses) {
                System.out.print("Course Code: " + courseCode + ", Grade: ");
                if (grades.containsKey(courseCode)) {
                    System.out.println(grades.get(courseCode));
                } else {
                    System.out.println("NA");
                }
            }

            if (enrolledCourses.isEmpty()) {
                double cgpaSem2 = calculateCGPAForSemester(2);
                System.out.println("CGPA for Semester 2: " + cgpaSem2);
            }

            double cgpa = calculateCGPA(this.grades);
            System.out.println("CGPA: " + cgpa);
        }
    }

    public double calculateSGPAForSemester(int semester) {
        double totalGradePoints = 0;
        int totalCredits = 0;

        for (String courseCode : completedCourses) {
            if (Integer.parseInt(courseCode.substring(3, 4)) == semester) {
                if (grades.containsKey(courseCode)) {
                    Course course = CourseCatalog.getInstance().findCourseByCode(courseCode);
                    if (course != null) {
                        int credits = course.getCredits();
                        totalGradePoints += grades.get(courseCode) * credits;
                        totalCredits += credits;
                    }
                }
            }
        }

        if (totalCredits == 0) {
            return 0;
        }

        return totalGradePoints / totalCredits;
    }

    public double calculateCGPAForSemester(int semester) {
        double totalGradePoints = 0;
        int totalCredits = 0;

        for (String courseCode : completedCourses) {
            if (Integer.parseInt(courseCode.substring(3, 4)) <= semester) {
                if (grades.containsKey(courseCode)) {
                    Course course = CourseCatalog.getInstance().findCourseByCode(courseCode);
                    if (course != null) {
                        int credits = course.getCredits();
                        totalGradePoints += grades.get(courseCode) * credits;
                        totalCredits += credits;
                    }
                }
            }
        }

        if (totalCredits == 0) {
            return 0;
        }

        return totalGradePoints / totalCredits;
    }

    public void giveFeedback() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enrolled Courses:");
        for (String courseCode : enrolledCourses) {
            System.out.println(courseCode);
        }

        System.out.print("Enter the course code of the course you want to give feedback for: ");
        String courseCode = scanner.next();

        if (enrolledCourses.contains(courseCode)) {
            System.out.print("Do you want to give a numerical rating (N) or a textual feedback (T)? ");
            char feedbackType = scanner.next().charAt(0);

            if (feedbackType == 'N' || feedbackType == 'n') {
                System.out.print("Enter your numerical rating (1-5): ");
                int numericalRating = scanner.nextInt();
                Feedback<Integer> feedback = new Feedback<>(name, courseCode, numericalRating);
                Main.feedbacks.add(feedback);
                System.out.println("Feedback submitted successfully!");
            } else if (feedbackType == 'T' || feedbackType == 't') {
                System.out.print("Enter your textual feedback: ");
                scanner.nextLine();
                String textualFeedback = scanner.nextLine();
                Feedback<String> feedback = new Feedback<>(name, courseCode, textualFeedback);
                Main.feedbacks.add(feedback);
                System.out.println("Feedback submitted successfully!");
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        } else {
            System.out.println("You are not enrolled in this course.");
        }
    }
    public String getName() {return name;
    }

    public String getuserName() {return name+"iiitd";
    }
    public String getPassword() {
        return password;
    }
    public void setTa(boolean ta) {
        this.ta = ta;
    }

    public boolean isTa() {
        return ta;
    }
    public Course getAssignedCourse() {
        return assignedCourse;
    }

    public void setAssignedCourse(Course assignedCourse) {
        this.assignedCourse = assignedCourse;
    }
}

