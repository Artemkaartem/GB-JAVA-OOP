package game;

import java.util.ArrayList;

public abstract class human extends units{

    public human(int health, int actionPoints, int defense, int mana, int demege, String name, int initiave, int x, int y) {
        super(health, actionPoints, defense, mana, demege, name, initiave, x, y);
    }

    @Override
    public void step(ArrayList<units> units, ArrayList<units> list) {

        if (this.health > 0) state = "stand";
    }
}
