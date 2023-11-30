import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = new String[0];
        NameRepository.setNames(names);

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Get the size of the list");
            System.out.println("2. Set the names in the list");
            System.out.println("3. Clear the list");
            System.out.println("4. Find all names in the list");
            System.out.println("5. Find a name in the list");
            System.out.println("6. Add a name to the list");
            System.out.println("7. Find names by first name");
            System.out.println("8. Find names by last name");
            System.out.println("9. Update a name in the list");
            System.out.println("10. Remove a name from the list");
            System.out.println("11. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("The size of the list is: " + NameRepository.getSize());
                    break;
                case 2:
                    System.out.println("Enter the name:");
                    String[] newNames = scanner.nextLine().split(" ");
                    NameRepository.setNames(newNames);
                    break;
                case 3:
                    NameRepository.clear();
                    System.out.println("The list has been cleared.");
                    break;
                case 4:
                    String[] allNames = NameRepository.findAll();
                    System.out.println("All names in the list:");
                    for (String name : allNames) {
                        System.out.println(name);
                    }
                    break;
                case 5:
                    System.out.println("Enter the name you want to find:");
                    String nameToFind = scanner.nextLine();
                    String foundName = NameRepository.find(nameToFind);
                    if (foundName == null) {
                        System.out.println("Name not found.");
                    } else {
                        System.out.println("Name found: " + foundName);
                    }
                    break;
                case 6:
                    System.out.println("Enter the name you want to add:");
                    String nameToAdd = scanner.nextLine();
                    boolean added = NameRepository.add(nameToAdd);
                    if (added) {
                        System.out.println("Name added successfully.");
                    } else {
                        System.out.println("Name already exists in the list.");
                    }
                    break;
                case 7:
                    System.out.println("Enter the first name you want to search for:");
                    String firstName = scanner.nextLine();
                    String[] namesByFirstName = NameRepository.findByFirstName(firstName);
                    System.out.println("Names found:");
                    for (String name : namesByFirstName) {
                        System.out.println(name);
                    }
                    break;
                case 8:
                    System.out.println("Enter the last name you want to search for:");
                    String lastName = scanner.nextLine();
                    String[] namesByLastName = NameRepository.findByLastName(lastName);
                    System.out.println("Names found:");
                    for (String name : namesByLastName) {
                        System.out.println(name);
                    }
                    break;
                case 9:
                    System.out.println("Enter the name you want to update:");
                    String originalName = scanner.nextLine();
                    System.out.println("Enter the new name:");
                    String updatedName = scanner.nextLine();
                    boolean updated = NameRepository.update(originalName, updatedName);
                    if (updated) {
                        System.out.println("Name updated successfully.");
                    } else {
                        System.out.println("Name not updated.");
                    }
                    break;
                case 10:
                    System.out.println("Enter the name you want to remove:");
                    String nameToRemove = scanner.nextLine();
                    boolean removed = NameRepository.remove(nameToRemove);
                    if (removed) {
                        System.out.println("Name removed successfully.");
                    } else {
                        System.out.println("Name not found.");
                    }
                    break;
                case 11:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}