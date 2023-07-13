package game;

import java.util.ArrayList;

public abstract class shooter extends units {
    protected int arrows = 50;
    public shooter(int health, int actionPoints, int defense, int mana, int demege, String name, int initiave, int x, int y) {
        super(health, actionPoints, defense, mana, demege, name, initiave, x, y);
    }

    @Override
    public void step(ArrayList<units> units, ArrayList<units> list) {
// Если жизни 0 вернуть управление
        if (this.health == 0 || this.arrows == 0) return;
        // Если стрел 0 вернуть управление
        // Найти ближайшего противника
        units tmp = nearest(units);
        // Нанести ему среднее повреждение

        for (units unit:list) {
            if (unit.name.equals("Human")) {
                arrows++;
                break;
            }
        }
        tmp.HP_demege(this.demege);
        // уменьшить кол-во стрел на одну и вернуть управление
        arrows -= 1;
        return;
    }
    @Override
    public String getInfo() {
        return String.format("name:%s hp:%d arrows:%d", name, health, arrows);
    }
}
