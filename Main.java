
public class Main{
	
	public static void main(String[] args) {
		BlackJack game = new BlackJack();
		Table t = new Table();
		Controller c = new Controller(game, t);
		c.go();
	}

}
