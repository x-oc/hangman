package backend.academy;

import java.util.List;
import java.util.Random;

public enum Difficulty {
    EASY("easy"),
    NORMAL("normal"),
    HARD("hard");

    final String name;

    Difficulty(String name) {
        this.name = name;
    }

    private static final List<Difficulty> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Difficulty randomDifficulty()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
