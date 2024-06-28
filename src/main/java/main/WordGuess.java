package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGuess {
    public static void process(char guess, char[] arr, ArrayList<String> list){
        int specialIndex;
        for (int i = 0; i < arr.length; i++){ //solved an error here, had to make it < not <=
            if (guess == arr[i]){
                specialIndex = i; //remember indexes start at zero! (but this finds index we need)
                list.remove(specialIndex);
                list.add(specialIndex, String.valueOf(guess));
            } else {
//            System.out.println("Not found in array.");
            }
        }
    }
    public static void printCurrentState(ArrayList<String> list, int total, int total2) {
        System.out.println("Current guesses: " + total2);
        System.out.println(list);
        System.out.println("You have " + total + " tries left.");
    }

    public static void playerWon(){
        System.out.println("***************");
        System.out.println("Congrats, you guessed it!!! You win!!!");
        System.out.println("***************");
    }

    public static void playerLost(){
        System.out.println("---------------");
        System.out.println("Sorry, you are OUT of turns! You lose.");
        System.out.println("---------------");
    }

//    public static void main (String[] args) {
    public void runGame(){
        Scanner scanner = new Scanner(System.in);

        boolean gameOn = true;
        while (gameOn) {
            //FOR VERSION 1 OF YOUR GAME
            //start the game
            System.out.println("Let's play WordGuess - Version 1.0");
            //make an array of words
            String[] words = {"apple", "banana", "orange", "berry", "grape"};
            //choose a random word from this array
            Random random = new Random();
            String randomWord = words[random.nextInt(words.length)];
            //find how many letters are in the random word
            int sizeOfRandomWord = randomWord.length();
            //declare that you get x amount of tries from the amount of letters in step above
            int triesAllowed = sizeOfRandomWord;
            //set up a solution array
            char[] secretWordArray = randomWord.toCharArray();
            //this out print here is to just check that the char array works. seems like it does
//    System.out.println(Arrays.toString(secretWordArray));

            //set up an empty guesses array that the user will guess chars into
            ArrayList<String> userGuessesArray = new ArrayList<String>();
            for (int i = 0; i <= sizeOfRandomWord - 1; i++) {
                userGuessesArray.add("_");
            }

            int userTries = 0;
            boolean wordGuessed = false;
            //first prompt to begin game - PRINT CURRENT STATE
//    public static void printCurrentState() {
//        System.out.println("You have " + triesAllowed + " tries left.");
//        System.out.println("Enter a single character:");
            printCurrentState(userGuessesArray, triesAllowed, userTries);

//        char userGuess = scanner.next().charAt(0);
//        process(userGuess, secretWordArray, userGuessesArray);
//        userTries++;
//        triesAllowed--;
//        printCurrentState(userGuessesArray, triesAllowed, userTries);
//    System.out.println("Enter a single character:");

//    }

            //logic to test if inputChar is included in randomWord (BASICALLY THE PROCESS METHOD)
            // ..... down below ....
            //get input character
            //loop through the random word string
            //if (i) at any point is equal to the input character,
            //find the index of that character in randomWord that matches with the input character
            //and once you have that index number, remove the _ from that index of the emptyArray
            //and replace it with the user input character
            //now empty array will look like __a_


            //set a while loop (while number of tries < tries allowed) AND
            //the player has not guessed the word...
            //if there is no _ in the array that means you guessed the word
            while ((userTries < sizeOfRandomWord) && wordGuessed == false) {
                userTries++;
                triesAllowed--;
//        System.out.println("You have " + triesAllowed + " tries left.");
//        System.out.println("Current guesses: " + userTries);
//        System.out.println("Make a new guess?");
                char newUserGuess = scanner.next().charAt(0);
                process(newUserGuess, secretWordArray, userGuessesArray);
                printCurrentState(userGuessesArray, triesAllowed, userTries);
                if (!(userTries > 0)) {
                    System.out.println("Enter a single character:");
                }
                if (!userGuessesArray.contains("_")) { //RIGHT NOW THIS DOESN'T WORK
                    wordGuessed = true;
                }
            }
            if (wordGuessed == true) {
                playerWon();
            }
            if ((userTries == sizeOfRandomWord) && wordGuessed == false) {
                playerLost();
            }

    /*
    VERSION 2: add a while (true) conditional wrapped around the whole game code
     that won't start unless they say Y/N to play again
     */
            System.out.println("Play Again?");
            System.out.println("1. Yes, play again.");
            System.out.println("2. No, quit.");
            if (scanner.nextInt() == 2){
                break;
            }
        } //end of GameOn boolean outer loop

    }
}
