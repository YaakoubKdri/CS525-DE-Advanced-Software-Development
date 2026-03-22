package game;

public class Level3 implements Level {
    @Override
    public void addPoints(Game game, int points) {
        int total = game.getPoints() + 3 * points;
        game.setPoints(total);
    }
}
