//Anthony Franklin afranklin18@cnm.edu
//RockPaperScissors Program

//RPS.java

import javax.swing.*;
import java.util.*;

public class RPS {
    public static void main(String[] args) {
        //Header in JOption Pane
        JOptionPane.showMessageDialog(null, "\nAnthony Franklin afranklin18@cnm.edu\nRPS.java\nWelcome to Rock, Paper, Scissors! Each game is best of 3. Let's go and good luck! \n");

        //Declare variables
        int choice;
        int compChoice;

        String[] outcome = {"You win, great job! ", "The computer wins ", "Draw! "};
        String result = "";

        //Array of choices:
        String[] options = {"Rock \u270a", "Paper \u270b", "Scissors \u270c"};
        Random rand = new Random();
        int wins = 0;
        int losses = 0;
        int games = 0;

        do {
            int compWins = 0;
            int playerWins = 0;
            int ties = 0;
            do {
                choice = JOptionPane.showOptionDialog(null, "Rock, Paper, Scissors", "Make your choice", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                compChoice = rand.nextInt(3);
                switch (choice) {
                    case 0:
                        if (compChoice == 0) {
                            ties++;
                            result = outcome[2];
                        } else if (compChoice == 1) {
                            compWins++;
                            result = outcome[1];
                        } else {
                            playerWins++;
                            result = outcome[0];
                        }
                        break;
                    case 1:
                        if (compChoice == 0) {
                            playerWins++;
                            result = outcome[0];
                        } else if (compChoice == 1) {
                            ties++;
                            result = outcome[2];
                        } else {
                            compWins++;
                            result = outcome[1];
                        }
                        break;
                    case 2:
                        if (compChoice == 0) {
                            compWins++;
                            result = outcome[1];
                        } else if (compChoice == 1) {
                            playerWins++;
                            result = outcome[0];
                        } else {
                            ties++;
                            result = outcome[2];
                        }
                        break;
                }
                JOptionPane.showMessageDialog(null, "You chose " + options[choice] + "\n" + "Computer chose " + options[compChoice] + "\n"
                        + "Player Score: " + playerWins + "\nComputer Score: " + compWins + "\nDraws: " + ties);
            }
            while (compWins < 2 && playerWins < 2);
            games++;
            if (playerWins == 2) {
                wins++;
            } else {
                losses++;
            }
        }
        while (JOptionPane.showConfirmDialog(null, result + "Play again?", "Make your choice", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION);
        JOptionPane.showMessageDialog(null, "\nThanks for playing with me! Final outcome: \nGames played: " + games + "\nPlayer wins: " + wins + "\nPlayer losses: " + losses);
    }
}