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
        //String[] stringArray = {"apple","banana","carrots","donuts","eggplant"};
        Supporter[] supporters = new Supporter[10];

        Supporter john = new Supporter("123", "John");
        Supporter jane = new Supporter("234", "Jane");
        Supporter jack = new Supporter("345", "Jack");
        Supporter yunus = new Supporter("354", "Ackj");
        Supporter yunushadi = new Supporter("354", "yunushadi");

        //supporters[0] = john;
        //supporters[1] = jane;
        //supporters[2] = jack;

        //System.out.println(supporters[2].getName());

       //for (Supporter supporter : supporters) {
        //System.out.println("supporter name: " + supporter.getName());
        //}
        //add values into the hashtable
        //hashtable.addValues(supporters);
        
        hashtable.put(john);
        hashtable.put(jane);
        hashtable.put(jack);
        hashtable.put(yunus);
        hashtable.put(yunushadi);
        
        //System.out.println(hashtable.put(yunushadi).getName());

        //print the hashtable
        hashtable.printSupportersOrdered();
        System.out.println();

        //test the containsName method
        for (Supporter supporter : supporters) {
            if (supporter != null) {
                System.out.println("does the supporter " + supporter.getName() + " exist? " + hashtable.containsName(supporter.getName()));

            }
        }

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
        System.out.println("can you get the supporter Jack? " + hashtable.get("yunushadi") + " ... What's his name? " + hashtable.get("yunushadi").getName());

    }

}
