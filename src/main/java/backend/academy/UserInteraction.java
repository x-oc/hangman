package backend.academy;

import java.util.Scanner;
import java.util.Set;

public class UserInteraction {

    private final Scanner SCANNER = new Scanner(System.in);

    public String requestNextChar() {
        System.out.print("Введите следующую букву: ");
        String input = SCANNER.nextLine();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        while (input.length() != 1 || !alphabet.contains(input.toLowerCase())) {
            System.out.print("Вам нужно ввести одну единственную букву латинского алфавита: ");
            input = SCANNER.nextLine();
        }
        return input.toLowerCase();
    }

    public void showHangman(Integer misses) {
        StringBuilder hangman = new StringBuilder();
        hangman.append("______\n")
            .append("|    |\n");
        if (misses == 0) {
             hangman.append("|\n")
                    .append("|\n")
                    .append("|\n")
                    .append("|\n")
                    .append("|\n");
        } else if (misses == 1) {
             hangman.append("|    o\n")
                    .append("|\n")
                    .append("|\n")
                    .append("|\n")
                    .append("|\n");
        } else if (misses == 2) {
             hangman.append("|    o\n")
                    .append("|    |\n")
                    .append("|\n")
                    .append("|\n")
                    .append("|\n");
        } else if (misses == 3) {
             hangman.append("|    o\n")
                    .append("|   /|\n")
                    .append("|\n")
                    .append("|\n")
                    .append("|\n");
        } else if (misses == 4) {
             hangman.append("|    o\n")
                    .append("|   /|\\\n")
                    .append("|\n")
                    .append("|\n")
                    .append("|\n");
        } else if (misses == 5) {
             hangman.append("|    o\n")
                    .append("|   /|\\\n")
                    .append("|     \\\n")
                    .append("|\n")
                    .append("|\n");
        } else {
             hangman.append("|    o\n")
                    .append("|   /|\\\n")
                    .append("|   / \\\n")
                    .append("|\n")
                    .append("|\n");
        }

        System.out.print(hangman);
    }

    public void showWord(String word, Set<Character> guessed) {
        StringBuilder toShow = new StringBuilder();
        if (word == null) {
            return;
        }
        for (Character c : word.toCharArray()) {
            if (guessed.contains(c)) {
                toShow.append(c);
                toShow.append(" ");
            } else {
                toShow.append("_ ");
            }
        }
        System.out.println(toShow);
    }

    public void indent() {
        System.out.print("\n".repeat(10));
    }
}
