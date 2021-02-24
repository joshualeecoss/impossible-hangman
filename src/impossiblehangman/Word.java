/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impossiblehangman;

/**
 * list of words found at https://github.com/dwyl/english-words/blob/master/words.txt
 * 
 * 
 * @author Joshua Coss
 */
public class Word {
    
    int length;
    char first;
    String word;
    
    public Word(String str) {
        length = str.length();
        first = str.charAt(0);
        word = str;
    }
    
    public String getWord() {
        return word;
    }
    
    public int getLength() {
        return length;
    }
    
    public char getFirst() {
        return first;
    }
    
    public String printSpaces(char[] guesses) {
        String hangman = "";
        for (int i = 0; i < length; i++){
            if (new String(guesses).indexOf(word.charAt(i)) != -1)
                hangman += word.charAt(i);
            else
                hangman += "_";
        }
        return hangman;     
    }
}
