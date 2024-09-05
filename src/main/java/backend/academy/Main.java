package backend.academy;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {

    @SuppressWarnings("RegexpSinglelineJava")
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.start();
    }
}
