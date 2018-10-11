package cisco.java.challenge;

import java.util.ArrayList;

public class DemoGNode {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A", null);
        GNode gnA = graph.getByName("A");
        graph.addNode("B", gnA);
        graph.addNode("C", gnA);
        graph.addNode("D", gnA);
        GNode gnB = graph.getByName("B");
        graph.addNode("E", gnB);
        graph.addNode("F", gnB);
        GNode gnC = graph.getByName("C");
        graph.addNode("G", gnC);
        graph.addNode("H", gnC);
        graph.addNode("I", gnC);
        System.out.println("WalkGraph:");
        ArrayList nodeArray = graph.walkGraph();
        for (Object g : nodeArray) {
            System.out.print(g+" ");
        }
        System.out.println();
        System.out.println("paths:");
        System.out.print("paths(" + gnA.getName() + ") = (");
        ArrayList arrayList = graph.paths(gnA);
        for (Object o : arrayList) {
            System.out.print(o + " ");
        }
        System.out.println(")");
        System.out.println("Childrens of B:");
        GNode[] childrens = gnB.getChildren();
        for (GNode ch : childrens)
            System.out.print(ch.getName() + " ");
    }
}
