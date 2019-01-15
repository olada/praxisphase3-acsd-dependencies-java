package de.cofinpro.melise.praxisphase3;

import java.util.Scanner;

public class CommandLine {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ReadTsvFile readTsvFile = new ReadTsvFile(scanner);
        readTsvFile.executeAllMethods();

    }
}
