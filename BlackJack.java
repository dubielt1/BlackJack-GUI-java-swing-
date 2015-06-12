import java.util.Observable;



class BlackJack extends Observable {
	private Player player;
	private Dealer dealer;
	private Deck deck;
	
	BlackJack() {
		player = new Player();
		dealer = new Dealer();
		deck = new Deck();
		deal();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Dealer getDealer() {
		return dealer;
	}
	
	private void deal() {
		
		if (deck.deck.size() < 10)
			deck = new Deck();
		
		for (int i = 0; i < 2; i++) {
			int j = 0;
			player.hand.add(deck.deck.get(j));
			deck.deck.remove(j);
			dealer.hand.add(deck.deck.get(j));
			deck.deck.remove(j);
		}
		
		//check if dealer hit? or in stay()
	}
	
	void hit() {
		//run when button is clicked
		player.hand.add(deck.deck.get(0));
		deck.deck.remove(0);
		
		if (player.getScore() > 21)
			System.out.println("Player Busts");
		
		//check for bust here?
	}
	
	boolean isBust() {
		if (player.getScore() > 21)
			return true;
		
		return false;
				
	}
	
	void dealerHit() {
		while (dealer.getScore() < 17) { //could implement soft 17 rules for more difficulty
			dealer.hand.add(deck.deck.get(0));
			
			setChanged();
			notifyObservers();
			deck.deck.remove(0);
			
		}
		
		if (dealer.getScore() > 21)
			System.out.println("Dealer Bust, player wins");
	}
	
	boolean isWin() {
		
		if ((player.getScore() > dealer.getScore() && player.getScore() <= 21) || dealer.getScore() > 21)
			return true;
		
		return false;
	}
	
	void stay() {
		dealerHit();
		isWin();
	}
	
	//void split() { option to split cards; gotta look up rules
	//If first two cards dealt are same number, can split hand
	
}