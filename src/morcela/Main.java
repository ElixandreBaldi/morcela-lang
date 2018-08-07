package morcela;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String args[]) {
        try {
            parseArguments(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        String contents = null;

        try {
            final int ARG_INPUT_FILE = 0;
            contents = openArgumentFile(args[ARG_INPUT_FILE]);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        printAsciiWelcome();
        compile(contents);

        System.exit(0);
    }

    private static void parseArguments(String args[]) throws IllegalArgumentException {
        final int ARGS_COUNT = 1;
        if (args.length != ARGS_COUNT) {
            throw new IllegalArgumentException("Invalid arguments. Only one is expected.");
        }
    }

    private static String openArgumentFile(String filename) throws IOException {
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        BufferedReader bf = new BufferedReader(fr);
        StringBuilder contents = new StringBuilder();
        do {
            String currentLine = bf.readLine();
            if (currentLine == null) {
                break;
            }
            contents.append(currentLine).append("\n");
        } while (true);
        return contents.toString();
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

    private static void compile(String contents) {
        Compiler compiler = new Compiler(contents);
        compiler.run();
    }
}
