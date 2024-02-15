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
        int pencils = 0;
        while (pencils == 0) {// read correct count of pencils from user
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
        System.out.println("Who will be the first (" + playersNames.get(0) + ", " + playersNames.get(1) + "):");
        while (player1 == 2) {// read correct name of player from user
            switch (scanner.nextLine()) { // read who started
                case ("John") -> player1 = 0;
                case ("Jack") -> player1 = 1;
                default -> System.out.println("Choose between '" + playersNames.get(0) + "' and '" + playersNames.get(1) + "'");
            }
        }

        //start the game
        printPencils(pencils);// print pencils in one line

        for(;pencils > 0;) {
            System.out.println(playersNames.get(player1) + "'s turn!");
            int tempPencils = pencils;
            for(;;) {
                try {
                    if (player1 == 1) {
                        if (pencils == 1) {tempPencils = 1;
                            System.out.println(tempPencils);}
                        else {
                            if (pencils % 4 == 0) {
                                tempPencils = 3;
                                System.out.println(tempPencils);
                            } //4,8,12,16,...
                            if ((pencils + 1) % 4 == 0) {
                                tempPencils = 2;
                                System.out.println(tempPencils);
                            } // 3,7,11,15,...
                            if ((pencils + 2) % 4 == 0) {
                                tempPencils = 1;
                                System.out.println(tempPencils);
                            } //2,6,10,14,...
                            if ((pencils - 1) % 4 == 0) {
                                tempPencils = new Random().nextInt(3) + 1;
                                System.out.println(tempPencils);// 5,9,13,17,...
                            }
                        }


                    }
                    else {
                        tempPencils = Integer.parseInt(scanner.nextLine());
                    }


                    if (tempPencils >= 1 && tempPencils <= 3) {
                        if (tempPencils > pencils) {
                            System.out.println("Too many pencils were taken");
                            continue;
                        }
                        pencils -= tempPencils; // read how many pencils take player
                        if (pencils == 0) { // player lost
                            player1++; //select next player name who won
                            if (player1 >= playersNames.size()) {
                                player1 = 0; // change on list[0]
                            }

                            System.out.println(playersNames.get(player1) + " won!");
                            break;

                        } else {
                            printPencils(pencils);// print pencils in one line
                            break;
                        }
                    } else {
                        throw new NumberFormatException(); // if tempPencils != 1,2,3
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Possible values: '1', '2' or '3'");
                }
            }

            player1++; //select player name for round
            if (player1 >= playersNames.size()) {
                player1 = 0; // change on list[0]
            }
        }



    }
}
