import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
            //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        if (args.length != 1) {
            System.err.println("Usage: java Main <file-path>");
            System.exit(1);
        }

        String filePath = args[0];

        File inputFile = new File(filePath);

        if (!inputFile.exists() || !inputFile.isFile()) {
            System.err.println("The provided path does not exist or is not a file: " + filePath);
            System.exit(1);
        }

        Lexer lexer = new Lexer(inputFile);

        lexer.tokenize();

        lexer.getTokens().forEach(System.out::println);

    }
}