import java.util.HashMap;
import java.util.Scanner;

public class InventoryManagementSystem {
    public static HashMap<String, Integer> Inventory = new HashMap<>();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Inventory Management System\n");
		
		int choice;
		do {
		System.out.println("1. Add Item");
		System.out.println("2. Remove Item");
		System.out.println("3. Update Quantity");
		System.out.println("4. Print Inventory");
		System.out.println("5. Exit");
		
		System.out.print("\nEnter your choice: ");
		choice = input.nextInt();
		
	switch (choice) {
		case 1:
			addItem(input);
			break;
		case 2:
			removeItem(input);
			break;
		case 3:
			updateQuantity(input);
			break;
		case 4: 
			printInventory();
			break;
		case 5:
			System.out.println("\nThank you for using the Inventory Management System");
			break;
		default: 
			System.out.println("\nInvalid choice");}
		}
		while(choice != 5);
		input.close();
	}
	private static void addItem(Scanner input) {
		System.out.print("\nEnter the item name: ");
		String itemName = input.next();
		
		System.out.print("Enter the quantity: ");
		int itemQuantity = input.nextInt();
		
		Inventory.put(itemName, itemQuantity);
		System.out.println("Item added successfully.\n");
	}
	private static void removeItem(Scanner input) {
		System.out.print("\nEnter the item name to remove: ");
		String itemName = input.next();
		
		if(Inventory.containsKey(itemName)) {
			Inventory.remove(itemName);
			System.out.println("Item removed successfully.\n");
		}else {
			System.out.println("Invalid Item\n");
		}
	}
	private static void updateQuantity(Scanner input){
		System.out.print("\nEnter the item name to update quantity: ");
		String itemName = input.next();
		
		if(Inventory.containsKey(itemName)) {
			System.out.print("Enter the new quantity: ");
			int newQuantity = input.nextInt();
			
			Inventory.put(itemName, newQuantity);
			System.out.println("Quantity updated successfully.\n");
		}
	}
	private static void printInventory() {
		System.out.println("\nCurrent Inventory:");
		for(String itemName : Inventory.keySet()) {
			System.out.println(itemName + " - " + Inventory.get(itemName));
		}
		System.out.println();
	}
}
