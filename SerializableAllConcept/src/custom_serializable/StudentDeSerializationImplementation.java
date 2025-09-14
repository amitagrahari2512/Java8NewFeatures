package custom_serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StudentDeSerializationImplementation {
	 public static void main(String[] args) throws IOException, ClassNotFoundException {
	        FileInputStream fileInputStream = new FileInputStream("student.ser");
	        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
	        System.out.println("De Serialization starts");
	        Student student = (Student)inputStream.readObject();
	        System.out.println("De Serialization Ends");
	        System.out.println("---------------------");
	        System.out.println("De-Serialized Object");
	        System.out.println(student);
	    }
}
