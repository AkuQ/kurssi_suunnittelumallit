
package builder;

public class Burger {
    private String buns, patty, condiment, filling;
    
    public Burger(){
        this.buns = "";
        this.patty = "";
        this.filling = "";
        this.condiment = "";
    }
    
    public Burger(String buns, String patty, String filling, String condiment){
        this.buns = buns;
        this.patty = patty;
        this.filling = filling;
        this.condiment = condiment;
    }
    
    public void setBuns(String buns){
        this.buns = buns;
    }
    
    public void setPatty(String patty){
        this.patty = patty;
    }
    
    public void setFilling(String filling){
        this.filling = filling;
    }
    
    public void setCondiment(String condiment){
        this.condiment = condiment;
    }
    
    @Override
    public String toString(){
        String str = "a " + (this.buns + " " + this.patty).trim() 
                + " burger with " + this.condiment + ", " + this.filling;
        return str;
    }
}
