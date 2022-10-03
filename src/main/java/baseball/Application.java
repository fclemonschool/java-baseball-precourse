package baseball;

import baseball.utils.IoUtils;
import baseball.utils.RandomUtils;
import baseball.utils.ValidationUtils;

public class Application {
    public static void main(String[] args) {
        boolean notEnd = true;
        String randomNumber = RandomUtils.generateRandomNumber();

        String inputValue = IoUtils.getUserInput("숫자를 입력해주세요: ");
        ValidationUtils.validateInput(inputValue);
    }
}
