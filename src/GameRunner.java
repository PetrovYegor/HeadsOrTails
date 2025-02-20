import dialog.Dialog;
import dialog.IntegerMinMaxDialog;
import models.Coin;
import models.players.Player;
import models.players.RealPlayer;

import java.util.ArrayList;
import java.util.List;

public class GameRunner{
    private static final String START_MESSAGE = """
	*************
	Орел и решка
	*************
	""";
    private static final int MIN = 1;
    private static final int MAX = 10;

    public static void main(String[] args){
        System.out.println(START_MESSAGE);

        Dialog<Integer> dialog = new IntegerMinMaxDialog("Введите количество игроков  (%d - %d): ".formatted(MIN, MAX)
                , "Введите число, соответствующее условию", MIN, MAX);

        //теперь из диалога принимаем количество игроков
        var amountPlayers = dialog.input();

        List<Player> players = createPlayers(amountPlayers);
        Coin coin = new Coin();

        Game game = new Game(players, coin);
        game.start();
    }

    private static List<Player> createPlayers(int amount) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < amount; i++){
            players.add(new RealPlayer("Игрок" + (i+1)));
        }
        return players;
    }
}