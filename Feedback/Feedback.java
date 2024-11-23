package Feedback;
import java.util.ArrayList;
import java.util.List;

public class Feedback<T> {
    private String studentName;
    private String courseCode;
    private T feedback;

    public Feedback(String studentName, String courseCode, T feedback) {
        this.studentName = studentName;
        this.courseCode = courseCode;
        this.feedback = feedback;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public T getFeedback() {
        return feedback;
    }
}
