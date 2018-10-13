/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supporter;

/**
 *
 * @author fadilafidina
 */
public class SupporterMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a new hashtable, empty
        SupporterDatabaseHT hashtable = new SupporterDatabaseHT();
        
        //create an array of strings to be inserted
        //String[] stringArray = {"hello","i love you","you are worth it","come here","i miss you","ok"};
        String[] stringArray = {"apple","banana","carrots","donuts","eggplant"};
        
    //add values into the hashtable
        hashtable.addValues(stringArray);
        
        //print the hashtable
       hashtable.printTable();
       System.out.println();
       
       //test the containsName method
       for (String string : stringArray) {
       System.out.println("does the word " + string + " exist? " + hashtable.containsName(string));
       }
       
       //test for size()
       System.out.println("how many things in your hashtable? " + hashtable.size());
       
       //test for isSEmpty()
       System.out.println("is your hashtable empty? " + hashtable.isEmpty());
       
    }
    
}
