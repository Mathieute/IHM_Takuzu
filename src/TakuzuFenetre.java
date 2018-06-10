import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;




public class TakuzuFenetre extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JButton jouer4;
	private JButton jouer6;
	private JButton jouer8;
	private JLabel jl;
	
	public TakuzuFenetre () {
		
		super("Takuzu Launcher");
		//this.setSize(230,90);
		this.initialise();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setBounds(	getScreenWidth()/2-230/2,
						getScreenHeight()/2-90/2,230,90);
		
		this.setVisible(true);

		
	}
	
	
	
	public void initialise () {
		
		this.setLayout(new BorderLayout());
		
		this.add(getPanelNorth(),BorderLayout.NORTH);
		this.add(getPanelSouth(),BorderLayout.SOUTH);
		
	}
	

	
	public JPanel getPanelNorth() {
		
		this.jl = new JLabel ("Taille de la grille :", SwingConstants.CENTER);
		JPanel panN = new JPanel();
		
		panN.add(this.jl);
		
		return panN;
	}
	
	public JPanel getPanelSouth() {
		
		JPanel panButtons = new JPanel (new FlowLayout());
		this.jouer4 = new JButton ("4x4");
		this.jouer6 = new JButton ("6x6");
		this.jouer8 = new JButton ("8x8");
		
		panButtons.add(this.jouer4);
		panButtons.add(this.jouer6);
		panButtons.add(this.jouer8);
		
		ButtonLis listener = new ButtonLis ();
		
		this.jouer4.addActionListener(listener);
		this.jouer6.addActionListener(listener);
		this.jouer8.addActionListener(listener);
		
		return panButtons;

	}
	
	class ButtonLis implements ActionListener {							//INNER CLASS POUR LE LISTENER
		
		public void actionPerformed (ActionEvent e) {
			
			if(e.getSource() == jouer4)									
			{	
				new TakuzuInGame(4);
			}	
			else if (e.getSource () == jouer6)														
			{
				new TakuzuInGame(6);
			}
			else
			{
				//choixG = "Grilles/grille8.txt";
				new TakuzuInGame(8);
			}
			
		}
		
	}
	
	
	
	//METHODES POUR GET LA TAILLE DE L'ECRAN
	public static int getScreenWidth()
	{
		return Toolkit.getDefaultToolkit().getScreenSize().width;
	}
	
	public static int getScreenHeight()
	{
		return Toolkit.getDefaultToolkit().getScreenSize().height;
	}
	
	
	
	public static void main (String[] args) {
		
		new TakuzuFenetre();
		
	}

	

}
