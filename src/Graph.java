/**
 *
 */
public class Graph {
    int totalVertex;
    int Graph[][];


    public Graph(int totalVertex, int[][] Graph) {
        this.totalVertex = totalVertex;
        this.Graph = Graph;
    }

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


}



