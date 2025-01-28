package singlylinkedlist.socialmedia;
import java.util.List;
import java.util.ArrayList;
class SocialMedia {
    private User head;

    // Add a new user
    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
        System.out.println("User added successfully.");
    }

    // Find a user by User ID
    private User findUserByID(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIDs.contains(userID2)) {
            user1.friendIDs.add(userID2);
        }
        if (!user2.friendIDs.contains(userID1)) {
            user2.friendIDs.add(userID1);
        }
        System.out.println("Friend connection added successfully.");
    }

    // Remove a friend connection
    public void removeFriendConnection(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIDs.remove(Integer.valueOf(userID2));
        user2.friendIDs.remove(Integer.valueOf(userID1));
        System.out.println("Friend connection removed successfully.");
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        List<Integer> mutualFriends = new ArrayList<>(user1.friendIDs);
        mutualFriends.retainAll(user2.friendIDs);

        if (mutualFriends.isEmpty()) {
            System.out.println("No mutual friends found.");
        } else {
            System.out.println("Mutual Friends: " + mutualFriends);
        }
    }

    // Display all friends of a specific user
    public void displayAllFriends(int userID) {
        User user = findUserByID(userID);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        if (user.friendIDs.isEmpty()) {
            System.out.println(user.name + " has no friends.");
        } else {
            System.out.println(user.name + "'s Friends: " + user.friendIDs);
        }
    }

    // Search for a user by Name or User ID
    public void searchUser(String name, int userID) {
        User temp = head;

        while (temp != null) {
            if (temp.userID == userID || temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: ID: " + temp.userID + ", Name: " + temp.name + ", Age: " + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    // Count the number of friends for each user
    public void countFriends() {
        User temp = head;

        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIDs.size() + " friend(s).");
            temp = temp.next;
        }
    }

    // Display all users
    public void displayAllUsers() {
        if (head == null) {
            System.out.println("No users in the system.");
            return;
        }

        User temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.userID + ", Name: " + temp.name + ", Age: " + temp.age +
                    ", Friends: " + temp.friendIDs);
            temp = temp.next;
        }
    }
}

