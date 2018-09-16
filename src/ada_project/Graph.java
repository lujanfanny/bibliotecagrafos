/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada_project;

import java.util.HashMap;

/**
 *
 * @author fanny
 */
public class Graph {
    HashMap <Integer, Node> nodes = new HashMap<>();
    HashMap <String, Edge> edges = new HashMap<>();
    boolean directed = false;
    public int m,n;

    public Graph(boolean directed, int n, int m) {
        this.directed = directed;
        this.m = m;
        this.n = n;
    }

    public Graph(int n, int m) {
        this.m = m;
        this.n = n;
        
    }

    public HashMap<Integer, Node> getNodes() {
        return nodes;
    }

    public void setNodes(HashMap<Integer, Node> nodes) {
        this.nodes = nodes;
    }

    public HashMap<String, Edge> getEdges() {
        return edges;
    }

    public void setEdges(HashMap<String, Edge> edges) {
        this.edges = edges;
    }
    
    

    
    
}
