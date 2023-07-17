package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class main {

    public static ArrayList<units> list = new ArrayList<>();
    public static ArrayList<units> team = new ArrayList<>();
    public static ArrayList<units> allTeam = new ArrayList<>();


    public static void main(String[] args) {
        ArrayList<units> units = new ArrayList<>();

        units.add(new wizard(0, 1, 1, 0));
        units.add(new monk(0, 3, 3, 0));
        units.add(new rogue(0, 2, 2));
        units.add(new spearman(0, 1, 1));
        units.add(new sniper(0, 2, 2));
        units.add(new crossbowman(0, 3, 3));
        units.add(new peasant(0, 2, 2, 0));

        units.forEach(n -> System.out.println(n.name));

        int teamCount = 10;
        for (int i = 0; i < teamCount + 1; i++) {
            int val = new Random().nextInt(7);
            switch (val) {
                case 0:
                    list.add(new crossbowman(1, i, 2));
                    break;
                case 1:
                    list.add(new monk(1, i, 2, 2));
                    break;
                case 2:
                    list.add(new peasant(1, i, 2, 1));
                    break;
                case 3:
                    list.add(new rogue(1, i, 2));
                    break;
                case 4:
                    list.add(new wizard(1, i, 1, 3));
                    break;
                case 5:
                    list.add(new sniper(1, i, 2));
                    break;
                case 6:
                    list.add(new spearman(1, i, 3));
                    break;
            }
        }
        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i).getInfo());
        }

        System.out.println("------------");

        for (int i = 0; i < teamCount + 1; i++) {
            int val = new Random().nextInt(7);
            switch (val) {
                case 0:
                    team.add(new monk(10, i, 2, 1));
                    break;
                case 1:
                    team.add(new sniper(10, i, 3));
                    break;
                case 2:
                    team.add(new crossbowman(10, i, 2));
                    break;
                case 3:
                    team.add(new rogue(10, i, 2));
                    break;
                case 4:
                    team.add(new peasant(10, i, 2, 2));
                    break;
                case 5:
                    team.add(new wizard(10, i, 1, 1));
                    break;
                case 6:
                    team.add(new spearman(10, i, 1));
                    break;

            }
            System.out.println(team.get(i).getInfo());
        }

        allTeam.addAll(list);
        allTeam.addAll(team);
        allTeam.sort(game.units::compareTo);

        view.view();

        Scanner in = new Scanner(System.in);
        while (true) {
            in.nextLine();
            String massege = null;

            int init1 = 0;
            int init2 = 0;
            units tmpTeam1 = list.get(init1);
            units tmpTeam2 = team.get(init2);

            for (int k = 0; k < teamCount * 2; k++) {
                if ((tmpTeam1.initiative >= tmpTeam2.initiative && init1 < 10) || (tmpTeam1.initiative < tmpTeam2.initiative && init2 == 10)) {
                    tmpTeam1.step(team, list);
                    init1++;
                    if (init1 < 10) tmpTeam1 = list.get(init1);
                } else {
                    tmpTeam2.step(list, team);
                    init2++;
                    if (init2 < 10) tmpTeam2 = team.get(init2);
                }

                if (teamDead(list)) {
                    massege = "Team 2 win!";
                    break;
                }
                if (teamDead(team)) {
                    massege = "Team 1 win!";
                    break;
                }
                view.view();

                if (massege == "Team 2 win!" || massege == "Team 1 win!") {
                    System.out.println(massege);
                    break;
                }
            }
        }
    }

    public static boolean teamDead(ArrayList<units> list) {
        for (units unit: list) {
            if (unit.state != "Dead") {
                //System.out.println("alive");
                return false;
            }
        }

        return true;
    }
}