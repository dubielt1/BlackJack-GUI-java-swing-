import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;


import javax.swing.Timer;


public class Controller implements Observer {
	
	BlackJack game;
	Table t;
	
	Controller(BlackJack game, Table t) {
		this.game = game;
		this.t = t;
		
		this.game.addObserver(this);
		this.t.addHitListener(new HitListener());
		this.t.addStartListener(new StartListener());
		this.t.addStayListener(new StayListener());
		
		//t.display();
	}
	
	public void go() {
		t.display();
	}
	
	public void update(Observable obj, Object observed) {
		
		t.hitDealer(game.getDealer());
		
	}
	
	class HitListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			game.hit();
			
			
			
			Timer timer = new Timer(2500, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (game.isBust() == true) 
						t.endGame(false);
				}
			});
			
			
			timer.setRepeats(false);
			timer.start();
			t.hitPlayer(game.getPlayer());
			
		}
	}
	
	class StartListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			t.addCards(game.getPlayer(), game.getDealer());
		}
	}
	
	class StayListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			game.stay();
			
			Timer timer = new Timer(2500, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (game.isWin() == true)
						t.endGame(true);
					else
						t.endGame(false);
				}
			});
			
			timer.setRepeats(false);
			timer.start();
		}
		
	}
	
	class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if (game.isBust() == true) {
				t.endGame(false);
			}
			
			
		}
	}
	
	/*private void doHit() {
		game.hit();
	}
	
	private void dealerHit() {
		t.hitDealer(game.getDealer());
	}
	
	private void doStay() {
		game.stay();
		//
	}
	
	private void drawHit() {
		t.hitPlayer(game.getPlayer());
	}*/
	
}
