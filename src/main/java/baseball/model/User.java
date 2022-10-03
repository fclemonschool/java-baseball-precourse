package baseball.model;

import baseball.utils.IoUtils;
import baseball.utils.ValidationUtils;
import lombok.Data;

@Data
public class User {
    private String userInput;

    public User() {
        this.userInput = IoUtils.getUserInput("숫자를 입력해주세요: ");
        ValidationUtils.validateInput(this.userInput);
    }
}
