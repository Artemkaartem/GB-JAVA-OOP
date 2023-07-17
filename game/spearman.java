package game;


public class spearman extends mag  {

    public spearman(int x, int y, int initiative) {
        super(x, y, initiative + 4, 10, 1, 1, 2);
    }
    @Override
    public String getInfo() {return getName() + " [" + coordinates.x + ", " + coordinates.y + "] HP:" + currentHealth + "/" + health + " " + state;}


    @Override
    String getName() {
        return num.spearman.getName();
    }
}
