package game;

import java.util.ArrayList;

public class  rogue extends mag{

    public rogue(int x, int y, int initiative) {
        super(x, y, initiative + 4, 5, 2, 2, 1);
    }
    @Override
    public String getInfo() {
        return getName() + " [" + coordinates.x + ", " + coordinates.y + "] HP: " + currentHealth + "/" + health + " " + state;
    }

    @Override
    String getName() {
        return num.rogue.getName();
    }
}
