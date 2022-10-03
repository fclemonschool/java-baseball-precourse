package baseball;

import baseball.model.Counts;
import baseball.model.Game;
import baseball.model.User;
import baseball.utils.RandomUtils;

public class Application {
    public static void main(String[] args) {
        boolean notEnd = true;
        String randomNumber = RandomUtils.generateRandomNumber();

        while (notEnd) {
            Game game = new Game(new Counts(), new User());
            game.calculateCounts(randomNumber);
            randomNumber = game.checkRestart(randomNumber, game.calculateResult());
        }
    }
}
