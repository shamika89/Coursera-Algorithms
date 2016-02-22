import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * User: Hp
 * Date: 11/22/15
 * Time: 5:44 PM
 */
public class Graph {
    private HashMap<Integer, Vertex> vertices;

    public Graph() {
        vertices = new HashMap<Integer, Vertex>();
    }

    /**
     * Add vertex to the graph
     * @param i
     * @param v
     */
    public void addVertex(Integer i,Vertex v){
        vertices.put(i,v);
    }

    public HashMap<Integer, Vertex> getVertices(){
        return  vertices;
    }

    /**
     * Return the vertex with given ID
     * @param i
     * @return
     */
    public Vertex getVertex(int i){
        return vertices.get(i);
    }
}
