/***********************************************************************************************************************
 * @file  BlackJack.java
 * @brief This is a game of black jack, it generates the numbers, calculates the total and determines who wins
 * @author Heba Beshai
 * @date   February 24, 2016
 ***********************************************************************************************************************/
import java.util.Random;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int largestInt;
        int smallestInt;
        int randInt1;
        largestInt = 11;
        smallestInt = 1;
        int card = 0;
        int counter = 0;
        int totalscore;
        totalscore = 0;
        String ans;
        int dealerscore;
        dealerscore = 0;
        String repeatgame = "y";


        System.out.println("============================================================");
        System.out.println("                       Black Jack Table                     ");
        System.out.println("============================================================");
        while(repeatgame.equals("Y")||repeatgame.equals("y")) {
            System.out.println();
            System.out.println("Player's turn");
            System.out.println();
            randInt1 = rand.nextInt(largestInt - smallestInt + 1) + smallestInt;
            System.out.print("card: " + randInt1);
            totalscore = totalscore + randInt1;
            System.out.println("   current score: " + totalscore);
            System.out.print("Hit me again (Y) I'm Done (N):");
            ans = input.next();


            while (ans.equals("y")) {
                randInt1 = rand.nextInt(largestInt - smallestInt + 1) + smallestInt; // generates rand int between 1 & 11
                System.out.print("card:  " + randInt1);                              //prints the random int for card
                totalscore = totalscore + randInt1;                                  //adds the cards printed
                if (totalscore > 21) {
                    System.out.println("   current score: " + totalscore);
                    System.out.print("Player's final score is " + totalscore);
                    break;
                }
                System.out.println("  current score: " + totalscore);               //prints the total score
                counter++;
                System.out.print("Hit me again (Y) I'm Done (N):");
                ans = input.next();

            }
            if (ans.equals("N")) {
                System.out.println("Player's final score:" + totalscore);
                System.out.println();
                System.exit(0);

            }
            System.out.println();
            System.out.println();
            System.out.println("Dealers Turn ");
            randInt1 = rand.nextInt(largestInt - smallestInt + 1) + smallestInt;
            System.out.print("card: " + randInt1);
            dealerscore = dealerscore + randInt1;
            System.out.println("   current score: " + dealerscore);
            while (dealerscore <= 17) {
                randInt1 = rand.nextInt(largestInt - smallestInt + 1) + smallestInt;
                System.out.print("card:  " + randInt1);
                dealerscore = dealerscore + randInt1;
                System.out.println("   current score: " + dealerscore);
            }
            randInt1 = rand.nextInt(largestInt - smallestInt + 1) + smallestInt;
            System.out.print("card:  " + randInt1);
            dealerscore = dealerscore + randInt1;
            System.out.println("   current score: " + dealerscore);

                System.out.print("Dealer's final score is " + dealerscore);
                System.out.println();




            if ((dealerscore <= 21) && (totalscore > 21)) {
                System.out.println("Dealer Wins!");
            }
            if ((dealerscore > 21) && (totalscore <= 21)) {
                System.out.println("Player Wins!");
            }

            //if ((dealerscore == totalscore) || ((dealerscore > 21) && (totalscore > 21))) {
            if (dealerscore > 21 && totalscore > 21) {
                System.out.println();
                System.out.println("You both lose");
            }

            if ((totalscore < 21) && (dealerscore < 21)) {
                if (totalscore < dealerscore) {
                    System.out.println();
                    System.out.println("Dealer wins");
                }
                System.out.println();
                if (totalscore > dealerscore) {
                    System.out.println("Player wins");
                }
            }
            System.out.println();

            totalscore = 0;
            dealerscore = 0;
            repeatgame = "n";
            System.out.println("Play again? (Y/N)");
            repeatgame = input.next();

        }


        } // end of main

    }

