package game;

public class monk extends human {

    public monk(int x, int y, int initiative, int actionPriority) {
        super(x, y, initiative + 2, 10, 5, 2, actionPriority);
    }

    @Override
    String getInfo() {
        return getName() +"[" + coordinates.x + ", " + coordinates.y + "] mana: " + manaPoints + "/" + 10 + " HP: " + currentHealth + "/" + health + " " + state;
    }

    @Override
    String getName() {
        return num.monk.getName();
    }
}

