import Student.Student;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student1 = new Student("Allen", "Barry", 25);

        System.out.println("Before serialization:");
        System.out.println(student1);

        FileOutputStream outputStream = new FileOutputStream("e:\\out.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(student1);

        FileInputStream inputStream = new FileInputStream("e:\\out.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

      Student  student2 = (Student) objectInputStream.readObject();
        System.out.println("After deserialization");
        System.out.println(student2);

    }

}
