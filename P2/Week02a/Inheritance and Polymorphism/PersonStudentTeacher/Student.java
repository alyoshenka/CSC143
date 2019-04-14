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
    public boolean isValidId(String id) {
        // Far easier with regexp:  
        return id.matches("[0-9]{9}");
        // Harder way:
        //         boolean validId = true;
        //         if (id.length() != 9) {
        //             validId = false;
        //         }
        //         else {
        //             for (int letterPos = 0; letterPos < id.length(); letterPos++) {
        //                 if (id.charAt(letterPos) < '0' || id.charAt(letterPos)> '9') {
        //                     validId = false;
        //                 }
        //             }
        //         }
        //         return validId;
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
