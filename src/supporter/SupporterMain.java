/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supporter;

import java.util.*;

/**
 *
 * @author fadilafidina
 */
public class SupporterMain {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {



        //create a new database, empty
        //SupporterDatabaseHT database = new SupporterDatabaseHT();
        SupporterDatabaseBST database = new SupporterDatabaseBST();

        Supporter giulia = new Supporter("123", "Giulia");
        Supporter ben = new Supporter("234", "Ben");
        Supporter alex = new Supporter("345", "Alex");
        Supporter eric = new Supporter("456", "Eric");
        Supporter harry = new Supporter("567", "Harry");
        Supporter fadila = new Supporter("678","Fadila");
        Supporter green = new Supporter("789","Green");


        //add these supporters to the database

        database.put(giulia);
        database.put(ben);
        database.put(alex);
        database.put(eric);
        database.put(harry);
        database.put(fadila);
        database.put(green);

        //print the database
        database.printSupportersOrdered();
        System.out.println();

        //test for size()
        System.out.println("how many things in your database? " + database.size());
        System.out.println();
        
        //test for isSEmpty()
        System.out.println("is your database empty? " + database.isEmpty());
        System.out.println();


        //test for get()
        System.out.println("can you get the supporter Giulia? " + database.get("Giulia"));
        System.out.println();
        System.out.println("can you get the supporter Ben? " + database.get("Ben"));
        System.out.println();
        System.out.println("can you get the supporter Alex? " + database.get("Alex"));
        System.out.println();
        System.out.println("can you get the supporter Eric? " + database.get("Eric"));
        System.out.println();
        System.out.println("can you get the supporter Harry? " + database.get("Harry"));
        System.out.println();
        System.out.println("can you get the supporter yellow? " + database.get("yellow"));
        System.out.println();



        //test for containsName()
        System.out.println("Is Giulia present in the hash table? "+ database.containsName("Giulia"));
        System.out.println("Is Ben present in the hash table? "+ database.containsName("Ben"));
        System.out.println("Is Alex present in the hash table? "+ database.containsName("Alex"));
        System.out.println("Is Eric present in the hash table? "+ database.containsName("Eric"));
        System.out.println("Is harry present in the hash table? "+ database.containsName("Harry"));
        System.out.println("Is green present in the hash table? "+ database.containsName("Green"));
        System.out.println("Is yellow present in the hash table? "+ database.containsName("yellow"));
        System.out.println();

        //what's the load factor - ONLY FOR HASHTABLE
        //System.out.println(database.getLoadFactor());

        //what's the depth
        System.out.println("Depth is at: " + database.depth());
        System.out.println("size() is at: " + database.size());
        System.out.println("getSize() is at: " + database.getSize());
        System.out.println();

        /*
        //test for remove
        System.out.println("Removing supporter Harry");
        database.remove("Harry");

        database.printSupportersOrdered();
        System.out.println();

        //what's the depth
        System.out.println("Depth is at: " + database.depth());
        System.out.println("size() is at: " + database.size());
        System.out.println("getSize() is at: " + database.getSize());
        System.out.println();
        */

        //clear
        System.out.println("Removing supporter Alex");
        database.remove("Alex");

        //print
        database.printSupportersOrdered();
        System.out.println("Depth is at: " + database.depth());
        System.out.println("size() is at: " + database.size());
        System.out.println();

        System.out.println("Is Alex present in the hash table? "+ database.containsName("Alex"));

        System.out.println("Adding supporter Tom...");

        Supporter tom = new Supporter("467","Tom");
        database.put(tom);


        //print
        database.printSupportersOrdered();
        System.out.println("Depth is at: " + database.depth());
        System.out.println("size() is at: " + database.size());
        System.out.println();

        System.out.println("Adding Alex back in...");
        database.put(alex);

        //print
        database.printSupportersOrdered();
        System.out.println("Depth is at: " + database.depth());
        System.out.println("size() is at: " + database.size());
        System.out.println();


        //clearing database
        System.out.println();
        System.out.println("Clearing the database...");
        System.out.println();
        database.clear();
        database.printSupportersOrdered();
        System.out.println();

        //what's the depth
        System.out.println("Depth is at: " + database.depth());
    }

}
