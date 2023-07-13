package game;


import java.util.ArrayList;

public abstract class units {

    public static int getHp;
    public String state;
    public int health;
    public int actionPoints;
    public int defense;
    public int mana;
    public int demege;
    public String name;
    public int initiave;

    public int max_health;

    Coordinates coordinates;

    public units(int health, int actionPoints, int defense, int mana, int demege, String name, int initiave, int x, int y) {
        this.health = health;
        this.actionPoints = actionPoints;
        this.defense = defense;
        this.mana = mana;
        this.demege = demege;
        this.name = name;
        this.initiave = initiave;
        coordinates = new Coordinates(x, y);
        this.state = "stand";
        this.max_health = max_health;
    }

    public boolean hasAP() {
        if (actionPoints > 0) {
            return true;
        } else return false;
    }


    String getInfo() {
        return  this.name;
    }
    public  int getHp() {
        return this.health;
    }

    public units nearest(ArrayList<units> units) {
        double nearestDistance = Double.MAX_VALUE;
        units nearestEnemy = null;
        for (int i = 0; i < units.size(); i++) {
            if (coordinates.countDistance(units.get(i).coordinates) < nearestDistance) {
                nearestEnemy = units.get(i);
                nearestDistance = coordinates.countDistance(units.get(i).coordinates);
            }
        }
        return nearestEnemy;
    }


    public abstract void step(ArrayList<units> units);

    public  void HP_demege(int damage) {
        health -= damage;
        if (health < 1) {
            state = "dead";
            health = 0;
        }
        if (health > max_health) health = max_health;
    }

    public abstract void step(ArrayList<units> units, ArrayList<units> list);
    public  ArrayList<Integer> getCoord() {
        return coordinates.xy;
    }

    public static double[] getCoords() {
        ArrayList<Double> doub = new ArrayList<>();
        return getCoords();
    }
}