package backend.academy.tests;

import backend.academy.Category;
import backend.academy.Difficulty;
import backend.academy.GameState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;

public class GameStateTest {

    @Test
    void commonGameStateUsage() {
        GameState gameState = GameState.builder()
            .difficulty(Difficulty.EASY)
            .category(Category.PROGRAMMING)
            .word("git")
            .description("A version control system used to manage code.")
            .build();

        Assertions.assertEquals("git", gameState.word());
        Assertions.assertEquals("A version control system used to manage code.", gameState.description());
        Assertions.assertEquals(Category.PROGRAMMING, gameState.category());
        Assertions.assertEquals(Difficulty.EASY, gameState.difficulty());
        Assertions.assertEquals(0, gameState.misses());
        Assertions.assertEquals(new HashSet<>(), gameState.guessed());

        gameState.incrementMisses();
        gameState.newAttempt('a');
        Assertions.assertEquals(1, gameState.misses());
        Assertions.assertEquals(new HashSet<>(List.of('a')), gameState.guessed());

        gameState.newAttempt('b');
        Assertions.assertEquals(1, gameState.misses());
        Assertions.assertEquals(new HashSet<>(List.of('a', 'b')), gameState.guessed());

    }
}
