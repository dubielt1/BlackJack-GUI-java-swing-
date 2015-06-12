import java.awt.image.BufferedImage;

public class Card {
	  private final Suit suit;
	  private final Value cardValue;
	  final BufferedImage img; 			//add a get Image, maybe
	 
	  Card (Value cardValue, Suit suit, BufferedImage img)
	  {
	    this.cardValue = cardValue;
	    this.suit = suit;
	    this.img = img;
	  }
	 
	  public Suit getSuit()
	  {
	    return suit;
	  }
	 
	  public int getCardValue() //change to int return cardValue.getValue()
	  {
	    return cardValue.getValue();
	  }
	  
	}
