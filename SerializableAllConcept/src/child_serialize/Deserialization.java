package child_serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {
	 
	 public static void main(String[] args) throws IOException, ClassNotFoundException{
	  
	 FileInputStream fileInputStream = new FileInputStream("son.ser");
	 ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
	 Son sonDeseralized = (Son)inputStream.readObject();
	 System.out.println(sonDeseralized.parent);
	 System.out.println(sonDeseralized.child);
	 }
	 
	}
