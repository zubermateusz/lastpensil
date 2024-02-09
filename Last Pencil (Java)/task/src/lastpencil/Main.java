package lastpencil;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("How many pencils would you like to use:"); // ask user
        Scanner scanner = new Scanner(System.in);
        int pencils = scanner.nextInt();// read how many pencils
        System.out.println("Who will be the first (John, Jack)");
        String player1 = scanner.nextLine(); // read line after int
        player1 = scanner.nextLine();
        //Random random = new Random();
        //int pencils = random.nextInt(7);
        while (pencils > 0) {
            System.out.print("|");
            pencils--;
        }
        System.out.println();
        System.out.println(player1 + " is going first!");

    }
}
