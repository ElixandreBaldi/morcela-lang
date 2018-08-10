package morcela.stackable;

public class Token implements Stackable {

    private TokenType type;

    private String content;

    private int line;

    private int column;

    public Token(TokenType type, int line, int column, String content) {
        this.type = type;
        this.content = content;
        this.line = line;
        this.column = column;
    }

    public Token(TokenType type, int line, int column) {
        this.type = type;
        this.content = type.toString();
        this.line = line;
        this.column = column;
    }

    @Override
    public String toString() {
        return "<" + type + ", " + content + "," + line + ":" + column + ">";
    }

    public TokenType getType() {
        return type;
    }

    Object[] toRow() {
        final int MAX_CONTENT_LEN = 40;
        StringBuilder contentStringBuilder = new StringBuilder(MAX_CONTENT_LEN);
        if (content.length() <= MAX_CONTENT_LEN) {
            contentStringBuilder.append(content);
        } else {
            String actualContent = content.substring(0, MAX_CONTENT_LEN - 3) + "...";
            contentStringBuilder.append(actualContent);
        }
        return new String[]{type.toString(), contentStringBuilder.toString(), String.valueOf(line), String.valueOf(column)};
    }
}
