import java.util.Arrays;

public class StockMaximize {
	
	public int value_1 = 0;
	
	public int value_2 = 0;
	
	public void func_1(int b) {
		b = b * b;
		System.out.println(b);
	}
	
	public static final void func_2(StockMaximize s) {
		s.value_1 = 10;
	}
	
	private static long[] getElements(String elements, int size) {

		String[] elementsArray = elements.trim().split(" ");

		if (elementsArray.length != size)
			throw new IllegalArgumentException("Number of elements in the list does not match the size provided");

		long[] numbers = new long[size];
		int index = 0;

		// extract integers
		for (String ele : elementsArray) {
			try {
				numbers[index++] = Long.parseLong(ele);
			} catch (NumberFormatException nfe) {
				System.out.println("Caught NumberFormatException: Unable to parse to long");
				nfe.getStackTrace();
			}

		}
		return numbers;
	}

	private static boolean[] findSellingDays(long[] stockPrices, int days) {

		boolean[] sellOn = new boolean[days]; 
		Arrays.fill(sellOn, false); 
		long localMax = Long.MIN_VALUE; 
		for (int i = days - 1; i >= 0; i--) {
			if (localMax < stockPrices[i]) { 
				localMax = stockPrices[i]; 
				sellOn[i] = true; 
			}
		}
		return sellOn;
	}

	
	private static long calcMaxProfit(long[] stockPrices, int days) {

		boolean[] sellOn = findSellingDays(stockPrices, days);

		long totalCost = 0, totalProfit = 0;
		int numShares = 0;

		for (int i = 0; i < days; i++) {
			if (sellOn[i] == false) { 
				totalCost += stockPrices[i];
				numShares++;
			} else if (totalCost != 0) { 
				totalProfit += numShares * stockPrices[i] - totalCost; 
				totalCost = 0;
				numShares = 0;
			}
		}
		return totalProfit;
	}

	public static void main(String[] args) {
		
		StockMaximize s = new StockMaximize();
		int a = 6;
		s.func_1(a);
		System.out.println(a);
		System.out.println(s.value_1);
		StockMaximize.func_2(s);
		System.out.println(s.value_1);
		/*BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testCases = Integer.parseInt(input.readLine().trim());

			if (testCases <= 0) {
				throw new IllegalArgumentException("The number of test cases must be greater than 0");
			}

			while (testCases > 0) {
				int days = Integer.parseInt(input.readLine().trim());
				if (days <= 0) {
					throw new IllegalArgumentException("The number of test cases must be greater than 0");
				}
				long[] stockPrices = getElements(input.readLine(), days);

				long maxProfit = calcMaxProfit(stockPrices, days);
				System.out.println(maxProfit);
				testCases--;
			}
			input.close();
		} catch (NumberFormatException nfe) {
			System.out.println("Caught NumberFormatException: Unable to parse inputs from stdin");
			nfe.getStackTrace();
		} catch (IOException ioe) {
			System.out.println("Caught IOException: Unable to read inputs from stdin");
			ioe.getStackTrace();
		}*/
	}
}	
