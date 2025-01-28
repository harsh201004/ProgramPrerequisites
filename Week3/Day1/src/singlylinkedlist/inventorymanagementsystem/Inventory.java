package singlylinkedlist.inventorymanagementsystem;

class Inventory {
    private Item head;

    // Add item at the beginning
    public void addAtBeginning(String itemName, int itemID, int quantity, double price) {
        Item newItem = new Item(itemName, itemID, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add item at the end
    public void addAtEnd(String itemName, int itemID, int quantity, double price) {
        Item newItem = new Item(itemName, itemID, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }

    // Add item at a specific position
    public void addAtPosition(int position, String itemName, int itemID, int quantity, double price) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        Item newItem = new Item(itemName, itemID, quantity, price);
        if (position == 1) {
            newItem.next = head;
            head = newItem;
        } else {
            Item temp = head;
            for (int i = 1; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Position out of range!");
            } else {
                newItem.next = temp.next;
                temp.next = newItem;
            }
        }
    }

    // Remove item by Item ID
    public void removeByItemID(int itemID) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        if (head.itemID == itemID) {
            head = head.next;
            System.out.println("Item removed successfully.");
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemID != itemID) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item not found!");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed successfully.");
        }
    }

    // Update quantity by Item ID
    public void updateQuantity(int itemID, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemID == itemID) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
    }

    // Search item by Item ID or Item Name
    public void searchItem(String itemName, int itemID) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemID == itemID || temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: Name: " + temp.itemName + ", ID: " + temp.itemID +
                        ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
    }

    // Calculate total inventory value
    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    // Sort inventory by Item Name or Price
    public void sortInventory(String criteria, boolean ascending) {
        if (head == null || head.next == null) {
            return; // Nothing to sort
        }
        head = mergeSort(head, criteria, ascending);
        System.out.println("Inventory sorted by " + criteria + " in " + (ascending ? "ascending" : "descending") + " order.");
    }

    private Item mergeSort(Item head, String criteria, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, criteria, ascending);
        Item right = mergeSort(nextOfMiddle, criteria, ascending);

        return sortedMerge(left, right, criteria, ascending);
    }

    private Item sortedMerge(Item a, Item b, String criteria, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (criteria.equalsIgnoreCase("Name")) {
            condition = ascending ? a.itemName.compareToIgnoreCase(b.itemName) < 0 : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else { // Price
            condition = ascending ? a.price < b.price : a.price > b.price;
        }

        if (condition) {
            a.next = sortedMerge(a.next, b, criteria, ascending);
            return a;
        } else {
            b.next = sortedMerge(a, b.next, criteria, ascending);
            return b;
        }
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Display all items
    public void displayAllItems() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println("Name: " + temp.itemName + ", ID: " + temp.itemID +
                    ", Quantity: " + temp.quantity + ", Price: $" + temp.price);
            temp = temp.next;
        }
    }
}
