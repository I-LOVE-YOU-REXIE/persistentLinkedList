package test5;

public class PersistentLinkedList {

	private static class Node {
		int value;
		Node next;
		Node previousValue; // For fat node (to store previous values)
		boolean isDeleted; // For tombstoning

		public Node(int value) {
			this.value = value;
			this.next = null;
			this.previousValue = null;
			this.isDeleted = false;
		}
	}

	private Node head;
	private Node tail;

	public PersistentLinkedList() {
		this.head = null;
		this.tail = null;
	}

	/*
	 * This method adds a node always after the end of the list by creating a tail
	 * pointer move it to the end of the list, and it stays there.
	 * 
	 */
	public void append(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			// newNode.previousValue = tail;
			tail = newNode;
		}
	}

	// 2. Delete operation (with tombstoning)

	public void delete(int position) {
		Node currentNode = head;
		for (int i = 0; i < position - 1; i++) {
			if (currentNode == null) {
				System.out.println("Position out of bounds.");
				return;
			}
			currentNode = currentNode.next;
		}

		currentNode.isDeleted = true;
		System.out.print("\nNode deleted.\n");
	}

	// 3. Change Value operation (with fat node)
	/*
	 * This method takes two parameters, the position and the value to be changed.
	 * This traverses the list using their index to identify the position.
	 * 
	 */
	public void changeValue(int position, int newValue) {
		Node currentNode = head;
		Node tempNode = currentNode;

		int deletedNodesCount = 0;

		for (int i = 0; i < position; i++) {
			System.out.println("test");
			if (tempNode.isDeleted) {
				++deletedNodesCount;
			}

			tempNode = tempNode.next;
		}

		for (int i = 1; i < position + deletedNodesCount; i++) {
			if (currentNode == null) {
				System.out.println("Position out of bounds.");
				return;
			}

			currentNode = currentNode.next;
		}

		if (currentNode != null) {
			// Store previous value(s)
			Node newPreviousValue = new Node(currentNode.value);

			newPreviousValue.next = currentNode.previousValue;

			currentNode.previousValue = newPreviousValue;

			currentNode.value = newValue;

			System.out.println("Node value changed.");
		} else {
			System.out.println("Position out of bounds.");
		}

	}

	// 4. Display operation
	public void display() {
		Node currentNode = head;
		while (currentNode != null) {
			if (!currentNode.isDeleted) {
				System.out.print(currentNode.value + " ");
			}
			currentNode = currentNode.next;
		}
		System.out.println("\n");
	}

	// 5. Node History operation
	public void nodeHistory(int position) {
		Node currentNode = head;
		for (int i = 1; i < position; i++) {
			if (currentNode == null) {
				System.out.println("Position out of bounds.");
				return;
			}
			currentNode = currentNode.next;
		}

		if (currentNode != null) {
			System.out.print("Current Value: " + currentNode.value);

			Node prevValueNode = currentNode.previousValue;
			while (prevValueNode != null) {
				System.out.print(" <---= " + prevValueNode.value);
				prevValueNode = prevValueNode.next;

			}
			System.out.println();

		} else {
			System.out.println("Position out of bounds.");
		}
	}

	// 6. List History operation
	public void listHistory() {
		Node currentNode = head;
		while (currentNode != null) {
			if (currentNode.isDeleted) {
				System.out.print("[" + currentNode.value + "] ");
			} else {
				System.out.print(currentNode.value + " ");
			}
			currentNode = currentNode.next;
		}
		System.out.println();
	}

}
