/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada_project;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author fanny
 */
public class AlgorithmsND {

    public static void Erdos(Graph g, boolean self) {
        HashMap<Integer, Node> nodes = new HashMap<>();
        HashMap<String, Edge> edges = new HashMap<>();
        Random rnd = new Random();
        int n = g.n;
        int m = g.m;

        for (int i = 0; i < n; i++) {
            nodes.put(i, new Node("n" + i));
        }
        for (int i = 0; i < m; i++) {
            int r1 = rnd.nextInt(n);
            int r2 = rnd.nextInt(n);

            if (!self) {
                while (r1 == r2) {
                    r2 = rnd.nextInt(n);
                }
            }
            edges.put(nodes.get(r1).name + "--" + nodes.get(r2).name, new Edge("e" + i));

        }

        g.setEdges(edges);
        g.setNodes(nodes);
        System.out.println();
    }

    public static void Gilbert(Graph g, boolean self, double p) {
        HashMap<Integer, Node> nodes = new HashMap<>();
        HashMap<String, Edge> edges = new HashMap<>();
        int n = g.n;

        for (int i = 0; i < n; i++) {
            nodes.put(i, new Node("n" + i));
        }
        for (int i = 0; i < n; i++) {
            int x = 0;
            if (!self) {
                x = i + 1;
            }

            for (int j = x; j < n; j++) {

                if (Math.random() <= p) {
                    edges.put(nodes.get(i).name + "--" + nodes.get(j).name, new Edge("e" + i));
                }

            }

        }
        g.setEdges(edges);
        g.setNodes(nodes);
        System.out.println();

    }

    public static void Geografico(Graph g, boolean self, int r) {
        HashMap<Integer, Node> nodes = new HashMap<>();
        HashMap<String, Edge> edges = new HashMap<>();
        Random rnd = new Random();
        int n = g.n;

        for (int i = 0; i < n; i++) {
            nodes.put(i, new Node("n" + i, Math.random(), Math.random()));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (!self) {
                    if (i == j) {
                        break;
                    }
                } else {
                    double distance = 0;
                    distance = Math.sqrt(Math.pow(nodes.get(j).x - nodes.get(i).x, 2) + Math.pow(nodes.get(j).y - nodes.get(i).y, 2));
                    if (distance <= r) {
                        edges.put(nodes.get(i).name + "--" + nodes.get(j).name, new Edge("e" + i));
                    }
                }

            }

        }
        g.setEdges(edges);
        g.setNodes(nodes);
        System.out.println();

    }
 }   

//   public static void Barabasi(Graph g, boolean self) {
//        HashMap<Integer, Node> nodes = new HashMap<>();
//        HashMap<String, Edge> edges = new HashMap<>();
//        Random rnd = new Random();
//        int n = g.n;
//        int d = g.m;
//        //Agregar nodos iniciales con conexiones rnd
//        for (int i = 0; i < m; i++){
//            nodes.put(i, new Node("n" + i));
//        }
//        for (int i = 0; i < n; i++) {
//            int x = 0;
//            if (!self) {
//                x = i + 1;
//            }
//
//            for (int j = x; j < n; j++) {
//
//                if (Math.random() <= p) {
//                    edges.put(nodes.get(i).name + "--" + nodes.get(j).name, new Edge("e" + i));
//                }
//        
//        }
//
//    }
//    g.setEdges(edges);
//        g.setNodes(nodes);
//        System.out.println();
//}