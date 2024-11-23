package Course;

import java.util.ArrayList;
import java.util.List;

public class CourseCatalog {
    private static CourseCatalog instance;
    public Course[] courses;

    private CourseCatalog() {
        courses = new Course[37];

        // Semester 1 courses
        courses[0] = new Course("Human Computer Interaction", "DES101", "Sonal", 4, new String[0], "Monday 4:00PM-5:00PM", "User-centered design principles", "Tuesday 6:00 PM", 3, 1, "LHC");
        courses[1] = new Course("Digital Circuits", "ELE101", "Tammam", 4, new String[0], "Wednesday 11:00AM-12:00PM", "Logic gates, Sequential circuits", "Monday 3:00 PM", 3, 1, "RnD");
        courses[2] = new Course("Introduction to Programming", "CSE105", "Shad", 4, new String[0], "Friday 4:00PM-5:00PM", "loops, functions, oops", "Wednesday 2:00 PM", 3, 1, "LHC");
        courses[3] = new Course("Linear Algebra", "MAT102", "Sanjit", 4, new String[0], "Tuesday 1:00PM-2:00PM", "Logic, Set theory", "Friday 12:00 PM", 3, 1, "RnD");
        courses[4] = new Course("Communication", "COM101", "Sonal", 4, new String[0], "Wednesday 1:00PM-2:00PM", "communication techniques, professional communication", "Saturday 12:00 PM", 3, 1, "RnD");
        courses[5] = new Course("Cloud Computing", "CSE1001", "Ashish", 2, new String[0], "Wednesday 2:00PM-4:00PM", "Services, Architecture", "Friday 1:00 PM", 3, 1, "LHC");
        courses[6] = new Course("Theory of Computation", "MAT1001", "Ashish", 2, new String[0], "Tuesday 3:00PM-5:00PM", "Automata, Complexity", "Wednesday 4:00 PM", 3, 1, "LHC");

        // Semester 2 courses
        courses[7] = new Course("Computer Organization", "CSE201", "Tammam", 4, new String[]{"ELE101"}, "Friday 1:00PM-3:00PM", "Assembly language, architecture", "Tuesday 3:00 PM", 3, 2, "LHC");
        courses[8] = new Course("Data Structures and Algorithms", "CSE202", "Shad", 4, new String[]{"CSE105"}, "Wednesday 2:00PM-4:00PM", "Trees, Graphs, Sorting algorithms", "Monday 5:00 PM", 3, 2, "RnD");
        courses[9] = new Course("Probability and Statistics", "MTH202", "Sanjit", 4, new String[]{"MAT102"}, "Tuesday 1:00PM-3:00PM", "probability , conditional probability, statistics", "Friday 3:00 PM", 3, 2, "LHC");
        courses[10] = new Course("Design Drawing and Visualization", "DES202", "Anoop", 4, new String[0], "Friday 2:00PM-4:00PM", "Art , Drawing", "Monday 11:00 AM", 3, 2, "LHC");
        courses[11] = new Course("Visual Designing Course", "DES205", "Anoop", 4, new String[0], "Thursday 2:00PM-4:00PM", "Photoshop, Illustrator", "Monday 11:00 AM", 3, 2, "LHC");
        courses[12] = new Course("Mobile App Development", "CSE2002", "Ashish", 2, new String[0], "Wednesday 3:00PM-5: 00PM", "Android, iOS", "Thursday 3:00 PM", 3, 2, "RnD");
        courses[13] = new Course("Embedded Systems", "ELE2002", "Ashish", 2, new String[]{"CSE105"}, "Thursday 10:00AM-12:00PM", "Microcontrollers, Programming", "Monday 2:00 PM", 3, 2, "RnD");
        courses[14] = new Course("Basic Electronics", "ELE201", "Sujay", 4, new String[]{"ELE101"}, "Friday 1:00PM-3:00PM", "Electronic circuits, devices", "Tuesday 3:00 PM", 3, 2, "LHC");
        courses[15] = new Course("Introduction to Biosciences", "BIO202", "Rishi", 4, new String[0], "Wednesday 2:00PM-4:00PM", "Cell biology, genetics", "Monday 5:00 PM", 10, 2, "RnD");
        courses[16] = new Course("Introduction to Sociology", "SOC203", "Rishi", 4, new String[0], "Tuesday 1:00PM-3:00PM", "Social structures, institutions", "Friday 3:00 PM", 3, 2, "LHC");
        courses[17] = new Course("Introduction to Artificial Intelligence", "IAI207", "Sujay", 4, new String[]{"CSE105"}, "Friday 2:00PM-4:00PM", "Machine learning, AI applications", "Monday 11:00 AM", 10, 2, "LHC");
        courses[18] = new Course("Money and Banking", "ECO2005", "Sonal", 2, new String[0], "Thursday 2:00PM-4:00PM", "Monetary policy, banking systems", "Monday 11:00 AM", 3, 2, "LHC");
        courses[19] = new Course("Introduction to Economics", "ECO2006", "Sonal", 2, new String[0], "Wednesday 3:00PM-5: 00PM", "Microeconomics, macroeconomics", "Thursday 3:00 PM", 40, 2, "RnD");
        courses[20] = new Course("Sociology and Anthropology", "SOC2007", "Anoop", 2, new String[0], "Thursday 10:00AM-12:00PM", "Cultural anthropology, social theory", "Monday 2:00 PM", 30, 2, "RnD");

        // Semester 3 courses
        courses[21] = new Course("Design Processes and Perspectives", "DES301", "Sonal", 4, new String[0], "Wednesday 11:00AM-12:00PM", "Design thinking, Human-centered design", "Thursday 5:00 PM", 20, 3, "RnD");
        courses[22] = new Course("Operating Systems", "CSE302", "Tammam", 4, new String[]{"CSE201"}, "Thursday 2:00PM-4:00PM", "Process management, Memory allocation", "Friday 3:00 PM", 25, 3, "LHC");
        courses[23] = new Course("Advanced Programming", "CSE303", "Shad", 4, new String[]{"CSE105"}, "Monday 1:00PM-3:00PM", "Object-oriented programming, Functional programming", "Tuesday 5:00 PM", 25, 3, "LHC");
        courses[24] = new Course("Multivariate Calculus", "MAT301", "Sanjit", 4, new String[]{"MAT102"}, "Tuesday 3:00PM-5:00PM", "Partial derivatives, Multiple integrals", "Wednesday 4:00 PM", 20, 3, "LHC");
        courses[25] = new Course("Discrete Maths", "MAT302", "Sanjit", 4, new String[]{"MAT102"}, "Friday 10:00AM-12:00PM", "Graph theory, Combinatorics", "Monday 4:00 PM", 30, 3, "RnD");
        courses[26] = new Course("Discrete Structures", "CSE304", "Sanjit", 4, new String[]{"CSE201"}, "Monday 11:00AM-12:00PM", "Set theory, Relations", "Tuesday 4:00 PM", 20, 3, "LHC");
        courses[27] = new Course("Real Analysis", "MAT303", "Sanjit", 4, new String[]{"MAT102"}, "Thursday 10:00AM-12:00PM", "Sequences, Series", "Friday 2:00 PM", 25, 3, "LHC");
        courses[28] = new Course("Cell Biology", "BIO301", "Rishi", 4, new String[]{"BIO202"}, "Wednesday 2:00PM-4:00PM", "Cell structure, Cell signaling", "Monday 5:00 PM", 10, 3, "RnD");
        courses[29] = new Course("Social Theory", "SOC301", "Sonal", 4, new String[]{"SOC203"}, "Tuesday 1:00PM-3:00PM", "Social structures, Institutions", "Friday 3:00 PM", 10, 3, "LHC");
        courses[30] = new Course("Artificial Intelligence I", "CSE305", "Sujay", 4, new String[]{"CSE204"}, "Friday 2:00PM-4:00PM", "Machine learning, AI applications", "Monday 11:00 AM", 10, 3, "LHC");
        courses[31] = new Course("Artificial Intelligence II", "CSE306", "Sujay", 4, new String[]{"CSE204"}, "Thursday 2:00PM-4:00PM", "Deep learning, Natural language processing", "Friday 3:00 PM", 25, 3, "LHC");
        courses[32] = new Course("Data Science", "CSE3001", "Rishi", 2, new String[0], "Wednesday 3:00PM-5: 00PM", "Data analysis, Visualization", "Thursday 3:00 PM", 40, 3, "RnD");
        courses[33] = new Course("Computer Networks II", "CSE3002", "Rishi", 2, new String[]{"CSE201"}, "Thursday 10:00AM-12:00PM", "Network protocols, Architecture", "Monday 2:00 PM", 30, 3, "RnD");
        courses[34] = new Course("Database Management Systems", "CSE3003", "Sujay", 2, new String[]{"CSE201"}, "Monday 11:00AM-12:00PM", "Database design, Querying", "Tuesday 4:00 PM", 20, 3, "LHC");
        courses[35] = new Course("Web Development II", "CSE3004", "Ashish", 2, new String[]{"CSE3001"}, "Thursday 10:00AM-12:00PM", "Cryptography, Threat analysis", "Friday 2:00 PM", 25, 3, "LHC");
        courses[36] = new Course("Data Warehousing", "CSE2005", "Rishi", 2, new String[]{"CSE2004"}, "Monday 11:00AM-12:00PM", "Data modeling, ETL", "Tuesday 4:00 PM", 20, 3, "LHC");
    }
    public static CourseCatalog getInstance() {
        if (instance == null) {
            instance = new CourseCatalog();
        }
        return instance;
    }
        public void displayCourses(int semester) {
            for (Course course : courses) {
                if (course.semester == semester) {
                    System.out.println("Title: " + course.title);
                    System.out.println("Code: " + course.code);
                    System.out.println("Professor: " + course.professorName);
                    System.out.println("Credits: " + course.credits);
                    System.out.println("Prerequisites: " + (course.prerequisites.length == 0 ? "None" : String.join(", ", course.prerequisites)));
                    System.out.println("Timings: " + course.timings);
                    System.out.println("Syllabus: " + course.syllabus);
                    System.out.println("Office Hours: " + course.officeHours);
                    System.out.println("Location: " + course.location);
                    System.out.println("-----");
                }
            }
        }


    public Course findCourseByCode(String code) {
        for (Course course : this.courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null;
    }
    public void removeCourse(Course course) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].getCode().equals(course.getCode())) {
                Course[] newCourses = new Course[courses.length - 1];
                System.arraycopy(courses, 0, newCourses, 0, i);
                System.arraycopy(courses, i + 1, newCourses, i, courses.length - i - 1);
                courses = newCourses;
                return;
            }
        }
    }
    public void addCourse(Course course) {
        Course[] newCourses = new Course[courses.length + 1];
        System.arraycopy(courses, 0, newCourses, 0, courses.length);
        newCourses[courses.length] = course;
        courses = newCourses;
    }
    public List<Course> getCoursesBySemester(int semester) {
        List<Course> coursesBySemester = new ArrayList<>();
        for (Course course : courses) {
            if (course.getSemester() == semester) {
                coursesBySemester.add(course);
            }
        }
        return coursesBySemester;
    }

    public List<String> getAllCourseCodes() {
        List<String> courseCodes = new ArrayList<>();
        for (Course course : courses) {
            courseCodes.add(course.getCode());
        }
        return courseCodes;
    }
    public Course getCourseByCode(String codeToDelete) {
        for (Course course : courses) {
            if (course.getCode().equals(codeToDelete)) {
                return course;
            }
        }
        return null;
    }

    public Course[] getCourses() {
        return courses;
    }

}
