import java.util.*;
/**
 * This class contains algorithms for graphs
 * @author Mauricio Toro
 * @version 1
 */
public class GraphAlgorithms
{
    static int cont;
     // DFS
     public static ArrayList<Integer> dfs(Graph g, int source)
     {
         int[] marcas = new int[g.size()]; // Para marcar por donde ya pasé   
         return dfsAux(g, source, marcas);
     }

     private static ArrayList<Integer> dfsAux(Graph g, int source, int[] marcas)
     {
         ArrayList<Integer> successors = g.getSuccessors(source);
         ArrayList<Integer> output = new ArrayList<Integer>();
         if (marcas[source] == 1)
           {
             return output;
           }
         else
           {
             marcas[source] = 1;
             output.add(source);
             for (int i = 0; i < successors.size(); i++)
             {
                 ArrayList<Integer> recursiveOutput = dfsAux(g,successors.get(i),marcas);
                 output.addAll(recursiveOutput);                
             }
             return output;
            }
     }

     // BFS
     public static ArrayList<Integer> bfs(Graph g, int source)
     {
        ArrayList<Integer> respuesta = new ArrayList<Integer>();
        boolean[] visited = new boolean[g.size()];
        Queue<Integer> cola = new LinkedList<Integer>();
        ArrayList<Integer> sucesores = new ArrayList<Integer>();
        cola.add(source);
        respuesta.add(source);
        while(!cola.isEmpty()){
            sucesores = g.getSuccessors(cola.poll());
            if(sucesores != null){
                for(Integer sucesor : sucesores){
                    if(!visited[sucesor]){
                        visited[sucesor] = true;
                        cola.add(sucesor);
                        respuesta.add(sucesor);                        
                    }
                }
            }
        }
        return respuesta;
     }
     
     private static boolean puedoPonerReina(int r, int c, int[] tablero){
         for(int i=0; i<r; ++i){
             if(tablero[i] == c || (i - r) == (tablero[i] - c) ||(i - r) == (c - tablero[i])){
                 return false;
             }
         }
         return true;
     }
     
     public static int nReinas(int n){
         int[] tablero = new int[n];
         cont = 0;
         return nReinas(0,n,tablero);
     }
     
     private static int nReinas(int r, int n, int[] tablero){
         for(int c = 0; c < n; ++c){
             if(puedoPonerReina(r,c,tablero)){
                 tablero[r] = c;
                 if(r == n-1){
                     ++cont;
                 }
                 else{
                     nReinas(r+1,n,tablero);
                 }
             }
         }
         return cont;
     }
     
      public static void imprimirTablero(int[] tablero) {
          int n = tablero.length;
          System.out.print("    ");
          for (int i = 0; i < n; ++i){
            System.out.print(i + " ");
          }   
          System.out.println("\n");
          for (int i = 0; i < n; ++i) {
              System.out.print(i + "   ");
              for (int j = 0; j < n; ++j)
              System.out.print((tablero[i] == j ? "Q" : "#") + " ");
              System.out.println();
            }
            System.out.println();
      }
      // Código para dibujar el grafo en GraphViz
      // Recomiendo www.webgraphviz.com/
     public static void dibujarGrafo(Graph g)
     {
        System.out.println("digraph Grafo {");
        System.out.println("node [color=cyan, style=filled];");
        int nv = g.size();
        for (int i = 0; i < nv; i++)
        {
           ArrayList<Integer> lista = g.getSuccessors(i);
           for (int j = 0; j < lista.size(); j++)
             System.out.println("\"" + i + "\" -> \"" + lista.get(j) + "\" [ label=\""+ g.getWeight(i,lista.get(j)) +"\"];");
        }
        System.out.println("}");
     }
     
     public static void main(String[] args)
     {
         GraphAL gal = new GraphAL(7);
         gal.addArc(0,1,4);
         gal.addArc(0,2,8);
         gal.addArc(1,2,9);
         gal.addArc(1,4,10);
         gal.addArc(1,3,8);
         gal.addArc(2,3,2);
         gal.addArc(2,5,1);
         gal.addArc(3,4,7);
         gal.addArc(3,5,9);
         gal.addArc(4,5,5);
         gal.addArc(4,6,6);
         gal.addArc(5,6,2);
        
         dibujarGrafo(gal);
          
         ArrayList<Integer> path = dfs(gal,0);
         for (int i  = 0; i < path.size(); i++)
           System.out.println(path.get(i));
         
         System.out.println("---");
         
         ArrayList<Integer> path3 = bfs(gal,0);
         for (int i  = 0; i < path3.size(); i++)
           System.out.println(path3.get(i));
         
         System.out.println("---");
           
         GraphAM gam = new GraphAM(7);
         gam.addArc(0,1,4);
         gam.addArc(0,2,8);
         gam.addArc(1,2,9);
         gam.addArc(1,4,10);
         gam.addArc(1,3,8);
         gam.addArc(2,3,2);
         gam.addArc(2,5,1);
         gam.addArc(3,4,7);
         gam.addArc(3,5,9);
         gam.addArc(4,5,5);
         gam.addArc(4,6,6);
         gam.addArc(5,6,2);
          
         ArrayList<Integer> path2 = dfs(gam,0);
            for (int i  = 0; i < path2.size(); i++){
               System.out.println(path2.get(i));
            }
    
                System.out.println("---");
         
         ArrayList<Integer> path4 = bfs(gam,0);
         for (int i  = 0; i < path4.size(); i++){
           System.out.println(path4.get(i));
        }
     }
     
     //Para tomar los tiempos de ejecucion por cada n
     public static long tomarTiempo(int n){   
        long startTime = System.currentTimeMillis();
        nReinas(n);
        long estimatedTime = System.currentTimeMillis() - startTime;
        return estimatedTime;
        }
        public static void tiempos(){
        for(int i=4; i <=32;i++){
            System.out.println(tomarTiempo(i));
        }
     }
}
