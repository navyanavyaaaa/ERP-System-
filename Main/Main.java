package Main;

import Admin.Admin;
import Complaint.Complaint;
import Exceptions.InvalidLoginException;
import Feedback.Feedback;
import Professor.Professor;
import Student.Student;
import User.User;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import Course.CourseCatalog;
import Course.Course;
import Student.TeachingAssistant;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    static User[] users = new User[0];
    public static Student[] students = new Student[0];
    static Admin[] admins = new Admin[0];
    public static Professor[] professors = new Professor[0];
    static List<Complaint> complaints = new ArrayList<Complaint>();
    static CourseCatalog courseCatalog = CourseCatalog.getInstance();
    public static List<Feedback<?>> feedbacks = new ArrayList<>();
    public static ArrayList<Course> courses = new ArrayList<>();
    public static TeachingAssistant[] tas= new TeachingAssistant[0];

    public static void main(String[] args) {
        Student student1 = new Student("Ria", "Riaiiitd", "password123");
        student1.semester = 1;
        student1.enrolledCourses.add("CSE105");
        student1.enrolledCourses.add("MAT102");
        student1.enrolledCourses.add("ELE101");
        student1.enrolledCourses.add("CSE1001");

        Student student2 = new Student("Aadi", "Aadiiiitd", "password456");
        student2.semester = 1;
        student2.enrolledCourses.add("CSE105");
        student2.enrolledCourses.add("ELE101");

        Student student3 = new Student("Rayansh", "Rayanshiiitd", "password789");
        student3.semester = 2;
        student3.enrolledCourses.add("CSE201");
        student3.enrolledCourses.add("CSE202");
        student3.completedCourses.add("CSE105");
        student3.completedCourses.add("ELE101");
        student3.completedCourses.add("CSE1001");
        student3.completedCourses.add("COM101");
        student3.addGrade("CSE105", 8);
        student3.addGrade("ELE101", 9);
        student3.addGrade("CSE1001", 7);
        student3.addGrade("COM101", 8);

        Course course = courseCatalog.findCourseByCode("DES101");
        course.setTaName("Farhan");
        TeachingAssistant ta = new TeachingAssistant("Farhan", "Farhaniiitd", "password",course );
        ta.enrolledCourses.add("CSE201");
        ta.enrolledCourses.add("CSE202");
        ta.completedCourses.add("CSE105");
        ta.completedCourses.add("DES101");
        ta.completedCourses.add("CSE1001");
        ta.semester = 2;

        Course course2 = courseCatalog.findCourseByCode("ELE101");
        course.setTaName("Yuu");
        TeachingAssistant ta2 = new TeachingAssistant("Yuu", "Yuuiiitd", "password",course );
        ta2.enrolledCourses.add("CSE201");
        ta2.enrolledCourses.add("CSE202");
        ta2.completedCourses.add("CSE105");
        ta2.completedCourses.add("ELE101");
        ta2.completedCourses.add("CSE1001");
        ta2.semester = 2;

// Hardcoding professors
        Professor professor1 = new Professor("Sonal", "Sonaliiitd", "password123");
        professor1.addCourse("DES101");
        professor1.addCourse("COM101");
        professor1.addCourse("ECO2005");
        professor1.addCourse("ECO2006");
        professor1.addCourse("DES301");
        professor1.addCourse("SOC301");

        Professor professor2 = new Professor("Tammam", "Tammamiiitd", "password123");
        professor2.addCourse("ELE101");
        professor2.addCourse("CSE201");
        professor2.addCourse("CSE302");

        Professor professor3 = new Professor("Shad", "Shadiiitd", "password123");
        professor3.addCourse("CSE105");
        professor3.addCourse("CSE202");
        professor3.addCourse("CSE303");

        Professor professor4 = new Professor("Ashish", "Ashishiiitd", "password123");
        professor4.addCourse("CSE1001");
        professor4.addCourse("MAT1001");
        professor4.addCourse("CSE3002");
        professor4.addCourse("ELE2002");
        professor4.addCourse("CSE3004");

        Professor professor5 = new Professor("Sanjit", "Sanjitiiitd", "password123");
        professor5.addCourse("MAT102");
        professor5.addCourse("MTH202");
        professor5.addCourse("MAT301");
        professor5.addCourse("MAT302");
        professor5.addCourse("CSE304");
        professor1.addCourse("MAT303");

        Professor professor6 = new Professor("Anoop", "Anoopiiitd", "password123");
        professor6.addCourse("DES102");
        professor6.addCourse("DES105");
        professor6.addCourse("SOC2007");

        Professor professor7 = new Professor("Sujay", "Sujayiiitd", "password123");
        professor7.addCourse("CSE204");
        professor7.addCourse("CSE305");
        professor7.addCourse("CSE306");
        professor7.addCourse("CSE3003");

        Professor professor8 = new Professor("Rishi", "Rishiiiitd", "password123");
        professor8.addCourse("BIO202");
        professor8.addCourse("SOC203");
        professor8.addCourse("BIO301");
        professor8.addCourse("SOC301");
        professor8.addCourse("CSE3001");
        professor8.addCourse("CSE3002");
        professor8.addCourse("CSE2005");

        professors = addProfessor(professors, professor1);
        professors = addProfessor(professors, professor2);
        professors = addProfessor(professors, professor3);
        professors = addProfessor(professors, professor4);
        professors = addProfessor(professors, professor5);
        professors = addProfessor(professors, professor6);
        professors = addProfessor(professors, professor7);
        professors = addProfessor(professors, professor8);

        users = addUser(users, new User("Tammamiiitd", "password123", "Professor"));
        users = addUser(users, new User("Shadiiitd", "password123", "Professor"));
        users = addUser(users, new User("Sanjitiiitd", "password123", "Professor"));
        users = addUser(users, new User("Ashishiiitd", "password123", "Professor"));
        users = addUser(users, new User("Rishiiiitd", "password123", "Professor"));
        users = addUser(users, new User("Anoopiiitd", "password123", "Professor"));
        users = addUser(users, new User("Sonaliiitd", "password123", "Professor"));
        users = addUser(users, new User("Sujayiiitd", "password123", "Professor"));

        students = addStudent(students, student1);
        students = addStudent(students, student2);
        students = addStudent(students, student3);

        users = addUser(users, new User("Riaiiitd", "password123", "Student"));
        users = addUser(users, new User("Aadiiiitd", "password456", "Student"));
        users = addUser(users, new User("Rayanshiiitd", "password789", "Student"));

        System.out.println("Welcome to Course Registration System");
        while (true) {
            System.out.print("Press L to login or S to signup: ");
            char choice = scanner.next().charAt(0);
            if (choice == 'L' || choice == 'l') {
                login();
            } else if (choice == 'S' || choice == 's') {
                signup();
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    static void signup() {
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Select a role (S for Student, A for Admin, P for Professor): ");
        char roleChoice = scanner.next().charAt(0);
        String role = "";
        if (roleChoice == 'S' || roleChoice == 's') {
            role = "Student";
        } else if (roleChoice == 'A' || roleChoice == 'a') {
            role = "Admin";
        } else if (roleChoice == 'P' || roleChoice == 'p') {
            role = "Professor";
        } else {
            System.out.println("Invalid role. Please try again.");
            return;
        }
        String username = name + "iiitd";
        String password = "";
        if (role.equals("Admin")) {
            System.out.println("Your password is '1234'.");
            password = "1234";
        } else {
            System.out.print("Enter password: ");
            password = scanner.next();
        }
        System.out.println("Your username is: " + username);

        User user = new User(username, password, role);
        if (role.equals("Student")) {
            Student student = new Student(name, username, password);
            students = addStudent(students, student);
        } else if (role.equals("Admin")) {
            Admin admin = new Admin(name, username, password);
            admins = addAdmin(admins, admin);
        } else if (role.equals("Professor")) {
            Professor professor = new Professor(name, username, password);
            professors = addProfessor(professors, professor);
        }
        users = addUser(users, user);
        System.out.println("Signup successful! You are signed up as a " + role);
    }

static void login () {
    System.out.print("Enter username: ");
    String username = scanner.next();
    System.out.print("Enter password: ");
    String password = scanner.next();

    try {
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                if (user.role.equals("Student")) {
                    for (Student student : students) {
                        if (student.username.equals(username)) {
                            studentMenu(student);
                            return;
                        }
                    }
                } else if (user.role.equals("Admin")) {
                    for (Admin admin : admins) {
                        if (admin.username.equals(username)) {
                            Adminmenu(admin);
                            return;
                        }
                    }
                } else if (user.role.equals("Professor")) {
                    for (Professor professor : professors) {
                        if (professor.username.equals(username)) {
                            professorMenu(professor);
                            return;
                        }
                    }
                }
            }
        }
        throw new InvalidLoginException("Invalid username or password. Please try again.");
    } catch (InvalidLoginException e) {
        System.out.println(e.getMessage());
    }
}

    private static void Adminmenu(Admin admin) {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Manage Course Catalog");
            System.out.println("2. Manage Student Records");
            System.out.println("3. Assign Professors to Courses");
            System.out.println("4. See Complaints");
            System.out.println("5. Handle Complaint");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    admin.manageCourseCatalogue(professors, students);
                    break;
                case 2:
                    admin.manageStudentRecords();
                    break;
                case 3:
                    admin.assignProfessorsToCourses();
                    break;
                case 4:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Input student name: ");
                    String stu= scanner.nextLine();
                    admin.seeComplaints(stu);
                    break;
                case 5:
                    admin.handleComps();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.print("Press X to logout or any key to continue: ");
            char option = scanner.next().charAt(0);
            if (option == 'X' || option == 'x') {
                System.out.println("Logout successful!");
                return;
            }
        }

    }

    static void displayMenu(String role) {
        if (role.equals("Admin")) {
            System.out.println("Redirecting to Admin menu...");
        } else if (role.equals("Student")) {
            System.out.println("Redirecting to Student menu...");
        } else if (role.equals("Professor")) {
            System.out.println("Redirecting to Professor menu...");
        } else {
            System.out.println("Invalid role.");
        }
    }

    static void studentMenu(Student student) {
        while (true) {
            if (student.isTa()) {
                System.out.println("Teaching Assistant Menu:");
                System.out.println("1. View available courses");
                System.out.println("2. Register for courses");
                System.out.println("3. View schedule");
                System.out.println("4. Track academic progress");
                System.out.println("5. Drop courses");
                System.out.println("6. Submit complaints");
                System.out.println("7. Give Feedback");
                System.out.println("8. View enrolled students");
                System.out.println("9. View student grades");
                System.out.println("10. Update grade for a student");
            } else {
                System.out.println("Student Menu:");
                System.out.println("1. View available courses");
                System.out.println("2. Register for courses");
                System.out.println("3. View schedule");
                System.out.println("4. Track academic progress");
                System.out.println("5. Drop courses");
                System.out.println("6. Submit complaints");
                System.out.println("7. Give Feedback");
            }

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    student.viewAvailableCourses();
                    break;
                case 2:
                    student.registerForCourses();
                    break;
                case 3:
                    student.viewSchedule();
                    break;
                case 4:
                    student.trackAcademicProgress();
                    break;
                case 5:
                    student.dropCourses();
                    break;
                case 6:
                    student.submitComplaints();
                    break;
                case 7:
                    student.giveFeedback();
                    break;

                case 8:
                    if (student.isTa()) {
                        int semester = Integer.parseInt(student.getAssignedCourse().getCode().substring(3, 4));
                        System.out.println("Enrolled students in " + student.getAssignedCourse().getCourseName() + ":");
                        for (Student s : students) {
                            if ((s.enrolledCourses.contains(student.getAssignedCourse().getCode()) && s.semester == semester && !s.equals(student)) ||
                                    (s.completedCourses.contains(student.getAssignedCourse().getCode()) && Integer.parseInt(s.completedCourses.get(s.completedCourses.indexOf(student.getAssignedCourse().getCode())).substring(3, 4)) == semester && !s.equals(student))) {
                                System.out.println("Name: " + s.getName());
                                System.out.println("Email: " + s.getuserName() + "@gmail.com");
                                if (s.completedCourses.contains(student.getAssignedCourse().getCode())) {
                                    System.out.println("Grade: " + s.grades.get(student.getAssignedCourse().getCode()));
                                } else {
                                    System.out.println("Grade: N/A");
                                }
                                System.out.println();
                            }
                        }
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }


                    break;

                case 9:
                    if (student.isTa()) {
                        int semester = Integer.parseInt(student.getAssignedCourse().getCode().substring(3, 4));
                        System.out.println("Student Grades for " + student.getAssignedCourse().getCourseName() + ":");
                        for (Student s : students) {
                            if ((s.enrolledCourses.contains(student.getAssignedCourse().getCode()) && s.semester == semester && !s.equals(student)) ||
                                    (s.completedCourses.contains(student.getAssignedCourse().getCode()) && Integer.parseInt(s.completedCourses.get(s.completedCourses.indexOf(student.getAssignedCourse().getCode())).substring(3, 4)) == semester && !s.equals(student))) {
                                System.out.print("Name: " + s.getName());
                                if (s.completedCourses.contains(student.getAssignedCourse().getCode())) {
                                    System.out.println(", Grade: " + s.grades.get(student.getAssignedCourse().getCode()));
                                } else {
                                    System.out.println(", Grade: N/A");
                                }
                            }
                        }
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 10:
                    if (student.isTa()) {
                        int semester = Integer.parseInt(student.getAssignedCourse().getCode().substring(3, 4));
                        System.out.println("Enrolled students in " + student.getAssignedCourse().getCourseName() + ":");
                        for (Student s : students) {
                            if ((s.enrolledCourses.contains(student.getAssignedCourse().getCode()) && s.semester == semester && !s.equals(student)) ||
                                    (s.completedCourses.contains(student.getAssignedCourse().getCode()) && Integer.parseInt(s.completedCourses.get(s.completedCourses.indexOf(student.getAssignedCourse().getCode())).substring(3, 4)) == semester && !s.equals(student))) {
                                System.out.println("Name: " + s.getName());
                                System.out.println("Email: " + s.getuserName() + "@gmail.com");
                                if (s.completedCourses.contains(student.getAssignedCourse().getCode())) {
                                    System.out.println("Grade: " + s.grades.get(student.getAssignedCourse().getCode()));
                                } else {
                                    System.out.println("Grade: N/A");
                                }
                                System.out.println();
                            }
                        }

                        System.out.print("Enter the name of the student whose grade you want to update: ");
                        String studentName = scanner.next();

                        Student studentToUpdate = null;
                        for (Student s : students) {
                            if (s.getName().equals(studentName)) {
                                studentToUpdate = s;
                                break;
                            }
                        }

                        if (studentToUpdate != null) {
                            System.out.print("Enter the new grade for " + studentName + ": ");
                            String newGrade = scanner.next();

                            if (studentToUpdate.enrolledCourses.contains(student.getAssignedCourse().getCode())) {
                                studentToUpdate.enrolledCourses.remove(student.getAssignedCourse().getCode());
                                studentToUpdate.completedCourses.add(student.getAssignedCourse().getCode());
                                studentToUpdate.grades.put(student.getAssignedCourse().getCode(), Integer.valueOf(newGrade));
                                System.out.println("Grade updated successfully!");
                            } else {
                                System.out.println("Student has not enrolled in this course yet.");
                            }
                        } else {
                            System.out.println("Student not found.");
                        }
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.print("Press X to logout or any key to continue: ");
            char option = scanner.next().charAt(0);
            if (option == 'X' || option == 'x') {
                System.out.println("Logout successful!");
                return;
            }
        }
    }
    static void TaMenu(TeachingAssistant ta){
        while (true){
            System.out.println("Teaching Assistant Menu:");
            System.out.println("1. View available courses");
            System.out.println("2. Register for courses");
            System.out.println("3. View schedule");
            System.out.println("4. Track academic progress");
            System.out.println("5. Drop courses");
            System.out.println("6. Submit complaints");
            System.out.println("7. Give Feedback");
            System.out.println("8. View enrolled students");
            System.out.println("9. View student grades");
            System.out.println("10. Update grade for a student");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ta.viewAvailableCourses();
                    break;
                case 2:
                    ta.registerForCourses();
                    break;
                case 3:
                    ta.viewSchedule();
                    break;
                case 4:
                    ta.trackAcademicProgress();
                    break;
                case 5:
                    ta.dropCourses();
                    break;
                case 6:
                    ta.submitComplaints();
                    break;
                case 7:
                    ta.giveFeedback();
                    break;

                case 8:
                    ta.viewEnrolledStudents(students);
                    break;

                case 9:

                    ta.viewStudentGrades(students);
                    break;
                case 10:

                    ta.updateStudentGrade(students);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.print("Press X to logout or any key to continue: ");
            char option = scanner.next().charAt(0);
            if (option == 'X' || option == 'x') {
                System.out.println("Logout successful!");
                return;
            }
        }
        }

    static void professorMenu(Professor professor) {
        while (true) {
            System.out.println("Professor Menu:");
            System.out.println("1. Manage Courses");
            System.out.println("2. View Enrolled Students");
            System.out.println("3. View Feedback");
            System.out.println("4. View Ta Name");
            System.out.println("5. Assign Ta for courses");

            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    professor.manageCourses();
                    break;
                case 2:
                    professor.viewEnrolledStudents(Main.students);
                    break;
                case 3:
                    professor.viewFeedback();
                    break;
                    case 4:
                        professor.viewTaForCourse();
                case 5:
                    professor.assignTaToCourse(Main.students);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.print("Press X to logout or any key to continue: ");
            char option = scanner.next().charAt(0);
            if (option == 'X' || option == 'x') {
                System.out.println("Logout successful!");
                return;
            }
        }
    }

    static User[] addUser(User[] users, User user) {
        User[] newUsers = new User[users.length + 1];
        for (int i = 0; i < users.length; i++) {
            newUsers[i] = users[i];
        }
        newUsers[users.length] = user;
        return newUsers;
    }

    static Student[] addStudent(Student[] students, Student student) {
        Student[] newStudents = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            newStudents[i] = students[i];
        }
        newStudents[students.length] = student;
        return newStudents;
    }

    static Admin[] addAdmin(Admin[] admins, Admin admin) {
        Admin[] newAdmins = new Admin[admins.length + 1];
        for (int i = 0; i < admins.length; i++) {
            newAdmins[i] = admins[i];
        }
        newAdmins[admins.length] = admin;
        return newAdmins;
    }

    static Professor[] addProfessor(Professor[] professors, Professor professor) {
        Professor[] newProfessors = new Professor[professors.length + 1];
        for (int i = 0; i < professors.length; i++) {
            newProfessors[i] = professors[i];
        }
        newProfessors[professors.length] = professor;
        return newProfessors;
    }
}
