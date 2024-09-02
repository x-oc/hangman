package backend.academy.tests;

import backend.academy.UserInteraction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class UserInteractionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private final UserInteraction interaction = new UserInteraction();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void fullHangmanOutput() {
        String hangman =
            """
                ______
                |    |
                |    o
                |   /|\\
                |   / \\
                |
                |
                """;

        interaction.showHangman(6);

        Assertions.assertEquals(hangman, outContent.toString());
    }

    private static Stream<Arguments> provideStringsForShowWord() {
        return Stream.of(
            Arguments.of("null", new HashSet<>(Arrays.asList('n', 'u', 'a')), "n u _ _"),
            Arguments.of("", new HashSet<>(Arrays.asList('a', 'b')), ""),
            Arguments.of(null, null, ""),
            Arguments.of("aaaa", new HashSet<>(Arrays.asList('a', 'b')), "a a a a"),
            Arguments.of("abcd", new HashSet<>(Arrays.asList('e', 'f')), "_ _ _ _")
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForShowWord")
    void showWord(String word, Set<Character> guessed, String correctOutput) {
        interaction.showWord(word, guessed);
        Assertions.assertEquals(correctOutput, outContent.toString().strip());
    }

    @Test
    void indent() {
        interaction.indent();
        Assertions.assertEquals("\n".repeat(10), outContent.toString());
    }

    @Test
    void nextCharInput() {
        System.setIn(new ByteArrayInputStream("ab\na\n".getBytes()));
        //interaction.requestNextChar();
        //Assertions.assertEquals("Введите следующую букву: Введите следующую букву: ", outContent.toString());
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}
