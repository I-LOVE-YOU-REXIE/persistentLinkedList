package test5;

import java.util.Scanner;

public class MainProgram {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PersistentLinkedList list = new PersistentLinkedList();

		while (true) {
			//@formatter:off
			System.out.println("Options: \n"
			+"[1] Append \n"
			+"[2] Delete \n"
			+"[3] Change Value \n"
			+"[4] Display \n"
			+"[5] Node History \n"
			+"[6] List History \n"
			+"[7] Exit");
			//@formatter:on

			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("\nEnter value to append: ");
				int valueToAppend = scanner.nextInt();
				list.append(valueToAppend);
				break;
			case 2:
				System.out.print("\nEnter position to delete: ");
				int positionToDelete = scanner.nextInt();
				list.delete(positionToDelete);
				break;
			case 3:
				System.out.print("\nEnter position to change: ");
				int positionToChange = scanner.nextInt();

				System.out.print("Enter new value: ");
				int newValue = scanner.nextInt();
				list.changeValue(positionToChange, newValue);
				break;
			case 4:
				System.out.print("\nList: ");
				list.display();
				break;
			case 5:
				System.out.print("\nEnter position for node history: ");
				int positionForHistory = scanner.nextInt();
				list.nodeHistory(positionForHistory);
				break;
			case 6:
				System.out.print("\nList History:");
				list.listHistory();
				break;
			case 7:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}

	}
}