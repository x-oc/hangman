package backend.academy;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Set;

public class UserInteraction {

    @SuppressWarnings("MemberName")
    private final Scanner SCANNER = new Scanner(System.in, StandardCharsets.UTF_8);
    private final PrintStream printStream = new PrintStream(System.out, false, StandardCharsets.UTF_8);
    private final Integer maxMisses;

    public UserInteraction(Integer maxMisses) {
        this.maxMisses = maxMisses;
    }

    public Character requestNextChar() {
        printStream.print("Введите следующую букву: ");
        String input = SCANNER.nextLine().toLowerCase();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        while (input.length() != 1 || !alphabet.contains(input)) {
            printStream.print("Вам нужно ввести одну единственную букву латинского алфавита: ");
            input = SCANNER.nextLine();
        }
        return input.charAt(0);
    }

    public void println(String message) {
        printStream.println(message);
    }

    public String requestParameter(String message) {
        printStream.println(message);
        return SCANNER.nextLine();
    }

    @SuppressWarnings("MagicNumber")
    public void showHangman(Integer misses) {
        StringBuilder hangman = new StringBuilder();
        hangman.append("______\n")
            .append("|    |\n");
         if (misses > maxMisses) {
            hangman.append("""
                 |    o
                 |   /|\\
                 |   / \\
                 |
                 |
                 """);
        } else if (misses == 0) {
             hangman.append("""
                 |
                 |
                 |
                 |
                 |
                 """);
        } else if (misses == 1) {
             hangman.append("""
                 |    o
                 |
                 |
                 |
                 |
                 """);
        } else if (misses == 2) {
             hangman.append("""
                 |    o
                 |    |
                 |
                 |
                 |
                 """);
        } else if (misses == 3) {
             hangman.append("""
                 |    o
                 |   /|
                 |
                 |
                 |
                 """);
        } else if (misses == 4) {
             hangman.append("""
                 |    o
                 |   /|\\
                 |
                 |
                 |
                 """);
        } else if (misses == 5) {
             hangman.append("""
                 |    o
                 |   /|\\
                 |     \\
                 |
                 |
                 """);
        }

        printStream.print(hangman);
    }

    public void showWord(String word, Set<Character> guessed) {
        StringBuilder toShow = new StringBuilder();
        if (word == null) {
            return;
        }
        for (Character c : word.toCharArray()) {
            if (guessed.contains(c)) {
                toShow.append(c);
                toShow.append(' ');
            } else {
                toShow.append("_ ");
            }
        }
        printStream.println(toShow);
    }

    @SuppressWarnings("MagicNumber")
    public void indent() {
        printStream.print("\n".repeat(10));
    }
}
