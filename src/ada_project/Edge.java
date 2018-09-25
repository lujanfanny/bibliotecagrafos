/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada_project;

/**
 *
 * @author fanny
 */
public class Edge {
    String name;
    private int n1,n2;
    boolean selfassign;

    public Edge(int n2) {
        this.n2 = n2;
        
    }

    Edge(String name, int n1,int n2) {
        this.name = name;
        this.n1 = n1;
        this.n2 = n2;
          }


    public int getN2() {
        return n2;
    }
    
    public int getN1() {
        return n1;
    }
    
    
    
}
