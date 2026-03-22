package game;

public class Level2 implements Level{
    @Override
    public void addPoints(Game game, int points) {
        int total = game.getPoints() + 2 * points;

        if(total >= 15){
            game.setPoints(total + 1);
            game.setLevel(new Level2_5());
        }else {
            game.setPoints(total);
        }
    }
}
