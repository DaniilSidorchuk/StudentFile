package Student;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import static java.lang.String.valueOf;

public class Student implements Externalizable{

    private String lastName;
    private String firstName;
    private int age;
    private  int n=3;

    public Student() {
    }

    public Student(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }


    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        lastName = encrypting(lastName);
        firstName = encrypting(firstName);
        age = (n*n + age) * -100;
        out.writeObject(lastName);
        out.writeObject(firstName);
        out.writeInt(age);

    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        lastName = decrypting((String)in.readObject());
        firstName = decrypting((String)in.readObject());
        age = (in.readInt() / -100) - n*n;
    }

    private String encrypting(String name){
        char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        name= name.toLowerCase();
        char[] word = name.toCharArray();

        for (int i = 0; i <word.length ; i++) {
            for (int j = 0; j < letters.length; j++) {
                if(word[i] == letters[j]){
                    int index = letters.length-1-j;
                    if (index >= n){
                        word[i] = letters[j+n];
                    }else{
                        word[i] = letters[n-index-1];
                    }
                    break;
                }
            }
        }
        name = valueOf(word[0]);
        for (int i = 1; i < word.length; i++) {
        name = name + word[i];
        }
        return name;
    }

    private String decrypting(String name){
        char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        name= name.toLowerCase();
        char[] word = name.toCharArray();

        for (int i = 0; i <word.length ; i++) {
            for (int j = 0; j < letters.length; j++) {
                if(word[i] == letters[j]){
                    if (j >= n){
                        word[i] = letters[j-n];
                    }else{
                        word[i] = letters[letters.length-n+j];
                    }
                    break;
                }
            }
        }
        name = valueOf(word[0]);
        name = name.toUpperCase();
        for (int i = 1; i < word.length; i++) {
            name = name + word[i];
        }
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
