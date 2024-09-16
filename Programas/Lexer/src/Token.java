public class Token {
    private final LexicalClass lClass;
    private final String lexeme;

    public Token(LexicalClass lexClass, String lexeme) {
        this.lClass = lexClass;
        this.lexeme = lexeme;
    }

    @Override
    public String toString() {
        if (this.lClass == LexicalClass.ID || this.lClass == LexicalClass.NUM_INT || this.lClass == LexicalClass.NUM_FLOAT) {
            return "<" + this.lClass + "," + this.lexeme + ">";
        } else {
            return "<" + this.lClass + "," + ">";
        }
    }
}
