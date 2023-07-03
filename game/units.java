package game;


public class units {
    
    public int health;
    public int actionPoints;
    public int defense;
    public int mana;
   // public boolean heveMana;
    public int demege;
    public String name;
    public int initiave;

    public units(int health, int actionPoints, int defense, int mana,int demege, String name, int initiave) {
        this.health = health;
        this.actionPoints = actionPoints;
        this.defense = defense;
        this.mana = mana;
       // this.heveMana = heveMana;
        this.demege = demege;
        this.name = name;
        this.initiave = initiave;
    }


    public boolean hasAP(){
        if(actionPoints > 0){
            return true;
        }
        else return false;
    }


    String getInfo(){
        return  this.name;
    }

    
    public void step() {

    }
}
