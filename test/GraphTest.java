import static org.junit.Assert.*;
import org.junit.Test;

public class GraphTest {

    @Test
    public void testAddEdge() {

        Graph graph = new Graph();

        graph.addEdge("Guatemala", "Antigua", 40);

        assertTrue(
                graph.getGraph()
                        .get("Guatemala")
                        .containsKey("Antigua")
        );
    }

    @Test
    public void testRemoveEdge() {

        Graph graph = new Graph();

        graph.addEdge("A", "B", 10);
        graph.removeEdge("A", "B");

        assertFalse(
                graph.getGraph()
                        .get("A")
                        .containsKey("B")
        );
    }

    @Test
    public void testFloyd() {

        Graph graph = new Graph();

        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 3);
        graph.addEdge("A", "C", 20);

        FloydWarshall fw = new FloydWarshall(graph);

        assertEquals(8, fw.getDistance("A", "C"));
    }
}
