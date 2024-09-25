package backend.academy;

import java.util.Objects;

public class GameManager {

    private final UserInteraction userInteraction;
    private GameState gameState;
    private static final Integer MAX_MISSES = 5;

    public GameManager() {
        userInteraction = new UserInteraction(MAX_MISSES);
    }

    public void start() {

        userInteraction.greet(MAX_MISSES);

        Difficulty difficulty = userInteraction.getDifficulty();
        Category category = userInteraction.getCategory();

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
}
