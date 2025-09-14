package creational.singelton_pattern.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializedSingletonWithReadResolver implements Serializable{

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingletonWithReadResolver(){}
    
    private static class SingletonHelper{
        private static final SerializedSingletonWithReadResolver instance = new SerializedSingletonWithReadResolver();
    }
    
    public static SerializedSingletonWithReadResolver getInstance(){
        return SingletonHelper.instance;
    }
    
    protected Object readResolve() {
        return getInstance();
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        SerializedSingletonWithReadResolver instanceOne = SerializedSingletonWithReadResolver.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();
        
        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        SerializedSingletonWithReadResolver instanceTwo = (SerializedSingletonWithReadResolver) in.readObject();
        in.close();
        
        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
        
    }
    
}
