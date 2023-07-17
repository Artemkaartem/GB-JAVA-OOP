package game;


public class crossbowman extends shooter {

    public crossbowman(int x, int y, int initiative) {
        super(x, y, initiative + 3, 5, 20, 0);
    }


    @Override
    public String getInfo() {
        return getName() + " [" + coordinates.x + ", " + coordinates.y + "] arrows: " + ammoAmount + " HP: " + currentHealth + "/" + health + " " + state;
    }

    @Override
    String getName() {
        return num.crossbowman.getName();
    }
}