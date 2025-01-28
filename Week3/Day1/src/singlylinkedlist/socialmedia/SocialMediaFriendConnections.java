package singlylinkedlist.socialmedia;

import java.util.Scanner;

public class SocialMediaFriendConnections {
    public static void main(String[] args) {
        SocialMedia socialMedia = new SocialMedia();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display All Friends");
            System.out.println("6. Search User");
            System.out.println("7. Count Friends");
            System.out.println("8. Display All Users");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter User ID: ");
                    int userID = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    socialMedia.addUser(userID, name, age);
                }
                case 2 -> {
                    System.out.print("Enter First User ID: ");
                    int userID1 = sc.nextInt();
                    System.out.print("Enter Second User ID: ");
                    int userID2 = sc.nextInt();
                    socialMedia.addFriendConnection(userID1, userID2);
                }
                case 3 -> {
                    System.out.print("Enter First User ID: ");
                    int userID1 = sc.nextInt();
                    System.out.print("Enter Second User ID: ");
                    int userID2 = sc.nextInt();
                    socialMedia.removeFriendConnection(userID1, userID2);
                }
                case 4 -> {
                    System.out.print("Enter First User ID: ");
                    int userID1 = sc.nextInt();
                    System.out.print("Enter Second User ID: ");
                    int userID2 = sc.nextInt();
                    socialMedia.findMutualFriends(userID1, userID2);
                }
                case 5 -> {
                    System.out.print("Enter User ID: ");
                    int userID = sc.nextInt();
                    socialMedia.displayAllFriends(userID);
                }
                case 6 -> {
                    System.out.print("Enter User ID or Name to Search: ");
                    String input = sc.next();
                    try {
                        int userID = Integer.parseInt(input);
                        socialMedia.searchUser("", userID);
                    } catch (NumberFormatException e) {
                        socialMedia.searchUser(input, -1);
                    }
                }
                case 7 -> socialMedia.countFriends();
                case 8 -> socialMedia.displayAllUsers();
                case 9 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 9);

        sc.close();
    }
}