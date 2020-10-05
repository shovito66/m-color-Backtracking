import java.util.List;

public class BackTrackingSearch {
    Graph graph;
    int color[];
    int mColor;
    List<Element> SortedDegree;

    public BackTrackingSearch(Graph graph,int mColor) {
        this.graph = graph;
//        this.color = color;
        this.mColor = mColor;
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
    boolean isSafe( int v, int c){
        for (int i = 0; i < graph.totalVertex; i++){
            if ( graph.Graph[v][i] == 1 && c == color[i]){
                return false;
            }
        }
        return true;
    }

    /* A recursive utility function to solve m coloring problem */
    boolean recursiveBackTracking(Element v)
    {
//        System.out.println("Got vertex:"+v.index);
//		/* base case: If all vertices are assigned a color then return true */
//        int myCounter;
//        for( myCounter =0; myCounter< graph.totalVertex; myCounter++){
//            if(color[myCounter]==0) //got at least one vertex that isn't colored yet
//                break;
//        }
//        System.out.println("Color ------------");
//        for (int myColor:color) {
//            System.out.print(myColor+" ");
//        }
//        System.out.println("\nColor ------------");
//        if(myCounter == graph.totalVertex){
//            System.out.println("all vertecies are colored");
//            return true;
//        }
//        System.out.println("IM here Vertex:"+ v.index);
//        if (v == graph.totalVertex)
//            return true;

		/* Consider this vertex v and try different colors */
        for (int c = 1; c <= getmColor(); c++) {
            /* Check if assignment of color c to v is fine*/
            if (isSafe(v.index, c)) {
                color[v.index] = c;

                int ElementIndex = SortedDegree.indexOf(v);
                System.out.println("Current vertex:"+v.index);

                /* base case: If all vertices are assigned a color then return true */
                int myCounter;
                for( myCounter =0; myCounter< graph.totalVertex; myCounter++){
                    if(color[myCounter]==0) //got at least one vertex that isn't colored yet
                        break;
                }
//                for (int myColor:color) {
//                    System.out.print(myColor+" ");
//                }
                if(myCounter == graph.totalVertex){
                    System.out.println("all vertecies are colored");
                    return true;
                }
//                if (ElementIndex+1 == graph.getTotalVertex()){
//                    //as all vertices explored , re initialised
//                    ElementIndex = 0;
//                }
                Element VertexElement = SortedDegree.get(ElementIndex+1);
                System.out.println("Next vertex:"+ VertexElement.index);
				/* recur to assign colors to rest of the vertices, v+1 */
                if (recursiveBackTracking(VertexElement))
                    return true;
				/* If assigning color c doesn't lead to a solution then remove it */
                color[v.index] = 0;
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

        Element VertexElement = SortedDegree.get(0);
        System.out.println("Starting Vertex/index:"+VertexElement.index);

        if ( !recursiveBackTracking(VertexElement)) {
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
            System.out.print(" " + color[i] + " ");
        System.out.println();
    }


}
