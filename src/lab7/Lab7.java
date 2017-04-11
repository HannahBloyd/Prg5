/*
 * Test efficiency of BST compared to Linked List
 * 
 * 
 */
package lab7;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Hannah Bloyd
 */
public class Lab7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int wordsFound=0, wordsNotFound=0;
        long compsFound=0, compsNotFound=0;
        BinarySearchTree[] dictionary = new BinarySearchTree[26];
        for (int i = 0; i < dictionary.length; i++)
            dictionary[i] = new BinarySearchTree<String>(); 
        
        
        
        try{
            
            File in = new File("random_dictionary.txt");
            Scanner scan = new Scanner(in);
            
            while(scan.hasNext()){
                String s = scan.next();
                s=s.toLowerCase();
                while (s.charAt(s.length()-1)-97 < 0 || s.charAt(s.length()-1)-97 > 25)
                    s= s.substring(0, s.length()-1);
                dictionary [(int)s.charAt(0) - 97].insert(s) ; 
                
            }
            
            
            
            in = new File("oliver.txt");
            scan = new Scanner(in);
            
            while(scan.hasNext()){
                String s = scan.next();
                s=s.toLowerCase();
                
                
                while (s.charAt(0)-97 < 0 || s.charAt(0)-97 > 25){
                    
                    s= s.substring(1);
                    
                    if (s.length() == 0){
                        s = scan.next();
                        
                        
                    }//if
                    
                    
                }//while s.charat
                
                while (s.charAt(s.length()-1)-97 < 0 || s.charAt(s.length()-1)-97 > 25){
                    
                    s= s.substring(0, s.length()-1);
                    
                    if (s.length() == 0){
                        s = scan.next();
                        
                        
                    }//if
                    
                    
                }//while s.charat2
                
               
                int[] count = new int[1];
                count[0]=0;
                if (dictionary [(int)s.charAt(0) - 97].search(s, count) ) {
                    
                    wordsFound++;
                    compsFound += count[0];
                    
                } 
                else {
                    wordsNotFound++;
                    compsNotFound += count[0];
                    //System.out.println(s);
                }
                
                
            }//while scan.hasnext
            
            System.out.println("words found " + wordsFound);
            System.out.println("words not found " + wordsNotFound);
            System.out.println("Comps Found " + compsFound);
            System.out.println("CompsNotFound " + compsNotFound);
            
            double avgcompsfound = 0, avgcompsnotfound = 0;
            avgcompsfound = compsFound/wordsFound;
            avgcompsnotfound = compsNotFound/wordsNotFound;
            
            System.out.println("Average comps for words found " + avgcompsfound);
            System.out.println("Average comps for words not found " + avgcompsnotfound);
        }//try
        catch (Exception e){
            e.printStackTrace();
            
        } //catch
    }
    
}
