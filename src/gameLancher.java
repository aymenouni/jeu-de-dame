
import java.awt.Color;

import java.awt.GridLayout;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;








public class gameLancher extends JFrame {
	private static Swath swath ; 
	private Menubar menu ; 
	 public static  JLabel b ; 
	 public static  JLabel b2 ;
	 public static  JTextArea b3 ;
	 public static  JTextArea b4 ;
	 
	 
	 public static void addpawn(int i) throws IOException  
	 {
		 if(i==1)
		 {
			 b2.add(new JLabel(new ImageIcon(ImageIO.read(new File("0010.png"))))) ;
			 b2.updateUI();
		 }
		 else
		 {
			 b.add(new JLabel(new ImageIcon(ImageIO.read(new File("0011.png"))))) ;
			 b.updateUI();
		 }
	 }
	 
	 
	
	
	public gameLancher() throws IOException 
	{
	//	gestion de laa fenetre principale
		 JLabel l = new JLabel(new ImageIcon(ImageIO.read(new File("3.jpg")))) ;
		
        
		 this.setLayout(new GridLayout(1,1));
		 this.add(l) ;
		this.setTitle("jeu de dame");
		this.setSize(1380, 768);
	    l.setLayout(null);
		
		
		this.setLocationRelativeTo(null);
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		swath = new Swath(9) ;
		l.add(swath);
		swath.setBounds(400, 50, 600, 600);
		menu = new Menubar(this) ;
 		this.setJMenuBar(menu);
 		
 		// gestion des label des pions
 		// label ou se trouve les pions blanc
 	     b = new  JLabel();
 	    b.setLayout(new GridLayout(3, 5));
 	    l.add(b);
 	    b.setBackground(Color.blue);
 	     b.setBounds(1020, 110, 180, 100);
 	     
 	     
 	     
 	
//label ou se trouve les pions noir
 	     b2 = new JLabel();
 	     l.add(b2);
 	     b2.setLayout(new GridLayout(3,5));
 	     b2.setBounds(1020, 330, 180, 100);
 	    //gestion des TextArea de l'historique de deplacement de pion
 	     // pour les pions noir
 	    b3 = new JTextArea();
 	   b3.setOpaque(false);
 	   b3.setBackground(new Color(0,0,0,64));

 	    JScrollPane list= new JScrollPane(b3);
 	
 	 	     
	     list.setOpaque(false); 
	     list.getViewport().setOpaque(false);list.setBorder(null);list.setViewportBorder(null);
	     l.add(list);
	    
	     list.setBounds(200, 80, 150, 150);
	     //pour les pions blanc
	     b4 = new JTextArea();
	     b4.setOpaque(false);
	     b4.setBackground(new Color(0,0,0,64));
	     JScrollPane list1= new JScrollPane(b4);
	     list1.setOpaque(false); 
	     list1.getViewport().setOpaque(false);list1.setBorder(null);list1.setViewportBorder(null);;
	     l.add(list1);
	    
	     list1.setBounds(200, 300, 150, 150);
	     
	  
	     
	     
 	    this.setVisible(true);
 	    
	}
	

	
	

	public static void main(String[] args) throws IOException {
		
		gameLancher f = new gameLancher() ; 
		
	
		
		
		
		
		
	
		
	
		
		
	}}
		  
	       
	        

		  
	       
	        

