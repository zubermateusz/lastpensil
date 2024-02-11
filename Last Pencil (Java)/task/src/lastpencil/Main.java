package lastpencil;

import java.util.ArrayList;
import java.util.List;
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
        int pencils = 0;
        while (pencils == 0) {
            try {
                pencils = Integer.parseInt(scanner.nextLine());// read how many pencils start
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
            }
            if (pencils == 0) {
                System.out.println("The number of pencils should be positive");
            }
        }

        List<String> playersNames = new ArrayList<>();// collection of players names
        playersNames.add("John");
        playersNames.add("Jack");

        int player1 = 2;// temporary set player1 to id not used
        System.out.println("Who will be the first (" + playersNames.get(0) + ", " + playersNames.get(0) + "):");
        while (player1 == 2) {
            switch (scanner.nextLine()) { // read who started
                case ("John") -> player1 = 0;
                case ("Jack") -> player1 = 1;
                default -> System.out.println("Choose between '" + playersNames.get(0) + "' and '" + playersNames.get(1) + "':");
            }
        }
        //start the game
        printPencils(pencils);// print pencils in one line

        while(pencils > 0) {
            System.out.println(playersNames.get(player1) + "'s turn:");
            int tempPencils = 0;
            do {
                try {
                    tempPencils = Integer.parseInt(scanner.nextLine());
                    if (tempPencils >= 1 && tempPencils <= 3) {
                        pencils -= tempPencils; // read how many pencils take player
                        printPencils(pencils);// print pencils in one line
                    } else {
                        System.out.println("Possible values: '1', '2' or '3'");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Possible values: '1', '2' or '3'");
                }
            } while (pencils == tempPencils);

            player1++; //select next player name
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
