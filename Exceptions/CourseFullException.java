package Exceptions;

public class CourseFullException extends Exception{
    public CourseFullException(String error){
        super(error);
    }
}
