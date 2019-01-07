/*Dead Class*/

package de.cofinpro.melise.praxisphase3;

import java.util.Scanner;

/**
 * Created by David Olah, Cofinpro AG.
 * Date: 29.11.2018.
 * Updated by Melise Akcay, Cofinpro AG.
 * Date: 6.12.2018.
 */
public class ReadInputAttribute {

    public void readInput() throws Exception {

        System.out.println("Enter your attribute-ID: ");
        Scanner scanner = new Scanner(System.in);
        String attributeID = scanner.nextLine();
        System.out.println("Your attribute-ID is " +attributeID);

    }


}
