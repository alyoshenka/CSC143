
/**
 * Write a description of class Student here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Student extends Person {

    // Instance variables
    private String[] coursesTaken = new String[30];
    private double[] courseGrades = new double[30];
    private int nextCourseIndex;

    // Constructor
    public Student(String id, String name, String email) {
        super(id, name, email);
        nextCourseIndex = 0;
    }

    // Other methods
    @Override
    public boolean isValidId(String id) {
        return id.matches("[0-9]{9}");
    }

    public void recordCourseCompletion(String courseName, double courseGrade) {
        coursesTaken[nextCourseIndex] = courseName;
        courseGrades[nextCourseIndex] = courseGrade;
        nextCourseIndex++;
    }

    public double getAverageGrade() {
        double gradeTotal = 0.0;
        for (int course = 0; course < nextCourseIndex; course++) {
            gradeTotal += courseGrades[course];
        }
        return (nextCourseIndex == 0) ? -99.0 : gradeTotal / nextCourseIndex;
    }

    @Override
    public String toString() {
        String info = super.toString();
        info += "Current grade average is " + getAverageGrade() + "\n";
        info += "Student has completed " + nextCourseIndex + " course(s) so far:" + "\n";
        for (int courseIndex = 0; courseIndex < nextCourseIndex; courseIndex++) {
            info += "   - " + coursesTaken[courseIndex];
            info += " (" + courseGrades[courseIndex] + ")";
            info += "\n";
        }
        return info;
    }
}
