package backend.academy.tests;

import backend.academy.GameManager;
import backend.academy.UserInteraction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

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
        GameManager gameManager = new GameManager();
        //gameManager.start();todo
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}
