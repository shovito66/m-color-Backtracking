import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("yor-f-83.crs");
//        File file = new File("course.txt");
        int count = 0;
        Scanner sc = null;
        sc = new Scanner(file);

        List<Course> vertex = new ArrayList<>();
        Graph g;

        String st;
        while (sc.hasNextLine()){
            st = sc.nextLine();
//            System.out.println(st);
            String[] arrOfStr = st.split(" ");
//            System.out.println(arrOfStr[0]+" "+arrOfStr[1]);
            Course course = new Course(Integer.parseInt(arrOfStr[0]),Integer.parseInt(arrOfStr[1]));
            vertex.add(course);
            count++;
        }

        g = new Graph(count);
        for(Course c: vertex){
            g.addVertex(c);

        }
//        System.out.println(count);

        File file1 = new File("yor-f-83.stu");
//        File file1 = new File("student.txt");
        sc = new Scanner(file1);
        while (sc.hasNextLine()){
            st = sc.nextLine();
            String[] arrOfStr = st.split(" ");
//            System.out.println(arrOfStr[0]+" "+arrOfStr[1]);
            for(int i=0;i<arrOfStr.length-1;i++){
                for(int j=i+1;j<arrOfStr.length;j++){
                    g.addEdge(Integer.parseInt(arrOfStr[i]),Integer.parseInt(arrOfStr[j]));
                }
            }
        }
//        g.printGraph();
        int mColor = 30;
//        BackTrackingSearch graphColoring = new BackTrackingSearch(g,mColor);
        GreedyColoring graphColoring = new GreedyColoring(g);
        graphColoring.graphColoring();
    }
}
