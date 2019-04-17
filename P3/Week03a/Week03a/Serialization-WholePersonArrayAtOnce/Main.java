import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;

public class Main {

    public static int MAX_PEOPLE = 5;

    public static void main(String[] args) {
        Person collegePeople[] = new Person[MAX_PEOPLE];

        Student testStudent = new Student("123456789", "Bobby Brown", "bobb@comcast.net");
        testStudent.recordCourseCompletion("History of Western Civilizations", 1.7);
        testStudent.recordCourseCompletion("Algebra II", 3.9);
        testStudent.recordCourseCompletion("Geometry I", 3.7);
        testStudent.recordCourseCompletion("History of Western Civilizations", 3.0);

        Teacher testTeacher = new Teacher("SS9482", "Samantha Smith", "sammys@microsoft.com");
        testTeacher.addCourseTaught("Algebra II");
        testTeacher.addCourseTaught("Intro to Programming");
        testTeacher.addCourseTaught("Algebra II");

        Person testPerson = new Student("987654321", "Chrissy Caldwell", "cccald@gmail.com");
        if (testPerson instanceof Student) {
            Student studentRefPerson = (Student)testPerson;
            studentRefPerson.recordCourseCompletion("Sociology I", 4.0);
        }

        // Add each to the array
        collegePeople[0] = testStudent;
        collegePeople[1] = testTeacher;
        collegePeople[2] = testPerson;

        System.out.println("------------------------------------");
        System.out.println("Array contents, before serialization");
        System.out.println("------------------------------------");
        displayPeople(collegePeople);

        //-----------------------------------------------
        //      Serialize
        //-----------------------------------------------
        System.out.println("---->  Serialization starting");
        try {
            FileOutputStream fileOut = new FileOutputStream("people.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(collegePeople);
        } catch (IOException e) {
            System.out.println("Serialization failed");
        }
        System.out.println("---->  Serialization attempt complete\n");

        //-----------------------------------------------
        //      Zero out the array
        //-----------------------------------------------
        for (int personIndex = 0; personIndex < collegePeople.length; personIndex++) {
            collegePeople[personIndex] = null;
        }

        System.out.println("---------------------------------------");
        System.out.println("Array contents, after zeroing out array");
        System.out.println("---------------------------------------");
        displayPeople(collegePeople);

        //-----------------------------------------------
        //      Deserialize
        //-----------------------------------------------
        System.out.println("---->  Deserialization starting");
        try {
            FileInputStream peopleFile = new FileInputStream("people.ser");
            ObjectInputStream in = new ObjectInputStream(peopleFile);
            collegePeople = (Person[])in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Deserialization file not found");
        } catch (IOException e) {
            System.out.println("Deserialization failed");
        } catch (ClassNotFoundException e) {
            System.out.println("Deserialization failed; possible version problem");
        }
        System.out.println("---->  Deserialization attempt complete\n");

        System.out.println("-------------------------------------");
        System.out.println("Array contents, after deserialization");
        System.out.println("-------------------------------------");
        displayPeople(collegePeople);
    }

    private static void displayPeople(Person[] people) {
        for (int personIndex = 0; personIndex < people.length; personIndex++) {
            System.out.println(people[personIndex] + "\n");
        }
    }
}
