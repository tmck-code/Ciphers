/*
 * Class Name:    Atbash
 *
 * @author Thomas McKeesick
 * @version 1
 *
 * Creation Date: Wednesday, September 24 2014, 11:54 
 * Last Modified: Friday, January 09 2015, 11:16
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
    /** A char array containing the alphabet in reverse order */
    //This is not the most efficient way of doing this, but it
    //is the most human-readable
    public static char[] AtbashOrder = { 'z', 'y', 'x', 'w', 'v', 'u', 't', 's',
        'r', 'q', 'p'/, 'o', 'n', 'm', 'l', 'k',
        'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c',
        'b', 'a' };

    /**
     * Main method, simply accepts input from the user for decoding,
     * then prints the result to screen
     *
     * @param args The string to decode
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("********************************\n" +
                           "Welcome to the Atbash decoder!\n" +
                           "********************************");
        System.out.print("Enter a message to decode: ");
        String message = keyboard.nextLine();
        System.out.println("\nDECRYPTED: " + decrypt(message).toUpperCase());
    }

    /**
     * Public static method to decrypt an Atbash-encoded message. This
     * method still adds non-alphabet characters to the final string,
     * in case the message is encoded with grammatical characters
     *
     * @param message The string to decrypt
     * @return The decrypted string in upper case
     */
    public String decrypt( String message ) {
        StringBuilder decoded = new StringBuilder();

        for( char i : message.toLowerCase().toCharArray()) {
            if(Character.isLetter(i)) {
                char c =  AtbashOrder[(i - 'a')];
                decoded.append(Character.toUpperCase(c));
            } else {
                decoded.append(i);
            }
        }
        return decoded.toString();
    }
}