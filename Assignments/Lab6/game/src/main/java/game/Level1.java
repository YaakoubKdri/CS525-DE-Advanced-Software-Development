package game;

public class Level1 implements Level {
    @Override
    public void addPoints(Game game, int points) {
        int total = game.getPoints() + points;

        if(total > 10){
            game.setPoints(total + 1);
            game.setLevel(new Level2());
        }else {
            game.setPoints(total);
        }
    }
}
