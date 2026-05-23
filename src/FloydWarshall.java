import java.util.*;

public class FloydWarshall {

    private static final int INF = 999999;

    private Map<String, Integer> indexMap;
    private String[] cities;
    private int[][] dist;
    private String[][] next;

    public FloydWarshall(Graph graph) {

        int n = graph.getNodes().size();

        indexMap = new HashMap<>();
        cities = new String[n];

        int idx = 0;
        for (String city : graph.getNodes()) {
            indexMap.put(city, idx);
            cities[idx] = city;
            idx++;
        }

        dist = new int[n][n];
        next = new String[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (String from : graph.getGraph().keySet()) {
            for (String to : graph.getGraph().get(from).keySet()) {

                int i = indexMap.get(from);
                int j = indexMap.get(to);

                dist[i][j] = graph.getGraph().get(from).get(to);
                next[i][j] = to;
            }
        }

        floyd(n);
    }

    private void floyd(int n) {

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (dist[i][k] + dist[k][j] < dist[i][j]) {

                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }

    public int getDistance(String from, String to) {

        int i = indexMap.get(from);
        int j = indexMap.get(to);

        return dist[i][j];
    }

    public List<String> getPath(String from, String to) {

        List<String> path = new ArrayList<>();

        int i = indexMap.get(from);
        int j = indexMap.get(to);

        if (next[i][j] == null)
            return path;

        path.add(from);

        while (!from.equals(to)) {
            from = next[indexMap.get(from)][j];
            path.add(from);
        }

        return path;
    }

    public int[][] getDistMatrix() {
        return dist;
    }

    public String[] getCities() {
        return cities;
    }
}