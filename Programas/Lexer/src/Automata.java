public class Automata {
    private  enum CharClass {
        LETTER, ZERO, ONE_TO_NINE, TWO_DOTS, EQUAL, PLUS, DOT, WHITE_SPACE;

        static CharClass classify(char c) {
            if (Character.isLetter(c)) {
                return LETTER;
            } else if (c == '0') {
                return ZERO;
            } else if (c >= '1' && c <= '9') {
                return ONE_TO_NINE;
            } else if (c == ':') {
                return TWO_DOTS;
            } else if (c == '=') {
                return EQUAL;
            } else if (c == '+') {
                return PLUS;
            } else if (c == '.') {
                return DOT;
            } else if (Character.isWhitespace(c)) {
                return WHITE_SPACE;
            } else {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }
    }

    private enum State {
        START(false,  LexicalClass.NOT_VALID),  Q1(true, LexicalClass.ID),
        Q2(true, LexicalClass.WHITE_SPACE),  Q3(false, LexicalClass.NOT_VALID),
        Q4(true, LexicalClass.SUM),  Q5(true,  LexicalClass.NUM_INT),
        Q6(true, LexicalClass.NUM_INT),  Q7(false, LexicalClass.NOT_VALID),
        Q8(true, LexicalClass.NUM_FLOAT),
        UNDEFINED_STATE(false, LexicalClass.NOT_VALID);

        final boolean accept;
        final LexicalClass lexicalClass;

        State(boolean accept, LexicalClass lexicalClass) {
            this.accept = accept;
            this.lexicalClass = lexicalClass;
        }

        State LETTER ;
        State ZERO;
        State ONE_TO_NINE;
        State TWO_DOTS;
        State EQUAL;
        State PLUS;
        State DOT;
        State WHITE_SPACE;

        static {
            /* Initialize transitions to a default of Invalid transition */
            for (State state : State.values()) {
                state.LETTER = UNDEFINED_STATE;
                state.ZERO = UNDEFINED_STATE;
                state.ONE_TO_NINE = UNDEFINED_STATE;
                state.TWO_DOTS = UNDEFINED_STATE;
                state.EQUAL = UNDEFINED_STATE;
                state.PLUS = UNDEFINED_STATE;
                state.DOT = UNDEFINED_STATE;
                state.WHITE_SPACE = UNDEFINED_STATE;
            }
            /* Define valid transitions */
            START.LETTER = Q1; START.ZERO = Q5;  START.ONE_TO_NINE = Q6;
            START.TWO_DOTS = Q3; START.PLUS = Q4;  START.WHITE_SPACE = Q2;
            Q1.LETTER =Q1;
            Q2.WHITE_SPACE = Q2;
            Q3.TWO_DOTS = Q7;
            Q5.DOT = Q8;
            Q6.ZERO =Q6; Q6.ONE_TO_NINE = Q6; Q6.DOT = Q8;
            Q7.EQUAL = Q4;
            Q8.ZERO = Q8; Q8.ONE_TO_NINE = Q8;
        }

        State transition(CharClass charClass) {
            return switch (charClass) {
                case LETTER -> this.LETTER;
                case ZERO -> this.ZERO;
                case ONE_TO_NINE -> this.ONE_TO_NINE;
                case TWO_DOTS -> this.TWO_DOTS;
                case EQUAL -> this.EQUAL;
                case PLUS -> this.PLUS;
                case DOT -> this.DOT;
                case WHITE_SPACE -> this.WHITE_SPACE;
            };
        }
    }

    private State currentState = State.START;

    /** Transitions to the next state based on the character class.
     * @param c The character that the DFA is about to read.
     * @return True if the transition is valid, false otherwise.
     */
    public boolean transitionToValidState(char c) {
        CharClass charClass = CharClass.classify(c);
        State nextState = currentState.transition(charClass);
        if (nextState == State.UNDEFINED_STATE) {
            return false;
        }
        currentState = nextState;
        return true;
    }

    /** Checks if the current state is an accept state.
     * @return True if the current state is an accept state, false otherwise.
     */
    public boolean isAcceptState() {
        return currentState.accept;
    }

    /** Resets the DFA to the start state.
     */
    public void reset() {
        currentState = State.START;
    }

    /** Returns the lexical class of the current state.
     * @return The lexical class of the current state.
     */
    public LexicalClass getLexicalClass() {
        return currentState.lexicalClass;
    }

}
