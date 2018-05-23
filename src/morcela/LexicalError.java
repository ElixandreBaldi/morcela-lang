package morcela;

public class LexicalError {
    private String message;

    LexicalError (String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
