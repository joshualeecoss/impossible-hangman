package impossiblehangman;

import java.util.*;

/**
 *  The main function of the program, this class loads a text file of words
 *  in and stores each word as a Word object in a list, as well as into a 
 *  Divider object used for manipulating the list.
 * 
 *  The player guesses a letter of the word (like in regular Hangman), but if
 *  they correctly guess a letter of the word, the word changes to a new word
 *  with the correctly guessed letters in the same spaces
 * 
 * @author Joshua Coss
 */
public class ImpossibleHangmanMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //loads txt file into WordList object
            WordList allWords = new WordList("words.txt");
            //initializes randomizer
            Random rand = new Random();

            //takes all 8 letter words out of allWords and store them in
            //a new list
            ArrayList<Word> wordList = allWords.makeWordList(8);
            
            //get random word out of wordlist
            Word newWord = wordList.get(rand.nextInt(wordList.size()));
            //initialize GuessField
            GuessField hangman = new GuessField(newWord.getWord());
            //how many guesses taken, how many guesses total
            int guessLength = 1, maxGuess = 10;
            //array of letters guessed
            char[] guesses = new char[guessLength];

            Scanner sc = new Scanner(System.in);
            while (guessLength != maxGuess){
                //print out word (for testing purposes)
                System.out.println(newWord.getWord());
                //print out GuessField
                System.out.println(hangman.getGuessField());

                //prompt user for a guess
                System.out.println("Please pick a letter");
                String guess = sc.nextLine();
                
                //if guess is correct, update guessfield, wordlist, and get
                //a new word
                if (newWord.getWord().contains(guess)){
                    char c = guess.charAt(0);
                    int ind = newWord.getWord().indexOf(guess);
                    while (ind >= 0) {
                        wordList = allWords.shortenWordList(wordList, ind, c);
                        ind = newWord.getWord().indexOf(guess, ind + 1);
                        hangman.updateGuessField(newWord.getWord(), c);
                    }
                    newWord = wordList.get(rand.nextInt(wordList.size()));

                }
                //update array of previous guesses
                guesses = Arrays.copyOf(guesses, guessLength);
                guesses[guessLength - 1] = guess.charAt(0);
                
                //increases total number of guesses
                guessLength++;
                //print out array of guesses
                System.out.println(Arrays.toString(guesses));
            }
            
        } catch(Exception IOException) {
            System.out.println("Something went wrong");
        }
    }
    
}
