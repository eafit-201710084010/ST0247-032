import java.util.*;
import java.io.*;
import java.lang.*;
/**
 * Write a description of class Punto2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Punto2
{
    static int cont;
    private static boolean puedoPonerReina(int r, int c, int[] tablero){
        for(int i=0; i<r; ++i){
            if(tablero[i]==c||(i-r)==(tablero[i]-c)||(i-r)==(c-tablero[i])){
                return false;
            }
        }
        return true;
    }
    
    public static void nReinas(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> respuestas = new ArrayList<Integer>();
        int n;
        cont = 0;
        while((n = sc.nextInt()) != 0){
            boolean[][] canPlace = new boolean[n][n];
            int [] tablero = new int[n]; 
            for(int i=0; i<n; ++i){
                String line = sc.next();
                for(int j=0;j<n;++j){
                    if(line.charAt(j)=='*'){
                        canPlace[i][j]=false;
                    }
                    else{
                        canPlace[i][j]=(true);
                    }
                }                
            }                        
            respuestas.add(nReinas(0,n,tablero,canPlace));
            cont = 0;
        }
        for(int k = 1; k <= respuestas.size(); ++k){
            System.out.println("Case "+k+": "+respuestas.get(k-1));
        }
    }
    
    private static int nReinas(int r, int n, int[] tablero, boolean[][] canPlace){
        for(int c=0; c<n; ++c){
            if(puedoPonerReina(r,c,tablero) && canPlace[c][r] == true){  
                tablero[r] = c;                        
                if(r==n-1){
                    ++cont;
                }
                else{
                    nReinas(r+1,n,tablero,canPlace);
                }
            } 
        }        
        return cont;
    }
    
    public static void main(String[] args){
        nReinas();
    }
}
