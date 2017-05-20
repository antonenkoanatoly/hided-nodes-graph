public class Node {
    private int node;

    public Node(int node) {
        this.node = node;
    }

    public int getNode() {
        return node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return this.node == node.node;

    }

    @Override
    public int hashCode() {
        return node;
    }

    @Override
    public String toString() {
        return "Node{" +
                "node=" + node +
                '}';
    }
}
