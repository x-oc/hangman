package backend.academy;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lombok.Builder;

@Builder
public class WordGenerator {

    @SuppressWarnings("MemberName")
    private final Map<String, Map<String, List<String>>> DICTIONARY = Map.of(
        Category.PROGRAMMING.name, Map.of(Difficulty.EASY.name, Arrays.asList("computer", "java", "git"),
                                            Difficulty.NORMAL.name, Arrays.asList("keyboard", "program", "mouse"),
                                            Difficulty.HARD.name, Arrays.asList("algorithm", "deadline")),
        Category.STUDYING.name, Map.of(Difficulty.EASY.name, Arrays.asList("book", "pen", "desk"),
                                        Difficulty.NORMAL.name, Arrays.asList("pencil", "notebook", "school"),
                                        Difficulty.HARD.name, Arrays.asList("university", "mathematics", "knowledge")),
        Category.WORKING.name, Map.of(Difficulty.EASY.name, Arrays.asList("money", "time"),
                                        Difficulty.NORMAL.name, Arrays.asList("salary", "office"),
                                        Difficulty.HARD.name, Arrays.asList("weekend", "development")));

    private Category category;
    private Difficulty difficulty;
    @SuppressWarnings("MemberName")
    private final SecureRandom RANDOM = new SecureRandom();

    public String generate() {
        if (this.category == null) {
            category = Category.randomCategory();
        }
        if (this.difficulty == null) {
            difficulty = Difficulty.randomDifficulty();
        }
        List<String> words = DICTIONARY.get(category.name).get(difficulty.name);
        return words.get(RANDOM.nextInt(words.size()));
    }
}
