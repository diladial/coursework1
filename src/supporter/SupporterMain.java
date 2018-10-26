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

        Supporter john = new Supporter("123", "John");
        Supporter jane = new Supporter("234", "Jane");
        Supporter jack = new Supporter("345", "Jack");
        Supporter joseph = new Supporter("354", "Joseph");
        Supporter yunushadi = new Supporter("3354", "yunushadi");
        Supporter dila = new Supporter("543","Dila");
        Supporter green = new Supporter("543","green");


        //add these supporters to the database

        hashtable.put(john);
        hashtable.put(jane);
        hashtable.put(jack);
        hashtable.put(joseph);
        hashtable.put(yunushadi);
        hashtable.put(dila);
        hashtable.put(green);

        //print the hashtable
        hashtable.printSupportersOrdered();
        System.out.println();

        //test for size()
        System.out.println("how many things in your hashtable? " + hashtable.size());
        System.out.println();
        
        //test for isSEmpty()
        System.out.println("is your hashtable empty? " + hashtable.isEmpty());
        System.out.println();
        
        //test for get()

        System.out.println("can you get the supporter John? " + hashtable.get("John") + " ... What's his name? " + hashtable.get("John").getName());
        System.out.println("can you get the supporter Jane? " + hashtable.get("Jane") + " ... What's his name? " + hashtable.get("Jane").getName());
        System.out.println("can you get the supporter Jack? " + hashtable.get("Jack") + " ... What's his name? " + hashtable.get("Jack").getName());
        System.out.println("can you get the supporter Joseph? " + hashtable.get("Joseph") + " ... What's his name? " + hashtable.get("Joseph").getName());
        System.out.println("can you get the supporter yunushadi? " + hashtable.get("yunushadi") + " ... What's his name? " + hashtable.get("yunushadi").getName());
        System.out.println("can you get the supporter yellow? " + hashtable.get("yellow"));
        System.out.println();


        //test for containsName()
        System.out.println("Is John present in the hash table? "+ hashtable.containsName("John"));
        System.out.println("Is Jane present in the hash table? "+ hashtable.containsName("Jane"));
        System.out.println("Is Jack present in the hash table? "+ hashtable.containsName("Jack"));
        System.out.println("Is Joseph present in the hash table? "+ hashtable.containsName("Joseph"));
        System.out.println("Is yunushadi present in the hash table? "+ hashtable.containsName("yunushadi"));
        System.out.println("Is green present in the hash table? "+ hashtable.containsName("green"));
        System.out.println("Is yellow present in the hash table? "+ hashtable.containsName("yellow"));


        //what's the load factor
        System.out.println(hashtable.getLoadFactor());

        //test for clear
        System.out.println("Clearing the hashtable...");
        hashtable.clear();
        hashtable.printSupportersOrdered();
    }

}
