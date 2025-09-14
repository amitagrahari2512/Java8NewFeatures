package parent_serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationParentInheritanceDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		 Son son = new Son();
		 son.child = 11;
		 son.parent = 21;
		 System.out.println("Serialization Starts");
		 FileOutputStream fileOutputStream = new FileOutputStream("inheritance.txt");
		 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		 objectOutputStream.writeObject(son);
		  
		 System.out.println("DeSerialization Starts");
		 FileInputStream fileInputStream = new FileInputStream("inheritance.txt");
		 ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
		 Son son1 = (Son)inputStream.readObject();
		  
		 System.out.println(son1.child);
		 System.out.println(son1.parent);
		 }
}
