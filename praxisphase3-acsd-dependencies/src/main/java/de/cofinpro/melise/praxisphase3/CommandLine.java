package de.cofinpro.melise.praxisphase3;

/** Klasse dient zur Ausfühung aller Komponenten*/

public class CommandLine {

    public static void main(String[] args) throws Exception {
        ReadTsvFile readTsvFile = new ReadTsvFile();
        readTsvFile.executeAllMethods();
    }
}
