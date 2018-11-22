/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supporter;

/**
 *
 * @author 18033862
 */
public class Supporter implements ISupporter, Comparable<Supporter>  {

    private String ID;
    private String name;
    private boolean deleted;
    
    public Supporter(String ID, String name) {
        this.ID = ID;
        this.name = name;
        this.deleted = false;
    }
    
    @Override
    public String getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setDeleted() {
        deleted = true;
    }

    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public int compareTo(Supporter supporter) {
        if (this.name.compareToIgnoreCase(supporter.getName()) < 0)
            return -1;
        if (this.name.compareToIgnoreCase(supporter.getName()) > 0)
            return 1;
        else return 0;
    }
}
