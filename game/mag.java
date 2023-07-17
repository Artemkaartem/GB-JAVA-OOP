package game;

import java.util.ArrayList;

public abstract class mag extends  units{


    public int attacksAmount;
    public int attackRange;

    public mag(int x, int y, int initiative, int damage, int moveDistance, int attacksAmount, int attackRange) {
        super(x, y, 100, 100, damage, moveDistance, initiative, true);

        this.attacksAmount = attacksAmount;
        this.attackRange = attackRange;
    }

    @Override
    public void step(ArrayList<units> team, ArrayList<units> list) {
        if (!isAlive) return;

        units tmp = findClosestEnemy(team);

        if (coordinates.countDistance(tmp.coordinates) <= attackRange) {
            for (int i = 0; i < attacksAmount; i++) tmp.getDamage(damage);
            state = "Attack";
        } else {
            move(tmp.coordinates, list);
            state = "Moving";
        }


    }

    abstract String getInfo();
}
