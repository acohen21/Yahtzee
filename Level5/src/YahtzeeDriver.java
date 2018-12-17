import java.util.Scanner;

public class YahtzeeDriver
{
	/*
	1. Creates a new instance of the YahtzeeGame class
	2. Calls the playGame method on the Yahtzee object
	3. Asks user if they would like to play again
	4. When the user is done playing, prints the number of games played, min, max, and average score
	*/
	public static void main(String [] args)
	{
		char playing = 'y';
		int minScore = 0;
		int maxScore = 0;
		double avgScore;
		int totalScore = 0;
		int numGames = 0;
		do {
			int score;
			YahtzeeGame myGame = new YahtzeeGame();
			System.out.println("Welcome to Thea's APCSA Yahtzee Game!");
			score = myGame.playGame();
			totalScore += score;

			if(minScore == 0 || score < minScore) {
				minScore = score;
			}
			if(maxScore == 0 || score > maxScore) {
				maxScore = score;
			}

			Scanner s = new Scanner(System.in);
			System.out.println("Would you like to play again? (y/n)");
			playing = s.nextLine().charAt(0);
			numGames++;
			avgScore = 1.0*totalScore/numGames;

		} while(playing == 'y');
		System.out.println("Games played: " + numGames + "\n"
				+ "Min score: " + minScore + "\n"
				+ "Max score: " + maxScore + "\n"
				+ "Avg score: " + avgScore);
	}
}
