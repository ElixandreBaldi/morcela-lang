package morcela;

public class LexicalError {
    private String message;

    private int line;

    private int column;

    private String tokenCause;

    LexicalError(int line, int column, String tokenCause, String message) {
        this.line = line;
        this.column = column;
        this.message = message;
        this.tokenCause = tokenCause;
    }

    LexicalError(int line, int column, String tokenCause) {
        this.line = line;
        this.column = column;
        this.message = "Unexpected character";
        this.tokenCause = tokenCause;
    }

    LexicalError(int line, int column) {
        this.line = line;
        this.column = column;
        this.message = "Unexpected character";
        this.tokenCause = "";
    }

    @Override
    public String toString() {
        return message + " " + tokenCause + " at " + line + ":" + column;
    }
}
