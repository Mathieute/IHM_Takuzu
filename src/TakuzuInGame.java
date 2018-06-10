import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class TakuzuInGame extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//private JTextField val;
	private int taille;	
	private Takuzu.Grille grille;
	private String choixG;
	private ArrayList<JButton> listeBouton = new ArrayList<JButton>();
	
	public TakuzuInGame(int n) {
		
		super("Takuzu");
		this.taille = n;
		choixG = "Grilles/grille" + n + ".txt";
		this.grille = Takuzu.initialiser_grille(choixG); 
		this.initialise();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		//this.setSize((75*n),(75*n+50));
		
		this.setBounds(	TakuzuFenetre.getScreenWidth()/2-(75*n)/2,
				TakuzuFenetre.getScreenHeight()/2-(75*n+50)/2,75*n,75*n+50);
		
		this.setVisible(true);
	}
	
	
	public void initialise() {
		
		this.setLayout(new BorderLayout());

		
		//this.add(getPanelSouth(),BorderLayout.SOUTH);
		this.add(getPanelCenter(),BorderLayout.CENTER);
	}
	
	
	/*public JPanel getPanelSouth() {
		
		
	}*/
	
	
	public JPanel getPanelCenter() {
		
		ButtonListener listener = new ButtonListener ();
		
		JPanel panC = new JPanel(new GridLayout(this.taille,this.taille));
		
			for (int i=0; i<this.taille; i++)
			{
				for (int j=0; j<this.taille; j++)
				{
					if (!Takuzu.est_cellule_initiale(grille, i, j))
					{	
						JButton b = new JButton();
						b.addActionListener(listener);
						panC.add(b);
						b.setName(Integer.toString(i) + Integer.toString(j));
						listeBouton.add(b);

					}	
					else
						
						panC.add(new JLabel(Integer.toString(Takuzu.get_val_cellule(grille, i, j)),(int) CENTER_ALIGNMENT));
				}
				
			}
				
		return panC;
	}
	
	class ButtonListener implements ActionListener {							//INNER CLASS POUR LE LISTENER
		
		public void actionPerformed (ActionEvent e) {					
			
			JButton bouton = (JButton) e.getSource();
			String name = bouton.getName();
			
			int i = Integer.parseInt(name.substring(0,1));
			int j = Integer.parseInt(name.substring(1));

			//CHANGER VALEUR LORS DU CLIC
			
			if (Takuzu.get_val_cellule(grille, i, j) == 0)
			{
				Takuzu.set_val_cellule(grille, i, j, 1);
				bouton.setText("1");
			}
			else if (Takuzu.get_val_cellule(grille, i, j) == 1)
			{
				Takuzu.set_val_cellule(grille, i, j, -1);
				bouton.setText("");
			}
			else 
			{
				Takuzu.set_val_cellule(grille, i, j, 0);
				bouton.setText("0");
			}
			
			////////////////////////
			//CAS DE FIN DE PARTIE//
			////////////////////////
			
			//// TODO ////
			
			if (Takuzu.est_partie_gagnee(grille))
			{
				for (JButton b : listeBouton)
				b.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Partie gagnée !", "Fin de partie", JOptionPane.PLAIN_MESSAGE);
				new TakuzuFenetre();
				
				
				/*for (int x=0; x<(grille.n * i + j); x++)
				{
					for (int y=0; y<(grille.n * i + j); y++)
					{	
						;
					}
				}*/
			
			}
	
	}
	
	/*public static void main (String[] args) {
		
		new TakuzuInGame(4);
	*/	
	}
}
