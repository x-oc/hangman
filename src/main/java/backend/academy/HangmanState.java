package backend.academy;

import java.util.Arrays;
import java.util.Objects;

public enum HangmanState {

    STATE0("""
                 ______
                 |    |
                 |
                 |
                 |
                 |
                 |
                 """, 0),
    STATE1("""
                 ______
                 |    |
                 |    o
                 |
                 |
                 |
                 |
                 """, 1),
    STATE2("""
                 ______
                 |    |
                 |    o
                 |    |
                 |
                 |
                 |
                 """, 2),
    STATE3("""
                 ______
                 |    |
                 |    o
                 |   /|
                 |
                 |
                 |
                 """, 3),
    STATE4("""
                 ______
                 |    |
                 |    o
                 |   /|\\
                 |
                 |
                 |
                 """, 4),
    STATE5("""
                 ______
                 |    |
                 |    o
                 |   /|\\
                 |     \\
                 |
                 |
                 """, 5),
    STATE6("""
                 ______
                 |    |
                 |    o
                 |   /|\\
                 |   / \\
                 |
                 |
                 """, -1);

    final String name;
    final Integer number;

    HangmanState(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public static String getState(Integer number) {
        return Arrays.stream(values())
            .filter(state -> Objects.equals(state.number, number))
            .map(state -> state.name)
            .findFirst()
            .orElse(HangmanState.STATE6.name);
    }
}
