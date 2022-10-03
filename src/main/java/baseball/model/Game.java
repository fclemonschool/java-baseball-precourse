package baseball.model;

import baseball.utils.IoUtils;
import baseball.utils.ValidationUtils;
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

    public void calculateCounts(String target) {
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

    public String calculateResult() {
        int keyCount = counts.getKeyCount();
        int strikeCount = counts.getStrikeCount();

        logCalculateResult();
        if (keyCount == strikeCount && strikeCount == 3) {
            log.info("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return calculateRestartOrEnd();
        }
        return null;
    }

    public void logCalculateResult() {
        log.info(makeCalculateLog(new StringBuilder(), counts.getKeyCount(), counts.getStrikeCount()));
    }

    public String makeCalculateLog(StringBuilder stringBuilder, int keyCount, int strikeCount) {
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

    public String calculateRestartOrEnd() {
        String value = IoUtils.getUserInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        ValidationUtils.validateRestartOrEndInput(value);
        if (value.equals("1")) {
            return "1";
        }
        return "2";
    }
}
