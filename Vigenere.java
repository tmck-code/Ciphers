/*
 * Class Name:    Vigenere
 *
 * Author:        Thomas McKeesick
 * Creation Date: Wednesday, September 24 2014, 14:33 
 * Last Modified:     Saturday, January 10 2015, 23:24
 * 
 * Class Description: Java implementation of the Vigenere cipher
 *
 */

import java.lang.Character;
import java.util.Scanner;

public class Vigenere {

    /** Variable representing the number of letters in the English Alphabet  */
    public static final int ALPHABET_SIZE = 26;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("**********************************************");
        System.out.println("Welcome to the Vigenere decrypter\n" + 
                "Decrypts an encoded message with a key");
        System.out.println("**********************************************");
        System.out.println("Enter the encoded message: ");
        String message = keyboard.nextLine();
        System.out.println("Enter the key: ");
        String key = keyboard.nextLine();
        String decrypted = decrypt(message, key);
        System.out.println("DECRYPTED MESSGAE: " + decrypted);
    }

    /**
     * Decrypts a string via the Vigenere cipher
     * @param str The encrypted string
     * @param key The key to decode the encrypted string with
     * @return The decrypted string
     */
    public static String decrypt(String str, String key) {
        String decrypted = "";
        key = key.toUpperCase();
        int keyIndex = 0;
        
        for( char c : str.toUpperCase().toCharArray() ) {

            if(Character.isLetter(c)) {
                decrypted += 
                    (char) (
                        (c - key.charAt(keyIndex) + ALPHABET_SIZE) 
                        % ALPHABET_SIZE + 'A');
                keyIndex = ++keyIndex % key.length();
            } else {
                decrypted += c;
            }
        }
        return decrypted;
    }
}

