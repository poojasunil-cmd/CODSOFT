import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {

	public static void main(String[] args) {

		Random RandomNumber = new Random();
		int randomNumber = RandomNumber.nextInt(100) + 1;
		Scanner scan = new Scanner(System.in);
		
		int count = 0;
		while (count <= 10) {
			if (count >= 10) {
				System.out.println("Oops limit exceeded, Better luck next time!");
				break;
			} else {
		System.out.println("Enter a number within 1-100: ");
		int user = scan.nextInt();
		count++;
		 if (user > 100) {		
			System.out.println("Enter within range");
		 } else {
			 
		if (randomNumber == user) {
			System.out.println("Amazing your guess is right!Congratualtions!!!");
			System.out.println("It took you " + count + " tries to guess the Right Number.");
			System.out.println("Your score is " + (10-count) + " out of 10!");
			break;
			
			} else if (user < randomNumber) {
				System.out.println("Nope, Guess Higher");
				
			} else if (user > randomNumber) {
				System.out.println("Nope, Guess Lower");
				
			}  else {
				System.out.println("Oops Invalid");
			}
		 }
	 }
		}
		scan.close();
	

	}

}

