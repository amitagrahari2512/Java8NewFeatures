package simple_serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StudentSerializationImplementation {
	public static void main(String[] args) throws IOException {
        Student student = new Student(25, "Sridhar", "Chennai");
        System.out.println(student);
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream("student.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch <span id="IL_AD6" class="IL_AD">block
            e.printStackTrace();
        }
    }
}
