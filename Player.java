import java.util.ArrayList;

class Player {
	ArrayList<Card> hand = new ArrayList<Card>();
	//Add a boolean soft hand variable? To handle the Ace condition?
	
	int getScore() {
		int sum = 0;
		for (Card c : hand)
			sum += c.getCardValue();
		
		return sum;
	}
	
}
