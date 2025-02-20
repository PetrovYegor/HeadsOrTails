import models.Coin;
import models.players.Bot;
import models.players.Player;

import java.util.List;

public class GameRunnerWithBots{
    public static void main(String[] args){
        Player player1 = new Bot("Bot1");
        Player player2 = new Bot("Bot2");
        Player player3 = new Bot("Bot3");

        Coin coin = new Coin();

        Game game = new Game(List.of(player1, player2, player3), coin);

        game.start();
    }
}