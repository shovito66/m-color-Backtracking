import java.util.List;

public class BackTrackingSearch {
    Graph graph;
    int color[];
    int mColor;
    List<Element> SortedDegree;

    public BackTrackingSearch(Graph graph, int mColor) {
        this.graph = graph;
//        this.color = color;
        this.mColor = mColor;
        this.graph.SortVertexRespectToDegree();
        this.SortedDegree = graph.getDegreeSortedVertex();

    }

    public Graph getGraph() {
        return graph;
    }

    public int[] getColor() {
        return color;
    }

    public int getmColor() {
        return mColor;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void setColor(int[] color) {
        this.color = color;
    }

    public void setmColor(int mColor) {
        this.mColor = mColor;
    }

    /* A utility function to check if the current color(c) assignment is safe for vertex-->v */
    boolean isSafe(Course v, int c){
        int indexV = graph.vertexList.indexOf(v); //vertexList e tar index ber krsi
        for (Course negihbourV: graph.vertexList.get(indexV).getAdjList()) {
            int i = graph.vertexList.indexOf(negihbourV);
            if (c == color[i]){
                return false;
            }
        }
        return true;
    }

    /* A recursive utility function to solve m coloring problem */
    boolean recursiveBackTracking(Course v)
    {
        /* Consider this vertex v and try different colors */
        for (int c = 1; c <= getmColor(); c++) {
            /* Check if assignment of color c to v is fine*/
            if (isSafe(v, c)) {
                color[graph.vertexList.indexOf(v)] = c;
                int ElementIndexInSortedDegree = -1;
                int indexOfVList = graph.vertexList.indexOf(v);
                for (Element x: SortedDegree) {
                    if(x.index==indexOfVList)
                        ElementIndexInSortedDegree = SortedDegree.indexOf(x);
                }

//                System.out.println("Current vertex:"+v.getCourseCode());

                /* base case: If all vertices are assigned a color then return true */
                int myCounter;
                for( myCounter =0; myCounter< graph.totalVertex; myCounter++){
                    if(color[myCounter]==0) //got at least one vertex that isn't colored yet
                        break;
                }

                if(myCounter == graph.totalVertex){
                    System.out.println("all vertecies are colored");
                    return true;
                }

//                System.out.println("Current Index---> "+ ElementIndexInSortedDegree);
                int NextVertexIndexInVertexList = SortedDegree.get(ElementIndexInSortedDegree+1).index;
//                System.out.println("Next Index---> "+NextVertexIndexInVertexList);
                Course NextVertex = graph.vertexList.get(NextVertexIndexInVertexList);
//                System.out.println("Next vertex:"+ NextVertex.getCourseCode());
                /* recur to assign colors to rest of the vertices, v+1 */
                if (recursiveBackTracking(NextVertex))
                    return true;
                /* If assigning color c doesn't lead to a solution then remove it */
                color[graph.vertexList.indexOf(v)] = 0;
            }
        }

        /* If no color can be assigned to this vertex then return false */
        return false;
    }

    /* This function solves the m Coloring problem using
    Backtracking. It mainly uses recursiveBackTracking()
    to solve the problem. It returns false if the m
    colors cannot be assigned, otherwise return true
    and prints assignments of colors to all vertices.
    Please note that there may be more than one
    solutions, this function prints one of the
    feasible solutions.*/
    boolean graphColoring()
    {
        // Initialize all color values as 0. This initialization is needed correct
        // functioning of isSafe()
        int VertexNo = graph.getTotalVertex();
        color = new int[VertexNo]; //V
        for (int i = 0; i < VertexNo; i++)
            color[i] = 0;

        // Call recursiveBackTracking() for the vertex that has the largest degree

        int startIndexOfVertexList = SortedDegree.get(0).index;
        Course startVertex = graph.vertexList.get(startIndexOfVertexList);
        System.out.println("Starting Vertex/index:"+startVertex.getCourseCode());

        if ( !recursiveBackTracking(startVertex)) {
            System.out.println("Solution does not exist");
            return false;
        }

        // Print the solution
        printSolution();
        return true;
    }

    /* A utility function to print solution */
    void printSolution()
    {
        System.out.println( "Solution Exists: Following" + " are the assigned colors");

        for (int i = 0; i < graph.getTotalVertex(); i++)
            System.out.print(" " + graph.vertexList.get(i) .getCourseCode()+ " ");
        System.out.println("-----------------------------");

        for (int i = 0; i < graph.getTotalVertex(); i++)
            System.out.print(" " + color[i] + " ");

        System.out.println();
    }
}



