package backend.academy;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        UserInteraction interaction = new UserInteraction();
        String letter = interaction.requestNextChar();
        System.out.println("Ваша буква: " + letter);
    }
}
