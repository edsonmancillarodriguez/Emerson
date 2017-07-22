/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letrasdesordenadas;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Edson Mancilla Rodriguez
 */
public class Tools {
    
    
    
    public static void alterarPalabra(String original, String alterado,int i)
    {
        if(alterado.length()==original.length()-2)
        {
            System.out.println(original.charAt(0)+alterado+original.charAt(original.length()-1));
            return;
        }
        int j = i;
        while(j < original.length()-1)
        {
            if(!contiene(alterado,original.charAt(j))){
                alterado+=original.charAt(j);
                alterarPalabra(original,alterado,j+1);
                alterado=alterado.substring(0, alterado.length()-1); //remover ultimo
            }
            j++; // acá esta el problema
        }
    }
    
    public static Boolean contiene(String s, char c)
    {
        for(int i = 0; i<s.length(); i++)
        {
            if(s.charAt(i)==c)
                return true;
            
        }
        return false;
    }
    /*
    public static void desordenarPalabra(String original, String alterado,LinkedList<String> L, int i)
    {
        if(alterado.length()==original.length())
        {
            L.addLast(alterado);
            return;
        }
        int j = 0;
        while(j < original.length())
        {
            if(!contiene(alterado,original.charAt(j))){
                alterado+=original.charAt(j);
                desordenarPalabra(original,alterado,L,j+1);
                alterado=quitarUltimaLetra(alterado); //remover ultimo
            }
            j++; // acá esta el problema
        }
        
    }
    */
    
    public static String quitarUltimaLetra(String palabra)
    {
        return (palabra.length()!=0)?palabra.substring(0, palabra.length()-1):"";
        
    }
    
    
    // ignorar
    public static void permutacionesSR(LinkedList<Integer> L1,LinkedList<Integer> L2, int i, int r)
    {
        if(L2.size()==r)
        {
            System.out.println(L2);
            return;
        }
        int j = 0;
        while(j < L1.size())
        {
            if(!L2.contains(L1.get(j))){
                L2.add(L1.get(j));
                permutacionesSR(L1,L2,j+1,r);
                L2.removeLast();
            }
            j++;
        }
    }
    //public static void()
    public static void desordenarPalabra(String s, LinkedList<String> L, LinkedList<Integer> pos, int i)
    {
        if(pos.size() == s.length())
        {
            String cadena = rearmar(pos,s);
            L.add(cadena);
        }
        int j = 0;
        while(j < s.length() && L.size() < 5040)
        {
            if( ! pos.contains(j))
            {
                pos.add(j);
                desordenarPalabra(s,L,pos,j+1);
                pos.removeLast();
                
            }
            j++;
        }
    }
    public static String rearmar(LinkedList<Integer> pos, String s)
    {
        String cad = "";
        for(int i = 0; i < pos.size(); i++)
        {
            cad += s.charAt(pos.get(i));
        }
        return cad;
    }
    
    
    
    public static int sigEspacio(String s, int init)
    {
        for(int i = init; i < s.length(); i++)
        {
            char c = s.charAt(i);
            
            if(espacio(c))
                return i;
        }
        return s.length();
    }
    private static boolean espacio(char c)
    {
        return c == 32 || c == '\n' || c == 9 || c == ',' || c == '.' || c == ';' || c=='?'|| c=='¿';
    }
    
    private static String desordenar(String original)
    {
        if(original.length() > 3)
        {
            String alterado;


            LinkedList<String> L = new LinkedList<>();
            desordenarPalabra(original.substring(1, original.length()-1), L,null, 0);

            Random r = new Random();
            int aleatorio = (int)(r.nextFloat()*(L.size()-1))+1; 
            
            alterado = original.charAt(0)+ L.get(aleatorio)+original.charAt(original.length()-1);
            
            return alterado;
        }
        return original;
    }
    public static String alterarFrase(String original)
    {
        String alterado = "";
        
        
        int x = 0;
        int j;
        int i = 0;
        while(i < original.length())
        {
            j = i;
            i = sigEspacio(original, i);
            alterado += desordenar(original.substring(j, i));
            
                        System.out.println(original.substring(j, i));

            while(i < original.length() && espacio(original.charAt(i)) )
            {
                alterado += original.charAt(i);
                i++;
            }
        }
        
        return alterado;
    }
}
