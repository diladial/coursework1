/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supporter;

import java.util.*;

/**
 *
 * @author 18033862
 */
public class SupporterMain {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SupporterDatabaseHT database = new SupporterDatabaseHT();
        //SupporterDatabaseBST database = new SupporterDatabaseBST();

        Supporter giulia = new Supporter("123", "Giulia");
        Supporter ben = new Supporter("234", "Ben");
        Supporter alex = new Supporter("345", "Alex");
        Supporter eric = new Supporter("456", "Eric");
        Supporter fadila = new Supporter("678","Fadila");
        Supporter green = new Supporter("789","Green");
        Supporter harry = new Supporter("567", "Harry");

        Supporter gyro = new Supporter("149","Gyro");

        Supporter gogon = new Supporter("789","Gogon");
        Supporter jennifer = new Supporter("345","Jennifer");



        //add these supporters to the database

        System.out.println("Is the tree empty? " +
                database.isEmpty());
        System.out.println();


        database.put(giulia);

        System.out.println("Is the tree empty? " +
                database.isEmpty());
        System.out.println();

        database.put(ben);
        database.put(alex);
        database.put(eric);
        database.put(fadila);
        database.put(green);
        database.put(harry);
        database.printSupportersOrdered();

        //System.out.println("Does the table contain supporter " +"FINDME? " + database.containsName("FINDME"));

        database.remove("Ben");

        database.printSupportersOrdered();

        System.out.println("Does the table contain supporter " +
                "Harry? " + database.containsName("Harry"));






        //database.put(harry);




        //database.printSupportersOrdered();

        //database.put(gogon);

        /*
        database.put(gyro);
        database.put(jennifer);



        System.out.println("Can you get the supporter Green? ");
        System.out.println("Name of supporter retrieved: " +
                database.get("Green").getName());

        //database.get("Green");
        database.printSupportersOrdered();

        database.clear();

        */


        /*


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
        */

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



        //print
        database.printSupportersOrdered();
        //System.out.println("Depth is at: " + database.depth());
        System.out.println("size() is at: " + database.size());
        System.out.println();

        //System.out.println("Removing supporter Giulia");
        database.remove("Giulia");
        System.out.println("Is Ben present in the database? "+ database.containsName("Ben"));
        */
        /*


        Supporter carter = new Supporter("467","CARTER");
        database.put(carter);

        System.out.println();
        Supporter reid = new Supporter("465","REID");
        database.put(reid);



        Supporter smith = new Supporter("867","SMITH");
        database.put(smith);

        Supporter johnson = new Supporter("863","JOHNSON");
        database.put(johnson);

        Supporter davis = new Supporter("355","DAVIS");
        Supporter white = new Supporter("355","WHITE");

        database.put(davis);
        database.put(white);

        Supporter brookes = new Supporter("367","BROOKES");
        database.put(brookes);

        Supporter lightfoot = new Supporter("807","LIGHTFOOT");
        database.put(lightfoot);
        */








        //Supporter alex1 = new Supporter("657","Alex");
        //database.put(alex1);

        //database.get("Alex");
        //database.get(alex);






        //print
        //database.printSupportersOrdered();
        //System.out.println("Depth is at: " + database.depth());
        //System.out.println("Size of the table is: " + database.size());
        //System.out.println();
        /*

        database.get("Jake");
        Supporter hannah = new Supporter("367","Hannah");
        database.put(hannah);

        database.printSupportersOrdered();



        System.out.println("Found Maya y/n? " + database.containsName("Maya"));
        System.out.println("Found Juliette y/n? " + database.containsName("Juliette"));
        System.out.println("Found Gyro y/n? " + database.containsName("Gyro"));

        database.get("Hannah");
        database.get("Harry");
        database.get("Giulia");
        database.get("Gyro");
        database.get("Chris");
        database.get("Does Not Exist");
        database.get("Green");
        database.get("Fadila");
        */

        /*
        //get the boy
        System.out.println("Can you get the supporter Green? ");
        database.get("Green");
        System.out.println();
        */



        /*

        //clearing database
        System.out.println();
        System.out.println("Clearing the database...");
        System.out.println();
        database.clear();
        database.printSupportersOrdered();
        System.out.println();
        */




        //what's the depth
        //System.out.println("Depth is at: " + database.depth());
    }

}
