package test5;

class Node {

	private int value;
	private Node next;
	private boolean tombstone;
	private int[] valueHistory;
	private int historyIndex;

	public Node(int value, int historySize) {
		this.setValue(value);
		this.setNext(null);
		this.setTombstone(false);
		this.valueHistory = new int[historySize];
		this.valueHistory[0] = value; // Store initial value
		this.historyIndex = 0;
	}

	// Method to add a new value to the history
	public void addToHistory(int newValue) {
		historyIndex++;
		valueHistory[historyIndex] = newValue;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public boolean isTombstone() {
		return tombstone;
	}

	public void setTombstone(boolean tombstone) {
		this.tombstone = tombstone;
	}
}