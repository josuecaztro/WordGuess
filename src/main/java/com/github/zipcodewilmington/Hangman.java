package com.github.zipcodewilmington;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);

    //hello my Name is Josue!

    //try to keep your methods small
    //if methods get too big, break them up into smaller pieces with other methods
    //DO GIT COMMITS ALONG THE WAY!!!

    //FOR VERSION 1 OF YOUR GAME
    //start the game
    System.out.println("Let's play Wordguess version 1.0");

    //make an array of words
    String[] words = {"apple", "banana", "orange", "strawberry"};
    //choose a random word from this array
    Random random = new Random();
    String randomWord = words[random.nextInt(words.length)];
    System.out.println(randomWord);
    //find how many letters are in the random word
    int sizeOfRandomWord = randomWord.length();
    //declare that you get x amount of tries from the amount of letters in step above
    int triesAllowed = sizeOfRandomWord;
    //set up a solution array
    char[] secretWordArray = randomWord.toCharArray();
    //this sout here is to just check that the char array works. seems like it does
//    System.out.println(Arrays.toString(secretWordArray));
    //set up an empty guesses array that the user will guess chars into
    String[] userGuessesArray = {"_", "_", "_", "_"};




    //logic to test if inputChar is included in randomWord
    for (int i = 0; i < sizeOfRandomWord; i++){
        System.out.println(randomWord.indexOf(i));
    }


    //first prompt to begin game
    System.out.println("You have " + triesAllowed + " tries left.");
    System.out.println("Enter a single character:");
    char userGuess = scanner.next().charAt(0);


    //set a while loop (while number of tries < tries allowed) AND
    //the player has not guessed the word...
    int userTries = 0;
    boolean wordGuessed = false;
    while ((userTries < triesAllowed) && wordGuessed == false){
        userTries++;
        triesAllowed--;
        System.out.println("You have " + triesAllowed + " tries left.");
        System.out.println("Current guesses: " + userTries);
        System.out.println("Make a new guess?");
        char newUserGuess = scanner.next().charAt(0);
    }
    //print current state of player guesses, ask player for a new guess, if char = "-", quit the game,
    //ELSE process the letter
    //if the letter makes the word complete - PLAYER WINS
    //after this while loop - if the word is not guessed - player loses.







    /*
    VERSION 2: add a while (true) conditional wrapped around the whole game code
     that won't start unless they say Y/N to play again
     */
}
}
