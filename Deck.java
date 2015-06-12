import java.util.*;
import java.awt.image.BufferedImage;

class Deck {
	  ArrayList<Card> deck;
	 
	  public Deck () {
		  
		  try {
		  LoadImages im = new LoadImages();
		  
		  
		  BufferedImage[] crdimg = im.cards;
		  
				  this.deck = new ArrayList<Card>();
				  for (int a=0; a<13; a++)
				  {
					  //enum default values() method returns array of values
					  Value value = Value.values()[a];
	 
					  for (int b=0; b<4; b++)
					  {
						  //assigns images this way because it is how they are loaded
						  //allowed for minimal changes to Command line version code
						  Card card = new Card(value, Suit.values()[b], crdimg[(a*4)+b]);
						  this.deck.add(card);
					  }
				  }
				  Collections.shuffle(deck);
		  } catch(Exception e) {}	//I should actually handle the exception  
		    
	  }
}