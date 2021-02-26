package impossiblehangman;

/**
 * This class is meant to take a word given to it from a txt file and store it's
 * length, first character, and the word itself.
 * list of words found at https://github.com/dwyl/english-words/blob/master/words.txt
 * 
 * @author Joshua Coss
 */
public class Word {
    
    int length;
    char first;
    String word;
    
    /**
     * Creates a word object based on a string being handed to it
     * 
     * @param str   word from text file
     */
    public Word(String str) {
        length = str.length();
        first = str.charAt(0);
        word = str;
    }
    
    /**
     * getWord() - returns the word field of the Word object
     * 
     * @return word
     */
    public String getWord() {
        return word;
    }
    
    /**
     * getLength - returns the length of the Word object
     * 
     * @return 
     */
    public int getLength() {
        return length;
    }
    
    /**
     * getFirst() - returns the first letter of the Word object
     * 
     * @return 
     */
    public char getFirst() {
        return first;
    }
    
}
