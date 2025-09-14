package custom_serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StudentSerializationImplementation {
	 
    public static void main(String[] args) throws IOException {
        Lecture lecture = new Lecture(1001, "Sripathy");
        Course course = new Course(1, "Java Serialization", 500, lecture);
        Department department = new Department(101,"CS");
        Student student = new Student(25, "Sridhar", "Chennai", course,department);
         
        System.out.println(student);
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream("student.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            System.out.println("Serialization starts");
            objectOutputStream.writeObject(student);
            System.out.println("Serialization ends");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
