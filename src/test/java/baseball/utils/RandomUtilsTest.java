package baseball.utils;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class RandomUtilsTest {

    @Test
    void generateRandomNumber() {
        String firstValue = RandomUtils.generateRandomNumber();
        String secondValue = RandomUtils.generateRandomNumber();

        assertNotEquals(firstValue, secondValue);
    }
}