import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
            throws FileNotFoundException {

        Graph graph = FileReaderGraph.loadGraph("guategrafo.txt");

        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {

            FloydWarshall fw = new FloydWarshall(graph);

            System.out.println("\n===== MENU =====");
            System.out.println("1. Ruta más corta");
            System.out.println("2. Centro del grafo");
            System.out.println("3. Modificar grafo");
            System.out.println("4. Mostrar grafo");
            System.out.println("5. Salir");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:

                    System.out.print("Ciudad origen: ");
                    String from = sc.nextLine();

                    System.out.print("Ciudad destino: ");
                    String to = sc.nextLine();

                    int distance = fw.getDistance(from, to);

                    if (distance >= 999999) {
                        System.out.println("No existe ruta.");
                    } else {

                        List<String> path = fw.getPath(from, to);

                        System.out.println("Distancia: " + distance + " KM");
                        System.out.println("Ruta: " + path);
                    }

                    break;

                case 2:

                    String center = GraphCenter.getCenter(fw);

                    System.out.println("Centro del grafo: " + center);

                    break;

                case 3:

                    System.out.println("1. Eliminar conexión");
                    System.out.println("2. Agregar conexión");

                    int mod = sc.nextInt();
                    sc.nextLine();

                    if (mod == 1) {

                        System.out.print("Ciudad origen: ");
                        String o = sc.nextLine();

                        System.out.print("Ciudad destino: ");
                        String d = sc.nextLine();

                        graph.removeEdge(o, d);

                        System.out.println("Conexión eliminada.");

                    } else {

                        System.out.print("Origen: ");
                        String o = sc.nextLine();

                        System.out.print("Destino: ");
                        String d = sc.nextLine();

                        System.out.print("Distancia: ");
                        int km = sc.nextInt();

                        graph.addEdge(o, d, km);

                        System.out.println("Conexión agregada.");
                    }

                    break;

                case 4:

                    graph.printGraph();
                    break;

                case 5:

                    running = false;
                    break;
            }
        }

        sc.close();
    }
}
