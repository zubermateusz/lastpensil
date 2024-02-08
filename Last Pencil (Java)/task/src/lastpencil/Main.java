package lastpencil;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int licznik = random.nextInt(7);
        while (licznik > 0) {
            System.out.print("|");
            licznik--;
        }
        System.out.println();
        System.out.println("Your turn!");

    }
}
