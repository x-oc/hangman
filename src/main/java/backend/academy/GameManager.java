package backend.academy;

import java.util.List;
import java.util.Objects;

public class GameManager {

    private final UserInteraction userInteraction;
    private GameState gameState;
    private static final Integer MAX_MISSES = 5;

    public GameManager() {
        userInteraction = new UserInteraction(MAX_MISSES);
    }

    public void start() {

        greet();

        Difficulty difficulty = getDifficulty();
        Category category = getCategory();

        WordGenerator wordGenerator = WordGenerator.builder()
            .difficulty(difficulty)
            .category(category)
            .build();

        gameState = GameState.builder()
            .difficulty(difficulty)
            .category(category)
            .word(wordGenerator.generate())
            .description(wordGenerator.getDescription())
            .build();

        boolean isGameProcessing = true;
        while (isGameProcessing) {
            isGameProcessing = nextIteration();
        }
    }

    private boolean nextIteration() {

        userInteraction.indent();
        userInteraction.showWord(gameState.word(), gameState.guessed());
        userInteraction.showHangman(gameState.misses());
        userInteraction.println("Осталось попыток: " + (MAX_MISSES + 1 - gameState.misses()));

        suggestHint();

        Character userChar = userInteraction.requestNextChar();
        gameState.newAttempt(userChar);

        if (gameState.word().indexOf(userChar) == -1) {
            gameState.incrementMisses();
        }

        if (gameState.misses() > MAX_MISSES) {
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

        if (!gameState.isHintUsed()) {
            String userInput = userInteraction.requestParameter("Хотите использовать подсказку (y/n)?");
            if (Objects.equals(userInput, "y")) {
                userInteraction.println(gameState.description());
                gameState.isHintUsed(true);
            }
        }
    }

    private void greet() {
        userInteraction.println("Привет! Это игра \"Виселица\". Вам нужно угадать слово по буквам. Ошибиться можно "
            + MAX_MISSES +  " раз. Давайте приступим!");
    }

    @SuppressWarnings("MultipleStringLiterals")
    private Difficulty getDifficulty() {
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
    private Category getCategory() {
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
