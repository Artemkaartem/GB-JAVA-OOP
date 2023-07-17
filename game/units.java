package game;


import java.util.ArrayList;

public abstract class units {
    public int[] position;
    public int currentHealth;
    public int health;
    public int damage;
    public int moveDistance;

    public int initiative;
    public String name;
    public boolean isAlive;
    public String state = "Stand";

    Coordinates coordinates;

    public units(int x, int y, int currentHealth, int health, int damage, int moveDistance, int initiative, boolean isAlive) {
        coordinates = new Coordinates(x, y);
        this.currentHealth  = currentHealth;
        this.health = health;
        this.damage = damage;
        this.moveDistance = moveDistance;
        this.initiative = initiative;
        this.isAlive = isAlive;
        this.name= name;
    }


    public void move(Coordinates targetPosition, ArrayList<units> allys) {
        if (!coordinates.containsByPos(coordinates.newPosition(targetPosition, allys), allys)) {
            for (int i = 0; i < moveDistance; i++) {
                coordinates = coordinates.newPosition(targetPosition, allys);
            }
        }

    }

    public units findClosestEnemy(ArrayList<units> units) {
        double minDistance = Double.MAX_VALUE;
        units closestEnemy = null;

        for (int i = 0; i < units.size(); i++) {
            if (coordinates.countDistance(units.get(i).coordinates) < minDistance && units.get(i).isAlive) {
                closestEnemy = units.get(i);
                minDistance = coordinates.countDistance(units.get(i).coordinates);
            }
        }

        return closestEnemy;
    }

    public abstract void step(ArrayList<units> team, ArrayList<units> list);

    String getName(){
        return this.name;
    }

    String getInfo() {
        return  this.name;
    }
    public  int getHp() {
        return this.health;
    }


    public void getDamage(int damage) {
        currentHealth -= damage;

        if (currentHealth <= 0) {
            currentHealth = 0;
            isAlive = false;
            state = "Dead";
        }

        if (currentHealth >= health) currentHealth = health;
    }

    public int compareTo(Object o) {
        units unit = (units) o;
        return unit.initiative - this.initiative;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + name + ", hp: " + health;
    }
}
