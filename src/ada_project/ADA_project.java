/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fanny
 */
public class ADA_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph g = AlgorithmsND.Geografico(200, true, 50);
        Graph g2 = AlgorithmsND.EdgeValues(g, 2, 100);
//   Graph g3 = AlgorithmsND.Dijkstra(g2, 2); //***
      
//  Graph g4 = AlgorithmsND.Dijkstra(g2, 2);
        //AlgorithmsND.Barabasi(g, true, 20);
  //      Alg_BFS_DFS.BFS(g1, 0);
        //Graph g2 = new Graph(100,2);
        //AlgorithmsND.Geografico(g2, true, 0.5);
                
//        PrintFile(g3);
        
        
    }

    private static void PrintFile(Graph g2) {
        try {
            File f = new File("grafo.gv");
            String struct = "graph g2 {\n";
            Iterator<Map.Entry<Integer, Node>>  it2 = g2.getNodes().entrySet().iterator();
            while (it2.hasNext()) {
                struct += it2.next().getKey()+ ";\n";
            }
            struct += "\n";
            Iterator<Map.Entry<Integer, Edge>> it = g2.getEdges().entrySet().iterator();
            while (it.hasNext()) {
                 Map.Entry<Integer, Edge> edge = it.next();
                struct += ""+edge.getKey()+"--"+ edge.getValue().getN2()+";\n";
            }
            struct += "}";
            
            PrintWriter pw;
            
            pw = new PrintWriter(f);
            pw.write(struct);
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ADA_project.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
    }
    
}
