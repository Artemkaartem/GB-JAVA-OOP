package game;

import java.util.ArrayList;

public abstract class human extends units{

    int stamina;
    int maxDemage;
    public human(int health, int actionPoints, int defense, int mana, int demege, String name, int initiave, int x, int y) {
        super(health, actionPoints, defense, mana, demege, name, initiave, x, y);
        this.stamina = stamina;
       this.maxDemage = maxDemage;
    }
/*
    @Override
    public void step(ArrayList<units> units, ArrayList<units> list) {

        if (this.health > 0) state = "stand";
    }*/

    @Override
    public void step(ArrayList<units> team, ArrayList<units> list) {
        if (this.stamina > 0 && this.health > 0) {
            units target = null;
            double minDistance = Double.MAX_VALUE;

            for (units unit : team) {
                if (this.coordinates.countDistance(coordinates) < minDistance && unit.health > 0) {
                    minDistance = this.coordinates.countDistance(coordinates);
                    target = unit;
                }
            }

            if (this.coordinates.countDistance(coordinates) >= 2) {
                this.coordinates.direction(target.coordinates, list);
            } else if (target.health > 0) {
                this.attack(target, this.demege, this.maxDemage);
                this.stamina--;
            }

        }
    }
}
