import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PathFinderTest {
    @Test
    public void testFind() {
        List<Edge> graph = new ArrayList<Edge>();

        graph.add(new Edge(new Node(1), new Node(3)));
        graph.add(new Edge(new Node(3), new Node(4)));
        graph.add(new Edge(new Node(4), new Node(7)));
        graph.add(new Edge(new Node(2), new Node(5)));
        graph.add(new Edge(new Node(5), new Node(6)));
        graph.add(new Edge(new Node(6), new Node(8)));

        List<Node> hidedNodes = new ArrayList<Node>();
        hidedNodes.add(new Node(1));
        hidedNodes.add(new Node(3));
        hidedNodes.add(new Node(4));
        hidedNodes.add(new Node(6));
        hidedNodes.add(new Node(8));

        List<List<Edge>> paths = PathFinder.find(graph, hidedNodes);
        System.out.println(paths);
        assertTrue(paths.size() == 2);
    }
}
