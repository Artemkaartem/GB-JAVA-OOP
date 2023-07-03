package game;

import java.util.ArrayList;
import java.util.Random;


public class main {
    public static void main(String[] args) {
        ArrayList<units> units = new ArrayList<>();

        units.add(new wizard("wizard"));
        units.add(new monk("Monk"));
        units.add(new rogue("rogue"));
        units.add(new spearman("Spearman"));
        units.add(new sniper("Sniper"));
        units.add(new crossbowman("Crossbowman"));
        units.add(new peasant("Peasant"));

        units.forEach(n -> System.out.println(n.name));

        ArrayList<units> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            int val = new Random().nextInt(7);
            switch (val) {
                case 0 -> list.add(new crossbowman());
                case 1 -> list.add(new monk());
                case 2 -> list.add(new peasant());
                case 3 -> list.add(new rogue());
                case 4 -> list.add(new wizard());
                case 5 -> list.add(new sniper());
                case 6 -> list.add(new spearman());
            }
        }
            for(int i = 0; i < list.size(); i++){

                System.out.println(list.get(i).getInfo());
            }
        }
}