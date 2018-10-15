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

        supporters[0] = john;
        supporters[1] = jane;
        supporters[2] = jack;

        System.out.println(supporters[2].getName());

       //for (Supporter supporter : supporters) {
        //System.out.println("supporter name: " + supporter.getName());
        //}
        //add values into the hashtable
        hashtable.addValues(supporters);

        //print the hashtable
        hashtable.printTable();
        System.out.println();

        //test the containsName method
        for (Supporter supporter : supporters) {
            if (supporter != null) {
                System.out.println("does the supporter " + supporter.getName() + " exist? " + hashtable.containsName(supporter.getName()));

            }
        }

        //test for size()
        System.out.println("how many things in your hashtable? " + hashtable.size());

        //test for isSEmpty()
        System.out.println("is your hashtable empty? " + hashtable.isEmpty());

    }

}
