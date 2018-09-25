/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada_project;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author fanny
 */
public class AlgorithmsND {

    public static Graph Erdos(int n, int m, boolean self) {
        HashMap<Integer, Node> nodes = new HashMap<>();
        HashMap<Integer, Edge> edges = new HashMap<>();
        Random rnd = new Random();
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

            edges.put(r1, new Edge(r2));

        }

//        g.setEdges(edges);
//        g.setNodes(nodes);
//        System.out.println();
        Graph g = new Graph(nodes, edges);
        return g;
    }

    public static Graph Gilbert(int n, boolean self, double p) {
        HashMap<Integer, Node> nodes = new HashMap<>();
        HashMap<Integer, Edge> edges = new HashMap<>();

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

                    edges.put(i, new Edge(j));
                }

            }

        }
        Graph g = new Graph(nodes, edges);
        return g;

    }

    public static Graph Geografico(int n, boolean self, double r) {
        HashMap<Integer, Node> nodes = new HashMap<>();
        HashMap<Integer, Edge> edges = new HashMap<>();
        Random rnd = new Random();

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
                        edges.put(i, new Edge(j));
                    }
                }

            }

        }
        Graph g = new Graph(nodes, edges);
        return g;

    }

    public static Graph Barabasi(int n, boolean self, double d) {
        HashMap<Integer, Node> nodes = new HashMap<>();
        HashMap<Integer, Edge> edges = new HashMap<>();
        double p = 0;

        for (int i = 0; i < n; i++) {
            nodes.put(i, new Node("n" + i));
        }

        int xx = 0;
        if (d > 0) {
            for (int i = 0; i < n; i++) {
                int j = 0;
                while (j <= i && (nodes.get(i).retDegree() <= d)) {
                    if (j != i || self) {
                        p = 1 - (nodes.get(j).retDegree() / d);
                        if (p > Math.random()) {
                            edges.put(i, new Edge(j));
                            nodes.get(i).degree++;
                            if (j != i) {
                                nodes.get(j).degree++;
                            }
                            xx++;
                        }
                    }
                    j++;
                }
            }
        }
        Graph g = new Graph(nodes, edges);
        return g;
    }

    public static Graph BFS(Graph g, int s) {
        HashMap<Integer, Edge> edges = new HashMap<>();
        //Crear lista de capa de padres
        LinkedList<LinkedList<Node>> padre = new LinkedList<>();
        //Marcar  todos los nodos como no visitados, estan en falso
        boolean visited[] = new boolean[g.getNodes().size()];
        visited[s] = true;
        //se le agrega valor cero a la capa padre
          padre.add(new LinkedList<>());
        padre.get(0).add(g.getNodes().get(s));
        int i = 0;
        Iterator<Map.Entry<Integer, Edge>> MapEdge;
        //mientras la capa padre no este vacia
        //seguir buscando los hijos
        while (!padre.get(i).isEmpty()) {
            LinkedList<Node> hijo = new LinkedList<>();
            for (int j = 0; j < padre.get(i).size(); j++) {
                MapEdge = g.getEdges().entrySet().iterator();
                //mientras todavia haya siguiente obtener valor y meterlo
                while (MapEdge.hasNext()) {
                    int n = padre.get(i).get(j).getivalue();
                    Map.Entry<Integer, Edge> edge = MapEdge.next();
                    if (n == edge.getValue().getN1()) {
                        if (!visited[edge.getValue().getN2()]) {
                            visited[edge.getValue().getN2()] = true;
                            hijo.add(g.getNodes().get(edge.getValue().getN2()));
                            edges.put(edge.getKey(), edge.getValue());
                        }
                    } else if (n == edge.getValue().getN2()) {
                        if (!visited[edge.getValue().getN1()]) {
                            visited[edge.getValue().getN1()] = true;
                            hijo.add(g.getNodes().get(edge.getValue().getN1()));
                            edges.put(edge.getKey(), edge.getValue());
                        }
                    }
                }
            }
            padre.add(hijo);
            i++;
        }
        Graph g2 = new Graph(false, g.getN(), g.getNodes(), edges);
        return g2;
    }
public static Graph DFSI(Graph g, int s){
         HashMap<Integer, Edge> edges = new HashMap<>();
        LinkedList<Node> nod = new LinkedList<>();
        boolean[] visited = new boolean[g.getN()];
        nod.add(g.getNodes().get(s));
        ArrayList<Integer> ed = new ArrayList<>();
        Iterator<Map.Entry<Integer, Edge>> it;
        int[] padre = new int[g.getN()];
        int j =0;
        while (!nod.isEmpty()) {
            int n0 = nod.get(0).getivalue();
            nod.remove(0);
            if (!visited[n0]) {
                ed.add(n0);
                visited[n0] = true;
            }
            if(n0 != s){
            edges.put(n0+padre[0], new Edge("e"+j++,n0,padre[n0]));
            
            }
            it = g.getEdges().entrySet().iterator();
            while (it.hasNext()) {
                    Map.Entry<Integer, Edge> edge = it.next();
                    Edge e = edge.getValue();
                    if (n0 == e.getN1() && !visited[e.getN2()]) {
                        nod.addFirst(g.getNodes().get(e.getN2()));
                        padre[e.getN2()] = n0;
                    } else if (n0 == e.getN2() && !visited[e.getN1()]) {
                        nod.addFirst(g.getNodes().get(e.getN1()));
                        padre[e.getN1()] = n0;
            
            }
    
               }}
           
          Graph g2 = new Graph(false, g.getN(), g.getNodes(), edges);
        return g2;
        }
       
        
        


private static HashMap<Integer, Edge> DFSRedges = new HashMap<>();

 public static Graph DFSR(Graph g, int n, boolean[] visited) {
        visited[n] = true;
        Iterator<Map.Entry<Integer, Edge>> j = g.getEdges().entrySet().iterator();
        int i = n;
        while (j.hasNext()) {
            Map.Entry<Integer, Edge> edge = j.next();
            if (i == edge.getValue().getN1()) {
                if (!visited[edge.getValue().getN2()]) {
                    DFSRedges.put(edge.getKey(), edge.getValue());
                    DFSR(g, edge.getValue().getN2(), visited);
                } else {
                }
            } else if (i == edge.getValue().getN2()) {
                if (!visited[edge.getValue().getN1()]) {
                    DFSRedges.put(edge.getKey(), edge.getValue());
                    DFSR(g, edge.getValue().getN1(), visited);
                }
            }
        }
        Graph t = new Graph(false, g.getN(), g.getNodes(), DFSRedges);
        return t;
    }
}
