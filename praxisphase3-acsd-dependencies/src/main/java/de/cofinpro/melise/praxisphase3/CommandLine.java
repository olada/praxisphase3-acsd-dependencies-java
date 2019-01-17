package de.cofinpro.melise.praxisphase3;

import java.util.Scanner;

public class CommandLine {

    public static void main(String[] args) throws Exception {
        ReadTsvFile readTsvFile = new ReadTsvFile();
        readTsvFile.executeAllMethods();
    }
}
