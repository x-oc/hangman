package backend.academy;

import java.util.List;
import java.util.Random;

public enum Category {
    PROGRAMMING("programming"),
    STUDYING("studying"),
    WORKING("working");

    final String name;

    Category(String name) {
        this.name = name;
    }

    private static final List<Category> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Category randomCategory()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
