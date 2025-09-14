package simple_serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StudentDeSerializationImplementation {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("student.ser");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Student student = (Student)inputStream.readObject();
        System.out.println("De-Serialized Object");
        System.out.println(student);
    }
}
