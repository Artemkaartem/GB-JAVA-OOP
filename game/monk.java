package game;

import java.util.ArrayList;

public class monk extends units {

    public monk(int x, int y) {
        super(100, 5, 30, 0, 30, "monk", 7, x, y);
        
    }
    public monk(String name, int x, int y) {
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

    @Override
    public void step(ArrayList<units> units, ArrayList<units> list) {
        units tmp = nearest(units);
    }
}
