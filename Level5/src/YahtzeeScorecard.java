public class YahtzeeScorecard
{
	/* instance data given */
	private int ones;
	private int twos;
	private int threes;
	private int fours;
	private int fives;
	private int sixes;
	private int threeKind;
	private int fourKind;
	private int fiveKind;
	private int chance;
	private int fullHouse;
	private int smStraight;
	private int lgStraight;
	private boolean bonus;
	private YahtzeeSortDice sort;

	/* Sets up a new game.  Sets all instance data to incomplete (-1). Sets bonus to false */
	public YahtzeeScorecard()
	{
		ones = -1;
		twos = -1;
		threes = -1;
		fours = -1;
		fives = -1;
		sixes = -1;
		threeKind = -1;
		fourKind = -1;
		fiveKind = -1;
		chance = -1;
		fullHouse = -1;
		smStraight = -1;
		lgStraight = -1;
		bonus = false;
	}

	/* 1. If the field is already full, return false
	   2. Set data value ones equal to number of ones rolled multiplied by one.
	   3. Update the bonus (call updateBonus())
	   4. Return true   */
	public boolean markOnes(int die1, int die2, int die3, int die4, int die5)
	{
		if(ones == -1) {
			int num1s = 0;
			if(die1 == 1) num1s++;
			if(die2 == 1) num1s++;
			if(die3 == 1) num1s++;
			if(die4 == 1) num1s++;
			if(die5 == 1) num1s++;
			ones = num1s*1;
			updateBonus();
			return true;
		} else { return false; }
	}

	/* 1. If the field is already full, return false
	   2. Set data value twos equal to number of twos rolled multiplied by two.
	   3. Update the bonus (call updateBonus())
	   4. Return true   */
	public boolean markTwos(int die1, int die2, int die3, int die4, int die5)
	{
		if(twos == -1) {
			int num2s = 0;
			if(die1 == 2) num2s++;
			if(die2 == 2) num2s++;
			if(die3 == 2) num2s++;
			if(die4 == 2) num2s++;
			if(die5 == 2) num2s++;
			twos = num2s*2;
			updateBonus();
			return true;
		} else { return false; }
	}

	/* 1. If the field is already full, return false
	   2. Set data value threes equal to number of threes rolled multiplied by three.
	   3. Update the bonus (call updateBonus())
	   4. Return true  */
	public boolean markThrees(int die1, int die2, int die3, int die4, int die5)
	{
		if(threes == -1) {
			int num3s = 0;
			if(die1 == 3) num3s++;
			if(die2 == 3) num3s++;
			if(die3 == 3) num3s++;
			if(die4 == 3) num3s++;
			if(die5 == 3) num3s++;
			threes = num3s*3;
			updateBonus();
			return true;
		} else { return false; }
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value fours equal to number of fours rolled multiplied by four.
	   3. Update the bonus (call updateBonus())
	   4. Returns true   */
	public boolean markFours(int die1, int die2, int die3, int die4, int die5)
	{
		if(fours == -1) {
			int num4s = 0;
			if(die1 == 4) num4s++;
			if(die2 == 4) num4s++;
			if(die3 == 4) num4s++;
			if(die4 == 4) num4s++;
			if(die5 == 4) num4s++;
			fours = num4s*4;
			updateBonus();
			return true;
		} else { return false; }
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value fives equal to number of fives rolled multiplied by five.
	   3. Update the bonus (call updateBonus())
	   4. Returns true   */
	public boolean markFives(int die1, int die2, int die3, int die4, int die5)
	{
		if(fives == -1) {
			int num5s = 0;
			if(die1 == 5) num5s++;
			if(die2 == 5) num5s++;
			if(die3 == 5) num5s++;
			if(die4 == 5) num5s++;
			if(die5 == 5) num5s++;
			fives = num5s*5;
			updateBonus();
			return true;
		} else { return false; }
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value sixes equal to number of sixes rolled multiplied by six.
	   3. Update the bonus (call updateBonus())
	   4. Returns true */
	public boolean markSixes(int die1, int die2, int die3, int die4, int die5)
	{
		if(sixes == -1) {
			int num6s = 0;
			if(die1 == 6) num6s++;
			if(die2 == 6) num6s++;
			if(die3 == 6) num6s++;
			if(die4 == 6) num6s++;
			if(die5 == 6) num6s++;
			sixes = num6s*6;
			updateBonus();
			return true;
		} else { return false; }
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually three of the same value.
		   If there are, set the data value threeKind to the value of all five dice.
		   If there aren't set the value to 0.
	   	   (Hint: use YahtzeeSortDice class!)
	   	4. Return true   */
	public boolean markThreeOfAKind(int die1, int die2, int die3, int die4, int die5) {
		sort = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		if(threeKind == -1) {
			if(sort.getFirst() == sort.getSecond() && sort.getSecond() == sort.getThird()) {
				threeKind = sort.getFirst() + sort.getSecond() + sort.getThird() + sort.getFourth() + sort.getFifth();
			} else if(sort.getSecond() == sort.getThird() && sort.getThird() == sort.getFourth()) {
				threeKind = sort.getFirst() + sort.getSecond() + sort.getThird() + sort.getFourth() + sort.getFifth();
			} else if(sort.getThird() == sort.getFourth() && sort.getFourth() == sort.getFifth()) {
				threeKind = sort.getFirst() + sort.getSecond() + sort.getThird() + sort.getFourth() + sort.getFifth();
			} else { threeKind = 0; }
			return true;
		} else { return false; }
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually four of the same value.
		   If there are, set the data value fourKind to the value of all five dice.
		   If there aren't set the value to 0;
		   (Hint: use YahtzeeSortDice class!)
		4. Return true  */
	public boolean markFourOfAKind(int die1, int die2, int die3, int die4, int die5)
	{
		sort = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		if(fourKind == -1) {
			if(sort.getFirst() == sort.getSecond() && sort.getSecond() == sort.getThird() && sort.getThird() == sort.getFourth()) {
				fourKind = sort.getFirst() + sort.getSecond() + sort.getThird() + sort.getFourth() + sort.getFifth();
			} else if(sort.getSecond() == sort.getThird() && sort.getThird() == sort.getFourth() && sort.getFourth() == sort.getFifth()) {
				fourKind = sort.getFirst() + sort.getSecond() + sort.getThird() + sort.getFourth() + sort.getFifth();
			} else { fourKind = 0; }
			return true;
		} else { return false; }
	}

	/* 1. If the field is already full, return false
	   2. Check to see if there are actually three die with the same value, and two with another value.
	      If there are, set the data value fullHouse to 25.
	      If there aren't set the value to 0.
	      (Hint: Use YahtzeeSortDice class!)
       3. Return true   */
	public boolean markFullHouse(int die1, int die2, int die3, int die4, int die5)
	{
		sort = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		if(fullHouse == -1) {
			if(sort.getFirst() == sort.getSecond() && sort.getThird() == sort.getFourth() && sort.getFourth() == sort.getFifth()) {
				fullHouse = 25;
			} else if(sort.getFirst() == sort.getSecond() && sort.getSecond() == sort.getThird() && sort.getFourth() == sort.getFifth()) {
				fullHouse = 25;
			} else { fullHouse = 0; }
			return true;
		} else { return false; }
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually four consecutive dice numbers.
		   If there are, set the data value smStraight to 30.
		   If there aren't set the value to 0.
		   (Hint: Use YahtzeeSortDice class)
		4. Return true  */
	public boolean markSmallStraight(int die1, int die2, int die3, int die4, int die5)
	{
		sort = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		if(smStraight == -1) {
			if(sort.getSecond() == sort.getFirst()+1 && sort.getThird() == sort.getSecond()+1 && sort.getFourth() == sort.getThird()+1) {
				smStraight = 30;
			} else if(sort.getThird() == sort.getSecond()+1 && sort.getFourth() == sort.getThird()+1 && sort.getFifth() == sort.getFourth()+1) {
				smStraight = 30;
			} else { smStraight = 0; }
			return true;
		} else { return false; }
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually five consecutive dice numbers.
		   If there are, set the data value lgStraight to 40.
		   If there aren't set the value to 0;
		   (Hint: use YahtzeeSortDice class!)
		3. Return true  */
	public boolean markLargeStraight(int die1, int die2, int die3, int die4, int die5)
	{
		sort = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		if(lgStraight == -1) {
			if (sort.getSecond() == sort.getFirst() + 1 && sort.getThird() == sort.getSecond() + 1 && sort.getFourth() == sort.getThird() + 1 && sort.getFifth() == sort.getFourth() + 1) {
				lgStraight = 40;
			} else { lgStraight = 0; }
			return true;
			} else { return false; }
		}

	/* 1. If the field is already full, return false
	   2. Checks to see if there are actually five of the same value.
	   If there are, set the data value fiveKind to 50.
	   If there aren't set the value to 0;
       3. Return true   */
	public boolean markYahtzee(int die1, int die2, int die3, int die4, int die5)
	{
		if(fiveKind == -1) {
			if(die1 == die2 && die2 == die3 && die3 == die4 && die4 == die5) {
				fiveKind = 50;
			} else { fiveKind = 0; }
			return true;
		} else { return false; }
	}

	/* 1. If the field is already full, return false
	   2. Set the data value chance to the value of all five dice.
	   3. Return true  */
	public boolean markChance(int die1, int die2, int die3, int die4, int die5)
	{
		if(chance == -1) {
			chance = die1 + die2 + die3 + die4 + die5;
			return true;
		} else { return false; }
	}

	/* 	1. If the bonus has already been assigned, do nothing
		2. If the upper section's total is 63 or greater, set the data value bonus to true */
	private void updateBonus()
	{
		if(!bonus) {
			if(getUpperTotal() >= 63) {
				bonus = true;
			}
		}
	}

	/* 	returns the upper total, remember incomplete sections (-1s) should not be factored in! */
	public int getUpperTotal()
	{
		int upperTotal = 0;
		if(ones != -1) {
			upperTotal += ones;
		}
		if(twos != -1) {
			upperTotal += twos;
		}
		if(threes != -1) {
			upperTotal += threes;
		}
		if(fours != -1) {
			upperTotal += fours;
		}
		if(fives != -1) {
			upperTotal += fives;
		}
		if(sixes != -1) {
			upperTotal += sixes;
		}
		if(bonus) {
			upperTotal += 35;
		}
		return upperTotal;
	}

	/* 	returns the lower total, remember incomplete sections (-1s) should not be factored in! */
	public int getLowerTotal()
	{
		int lowerTotal = 0;
		if(fourKind != -1) {
			lowerTotal += fourKind;
		}
		if(fiveKind != -1) {
			lowerTotal += fiveKind;
		}
		if(chance != -1) {
			lowerTotal += chance;
		}
		if(fullHouse != -1) {
			lowerTotal += fullHouse;
		}
		if(smStraight != -1) {
			lowerTotal += smStraight;
		}
		if(lgStraight != -1) {
			lowerTotal += lgStraight;
		}
		return lowerTotal;
	}

	/* 	returns the grand total, remember incomplete sections (-1s) should not be factored in! */
	public int getGrandTotal()
	{
		return getUpperTotal() + getLowerTotal();
	}

	/*	Prints a scorecard with the current total, using "__" to mark uncompleted fields and a number to mark filled fields
		Sample:
		**********************************
		*  	    Yahtzee Score Card		 *
		*  					`		  	 *
		*   Ones:               __		 *
		* 	Twos:				__		 *
		* 	Threes:				__		 *
		* 	Fours:				__		 *
		* 	Fives:				25		 *
		* 	Sixes:				__		 *
		*								 *
		*	Upper Bonus:		 0		 *
		* 	Upper Total:   		25		 *
		*								 *
		*	3 of Kind:			__		 *
		* 	4 of Kind:			__		 *
		* 	Full House:			25		 *
		* 	Sm Straight:		__		 *
		* 	Lg  Straight:		__		 *
		* 	Yahtzee:	  		 0		 *
		* 	Chance:				__		 *
		*								 *
		* 	Lower Total:		25		 *
		*								 *
		* 	Grand Total:		50		 *
		**********************************
		already implemented
	*/
	public void printScoreCard()
	{
		System.out.println();
		System.out.println("*********************************");
		System.out.println("*      Yahtzee Score Card       *");
		System.out.println("*                               *");
		System.out.print("*  Ones:");
		for(int s = 0; s < 20-("ones:".length()); s++) {
			System.out.print(" ");
		}
		if(ones==-1)System.out.print("__");
			else System.out.print(ones);
		if(ones < 10 && ones != -1) {
			System.out.println("        *");
		} else System.out.println("       *");
		System.out.print("*  Twos:");
		for(int s = 0; s < 20-("twos:".length()); s++) {
			System.out.print(" ");
		}
		if(twos==-1)System.out.print("__");
			else System.out.print(twos);
		if(twos < 10 && twos != -1) {
			System.out.println("        *");
		} else System.out.println("       *");
		System.out.print("*  Threes:");
		for(int s = 0; s < 20-("threes:".length()); s++) {
			System.out.print(" ");
		}
		if(threes==-1)System.out.print("__");
			else System.out.print(threes);
		if(threes < 10 && threes != -1) {
			System.out.println("        *");
		} else System.out.println("       *");
		System.out.print("*  Fours:");
		for(int s = 0; s < 20-("fours:".length()); s++) {
			System.out.print(" ");
		}
		if(fours==-1)System.out.print("__");
			else System.out.print(fours);
		if(fours < 10 && fours != -1) {
			System.out.println("        *");
		} else System.out.println("       *");
		System.out.print("*  Fives:");
		for(int s = 0; s < 20-("fives:".length()); s++) {
			System.out.print(" ");
		}
		if(fives==-1)System.out.print("__");
			else System.out.print(fives);
		if(fives < 10 && fives != -1) {
			System.out.println("        *");
		} else System.out.println("       *");
		System.out.print("*  Sixes:");
		for(int s = 0; s < 20-("sixes:".length()); s++) {
			System.out.print(" ");
		}
		if(sixes==-1)System.out.print("__");
			else System.out.print(sixes);
		if(sixes < 10 && sixes != -1) {
			System.out.println("        *");
		} else System.out.println("       *");
		System.out.println("*                               *");
		System.out.print("*  Upper Bonus:");
		for(int s = 0; s < 20-("upper bonus:".length()); s++) {
			System.out.print(" ");
		}
		if(bonus) {
			System.out.print("35");
			System.out.println("       *");
		}
			else {
				System.out.print("0");
				System.out.println("        *");
		}
		System.out.print("*  Upper Total:");
		for(int s = 0; s < 20-("upper total:".length()); s++) {
			System.out.print(" ");
		}
		System.out.print(this.getUpperTotal());
		if(this.getUpperTotal() < 10) {
			System.out.println("        *");
		} else { System.out.println("       *"); }
		System.out.println("*                               *");
		System.out.print("*  3 of Kind:");
		for(int s = 0; s < 20-("3 of kind:".length()); s++) {
			System.out.print(" ");
		}
		if(threeKind==-1)System.out.print("__");
			else System.out.print(threeKind);
		System.out.println("       *");
		System.out.print("*  4 of Kind:");
		for(int s = 0; s < 20-("4 of kind:".length()); s++) {
			System.out.print(" ");
		}
		if(fourKind==-1)System.out.print("__");
			else System.out.print(fourKind);
		System.out.println("       *");
		System.out.print("*  Full House:");
		for(int s = 0; s < 20-("full house:".length()); s++) {
			System.out.print(" ");
		}
		if(fullHouse==-1)System.out.print("__");
			else System.out.print(fullHouse);
		System.out.println("       *");
		System.out.print("*  Sm Straight:");
		for(int s = 0; s < 20-("sm straight:".length()); s++) {
			System.out.print(" ");
		}
		if(smStraight==-1)System.out.print("__");
			else System.out.print(smStraight);
		System.out.println("       *");
		System.out.print("*  Lg Straight:"); //nah
		for(int s = 0; s < 20-("lg straight:".length()); s++) {
			System.out.print(" ");
		}
		if(lgStraight==-1)System.out.print("__");
			else System.out.print(lgStraight);
		System.out.println("       *");
		System.out.print("*  Yahtzee:");
		for(int s = 0; s < 20-("yahtzee:".length()); s++) {
			System.out.print(" ");
		}
		if(fiveKind==-1)System.out.print("__");
			else System.out.print(fiveKind);
		System.out.println("       *");
		System.out.print("*  Chance:");
		for(int s = 0; s < 20-("chance:".length()); s++) {
			System.out.print(" ");
		}
		if(chance==-1)System.out.print("__");
			else System.out.print(chance);
		System.out.println("       *");
		System.out.println("*                               *");
		System.out.print("*  Lower Total:");
		for(int s = 0; s < 20-("lower total:".length()); s++) {
			System.out.print(" ");
		}
		System.out.print(this.getLowerTotal());
		if(this.getLowerTotal() < 10) {
			System.out.println("        *");
		} else { System.out.println("       *"); }
		System.out.println("*                               *");
		System.out.print("*  Grand Total:");
		for(int s = 0; s < 20-("grand total:".length()); s++) {
			System.out.print(" ");
		}
		System.out.print(this.getGrandTotal());
		if(this.getGrandTotal() < 10) {
			System.out.println("        *");
		} else { System.out.println("       *"); }
		System.out.println("*********************************");
		System.out.println();
	}
}