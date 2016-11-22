package Student;

import Student.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsList {

    public static void main(String[] args) throws IOException {
        String path = "e:\\student.txt.txt";
        List<Student> students = readFile(path);
        fileWriter(students);
    }

    private static List readFile(String path) throws IOException {
        List<Student> students = new ArrayList();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> line = new ArrayList();
        String list;
        while (( list =bufferedReader.readLine())!= null) {
            line.add(list);
        }
        String[] lastName;
        String[] firstName;
        String[] age;

        for (int i = 0; i < line.size(); i+=3) {
            lastName = line.get(i).split(" ");
            int length1 = lastName.length-1;
            firstName = line.get(i+1).split(" ");
            int length2 = firstName.length-1;
            age = line.get(i+2).split(" ");
            int length3 = age.length-1;
            int age1 = Integer.valueOf(age[length3]);
            students.add(new Student(lastName[length1], firstName[length2], age1));
       }
       bufferedReader.close();
       return students;
    }

    private static void fileWriter (List <Student> student) throws IOException {
        FileWriter fileWriter = new FileWriter("e:\\studentOut.txt.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("<Students>");
        bufferedWriter.newLine();
        for (int i = 0; i < student.size(); i++) {
            bufferedWriter.write("<Student.Student>");
            bufferedWriter.newLine();
            bufferedWriter.write("<LastName>" + student.get(i).getLastName() + "</LastName>");
            bufferedWriter.newLine();
            bufferedWriter.write("<FirstName>" + student.get(i).getFirstName() + "</FirstName>");
            bufferedWriter.newLine();
            bufferedWriter.write("<Age>" + student.get(i).getAge() + "</Age>");
            bufferedWriter.newLine();
            bufferedWriter.write("</Student.Student>");
            bufferedWriter.newLine();
        }
        bufferedWriter.write("</Students>");
        bufferedWriter.close();
    }

}
