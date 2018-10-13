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
public class Supporter implements ISupporter {

    private String ID;
    private String name;
    
    public Supporter(){
        
    }
    
    public Supporter(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }
    
    @Override
    public String getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }
    
    
    
}
