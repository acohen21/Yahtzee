import java.util.Scanner;

public class YahtzeeGame
{
	private YahtzeeDie die1;
	private YahtzeeDie die2;
	private YahtzeeDie die3;
	private YahtzeeDie die4;
	private YahtzeeDie die5;
	private static final int NUM_SIDES = 6;
	private YahtzeeScorecard score;

	private Scanner s = new Scanner(System.in);
	/* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which should be set to six (the number of sides on a yahtzee die) */


	/* initializes the dice and scoreboard */
	public YahtzeeGame()
	{
		die1 = new YahtzeeDie(NUM_SIDES);
		die2 = new YahtzeeDie(NUM_SIDES);
		die3 = new YahtzeeDie(NUM_SIDES);
		die4 = new YahtzeeDie(NUM_SIDES);
		die5 = new YahtzeeDie(NUM_SIDES);
		score = new YahtzeeScorecard();
	}

	/* check to see if the game is over, and while the game is not over call the method takeTurn()
	once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
	final scorecard and return the grand total */
	public int playGame()
	{
		for(int turn = 0; turn < 13; turn++) {
			takeTurn();
		}
		score.printScoreCard();
		return score.getGrandTotal();
	}

	/* 	1. call rollDice()
		2. call printDice()
		3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		4. call chooseFrozen()
		5. call rollDice()
		6. call printDice()
		7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		8. call chooseFrozen()
		9. call rollDice()
		10. call printDice()
		11. call markScore()
	*/
	private void takeTurn()
	{
		rollDice();
		printDice();
		System.out.println("Do you want to roll again? (y/n)");
		if(s.nextLine().charAt(0) == 'y') {
			chooseFrozen();
			rollDice();
			printDice();
			System.out.println("Do you want to roll again? This is your last roll. (y/n)");
			if(s.nextLine().charAt(0) == 'y') {
				chooseFrozen();
				rollDice();
				printDice();
				markScore();
			} else {
				markScore();
			}
		} else {
			markScore();
		}
	}

	/* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
	private void rollDice()
	{
		if(!die1.isFrozen()) {
			die1.rollDie();
		}
		if(!die2.isFrozen()) {
			die2.rollDie();
		}
		if(!die3.isFrozen()) {
			die3.rollDie();
		}
		if(!die4.isFrozen()) {
			die4.rollDie();
		}
		if(!die5.isFrozen()) {
			die5.rollDie();
		}
		//unfreezes die
		if(die1.isFrozen()) {
			die1.unfreezeDie();
		}
		if(die2.isFrozen()) {
			die2.unfreezeDie();
		}
		if(die3.isFrozen()) {
			die3.unfreezeDie();
		}
		if(die4.isFrozen()) {
			die4.unfreezeDie();
		}
		if(die5.isFrozen()) {
			die5.unfreezeDie();
		}

	}

	/* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
	private void chooseFrozen()
	{
		System.out.println("Choose which dice should be frozen (input numbers 1-5)");
		String freeze = s.nextLine();
		if(freeze.indexOf("1") != -1) {
			die1.freezeDie();
		}
		if(freeze.indexOf("2") != -1) {
			die2.freezeDie();
		}
		if(freeze.indexOf("3") != -1) {
			die3.freezeDie();
		}
		if(freeze.indexOf("4") != -1) {
			die4.freezeDie();
		}
		if(freeze.indexOf("5") != -1) {
			die5.freezeDie();
		}
	}

	/* Should print the value of all five dice separated by a tab (\t) to the console */
	private void printDice()
	{
		System.out.println(die1.getValue() + "\t" +
				die2.getValue() + "\t" +
				die3.getValue() + "\t" +
				die4.getValue() + "\t" +
				die5.getValue());
	}

	/* 1. Print a scoreboard
	   2. Ask the user where they would like to mark their score.
	   3. Call appropriate function
	   4. If false is returned the user entered an invalid number, so ask the user to try again	*/
	private void markScore()
	{
		boolean valid;
		boolean notFull;
		do {
			valid = true;
			score.printScoreCard();
			System.out.println("Where would you like to mark your score?" + "\n" +
					"1. Ones \t7. 3 of Kind\n" +
					"2. Twos \t8. 4 of Kind\n" +
					"3. Threes \t9. Full House\n" +
					"4. Fours \t10. Sm Straight\n" +
					"5. Fives \t11. Lg Straight\n" +
					"6. Sixes \t12. Yahtzee\n" +
					"\t\t\t13. Chance\n" +
					"Enter 1-13: ");
			int entered = s.nextInt();
			s.nextLine();
			notFull = true;
				switch (entered) {
					case 1:
						notFull = score.markOnes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
						break;
					case 2:
						notFull = score.markTwos(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
						break;
					case 3:
						notFull = score.markThrees(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
						break;
					case 4:
						notFull = score.markFours(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
						break;
					case 5:
						notFull = score.markFives(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
						break;
					case 6:
						notFull = score.markSixes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
						break;
					case 7:
						notFull = score.markThreeOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
						break;
					case 8:
						notFull = score.markFourOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
						break;
					case 9:
						notFull = score.markFullHouse(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
						break;
					case 10:
						notFull = score.markSmallStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
						break;
					case 11:
						notFull = score.markLargeStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
						break;
					case 12:
						notFull = score.markYahtzee(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
						break;
					case 13:
						notFull = score.markChance(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
						break;
					default:
						System.out.println("Invalid number. Try again.");
						valid = false;
						break;
				}
			if(!notFull) { System.out.println("This is full, please try again"); }
		} while(!valid || !notFull);
	}
}