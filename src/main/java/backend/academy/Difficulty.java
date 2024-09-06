package backend.academy;

import java.security.SecureRandom;
import java.util.List;
import lombok.Getter;

public enum Difficulty {
    EASY("easy"),
    NORMAL("normal"),
    HARD("hard");

    final String name;

    Difficulty(String name) {
        this.name = name;
    }

    @Getter
    private static final List<Difficulty> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final SecureRandom RANDOM = new SecureRandom();

    public static Difficulty randomDifficulty()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
