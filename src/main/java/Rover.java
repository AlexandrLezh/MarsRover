public class Rover {
	private int x;
	private int y;
	private char direction;
	private Plateau plateau;

	public Rover(int x, int y, char direction, Plateau plateau) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.plateau = plateau;
	}

	public void move(char instruction) {
		switch (instruction) {
			case 'L' -> turnLeft();
			case 'R' -> turnRight();
			case 'M' -> moveForward();
		}
	}

	private void turnLeft() {
		direction = switch (direction) {
			case 'N' -> 'W';
			case 'W' -> 'S';
			case 'S' -> 'E';
			case 'E' -> 'N';
			default -> direction; // Handle unexpected direction
		};
	}

	private void turnRight() {
		direction = switch (direction) {
			case 'N' -> 'E';
			case 'E' -> 'S';
			case 'S' -> 'W';
			case 'W' -> 'N';
			default -> direction; // Handle unexpected direction
		};
	}

	private void moveForward() {
		int nextX, nextY;
		switch (direction) {
			case 'N' -> {
				nextX = x;
				nextY = y + 1;
			}
			case 'E' -> {
				nextX = x + 1;
				nextY = y;
			}
			case 'S' -> {
				nextX = x;
				nextY = y - 1;
			}
			case 'W' -> {
				nextX = x - 1;
				nextY = y;
			}
			default -> throw new IllegalStateException("Unexpected value: " + direction);
		}

		String nextPosition = nextX + " " + nextY;
		if (plateau.isValidPosition(nextX, nextY) && !plateau.isPositionOccupied(nextX, nextY)) {
			
			x = nextX;
			y = nextY;

			plateau.occupyPosition(x, y);
		}
	}

	public String getPosition() {
		return x + " " + y + " " + direction;
	}
}
