package game;

import java.util.ArrayList;

public  class peasant extends human {

    public peasant(int x, int y, int initiative, int actionPriority) {
        super(x, y, initiative, 0, 0, 1, actionPriority);
    }

    @Override
    public String getInfo() {
        return getName() + " [" + coordinates.x + ", " + coordinates.y + "] HP:" + currentHealth + "/" + health + " " + state;
    }
    @Override
    public void step(ArrayList<units> team, ArrayList<units> list) {
        if (isAlive) {
            if (state == "Busy") {
                state = "Stand";
            }
        }
    }

    @Override
    String getName() {
        return num.peasant.getName();
    }
}
