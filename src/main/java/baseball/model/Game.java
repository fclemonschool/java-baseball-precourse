package baseball.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private final Counts counts;
    private final User user;

    public Game(Counts counts, User user) {
        this.counts = counts;
        this.user = user;
    }

    public Counts calculateCounts(String target) {
        Map<Character, Integer> inputMap = new HashMap<>();
        Map<Character, Integer> randomNumberMap = new HashMap<>();

        for (int i = 0; i < user.getUserInput().length(); i++) {
            inputMap.put(user.getUserInput().charAt(i), i);
            randomNumberMap.put(target.charAt(i), i);
        }
        inputMap.forEach((key, value) -> {
            calculateKeyCount(randomNumberMap, key);
            calculateStrikeCount(randomNumberMap, key, value);
        });
        return counts;
    }

    public void calculateKeyCount(Map<Character, Integer> randomNumberMap, Character key) {
        if (randomNumberMap.containsKey(key)) {
            counts.setKeyCount(counts.getKeyCount() + 1);
        }
    }

    public void calculateStrikeCount(Map<Character, Integer> randomNumberMap, Character key, Integer value) {
        if (randomNumberMap.containsKey(key) && Objects.equals(randomNumberMap.get(key), value)) {
            counts.setStrikeCount(counts.getStrikeCount() + 1);
        }
    }
}
