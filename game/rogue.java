package game;

import java.util.ArrayList;

public class  rogue extends units{

    public rogue(int x, int y) {
        super(100, 5, 30, 0, 15, "rogue", 7, x, y);
        
    }
    public rogue(String name, int x, int y) {
        super(100, 5, 30, 0, 15, name, 7, x, y);
    }

    @Override
    public String getInfo() {
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
