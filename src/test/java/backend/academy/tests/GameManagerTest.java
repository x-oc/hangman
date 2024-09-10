package backend.academy.tests;

import backend.academy.GameManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameManagerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void processing() {
        System.setIn(new ByteArrayInputStream("EASY\nPROGRAMMING\nn\nn\nn\nn\nn\nn\ny\nn\nn\nn".getBytes()));
        GameManager gameManager = new GameManager();
        gameManager.start();
        List<String> correctAnswers =
            Arrays.asList(new String[] {"Привет! Это игра \"Виселица\". Вам нужно угадать слово по буквам. Ошибиться можно 5 раз. Давайте приступим!\n" +
                "Укажите сложность (EASY, NORMAL, HARD, null): \n" +
                "Укажите категорию (PROGRAMMING, STUDYING, WORKING, null): \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "_ _ _ _ \n" +
                "______\n" +
                "|    |\n" +
                "|\n" +
                "|\n" +
                "|\n" +
                "|\n" +
                "|\n" +
                "Осталось попыток: 6\n" +
                "Хотите использовать подсказку (y/n)?\n" +
                "Введите следующую букву: \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "_ _ _ _ \n" +
                "______\n" +
                "|    |\n" +
                "|    o\n" +
                "|\n" +
                "|\n" +
                "|\n" +
                "|\n" +
                "Осталось попыток: 5\n" +
                "Хотите использовать подсказку (y/n)?\n" +
                "Введите следующую букву: \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "_ _ _ _ \n" +
                "______\n" +
                "|    |\n" +
                "|    o\n" +
                "|    |\n" +
                "|\n" +
                "|\n" +
                "|\n" +
                "Осталось попыток: 4\n" +
                "Хотите использовать подсказку (y/n)?\n" +
                "Введите следующую букву: \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "_ _ _ _ \n" +
                "______\n" +
                "|    |\n" +
                "|    o\n" +
                "|   /|\n" +
                "|\n" +
                "|\n" +
                "|\n" +
                "Осталось попыток: 3\n" +
                "Хотите использовать подсказку (y/n)?\n" +
                "A programming language used to create applications.\n" +
                "Введите следующую букву: \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "_ _ _ _ \n" +
                "______\n" +
                "|    |\n" +
                "|    o\n" +
                "|   /|\\\n" +
                "|\n" +
                "|\n" +
                "|\n" +
                "Осталось попыток: 2\n" +
                "Введите следующую букву: \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "_ _ _ _ \n" +
                "______\n" +
                "|    |\n" +
                "|    o\n" +
                "|   /|\\\n" +
                "|     \\\n" +
                "|\n" +
                "|\n" +
                "Осталось попыток: 1\n" +
                "Введите следующую букву: ______\n" +
                "|    |\n" +
                "|    o\n" +
                "|   /|\\\n" +
                "|   / \\\n" +
                "|\n" +
                "|\n" +
                "Вы проиграли! Правильное слово: java",

                "Привет! Это игра \"Виселица\". Вам нужно угадать слово по буквам. Ошибиться можно 5 раз. Давайте приступим!\n" +
                    "Укажите сложность (EASY, NORMAL, HARD, null): \n" +
                    "Укажите категорию (PROGRAMMING, STUDYING, WORKING, null): \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "_ _ _ \n" +
                    "______\n" +
                    "|    |\n" +
                    "|\n" +
                    "|\n" +
                    "|\n" +
                    "|\n" +
                    "|\n" +
                    "Осталось попыток: 6\n" +
                    "Хотите использовать подсказку (y/n)?\n" +
                    "Введите следующую букву: \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "_ _ _ \n" +
                    "______\n" +
                    "|    |\n" +
                    "|    o\n" +
                    "|\n" +
                    "|\n" +
                    "|\n" +
                    "|\n" +
                    "Осталось попыток: 5\n" +
                    "Хотите использовать подсказку (y/n)?\n" +
                    "Введите следующую букву: \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "_ _ _ \n" +
                    "______\n" +
                    "|    |\n" +
                    "|    o\n" +
                    "|    |\n" +
                    "|\n" +
                    "|\n" +
                    "|\n" +
                    "Осталось попыток: 4\n" +
                    "Хотите использовать подсказку (y/n)?\n" +
                    "Введите следующую букву: \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "_ _ _ \n" +
                    "______\n" +
                    "|    |\n" +
                    "|    o\n" +
                    "|   /|\n" +
                    "|\n" +
                    "|\n" +
                    "|\n" +
                    "Осталось попыток: 3\n" +
                    "Хотите использовать подсказку (y/n)?\n" +
                    "A version control system used to manage code.\n" +
                    "Введите следующую букву: \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "_ _ _ \n" +
                    "______\n" +
                    "|    |\n" +
                    "|    o\n" +
                    "|   /|\\\n" +
                    "|\n" +
                    "|\n" +
                    "|\n" +
                    "Осталось попыток: 2\n" +
                    "Введите следующую букву: \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "_ _ _ \n" +
                    "______\n" +
                    "|    |\n" +
                    "|    o\n" +
                    "|   /|\\\n" +
                    "|     \\\n" +
                    "|\n" +
                    "|\n" +
                    "Осталось попыток: 1\n" +
                    "Введите следующую букву: ______\n" +
                    "|    |\n" +
                    "|    o\n" +
                    "|   /|\\\n" +
                    "|   / \\\n" +
                    "|\n" +
                    "|\n" +
                    "Вы проиграли! Правильное слово: git",

                "Привет! Это игра \"Виселица\". Вам нужно угадать слово по буквам. Ошибиться можно 5 раз. Давайте приступим!\n" +
                    "Укажите сложность (EASY, NORMAL, HARD, null): \n" +
                    "Укажите категорию (PROGRAMMING, STUDYING, WORKING, null): \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "_ _ _ _ _ _ _ _ \n" +
                    "______\n" +
                    "|    |\n" +
                    "|\n" +
                    "|\n" +
                    "|\n" +
                    "|\n" +
                    "|\n" +
                    "Осталось попыток: 6\n" +
                    "Хотите использовать подсказку (y/n)?\n" +
                    "Введите следующую букву: \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "_ _ _ _ _ _ _ _ \n" +
                    "______\n" +
                    "|    |\n" +
                    "|    o\n" +
                    "|\n" +
                    "|\n" +
                    "|\n" +
                    "|\n" +
                    "Осталось попыток: 5\n" +
                    "Хотите использовать подсказку (y/n)?\n" +
                    "Введите следующую букву: \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "_ _ _ _ _ _ _ _ \n" +
                    "______\n" +
                    "|    |\n" +
                    "|    o\n" +
                    "|    |\n" +
                    "|\n" +
                    "|\n" +
                    "|\n" +
                    "Осталось попыток: 4\n" +
                    "Хотите использовать подсказку (y/n)?\n" +
                    "Введите следующую букву: \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "_ _ _ _ _ _ _ _ \n" +
                    "______\n" +
                    "|    |\n" +
                    "|    o\n" +
                    "|   /|\n" +
                    "|\n" +
                    "|\n" +
                    "|\n" +
                    "Осталось попыток: 3\n" +
                    "Хотите использовать подсказку (y/n)?\n" +
                    "An electronic device that processes information.\n" +
                    "Введите следующую букву: \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "_ _ _ _ _ _ _ _ \n" +
                    "______\n" +
                    "|    |\n" +
                    "|    o\n" +
                    "|   /|\\\n" +
                    "|\n" +
                    "|\n" +
                    "|\n" +
                    "Осталось попыток: 2\n" +
                    "Введите следующую букву: \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "_ _ _ _ _ _ _ _ \n" +
                    "______\n" +
                    "|    |\n" +
                    "|    o\n" +
                    "|   /|\\\n" +
                    "|     \\\n" +
                    "|\n" +
                    "|\n" +
                    "Осталось попыток: 1\n" +
                    "Введите следующую букву: ______\n" +
                    "|    |\n" +
                    "|    o\n" +
                    "|   /|\\\n" +
                    "|   / \\\n" +
                    "|\n" +
                    "|\n" +
                    "Вы проиграли! Правильное слово: computer"
            });
        Assertions.assertThat(outContent.toString().trim().replace("\r", "")).isIn(correctAnswers);
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}
