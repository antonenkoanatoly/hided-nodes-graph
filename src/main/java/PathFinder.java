import java.util.ArrayList;
import java.util.List;

public class PathFinder {
    public static List<List<Edge>> find(List<Edge> graph, List<Node> hidedNodes) {
        List<List<Edge>> paths = new ArrayList<List<Edge>>();
//        For each node in hidedNodes:
//        1. Get node
//        1.1 If node already in path from paths, then get next node
//        2. Find edge where node is aNode
//        2.1 If edge zNode is from hidedNodes, then add edge to path.
//        2.2 Go to 2. with node = zNode
        for (Node node: hidedNodes) {
            if (isInPath(node, paths)) continue;
            List<Edge> path = new ArrayList<Edge>();

            proceedNode(node, path, graph, hidedNodes);

            if (!path.isEmpty()) {
                paths.add(path);
            }
        }
        return paths;
    }

    private static void proceedNode(Node node, List<Edge> path, List<Edge> graph, List<Node> hidedNodes) {
        Edge edge = findEdgeByANode(node, graph);
        if (edge == null) return;
        if (hidedNodes.contains(edge.getZNode())) {
            path.add(edge);
            proceedNode(edge.getZNode(), path, graph, hidedNodes);
        }
    }

    private static Edge findEdgeByANode(Node node, List<Edge> graph) {
        for (Edge edge: graph) {
            if (edge.getANode().equals(node)) {
                return edge;
            }
        }
        return null;
    }

    private static boolean isInPath(Node node, List<List<Edge>> paths) {
        for(List<Edge> path: paths) {
            for(Edge edge: path) {
                if (edge.contains(node)) {
                    return true;
                }
            }
        }
        return false;
    }
}
