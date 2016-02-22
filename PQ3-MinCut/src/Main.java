import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * User: Shamika
 * Date: 11/29/15
 * Time: 8:52 AM
 */


/**
 * The purpose of this class is reading the input file and creating the graph.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
        for(int i=1;  i<= 200; i++){
             Vertex v = new Vertex(i);
             graph.addVertex(v);
        }

        BufferedReader br = new BufferedReader(new FileReader("input/kargerMinCut.txt"));
        String currentLine;
        String[] temp;
        Vertex source;
        while ((currentLine = br.readLine())!= null){
             temp = currentLine.split("\\t");
             source = graph.getVertexById(Integer.parseInt(temp[0]));
             Vertex neighbourVertex;
             for(int i =1; i<temp.length; i++){
                 neighbourVertex = graph.getVertexById(Integer.parseInt(temp[i]));
                 source.addNeighbour(neighbourVertex);
             }
        }

        MinCut minCut = new MinCut();
        minCut.countMinCut(graph);
    }

}
