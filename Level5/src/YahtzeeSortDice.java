public class YahtzeeSortDice
{
	private int first;
	private int second;
	private int third;
	private int fourth;
	private int fifth;

	/* constructor: initializes the private data by sorting the order of the dice */
	public YahtzeeSortDice(int a, int b, int c, int d, int e)
	{
		int x;
		for (int i = 0; i < 4; i++) {
			if(b < a) {
				x = a;
				a = b;
				b = x;
			}

			if(c < b) {
				x = b;
				b = c;
				c = x;
			}

			if(d < c) {
				x = c;
				c = d;
				d = x;
			}

			if(e < d) {
				x = d;
				d = e;
				e = x;
			}
		}
		first = a;
		second = b;
		third = c;
		fourth = d;
		fifth = e;
	}
	/* returns the minimum of the five numbers */
	public int getFirst()
	{
		return first;
	}

	/* returns the second smallest of the five numbers */
	public int getSecond()
	{
		return second;
	}

	/* returns the middle of the five numbers */
	public int getThird()
	{
		return third;
	}

	/* returns the second largest of the five numbers */
	public int getFourth()
	{
		return fourth;
	}

	/* returns the biggest of the five numbers */
	public int getFifth()
	{
		return fifth;
	}
}