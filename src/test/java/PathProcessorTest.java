import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PathProcessorTest {
    @Test
    public void proceedPathTest() {
        List<Edge> edges = initGraphEdges();
        List<Edge> groupEdges = initGroupEdges();


        //hided nodes
        List<Node> hidedNodes = new ArrayList<Node>();
        hidedNodes.add(new Node(1));
        hidedNodes.add(new Node(2));
        hidedNodes.add(new Node(3));
        hidedNodes.add(new Node(4));

        List<Edge> path = PathFinder.find(edges, hidedNodes).get(0);
        assertTrue(path.size() == 1);

        List<Action> actions = PathProcessor.process(groupEdges, edges, path);
        //delete 1, 2, create fake node instead
        //delete 3, 4, link fake node with 5
    }

    private List<Edge> initGroupEdges() {
        //groups
        Node group1 = new Node(100);
        Node group2 = new Node(200);
        Node group3 = new Node(300);
        //group edges
        List<Edge> groupEdges = new ArrayList<Edge>();
        groupEdges.add(new Edge(group1, new Node(1)));
        groupEdges.add(new Edge(group1, new Node(2)));
        groupEdges.add(new Edge(group1, new Node(8)));
        groupEdges.add(new Edge(group1, new Node(9)));

        groupEdges.add(new Edge(group2, new Node(3)));
        groupEdges.add(new Edge(group2, new Node(4)));
        groupEdges.add(new Edge(group2, new Node(5)));
        groupEdges.add(new Edge(group2, new Node(10)));
        groupEdges.add(new Edge(group2, new Node(11)));
        groupEdges.add(new Edge(group2, new Node(12)));

        groupEdges.add(new Edge(group3, new Node(6)));
        groupEdges.add(new Edge(group3, new Node(7)));
        groupEdges.add(new Edge(group3, new Node(13)));
        groupEdges.add(new Edge(group3, new Node(14)));
        return groupEdges;
    }

    private List<Edge> initGraphEdges() {
        List<Edge> edges = new ArrayList<Edge>();
        //first circuit
        edges.add(new Edge(new Node(1), new Node(2)));
        edges.add(new Edge(new Node(2), new Node(3)));
        edges.add(new Edge(new Node(3), new Node(4)));
        edges.add(new Edge(new Node(4), new Node(5)));
        edges.add(new Edge(new Node(5), new Node(6)));
        edges.add(new Edge(new Node(6), new Node(7)));
        //second circuit
        edges.add(new Edge(new Node(8), new Node(9)));
        edges.add(new Edge(new Node(9), new Node(10)));
        edges.add(new Edge(new Node(10), new Node(11)));
        edges.add(new Edge(new Node(11), new Node(12)));
        edges.add(new Edge(new Node(12), new Node(13)));
        edges.add(new Edge(new Node(13), new Node(14)));
        return edges;
    }
}
