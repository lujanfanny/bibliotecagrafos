/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada_project;

import static java.lang.reflect.Array.get;

/**
 *
 * @author fanny
 */
public class Edge {

    private double Weight = 1;
    String name;
    private int n1, n2;
    boolean selfassign;
    double weight;
    private Node startnodo;
    private Node targetnodo;
    
    public Edge(double weight, Node startnodo, Node targetnodo){
        this.weight= weight;
        this.startnodo = startnodo;
        this.targetnodo = targetnodo;
    }
    
   

    public Edge(int n2) {
        this.n2 = n2;

    }
    
   

    Edge(String name, int n1, int n2, double weight) {
        this.name = name;
        this.n1 = n1;
        this.n2 = n2;
        this.weight = weight;
    }

    

    public int getN2() {
        return n2;
    }

    public int getN1() {
        return n1;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double Weight) {
        this.Weight = Weight;
    }

    public int compare(Edge e2) {
        if (this.weight > e2.getWeight()) {
            return 1;
        } else if (this.weight < e2.getWeight()) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * @return the startnodo
     */
    public Node getStartnodo() {
        return startnodo;
    }

    /**
     * @param startnodo the startnodo to set
     */
    public void setStartnodo(Node startnodo) {
        this.startnodo = startnodo;
    }

    /**
     * @return the targetnodo
     */
    public Node getTargetnodo() {
        return targetnodo;
    }

    /**
     * @param targetnodo the targetnodo to set
     */
    public void setTargetnodo(Node targetnodo) {
        this.targetnodo = targetnodo;
    }

}
