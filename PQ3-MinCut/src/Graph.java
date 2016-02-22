import java.util.ArrayList;

/**
 * User: Shamika
 * Date: 11/29/15
 * Time: 8:47 AM
 */
public class Graph {
    private ArrayList<Vertex> vertices;

    public Graph() {
        vertices = new ArrayList<Vertex>();
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    /**
     * Add vertices to the graph.
     * @param vertex
     */
    public void addVertex(Vertex vertex){
       vertices.add(vertex);
    }

    /**
     * Return the vertex according to the given ID.
     * @param id
     * @return
     */
    public Vertex getVertexById(int id){
        for(Vertex v: vertices){
            if(v.getId() == id){
                return v;
            }
        }
        return  null;
    }
}
