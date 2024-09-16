import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Lexer {
    private char[] charactersList;
    private Queue<Token> tokenQueue;
    private char bufferedChar ;
    private int currentIndex;
    private final StringBuilder currentLexeme = new StringBuilder();

    public Lexer(File file) throws IOException {
        this.tokenQueue = new LinkedList<>();
        this.charactersList = readFileToCharArray(file);
        this.bufferedChar = ' ';
        this.currentIndex = -1;
    }

    private char goToNextChar() {
        this.bufferedChar = this.charactersList[++this.currentIndex];
        return this.bufferedChar;
    }

    /** Reads the content of a file and returns it as a char array.
     * @param file The file to read.
     * @return The content of the file as a char array.
     * @throws IOException If an I/O error occurs.
     */
    private char[] readFileToCharArray(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder fileContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
            return fileContent.toString().toCharArray();
        }
    }

    private void addToken(LexicalClass lexicalClass, String lexeme) {
        tokenQueue.add(new Token(lexicalClass, lexeme));
    }

    /** Tokenizes the content of the file.
     * The tokens are stored in the tokenQueue.
     */
    public void tokenize() {
        Automata dfa = new Automata();
        this.currentLexeme.setLength(0);

        while (currentIndex < charactersList.length - 1) {
            char currentChar = goToNextChar();
            if (dfa.transitionToValidState(currentChar)) {
                currentLexeme.append(currentChar);
            } else {
                if (dfa.isAcceptState()) {
                    addToken(dfa.getLexicalClass(), currentLexeme.toString());
                    currentLexeme.setLength(0);
                    dfa.reset();
                    currentIndex--;
                } else {
                    System.out.println("Lexical error: " + currentLexeme);
                    System.exit(1);
                }
            }
        }
    }

    public Queue<Token> getTokens() {
        return tokenQueue;
    }
}
