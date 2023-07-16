package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class main {

   public static ArrayList<units> list = new ArrayList<>();
    public static ArrayList<units> team = new ArrayList<>();
   public static ArrayList<units> allTeam = new ArrayList<>();


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

        int teamCount = 10;
        for(int i = 0; i < teamCount + 1; i++) {
            int val = new Random().nextInt(7);
            switch (val) {
                case 0 : list.add(new crossbowman(num.crossbowman.getName(),1, i));
                    break;
                case 1 : list.add(new monk(num.monk.getName(),1, i));
                    break;
                case 2 : list.add(new peasant(num.peasant.getName(),1, i));
                    break;
                case 3 : list.add(new rogue(num.rogue.getName(),1, i));
                    break;
                case 4 : list.add(new wizard(num.wizard.getName(),1, i));
                    break;
                case 5 : list.add(new sniper(num.sniper.getName(),1, i));
                    break;
                case 6 : list.add(new spearman(num.spearman.getName(),1, i));
                    break;
            }
        }
            for(int i = 0; i < list.size(); i++){

                System.out.println(list.get(i).getInfo());
            }

        System.out.println("------------");

        for (int i = 0; i < teamCount + 1; i++) {
            int val = new Random().nextInt(7);
            switch (val) {
                case 0:
                    team.add(new monk(num.monk.getName(), 10, i));
                    break;
                case 1:
                    team.add(new sniper(num.sniper.getName(), 10, i));
                    break;
                case 2:
                    team.add(new crossbowman(num.crossbowman.getName(), 10, i));
                    break;
                case 3:
                    team.add(new rogue(num.rogue.getName(), 10, i));
                    break;
                case 4:
                    team.add(new peasant(num.peasant.getName(), 10, i));
                    break;
                case 5:
                    team.add(new wizard(num.wizard.getName(), 10, i));
                    break;
                case 6:
                    team.add(new spearman(num.spearman.getName(), 10, i));
                    break;

            }
            System.out.println(team.get(i).getInfo());
        }
        System.out.println("------------");
        //list.forEach(n -> n.step(team));

        System.out.println("------------");

        System.out.println("Team1: ");
        list.forEach(n-> System.out.println(n.getInfo()));

        System.out.println("------------");

        System.out.println("Team2: ");
        team.forEach(n-> System.out.println(n.getInfo()));

        list.forEach(n-> n.step(team, list));
        team.forEach(n-> n.step(list, team));

        System.out.println("------------");

        System.out.println("Team1 урон: ");
        list.forEach(n-> System.out.println(n.getInfo() + " " + new Random().nextInt(n.demege)));

        System.out.println("------------");

        System.out.println("Team2 урон: ");
        team.forEach(n-> System.out.println(n.getInfo() + " " + new Random().nextInt(n.demege)));

        allTeam.addAll(list);
        allTeam.addAll(team);
        allTeam.sort(game.units::compareTo);

        Scanner in = new Scanner(System.in);
        while(true) {
            view.view();
            in.nextLine();
            for (units units1 : allTeam) {
                if (team.contains(units1)) units1.step(list, team);
                else units1.step(team, list);
            }
            if (isTeamDie(list)) {
                System.out.println("Team 2 (Blue) win");
                break;
            }
            if (isTeamDie(team)) {
                System.out.println(("Team 1 (Green) win"));
                break;
            }
        }
    }
    static boolean isTeamDie(ArrayList<units> team) {
        for (units units1: team) {
            if (!units1.equals("dead")) return false;
        }
        return true;
    }
}