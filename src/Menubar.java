import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.UIManager;

import javax.swing.plaf.FontUIResource;

public class Menubar extends JMenuBar implements ActionListener {
	private gameLancher swath;
	
	JMenuItem nouveau ; 
	JMenuItem aide ;
	JMenuItem about ;
	JMenuItem exit ;
	
	
	public Menubar(gameLancher x ) {
              swath =x;
	  
		
		try {
			// parametrage de la police de jeux
			UIManager.put("TextArea.font",new Font("Freestyle Script",Font.PLAIN,28));
		      UIManager.put("*.font",new Font("Freestyle Script",Font.PLAIN,28));
		      UIManager.put("Menu.font",new Font("Freestyle Script",Font.PLAIN,25));
		      UIManager.put("MenuItem.font",new Font("Freestyle Script",Font.PLAIN,25));
		
		      UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
			            "Freestyle Script", Font.PLAIN, 25))); 
		      
		    }
		    catch(Exception e) {
		      e.printStackTrace();
		    }
	  
		   //creation de deux menu  
		    JMenu game = new JMenu(" game    ");
		    JMenu info = new JMenu(" info     ");
		   
		    nouveau = new JMenuItem("new game", 'N');//creation d'un menuItem
		    nouveau.addActionListener(this) ; //affecter l'actionPerformed(ActionEvent e) au menuItem new game 
			
				
		
		    game.add(nouveau);//ajouter le menuItem au 1er menu
		    
		    aide = new JMenuItem("aide      ", 'z');//creation d'un menuItem
		    aide.addActionListener(new ActionListener()// ajouter un action au menuItem  
					{
						public void actionPerformed(ActionEvent e)
						{	 
						
					
							JOptionPane.showMessageDialog(null,"1.Le jeu de dames international se joue sur un damier carr� divis� en 81 cases �gales, alternativement claires et fonc�es.\n "
									+ "2.Le jeu se joue sur les cases fonc�es du damier. Il y a donc 41 cases actives. La plus longue diagonale, \n    joignant deux coins du damier et comprenant 11 cases fonc�es, se d�nomme la grande diagonale.\n"
									+ "3.Il existe deux types de pi�ces : les pions et les dames.\n"
									+ "4.Le premier coup est toujours jou� par les blancs. Les adversaires jouent un coup chacun � tour de r�le avec leurs pi�ces.\r\n" 
									+ "5.Un pion se d�place obligatoirement vers l�avant, en diagonale, d�une case sur une case libre de la rang�e suivante \n"
									+ "6.Lorsqu'il atteint la derni�re rang�e, le pion devient dame.\n"
									+ "7.Une dame se d�place obligatoirement vers l�arriere, en diagonale, d�une case sur une case libre de la rang�e suivante.\n"
									+ "8.Lorsqu�un pion se trouve en pr�sence, diagonalement, d�une pi�ce adverse derri�re laquelle se trouve une case libre, \n   il doit obligatoirement sauter par-dessus cette pi�ce et occuper la case libre.\n"
									+ "9.Cette pi�ce adverse est alors enlev�e du damier. Cette op�ration compl�te est la prise par un pion.\n"
									+ "10.La fin de partie est consid�r�e s'il une disparition totale des pion de l'un de deux adversaire. \n"
									+ "","aide",JOptionPane.PLAIN_MESSAGE);
				  
				   			}
					});
		    info.add(aide);//ajouter le menuItem au 2eme menu
		    
		     exit = new JMenuItem("exit");
		    exit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					  System.exit(0); 
				}
			});
		    
		    game.add(exit);
		    
		
		    about = new JMenuItem("about");
		    about.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{	 
				
			
					JOptionPane.showMessageDialog(null,"D�velopp� par aymen oni et hadi aminne chaabeni ","About",JOptionPane.PLAIN_MESSAGE); 
		  
		   			}
			});
		    info.add(about);
		  
		    add(game);  
		    add(info);
		  
	}



	@Override
	public void actionPerformed(ActionEvent e) {//action correspont au menuItem nouveau 
		gameLancher g ; 
		if (e.getSource() == nouveau )
		{
			swath.dispose();
			 try {
				g = new gameLancher() ;
				swath = g ;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}


	
	}


