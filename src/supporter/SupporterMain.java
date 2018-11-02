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
        //create a new database, empty
        //SupporterDatabaseHT database = new SupporterDatabaseHT();
        SupporterDatabaseBST database = new SupporterDatabaseBST();

        Supporter john = new Supporter("123", "John");
        Supporter jane = new Supporter("234", "Jane");
        Supporter jack = new Supporter("345", "Jack");
        Supporter joseph = new Supporter("354", "Joseph");
        Supporter yunushadi = new Supporter("3354", "Yunushadi");
        Supporter dila = new Supporter("543","Dila");
        Supporter green = new Supporter("543","Green");


        //add these supporters to the database

        database.put(john);
        database.put(jane);
        database.put(jack);
        database.put(joseph);
        database.put(yunushadi);
        database.put(dila);
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
        System.out.println("can you get the supporter John? " + database.get("John") + " ... What's his name? " + database.get("John").getName());
        System.out.println("can you get the supporter Jane? " + database.get("Jane") + " ... What's his name? " + database.get("Jane").getName());
        System.out.println("can you get the supporter Jack? " + database.get("Jack") + " ... What's his name? " + database.get("Jack").getName());
        System.out.println("can you get the supporter Joseph? " + database.get("Joseph") + " ... What's his name? " + database.get("Joseph").getName());
        System.out.println("can you get the supporter yunushadi? " + database.get("Yunushadi") + " ... What's his name? " + database.get("Yunushadi").getName());
        System.out.println("can you get the supporter yellow? " + database.get("yellow"));
        System.out.println();



        //test for containsName()
        System.out.println("Is John present in the hash table? "+ database.containsName("John"));
        System.out.println("Is Jane present in the hash table? "+ database.containsName("Jane"));
        System.out.println("Is Jack present in the hash table? "+ database.containsName("Jack"));
        System.out.println("Is Joseph present in the hash table? "+ database.containsName("Joseph"));
        System.out.println("Is yunushadi present in the hash table? "+ database.containsName("Yunushadi"));
        System.out.println("Is green present in the hash table? "+ database.containsName("Green"));
        System.out.println("Is yellow present in the hash table? "+ database.containsName("yellow"));


        //what's the load factor - ONLY FOR database
        //System.out.println(database.getLoadFactor());

        //what's the depth
        System.out.println("Depth is at: " + database.depth());
        System.out.println("size() is at: " + database.size());
        System.out.println("getSize() is at: " + database.getSize());
        System.out.println();

        //test for clear
        System.out.println("Clearing the database...");
        database.clear();
        database.printSupportersOrdered();
        System.out.println();

        //what's the depth
        System.out.println("Depth is at: " + database.depth());
        System.out.println("size() is at: " + database.size());
        System.out.println("getSize() is at: " + database.getSize());
    }

}
