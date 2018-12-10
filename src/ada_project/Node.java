/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada_project;

import java.util.ArrayList;
import java.util.List;
import sun.security.provider.certpath.Vertex;

/**
 *
 * @author fanny
 */
public class Node implements Comparable<Node> {

    public static void setNode(Vertex v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int degree;
   
    double x,y;
    public int ivalue;
    public int ikey;
    public boolean visited = false;
    public double distance = Double.POSITIVE_INFINITY;
    public String n_name;
    public String color;
    public String n_key;
    public String label = "";
    public boolean discovered = false;
    
 private String name;
 private List<Edge> adjacenciesList;
 private boolean visit;
 private Node ancestor;
 private double Distance = Double.MAX_VALUE;
    private boolean vertex;
 
 public Node(String Name){
     this.name= name;
     this.adjacenciesList = new ArrayList<>();
 }
void addVecino(Edge edge) {
    this.getAdjacenciesList().add(edge);
}
 public String ToString(){
    return this.name;
    
    }
 
    @Override
    public String toString(){
return  this.getName();
}

 
public void setName(String name) {
        this.name = name;
}
    public Node(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    
    public String getn_name() {
        return n_name;
}
    public int retDegree() {
        return degree;
}
       public int getivalue() {
        return ivalue;
    }  
       
        public int getIkey() {
        return ikey;
}
       
       public void setVisited(boolean visited) {
        this.visited = visited;
       }
       
        public void setVertex(boolean vertex) {
        this.vertex = vertex;
       }
public boolean isVisited() {
        return visited;
}
 

    void putDistance(double d) {
    this.distance = distance;    
    }

  

    String getN_key() {
return n_key;        
    }

    void setLabel(String string) {
    this.label = label;
    }

 
    public int compareTo(Node n2) {
        if (this.distance > n2.getDistance()) {
            return 1;
        } else if (this.distance < n2.getDistance()) {
            return -1;
        } else {
            return 0;
        }
}



    void setDiscovered(boolean b) {
         this.discovered = discovered;
    }

    boolean isDiscovered() {
         return discovered;
    }

    int ikey() {
      return  ikey;
                }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the adjacenciesList
     */
    public List<Edge> getAdjacenciesList() {
        return adjacenciesList;
    }

    /**
     * @param adjacenciesList the adjacenciesList to set
     */
    public void setAdjacenciesList(List<Edge> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }

    /**
     * @return the visit
     */
    public boolean isVisit() {
        return visit;
    }

    /**
     * @param visit the visit to set
     */
    public void setVisit(boolean visit) {
        this.visit = visit;
    }

    /**
     * @return the ancestor
     */
    public Node getAncestor() {
        return ancestor;
    }

    /**
     * @param ancestor the ancestor to set
     */
    public void setAncestor(Node ancestor) {
        this.ancestor = ancestor;
    }

    /**
     * @return the minDistance
     */
    public double getDistance() {
        return Distance;
    }

    /**
     * @param Distance
     * @param minDistance the minDistance to set
     */
    public void setDistance(double Distance) {
        this.Distance = Distance;
    }

    public void setVertex(Vertex n) {
     this.vertex = vertex; 
    }

   
   
}
