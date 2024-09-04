package backend.academy.tests;

import backend.academy.Category;
import backend.academy.Difficulty;
import backend.academy.WordGenerator;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class WordGeneratorTest {

    @RepeatedTest(10)
    void generationRandom() {
        List<String> words = Arrays.asList("computer", "java", "git", "keyboard", "program", "mouse",
            "algorithm", "deadline", "book", "pen", "desk", "pencil", "notebook", "school",
            "university", "mathematics", "knowledge", "money", "time", "salary", "office", "weekend", "development");
        WordGenerator generator = WordGenerator.builder().build();
        MatcherAssert.assertThat(words, Matchers.hasItem(generator.generate()));
    }

    @RepeatedTest(5)
    void generationRandomCategory() {
        List<String> words = Arrays.asList("computer", "java", "git", "book", "pen", "desk", "money", "time");
        WordGenerator generator = WordGenerator.builder()
            .difficulty(Difficulty.EASY)
            .build();
        MatcherAssert.assertThat(words, Matchers.hasItem(generator.generate()));
    }

    @RepeatedTest(5)
    void generationRandomDifficulty() {
        List<String> words = Arrays.asList("computer", "java", "git", "keyboard", "program", "mouse", "algorithm", "deadline");
        WordGenerator generator = WordGenerator.builder()
            .category(Category.PROGRAMMING)
            .build();
        MatcherAssert.assertThat(words, Matchers.hasItem(generator.generate()));
    }

    @Test
    void generation() {
        List<String> words = Arrays.asList("computer", "java", "git");
        WordGenerator generator = WordGenerator.builder()
            .category(Category.PROGRAMMING)
            .difficulty(Difficulty.EASY)
            .build();
        MatcherAssert.assertThat(words, Matchers.hasItem(generator.generate()));
    }

    @Test
    void getDescription() {
        List<String> words = Arrays.asList(
            "An electronic device that processes information.",
            "A programming language used to create applications.",
            "A version control system used to manage code.");
        WordGenerator generator = WordGenerator.builder()
            .category(Category.PROGRAMMING)
            .difficulty(Difficulty.EASY)
            .build();
        generator.generate();
        MatcherAssert.assertThat(words, Matchers.hasItem(generator.getDescription()));
    }
}
