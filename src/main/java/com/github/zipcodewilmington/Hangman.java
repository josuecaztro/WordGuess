package com.github.zipcodewilmington;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {

    public static void processInputChar(char guess, char[] arr, ArrayList<String> list){
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
    System.out.println(Arrays.toString(secretWordArray));

    //set up an empty guesses array that the user will guess chars into
    ArrayList<String> userGuessesArray = new ArrayList<String>();
    for (int i = 0; i <= sizeOfRandomWord - 1; i++){
        userGuessesArray.add("_");
    }
    System.out.println(userGuessesArray);


    //first prompt to begin game
    System.out.println("You have " + triesAllowed + " tries left.");
    System.out.println("Enter a single character:");
    char userGuess = scanner.next().charAt(0);
    processInputChar(userGuess, secretWordArray, userGuessesArray);

    //logic to test if inputChar is included in randomWord
    // ..... down below ....
    //get input character
    //loop through the random word string
    //if (i) at any point is equal to the input character,
    //find the index of that character in randomWord that matches with the input character
    //and once you have that index number, remove the _ from that index of the emptyArray
    //and replace it with the user input character
    //now empty array will look like __a_

//    int specialIndex;
//    for (int i = 0; i < secretWordArray.length; i++){ //solved an error here, had to make it < not <=
//        if (userGuess == secretWordArray[i]){
//            specialIndex = i; //remember indexes start at zero! (but this finds index we need)
//            userGuessesArray.remove(specialIndex);
//            userGuessesArray.add(specialIndex, String.valueOf(userGuess));
//        } else {
////            System.out.println("Not found in array.");
//        }
//    }

    System.out.println(userGuessesArray);





    //EXAMPLE: (if they guess a)
    // indices      0   1   2
    // randoWord    c   a   t
    //guessesArray  _   a   _











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
        processInputChar(newUserGuess, secretWordArray, userGuessesArray);
        System.out.println(userGuessesArray);
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
