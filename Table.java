import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

@SuppressWarnings("serial")
class Table extends JPanel {
	
	private JPanel topPanel = new JPanel();
	private JPanel dcardPanel = new JPanel();
	private JPanel pcardPanel = new JPanel();
	
	private JButton start = new JButton("Start");
	private JButton hit = new JButton("HIT");
	private JButton stay = new JButton("STAY");
	
	private JLabel dealerlabel = new JLabel();
	private JLabel playerlabel = new JLabel();
	
	//private LayoutManager overlay = new OverlayLayout(pcardPanel);
	
	private float alignmentX = 0.0f;
	private float alignmentY = 0.0f;
	
	
	Table() {
		topPanel.setBackground(new Color(0, 122, 0));
	    dcardPanel.setBackground(new Color(0, 122, 0));
	    pcardPanel.setBackground(new Color(0, 122, 0));
	    
	    //topPanel.setLayout(new FlowLayout());
	    
	    dealerlabel.setText("  Dealer:  ");
	    playerlabel.setText("  Player:  ");
	    
	    add (dcardPanel);
	    add (pcardPanel);
	    add (topPanel);
	    
	    topPanel.add(start);
	    
	    //setLayout(new BorderLayout());
	    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	    //pcardPanel.setLayout(overlay);
	    
	    
	    add(dcardPanel);
	    add(pcardPanel);
	    add(topPanel);
	    //Have a split button setEnabled(false)
	    //on a split add a new panel with options hit left and hit right
	    //then apply overlay to pcardPanel, and utilize the alignment vars, accordingly
	    //then stack hits in columns on according card
	    
	}
	
	void addHitListener(ActionListener HitListener) {
		hit.addActionListener(HitListener);
	}
	
	void addStartListener(ActionListener StartListener) {
		start.addActionListener(StartListener);
	}
	
	void addStayListener(ActionListener StayListener) {
		stay.addActionListener(StayListener);
	}
	
	void display() {
		JFrame myFrame = new JFrame("BlackJack");
	    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    myFrame.setContentPane(this);
	    myFrame.setPreferredSize(new Dimension(700,550));

	    myFrame.pack();
	    myFrame.setVisible(true);
	}
	
	void addCards(Player p, Dealer d) {
		topPanel.remove(start);
		
		pcardPanel.add(playerlabel);
	    dcardPanel.add(dealerlabel);		
	    
		for (Card c : p.hand) {
			ImageIcon cc = new ImageIcon(c.img);
			JLabel cC = new JLabel(cc);
			
			//cC.setAlignmentX(alignmentX); use to get X alignment of card 1 & 2 for splits
			//cC.setAlignmentY(alignmentY); same for Y, then increment by .3f
			
			pcardPanel.add(cC);
			
			
		}
		
		for (Card c : d.hand)
			dcardPanel.add(new JLabel(new ImageIcon(c.img))); //maybe add 'lastcard drawn' variable
															  //to solve dealer hit issues
		topPanel.add(new JLabel("Options: "));
		topPanel.add(hit);								//Or have duplicate hand instances for Table class**
		topPanel.add(stay);								//Because implementing Splits will be tough
		
		validate();
		repaint();
	}
	
	void endGame(boolean isWin) {
		
		removeAll();
		setBackground(new Color(0, 122, 0));
		
		if (isWin == true)
			add(new JLabel("You won!"));
		else
			add(new JLabel("You Lost"));
		
		validate();
		repaint();
	}
	
	//have hitPlayer and hitDealer methods for table class
	//Call on every hit
	public void hitPlayer(Player p) {
		JLabel hits = new JLabel(new ImageIcon(p.hand.get(p.hand.size()-1).img));
		//hits.setAlignmentY(alignmentY);
		
		pcardPanel.add(hits);
		
		validate();
		repaint();
	}
	
	public void hitDealer(Dealer d) {
		dcardPanel.add(new JLabel(new ImageIcon(d.hand.get(d.hand.size()-1).img)));
		validate();
		repaint();
	}

}