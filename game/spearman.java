package game;

import java.util.ArrayList;

public class spearman extends units  {

    public spearman(int x, int y) {
        super(100, 5, 30, 0, 30, "spearman", 7, x, y);
    }

    public spearman(String name, int x, int y) {
        super(100, 5, 30, 0, 30, name, 7, x, y);
    }

    @Override
    String getInfo() {return super.getInfo();}

    @Override
    public void step(ArrayList<units> units) {
        units tmp = nearest(units);
        System.out.println(tmp.name + " " + coordinates.countDistance(tmp.coordinates));
    }
}
