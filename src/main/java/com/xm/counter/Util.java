package com.xm.counter;

import java.io.*;

/**
 * Created by peter on 2016/9/17.
 */
public class Util {
    public static final String fileName = "E://Counter.ser";

    public static void SerializeCounter(Counter count) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(count);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in " + fileName);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Counter DeserializeCounter() {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Counter count = (Counter) in.readObject();
            in.close();
            fileIn.close();
            return count;
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Counter class not found");
            c.printStackTrace();
            return null;
        }
    }

    public static String getFileName() {
        return fileName;
    }
}
