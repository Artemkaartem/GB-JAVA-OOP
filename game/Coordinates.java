package game;

import java.util.ArrayList;

public class Coordinates {
    int x, y;
    ArrayList<Integer> xy = new ArrayList<>();

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
        xy.add(x);
        xy.add(y);
    }

    public double countDistance(Coordinates coordinates) {
        int dx = coordinates.x - x;
        int dy = coordinates.y - y;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public void direction(Coordinates coordinates, ArrayList<units> list) {
        boolean[] temp = checkPos(list);
        float dx = Math.abs(this.x - coordinates.x);
        float dy = Math.abs(this.y - coordinates.y);
        if ((dx > dy)) {
            if (this.x < coordinates.x && !temp[0] && this.x + 1 != 11) {
                this.x += 1;
                System.out.printf("1 %s\n", this.getClass().getSimpleName());
                return;
            } else if (this.x > coordinates.x && !temp[1] && this.x - 1 != 0) {
                this.x -= 1;
                System.out.printf("2 %s\n", this.getClass().getSimpleName());
                return;
            }
            if (this.y <= coordinates.y && !temp[2] && this.y + 1 != 11) {
                this.y += 1;
                System.out.printf("3 %s\n", this.getClass().getSimpleName());
                return;
            } else if (this.y >= coordinates.y && !temp[3] && this.y - 1 != 0) {
                this.y -= 1;
                System.out.printf("4 %n", this.getClass().getSimpleName());
                return;
            }
        } else {
            if (this.y < coordinates.y && !temp[2] && this.y + 1 != 11) {
                this.y += 1;
                System.out.printf("1.1 %s\n", this.getClass().getSimpleName());
                return;
            } else if (this.y > coordinates.y && !temp[3] && this.y - 1 != 0) {
                this.y -= 1;
                System.out.printf("1.2 %s\n", this.getClass().getSimpleName());
                return;
            }
            if (this.x <= coordinates.x && !temp[0] && this.x + 1 != 11) {
                this.x += 1;
                System.out.printf("1.3 %s\n", this.getClass().getSimpleName());
                return;
            } else if (this.x >= coordinates.x && !temp[1] && this.x - 1 != 0) {
                this.x -= 1;
                System.out.printf("1.4 %s\n", this.getClass().getSimpleName());
                return;
            }
        }
    }
    public boolean[] checkPos(ArrayList<units> friends) {
        boolean[] temp = new boolean[4];
        for (units u : friends) {
            if ((u.coordinates.x == this.x + 1) && (u.coordinates.y == this.y))
                temp[0] = true;
            if ((u.coordinates.x == this.x - 1) && (u.coordinates.y == this.y))
                temp[1] = true;
            if ((u.coordinates.x == this.x) && (u.coordinates.y == this.y + 1))
                temp[2] = true;
            if ((u.coordinates.x == this.x) && (u.coordinates.y == this.y - 1))
                temp[3] = true;
        }
        return temp;
    }
}


