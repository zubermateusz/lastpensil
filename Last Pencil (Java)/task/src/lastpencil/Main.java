package lastpencil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void printPencils(int pencils) {
        while (pencils > 0) {
            System.out.print("|");
            pencils--;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("How many pencils would you like to use:"); // ask user
        Scanner scanner = new Scanner(System.in);
        int pencils = scanner.nextInt();// read how many pencils start

        List<String> playersNames = new ArrayList<>();// collection of players names
        playersNames.add("John");
        playersNames.add("Jack");

        System.out.println("Who will be the first (John, Jack)");
        scanner.nextLine(); // read line after int
        int player1 = 0;

        switch (scanner.nextLine()) { // read who started
            case ("John"): {
                player1 = 0;
                break;
            }
            case ("Jack"): {
                player1 = 1;
                break;
            }
        }

        //start the game
        printPencils(pencils);// print pencils in one line

        while(pencils > 0) {
            System.out.println(playersNames.get(player1) + "'s turn:");
            pencils -= scanner.nextInt(); // read how many pencils take player
            printPencils(pencils);// print pencils in one line
            player1++;
            if (player1 >= playersNames.size()) {
                player1 = 0; // change on list[0]
            }
        }
        //Random random = new Random();
        //int pencils = random.nextInt(7);
        /*printPencils(pencils); // print pencils in one line
        System.out.println();
        System.out.println(player1 + " is going first!");*/

    }




}
