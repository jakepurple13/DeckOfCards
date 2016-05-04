package deckofcards;

public class HandList {

	HandNode first;
	int size;

	public HandList() {
		first = null;
		size = 0;
	}

	public void insertInOrder(Card c) {
		HandNode previous, current;
		HandNode temp = new HandNode(c);
		boolean found = false;
		current = first;
		previous = null;
		Card key = c;
		while (!found && current != null) {

			if (key.compareTo(current.data) < 0)
				found = true;
			else {
				previous = current;
				current = current.right;
			}
		}
		temp.right = current;
		if (previous == null)
			first = temp;
		else
			previous.right = temp;

		size++;
	}

	public HandNode search(Card c) {

		HandNode trav = first;
		while (trav != null) {
			if (trav.data.equals(c)) {
				break;
			}
			trav = trav.right;
		}
		return trav;
	}

	public Card indexOf(int index) {
		int count;
		if (index > size) {
			count = size;
		} else {
			count = index;
		}
		HandNode trav = first;
		for (int i = 0; i < count; i++) {
			trav = trav.right;
		}
		return trav.data;
	}

	public HandNode delete(Card c) {
		HandNode current = first;
		HandNode previous = null;
		boolean found = false;

		while (!found && current != null) {

			if (current.data.equals(c))
				found = true;
			else {
				previous = current;
				current = current.right;
			}
		}
		if (previous == null && found == true) {
			first = first.right;
			size--;
		} else if (found == true) {
			previous.right = current.right;
			size--;
		} else {
			System.out.println(c + " never found");
		}

		return current;

	}

	public void insertAtBeginning(Card c) {
		HandNode newLink = new HandNode(c);
		newLink.right = first;
		first = newLink;
		size++;
	}

	public void insertAtEnd(Card c) {
		HandNode trav, temp;
		temp = new HandNode(c);
		temp.right = null;
		trav = first;
		if (trav == null)
			first = temp;
		else {
			while (trav.right != null) {
				trav = trav.right;
			}
			trav.right = temp;
		}
		size++;

	}
	
	public void clearAll() {
		first = null;
		size = 0;
	}

	public void sortBySuit() {
		HandList spades = new HandList();
		HandList clubs = new HandList();
		HandList diamonds = new HandList();
		HandList hearts = new HandList();
		int count = size;
		for (int i = 0; i < count; i++) {
			Card c = indexOf(i);
			if (c.isSuit(Suit.SPADES)) {
				spades.insertInOrder(c);
			} else if (c.isSuit(Suit.CLUBS)) {
				clubs.insertInOrder(c);
			} else if (c.isSuit(Suit.DIAMONDS)) {
				diamonds.insertInOrder(c);
			} else if (c.isSuit(Suit.HEARTS)) {
				hearts.insertInOrder(c);
			}
		}
		
		clearAll();
		
		sortBySuit(spades);
		sortBySuit(clubs);
		sortBySuit(diamonds);
		sortBySuit(hearts);

	}
	
	private void sortBySuit(HandList suits) {
		for(int i=suits.getSize()-1;i>=0;i--) {
			insertAtBeginning(suits.indexOf(i));
		}
	}

	public void sortByValue() {

		for (int i = 0; i < size; i++) {
			Card c = indexOf(i);
			delete(c);
			insertInOrder(c);
		}

	}

	public void printList() {
		HandNode trav = first;

		while (trav != null) {
			System.out.print(trav + "-->");
			trav = trav.right;
		}
		System.out.println();

	}
	
	public void printListRecursively() {
		printList(first);
	}
	
	private void printList(HandNode next) {
		HandNode trav = next;
		System.out.print(trav + "-->");
		if(trav.right!=null) {
			printList(trav.right);
		}
	}

	public int getSize() {
		return size;
	}

}
