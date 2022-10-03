package baseball.utils;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {

    private ValidationUtils() {
    }

    public static boolean checkNotUniqueness(String value) {
        Set<Character> valueSet = new HashSet<>();
        for (int i = 0; i < value.length(); i++) {
            valueSet.add(value.charAt(i));
        }
        return valueSet.size() != 3;
    }

    public static void validateInput(String input) {
        if (ValidationUtils.checkNotUniqueness(input)) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
        }
    }
}
