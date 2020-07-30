import java.util.Scanner;

public class Validator {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("please enter first name");
		String firstName = scnr.nextLine();
				while(!validateFirstName(firstName)) {
					System.out.println("sorry first name is not vaild");
					System.out.println("please enter a valid first name");
					firstName = scnr.nextLine();
				}
		System.out.println("please enter last name");
		String lastName = scnr.nextLine();
				while(!validateLastName(lastName)) {
					System.out.println("sorry last name is not vaild");
					System.out.println("please enter a valid last name");
					lastName = scnr.nextLine();
						}
		System.out.println("please enter a valid phone number");
		String phone = scnr.nextLine();
		while(!validatePhone(phone)) {
			System.out.println("sorry phone number is not vaild");
			System.out.println("please enter a valid phone number");
			phone = scnr.nextLine();
		}
		System.out.println("please enter a valid email");
		String email = scnr.nextLine();
		while(!validateEmail(email)) {
			System.out.println("sorry email is not vaild");
			System.out.println("please enter a valid email");
			email = scnr.nextLine();
		}
		System.out.println("please enter a valid date");
		String date = scnr.nextLine();
		while(!validateDate(date)) {
			System.out.println("sorry date is not vaild");
			System.out.println("please enter a valid date");
			date = scnr.nextLine();
		}
				
		scnr.close();
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Phone number: " + phone);
		System.out.println("Email: " + email);
		System.out.println("Date: " + date);
	}

	public static int getInt(Scanner scnr, String prompt) {
		System.out.print(prompt);
		// loop while the input would be bad.
		while (!scnr.hasNextInt()) {
			scnr.nextLine(); // <-- clear out the bad input that they already
								// typed
			System.out
					.println("That is not a valid integer. Please try again.");
			System.out.print(prompt);
		}
		int input = scnr.nextInt();
		scnr.nextLine(); // <-- clear entire line to ready for next input
		return input;
	}

	public static int getPositiveInt(Scanner scnr, String prompt) {
		int input;
		do {
			input = getInt(scnr, prompt);
			if (input <= 0) {
				System.out.println("You must enter a positive number.");
			}
		} while (input <= 0);
		return input;
	}

	public static double getDouble(Scanner scnr, String prompt) {
		System.out.print(prompt);
		// loop while the input would be bad.
		while (!scnr.hasNextDouble()) {
			scnr.nextLine(); // <-- clear out the bad input that they already
								// typed
			System.out.println("That is not a valid number. Please try again.");
			System.out.print(prompt);
		}
		double input = scnr.nextDouble();
		scnr.nextLine(); // <-- clear entire line to ready for next input
		return input;
	}

	public static boolean getYesNo(Scanner scnr, String prompt) {
		String input;
		boolean isValid;
		do {
			System.out.println(prompt);
			input = scnr.nextLine();
			isValid = "yes".equalsIgnoreCase(input) ||
					"no".equalsIgnoreCase(input) || "y".equalsIgnoreCase(input)
					|| "n".equalsIgnoreCase(input);
			if (!isValid) {
				System.out.println("Invalid response. Enter yes or no.");
			}
		} while (!isValid);
		
		return input.toLowerCase().startsWith("y");
	}
	
	public static boolean validateFirstName(String firstName) {
		String regex = "[A-Z]{1}[a-z]{1,29}";
		
		if (firstName.matches(regex)) {
			return true;
		}
			return false;
	}

	public static boolean validateLastName(String lastName) {
		String regex = "[A-Z]{1}[a-z]{1,29}";
		
		if (lastName.matches(regex)) {
			return true;
		}
			return false;
	}
	
	public static boolean validatePhone(String phone) {
		String regex = "\\d{3}-\\d{3}-\\d{4}";
		if (phone.matches(regex)) {
			return true;
		}
			return false;
		
	}

	public static boolean validateEmail(String email) {
		String regex = "[A-Z, a-z,0-9]{5,30}@[A-Z, a-z,0-9]{3,10}.com";		
		if (email.matches(regex)) {
			return true;
		}
			return false;
	}

	public static boolean validateDate(String date) {
		String regex = "[0-9]{2}/[0-9]{2}/[0-9]{4}";
		if (date.matches(regex)) {
			return true;
		}
			return false;
	}

}