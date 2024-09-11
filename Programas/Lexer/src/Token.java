public class Token {
    private final LexicalClass lClass;
    private final String lexeme;

    public Token(LexicalClass lexClass, String lexeme) {
        this.lClass = lexClass;
        this.lexeme = lexeme;
    }

    @Override
    public String toString() {
        return "<" + this.lClass + "," + this.lexeme + ">";
    }
}
