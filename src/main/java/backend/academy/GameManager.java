package backend.academy;

import java.util.List;
import java.util.Objects;

public class GameManager {

    private WordGenerator wordGenerator;
    private UserInteraction userInteraction;
    private final GameState gameState;

    public GameManager() {
        gameState = new GameState();
        userInteraction = new UserInteraction();
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

    }

    private void greet() {
        userInteraction.println("Привет! Это игра \"Виселица\", давайте приступим!");
    }

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
