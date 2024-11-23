package Student;
import Course.Course;

import java.util.*;
import Course.CourseCatalog;


public class TeachingAssistant extends Student {
    private Course assignedCourse;

    public TeachingAssistant(String name, String username, String password, Course assignedCourse) {
        super(name, username, password);
        this.assignedCourse = assignedCourse;
    }
    public void viewEnrolledStudents(Student[] students) {
        int semester = Integer.parseInt(assignedCourse.getCode().substring(3, 4));
        System.out.println("Enrolled students in " + assignedCourse.getCourseName() + ":");
        for (Student s : students) {
            if ((s.enrolledCourses.contains(assignedCourse.getCode()) && s.semester == semester && !s.equals(this)) ||
                    (s.completedCourses.contains(assignedCourse.getCode()) && Integer.parseInt(s.completedCourses.get(s.completedCourses.indexOf(assignedCourse.getCode())).substring(3, 4)) == semester && !s.equals(this))) {
                System.out.println("Name: " + s.getName());
                System.out.println("Email: " + s.getuserName() + "@gmail.com");
                if (s.completedCourses.contains(assignedCourse.getCode())) {
                    System.out.println("Grade: " + s.grades.get(assignedCourse.getCode()));
                } else {
                    System.out.println("Grade: N/A");
                }
                System.out.println();
            }
        }
    }

    public void viewStudentGrades(Student[] students) {
        int semester = Integer.parseInt(assignedCourse.getCode().substring(3, 4));
        System.out.println("Student Grades for " + assignedCourse.getCourseName() + ":");
        for (Student s : students) {
            if ((s.enrolledCourses.contains(assignedCourse.getCode()) && s.semester == semester && !s.equals(this)) ||
                    (s.completedCourses.contains(assignedCourse.getCode()) && Integer.parseInt(s.completedCourses.get(s.completedCourses.indexOf(assignedCourse.getCode())).substring(3, 4)) == semester && !s.equals(this))) {
                System.out.print("Name: " + s.getName());
                if (s.completedCourses.contains(assignedCourse.getCode())) {
                    System.out.println(", Grade: " + s.grades.get(assignedCourse.getCode()));
                } else {
                    System.out.println(", Grade: N/A");
                }
            }
        }
    }

    public void updateStudentGrade(Student[] students) {
        int semester = Integer.parseInt(assignedCourse.getCode().substring(3, 4));
        System.out.println("Enrolled students in " + assignedCourse.getCourseName() + ":");
        for (Student s : students) {
            if ((s.enrolledCourses.contains(assignedCourse.getCode()) && s.semester == semester && !s.equals(this)) ||
                    (s.completedCourses.contains(assignedCourse.getCode()) && Integer.parseInt(s.completedCourses.get(s.completedCourses.indexOf(assignedCourse.getCode())).substring(3, 4)) == semester && !s.equals(this))) {
                System.out.println("Name: " + s.getName());
                System.out.println("Email: " + s.getuserName() + "@gmail.com");
                if (s.completedCourses.contains(assignedCourse.getCode())) {
                    System.out.println("Grade: " + s.grades.get(assignedCourse.getCode()));
                } else {
                    System.out.println("Grade: N/A");
                }
                System.out.println();
            }
        }

        System.out.print("Enter the name of the student whose grade you want to update: ");
        Scanner scanner= new Scanner(System.in);
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

            if (studentToUpdate.enrolledCourses.contains(assignedCourse.getCode())) {
                studentToUpdate.enrolledCourses.remove(assignedCourse.getCode());
                studentToUpdate.completedCourses.add(assignedCourse.getCode());
                studentToUpdate.grades.put(assignedCourse.getCode(), Integer.valueOf(newGrade));
                System.out.println("Grade updated successfully!");
            } else {
                System.out.println("Student has not enrolled in this course yet.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }
}


