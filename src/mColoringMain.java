public class mColoringMain {
    public static void main(String[] args) {
        int totalVertex = 6;
        int mColor = 20; //#of max color
//        int graphArray[][] = {
//                { 0, 1, 1, 1 },
//                { 1, 0, 1, 0 },
//                { 1, 1, 0, 1 },
//                { 1, 0, 1, 0 },
//        };
        int graphArray[][] = {
                { 0, 1, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 0 },
                { 1, 1, 0, 1, 1, 0 },
                { 0, 1, 1, 0, 1, 0 },
                { 0, 1, 1, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 0 },
        };
        Graph graph = new Graph(totalVertex,graphArray);
        BackTrackingSearch graphColoring = new BackTrackingSearch(graph,mColor);
        graphColoring.graphColoring();
    }
}
