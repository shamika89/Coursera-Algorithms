import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * User: Hp
 * Date: 11/22/15
 * Time: 5:10 PM
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Graph g= new Graph();
        for(int i=1; i<=200; i++){
            Vertex v= new Vertex(i);
            g.addVertex(i, v);
        }

        BufferedReader br = new BufferedReader(new FileReader("input/dijkstraData.txt"));
        String currentLine;
        String[] temp;
        while ((currentLine = br.readLine())!= null){
            temp = currentLine.split("\\t");
            Vertex source = g.getVertex(Integer.parseInt(temp[0]));
            String[] temp2;
            Vertex u;
            for(int i=1; i<temp.length; i++){
                temp2 = temp[i].split(",");
                u =  g.getVertex(Integer.parseInt(temp2[0]));
                source.insetNeighbours(u,Integer.parseInt(temp2[1]));
            }
        }

        Dijkstra d =new Dijkstra();
        d.DijkstraAlgo(g,g.getVertex(1));

        for(Vertex v : g.getVertices().values()){
            if(v.getId() == 7 || v.getId() == 37 || v.getId()== 59 || v.getId() == 82 || v.getId() == 99
             || v.getId() == 115 || v.getId() == 133 || v.getId()== 165 || v.getId() == 188 || v.getId() == 197)
            System.out.println(v.getId() + " " +v.getDistance());
        }
    }
}
