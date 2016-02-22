import java.util.Comparator;
import java.util.HashMap;

/**
 * User: Hp
 * Date: 11/22/15
 * Time: 5:26 PM
 */
public class Vertex implements  Comparable<Vertex>{
    private  int id;
    private int distance;
    private  Vertex predecessor;
    private HashMap<Vertex, Integer> neighbours;

    public Vertex(int id) {
        this.id = id;
        distance = 1000000;
        predecessor = null;
        neighbours = new HashMap<Vertex, Integer>();
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public void insetNeighbours(Vertex v, Integer i){
        neighbours.put(v,i);
    }

    public HashMap<Vertex, Integer> getNeighbours() {
        return neighbours;
    }

    public int getId() {
        return id;
    }

    public int compareTo(Vertex o) {
        return this.getDistance() - o.getDistance();
    }

}
