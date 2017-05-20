public class Edge {
    private Node aNode;
    private Node zNode;

    public Edge(Node aNode, Node zNode) {
        this.aNode = aNode;
        this.zNode = zNode;
    }

    public Node getANode() {
        return aNode;
    }

    public Node getZNode() {
        return zNode;
    }

    public boolean contains(Node node) {
        return node.equals(aNode) || node.equals(zNode);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "aNode=" + aNode +
                ", zNode=" + zNode +
                '}';
    }
}
