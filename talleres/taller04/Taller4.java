import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #4
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller4 {

    public static ArrayList<Integer> dfs(Digraph g, int v){
        boolean[] visited = new boolean[g.size()];
        ArrayList<Integer> res = new ArrayList<Integer>();
        dfs(g, v, res, visited);
        return res;
    }
        
    private static void dfs(Digraph g, int v, ArrayList<Integer> res, boolean[] visited){
        visited[v] = true;
        res.add(v);
        ArrayList<Integer> sucesores = g.getSuccessors(v);
        if(sucesores != null){
            for(Integer sucesor : sucesores){
                if(!visited[sucesor]){
                    dfs(g, sucesor, res, visited);
                }
            }
        }   
        return;
    }
        
    public static ArrayList<Integer> bfs(Digraph g, int v){
        ArrayList<Integer> res = new ArrayList<Integer>();
        boolean visited[] = new boolean[g.size];
        bfs(g,v,visited, res);
        return res;
    }
    
     private static void bfs(Digraph g, int v, boolean[] visited, ArrayList<Integer> res){
        visited[v] = true; 
        Queue<Integer> a = new LinkedList<Integer>();
        ArrayList<Integer> sucesores = new ArrayList<Integer>();
        a.add(v);
        res.add(v);
        while(!a.isEmpty()){
            sucesores = g.getSuccessors(a.poll());
            if(sucesores != null){
                for(Integer sucesor : sucesores){                   
                    if(!visited[sucesor]){
                        visited[sucesor] = true;
                        a.add(sucesor);
                        res.add(sucesor);
                    }
                }
            }    
        }
    }
    
    
    public static boolean hayCaminoDFS(Digraph g, int inicio, int fin){
        boolean[] visited = new boolean[g.size()];
        return hayCaminoDFS(g,inicio,fin,visited);
    }
       private static boolean hayCaminoDFS(Digraph g, int nodo, int objetivo, boolean[] visited){
        visited[nodo] = true;
        ArrayList<Integer> sucesores = g.getSuccessors(nodo);
        if(sucesores != null){
            for(Integer sucesor : sucesores){              
                if(!visited[sucesor] && (sucesor == objetivo || hayCaminoDFS(g, sucesor, objetivo, visited))){      
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean hayCaminoBFS(Digraph g, int inicio, int fin){
        boolean[] visited = new boolean[g.size()];
        return hayCaminoBFS(g,inicio,fin,visited);
        
    }
    
    private static boolean hayCaminoBFS(Digraph g, int nodo, int objetivo, boolean[] visited){
        Queue<Integer> hijos = new LinkedList<Integer>();
        ArrayList<Integer> sucesores = new ArrayList<Integer>();
        hijos.add(nodo);
        while(!hijos.isEmpty()){
            int hijo= hijos.poll();
            sucesores=g.getSuccessors(hijo);
               
            if(hijo==objetivo) return true;      
            visited[hijo]=true; 
            if( sucesores!=null){                
              for(Integer sucesor: sucesores){
                 if(!visited[sucesor]){
                        hijos.add(sucesor);
                 }
              }
            }   
        }
        return false;
        }
        
          public static void main(String[] args){
        DigraphAL g = new DigraphAL(6);
        g.addArc(0,1,1);
        g.addArc(1,3,1);
        g.addArc(0,2,1);
        g.addArc(3,0,1);
        g.addArc(4,5,1);

        System.out.println(dfs(g,0));
        System.out.println(bfs(g,0));
        System.out.println(hayCaminoDFS(g,0,2));
        System.out.println(hayCaminoDFS(g,4,2));
        System.out.println(hayCaminoBFS(g,0,2));
        System.out.println(hayCaminoBFS(g,4,2));
    }

        
    
    /*public static int recorrido(Digraph g) {
        // complete...
    }
    
    // recomendacion
    private static int recorrido(Digraph g, int v, int[] visited) {
        
    }
    
    // recomendacion
    private static int[] removeAt(int k, int a[]) {
        // complete...
    }
    
    public static int costoMinimo(Digraph g, int inicio, int fin) {
        // complete...
    }
    
    // recomendacion
    private static void dfs(Digraph g, int v, int[] costo) {
        // complete...
    }*/

}
