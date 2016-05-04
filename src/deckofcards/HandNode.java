package deckofcards;

public class HandNode {
		
		public Card data;
		public HandNode right;

		public HandNode() {
			data = null;
			right = null;
		}
		
		public HandNode(Card data) {
			this.data = data;
			right = null;
		}
		
		public HandNode(Card data, HandNode right) {
			this.data = data;
			this.right = right;
		}
		
		@Override
		public String toString() {
			return data.toString();
		}
}
