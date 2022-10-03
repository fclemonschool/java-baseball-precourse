package baseball.utils;

import camp.nextstep.edu.missionutils.Console;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IoUtils {

    private IoUtils() {
    }

    public static String getUserInput(String msg) {
        log.info(msg);
        return Console.readLine();
    }
}
