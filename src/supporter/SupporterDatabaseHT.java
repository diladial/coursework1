/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supporter;

import java.text.DecimalFormat;

/**
 *
 * @author fadilafidina
 */
public class SupporterDatabaseHT implements ISupporterDatabase {

    //hash table size
    private int capacity = 11;

    //number of supporters in the hashtable
    private int size = 0;

    //array of supporters
    private Supporter[] table;

    //load factor
    private double loadFactor = 0.0;

    //constructor that takes in no params
    public SupporterDatabaseHT() {
        table = new Supporter[capacity];
        clear();
    }


    /*
     Hash function
     */
    public int hash(String key) {
        int y = 7;
        int hash = 0;
        for (int i = 0; i < key.length(); i++){
            hash = y * (hash + key.charAt(i));
        }
        return hash % capacity;
    }
    
    public int probe(int i){
        return i*i;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
    }

    @Override
    /*
     returns a boolean if the name is found in hashtable
     - get name - hashes - if not found in key, then probe - then look again
     */
    public boolean containsName(String name) {
        int index = hash(name);
        int i = 1;

        if (table[index] == null) {
            System.out.println("Name " + name + " is not in table.");
            return false;
        }

        if (table[index].getName().equals(name) && !table[index].isDeleted())
            return true;

        while (!table[index].getName().equals(name)){

            if (table[index] == null){ //no name has been found
                return false;
            }

            System.out.println("Clash  in trying containsName() on " + name);
            index = (index + i*i) % capacity;

            if (table[index].getName().equals(name) && !table[index].isDeleted()){
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public Supporter get(String name) {
        int index = hash(name);
        int i = 1;
        if (table[index] == null) {
            System.out.println("Supporter " + name + " not found");
            return null;
        }

        else if (table[index].getName().equals(name) && !table[index].isDeleted()) {
            System.out.println("Supporter " + name + " found!");
            return table[index];
        }
        else {

            while (!table[index].getName().equals(name)) {
                System.out.println("Clash  in trying get() on " + name);
                index = (index + i*i) % capacity;

                if (table[index].getName().equals(name) && !table[index].isDeleted()){
                    System.out.println("Supporter " + name + " found!");
                    return table[index];
                }

                if (table[index] == null){
                    System.out.println("not found: " + name);
                    return null;
                }
                i++;
            }
        }
        return null;
        //condition that stops if i go to an empty slot
        //and check and you havent looked in every single slot
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Supporter put(Supporter supporter) {
        String name = supporter.getName();
        System.out.println("Adding supporter " + name + "...");
        int index = hash(name);
        int i = 1;

        if (table[index] == null ) {
            System.out.println("Previous hashtable capacity: " + size());
            table[index] = supporter;
            size++;
            System.out.println("Supporter added: " + supporter.getName() + ", with index " + index);
            System.out.println("New hashtable size: " + size());
            printLoadFactor();
            System.out.println();

            resize();
        }


        else
            while (table[index] != null){
                System.out.println("Clash detected! Index is at: " + index);
                index = (index + i*i) % capacity;

                if (table[index] == null) {
                    System.out.println("Found an empty space! Index is now at: " + index);
                    System.out.println("Previous hashtable capacity: " + size());

                    table[index] = supporter;
                    size++;

                    System.out.println("Supporter added: " + supporter.getName());
                    System.out.println("New hashtable size: " + size());
                    printLoadFactor();
                    System.out.println();
                    resize();

                    return supporter;
                }

            }
            return null;
    }

    @Override
    public Supporter remove(String name) {
        System.out.println("Removing supporter " + name + "...");

        int index = hash(name);
        int i = 1;
        if (table[index] == null) {
            System.out.println("Supporter " + name + " not found");
            return null;
        }

        else if (table[index].getName().equals(name) && !table[index].isDeleted()) {
            table[index].setDeleted();
            System.out.println("Supporter " + name + " is 'removed'!");
            size--;
            return table[index];
        }
        else {

            while (!table[index].getName().equals(name)) {
                System.out.println("Clash  in trying get() on " + name);
                index = (index + i*i) % capacity;

                if (table[index].getName().equals(name) && !table[index].isDeleted()){
                    table[index].setDeleted();
                    System.out.println("Supporter " + name + " is 'removed'!");
                    size--;
                    return table[index];
                }

                if (table[index] == null){
                    System.out.println("Not found: " + name);
                    return null;
                }
                i++;
            }
        }
        return null;

    }

    /*
     needs to print in alpabetical order
     */
    @Override
    public void printSupportersOrdered() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null && !table[i].isDeleted()) {
                System.out.println("Words at position " + i + ": " + table[i].getName());
            }
        }
    }

    public double getLoadFactor() {
        loadFactor = ((double) size / (double) capacity);
        return loadFactor;
    }

    public void printLoadFactor(){
        DecimalFormat df = new DecimalFormat("0.00");
        String formatted = df.format(getLoadFactor());
        System.out.println("New load factor: " + formatted);
    }

    public void resize(){
        if (getLoadFactor() > 0.75) {
            System.out.println("****** Oh no! Load factor has exceeded 75%! We must rehash! **********");
            System.out.println("**************************** REHASHING *******************************");
            rehash();
        }
    }

    public void rehash() {
        Supporter[] oldTable = table;
        System.out.println("Previous capacity of table: " + capacity);
        capacity = oldTable.length * 2;
        System.out.println("New capacity of table: " + capacity);
        System.out.println();

        table = new Supporter[capacity];
        size = 0;

        for (int i = 0; i < oldTable.length; i++){
            if (oldTable[i] != null && !oldTable[i].isDeleted()){
                put(oldTable[i]);
            }

        }
    }

}
   