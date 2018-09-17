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

    public Node(String name) {
        this.name = name;
    }

    public Node(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public int retDegree() {
        return degree;
}
            
}
