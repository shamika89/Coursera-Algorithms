import java.util.*;

/**
 * User: Hp
 * Date: 11/22/15
 * Time: 5:41 PM
 */

/**
 *  This includes the implementation of Dijkstra's Algorithm
 */
public class Dijkstra {

    /**
     * @param g - Graph
     * @param s - Source Vertex
     */
    public void  DijkstraAlgo(Graph g, Vertex s){
        s.setDistance(0);
        ArrayList<Vertex> finishedVertices = new ArrayList<Vertex>();
        ArrayList<Vertex> nonFinishedVertices = new ArrayList<Vertex>();

        for(Vertex v: g.getVertices().values()){
            nonFinishedVertices.add(v);
        }
        Vertex u;
        while (!nonFinishedVertices.isEmpty()) {
            Collections.sort(nonFinishedVertices);
            // Retrieve the vertex with minimum distance
            u = nonFinishedVertices.remove(0);
            finishedVertices.add(u);
            int weight;
            // Relaxing adjacent edges
            for(Vertex v : u.getNeighbours().keySet()){
                 if(!finishedVertices.contains(v)){
                     weight = u.getNeighbours().get(v);
                     relax(u,v,weight);
                 }
            }
        }
    }

    /**
     * Relax an edge
     * @param u
     * @param v
     * @param weight
     */
    public void relax(Vertex u, Vertex v, int weight){
         if(v.getDistance() > u.getDistance() + weight){
             v.setDistance(u.getDistance() + weight);
             v.setPredecessor(u);
         }
    }
}
