package backend.academy;

import java.util.List;
import java.util.Objects;

public class GameManager {

    private WordGenerator wordGenerator;
    private UserInteraction userInteraction;
    private boolean isHintUsed;
    private final GameState gameState;
    private final Integer maxMisses = 5;

    public GameManager() {
        gameState = new GameState();
        userInteraction = new UserInteraction(maxMisses);
        isHintUsed = false;
    }

    public void start() {

        greet();

        Difficulty difficulty = askDifficulty();
        Category category = askCategory();

        wordGenerator = WordGenerator.builder()
            .difficulty(difficulty)
            .category(category)
            .build();

        gameState.difficulty(difficulty);
        gameState.category(category);
        gameState.word(wordGenerator.generate());
        gameState.description(wordGenerator.getDescription());

        boolean isGameProcessing = true;
        while (isGameProcessing) {
            isGameProcessing = nextIteration();
        }
    }

    private boolean nextIteration() {

        userInteraction.showWord(gameState.word(), gameState.guessed());
        userInteraction.showHangman(gameState.misses());

        suggestHint();

        Character userChar = userInteraction.requestNextChar();
        gameState.newAttempt(userChar);

        if (gameState.word().indexOf(userChar) == -1) {
            gameState.incrementMisses();
        }

        if (gameState.misses() > maxMisses) {
            userInteraction.showHangman(gameState.misses());
            userInteraction.println("Вы проиграли! Правильное слово: " + gameState.word());
            return false;
        } else if (gameState.guessed().containsAll(gameState.word().chars().mapToObj(c -> (char) c).toList())) {
            userInteraction.showWord(gameState.word(), gameState.guessed());
            userInteraction.println("Вы выиграли!");
            return false;
        }

        return true;
    }

    private void suggestHint() {

        if (!isHintUsed) {
            String userInput = userInteraction.requestParameter("Хотите использовать подсказку (y/n)?");
            if (Objects.equals(userInput, "y")) {
                userInteraction.println(gameState.description());
                isHintUsed = true;
            }
        }
    }

    private void greet() {
        userInteraction.println("Привет! Это игра \"Виселица\", давайте приступим!");
    }

    @SuppressWarnings("MultipleStringLiterals")
    private Difficulty askDifficulty() {
        List<String> difficulties = Difficulty.VALUES().stream().map(Enum::name).toList();
        String userInput = userInteraction.requestParameter("Укажите сложность ("
            + String.join(", ", difficulties) + ", null): ");
        while (!difficulties.contains(userInput) && !Objects.equals(userInput, "null")) {
            userInput = userInteraction.requestParameter("Некорректная сложность (выберите среди "
                + String.join(", ", difficulties) + ", null): ");
        }
        if (Objects.equals(userInput, "null")) {
            return null;
        }
        return Difficulty.valueOf(userInput);
    }

    @SuppressWarnings("MultipleStringLiterals")
    private Category askCategory() {
        List<String> categories = Category.VALUES().stream().map(Enum::name).toList();
        String userInput = userInteraction.requestParameter("Укажите категорию ("
            + String.join(", ", categories) + ", null): ");
        while (!categories.contains(userInput) && !Objects.equals(userInput, "null")) {
            userInput = userInteraction.requestParameter("Некорректная категория (выберите среди "
                + String.join(", ", categories) + ", null): ");
        }
        if (Objects.equals(userInput, "null")) {
            return null;
        }
        return Category.valueOf(userInput);
    }
}
