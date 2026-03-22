package game;

import java.util.Random;

public class Game {
	private int totalPoints = 0;
	private Level level;

    public Game() {
        this.level = new Level1();
    }

    public void play() {
		Random random = new Random();
		addPoints(random.nextInt(7));
		System.out.println("points="+totalPoints+" level="+level.getClass().getSimpleName());
	}

	public void addPoints(int newPoints) {
		level.addPoints(this, newPoints);
	}

    public void setLevel(Level level){
        this.level = level;
    }

    public int getPoints(){
        return totalPoints;
    }

    public void setPoints(int points){
        this.totalPoints = points;
    }

}
