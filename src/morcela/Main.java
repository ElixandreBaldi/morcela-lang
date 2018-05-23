package morcela;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    private static int ARGS_COUNT = 1;

    private static int ARG_INPUT_FILE = 0;

    public static void main(String args[]) {
        try {
            parseArguments(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        BufferedReader bf = null;
        try {
            bf = openArgumentFile(args[ARG_INPUT_FILE]);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        printAsciiWelcome();
        runLexicalAnalysis(bf);

        System.exit(0);
    }

    private static void parseArguments(String args[]) throws IllegalArgumentException {
        if (args.length != ARGS_COUNT) {
            throw new IllegalArgumentException("Invalid arguments. Only one is expected.");
        }
    }

    private static BufferedReader openArgumentFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        return new BufferedReader(fr);
    }

    private static void printAsciiWelcome() {
        System.out.println("      ___           ___           ___           ___           ___           ___       ___     \n" +
                "     /\\__\\         /\\  \\         /\\  \\         /\\  \\         /\\  \\         /\\__\\     /\\  \\    \n" +
                "    /::|  |       /::\\  \\       /::\\  \\       /::\\  \\       /::\\  \\       /:/  /    /::\\  \\   \n" +
                "   /:|:|  |      /:/\\:\\  \\     /:/\\:\\  \\     /:/\\:\\  \\     /:/\\:\\  \\     /:/  /    /:/\\:\\  \\  \n" +
                "  /:/|:|__|__   /:/  \\:\\  \\   /::\\~\\:\\  \\   /:/  \\:\\  \\   /::\\~\\:\\  \\   /:/  /    /::\\~\\:\\  \\ \n" +
                " /:/ |::::\\__\\ /:/__/ \\:\\__\\ /:/\\:\\ \\:\\__\\ /:/__/ \\:\\__\\ /:/\\:\\ \\:\\__\\ /:/__/    /:/\\:\\ \\:\\__\\\n" +
                " \\/__/~~/:/  / \\:\\  \\ /:/  / \\/_|::\\/:/  / \\:\\  \\  \\/__/ \\:\\~\\:\\ \\/__/ \\:\\  \\    \\/__\\:\\/:/  /\n" +
                "       /:/  /   \\:\\  /:/  /     |:|::/  /   \\:\\  \\        \\:\\ \\:\\__\\    \\:\\  \\        \\::/  / \n" +
                "      /:/  /     \\:\\/:/  /      |:|\\/__/     \\:\\  \\        \\:\\ \\/__/     \\:\\  \\       /:/  /  \n" +
                "     /:/  /       \\::/  /       |:|  |        \\:\\__\\        \\:\\__\\        \\:\\__\\     /:/  /   \n" +
                "     \\/__/         \\/__/         \\|__|         \\/__/         \\/__/         \\/__/     \\/__/    ");
        System.out.println();
        System.out.println("Morcela Lang 0.1");
    }

    private static void runLexicalAnalysis(BufferedReader bf) {
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(bf);
        lexicalAnalyzer.run();
    }
}
