import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class Graph {
    int totalVertex;
    int Graph[][];
    int VertexDegreeArray []; //degrees of all the vertices
    List<Element> DegreeSortedVertex = new ArrayList<Element>(); //vertex gula degree onujayoi sorted


    public Graph(int totalVertex, int[][] Graph) {
        this.totalVertex = totalVertex;
        this.Graph = Graph;
        this.VertexDegreeArray = new int [totalVertex];
        //ekhane degree onujayi vertex no gula shajabo
        SortVertexRespectToDegree();
    }

    public void countDegree(){
        int count = 0;
        for (int i=0; i < totalVertex; i++){
            for (int j=0; j < totalVertex; j++){
                if(Graph[i][j]==1){
                    count++;
                }
            }
            VertexDegreeArray[i] = count;
            count = 0;
        }
    }

    public void SortVertexRespectToDegree(){
        //ekhane degree onujayi vertex no gula shajabo
        countDegree();
        for (int i = 0; i < VertexDegreeArray.length; i++) {
            DegreeSortedVertex.add(new Element(i, VertexDegreeArray[i]));
        }
        Collections.sort(DegreeSortedVertex);
        Collections.reverse(DegreeSortedVertex);
        for (Element element : DegreeSortedVertex) {
            System.out.println(element.value + " " + element.index);
        }
    }

    //---------Setter-Getter---------
    public void setGraph(int[][] Graph) {
        this.Graph = Graph;
    }

    public int[][] getGraph() {
        return Graph;
    }

    public int getTotalVertex() {
        return totalVertex;
    }

    public void setTotalVertex(int totalVertex) {
        this.totalVertex = totalVertex;
    }

    public int[] getVertexDegreeArray() {
        return VertexDegreeArray;
    }

    public List<Element> getDegreeSortedVertex() {
        return DegreeSortedVertex;
    }
}



