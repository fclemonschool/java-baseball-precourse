package baseball.model;

import lombok.Data;

@Data
public class Counts {
    private int keyCount;
    private int strikeCount;
    private int ballCount;

    public int getBallCount() {
        return keyCount - strikeCount;
    }
}
