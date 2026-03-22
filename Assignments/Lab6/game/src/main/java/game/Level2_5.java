package game;

public class Level2_5 implements Level {
    @Override
    public void addPoints(Game game, int points) {
        int total = game.getPoints() + 2 * points;
        if(total >= 20){
            game.setPoints(total + 2);
            game.setLevel(new Level3());
        }else {
            game.setPoints(total);
        }
    }
}
