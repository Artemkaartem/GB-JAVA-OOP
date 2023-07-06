package game;

import java.util.ArrayList;

public class wizard extends units {

    public wizard(int x, int y) {
        super(100, 5, 30, 70, 30, "wizard", 7, x, y);
        
    }
    public wizard(String name, int x, int y ) {
        super(100, 5, 30, 70, 30, name, 7, x, y);
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
