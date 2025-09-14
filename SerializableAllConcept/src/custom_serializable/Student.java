package custom_serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable{
    
    private int studentRollNo;
    private String studentName;
    private String studentAddress;
    transient private Course course;
    transient private Department department;
    public Student(int studentRollNo, String studentName, String studentAddress, Course course, Department department) {
        System.out.println("Student Constructor...");
        this.studentRollNo = studentRollNo;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.course = course;
        this.department = department;
    }
 
    public int getStudentRollNo() {
        return studentRollNo;
    }
 
    public void setStudentRollNo(int studentRollNo) {
        this.studentRollNo = studentRollNo;
    }
 
    public String getStudentName() {
        return studentName;
    }
 
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
 
    public String getStudentAddress() {
        return studentAddress;
    }
 
    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }
 
     
    public Course getCourse() {
        return course;
    }
 
    public void setCourse(Course course) {
        this.course = course;
    }
 
    public Department getDepartment() {
        return department;
    }
 
    public void setDepartment(Department department) {
        this.department = department;
    }
 
    @Override
    public String toString() {
        return "Student [studentRollNo=" + studentRollNo + ", studentName=" + studentName + ", studentAddress="
                + studentAddress + ", course=" + course + ", department=" + department + "]";
    }
 
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException{
        System.out.println("Custom Serialization starts");
            objectOutputStream.defaultWriteObject();
             
            objectOutputStream.writeInt(course.getStaffTaken().getLectureId());
            objectOutputStream.writeObject(course.getStaffTaken().getLectureName());
             
            objectOutputStream.writeInt(course.getCourseId());
            objectOutputStream.writeObject(course.getCourseName());
            objectOutputStream.writeDouble(course.getCourseCost());
            //objectOutputStream.writeObject(course.getStaffTaken());
             
            objectOutputStream.writeInt(department.getDeptNo());
            objectOutputStream.writeObject(department.getDeptName());
         
        System.out.println("Custom Serialization ends");
    }
     
    private void readObject(ObjectInputStream objectinputStream) throws IOException, ClassNotFoundException {
        System.out.println("Custom De Serialization starts");
        objectinputStream.defaultReadObject();
        int lectureId = objectinputStream.readInt();
        String lectureName = (String)objectinputStream.readObject();
         
         
        int courseId = objectinputStream.readInt();
        String courseName =  (String)objectinputStream.readObject();
        double courseCost = objectinputStream.readDouble();
        course = new Course(courseId, 
                courseName, courseCost, 
                new Lecture(lectureId,lectureName));
         
        int deptNo =  objectinputStream.readInt();
        String deptName =  (String)objectinputStream.readObject();
        department = new Department(deptNo, deptName);
        System.out.println("Custom De Serialization ends");
    }
}
