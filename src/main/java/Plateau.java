import java.util.ArrayList;
import java.util.List;

public class Plateau {
	private int upperRightX;
	private int upperRightY;
	private List<String> occupiedPositions;

	public Plateau(int upperRightX, int upperRightY) {
		this.upperRightX = upperRightX;
		this.upperRightY = upperRightY;
		this.occupiedPositions = new ArrayList<>();
	}

	public boolean isPositionOccupied(int x, int y) {
		return occupiedPositions.contains(x + " " + y);
	}

	public boolean isValidPosition(int x, int y) {
		return x >= 0 && x <= upperRightX && y >= 0 && y <= upperRightY;
	}

	public void occupyPosition(int x, int y) {
		occupiedPositions.add(x + " " + y);
	}
}

