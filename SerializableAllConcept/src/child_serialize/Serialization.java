package child_serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {
	 
	 public static void main(String[] args) throws IOException, ClassNotFoundException{
	 Son son = new Son();
	 son.parent = 101;
	 son.child = 102;
	 FileOutputStream fileOutputStream = new FileOutputStream("son.ser") ;
	 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	 objectOutputStream.writeObject(son);
	 
	 }
	 
	}