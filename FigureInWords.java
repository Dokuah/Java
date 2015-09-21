import java.util.Scanner;

public class FigureInWords {

	//String for units
	private static final String[] units = {

		"", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ", "ten ", "eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "seventeen ", "eighteen ", "nineteen "
	};   

	//string for tens
	private static final String[] tens = {

		"", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety "
	};

	//Array for 
	private static final String[] mills = {

		"", "thousand ", "million ", "billion "
	};


	public static String NumsBelowThousand(int num) {
		String corn;

		//for handling numbers less than 100
		if (num % 100 < 20){
			corn = units[num % 100];
			num /= 100;
		}
		
		//for handling numbers => 10
		else {
			corn = units[num % 10];
			num /= 10;

			corn = tens[num % 10] + corn;
			num /= 10;
		}
		
		//for handling numbers > hundred
		if (num == 0) return corn;
		return units[num ] + " hundred and " + corn;
	}

	public static String convert(int num) {

		if (num == 0) { return "zero"; }

		String prefix = "";

		//for negative integers
		if (num < 0) {
			num = -num;
			prefix = "negative ";
		}

		
		//for handling numbers > thousand
		String corn = "";
		int fall = 0;

		do {
			int n = num % 1000;
			if (n != 0){
				String s = NumsBelowThousand(n);
				corn = s + mills[fall] + corn ;
			}
			fall++;
			num /= 1000;
		} while (num > 0);

		return (prefix  + corn ).trim();
	}



	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		String prompt;

		do {

			System.out.println("Enter a number to convert to words (or 'done' to quit): ");
			prompt = in.nextLine();
			if (!prompt.equals("Done")){

				try{ //
					int f1 = Integer.parseInt(prompt);
				System.out.println (convert(f1));
				}
				catch(NumberFormatException e)
				{
					System.out.println("You entered a wrong value.");
				}
				
			}

		} while (!prompt.equals("Done"));


		System.out.println ("Thank you for using our service");

	}
}