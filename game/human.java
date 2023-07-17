package game;

import java.util.ArrayList;

public abstract class human extends units {

    public int manaPoints;
    public int magicDamage;
    public int attackRange;
    public int actionPriority;

    public human(int x, int y, int initiative, int manaPoints, int magicDamage, int attackRange, int actionPriority) {
        super(x, y, 70, 70, 5, 1, initiative, true);

        this.manaPoints = manaPoints;
        this.magicDamage = magicDamage;
        this.attackRange = attackRange;
        this.actionPriority = actionPriority;
    }

    abstract String getInfo();

    @Override
    public void step(ArrayList<units> team, ArrayList<units> list) {
        units tmp = findClosestEnemy(team);

        if ((int) coordinates.countDistance(tmp.coordinates) <= attackRange) {
            if (manaPoints > 0) {
                tmp.getDamage(damage);
                manaPoints -= 1;
                state = "Attack";
            } else {
                manaPoints += 1;
                state = "Busy";
            }
        } else {
            move(tmp.coordinates, list);
            state = "Moving";
        }

    }
}
