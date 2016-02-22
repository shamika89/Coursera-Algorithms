import java.util.Iterator;
import java.util.Random;

/**
 * User: Shamika
 * Date: 11/29/15
 * Time: 8:52 AM
 */
public class MinCut {
    /**
     *  This includes the implementation of MinCut algorithm
     *
     * @param graph
     */
    public void countMinCut(Graph graph) {
        Random random = new Random();
        int randomVertexIndex, randomNeighbourIndex;
        Vertex randomVertex, randomNeighbourVertex;

        while (graph.getVertices().size() > 2) {
            /**
             *  Randomly generate two vertices adjacent to each other.
             */
            randomVertexIndex = random.nextInt(graph.getVertices().size());
            randomVertex = graph.getVertices().get(randomVertexIndex);
            randomNeighbourIndex = random.nextInt(randomVertex.getNeighbours().size());
            randomNeighbourVertex = randomVertex.getNeighbours().get(randomNeighbourIndex);

            if (randomVertex.getId() == randomNeighbourVertex.getId()) {
                continue;
            } else {
                // Merge two adjacent vertices.
                for (Vertex v : randomNeighbourVertex.getNeighbours()) {
                    randomVertex.addNeighbour(v);
                }

                // Removing self loops from random vertex.
                Iterator<Vertex> iterator = randomVertex.getNeighbours().iterator();
                Vertex v1;
                while (iterator.hasNext()) {
                    v1 = iterator.next();
                    if (v1.getId() == randomVertex.getId() || v1.getId() == randomNeighbourVertex.getId()) {
                        iterator.remove();
                    }
                }

                // Remove random neighbor vertex from the graph.
                graph.getVertices().remove(randomNeighbourVertex);

                // Replace references to the random neighbour vertex with random vertex.
                iterator = graph.getVertices().iterator();  // Iterator to loop through vertex list
                Vertex v2;
                Iterator<Vertex> iterator1; // Iterator to loop through adjacent list of each vertex
                while (iterator.hasNext()) {
                    boolean removed = false;
                    v2 = iterator.next();
                    iterator1 = v2.getNeighbours().iterator();
                    Vertex v3;
                    int cnt = 0;
                    while (iterator1.hasNext()) {
                        v3 = iterator1.next();
                        if (v3.getId() == randomNeighbourVertex.getId()) {
                            iterator1.remove();
                            removed = true;
                            cnt++;
                        }
                    }
                    /**
                     * If random neighbor vertex is removed add random vertex to the particular list
                     */
                    if (removed) {
                        while (cnt > 0) {
                            v2.addNeighbour(randomVertex);
                            cnt--;
                        }
                    }
                }
            }
        }

        for (Vertex v : graph.getVertices()) {
            System.out.println("ID = " + v.getId() + " " + "Number of neighbours " + v.getNeighbours().size());
        }

    }
}
