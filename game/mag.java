package game;

import java.util.ArrayList;

public abstract class mag extends  units{
    public mag(int health, int actionPoints, int defense, int mana, int demege, String name, int initiave, int x, int y) {
        super(health, actionPoints, defense, mana, demege, name, initiave, x, y);
    }

    @Override
    public void step(ArrayList<units> units, ArrayList<units> list) {
        if (!state.equals("dead")) {
            float min_XP = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                if ((float) (list.get(i).health / max_health) < min_XP) {
                    min_XP = (float) (list.get(i).health / max_health);
                    index = i;
                }
            }
            list.get(index).HP_demege(this.demege);
        }
    }
}
