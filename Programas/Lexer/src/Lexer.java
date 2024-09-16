import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Lexer {
    private final char[] charactersList;
    private final Queue<Token> tokenQueue;

    public Lexer(File file) throws IOException {
        this.tokenQueue = new LinkedList<>();
        this.charactersList = readFileToCharArray(file);
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

    public char[] getCharactersList() {
        return charactersList;
    }

}
