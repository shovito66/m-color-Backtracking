import java.util.LinkedList;

public class Course {
    int courseCode;
    int TotalStudent;
    LinkedList<Course> adjList;

    public LinkedList<Course> getAdjList() {
        return adjList;
    }


    public Course(int courseCode, int totalStudent) {
        this.courseCode = courseCode;
        this.TotalStudent = totalStudent;
        this.adjList = new LinkedList();
    }

    public void addCourses(Course c){
        adjList.add(c);
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public int getTotalStudent() {
        return TotalStudent;
    }

    public void setTotalStudent(int totalStudent) {
        TotalStudent = totalStudent;
    }

    public Course getCourseObject(int code){
        if (this.courseCode == code)
            return this;
        else
            return null;
    }
}
