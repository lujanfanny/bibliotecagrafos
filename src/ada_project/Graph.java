/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada_project;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author fanny
 */

public class Graph {

    
    private HashMap <Integer, Node> nodes = new HashMap<>();
    private HashMap <Integer, Edge> edges = new HashMap<>();
    boolean directed = false;
    public int m,n;
    private boolean b;
    private boolean [][] AdjMatrix;

    public Graph(boolean directed, int n, int m) {
        this.directed = directed;
        this.m = m;
        this.n = n;
    }

    public Graph(int n, int m) {
        this.m = m;
        this.n = n;
        
    }
    
    
    public Graph(HashMap <Integer, Node> nodes, HashMap<Integer, Edge> edges){
        this.nodes = nodes;
    this.edges = edges;
    this.n = nodes.size();
    this.m = edges.size();
    }

    Graph(boolean b, int n, HashMap<Integer, Node> nodes, HashMap<Integer, Edge> edges) {
         this.b = false;
         this.n = n;
         this.m = edges.size();
         this.nodes = nodes;
         this.edges = edges;
    }


  
   

    public HashMap<Integer, Node> getNodes() {
        return nodes;
    }

    public void setNodes(HashMap<Integer, Node> nodes) {
        this.nodes = nodes;
    }

    public HashMap<Integer, Edge> getEdges() {
        return edges;
    }

    public void setEdges(HashMap<Integer, Edge> edges) {
        this.edges = edges;
    }
    
      public int getN() {
        return n;
      }

    boolean[][] getAdjMatrix() {
        return AdjMatrix;
    }

    
    
    
    

   
}
    