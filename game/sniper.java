package game;



public class sniper extends shooter {

    public sniper(int x, int y, int initiative) {
        super(x, y, initiative + 3, 7, 100, 1);
    }

    @Override
    public String getInfo() {
        return getName() + " ["+ coordinates.x + ", " + coordinates.y + "] HP: " + currentHealth + "/" + health + " " + state;
    }

    @Override
    String getName() {
        return num.sniper.getName();
    }
}
