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
        SupporterDatabaseHT database = new SupporterDatabaseHT();
        //SupporterDatabaseBST database = new SupporterDatabaseBST();

        Supporter giulia = new Supporter("123", "Giulia");
        Supporter ben = new Supporter("234", "Ben");
        Supporter alex = new Supporter("345", "Alex");
        Supporter eric = new Supporter("456", "Eric");
        Supporter harry = new Supporter("567", "Harry");
        Supporter fadila = new Supporter("678","Fadila");
        Supporter gyro = new Supporter("789","Gyro");
        Supporter green = new Supporter("789","Green");
        Supporter gogon = new Supporter("789","Gogon");
        //Supporter jennifer = new Supporter("345","Jennifer");
        //Supporter chris = new Supporter("355","Chris");
        //Supporter alice = new Supporter("355","Alice");


        //add these supporters to the database

        database.put(giulia);
        database.put(ben);
        database.put(alex);
        database.put(eric);
        database.put(harry);
        database.put(fadila);
        //database.put(gogon);
        database.put(green);
        //database.put(gyro);
        //database.put(jennifer);
        //database.put(chris);
        //database.put(alice);


        //print the database
        database.printSupportersOrdered();
        System.out.println();

        //test for size()
        System.out.println("How many things in your database? " + database.size());
        System.out.println();
        
        //test for isSEmpty()
        System.out.println("Is your database empty? " + database.isEmpty());
        System.out.println();


        //test for get()
        System.out.println("Can you get the supporter Giulia? " + database.get("Giulia"));
        System.out.println();
        System.out.println("Can you get the supporter Ben? " + database.get("Ben"));
        System.out.println();
        System.out.println("Can you get the supporter Alex? " + database.get("Alex"));
        System.out.println();
        System.out.println("Can you get the supporter Eric? " + database.get("Eric"));
        System.out.println();
        System.out.println("Can you get the supporter Harry? " + database.get("Harry"));
        System.out.println();
        System.out.println("Can you get the supporter yellow? " + database.get("yellow"));
        System.out.println();

        //database.remove("Alice");



        //test for containsName()
        System.out.println("Is Giulia present in the database? "+ database.containsName("Giulia"));
        System.out.println("Is Ben present in the database? "+ database.containsName("Ben"));
        System.out.println("Is Alex present in the database? "+ database.containsName("Alex"));

        //System.out.println("Is Alex present in the database? "+ database.containsName("Alex"));
        System.out.println("Is Giulia present in the database? "+ database.containsName("Giulia"));
        System.out.println("Is Eric present in the database? "+ database.containsName("Eric"));
        System.out.println("Is harry present in the database? "+ database.containsName("Harry"));
        System.out.println("Is green present in the database? "+ database.containsName("Green"));
        System.out.println("Is yellow present in the database? "+ database.containsName("yellow"));
        System.out.println();

        //what's the load factor - ONLY FOR HASHTABLE
        //System.out.println(database.getLoadFactor());

        /*
        //what's the depth
        System.out.println("Depth is at: " + database.depth());
        System.out.println("size() is at: " + database.size());
        System.out.println("getSize() is at: " + database.getSize());
        System.out.println();
        */

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


        //clear
        //database.remove("Alex");

        //print
        database.printSupportersOrdered();
        //System.out.println("Depth is at: " + database.depth());
        System.out.println("size() is at: " + database.size());
        System.out.println();
        */


        /*
        Supporter tom = new Supporter("467","Tom");
        database.put(tom);



        //print
        database.printSupportersOrdered();
        //System.out.println("Depth is at: " + database.depth());
        System.out.println("size() is at: " + database.size());
        System.out.println();

        //System.out.println("Removing supporter Giulia");
        database.remove("Giulia");
        System.out.println("Is Ben present in the database? "+ database.containsName("Ben"));
        */

        System.out.println();
        Supporter luke = new Supporter("465","Luke");
        database.put(luke);

        Supporter hannah = new Supporter("367","Hannah");
        database.put(hannah);

        Supporter viv = new Supporter("867","Viv");
        database.put(viv);

        //Supporter alex1 = new Supporter("657","Alex");
        //database.put(alex1);

        //database.get("Alex");
        //database.get(alex);



        database.printSupportersOrdered();
        System.out.println();

        database.remove("Ben");


        //print
        database.printSupportersOrdered();
        //System.out.println("Depth is at: " + database.depth());
        //System.out.println("Size of the table is: " + database.size());
        System.out.println();

        /*
        //get the boy
        System.out.println("Can you get the supporter Green? ");
        database.get("Green");
        System.out.println();
        */




        //clearing database
        System.out.println();
        System.out.println("Clearing the database...");
        System.out.println();
        database.clear();
        database.printSupportersOrdered();
        System.out.println();



        //what's the depth
        //System.out.println("Depth is at: " + database.depth());
    }

}
