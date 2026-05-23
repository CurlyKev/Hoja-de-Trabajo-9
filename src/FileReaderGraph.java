import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderGraph {

    public static Graph loadGraph(String filename)
            throws FileNotFoundException {

        Graph graph = new Graph();

        Scanner scanner = new Scanner(new File(filename));

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine().trim();

            if (line.isEmpty())
                continue;

            String[] parts = line.split(" ");

            String city1 = parts[0];
            String city2 = parts[1];
            int distance = Integer.parseInt(parts[2]);

            graph.addEdge(city1, city2, distance);
        }

        scanner.close();

        return graph;
    }
}
