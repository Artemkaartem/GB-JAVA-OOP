package game;

public class wizard extends human {

    public wizard(int x, int y, int initiative, int actionPriority) {
        super(x, y, initiative + 2, 100, 10, 3, actionPriority);
    }
    @Override
    public String getInfo() {
        return getName() +" [" + coordinates.x + ", " + coordinates.y + "] mana: " + manaPoints + "/" + 10 + " HP: " + currentHealth + "/" + health + " " + state;
    }

    @Override
    String getName() {
        return num.wizard.getName();
    }
}
