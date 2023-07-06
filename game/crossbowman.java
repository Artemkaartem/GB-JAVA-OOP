package game;

import java.util.ArrayList;

public class crossbowman extends units {

    public crossbowman(int x, int y) {
        super(100, 5, 30, 0, 25, "crossbowman", 7,x,y);
        
    }
    public crossbowman(String name,int x, int y ) {
        super(100, 5, 30, 0, 25, name, 7, x , y);
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
