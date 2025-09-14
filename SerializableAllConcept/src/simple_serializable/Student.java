package simple_serializable;

import java.io.Serializable;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int studentRollNo;
    private String studentName;
    private String studentAddress;
     
    public Student(int studentRollNo, String studentName, String studentAddress) {
        System.out.println("Student Constructor...");
        this.studentRollNo = studentRollNo;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
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
 
    @Override
    public String toString() {
        return "Student [studentRollNo=" + studentRollNo + ", studentName=" + studentName + ", studentAddress="
                + studentAddress + "]";
    }
}
