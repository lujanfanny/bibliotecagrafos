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
public class Node {
    int degree;
    String name;
    double x,y;
    public int ivalue;

    public Node(String name) {
        this.name = name;
        this.degree = 0;
        this.ivalue =Integer.parseInt(name.substring(1, name.length()));
        
    }

    public Node(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public int retDegree() {
        return degree;
}
       public int getivalue() {
        return ivalue;
    }     
}
