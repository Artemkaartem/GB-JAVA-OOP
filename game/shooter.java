package game;

import java.util.ArrayList;

public abstract class shooter extends units {
    public int attackRange;
    public int ammoAmount;
    public int timeToLoad;

    public shooter(int x,int y, int initiative, int attackRange, int ammoAmount, int timeToLoad) {
        super(x, y, 50, 50, 5, 1, initiative, true);

        this.attackRange = attackRange;
        this.ammoAmount = ammoAmount;
        this.timeToLoad = timeToLoad;
    }

    @Override
    public void step(ArrayList<units> team, ArrayList<units> list) {


        units tmp = findClosestEnemy(list);

        if (isAlive) {
            for (units unit: list) {
                if (unit instanceof peasant && unit.state == "Stand" && ammoAmount < 20 && this instanceof crossbowman) {
                    ammoAmount += 1;
                    unit.state = "Busy";
                    return;
                }
            }

            if ((int)coordinates.countDistance(tmp.coordinates) <= attackRange) {
                if (ammoAmount > 0 && attackRange != 1) {
                    if (attackRange == 1) tmp.getDamage(1);
                    else tmp.getDamage(damage);
                    ammoAmount -= 1;
                    state = "Attack";
                    return;
                } else {
                    attackRange = 1;
                    state = "->Melee";
                }
            } else {
                move(tmp.coordinates, list);
                state = "Moving";
                return;
            }
        }

        return;
    }

    public abstract String getInfo();
}
