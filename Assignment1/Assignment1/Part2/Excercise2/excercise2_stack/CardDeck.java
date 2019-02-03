package excercise2_stack;

import java.util.Stack;
import java.util.Collections;
public class CardDeck {
    String[] rankValues = { "1","2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

	public CardDeck() {
		for (Suit suit : Suit.values())
			for (String rank : rankValues)
				deck.push(new Card(rank, suit));
	}
	public Hand dealHand(int numCards) {
			 if(deck.size() < numCards) {      
				 System.err.println("Not enough cards left in the deck!");   
				 System.exit(1);    }   
			 Hand hand = new Hand();   
			 for(int i = 0 ; i < numCards ; ++i) {     
				 hand.add(deck.pop());   
				 }    return hand; 
				 }
	
	 public void shuffle() {    Collections.shuffle(deck);  }
	 

	private Stack<Card> deck = new Stack<>();
}
