package heads_or_tails;

public class Player {
    private final String name;
    private final int guess;

    Player(String name, int guess) {
        this.name = name;
        this.guess = guess;
    }

    public String getName() {
        return name;
    }

    public int getGuess() {
        return guess;
    }
}
