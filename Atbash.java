/*
 * Class Name:    Atbash
 * @author Thomas McKeesick
 * @version 1
 *
 * Creation Date:     Wednesday, September 24 2014, 11:54 
 * Last Modified:     Friday, January 09 2015, 13:01
 * 
 * Class Description: This is program that decodes the
 *       Atbash cipher, a simple substitution where a letter's
 *       position in the alphabet is essentially mirrored.
 *       This class is not abstract as it is intended to be able
 *       to be used as a standalone program and also by others.
 */

import java.util.Scanner;

public class Atbash
{
    /**
     * Main method, simply accepts input from the user for decoding,
     * then prints the result to screen
     * @param args The string to decode
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the Atbash decoder!\n" +
                           "Enter a message to decode: ");
        String message = keyboard.nextLine();
        System.out.println("\nDECRYPTED: " + decrypt(message).toUpperCase());
    }

    /**
     * Public static method to decrypt an Atbash-encoded message. This
     * method preserves non-alphabet characters in the final string
     * @param message The string to decrypt
     * @return The decrypted string in upper case
     */
    public static String decrypt( String message )
    {
        StringBuilder decoded = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                int newChar = ('Z' - c) + 'A';
                decoded.append((char) newChar);
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }
}
