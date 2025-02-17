package heads_or_tails;

import java.util.Random;

public class Coin {
    private final CoinSide heads;
    private final CoinSide tails;
    private final Random random;

    Coin() {
        heads = new CoinSide(0, "Орел");
        tails = new CoinSide(1, "Решка");
        random = new Random();
    }

    CoinSide flipCoin() {
        int zeroOrOne = random.nextInt(2);
        if (zeroOrOne == 0) {
            return heads;
        } else {
            return tails;
        }
    }
}
