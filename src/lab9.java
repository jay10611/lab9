import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class lab9 {

	private static Scanner scnr;
	private static Map<String, Double> items = new TreeMap<>();
	private static List<String> orderedItems = new ArrayList<String>(items.keySet());
	private static List<Double> itemsPrice = new ArrayList<Double>(items.values());

	public static void main(String[] args) {
		scnr = new Scanner(System.in);
		fillItemsMap();

		boolean moreInfo = false;
		boolean invalidInput = false;

		do {
			do {
				printMenu();
				System.out.print("What would you like to order?");
				String itemName = scnr.nextLine();
				Double itemPrice = items.get(itemName);
				if (items.containsKey(itemName)) {
					System.out.println("Adding " + itemName + " to cart at $" + itemPrice);
					System.out.println();

					orderedItems.add(itemName);
					itemsPrice.add(itemPrice);
					break;
				} else {
					System.out.println("Sorry, we must be out of that try ordering something on the menu");
					invalidInput = true;
				}

			} while (invalidInput == true);
			moreInfo = Validator.getYesNo(scnr, "Would you like to order anything else? ");
		} while (moreInfo == true);
		System.out.println("Thank you for ordering");
		System.out.println("======================");
		for (int i = 0; i < itemsPrice.size(); i++) {
			System.out.println(orderedItems.get(i) + "\t" + itemsPrice.get(i));

		}
		System.out.println("======================");

		average();
		max();
		min();

	}

	private static void fillItemsMap() {
		items.put("Apples", .99);
		items.put("Bacon", 4.99);
		items.put("Coffee", 6.55);
		items.put("Bread", 2.99);
		items.put("Milk", 3.28);
		items.put("Steaks", 12.25);
		items.put("Sugar", 3.49);
		items.put("Chips", 6.99);

	}

	private static void printMenu() {
		System.out.println("Items\tPrice");
		System.out.println("==============");

		for (Map.Entry<String, Double> entry : items.entrySet())
			System.out.println(entry.getKey() + "\t" + entry.getValue());

	}

	private static void average() {
		double total = 0;
		double avg;
		for (int i = 0; i < itemsPrice.size(); i++)
			total += itemsPrice.get(i);
		avg = total / itemsPrice.size();
		System.out.format("The Average of your cart is %.2f:", avg);
		System.out.println();

	}

	private static void max() {
		double highest = itemsPrice.get(0);

		for (int s = 0; s < itemsPrice.size(); s++)
			if (itemsPrice.get(s) > highest)
				highest = itemsPrice.get(s);
		System.out.println("The most expensive item in your cart cost was$" + highest);

	}

	private static void min() {
		double lowest = itemsPrice.get(0);

		for (int s = 0; s > itemsPrice.size(); s++)
			if (itemsPrice.get(s) > lowest)
				lowest = itemsPrice.get(s);
		System.out.println("The cheapest item in your cart cost $" + lowest);

	}
}
