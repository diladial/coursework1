/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supporter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 18033862
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

    SupporterDatabaseHT() {
        table = new Supporter[capacity];
        clear();
    }


    private int hash(String key) {
        int y = 3;
        int hash = 0;
        for (int i = 0; i < key.length(); i++){
            hash = y * (hash + key.charAt(i));
        }
        hash = hash % capacity;
        if (hash < 0){
            hash = capacity + hash;
        }
        return hash;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean containsName(String name) {
        int index = hash(name);
        int i = 1;
        System.out.println("Trying containsName() on " + name);
        if (table[index] == null) {
            System.out.println("Name " + name + " is not in table.");
            System.out.println();
            return false;
        }
        if (table[index].getName().equals(name) && !table[index].isDeleted()) {
            System.out.println("The table contains name " + name);
            return true;
        }
        if (table[index] != null) {
            while (table[index] != null && !table[index].getName().equals(name)) {
                if (table[index] == null) { //no name has been found
                    System.out.println("Name " + name + " is not in table.");
                    System.out.println();
                    return false;
                }
                System.out.println("Clash  in trying containsName() on " + name);
                int newIndex;

                if (isOdd(i))
                    newIndex = (index + i*i) % capacity;
                else
                    newIndex = (index - i*i) % capacity;

                if (newIndex < 0) {
                    index = capacity  + newIndex;
                } else { //if newIndex==0 or newIndex > 0
                    index = newIndex;
                }

                if (table[index] != null) {
                    if (table[index].getName().equals(name) && !table[index].isDeleted()) {
                        System.out.println("The table contains name " + name);
                        System.out.println();
                        return true;
                    }
                    i++;
                }
            }
        }
        return false;
    }

    @Override
    public Supporter get(String name) {
        int index = hash(name);
        int i = 1;
        if (table[index] == null) {
            System.out.println("Supporter " + name + " not found");
            System.out.println();
            return null;
        }
        else if (table[index].getName().equals(name) && !table[index].isDeleted()) {
            System.out.println("Supporter " + name + " found with ID " + table[index].getID());
            System.out.println();
            return table[index];
        }
        else {
            while (!table[index].getName().equals(name)) {
                System.out.println("Clash in trying to locate " + name + " at index " + index);

                int newIndex;

                if (isOdd(i))
                    newIndex = (index + i*i) % capacity;
                else
                    newIndex = (index - i*i) % capacity;

                if (newIndex < 0) {
                    index = capacity  + newIndex;
                } else { //if newIndex==0 or newIndex > 0
                    index = newIndex;
                }

                if (table[index] != null) {

                    if (table[index].getName().equals(name) && !table[index].isDeleted()) {
                        System.out.println("Supporter " + name + " found with ID " + table[index].getID() + " at index "+ index);
                        System.out.println();
                        return table[index];
                    }
                }
                if (table[index] == null){
                    System.out.println("Supporter " + name + " not found");
                    return null;
                }
                i++;
            }
        }
        return null;
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
            System.out.println("Previous hash table size: " + size());
            table[index] = supporter;
            size++;
            System.out.println("Supporter added: " + supporter.getName() + ", with index " + index);
            System.out.println("New hash table size: " + size());
            printLoadFactor();
            System.out.println();
            resize();
        }


        else
            while (table[index] != null){
                System.out.println("Clash detected! Index is at: " + index);
                int newIndex;
                if (isOdd(i))
                    newIndex = (index + i*i) % capacity;
                 else
                    newIndex = (index - i*i) % capacity;

                 if (newIndex < 0) {
                     index = capacity + newIndex;
                 } else {
                     index = newIndex;
                 }
                if (table[index] == null) {
                    System.out.println("Found an empty space! Index is now at: " + index);
                    System.out.println("Previous hash table size: " + size());
                    table[index] = supporter;
                    size++;
                    System.out.println("Supporter added: " + supporter.getName() + ", with index " + index);
                    System.out.println("New hash table size: " + size());
                    printLoadFactor();
                    System.out.println();
                    resize();
                    return supporter;
                }
                i++;
            }
            return null;
    }

    private boolean isOdd(int i){
        return i % 2 != 0;
    }

    @Override
    public Supporter remove(String name) {
        System.out.println("Removing supporter " + name + "...");
        int index = hash(name);
        int i = 1;
        if (table[index] == null) {
            System.out.print("Supporter ");
            System.out.println("Supporter " + name + " not found, and not removed");
            System.out.println();
            return null;
        }

        else if (table[index].getName().equals(name) && !table[index].isDeleted()) {
            table[index].setDeleted();
            System.out.println("Supporter " + name + " is 'removed' from index " + index +"!");
            size--;
            System.out.println("New hash table size: " + size());
            printLoadFactor();
            System.out.println();
            return table[index];
        }
        else {
            while (!table[index].getName().equals(name)) {
                System.out.println("Clash  in trying get() on " + name);
                int newIndex;
                if (isOdd(i))
                    newIndex = (index + i*i) % capacity;
                else
                    newIndex = (index - i*i) % capacity;

                if (newIndex < 0) {
                    index = capacity + newIndex;
                } else { //if newIndex==0 or newIndex > 0
                    index = newIndex;
                }

                if (table[index] == null){
                    System.out.println("Not found: " + name);
                    return null;
                } else if (table[index].getName().equals(name) && !table[index].isDeleted()){
                    table[index].setDeleted();
                    System.out.println("Supporter " + name + " is 'removed' from index " + index + "!");
                    System.out.println("New hash table size: " + size());
                    printLoadFactor();
                    System.out.println();
                    size--;
                    return table[index];
                }
                i++;
            }
        }
        return null;

    }

    @Override
    public void printSupportersOrdered() {
        System.out.println("********** Printing supporters in hash table ***********");
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null && !table[i].isDeleted()) {
                System.out.println("Supporter at index " + i + ": " + table[i].getName());
            }
        }
        List<Supporter> supporters = new ArrayList<>();

        for (Supporter supporter : table){
            if (supporter != null)
            supporters.add(supporter);
        }
        Collections.sort(supporters);
        System.out.println();
        System.out.println("*********** Supporters in alphabetical order  **********");
        for (Supporter sup : supporters) {
            if (!sup.isDeleted())
            System.out.println("Supporter " + sup.getName() +  " with ID " + sup.getID());
        }
        System.out.println("******************* End of hash table  *****************");
        System.out.println("Size of hash table is: " + size());
        System.out.println("Capacity of hash table is: " + capacity);
        System.out.println("Load factor of hash table is " + formatLoadFactor());
        System.out.println();
    }

    private double getLoadFactor() {
        loadFactor = ((double) size / (double) capacity);
        return loadFactor;
    }

    private void printLoadFactor(){
        DecimalFormat df = new DecimalFormat("0.00");
        String formatted = df.format(getLoadFactor());
        System.out.println("Load factor of the hash table is: " + formatted);
    }

    private String formatLoadFactor(){
        DecimalFormat df = new DecimalFormat("0.00");
        String formatted = df.format(getLoadFactor());
        return formatted;
    }

    private void resize(){
        if (getLoadFactor() > 0.50) {
            System.out.println("****** Oh no! Load factor has exceeded 0.50! We must rehash! **********");
            System.out.println("**************************** REHASHING *******************************");
            rehash();
        }
    }

    private void rehash() {
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
   