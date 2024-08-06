import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class ToDoList {
    private final List<String> items;

    public ToDoList() {
        this.items = new ArrayList<>();
    }

   
    public void addItem(String item) {
        items.add(item);
        System.out.println("Added: " + item);
    }

   
    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            String removedItem = items.remove(index);
            System.out.println("Removed: " + removedItem);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void viewItems() {
        if (items.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }
        }
    }
}


public class todo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ToDoList toDoList = new ToDoList();
            boolean running = true;
            
            while (running) {
                System.out.println("\nTo-Do List Menu:");
                System.out.println("1. Add item");
                System.out.println("2. Remove item");
                System.out.println("3. View items");
                System.out.println("4. Exit");
                
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter the item to add: ");
                        String addItem = scanner.nextLine();
                        toDoList.addItem(addItem);
                    }
                    case 2 -> {
                        toDoList.viewItems();
                        System.out.print("Enter the number of the item to remove: ");
                        int index = scanner.nextInt() - 1;
                        toDoList.removeItem(index);
                    }
                    case 3 -> toDoList.viewItems();
                    case 4 -> {
                        running = false;
                        System.out.println("Exiting...");
                    }
                    default -> System.out.println("Invalid choice, please try again.");
                }
            }
        }
    }
}
