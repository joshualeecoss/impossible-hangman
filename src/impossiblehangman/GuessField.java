package impossiblehangman;

/**
 * GuessField object takes in a string, creates a string of "_" totaling the
 * length of the string in a guessField variable, and updates the guessField
 * when the player makes a correct guess.
 * 
 * @author Joshua Coss
 */
public class GuessField {
    
    int length;
    String word;
    String guessField;
    
    /**
     * Creates a GuessField object based on a string being handed to it
     * 
     * @param str   word from text file
     */
    public GuessField(String str) {
        length = str.length();
        word = str;
        guessField = "";
        for (int i = 0; i < length; i++)
            guessField = guessField + "_";
    }
    
    /**
     * getGuessField() - returns a string of underscores and characters, 
     *                   depending on if the player has made any correct
     *                   guesses
     * 
     * @return guessField string
     */
    public String getGuessField() {
        return guessField;
    }
    
    /**
     * updateGuessField - takes in a string, word, and guess, and updates the
     *                    guessField variable
     * 
     * @param str       current guessField
     * @param word      current word
     * @param guess     current guess
     */
    public void updateGuessField(String word, Character guess) {
        char[] strChars = guessField.toCharArray();
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < wordChars.length; i++) {
            if (wordChars[i] == guess) {
                strChars[i] = guess;
            }

        }    
        guessField = String.valueOf(strChars);
        
    }
}
