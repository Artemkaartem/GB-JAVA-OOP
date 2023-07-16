package game;


import java.util.ArrayList;
import java.util.Random;

public abstract class units {



    public String state;
    public  int health;
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


    public  void HP_demege(int damage) {
        health -= damage;
        if (health < 1) {
            state = "dead";
            health = 0;
        }
        if (health > max_health) health = max_health;
    }

    public abstract void step(ArrayList<units> units);

    public abstract void step(ArrayList<units> units, ArrayList<units> list);
    public  ArrayList<Integer> getCoords() {

        return coordinates.xy;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + name + ", hp: " + health;
    }

    public int compareTo(Object o) {
        units unit = (units) o;
        return unit.initiave - this.initiave;
    }


    public void attack(units target, int damage, int maxDamage) {
        int causedDamage;
        if (damage < target.defense) causedDamage = damage;
        else {
            switch (new Random().nextInt(4)) {
                case 0:
                    causedDamage = maxDamage;
                    break;
                default:
                    causedDamage = damage;
                    break;
            }
        }
        target.HP_demege(causedDamage);
    }

}