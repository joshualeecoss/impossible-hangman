/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impossiblehangman;

import java.nio.file.Paths;
import java.util.*;

/**
 *
 * @author Joshua Coss
 */
public class ImpossibleHangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner inFile = new Scanner (Paths.get("words.txt"));
            Divider divide = new Divider("words.txt");
            Random rand = new Random();
            
            ArrayList<Word> words = new ArrayList<>();
            
            while (inFile.hasNextLine()) {
                String line = inFile.nextLine();
                Word addition = new Word(line);
                words.add(addition);
            }  

            ArrayList<Word> wordList = divide.makeWordList(8);
            
            Word newWord = wordList.get(rand.nextInt(wordList.size()));
            GuessField hangman = new GuessField(newWord.getWord());
            int guessLength = 1, maxGuess = 10;
            char[] guesses = new char[guessLength];
            

            Scanner sc = new Scanner(System.in);

            
            while (guessLength != maxGuess){
                System.out.println(newWord.getWord());
                
                
                System.out.println(hangman.getGuessField());

                System.out.println("Please pick a letter");
                String guess = sc.nextLine();
                
                if (newWord.getWord().contains(guess)){
                    char c = guess.charAt(0);
                    int ind = newWord.getWord().indexOf(guess);
                    while (ind >= 0) {
                        wordList = divide.shortenWordList(wordList, ind, c);
                        ind = newWord.getWord().indexOf(guess, ind + 1);
                        hangman.updateGuessField(hangman.getGuessField(), newWord.getWord(), c);
                    }
                    newWord = wordList.get(rand.nextInt(wordList.size()));
                    guesses = Arrays.copyOf(guesses, guessLength);
                    guesses[guessLength - 1] = c;
                    
                }
                guessLength++;
                System.out.println(Arrays.toString(guesses));
            }
            
        } catch(Exception IOException) {
            System.out.println("No such file exists");
        }
    }
    
}
