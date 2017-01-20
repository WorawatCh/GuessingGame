import java.util.Scanner;

public class GameConsole {
	Scanner input = new Scanner(System.in);

	/**
	 * The play method plays a game using input from a user.
	 * 
	 * @param game
	 *            receive upperBound number
	 * @return secret number
	 */
	public int play(GuessingGame game) {
		String title = "Guessing Game";
		String prompt = "Your guess? ";
		System.out.println(title);
		System.out.println(game.getHint());
		int number = 0;
		while (!game.guess(number)) {
			game.getHint();
			System.out.print(prompt);
			number = input.nextInt();
			game.guess(number);
			System.out.println(game.getHint());
		}
		return number;
	}
}
