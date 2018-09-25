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
        Graph g = AlgorithmsND.Erdos(30, 30, true);
        Graph g2 = AlgorithmsND.DFSI(g, 0);
    //    Graph g2 = AlgorithmsND.BFS(g, 0);
   //     Graph g2 = AlgorithmsND.DFSR(g, 3, new boolean[g.getN()]);
        //AlgorithmsND.Barabasi(g, true, 20);
  //      Alg_BFS_DFS.BFS(g1, 0);
        //Graph g2 = new Graph(100,2);
        //AlgorithmsND.Geografico(g2, true, 0.5);
                
        PrintFile(g2);
        
        
    }

    private static void PrintFile(Graph g) {
        try {
            File f = new File("grafo.gv");
            String struct = "graph g2 {\n";
            Iterator<Map.Entry<Integer, Node>>  it2 = g.getNodes().entrySet().iterator();
            while (it2.hasNext()) {
                struct += it2.next().getKey()+ ";\n";
            }
            struct += "\n";
            Iterator<Map.Entry<Integer, Edge>> it = g.getEdges().entrySet().iterator();
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
