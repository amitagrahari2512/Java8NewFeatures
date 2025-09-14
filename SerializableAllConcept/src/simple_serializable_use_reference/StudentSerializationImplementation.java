package simple_serializable_use_reference;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StudentSerializationImplementation {
	public static void main(String[] args) throws IOException {
        Course course = new Course(1, "Java Serialization", 500);
        Student student = new Student(25, "Sridhar", "Chennai", course);
         
        System.out.println(student);
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream("student.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
