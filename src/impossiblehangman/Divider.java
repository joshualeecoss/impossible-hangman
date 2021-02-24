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
public class Divider {
    private List<Word> words;
    
    public Divider(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));      
        words = new ArrayList<>();
        boolean first = true;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            words.add(new Word(line));  
       }
    }
    
    public ArrayList<Word> makeWordList(int length) {
        ArrayList<Word> four = new ArrayList<>();
        for (Word entry : words)
            if (entry.getLength() == length && validateString(entry.getWord()))
                four.add(entry);
        return four;
    }
    
    public ArrayList<Word> shortenWordList(ArrayList<Word> list, int index, char guess) {
        ArrayList<Word> four = new ArrayList<>();
        for (Word entry : list)
            if (entry.getWord().charAt(index) == guess)
                four.add(entry);
        return four;
    }
    
    /**
     * https://www.tutorialspoint.com/how-to-find-if-a-given-string-contains-only-letters-in-java
     * 
     * @param str
     * @return 
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
