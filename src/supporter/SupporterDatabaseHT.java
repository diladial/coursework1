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

    //the default value of a space in the hashtable.
    //will be xxx if there is no value assigned to it
    String init = "xxx";

    //number of supporters in the hashtable
    int size = 0;
    String[] table;

    //constructor that takes in no params
    //makes an empty array with the default value 'xxx'
    public SupporterDatabaseHT() {
        table = new String[HTS];
        //a default value of xxx for an empty bucket
        for (int i = 0; i < HTS; i++) {
            table[i] = init;
        }
    }

    /*
     * Method used to add String's into the array
     */
    public void addValues(String[] list) {
        int hashValue = 0;
        int probe = 1;
        for (String string : list) {
            hashValue = hash(string);
            
            if (table[hashValue].equals("xxx")) {
                table[hashValue] = string;
                size++;
            }
            else
                hashValue = (hash(string) + probe) % HTS;
                table[hashValue] = string;
                probe++;
        }
    }

    /*
     a method to hash the given value in a string
     returning the position for the value
     to be used in the hashtable
     NOTE: STILL USES  A REALLY DUMB HASH!!
     */
    public int hash(String key) {
        return (int) key.charAt(0) % HTS;
    }

    

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsName(String name) {
        int key = hash(name);
        return table[key].equals(name);
    }

    @Override
    public Supporter get(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
     prints the table
     */
    public void printTable() {
        for (int i = 0; i < HTS; i++) {
            System.out.println("Words at position " + i + ": " + table[i]);
        }
    }

}
