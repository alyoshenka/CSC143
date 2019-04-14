
public class Main {
    public static void main(String[] args) {
        
        Student testStudent = new Student("123456789", "Bobby Brown", "bobb@comcast.net");
        testStudent.recordCourseCompletion("History of Western Civilizations", 1.7);
        testStudent.recordCourseCompletion("Algebra II", 3.9);
        testStudent.recordCourseCompletion("Geometry I", 3.7);
        testStudent.recordCourseCompletion("History of Western Civilizations", 3.0);
        System.out.println(testStudent);
        
        Teacher testTeacher = new Teacher("SS9482", "Samantha Smith", "sammys@microsoft.com");
        testTeacher.addCourseTaught("Algebra II");
        testTeacher.addCourseTaught("Intro to Programming");
        testTeacher.addCourseTaught("Algebra II");
        System.out.println(testTeacher);
   }
}
