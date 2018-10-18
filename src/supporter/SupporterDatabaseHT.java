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
        int g = 3;
        int hash = 0;
        for (int i = 0; i < key.length(); i++){
            hash = g * (hash + key.charAt(i));
        }
        return hash % HTS;
    }
    
    public int probe(int i){
        return i*i;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    /*
     returns a boolean if the name is found in hashtable
     - get name - hashes - if not found in key, then probe - then look again
     */
    public boolean containsName(String name) {
        int key = hash(name);
        int probe = 1;
        
        /* second attempt
        if (table[key].getName().equals(name)) {
                return true;
            }
        
        else {
            key = (key + probe) % HTS;
            return false;
        }
        */
        

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
        return table[key];
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
        int hash = hash(name);
        int probe = 0;
        
        //when i = 0
        if (table[hash] == null) {
        table[hash] = supporter;
        size++;
        return null;
        }
        
        probe = hash + 1;
        
        while (probe != hash) {
            
            if (table[probe] == null){
                table[probe] = supporter;
                size++;
                return null;
            }
                
            else {
                probe = probe + 1;
            }
            if (probe == HTS)
                probe = 0;
            System.out.println(probe);
        }
        
        /*
        //when i > 0
        int i = 1;
        //while the spot is taken
        while (table[hash] != null) { 
            //add the probe to the current space
            newKey  = ((hash + i*i) % HTS); 
            newKey = 2;
            //look in the new space if its filled or not
            if (table[newKey] != null){
                //assign it a new supporter
                table[newKey] = supporter;
            }
            //if the spot is filled, i++
            i++;
            System.out.println(i);
        }
        return null;
        */
        /**
         if (table[hash] != null) {
            
            Supporter oldSupporter = table[hash];
            table[hash] = supporter;
            
            size++;
            size--;
            return oldSupporter;
        }
        return null;
        * **/return null;
    }

    @Override
    public Supporter remove(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
     needs to print in apphabetical order
     */
    @Override
    public void printSupportersOrdered() {
        for (int i = 0; i < HTS; i++) {
            if (table[i] != null) {
                System.out.println("Words at position " + i + ": " + table[i].getName());
            }
        }
    }

}
   