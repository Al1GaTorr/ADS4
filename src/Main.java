import java.util.List;

public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>();
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Vertex<String> startW = new Vertex<>("Almaty");
        Vertex<String> endW = new Vertex<>("Kyzylorda");
        Search<String> djk = new DijkstraSearch<>(weightedGraph);
        List<Vertex<String>> dijkstraPath = djk.search(startW, endW);
        outputPath(dijkstraPath);

        System.out.println("--------------------------------");

        UnweightedGraph<String> unweightedGraph = new UnweightedGraph<>();
        fillWithoutWeights(unweightedGraph);


        System.out.println("--------------------------------");

        System.out.println("BFS:");
        Vertex<String> startU = new Vertex<>("Almaty");
        Vertex<String> endU = new Vertex<>("Kyzylorda");
        Search<String> bfs = new BreadthFirstSearch<>(weightedGraph);
        List<Vertex<String>> bfsPath = bfs.search(  startU, endU);
        outputPath(bfsPath);
    }

    public static void fillWithoutWeights(UnweightedGraph<String> graph) {
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Astana"));
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Atyrau"));
        graph.addEdge(new Vertex<>("Atyrau"), new Vertex<>("Astana"));
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Shymkent"));
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Astana"));
        graph.addEdge(new Vertex<>("Astana"), new Vertex<>("Kostanay"));
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Kyzylorda"));
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Astana"), 2.1);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Atyrau"), 7.8);
        graph.addEdge(new Vertex<>("Atyrau"), new Vertex<>("Astana"), 7.1);
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Shymkent"), 7.2);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Astana"), 3.9);
        graph.addEdge(new Vertex<>("Astana"), new Vertex<>("Kostanay"), 3.5);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Kyzylorda"), 5.4);
    }

    public static void outputPath(List<Vertex<String>> path) {
        if (path == null || path.isEmpty()) {
            System.out.println("Путь не найден");
            return;
        }
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i).getData());
            if (i != path.size() - 1) System.out.print(" -> ");
        }
        System.out.println();
    }
}