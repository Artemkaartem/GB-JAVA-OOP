package game;

import java.util.ArrayList;

public class peasant extends units {

    public peasant(int x, int y) {
        super(100, 5, 25, 0, 30, "peasant", 7, x, y);
        
    }
    public peasant(String name, int x, int y) {
        super(100, 5, 25, 0, 30, name, 7, x ,y);
    }

    @Override
    String getInfo() {
        return super.getInfo();
    }

    @Override
    public void step(ArrayList<units> units) {
        units tmp = nearest(units);
        System.out.println(tmp.name + " " + coordinates.countDistance(tmp.coordinates));
    }
}
