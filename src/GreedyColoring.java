import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GreedyColoring {
    Graph graph;
    int color[];
    boolean available[];

    public GreedyColoring(Graph graph) {
        this.graph = graph;
        this.color = new int[graph.getTotalVertex()];
        this.available = new boolean[graph.getTotalVertex()];
        Arrays.fill(color,-1); //in the beginning colors are unassigned for all verticies

        Arrays.fill(available,true); // all color are available in the beginning
    }

    public void greedyAlgo(){
        int totalVertex = graph.getTotalVertex();

        color[0]=0; //assigning 1st color in the beginning
        //assign colors to remaining v-1 vertex, starting from 1 not 0
        for(int u=1; u<totalVertex; u++){
//            System.out.println("Curr Vertex-->"+graph.vertexList.get(u).getCourseCode());
            LinkedList<Course> neighboursList = graph.vertexList.get(u).getAdjList();
            for (Course neighbour:neighboursList) {
//                System.out.println("\nNeighbour:"+neighbour.getCourseCode());
                int NeighbourIndexInVertexList = graph.vertexList.indexOf(neighbour);
//                System.out.println("index of neighbour: "+NeighbourIndexInVertexList);
//                System.out.println("Neighbour Color:"+color[NeighbourIndexInVertexList]+"\n");
                //neighbours who are already colored, making them unavailble
                if(color[NeighbourIndexInVertexList] != -1){
                    available[color[NeighbourIndexInVertexList]] = false;
                }
            }
            //find the first available color
            int colorNo;
            for (colorNo = 0; colorNo < totalVertex; colorNo++){
                if (available[colorNo])
                    break;
            }
            //assign the first available color
            color[u] = colorNo;
//            System.out.println("Assigned Color: "+colorNo+" TO-->"+ graph.vertexList.get(u).getCourseCode());

            //reset values true for next iteration
            Arrays.fill(available,true);
        }
    }

    public void printSolution(){
        System.out.println( "Solution Exists: Following" + " are the assigned colors");

        for (int i = 0; i < graph.getTotalVertex(); i++)
            System.out.print(" " + graph.vertexList.get(i) .getCourseCode()+ " ");
        System.out.println("-----------------------------");

        for (int i = 0; i < graph.getTotalVertex(); i++)
            System.out.print(" " + color[i] + " ");

        System.out.println();
    }

    public void graphColoring(){
        greedyAlgo();
        printSolution();
    }
}
