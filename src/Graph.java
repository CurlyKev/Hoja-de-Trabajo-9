import java.util.*;

public class Graph {

    private Map<String, Map<String, Integer>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public void addNode(String city) {
        graph.putIfAbsent(city, new HashMap<>());
    }

    public void addEdge(String from, String to, int distance) {
        addNode(from);
        addNode(to);
        graph.get(from).put(to, distance);
    }

    public void removeEdge(String from, String to) {
        if (graph.containsKey(from)) {
            graph.get(from).remove(to);
        }
    }

    public Map<String, Map<String, Integer>> getGraph() {
        return graph;
    }

    public Set<String> getNodes() {
        return graph.keySet();
    }

    public void printGraph() {
        for (String from : graph.keySet()) {
            for (String to : graph.get(from).keySet()) {
                System.out.println(from + " -> " + to +
                        " : " + graph.get(from).get(to) + " KM");
            }
        }
    }
}