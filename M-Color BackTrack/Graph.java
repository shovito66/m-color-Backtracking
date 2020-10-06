import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    int totalVertex;
    LinkedList<Course> vertexList;
    int VertexDegreeArray [];
    List<Element> DegreeSortedVertex = new ArrayList<Element>(); //vertex gula degree onujayoi sorted,
    // etar index element diyei ami vertexList theke decide krbo kake diye start kra lagbe

    public Graph(int totalVertex) {
        this.totalVertex = totalVertex;
        this.vertexList = new LinkedList<>();
        this.VertexDegreeArray = new int[totalVertex];
//        SortVertexRespectToDegree(); //degree onujayi vertexList-->index no gula shajabo
    }

    public void addVertex(Course course){
        vertexList.add(course);
    }

    public void addEdge(int codeU,int codeV)
    {
        Course CourseU = null, CourseV = null;
        for (Course c: vertexList) {
            if (c.getCourseCode()==codeU){
                CourseU = c;
            }
            if (c.getCourseCode()==codeV){
                CourseV = c;
            }
        }
        if (CourseV != null && CourseU != null){
//            System.out.println("U:"+CourseU.getCourseCode());
//            System.out.println("V:"+CourseV.getCourseCode());
            CourseU.addCourses(CourseV);
            CourseV.addCourses(CourseU);
        }
    }

    public int getTotalVertex() {
        return totalVertex;
    }

    public List<Element> getDegreeSortedVertex() {
        return DegreeSortedVertex;
    }

    public void setTotalVertex(int totalVertex) {
        this.totalVertex = totalVertex;
    }

    public void printGraph(){
        System.out.println("-------EDGE------");
        for (Course c:
             vertexList) {
            System.out.print("Course "+c.getCourseCode()+": ");
            for (Course Neighbour:
                 c.getAdjList()) {
                System.out.print(Neighbour.getCourseCode()+" ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }

    public void countDegree(){
        int index = 0;
        for (Course vertex : vertexList) {
            VertexDegreeArray[index] = vertex.getAdjList().size(); //store the degree
//            System.out.println("Index:"+index+" Degree:"+VertexDegreeArray[index]);
            index++;
        }
    }

    public void SortVertexRespectToDegree(){
        countDegree();
        for (int i = 0; i < VertexDegreeArray.length; i++) {

            DegreeSortedVertex.add(new Element(i, VertexDegreeArray[i])); //indexOfVertexDegree, and Degree
        }
        Collections.sort(DegreeSortedVertex);
        Collections.reverse(DegreeSortedVertex);
//        for (Element element : DegreeSortedVertex) {
////            System.out.println(element.value + "--> " + element.index);
//        }
    }

}
