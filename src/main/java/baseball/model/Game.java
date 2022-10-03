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

    public String makeCalculateLog(int keyCount, int strikeCount) {
        StringBuilder stringBuilder = new StringBuilder();
        if (keyCount > 0 && keyCount == strikeCount) {
            return stringBuilder.append(strikeCount).append("스트라이크").toString();
        }
        if (strikeCount != keyCount && strikeCount != 0) {
            return stringBuilder.append(counts.getBallCount()).append("볼 ").append(strikeCount).append("스트라이크")
                    .toString();
        }
        if (keyCount != 0 && strikeCount == 0) {
            return stringBuilder.append(counts.getBallCount()).append("볼").toString();
        }
        return stringBuilder.append("낫싱").toString();
    }
}
