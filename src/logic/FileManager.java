package logic;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by svkreml on 05.10.2016.
 */
public class FileManager {
    String fileName;
    Object object = null;
    ObjectOutputStream saveStream;
    ObjectInputStream loadStream;
    public FileManager(String fileName) {
        this.fileName = fileName;
        /*File newFile = new File(fileName);
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            //e.printStackTrace();
        }
*/
    }

    public void saveName(String fileName) {
        this.fileName = fileName;
    }

    public void save(Object db) {
        try {
            saveStream = new ObjectOutputStream(
                    new FileOutputStream(fileName));
            saveStream.writeObject(db);
            saveStream.flush();
            saveStream.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public Object load() {
        try {
            loadStream = new ObjectInputStream(
                    new FileInputStream(fileName));
            object = loadStream.readObject();
            loadStream.close();
        } catch (FileNotFoundException ex) {
            //System.out.println(ex.toString());
            System.out.println("File not found, creating new file " + fileName);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return object;
    }
    public Vector<Iris> irisload(){

        Vector<Iris> irises = new Vector<>();
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {

                Iris iris = new Iris(scan.nextLine());
                irises.add(iris);
            }
            scan.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found, creating new file " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return irises;
    }

    public String readString() {
        byte[] buf = new byte[0];
        try {
            buf = Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(buf, StandardCharsets.UTF_8);
    }

    public void writeString(String s) {
        byte[] buf = s.getBytes();
        try {
            Files.write(Paths.get(fileName), buf, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
