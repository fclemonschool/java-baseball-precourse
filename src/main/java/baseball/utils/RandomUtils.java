package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {

    private RandomUtils() {
    }

    public static String generateRandomNumber() {
        StringBuilder randomBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            randomBuilder.append(Randoms.pickNumberInRange(1, 9));
        }

        if (ValidationUtils.checkNotUniqueness(String.valueOf(randomBuilder))) {
            randomBuilder = new StringBuilder(generateRandomNumber());
        }
        return randomBuilder.toString();
    }
}
