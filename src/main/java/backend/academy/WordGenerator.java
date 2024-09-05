package backend.academy;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

@Builder
public class WordGenerator {

    @SuppressWarnings("MemberName")
    private final Map<String, Map<String, List<Pair<String, String>>>> DICTIONARY = Map.of(
        Category.PROGRAMMING.name, Map.of(
            Difficulty.EASY.name, Arrays.asList(
                new ImmutablePair<>("computer", "An electronic device that processes information."),
                new ImmutablePair<>("java", "A programming language used to create applications."),
                new ImmutablePair<>("git", "A version control system used to manage code.")),
            Difficulty.NORMAL.name, Arrays.asList(
                new ImmutablePair<>("keyboard", "A device for entering text into a computer."),
                new ImmutablePair<>("program", "A set of instructions for a computer."),
                new ImmutablePair<>("mouse", "An input device that controls a cursor on the screen.")),
            Difficulty.HARD.name, Arrays.asList(
                new ImmutablePair<>("algorithm", "A step-by-step instruction for solving a problem."),
                new ImmutablePair<>("deadline", "A set date for the completion of work."))),
        Category.STUDYING.name, Map.of(
            Difficulty.EASY.name, Arrays.asList(
                new ImmutablePair<>("book", "A publication containing written text."),
                new ImmutablePair<>("pen", "A writing tool."),
                new ImmutablePair<>("desk", "A piece of furniture used for work or eating.")),
            Difficulty.NORMAL.name, Arrays.asList(
                new ImmutablePair<>("pencil", "A tool used for writing and drawing."),
                new ImmutablePair<>("notebook", "A small book for writing notes."),
                new ImmutablePair<>("school", "An institution for the education of children.")),
            Difficulty.HARD.name, Arrays.asList(
                new ImmutablePair<>("university", "A higher education institution."),
                new ImmutablePair<>("mathematics", "The science of numbers, shapes, and relationships."),
                new ImmutablePair<>("knowledge", "Information acquired through learning."))),
        Category.WORKING.name, Map.of(
            Difficulty.EASY.name, Arrays.asList(
                new ImmutablePair<>("money", "A medium of exchange for goods and services."),
                new ImmutablePair<>("time", "The duration of existence.")),
            Difficulty.NORMAL.name, Arrays.asList(
                new ImmutablePair<>("salary", "Monetary compensation for work."),
                new ImmutablePair<>("office", "A room for working.")),
            Difficulty.HARD.name, Arrays.asList(
                new ImmutablePair<>("weekend", "Days of rest from work."),
                new ImmutablePair<>("development", "The process of creating something new."))));

    private Category category;
    private Difficulty difficulty;
    private Pair<String, String> lastChosen;
    @SuppressWarnings("MemberName")
    private final SecureRandom RANDOM = new SecureRandom();

    public String generate() {
        if (this.category == null) {
            category = Category.randomCategory();
        }
        if (this.difficulty == null) {
            difficulty = Difficulty.randomDifficulty();
        }
        List<Pair<String, String>> words = DICTIONARY.get(category.name).get(difficulty.name);
        lastChosen = words.get(RANDOM.nextInt(words.size()));
        return lastChosen.getLeft();
    }

    public String getDescription() {
        if (lastChosen == null) {
            return null;
        }
        return lastChosen.getRight();
    }
}
