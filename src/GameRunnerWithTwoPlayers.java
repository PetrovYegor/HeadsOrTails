import models.Coin;
import models.players.Player;
import models.players.RealPlayer;

import java.util.List;

public class GameRunnerWithTwoPlayers{
    public static void main(String[] args){
        Player player1 = new RealPlayer("Иванов");
        Player player2 = new RealPlayer("Петров");

        Coin coin = new Coin(){
            @Override
            public Side flip(){
                return Coin.Side.HEADS;
            }
        };

        Game game = new Game(List.of(player1, player2), coin);

        game.start();
    }
}