/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
        Graph g = new Graph(500,2000);
        AlgorithmsND.Erdos(g, false);
        //Graph g2 = new Graph(100,2);
        //AlgorithmsND.Geografico(g2, true, 0.5);
                
        PrintFile(g);
        
        
    }

    private static void PrintFile(Graph g) {
        try {
            File f = new File("grafo.gv");
            String struct = "graph G1 {\n";
            Iterator<Map.Entry<Integer, Node>>  it2 = g.getNodes().entrySet().iterator();
            while (it2.hasNext()) {
                struct += it2.next().getValue().name+ ";\n";
            }
            struct += "\n";
            Iterator<Map.Entry<String, Edge>> it = g.getEdges().entrySet().iterator();
            while (it.hasNext()) {
                struct += it.next().getKey() + ";\n";
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
