package backend.academy;

import java.security.SecureRandom;
import java.util.List;
import lombok.Getter;

public enum Category {
    PROGRAMMING("programming"),
    STUDYING("studying"),
    WORKING("working");

    @Getter
    private static final List<Category> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final SecureRandom RANDOM = new SecureRandom();
    final String name;

    Category(String name) {
        this.name = name;
    }

    public static Category randomCategory()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
