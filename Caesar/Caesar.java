/*
 * Class Name:    Caesar
 *
 * @author Thomas McKeesick
 * @version 1.1.0
 *
 * Author:        Thomas McKeesick
 * Creation Date: Sunday, September 21 2014, 16:50 
 * Last Modified:     Saturday, January 10 2015, 21:45
 * 
 * Class Description: This is a program that decodes a string
 *    via Caesar shifts. The program runs through shifts 1-25.
 */

import java.io.IOException;
import java.lang.String;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Exception;

import java.util.ArrayList;

public class Caesar {
    
    /** Variable representing the number of letters in the English Alphabet. */
    private static final int ALPHABET_SIZE = 26;
    
    /**
     * Main method of the program, takes an input string from the user and
     * then decodes it, printing the output to the user.
     */
    public static void main(String[] args) {

        System.out.println("****************************************");
        System.out.println("Decrypts via caesar, tries all shifts");
        System.out.println("****************************************");
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter string to decrypt: ");
        String encrypted = keyboard.nextLine();
        System.out.println("Decrypted text: ");

        ArrayList<String> result = decrypt(encrypted);
        System.out.println(result);
   }

    /**
     * The decryption method, tries every Caesar shift from 1 - 25
     * @param decrypted
     * @return An ArrayList of Strings containing all possible solutions
     */
    public static ArrayList<String> decrypt( String encrypted ) {
        ArrayList<String> result = new ArrayList<String>();
		
        for(int shift = 0; shift < ALPHABET_SIZE; shift++) {
            String line = caesarEncrypt( encrypted, shift );
            result.add(line);
        }
        return result;
   }

    /**
     * The encryption method, moves every letter in the string along by the 
     * shift number provided
     * @param str The string to encrypt
     * @param shift The number that each letter is shifted by
     * @return The encrypted string
     */
    public static String caesarEncrypt( String str, int shift ) {
        StringBuilder encoded = new StringBuilder();

        for (char c : str.toUpperCase().toCharArray()) {
            if (Character.isLetter(c)) {
                char newChar = (char) (((c + shift) % ALPHABET_SIZE) + 'A' );
                encoded.append(newChar);
            } else {
                encoded.append(c);
            }
        }
        encoded.append("\n");
        return encoded.toString();
    }
}
