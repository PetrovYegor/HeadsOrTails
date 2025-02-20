package models.players;

import java.util.Objects;

public abstract class Player {//с точки зрения Алексея класс сделан идеально. он может потом поменяться, изменения модели - это нормальный процесс
    private final String name;

    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return Objects.equals(name, player.name);
    }

    public int hashCode(){
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "models.players.Player{" +
                "name='" + name + '\'' +
                '}';
    }
}