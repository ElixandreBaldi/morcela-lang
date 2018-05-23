package morcela;

import java.io.*;

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

        String contents = null;
        try {
            contents = openArgumentFile(args[ARG_INPUT_FILE]);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        printAsciiWelcome();

        runLexicalAnalysis(contents);


        System.exit(0);
    }

    private static void parseArguments(String args[]) throws IllegalArgumentException {
        if (args.length != ARGS_COUNT) {
            throw new IllegalArgumentException("Invalid arguments. Only one is expected.");
        }
    }

    private static String openArgumentFile(String filename) throws IOException {
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        BufferedReader bf = new BufferedReader(fr);
        StringBuilder contents = new StringBuilder();
        do{
            String currentLine = bf.readLine();
            if (currentLine == null) {
                break;
            }
            contents.append(currentLine + "\n");
        } while(true);
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

    private static void runLexicalAnalysis(String contents) {
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(contents);
        lexicalAnalyzer.run();
        System.out.println(lexicalAnalyzer);
    }
}
