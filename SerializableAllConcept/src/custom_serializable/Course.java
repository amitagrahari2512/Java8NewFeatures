package custom_serializable;

public class Course{
	 
    private int courseId;
    private String courseName;
    private double courseCost;
    private Lecture    staffTaken;
    public Course(int courseId, String courseName, double courseCost,Lecture lecture) {
        System.out.println("Course Constructor...");
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCost = courseCost;
        this.staffTaken = lecture;
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
 
    public Lecture getStaffTaken() {
        return staffTaken;
    }
 
    public void setStaffTaken(Lecture staffTaken) {
        this.staffTaken = staffTaken;
    }
 
    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseCost=" + courseCost
                + ", staffTaken=" + staffTaken + "]";
    }
 
     
}
