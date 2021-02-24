/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impossiblehangman;

/**
 * 
 * 
 * @author Joshua Coss
 */
public class GuessField {
    
    int length;
    String word;
    String guessField;
    
    public GuessField(String str) {
        length = str.length();
        word = str;
        guessField = "";
        for (int i = 0; i < length; i++)
            guessField = guessField + "_";
    }
    
    public String printGuessField() {
        return guessField;
    }
}
