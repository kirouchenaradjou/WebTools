package excercise2_stack;

public class TryDeal {
	public static void main(String[] args) {    CardDeck deck = new CardDeck();

	deck.shuffle();

	Hand hand1 = deck.dealHand(13).sort();
	Hand hand2 = deck.dealHand(13).sort();
	Hand hand3 = deck.dealHand(13).sort();
	Hand hand4 = deck.dealHand(13).sort();
	System.out.println("\nHand 1 is "+hand1);
	System.out.println("\nHand 2 is "+hand2);
	System.out.println("\nHand 3 is "+hand3);
	System.out.println("\nHand 4 is "+hand4);

	}
}
