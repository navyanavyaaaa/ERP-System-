package Course;

import Student.Student;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Course {
    public String title;
    public String code;
    public String professorName;
    public int credits;
    public String[] prerequisites;
    public String timings;
    public String syllabus;
    public String officeHours;
    public int enrollmentLimit;
    public int semester;
    public String location;
    private String classTimings;
    private String taName;
    private LocalDate dropDeadline;


    public Course(String title, String code, String professorName, int credits, String[] prerequisites, String timings, String syllabus, String officeHours, int enrollmentLimit,int semester,String location) {
        this.title = title;
        this.code = code;
        this.professorName = professorName;
        this.credits = credits;
        this.prerequisites = prerequisites;
        this.timings = timings;
        this.syllabus = syllabus;
        this.officeHours = officeHours;
        this.enrollmentLimit = enrollmentLimit;
        this.semester=semester;
        this.location=location;
        this.taName=null;
        this.dropDeadline = dropDeadline;
    }
    public Course(String title, String code, int semester, String professorName, String timings, String syllabus, String officeHours, String prerequisites[], int credits, int enrollmentLimit) {
        this.title = title;
        this.code = code;
        this.semester = semester;
        this.professorName = professorName;
        this.timings = timings;
        this.syllabus = syllabus;
        this.officeHours = officeHours;
        this.prerequisites = prerequisites;
        this.credits = credits;
        this.enrollmentLimit = enrollmentLimit;
        this.dropDeadline = dropDeadline;
    }
    public String getTaName() {
        return taName;
    }

    public void setTaName(String taName) {
        this.taName = taName;
    }
    public String getCode() {
        return code;
    }


    public int getCredits() {
        return credits;
    }
    public String getCourseName() {
        return title;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getClassTimings() {
        return classTimings;
    }

    public void setClassTimings(String classTimings) {
        this.timings = classTimings;
    }


    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String[] getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String[] prerequisites) {
        this.prerequisites = new String[]{Arrays.toString(prerequisites)};
    }

    public int getEnrollmentLimit() {
        return enrollmentLimit;
    }

    public void setEnrollmentLimit(int enrollmentLimit) {
        this.enrollmentLimit = enrollmentLimit;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public void setTimings(String timings) { this.timings = timings; }

    public String getTimings(){return timings;}
    public void setLocation(String location) { this.location = location; }
    public String getLocation(){return location;}

    public int getSemester() {return semester;
    }

    public String getTitle() {return title;}

    public String getProfessorName() {return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName=professorName;
    }
    public LocalDate getDropDeadline() {
        return dropDeadline;
    }

    public void setDropDeadline(LocalDate dropDeadline) {
        this.dropDeadline = dropDeadline;
    }
}


