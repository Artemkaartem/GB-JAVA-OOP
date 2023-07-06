package game;

import java.util.ArrayList;
import java.util.Random;


public class main {
    public static void main(String[] args) {
        ArrayList<units> units = new ArrayList<>();

        units.add(new wizard("wizard", 0 ,1));
        units.add(new monk("Monk", 0 , 3));
        units.add(new rogue("rogue", 0, 2));
        units.add(new spearman("Spearman", 0, 1));
        units.add(new sniper("Sniper", 0, 2));
        units.add(new crossbowman("Crossbowman", 0, 3 ));
        units.add(new peasant("Peasant", 0, 2));

        units.forEach(n -> System.out.println(n.name));

        ArrayList<units> list = new ArrayList<>();
        int teamCount = 7;
        for(int i = 0; i < 10; i++) {
            int val = new Random().nextInt(7);
            switch (val) {
                case 0 -> list.add(new crossbowman(0, val+1));
                case 1 -> list.add(new monk(0, val+1));
                case 2 -> list.add(new peasant(0, val+1));
                case 3 -> list.add(new rogue(0, val+1));
                case 4 -> list.add(new wizard(0, val+1));
                case 5 -> list.add(new sniper(0, val+1));
                case 6 -> list.add(new spearman(0, val+1));
            }
        }
            for(int i = 0; i < list.size(); i++){

                System.out.println(list.get(i).getInfo());
            }

        System.out.println("------------");
        ArrayList<units> team = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            int val = new Random().nextInt(7);
            switch (val) {
                case 0:
                    team.add(new monk(num.monk.getName(), 5, val+1));
                    break;
                case 1:
                    team.add(new sniper(num.sniper.getName(), 5, val+1));
                    break;
                case 2:
                    team.add(new crossbowman(num.crossbowman.getName(), 5, val+1));
                    break;
                case 3:
                    team.add(new rogue(num.rogue.getName(), 5, val+1));
                    break;
                case 4:
                    team.add(new peasant(num.peasant.getName(), 5, val+1));
                    break;
                case 5:
                    team.add(new wizard(num.wizard.getName(), 5, val+1));
                    break;
                case 6:
                    team.add(new spearman(num.spearman.getName(), 5, val+1));
                    break;

            }
            System.out.println(team.get(i).getInfo());
        }
        System.out.println("------------");
        list.forEach(n -> n.step(team));



    }
}