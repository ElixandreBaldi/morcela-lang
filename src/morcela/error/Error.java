package morcela.error;

public class Error {
    private String message;

    private int line;

    private int column;

    private String tokenCause;

    public Error(int line, int column, String tokenCause, String message) {
        this.line = line;
        this.column = column;
        this.message = message;
        this.tokenCause = tokenCause;
    }

    public Error(int line, int column, String tokenCause) {
        this.line = line;
        this.column = column;
        this.message = "Unexpected character";
        this.tokenCause = tokenCause;
    }

    public Error(int line, int column) {
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
