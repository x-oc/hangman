package backend.academy;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        WordGenerator wordGenerator = WordGenerator.builder()
            .category(Category.PROGRAMMING)
            .difficulty(Difficulty.EASY)
            .build();
        System.out.println(wordGenerator.generate());
    }
}
