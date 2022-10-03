package baseball.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidationUtilsTest {

    @Test
    void checkNotUniqueness() {
        boolean firstResult = ValidationUtils.checkNotUniqueness("123");
        boolean secondResult = ValidationUtils.checkNotUniqueness("1234");
        boolean thirdResult = ValidationUtils.checkNotUniqueness("122");

        assertFalse(firstResult);
        assertTrue(secondResult);
        assertTrue(thirdResult);
    }

    @Test
    void validateInput() {
        assertThatThrownBy(() -> ValidationUtils.validateInput("1234")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 입력값입니다.");
    }

    @Test
    void validateRestartOrEndInput() {
        assertThatThrownBy(() -> ValidationUtils.validateRestartOrEndInput("3")).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("잘못된 입력값입니다. 1이나 2를 입력하세요.");
    }
}