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
public class SupporterDatabaseHT implements ISupporterDatabase {

    //hash table size
    final int HTS = 10;

    //number of supporters in the hashtable
    int size = 0;
    Supporter[] table;

    //load factor
    double loadFactor = 0;

    //constructor that takes in no params
    public SupporterDatabaseHT() {
        table = new Supporter[HTS];
        //a default value of xxx for an empty bucket
        for (int i = 0; i < HTS; i++) {
            table[i] = null;
        }
    }

    /*
     a method to hash the given value in a string
     returning the position for the value
     to be used in the hashtable
     NOTE: STILL USES  A REALLY DUMB HASH!!
     */
    public int hash(String key) {
        //return (int) key.charAt(3) % HTS;
        int y = 7;
        int hash = 0;
        for (int i = 0; i < key.length(); i++){
            hash = y * (hash + key.charAt(i));
        }
        return hash % HTS;
    }
    
    public int probe(int i){
        return i*i;
    }

    @Override
    public void clear() {
        table = new Supporter[HTS];
    }

    @Override
    /*
     returns a boolean if the name is found in hashtable
     - get name - hashes - if not found in key, then probe - then look again
     */
    public boolean containsName(String name) {
        int key = hash(name);
        int probe = 1;

        while (table[key] != null) {

            if (table[key].getName().equals(name)) {
                return true;

            } else {

                key = (key + probe) % HTS;

                if (table[key] != null && table[key].getName().equals(name)) {
                    return true;
                } else {
                    probe++;
                }
            }
        }
        return false;
        
    }

    @Override
    public Supporter get(String name) {
        int key = hash(name);
        int probe = 0;
        if (table[key].getName().equals(name))
                return table[key];
        else {
            probe = key + 1;
            
            while (probe != key){
                if (table[probe].getName().equals(name))
                    return table[probe];
                else
                    probe++;
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
        int key = hash(name);
        int probe = 0;

        if (table[key] == null) {
        table[key] = supporter;
        size++;
        System.out.println(getLoadFactor());
        return null;
        }
        
        probe = key + 1;
        
        while (probe != key) {
            
            if (table[probe] == null){
                table[probe] = supporter;
                System.out.println(getLoadFactor());
                size++;
                return supporter;
            }
                
            else {
                probe = probe + 1;
            }
            if (probe == HTS)
                probe = 0;
            System.out.println(probe);
        }

        return supporter;
    }

    @Override
    public Supporter remove(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
     needs to print in alpabetical order
     */
    @Override
    public void printSupportersOrdered() {
        for (int i = 0; i < HTS; i++) {
            if (table[i] != null) {
                System.out.println("Words at position " + i + ": " + table[i].getName());
            }
        }
    }

    public double getLoadFactor() {
        loadFactor = ((double) size / (double) HTS);
        return loadFactor;
    }

}
   