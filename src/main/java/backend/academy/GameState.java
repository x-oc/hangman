package backend.academy;

import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameState {

    private Difficulty difficulty;
    private Category category;
    @Setter(AccessLevel.NONE)
    private Integer misses;
    private String word;
    private String description;
    private boolean isHintUsed;
    private Set<Character> guessed;

    @Builder
    public GameState(Difficulty difficulty, Category category, String word, String description) {
        this.difficulty = difficulty;
        this.category = category;
        this.word = word;
        this.description = description;
        misses = 0;
        guessed = new HashSet<>();
        isHintUsed = false;
    }

    public void newAttempt(Character character) {
        guessed.add(character);
    }

    public void incrementMisses() {
        misses++;
    }

}
