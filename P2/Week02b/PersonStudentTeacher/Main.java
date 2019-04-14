
public class Main
{
    public static void main(String[] args) {
        Person collegePeople[] = new Person[5];
        
        Student testStudent = new Student("123456789", "Bobby Brown", "bobb@comcast.net");
        testStudent.recordCourseCompletion("History of Western Civilizations", 1.7);
        testStudent.recordCourseCompletion("Algebra II", 3.9);
        testStudent.recordCourseCompletion("Geometry I", 3.7);
        testStudent.recordCourseCompletion("History of Western Civilizations", 3.0);
        
        Teacher testTeacher = new Teacher("SS9482", "Samantha Smith", "sammys@microsoft.com");
        testTeacher.addCourseTaught("Algebra II");
        testTeacher.addCourseTaught("Intro to Programming");
        testTeacher.addCourseTaught("Calculus I");
        
        // Can't do this
        //      Person testPerson2 = new Person("Dean Davis", "deano@gmail.com");

        // Can't do this 
        //      Person testPerson = new Student("987654321", "Chrissy Caldwell", "cccald@gmail.com");
        //      testPerson.recordCourseCompletion("Sociology I", 4.0);

        // CAN do this, but it is dangerous if applied incorrectly (e.g., on a Teacher)
        //      Person testPerson = new Student("987654321", "Chrissy Caldwell", "cccald@gmail.com");
        //      Student studentRefPerson = (Student)testPerson;
        //      studentRefPerson.recordCourseCompletion("Sociology I", 4.0);
        // Better...
        Person testPerson = new Student("987654321", "Chrissy Caldwell", "cccald@gmail.com");
        if (testPerson instanceof Student) {
            Student studentRefPerson = (Student)testPerson;
            studentRefPerson.recordCourseCompletion("Sociology I", 4.0);
        }
        
        // Add each to the array
        collegePeople[0] = testStudent;
        collegePeople[1] = testTeacher;
        collegePeople[2] = testPerson;
        
        for (int personIndex = 0; personIndex < 3; personIndex++) {
            System.out.println(collegePeople[personIndex] + "\n");
        }
   }
}
