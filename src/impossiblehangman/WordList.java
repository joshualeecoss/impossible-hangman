/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impossiblehangman;

import java.io.*;
import java.util.*;

/**
 *
 * @author Joshua Coss
 */
public class WordList {
    private List<Word> words;
    
    /**
     * Creates a list of Word objects from a txt file full of words
     * 
     * @param filename                  txt file of words
     * @throws FileNotFoundException 
     */
    public WordList(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));      
        words = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            words.add(new Word(line));  
       }
    }
    
    /**
     * makeWordList - makes a list of words of a given length
     * 
     * @param length    int length of wanted words
     * @return          ArrayList of words
     */
    public ArrayList<Word> makeWordList(int length) {
        ArrayList<Word> wordList = new ArrayList<>();
        for (Word entry : words)
            if (entry.getLength() == length && validateString(entry.getWord()))
                wordList.add(entry);
        return wordList;
    }
    
    /**
     * shortenWordList - removes word from list 
     * 
     * @param list      list to remove word from
     * @param index
     * @param guess
     * @return          new list of words
     */
    public ArrayList<Word> shortenWordList(ArrayList<Word> list, int index, char guess) {
        ArrayList<Word> newWords = new ArrayList<>();
        for (Word entry : list)
            if (entry.getWord().charAt(index) == guess)
                newWords.add(entry);
        return newWords;
    }
    
    /**
     * validateString - makes sure a word contains only alphabetical letters
     * https://www.tutorialspoint.com/how-to-find-if-a-given-string-contains-only-letters-in-java
     * 
     * @param str   word
     * @return      boolean true or false
     */
    public boolean validateString(String str) {
        str = str.toLowerCase();
        char [] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (!(ch >= 'a' && ch <= 'z')) {
                return false;
            }
        }
        return true;
    }
    
}
