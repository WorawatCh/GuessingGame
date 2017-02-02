import java.util.Random; // for random numbers

/**
 * Game of guessing a secret number.
 * 
 * @author Worawat Chueajedton
 */
public class GuessingGame {
	/* properties of a guessing game */
	// TODO Declare variables for attributes of the game
	private int upperBound;
	private int secret;
	private String hint;
	private int count = 0;

	/**
	 * Initialize a new game.
	 * 
	 * @param upperbound
	 *            is the max value for the secret number (>1).
	 */
	public GuessingGame(int upperBound) {
		this.upperBound = upperBound;
		this.secret = getRandomNumber(upperBound);
		this.hint = "I'm thinking of a number between 1 and " + upperBound;
	}

	/**
	 * Create a random number between 1 and limit.
	 * 
	 * @param limit
	 *            is the upper limit for random number
	 * @return a random number between 1 and limit (inclusive)
	 */
	private int getRandomNumber(int limit) {
		long seed = System.currentTimeMillis();
		Random rand = new Random(seed);
		return rand.nextInt(limit) + 1;
	}

	/**
	 * show a status when player type guess number
	 * 
	 * @param number
	 *            is number that player type
	 * @return result if player can guess right number or wrong number and get
	 *         some hint if it is a wrong number
	 */
	public boolean guess(int number) {
		count++;
		if (number == secret) {
			setHint(String.format("Correct. The secret is %d. You used %d guesses.", this.secret, this.count));
			return true;

		} else if (number < secret) {
			setHint("Sorry,your guess is too small");
		} else {
			setHint("Sorry,your guess is too large");
		}
		return false;

	}

	/**
	 * Return a hint based on the most recent guess.
	 * 
	 * @return hint based on most recent guess
	 */
	public String getHint() {
		return hint;
	}

	/**
	 * Return how many time do you guess
	 * 
	 * @return amount time that you guess
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * to set hint
	 */
	public void setHint(String hint) {
		this.hint = hint;
	}

}

