import java.util.Scanner;

public class MarsRover {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int plateauUpperRightX = scanner.nextInt();
		int plateauUpperRightY = scanner.nextInt();
		scanner.nextLine();

		Plateau plateau = new Plateau(plateauUpperRightX, plateauUpperRightY);

		while (scanner.hasNextLine()) {
			int roverX = scanner.nextInt();
			int roverY = scanner.nextInt();
			char roverDirection = scanner.next().charAt(0);
			scanner.nextLine();
			String instructions = scanner.nextLine();

			Rover rover = new Rover(roverX, roverY, roverDirection, plateau);
			for (char instruction : instructions.toCharArray()) {
				rover.move(instruction);
			}

			System.out.println(rover.getPosition());
		}
	}
}
