public class Teacher extends Person {

    // Instance variables
    private String[] coursesTaught = new String[50];
    private int nextCourseIndex;

    // Constructor
    public Teacher(String id, String name, String email) {
        super(id, name, email);
        nextCourseIndex    = 0;
    }

    // Other methods
    public boolean isValidId(String id) {
        return id.matches("[A-Z0-9]{6}");
    }

    public void addCourseTaught(String course) {
        // See if the course is already on the list
        int courseIndex = 0;
        while ( courseIndex < coursesTaught.length && 
                courseIndex < nextCourseIndex && 
                !coursesTaught[courseIndex].equals(course)) {
            courseIndex++;
        }
        if (coursesTaught[courseIndex] == null || !coursesTaught[courseIndex].equals(course)) {
            // Add the course
            coursesTaught[nextCourseIndex] = course;
            nextCourseIndex++;
        }
    }
    
    public String toString() {
        String info = super.toString();
        info += "Has taught " + nextCourseIndex + " course(s):\n";
        for (int courseIndex = 0; courseIndex < nextCourseIndex; courseIndex++) {
            info += "   - " + coursesTaught[courseIndex] + "\n";
        }
        return info;
    }
}
