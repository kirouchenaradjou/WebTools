package excercise2_stack;

public class Card implements Comparable<Card> {
	public Card(String rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	@Override
	public String toString() {
		return rank + "" + suit;
	}

	private Suit suit;
	private String rank;

	@Override
	public int compareTo(Card card) {
		if (suit.equals(card.suit)) {
			if (rank.equals(card.rank)) {
				return 0;
			}
			return rank.compareTo(card.rank) < 0 ? -1 : 1;
		} else {
			return suit.compareTo(card.suit) < 0 ? -1 : 1;
		}
	}
}
