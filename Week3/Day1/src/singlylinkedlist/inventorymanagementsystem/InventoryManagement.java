package singlylinkedlist.inventorymanagementsystem;
 import java.util.Scanner;

public class InventoryManagement {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity by ID");
            System.out.println("6. Search Item");
            System.out.println("7. Calculate Total Inventory Value");
            System.out.println("8. Sort Inventory");
            System.out.println("9. Display All Items");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    inventory.addAtBeginning(name, id, quantity, price);
                }
                case 2 -> {
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    inventory.addAtEnd(name, id, quantity, price);
                }
                case 3 -> {
                    System.out.print("Enter Position: ");
                    int position = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    inventory.addAtPosition(position, name, id, quantity, price);
                }
                case 4 -> {
                    System.out.print("Enter Item ID to Remove: ");
                    int id = sc.nextInt();
                    inventory.removeByItemID(id);
                }
                case 5 -> {
                    System.out.print("Enter Item ID to Update Quantity: ");
                    int id = sc.nextInt();
                    System.out.print("Enter New Quantity: ");
                    int quantity = sc.nextInt();
                    inventory.updateQuantity(id, quantity);
                }
                case 6 -> {
                    System.out.print("Enter Name or ID to Search: ");
                    String name = sc.next();
                    int id;
                    try {
                        id = Integer.parseInt(name);
                        inventory.searchItem("", id);
                    } catch (NumberFormatException e) {
                        inventory.searchItem(name, -1);
                    }
                }
                case 7 -> inventory.calculateTotalValue();
                case 8 -> {
                    System.out.print("Sort by Name or Price? ");
                    String criteria = sc.next();
                    System.out.print("Ascending (true/false)? ");
                    boolean ascending = sc.nextBoolean();
                    inventory.sortInventory(criteria, ascending);
                }
                case 9 -> inventory.displayAllItems();
                case 10 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 10);

        sc.close();
    }
}














