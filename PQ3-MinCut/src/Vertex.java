import java.util.ArrayList;

/**
 * User: Shamika
 * Date: 11/29/15
 * Time: 8:42 AM
 */
public class Vertex {
    private int id;
    private ArrayList<Vertex> neighbours;

    public Vertex(int id) {
        this.id = id;
        neighbours = new ArrayList<Vertex>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return adjacent vertices.
     * @return
     */
    public ArrayList<Vertex> getNeighbours() {
        return neighbours;
    }

    /**
     * Add adjacent vertices.
     * @param vertex
     */
    public void addNeighbour(Vertex vertex){
        neighbours.add(vertex);
    }
}
