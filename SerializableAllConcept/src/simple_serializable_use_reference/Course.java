package simple_serializable_use_reference;

import java.io.Serializable;

public class Course implements Serializable{
	 
    private int courseId;
    private String courseName;
    private double courseCost;
     
    public Course(int courseId, String courseName, double courseCost) {
        System.out.println("Course Constructor...");
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCost = courseCost;
    }
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public double getCourseCost() {
        return courseCost;
    }
    public void setCourseCost(double courseCost) {
        this.courseCost = courseCost;
    }
 
    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseCost=" + courseCost + "]";
    }
}
