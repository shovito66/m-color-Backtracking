public class BackTrackingSearch {
    Graph graph;
    int color[];
    int mColor;

    public BackTrackingSearch(Graph graph,int mColor) {
        this.graph = graph;
//        this.color = color;
        this.mColor = mColor;
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
    boolean recursiveBackTracking(int v)
    {
		/* base case: If all vertices are assigned a color then return true */
        if (v == graph.totalVertex)
            return true;

		/* Consider this vertex v and try different colors */
        for (int c = 1; c <= getmColor(); c++) {
			/* Check if assignment of color c to v is fine*/
            if (isSafe(v, c)) {
                color[v] = c;

				/* recur to assign colors to rest of the vertices */
                if (recursiveBackTracking(v + 1))
                    return true;

				/* If assigning color c doesn't lead to a solution then remove it */
                color[v] = 0;
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

        // Call recursiveBackTracking() for vertex 0
        if ( !recursiveBackTracking(0)) {
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
