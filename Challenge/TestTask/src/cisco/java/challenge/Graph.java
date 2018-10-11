package cisco.java.challenge;

import java.util.ArrayList;

public class Graph {
    Node root = null;
    int count;
    ArrayList<Node> nodeList;

    public Graph() {
        nodeList = new ArrayList<>(count);
    }

    public Node getByName(String name) {
        Node temp = new Node(name);
        if (nodeList.contains(temp)) {
            return nodeList.get(nodeList.indexOf(temp));
        } else return null;
    }

    public void addNode(String name, GNode prev) {
        Node elem;
        Node prElem;
        int ind;
        if (prev == null) {
            elem = new Node(name);
            if (!nodeList.contains(elem)) {
                root = elem;
                nodeList.add(elem);
                count++;
            }
        } else {
            if (nodeList.contains(prev)) {
                ind = nodeList.indexOf(prev);
                prElem = nodeList.get(ind);
                elem = new Node(name, prElem);
                if (!nodeList.contains(elem)) {
                    nodeList.add(elem);
                    count++;
                }
            }
        }
    }


    private void findPath(ArrayList<Node> nodes, Node node, ArrayList<ArrayList<Node>> commonNodes) {
        boolean flag = false;
        ArrayList<Node> newNodes = new ArrayList<>(nodes);
        for (Node n : nodeList) {
            if (node.equals(n.prev)) {
                newNodes = new ArrayList<>(nodes);
                if (n.name == "E")
                    flag = false;
                newNodes.add(n);
                flag = true;
                findPath(newNodes, n, commonNodes);
            }
        }
        if (!flag) {
            commonNodes.add(newNodes);
        }
    }


    public ArrayList paths(GNode node) {
        ArrayList<ArrayList<Node>> commonNodes = new ArrayList<>();
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add((Node) node);
        findPath(nodes, (Node) node, commonNodes);
        return commonNodes;
    }


    private class Node implements GNode {
        private String name;
        private Node prev;

        Node(String name) {
            this.name = name;
            this.prev = null;
        }

        Node(String name, GNode prev) {
            this.name = name;
            this.prev = (Node) prev;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public GNode[] getChildren() {
            if (count == 0)
                return new GNode[0];
            else {

                int i = 0;
                for (Node n : nodeList) {
                    if (this.equals(n.prev))
                        i++;
                }

                GNode[] mas = new Node[i];
                i = 0;
                for (Node n : nodeList) {
                    if (this.equals(n.prev)) {
                        mas[i] = n;
                        i++;
                    }
                }
                return mas;
            }
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }
            Node guest = (Node) obj;
            if (guest.name.equals(this.name))
                return true;
            return false;
        }


        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + name.hashCode();
            return result;
        }

    }

    public ArrayList walkGraph() {
        return nodeList;
    }
}

