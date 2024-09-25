package backend.academy;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class UserInteraction {

    @SuppressWarnings("MemberName")
    private final Scanner SCANNER = new Scanner(System.in, StandardCharsets.UTF_8);
    private final PrintStream printStream = new PrintStream(System.out, false, StandardCharsets.UTF_8);
    private final Integer maxMisses;
    private final static String NULL = "null";

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
        String hangman = HangmanState.getState(misses);
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

    public void greet() {
        println("Привет! Это игра \"Виселица\". Вам нужно угадать слово по буквам. Ошибиться можно "
            + maxMisses +  " раз. Давайте приступим!");
    }

    public Difficulty getDifficulty() {
        String difficultyPrompt = "Укажите сложность (%s, null): ";
        String difficultyPromptError = "Некорректная сложность (выберите среди %s, null): ";
        String difficulties = Difficulty.VALUES().stream().map(Enum::name).collect(Collectors.joining(", "));
        String userInput = requestParameter(String.format(difficultyPrompt, difficulties));
        while (!difficulties.contains(userInput) && !NULL.equals(userInput)) {
            userInput = requestParameter(requestParameter(String.format(difficultyPromptError, difficulties)));
        }
        if (NULL.equals(userInput)) {
            return null;
        }
        return Difficulty.valueOf(userInput);
    }

    public Category getCategory() {
        String categoryPrompt = "Укажите категорию (%s, null): ";
        String categoryPromptError = "Некорректная категория (выберите среди %s, null): ";
        String categories = Category.VALUES().stream().map(Enum::name).collect(Collectors.joining(", "));
        String userInput = requestParameter(String.format(categoryPrompt, categories));
        while (!categories.contains(userInput) && !NULL.equals(userInput)) {
            userInput = requestParameter(String.format(categoryPromptError, categories));
        }
        if (NULL.equals(userInput)) {
            return null;
        }
        return Category.valueOf(userInput);
    }
}
